$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/store/store.feature");
formatter.feature({
  "name": "Testing petstore.swagger.io services related to store services",
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
  "name": "I request to do \u0027\u003coperation\u003e\u0027 operation against the petStore store service",
  "keyword": "When "
});
formatter.step({
  "name": "I should get \u003cexpectedStatusCode\u003e status store code",
  "keyword": "Then "
});
formatter.step({
  "name": "The value for the \u0027\u003ckey\u003e\u0027 after the \u0027\u003coperation\u003e\u0027 should be \u0027\u003cvalue\u003e\u0027",
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
        "expectedStatusCode",
        "key",
        "operation",
        "value"
      ]
    },
    {
      "cells": [
        "get",
        "200",
        "status",
        "get",
        "6"
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
formatter.step({
  "name": "I request to do \u0027get\u0027 operation against the petStore store service",
  "keyword": "When "
});
formatter.match({
  "location": "StoreExampleDefinitions.iRequestToDoOperationOperationAgainstThePetStoreStoreService(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should get 200 status store code",
  "keyword": "Then "
});
formatter.match({
  "location": "StoreExampleDefinitions.iShouldGetExpectedStatusCodeStatusStoreCode(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The value for the \u0027status\u0027 after the \u0027get\u0027 should be \u00276\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "StoreExampleDefinitions.theForTheKeyAfterTheOperationShouldBeValue(String,String,String)"
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
});