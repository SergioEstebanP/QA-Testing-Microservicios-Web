$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/pet/pet.feature");
formatter.feature({
  "name": "Testing petstore.swagger.io services",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I request to do \u0027delete\u0027 operation by 3603 id against the petStore service",
  "keyword": "When "
});
formatter.match({
  "location": "PetExampleDefinitions.iRequestToDoOperationOperationByIdAgainstThePetStoreService(String,int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should get 200 status code",
  "keyword": "Then "
});
formatter.match({
  "location": "PetExampleDefinitions.iShouldGetStatusCode(int)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});