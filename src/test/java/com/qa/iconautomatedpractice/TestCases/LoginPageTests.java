package com.qa.iconautomatedpractice.TestCases;

import com.qa.iconautomatedpractice.PageObjects.LoginPage;
import com.qa.iconautomatedpractice.TestBase.BaseTest;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {

    //test
    @Test(dataProvider = "excelData", dataProviderClass = com.qa.iconautomatedpractice.Utilities.DataProviders.class)
    public void userLogin(String name, String password, String expectedStatus) {
        LoginPage login = new LoginPage(driver);
        try {
            logger.info("Starting Login test");
            login.loginUser(name, password);
            if("logged successfully".equalsIgnoreCase(expectedStatus)){
                browserUrl.CurrentUrl("/home");
                logger.info("Navigated success after a successful login");
            } else if ("invalid credentials".equalsIgnoreCase(expectedStatus)) {
                browserUrl.assertUrlDoesNotContain("/home");
                logger.info("Login failed as expected with invalid credentials.");
            }


        }catch (Exception e) {
           logger.error("Error during login", e);
           throw e;
        }
    }
}
