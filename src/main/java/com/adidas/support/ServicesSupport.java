package com.adidas.support;

import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import java.io.InputStream;

public class ServicesSupport{

    /**
     * Converts an Input Stream to a JSON object
     * @param is Input Stream to be converted (a JSON file in the project)
     * @return JSON object
     * */
    public JSONObject jsonInputStreamToJsonObject(InputStream is) throws Exception {
        
        JSONObject json;
        String jsonTxt = IOUtils.toString(is, "UTF-8");
        json = new JSONObject(jsonTxt);
        return json;
    }

    /**
     * Executes a request depending on the method received by parameter
     * @param spec Request specification
     * @param method One of the next values: get, post, put or delete
     * @param endpoint Endpoint of the service
     * @return response object with attributes like status code or response body
     * */
    public Response executeRequest(RequestSpecification spec, String method, String endpoint) {
        Response response;

        switch (method.toUpperCase()) {
            case "GET":
                response = spec.get(endpoint);
                break;
            case "POST":
                response = spec.post(endpoint);
                break;
            case "DELETE":
                response = spec.delete(endpoint);
                break;
            case "PUT":
                response = spec.put(endpoint);
                break;
            default:
                response = spec.get(endpoint);
                break;
        }
        return response;
    }

}