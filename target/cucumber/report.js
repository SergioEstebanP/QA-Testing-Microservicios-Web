$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/Example.feature");
formatter.feature({
  "name": "Basic API feature",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Get an existing user",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I request to get a user by ID \"\u003cuserID\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "I should get \u003cexpectedStatusCode\u003e status code",
  "keyword": "Then "
});
formatter.step({
  "name": "The value for the \"\u003ckey\u003e\" after get operation should be \"\u003cvalue\u003e\"",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "userID",
        "key",
        "value",
        "expectedStatusCode"
      ]
    },
    {
      "cells": [
        "2",
        "first_name",
        "Janet",
        "200"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Get an existing user",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I request to get a user by ID \"2\"",
  "keyword": "When "
});
formatter.match({
  "location": "ExampleDefinitions.iRequestOperUserByID(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should get 200 status code",
  "keyword": "Then "
});
formatter.match({
  "location": "ExampleDefinitions.iShouldGetStatusCode(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The value for the \"first_name\" after get operation should be \"Janet\"",
  "keyword": "And "
});
formatter.match({
  "location": "ExampleDefinitions.theValueForTheAfterGetOperationShouldBe(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Create a new user successfully",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I request to create a user",
  "keyword": "When "
});
formatter.step({
  "name": "I should get \u003cexpectedStatusCode\u003e status code",
  "keyword": "Then "
});
formatter.step({
  "name": "The value for the \"\u003ckey\u003e\" after post operation should be \"\u003cvalue\u003e\"",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "key",
        "value",
        "expectedStatusCode"
      ]
    },
    {
      "cells": [
        "name",
        "morpheus",
        "201"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Create a new user successfully",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I request to create a user",
  "keyword": "When "
});
formatter.match({
  "location": "ExampleDefinitions.iRequestToCreateNewUser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should get 201 status code",
  "keyword": "Then "
});
formatter.match({
  "location": "ExampleDefinitions.iShouldGetStatusCode(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The value for the \"name\" after post operation should be \"morpheus\"",
  "keyword": "And "
});
formatter.match({
  "location": "ExampleDefinitions.theValueForTheAfterGetOperationShouldBe(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Update an existing user",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I request to update a user by ID \"\u003cuserID\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "I should get \u003cexpectedStatusCode\u003e status code",
  "keyword": "Then "
});
formatter.step({
  "name": "The value for the \"\u003ckey\u003e\" after update operation should be \"\u003cvalue\u003e\"",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "userID",
        "key",
        "value",
        "expectedStatusCode"
      ]
    },
    {
      "cells": [
        "2",
        "name",
        "morpheus",
        "200"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Update an existing user",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I request to update a user by ID \"2\"",
  "keyword": "When "
});
formatter.match({
  "location": "ExampleDefinitions.iRequestOperUserByID(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should get 200 status code",
  "keyword": "Then "
});
formatter.match({
  "location": "ExampleDefinitions.iShouldGetStatusCode(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The value for the \"name\" after update operation should be \"morpheus\"",
  "keyword": "And "
});
formatter.match({
  "location": "ExampleDefinitions.theValueForTheAfterGetOperationShouldBe(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Delete an existing user",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I request to delete a user by ID \"2\"",
  "keyword": "When "
});
formatter.match({
  "location": "ExampleDefinitions.iRequestOperUserByID(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should get 204 status code",
  "keyword": "Then "
});
formatter.match({
  "location": "ExampleDefinitions.iShouldGetStatusCode(int)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});