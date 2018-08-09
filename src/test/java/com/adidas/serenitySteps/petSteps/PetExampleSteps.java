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
     *
     * @param operation String with the specified operation in cucumber
     */
    @Step
    public void postNewPetOnStore(String operation) {
        try {
            InputStream is = this.getClass().getResourceAsStream("/requests/postPet.json");
            JSONObject body = servicesSupport.jsonInputStreamToJsonObject(is);
            spec = spec.body(body.toMap());
            Response response = servicesSupport.executeRequest(spec, operation.toUpperCase(), getEndPoint());
            Serenity.setSessionVariable("response").to(response);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Performs a PUT operation with the given pet in json file, and it will update the information on the server store
     *
     * @param operation String with the specified operation in cucumber
     */
    @Step
    public void putNewInfoOnStore(String operation) {
        try {
            InputStream is = this.getClass().getResourceAsStream("/requests/putPet.json");
            JSONObject body = servicesSupport.jsonInputStreamToJsonObject(is);
            spec = spec.body(body.toMap());
            Response response = servicesSupport.executeRequest(spec, operation.toUpperCase(), getEndPoint());
            Serenity.setSessionVariable("response").to(response);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Performs a GET operation into the server retrieving some information off it.
     *
     * @param operation String with the specified operation in cucumber
     */
    @Step
    public void getInfoOfStore (String operation) {
        endpoint = getEndPoint() + "/findByStatus?status=available";
        Response response = servicesSupport.executeRequest(spec, operation.toUpperCase(), endpoint);
        Serenity.setSessionVariable("response").to(response);
    }

    /**
     * Method to verify if the status code returned by the operation is which it should be
     *
     * @param statusCode integer with the status code with the result of the performed operation
     */
    @Step
    public void verifyStatusCode(int statusCode) {
        Response res = Serenity.sessionVariableCalled("response");
        Assert.assertEquals("The status code is incorrect, something in the operation went wrong", statusCode, res.getStatusCode());
    }

    /**
     * Performs a GET operation into the server to retrieving some pet information filtered by its id
     *
     * @param operation String with the specified operation in cucumber
     * @param id Integer which represents the pet's id in the server
     */
    @Step
    public void getPetById(String operation, int id) {
        endpoint = getEndPoint() + "/" + Integer.toString(id);
        Response response = servicesSupport.executeRequest(spec, operation.toUpperCase(), endpoint);
        Serenity.setSessionVariable("response").to(response);
    }

    /**
     * Method to verify if the results of the operation are corrects. It compares what should be and what there is in the response.
     *
     * @param identifier String which represents the identifier of the JSON body
     * @param value      String which represents the value of the JSON identifier.
     */
    @Step
    public void checkValueFromResponse(Response response, String operation, String identifier, String value) {
        String responseValue = null;

        switch (operation.toLowerCase()) {
            case "post":
                responseValue = response.getBody().jsonPath().getString(identifier);
                Assert.assertEquals("The current value of the response doesn't match with the expected one", value, responseValue);
                break;
            case "get":
                responseValue = response.getBody().jsonPath().getString(identifier);
                Assert.assertTrue("The current value of the response doesn't match with the expected one", responseValue.contains(value));
                break;
        }
    }

    /**
     * Method to delete a pet from the server filtered by its id.
     *
     * @param operation String with the specified operation in cucumber
     * @param id Integer which represents the pet's id in the server
     */
    public void deletePetById(String operation, int id) {
        endpoint = getEndPoint() + "/" + Integer.toString(id);
        Response response = servicesSupport.executeRequest(spec, operation.toUpperCase(), endpoint);
        Serenity.setSessionVariable("response").to(response);
    }
}
