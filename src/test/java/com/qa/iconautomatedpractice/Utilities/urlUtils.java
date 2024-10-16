package com.qa.iconautomatedpractice.Utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class urlUtils {
    public WebDriver driver;
    public urlUtils(WebDriver driver) {
        this.driver=driver;
    }

    public void CurrentUrl(String route) {
        String baseUrl = "https://icon.amalitech-dev.net";
        String expectedURL = baseUrl + route;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlToBe(expectedURL));

        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, expectedURL);
    }
}
