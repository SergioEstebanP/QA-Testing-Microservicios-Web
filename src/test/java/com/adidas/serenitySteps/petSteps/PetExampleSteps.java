package com.adidas.serenitySteps.petSteps;

import com.adidas.support.ServicesSupport;
import cucumber.api.DataTable;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.Map;

public class PetExampleSteps {

    public RequestSpecification requestSpecification = RestAssured.given();
    public Response response;
    public String ENDPOINT;
    public String OPERATION;

    public void setBaseUrl() {
        requestSpecification.baseUri(ServicesSupport.BASE_PET_STORE_PATH);
    }

    public void setEndpoint(String endpoint) {
        ENDPOINT = endpoint;
    }

    public void setHeaderToValue(String headerName, String headerValue) {
        requestSpecification.header(headerName, headerValue);
    }

    public void setHeaderBulk(DataTable headers) {
        Map<String, String> headersMap = headers.asMap(String.class, String.class);
        for (String headerName : headersMap.keySet()) {
            requestSpecification.header(headerName, headersMap.get(headerName));
        }
    }

    public void setRequestOperation(String operation) {
        OPERATION = operation;
    }

    public void executeRequest() {
        response = ServicesSupport.executeRequest(requestSpecification, OPERATION, ENDPOINT);
    }

    public void checkStatusCode(int statusCode) {
        int responseStatusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, responseStatusCode);
    }

    public void checkJsonPathValue(String jsonPath, String value) {
        String responseValue = response.jsonPath().getString(jsonPath);
        Assert.assertEquals(value, responseValue);
    }

}
