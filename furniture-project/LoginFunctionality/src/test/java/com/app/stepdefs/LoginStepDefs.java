package com.app.stepdefs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginStepDefs {
	private static final Logger logger = LogManager.getLogger(LoginStepDefs.class);
    WebDriver driver;

    @Given("user navigates to the login page")
    public void userNavigatesToLoginPage() {
    	logger.info("User navigates to the loginpage");
        driver = new ChromeDriver();
        driver.get("https://www.chilternoakfurniture.co.uk/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement loginpage = driver.findElement(By.xpath("//a[@class='toolbar-account']"));
        loginpage.click();
    }

    @When("user enters {string} and {string}")
    public void userEntersUsernameAndPassword(String username, String password) {
    	logger.info("User enters the user name and password");
        WebElement emailField = driver.findElement(By.xpath("//input[@id='customer_email']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));

        emailField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    @When("clicks the login button")
    public void clicksLoginButton() {
    	logger.info("User clicks on the login button");
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
    }

    @Then("Message Should Be Displayed {string}")
    public void messageShouldBeDisplayed(String loginResult) {
    	logger.info("Displayed Message");
        if (loginResult.equals("logged_in_successfully")) {
            // Add assertion or verification for successful login
            System.out.println("logged in successfully");
        } else {
            // Add assertion or verification for unsuccessful login
            // For example, checking error messages or validating the login page
            String errorMessage = "Incorrect email or Password";
            Assert.assertTrue(driver.getPageSource().contains(errorMessage));
        }
        driver.quit();
    }
}
