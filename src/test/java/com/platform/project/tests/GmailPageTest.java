package com.platform.project.tests;

import com.platform.project.commons.Commons;
import com.platform.project.commons.ReadPropertyFile;
import com.platform.project.commons.WebDriverManager;
import com.platform.project.pageObjects.GmailPage;
import com.platform.project.pageObjects.RedfinHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class GmailPageTest
{
    WebDriver driver;
    GmailPage gmailPage;
    WebDriverManager webDriverManager;

    @BeforeMethod
    public void setup()
    {
        webDriverManager = new WebDriverManager();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = webDriverManager.getDriver
                (Commons.createEnvVariable("browser", ReadPropertyFile.getConfigPropertyVal("browser")));
        gmailPage = new GmailPage(driver);
        driver.manage().deleteAllCookies();
    }

    @Test
    public void openHomePage()
    {
        gmailPage.openHomePage();
    }

    @Test
    public void openNextPage()
    {
        gmailPage.openHomePage();
        gmailPage.openNextPage();
    }

    @Test
    public void openWindow() throws InterruptedException
    {
        gmailPage.openHomePage();
        gmailPage.openNewWindow(driver);
    }

    @Test
    public void openWindows() throws InterruptedException
    {
        gmailPage.openHomePage();
        gmailPage.openNewWindows(driver);
    }

    @Test
    public void openTabs()
    {
        gmailPage.openHomePage();
        gmailPage.openTabs(driver);
    }
    @AfterMethod
    public void cleanUp()
    {
        //driver.quit();
    }
}
