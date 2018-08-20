package com.adidas.gherkinDefinitions.petDefinitions;

import com.adidas.influxdb.InfluxDBIntegration;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import com.adidas.serenitySteps.petSteps.PetExampleSteps;

import java.awt.*;
import java.util.Calendar;

public class PetExampleDefinitions {

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
    private PetExampleSteps PetExampleSteps;

    /**
     * Step definition: the user try to post a new pet on the store.
     *
     */
    @When("^I request to do '(.*)' operation against the petStore service$")
    public void iRequestToStoreAPetInJsonFile (String operation) {
        switch (operation.toLowerCase()){
            case ("post"):
                PetExampleSteps.postNewPetOnStore(operation);
                break;
            case ("put"):
                PetExampleSteps.putNewInfoOnStore(operation);
                break;
            case ("get"):
                PetExampleSteps.getInfoOfStore(operation);
                break;
        }
    }

    @When("^I request to do '(.*)' operation by (.*) against the petStore service$")
    public void iRequestToDoOperationOperationByIdAgainstThePetStoreService(String operation, int id) {
        switch (operation.toLowerCase()) {
            case ("get"):
                PetExampleSteps.getPetById(operation, id);
                break;
            case ("delete"):
                PetExampleSteps.deletePetById(operation, id);
                break;
            case ("post"):
                PetExampleSteps.updateInfoById(operation, id);
                break;
        }
    }

    @And("^I want to change the name to '(.*)' and the status to '(.*)'$")
    public void iWantToChangeTheNameToBuguiAndTheStatusToSold(String name, String status) {
    }

    @Then("^I should get (.*) status code$")
    public void iShouldGetStatusCode (int statusCode) {
        PetExampleSteps.verifyStatusCode(statusCode);
    }

    @And ("^The value for the '(.*)' after '(.*)' operation should be '(.*)'$")
    public void checkValueFromResponse (String identifier, String operation, String value) {
        Response res = Serenity.sessionVariableCalled("response");
        PetExampleSteps.checkValueFromResponse(res, operation, identifier, value);
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
