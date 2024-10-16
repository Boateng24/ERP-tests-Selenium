package com.qa.iconautomatedpractice.TestBase;
import com.qa.iconautomatedpractice.Utilities.urlUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;



public class BaseTest {
    public WebDriver driver;
    public urlUtils browserUrl;
    public Logger logger;
    public Properties prop;

    //setup
    @Parameters({"browser", "os"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser, @Optional("windows") String os) throws IOException {
        FileReader envFile = new FileReader("./src//test//resources/config.properties");
        prop = new Properties();
        prop.load(envFile);
        logger = LogManager.getLogger(this.getClass() );
        if(browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser and OS");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(prop.getProperty("baseUrl"));
        driver.manage().window().maximize();
        browserUrl = new urlUtils(driver);
    }

    //teardown
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
