package com.platform.project.tests;

import com.platform.project.commons.Commons;
import com.platform.project.commons.ReadPropertyFile;
import com.platform.project.commons.WebDriverManager;
import com.platform.project.pageObjects.MTGOTraders;
import com.platform.project.pageObjects.RedfinHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    @Test
    public void openEbay()
    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/geckodriver.exe");

        WebDriver driver2 = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver2, 20);
        driver2.get("https://www.ebay.com/");
        driver2.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("iphones");
        driver2.findElement(By.xpath("//input[@id='gh-btn']")).click();
        //wait.until(ExpectedConditions.visibilityOf(driver2.findElement(By.xpath("//h3[contains(text(),'Apple iPhone 8 Plus (Factory Unlocked,Verizon,AT&T')]")))).click();
        driver2.findElement(By.xpath("//li[2]//div[1]//div[1]//div[1]//a[1]//div[1]//img[1]")).click();
        //driver2.quit();
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
