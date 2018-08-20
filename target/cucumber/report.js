$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/pet/pet.feature");
formatter.feature({
  "name": "Testing petstore.swagger.io services related to pet services",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@test"
    }
  ]
});
formatter.step({
  "name": "I request to do \u0027\u003coperation\u003e\u0027 operation against the petStore service",
  "keyword": "When "
});
formatter.step({
  "name": "I should get \u003cexpectedStatusCode\u003e status code",
  "keyword": "Then "
});
formatter.step({
  "name": "The value for the \u0027\u003ckey\u003e\u0027 after \u0027\u003coperation\u003e\u0027 operation should be \u0027\u003cvalue\u003e\u0027",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "operation",
        "key",
        "value",
        "expectedStatusCode"
      ]
    },
    {
      "cells": [
        "post",
        "status",
        "available",
        "200"
      ]
    }
  ]
});
formatter.scenario({
  "name": "",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@test"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I request to do \u0027post\u0027 operation against the petStore service",
  "keyword": "When "
});
formatter.match({
  "location": "PetExampleDefinitions.iRequestToStoreAPetInJsonFile(String)"
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
formatter.step({
  "name": "The value for the \u0027status\u0027 after \u0027post\u0027 operation should be \u0027available\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "PetExampleDefinitions.checkValueFromResponse(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});