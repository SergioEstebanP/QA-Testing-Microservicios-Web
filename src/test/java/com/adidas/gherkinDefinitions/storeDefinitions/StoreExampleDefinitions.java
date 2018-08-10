package com.adidas.gherkinDefinitions.storeDefinitions;


import com.adidas.influxdb.InfluxDBIntegration;
import com.adidas.serenitySteps.storeSteps.StoreExampleSteps;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

import java.util.Calendar;

public class StoreExampleDefinitions {

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

    @When("^I request to do '(.*)' operation against the petStore store service$")
    public void iRequestToDoOperationOperationAgainstThePetStoreStoreService(String operation) {
        switch (operation) {
            case ("get"):
                StoreExampleSteps.getInfoOfStore(operation);
                break;
        }
    }

    @Steps
    private StoreExampleSteps StoreExampleSteps;

    /**
     * Method executed after each scenario to write execution times on InfluxDB
     *
     * @param scenario Scenario object to write different attributes in DB
     */
    @After
    public void measureScenario(Scenario scenario) {

        if (scenario.getSourceTagNames().contains("@influxdb")) {
            InfluxDBIntegration bd = InfluxDBIntegration.getInstance();
            Calendar startTime = Serenity.sessionVariableCalled("startTime");
            Serenity.setSessionVariable("endTime").to(Calendar.getInstance());
            Calendar endTime = Serenity.sessionVariableCalled("endTime");
            bd.writeInfluxDB(scenario, startTime, endTime);
        }

    }

    @Then("^I should get (.*) status store code$")
    public void iShouldGetExpectedStatusCodeStatusStoreCode(int statusCode) {
        StoreExampleSteps.checkStatusCode(statusCode);
    }

    @And("^The value for the '(.*)' after the '(.*)' should be '(.*)'$")
    public void theForTheKeyAfterTheOperationShouldBeValue(String key, String operation, String value) {
        Response res = Serenity.sessionVariableCalled("response");
        StoreExampleSteps.verifyResultsOperation(res, key, operation, value);
    }
}