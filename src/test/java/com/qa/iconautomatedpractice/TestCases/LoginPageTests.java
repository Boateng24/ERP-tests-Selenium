package com.qa.iconautomatedpractice.TestCases;

import com.qa.iconautomatedpractice.PageObjects.LoginPage;
import com.qa.iconautomatedpractice.TestBase.BaseTest;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {

    //test
    @Test
    public void userLogin() {
        LoginPage login = new LoginPage(driver);
        try {
            logger.info("Starting Login test");
            login.loginUser("me@you.com", "11223344");
            browserUrl.CurrentUrl("/home");
            logger.info("Navigated success after a successful login");
        }catch (Exception e) {
           logger.error("Error during login", e);
           throw e;
        }
    }
}
