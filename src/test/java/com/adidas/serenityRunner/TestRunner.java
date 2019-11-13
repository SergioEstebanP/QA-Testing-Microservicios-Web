package com.adidas.serenityRunner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.net.DatagramSocket;
import java.net.InetAddress;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = { "pretty", "html:target/cucumber", "json:target/cucumber-report.json"},
        glue = {"com.adidas.gherkinDefinitions"}
)

public class TestRunner {
    // nothing should be initialized here
}
