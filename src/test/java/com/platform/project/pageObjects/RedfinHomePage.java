package com.platform.project.pageObjects;

import com.platform.project.commons.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedfinHomePage
{
    @FindBy(xpath = "//h2[contains(text(),'SELLING')]")
    WebElement pageTitle;
    @FindBy(xpath = "//div[@class='logo-div menuItemAlign verticallyCenterFlexContent']")
    WebElement homeLogoButton;
    @FindBy(xpath = "//div[@class='searchInputNode']//input[@id='search-box-input']")
    WebElement searchBar;
    @FindBy(xpath = "//div[@class='searchInputNode']//button[@class='inline-block SearchButton clickable float-right']" + "//*[local-name()='svg']")
    WebElement searchButton;
    @FindBy(xpath = "//div[@class='item-row clickable']")
    WebElement sunnyvale;

    @FindBy(xpath = "//h1[contains(text(),'Sunnyvale Homes for Sale')]")
    WebElement sunnyvaleHomesForSale;
    @FindBy(xpath = "//h1[contains(text(),'Sunnyvale Real Estate')]")
    WebElement sunnyvaleRealEstate;
    @FindBy(xpath = "//input[@id='search-box-input']")
    WebElement searchBox;
    @FindBy(className = "textContent")
    WebElement sunnyvaleTextBox;
    @FindBy(xpath = "//span[contains(text(),'No min')]")
    WebElement minBox;
    @FindBy(xpath = "//span[contains(text(),'No max')]")
    WebElement maxBox;
    @FindBy(xpath = "//span[contains(text(),'$850k')]")
    WebElement eightFifty;
    @FindBy(xpath = "//span[contains(text(),'$950k')]")
    WebElement nineFifty;
    @FindBy(xpath = "//span[@class='modeOptionInnard table']")
    WebElement tableButton;

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

        Map<String, String> map = new HashMap<>();
        map.put("small", "uri");
        map.put("medium", "uri");
    }

    public boolean isMainLogoVisible()
    {
        log.info("Verifying main logo is available.");
        return Commons.isElementVisible(driver, homeLogoButton, 3);
    }

    public String getPageTitle()
    {
        log.info("Getting title");
        return Commons.getElementText(driver, pageTitle, 3);
    }

    public String verifySecondPage()
    {
        log.info("Getting title of second page");
        JSUtil.drawBorder(sunnyvaleHomesForSale, driver);
        return Commons.getElementText(driver, sunnyvaleHomesForSale, 3);
    }

    public void getToRealEstatePage()
    {
        searchBar.sendKeys("Sunnyvale");
        Commons.clickOnElement(driver, searchButton);
        Commons.clickOnElement(driver, sunnyvale);
    }

    public String confirmSunnyvaleTextBox()
    {
        log.info("highlighting element");
        JSUtil.drawBorder(sunnyvaleTextBox, driver);
        Commons.clickOnElement(driver, sunnyvaleTextBox);
        return Commons.getElementText(driver, sunnyvaleTextBox);
    }

    public void gatherPrices()
    {
        Commons.clickOnElement(driver, minBox);
        Commons.clickOnElement(driver, eightFifty);
        Commons.clickOnElement(driver, maxBox);
        Commons.clickOnElement(driver, nineFifty);
        Commons.clickOnElement(driver, tableButton);
        //JSUtil.drawBorder(table, driver);

        WebElement tableList = driver.findElement(By.className("tableList"));
        log.info("the table size is: " + tableList.getSize());
        JSUtil.drawBorder(tableList, driver);
        log.info("the text in the table is: " + tableList.getText());

        //this gets one full row of the results
        WebElement tableRow = driver.findElement(By.id("ReactDataTableRow_0"));
        log.info("the table has " + tableRow.getText());

        JSUtil.drawBorder(tableRow, driver);
        List<String> texts = new ArrayList<>();
        for(String s: texts)
        {
            log.info(s);
        }
        /*List<WebElement> column = tableList.findElements(By.className("column column_3 col_price"));
        for (WebElement el : column)
        {

            String location = el.getText().toLowerCase();
            //Commons.isElementVisible(driver, div, 3);
            *//*if (location.contains("sunnyvale") || location.contains("santa clara"))
            {
                log.info("Homes exists for the searched condition");
                log.info("Location identified successfully");
            } else
            {
                log.info("There is no data to test");

            }*//*

            log.info(location);
        }*/




    }
}
