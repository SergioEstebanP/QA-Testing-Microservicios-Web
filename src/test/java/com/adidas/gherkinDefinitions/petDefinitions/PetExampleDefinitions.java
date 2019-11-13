package com.adidas.gherkinDefinitions.petDefinitions;

import com.adidas.serenitySteps.petSteps.PetExampleSteps;
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

    @And("^I set operation request to (get|GET|post|POST|put|PUT|delete|DELETE)$")
    public void iSetOperationRequestTo(String operation) {
        petExampleSteps.setRequestOperation(operation);
    }

    @When("^I execute the request$")
    public void iExecuteTheRequest() {
        petExampleSteps.executeRequest();
    }

    @Then("^the status code should be a (\\d+)$")
    public void theStatusCodeShouldBeA(int statusCode) {
        petExampleSteps.checkStatusCode(statusCode);
    }

    @And("^the response jsonPath \"([^\"]*)\" should be \"([^\"]*)\"$")
    public void heResponseJsonPathShouldBeAValidId(String jsonPath, String value) {
        petExampleSteps.checkJsonPathValue(jsonPath, value);
    }
}
