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
  "error_message": "java.lang.NullPointerException\r\n\tat com.adidas.serenitySteps.userSteps.UserExampleSteps.checkStatusCode(UserExampleSteps.java:43)\r\n\tat com.adidas.serenitySteps.userSteps.UserExampleSteps$$EnhancerByCGLIB$$4de8d101.CGLIB$checkStatusCode$3(\u003cgenerated\u003e)\r\n\tat com.adidas.serenitySteps.userSteps.UserExampleSteps$$EnhancerByCGLIB$$4de8d101$$FastClassByCGLIB$$50f7a840.invoke(\u003cgenerated\u003e)\r\n\tat net.sf.cglib.proxy.MethodProxy.invokeSuper(MethodProxy.java:228)\r\n\tat net.thucydides.core.steps.StepInterceptor.invokeMethod(StepInterceptor.java:449)\r\n\tat net.thucydides.core.steps.StepInterceptor.executeTestStepMethod(StepInterceptor.java:434)\r\n\tat net.thucydides.core.steps.StepInterceptor.runTestStep(StepInterceptor.java:409)\r\n\tat net.thucydides.core.steps.StepInterceptor.runOrSkipMethod(StepInterceptor.java:150)\r\n\tat net.thucydides.core.steps.StepInterceptor.testStepResult(StepInterceptor.java:137)\r\n\tat net.thucydides.core.steps.StepInterceptor.intercept(StepInterceptor.java:68)\r\n\tat com.adidas.serenitySteps.userSteps.UserExampleSteps$$EnhancerByCGLIB$$4de8d101.checkStatusCode(\u003cgenerated\u003e)\r\n\tat com.adidas.gherkinDefinitions.userDefinitions.UserExampleDefinitions.iShouldGetExpectedStatusCodeStatusStoreCode(UserExampleDefinitions.java:75)\r\n\tat ✽.I should get 200 status user code(src/test/resources/features/user/user.feature:7)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "The user value for the \u0027id\u0027 after the \u0027post\u0027 should be \u00272311\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "UserExampleDefinitions.theForTheKeyAfterTheOperationShouldBeValue(String,String,String)"
});
formatter.result({
  "status": "skipped"
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