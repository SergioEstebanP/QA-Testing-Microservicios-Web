package com.adidas.serenitySteps.petSteps;

import com.adidas.support.ServicesSupport;
import cucumber.api.DataTable;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.serenitybdd.rest.SerenityRest.rest;

public class PetExampleSteps {

    public RequestSpecification requestSpecification = rest();
    public Response response;
    public String ENDPOINT;
    public String OPERATION;

    public void setBaseUrl() {
        requestSpecification.baseUri(ServicesSupport.BASE_PET_STORE_PATH);
    }

    public void setBody(String requestBody) {
        requestSpecification.body(requestBody);
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

    public void checkValidId(String jsonPath) {
        int responseId = response.jsonPath().getInt(jsonPath);
        Pattern pattern = Pattern.compile("\\d");
        Matcher match = pattern.matcher(String.valueOf(responseId));
        Assert.assertTrue(match.lookingAt());
    }

    public void checkJsonPathValue(String jsonPath, String value) {
        String responseValue = response.jsonPath().getString(jsonPath);
        Assert.assertEquals(value, responseValue);
    }

    public void setToken(String tokenName, String value) {
        if ("valid_token".equals(value)) {
            requestSpecification.header(tokenName, ServicesSupport.TOKEN);
        } else {
            requestSpecification.header(tokenName, value);
        }
    }
}
