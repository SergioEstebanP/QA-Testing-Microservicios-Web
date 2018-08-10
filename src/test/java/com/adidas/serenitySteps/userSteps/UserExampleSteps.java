package com.adidas.serenitySteps.userSteps;

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

public class UserExampleSteps {
    private ServicesSupport servicesSupport = new ServicesSupport();
    private RequestSpecification spec = rest().baseUri(ServicesConfiguration.URI).contentType(ContentType.JSON).when();

    private String getEndPoint() {
        return endpoint;
    }

    private String endpoint = ServicesConfiguration.USER;

    @Step
    public void createUser(String operation) {
        try {
            InputStream is = this.getClass().getResourceAsStream("/requests/create_user.json");
            JSONObject body = servicesSupport.jsonInputStreamToJsonObject(is);
            spec = spec.body(body.toMap());
            Response response = servicesSupport.executeRequest(spec, operation.toUpperCase(), getEndPoint());
            Serenity.setSessionVariable("response").to(response);
        } catch (Exception e) {
            System.out.println(e);
        }
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

    @Step
    public void loginUser(String operation, String user, String passwd) {
        endpoint = getEndPoint() + "/login?username=" + user + "&password=" + passwd;
        Response response = servicesSupport.executeRequest(spec, operation.toUpperCase(), getEndPoint());
        Serenity.setSessionVariable("response").to(response);
    }

    @Step
    public void logoutUser(String operation) {
        endpoint = getEndPoint() + "/logout";
        Response response = servicesSupport.executeRequest(spec, operation.toUpperCase(), getEndPoint());
        Serenity.setSessionVariable("response").to(response);
    }

    @Step
    public void getByName(String operation, String name) {
        endpoint = getEndPoint() + "/" + name;
        Response response = servicesSupport.executeRequest(spec, operation.toUpperCase(), getEndPoint());
        Serenity.setSessionVariable("response").to(response);
    }

    @Step
    public void updateUser(String operation, String name) {
        try {
            endpoint = getEndPoint() + "/" + name;
            InputStream is = this.getClass().getResourceAsStream("/requests/updateUser.json");
            JSONObject body = servicesSupport.jsonInputStreamToJsonObject(is);
            spec = spec.body(body.toMap());
            Response response = servicesSupport.executeRequest(spec, operation.toUpperCase(), getEndPoint());
            Serenity.setSessionVariable("response").to(response);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Step
    public void deleteByName(String operation, String name) {
        endpoint = getEndPoint() + "/" + name;
        Response response = servicesSupport.executeRequest(spec, operation.toUpperCase(), getEndPoint());
        Serenity.setSessionVariable("response").to(response);
    }

    @Step
    public void createUserList(String operation) {
        try {
            endpoint = getEndPoint() + "/createWithArray";
            InputStream is = this.getClass().getResourceAsStream("/requests/createUserList.json");
            JSONObject body = servicesSupport.jsonInputStreamToJsonObject(is);
            spec = spec.body(body.toMap());
            Response response = servicesSupport.executeRequest(spec, operation.toUpperCase(), getEndPoint());
            Serenity.setSessionVariable("response").to(response);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
