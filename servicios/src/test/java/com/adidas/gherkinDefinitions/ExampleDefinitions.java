package com.adidas.gherkinDefinitions;

import com.adidas.influxdb.InfluxDBIntegration;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.adidas.serenitySteps.ExampleSteps;

import java.awt.*;
import java.util.Calendar;

public class ExampleDefinitions {

    /**
     * Method executed before each scenario to start measuring execution times
     *
     * @param scenario Scenario object to check if the scenario contains the tag to write on InfluxDB
     */
    @Before
    public void startInfluxdb(Scenario scenario) {
        if (scenario.getSourceTagNames().contains("@influxdb"))
            Serenity.setSessionVariable("startTime").to(Calendar.getInstance());
    }

    @Steps
    private ExampleSteps exampleSteps;

    @When("^I request to (get|update|delete) a pet by ID \"([^\"]*)\"$")
    public void iRequestOperPetByID(String operation, String id) {
        switch (operation.toLowerCase()) {
            case "get":
                exampleSteps.getPetById(id);
                break;
            case "update":
                exampleSteps.updateUserById(id);
                break;
            case "delete":
                exampleSteps.deleteUserById(id);
                break;
            default:
                break;
        }
    }

    @When("I request to create a user")
    public void iRequestToCreateNewUser() {
        exampleSteps.createUser();
    }

    @Then("I should get (.*) status code")
    public void iShouldGetStatusCode(int expectedStatusCode) {
        exampleSteps.verifyStatusCode(expectedStatusCode);
    }

    @And("^The value for the \"([^\"]*)\" after (get|post|update|delete) operation should be \"([^\"]*)\"$")
    public void theValueForTheAfterGetOperationShouldBe(String key, String operation, String expectedValue) {
        Response res = Serenity.sessionVariableCalled("response");
        exampleSteps.verifyValueFromKey(res, operation, key, expectedValue);
    }

    /**
     * Method executed after each scenario to write execution times on InfluxDB
     *
     * @param scenario Scenario object to write different attributes in DB
     */
    @After
    public void measureScenario(Scenario scenario) throws AWTException {

        if (scenario.getSourceTagNames().contains("@influxdb")) {
            InfluxDBIntegration bd = InfluxDBIntegration.getInstance();
            Calendar startTime = Serenity.sessionVariableCalled("startTime");
            Serenity.setSessionVariable("endTime").to(Calendar.getInstance());
            Calendar endTime = Serenity.sessionVariableCalled("endTime");
            bd.writeInfluxDB(scenario, startTime, endTime);
        }

    }
}
