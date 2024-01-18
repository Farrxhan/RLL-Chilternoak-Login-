package com.app.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "C:\\Users\\farha\\furniture-project\\LoginFunctionality\\src\\test\\java\\features\\login.feature",
    glue = { "com.app.stepdefs" },
    plugin = {
        "html:target/Login_Functionality_Report.html",
        "pretty",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "timeline:test-output-thread/"
    }
    // Add tags option if needed: tags = "@yourTag"
)
public class TestNgRunner extends AbstractTestNGCucumberTests {

    // A cucumber runner file is used to build a communication between your feature
    // files and step definition file
    // Whenever we have to run multiple features or multiple steps, then we use
    // Cucumber runner file.
    // Whenever have to generate reports, we will use the cucumber runner file
}