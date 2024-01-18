package com.app.stepdefs;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
    public void userEntersUsernameAndPassword(String username, String password) throws InterruptedException {
    	logger.info("User enters the user name and password");
        WebElement emailField = driver.findElement(By.xpath("//input[@id='customer_email']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        Thread.sleep(3000);
        emailField.sendKeys(username);
        Thread.sleep(3000);
        passwordField.sendKeys(password);
        Thread.sleep(3000);
    }

    @When("clicks the login button")
    public void clicksLoginButton() throws InterruptedException {
    	logger.info("User clicks on the login button");
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
        Thread.sleep(30000);
    }

    @Then("Message Should Be Displayed {string}")
    public void messageShouldBeDisplayed(String loginResult) {
    	logger.info("Displayed Message");
        if (loginResult.equals("logged_in_successfully")) {
            //verification for successful login
            System.out.println("logged in successfully");
        } else {
            //verification for unsuccessful login
            String errorMessage = "Incorrect email or Password";
            Assert.assertTrue(driver.getPageSource().contains(errorMessage));
           
        }
    }
        
       
    }

