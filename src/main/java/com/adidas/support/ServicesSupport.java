package com.adidas.support;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ServicesSupport{
    public static final String BASE_PET_STORE_PATH = "https://petstore.swagger.io/v2";

    public static Response executeRequest(RequestSpecification requestSpecification, String operation, String endpoint) {
        Response response;
        switch (operation.toLowerCase()) {
            case ("GET"):
                response = requestSpecification.get(endpoint);
                break;
            case ("POST"):
                response = requestSpecification.post(endpoint);
                break;
            case ("PUT"):
                response = requestSpecification.put(endpoint);
                break;
            case ("DELETE"):
                response = requestSpecification.delete(endpoint);
                break;
            case ("PATCH"):
                response = requestSpecification.patch(endpoint);
                break;
            default:
                response = requestSpecification.get(endpoint);
                break;
        }
        return response;
    }
}