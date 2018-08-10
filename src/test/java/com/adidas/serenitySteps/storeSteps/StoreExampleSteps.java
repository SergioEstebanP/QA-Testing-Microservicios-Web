package com.adidas.serenitySteps.storeSteps;

import com.adidas.config.ServicesConfiguration;
import com.adidas.support.ServicesSupport;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.rest;

public class StoreExampleSteps {

    private ServicesSupport servicesSupport = new ServicesSupport();
    private RequestSpecification spec = rest().baseUri(ServicesConfiguration.URI).contentType(ContentType.JSON).when();

    private String getEndPoint() {
        return endpoint;
    }

    private String endpoint = ServicesConfiguration.STORE;

    @Step
    public void getInfoOfStore (String operation) {
        endpoint = getEndPoint() + "/" + "inventory";
        Response response = servicesSupport.executeRequest(spec, operation.toUpperCase(), endpoint);
        Serenity.setSessionVariable("response").to(response);
    }


    @Step
    public void checkStatusCode(int statusCode) {
        Response res = Serenity.sessionVariableCalled("response");
        Assert.assertEquals("The status code is incorrect, something in the operation went wrong", statusCode, res.getStatusCode());
    }

    @Step
    public void verifyResultsOperation(Response response, String key, String operation, String value) {
        String responseValue;

        switch (operation.toLowerCase()) {
            case "get":
                responseValue = response.getBody().jsonPath().getString(key);
                Assert.assertTrue("The current value of the response doesn't match with the expected one", responseValue.contains(value));
                break;
        }
    }
}