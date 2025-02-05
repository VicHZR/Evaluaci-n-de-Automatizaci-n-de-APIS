package com.nttdata.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.nttdata.glue",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner {
}
