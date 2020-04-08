package com.platform.project.tests;

import com.platform.project.commons.*;
import com.platform.project.pageObjects.RedfinHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RedfinHomePageTest
{
    WebDriver driver;
    RedfinHomePage redfinHomePage;
    WebDriverManager webDriverManager;

    @BeforeMethod
    public void setup()
    {
        webDriverManager = new WebDriverManager();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = webDriverManager.getDriver
                (Commons.createEnvVariable("browser", ReadPropertyFile.getConfigPropertyVal("browser")));
        redfinHomePage = new RedfinHomePage(driver);
    }

    @Test
    public void openHomePage()
    {
        redfinHomePage.openHomePage();
        Commons.check(driver, redfinHomePage.getClassName().equals("Tour homes without\n" + "leaving your couch"),
                "Home Page Title didn't match.");
    }

    @AfterMethod
    public void cleanUp()
    {
        driver.quit();
    }
}
