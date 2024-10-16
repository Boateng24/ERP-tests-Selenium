package com.qa.iconautomatedpractice.PageObjects;

import com.qa.iconautomatedpractice.Utilities.LoginActions;
import org.openqa.selenium.WebDriver;


// page_url = https://icon.amalitech-dev.net/
public class LoginPage extends BasePage {
    WebDriver driver;
    LoginActions actions;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        actions = new LoginActions(driver);
    }

    public void loginUser(String email, String password) {
        actions.enterEmail((email));
        actions.enterPassword(password);
        actions.clickLoginButton();
    }

}