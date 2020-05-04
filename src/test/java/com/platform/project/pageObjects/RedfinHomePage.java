package com.platform.project.pageObjects;

import com.platform.project.commons.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RedfinHomePage
{
    @FindBy(xpath = "//h2[contains(text(),'SELLING')]")
    WebElement pageTitle;
    @FindBy(xpath = "//div[@class='searchInputNode']//input[@id='search-box-input']")
    WebElement searchBar;
    @FindBy(xpath = "//div[@class='searchInputNode']//button[@class='inline-block SearchButton clickable float-right']" +
            "//*[local-name()='svg']")
    WebElement searchButton;
    //@FindBy(linkText = "Sunnyvale")
    //WebElement sunnyVale;


    private WebDriver driver;
    private JavascriptExecutor javascriptExecutor;
    private Logger log = Logger.getLogger(RedfinHomePage.class);

    public RedfinHomePage(WebDriver driver)
    {
        this.driver = driver;
        javascriptExecutor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void openHomePage()
    {
        log.info("Opening the Redfin.com");
        driver.get(ReadPropertyFile.getConfigPropertyVal("redfinHomepage"));
    }

    public String getPageTitle()
    {
        log.info("Getting title");
        return Commons.getElementText(driver, pageTitle, 3);
    }

    public void getToRealEstatePage()
    {
        searchBar.sendKeys("Sunnyvale");
        Commons.clickOnElement(driver, searchButton);
        //javascriptExecutor.executeScript("arguments[0].click();",sunnyVale);
        //Commons.clickOnElement(driver, sunnyVale);




        
    }



}
