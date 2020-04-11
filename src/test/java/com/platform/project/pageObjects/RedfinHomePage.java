package com.platform.project.pageObjects;

import com.platform.project.commons.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
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
    @FindBy(linkText = "https://www.redfin.com/city/19457/CA/Sunnyvale")
    WebElement sunnyVale;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/header[2]/div[1]/div[1]/a[1]/*[local-name()='svg'][1]")
    WebElement redFinLogo;

    private WebDriver driver;
    private Logger log = Logger.getLogger(RedfinHomePage.class);

    public RedfinHomePage(WebDriver driver)
    {
        this.driver = driver;
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

        Commons.clickOnElement(driver, sunnyVale);




        
    }



}
