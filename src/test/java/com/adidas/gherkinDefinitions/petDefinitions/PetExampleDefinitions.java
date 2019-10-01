package com.adidas.gherkinDefinitions.petDefinitions;

import com.adidas.serenitySteps.petSteps.PetExampleSteps;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class PetExampleDefinitions {

    @Steps
    private PetExampleSteps petExampleSteps;

    @Given("^I set base URL for the request to base petstore URL$")
    public void iSetBaseUrlForRequestBasePetStore() {
        petExampleSteps.setBaseUrl();
    }

    @And("^I set endpoint to \"([^\"]*)\"$")
    public void iSetEndpointTo(String endpoint) {
        petExampleSteps.setEndpoint(endpoint);
    }

    @And("^I set body with this template: \"([^\"]*)\"$")
    public void iSetBodyWithFromThisTemplate(String pathFile) {
        //petExampleSteps.setBody();
    }

    @And("^I set body with this information:$")
    public void iSetBodyWithThisInformation(String requestBody) {
        petExampleSteps.setBody(requestBody);
    }

    @And("^I set header \"([^\"]*)\" to value \"([^\"]*)\"$")
    public void iSetHeaderToValue(String headerName, String headerValue) {
        petExampleSteps.setHeaderToValue(headerName, headerValue);
    }

    @And("^I set headers with:$")
    public void iSetHeadersWith(DataTable headers) {
        petExampleSteps.setHeaderBulk(headers);
    }

    @When("^I execute the request$")
    public void iExecuteTheRequest() {
        petExampleSteps.executeRequest();
    }

    @And("^I set operation request to \"([^\"]*)\"$")
    public void iSetOperationRequestTo(String operation) {
        petExampleSteps.setRequestOperation(operation);
    }

    @Then("^the status code should be a (\\d+)$")
    public void theStatusCodeShouldBeA(int statusCode) {
        petExampleSteps.checkStatusCode(statusCode);
    }

    @And("^the response json path \"([^\"]*)\" should be a valid id$")
    public void heResponseJsonPathShouldBeAValidId(String jsonPath) {
        petExampleSteps.checkValidId(jsonPath);
    }

    @And("^the response json path \"([^\"]*)\" should be \"([^\"]*)\"$")
    public void theResponseJsonPathShouldBe(String jsonPath, String value) {
        petExampleSteps.checkJsonPathValue(jsonPath, value);
    }

    @And("^I set header \"([^\"]*)\" to \"([^\"]*)\"$")
    public void iSetHeaderTo(String tokenName, String value) {
        petExampleSteps.setToken(tokenName, value);
    }
}
