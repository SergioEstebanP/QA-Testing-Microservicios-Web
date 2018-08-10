package com.adidas.gherkinDefinitions.userDefinitions;


import com.adidas.influxdb.InfluxDBIntegration;
import com.adidas.serenitySteps.storeSteps.StoreExampleSteps;
import com.adidas.serenitySteps.userSteps.UserExampleSteps;
import cucumber.api.PendingException;
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

public class UserExampleDefinitions {

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

    @When("^I request to do '(.*)' '(.*)' operation against the petStore user service$")
    public void iRequestToDoOperationOperationAgainstThePetStoreUserService(String operationUser, String operation) {
        switch (operation) {
            case ("post"):
                switch (operationUser) {
                    case ("create"):
                        userExampleSteps.createUser(operation);
                        break;
                    case ("createList"):
                        userExampleSteps.createUserList(operation);
                        break;
                }
                break;
            case ("get"):
                userExampleSteps.logoutUser(operation);
                break;
        }
    }

    @Steps
    private UserExampleSteps userExampleSteps;

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

    @Then("^I should get (.*) status user code$")
    public void iShouldGetExpectedStatusCodeStatusStoreCode(int statusCode) {
        userExampleSteps.checkStatusCode(statusCode);
    }

    @And("^The user value for the '(.*)' after the '(.*)' should be '(.*)'$")
    public void theForTheKeyAfterTheOperationShouldBeValue(String key, String operation, String value) {
        Response res = Serenity.sessionVariableCalled("response");
        userExampleSteps.verifyResultsOperation(res, key, operation, value);
    }

    @When("^I request to do '(.*)' operation against the petStore user service to login '(.*)' '(.*)'$")
    public void iRequestToDoOperationOperationAgainstThePetStoreUserServiceToLoginUserPasswd(String operation, String user, String passwd) {
        userExampleSteps.loginUser(operation, user, passwd);
    }

    @When("^I request to do '(.*)' operation against the petStore user service to login '(.*)'$")
    public void iRequestToDoOperationOperationAgainstThePetStoreUserServiceToLoginUser(String operation, String name) {
        switch (operation) {
            case ("put"):
                userExampleSteps.updateUser(operation, name);
                break;
            case ("get"):
                userExampleSteps.getByName(operation, name);
                break;
            case ("delete"):
                userExampleSteps.deleteByName(operation, name);
                break;
        }
    }
}