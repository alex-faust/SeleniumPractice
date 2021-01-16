package com.platform.project.tests;

import com.platform.project.commons.*;
import com.platform.project.pageObjects.RedfinHomePage;
import org.openqa.selenium.*;
import org.testng.Assert;
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
        driver.manage().deleteAllCookies();
    }

    @Test
    public void openHomePage()
    {
        redfinHomePage.openHomePage();
        Commons.check(driver, redfinHomePage.isMainLogoVisible(), "Main page not available.");
    }



    @Test
    public void sunnyvaleBox()
    {
        redfinHomePage.openHomePage();
        redfinHomePage.getToRealEstatePage();
        Commons.check(driver, redfinHomePage.confirmSunnyvaleTextBox().equals("Sunnyvale"),
                "Does not match.");
    }

    @Test
    public void openSecondPage()
    {
        redfinHomePage.openHomePage();
        redfinHomePage.getToRealEstatePage();
        Commons.check(driver, redfinHomePage.verifySecondPage().equals("Sunnyvale Homes for Sale"),
                "Page does not match");
    }

    @Test
    public void gatherListOfPrices()
    {
        redfinHomePage.openHomePage();
        redfinHomePage.getToRealEstatePage();
        Commons.check(driver, redfinHomePage.gatherPrices(), "Prices are out of range.");
        //Assert.assertTrue(redfinHomePage.gatherPrices());
    }





    @AfterMethod
    public void cleanUp()
    {
        driver.quit();
    }
}
