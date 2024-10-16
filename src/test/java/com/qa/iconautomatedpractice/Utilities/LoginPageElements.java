package com.qa.iconautomatedpractice.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageElements {

    WebDriver driver;

    public LoginPageElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#loginEmail")
    public WebElement emailField;

    @FindBy(css = "#loginPassword")
    public WebElement passwordField;

    @FindBy(xpath = "//button")
    public WebElement loginButton;
}

