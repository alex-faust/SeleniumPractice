package com.platform.project.pageObjects;

import com.platform.project.commons.Commons;
import com.platform.project.commons.JSUtil;
import com.platform.project.commons.ReadPropertyFile;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MTGOTraders
{
    private WebDriver driver;
    private JavascriptExecutor js;
    private Logger log = Logger.getLogger(MTGOTraders.class);

    @FindBy(xpath = "//a[contains(text(),'www.mtgotraders.com')]")
    WebElement pageTitle;
    @FindBy(xpath = "//a[contains(text(),'Log In')]")
    WebElement loginButton;
    @FindBy(xpath = "//div[@class='crlogin']//input[@name='email1']")
    WebElement email;
    @FindBy(xpath = "//input[@name='text1']")
    WebElement password;
    @FindBy(xpath = "//input[@id='Sign In']")
    WebElement signInButton;
    @FindBy(xpath = "//a[contains(text(),'My Account')]")
    WebElement myAccountButton;



    public MTGOTraders(WebDriver driver)
    {
        this.driver = driver;
        js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void openHomePage()
    {
        log.info("opening mtgotraders home page");
        driver.get(ReadPropertyFile.getConfigPropertyVal("mtgotradersPage"));
    }

    public String getPageTitle()
    {
        log.info("Getting MTGO Traders page title.");
        return Commons.getElementText(driver, pageTitle, 3);
    }

    public void login()
    {
        log.info("logging in to mtgo traders");
        Commons.clickOnElement(driver, loginButton);
        email.sendKeys((ReadPropertyFile.getConfigPropertyVal("email")));
        password.sendKeys((ReadPropertyFile.getConfigPropertyVal("password")));
        Commons.clickOnElement(driver, signInButton);
    }

    public boolean getLoginPageTitle()
    {
        log.info("Getting Login page title");
        return Commons.isElementVisible(driver, myAccountButton, 3);
    }
}
