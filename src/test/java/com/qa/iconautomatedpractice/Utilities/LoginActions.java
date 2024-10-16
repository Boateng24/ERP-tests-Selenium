package com.qa.iconautomatedpractice.Utilities;

import org.openqa.selenium.WebDriver;

public class LoginActions {

    LoginPageElements elements;

    public LoginActions(WebDriver driver) {
        elements = new LoginPageElements(driver);
    }

    public void enterEmail(String email) {
        elements.emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        elements.passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        elements.loginButton.click();
    }
}
