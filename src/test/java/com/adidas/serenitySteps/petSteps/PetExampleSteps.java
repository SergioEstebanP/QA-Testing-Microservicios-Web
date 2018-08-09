package com.adidas.serenitySteps.petSteps;

import com.adidas.config.ServicesConfiguration;
import com.adidas.support.ServicesSupport;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import org.junit.Assert;

import java.io.InputStream;

import static net.serenitybdd.rest.SerenityRest.rest;

public class PetExampleSteps {

    private ServicesSupport servicesSupport = new ServicesSupport();
    private RequestSpecification spec = rest().baseUri(ServicesConfiguration.URI).contentType(ContentType.JSON).when();

    private String getEndPoint() {
        return endpoint;
    }

    private String endpoint = ServicesConfiguration.PET;

    /**
     * Performs a POST operation with the given pet in json file, and it will create a new pet in the store
     */
    @Step
    public void postNewPetOnStore() {
        try {
            InputStream is = this.getClass().getResourceAsStream("/requests/postPet.json");
            JSONObject body = servicesSupport.jsonInputStreamToJsonObject(is);
            spec = spec.body(body.toMap());
            Response response = servicesSupport.executeRequest(spec, "POST", getEndPoint());
            Serenity.setSessionVariable("response").to(response);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Method to verify if the status code returned by the operation is which it should be
     *
     * @param statusCode integer with the status code with the result of the performed operation
     */
    @Step
    public void verifyStatusCode (int statusCode) {
        Response res = Serenity.sessionVariableCalled("response");
        Assert.assertEquals("The status code is incorrect, something in the operation went wrong", statusCode, res.getStatusCode());
    }

    /**
     * Method to verify if the results of the operation are corrects. It compares what should be and what there is in the response.
     *
     * @param identifier String which represents the identifier of the JSON body
     * @param value String which represents the value of the JSON identifier.
     */
    @Step
    public void checkValueFromResponse (Response response, String operation, String identifier, String value) {
        String responseValue = null;

        switch (operation.toLowerCase()) {
            case "post":
                responseValue = response.getBody().jsonPath().getString(identifier);
                break;
        }

        Assert.assertEquals("The current value of the response doesn't match with the expected one", value, responseValue);
    }
}
