package com.app.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(xpath = "//a[@class='toolbar-account']")
    WebElement loginPage;

    @FindBy(xpath = "//input[@id='customer_email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordField;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement loginButton;

    // Constructor to initialize the elements
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methods to perform actions on the page
    public void clickLoginPage() {
        loginPage.click();
    }

    public void enterEmail(String email)  {
        emailField.sendKeys(email);
        //Thread.sleep(10000);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
        //Thread.sleep(10000);
    }

    public void clickLoginButton(){
        loginButton.click();
       // Thread.sleep(30000);
    }

    
}