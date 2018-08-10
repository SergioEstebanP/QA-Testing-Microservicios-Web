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
  "name": "I request to do \u0027\u003coperation\u003e\u0027 operation by \u003cid\u003e against the petStore store service",
  "keyword": "When "
});
formatter.step({
  "name": "I should get \u003cexpectedStatusCode\u003e status store code",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "operation",
        "id",
        "expectedStatusCode"
      ]
    },
    {
      "cells": [
        "delete",
        "1",
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
formatter.step({
  "name": "I request to do \u0027delete\u0027 operation by 1 against the petStore store service",
  "keyword": "When "
});
formatter.match({
  "location": "StoreExampleDefinitions.iRequestToDoOperationOperationByIdAgainstThePetStoreStoreService(String,int)"
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
  "error_message": "java.lang.AssertionError: The status code is incorrect, something in the operation went wrong expected:\u003c200\u003e but was:\u003c404\u003e\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.failNotEquals(Assert.java:834)\r\n\tat org.junit.Assert.assertEquals(Assert.java:645)\r\n\tat com.adidas.serenitySteps.storeSteps.StoreExampleSteps.checkStatusCode(StoreExampleSteps.java:39)\r\n\tat com.adidas.serenitySteps.storeSteps.StoreExampleSteps$$EnhancerByCGLIB$$6378d2f5.CGLIB$checkStatusCode$2(\u003cgenerated\u003e)\r\n\tat com.adidas.serenitySteps.storeSteps.StoreExampleSteps$$EnhancerByCGLIB$$6378d2f5$$FastClassByCGLIB$$200e0ee.invoke(\u003cgenerated\u003e)\r\n\tat net.sf.cglib.proxy.MethodProxy.invokeSuper(MethodProxy.java:228)\r\n\tat net.thucydides.core.steps.StepInterceptor.invokeMethod(StepInterceptor.java:449)\r\n\tat net.thucydides.core.steps.StepInterceptor.executeTestStepMethod(StepInterceptor.java:434)\r\n\tat net.thucydides.core.steps.StepInterceptor.runTestStep(StepInterceptor.java:409)\r\n\tat net.thucydides.core.steps.StepInterceptor.runOrSkipMethod(StepInterceptor.java:150)\r\n\tat net.thucydides.core.steps.StepInterceptor.testStepResult(StepInterceptor.java:137)\r\n\tat net.thucydides.core.steps.StepInterceptor.intercept(StepInterceptor.java:68)\r\n\tat com.adidas.serenitySteps.storeSteps.StoreExampleSteps$$EnhancerByCGLIB$$6378d2f5.checkStatusCode(\u003cgenerated\u003e)\r\n\tat com.adidas.gherkinDefinitions.storeDefinitions.StoreExampleDefinitions.iShouldGetExpectedStatusCodeStatusStoreCode(StoreExampleDefinitions.java:67)\r\n\tat ✽.I should get 200 status store code(src/test/resources/features/store/store.feature:25)\r\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});