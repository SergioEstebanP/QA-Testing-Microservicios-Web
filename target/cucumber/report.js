$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/user/user.feature");
formatter.feature({
  "name": "Testing petstore.swagger.io services related to user services",
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
  "name": "I request to do \u0027\u003cuserOperation\u003e\u0027 \u0027\u003coperation\u003e\u0027 operation against the petStore user service",
  "keyword": "When "
});
formatter.step({
  "name": "I should get \u003cexpectedStatusCode\u003e status user code",
  "keyword": "Then "
});
formatter.step({
  "name": "The user value for the \u0027\u003ckey\u003e\u0027 after the \u0027\u003coperation\u003e\u0027 should be \u0027\u003cvalue\u003e\u0027",
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
        "userOperation",
        "expectedStatusCode",
        "key",
        "operation",
        "value"
      ]
    },
    {
      "cells": [
        "post",
        "createList",
        "200",
        "id",
        "post",
        "2311"
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
  "name": "I request to do \u0027createList\u0027 \u0027post\u0027 operation against the petStore user service",
  "keyword": "When "
});
formatter.match({
  "location": "UserExampleDefinitions.iRequestToDoOperationOperationAgainstThePetStoreUserService(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should get 200 status user code",
  "keyword": "Then "
});
formatter.match({
  "location": "UserExampleDefinitions.iShouldGetExpectedStatusCodeStatusStoreCode(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The user value for the \u0027id\u0027 after the \u0027post\u0027 should be \u00272311\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "UserExampleDefinitions.theForTheKeyAfterTheOperationShouldBeValue(String,String,String)"
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