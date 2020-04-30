package com.platform.project.tests;

import com.platform.project.commons.Commons;
import com.platform.project.commons.ReadPropertyFile;
import com.platform.project.commons.WebDriverManager;
import com.platform.project.pageObjects.MTGOTraders;
import com.platform.project.pageObjects.RedfinHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MTGOTradersTest
{
    WebDriver driver;
    MTGOTraders mtgoTraders;
    WebDriverManager webDriverManager;

    //@BeforeMethod
    public void setup()
    {
        webDriverManager = new WebDriverManager();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = webDriverManager.getDriver
                (Commons.createEnvVariable("browser", ReadPropertyFile.getConfigPropertyVal("browser")));
        mtgoTraders = new MTGOTraders(driver);
    }

    @Test
    public void openHomePage()
    {
        mtgoTraders.openHomePage();
        Commons.check(driver, mtgoTraders.getPageTitle().equals("www.mtgotraders.com"),
                "Failed to open the MTGO home page");
    }

    //@Test
    public void loginMTGO()
    {
        mtgoTraders.openHomePage();
        mtgoTraders.login();
        Commons.check(driver, mtgoTraders.getLoginPageTitle(), "login page not found");
    }

    //@AfterMethod
    public void cleanUp()
    {
        driver.quit();
    }
}
