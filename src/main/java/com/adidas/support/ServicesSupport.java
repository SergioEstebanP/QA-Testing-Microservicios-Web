package com.adidas.support;

import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ServicesSupport{
    public static final String BASE_PET_STORE_PATH = "https://petstore.swagger.io/v2";
    public static Properties dataProperties;
    public static String TOKEN;

    static {
        try {
            dataProperties.load(new FileInputStream("src/main/java/com/adidas/support/data.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        TOKEN = dataProperties.getProperty("REQUEST_TOKEN");
    }

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