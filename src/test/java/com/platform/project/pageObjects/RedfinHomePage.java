package com.platform.project.pageObjects;

import com.platform.project.commons.*;
import com.platform.project.commons.waits.WaitUtils;
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
        WaitUtils.sleep(3);
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

    public boolean gatherPrices()
    {
        Commons.clickOnElement(driver, minBox, 5);
        Commons.clickOnElement(driver, eightFifty, 5);
        Commons.clickOnElement(driver, maxBox, 5);
        Commons.clickOnElement(driver, nineFifty, 5);
        Commons.clickOnElement(driver, tableButton);

        WaitUtils.sleep(5);

        WebElement table = driver.findElement(By.xpath("//tbody"));
        List<WebElement> tables = table.findElements(By.tagName("tr"));
        ArrayList<Integer> prices = new ArrayList<>();

        boolean inRange = false;

        for (int i = 0; i < tables.size(); i++)
        {
            WebElement t = driver.findElement(By.xpath("//tbody/tr[@id='ReactDataTableRow_" + i + "']/td[4]"));
            if(prices.add(Integer.parseInt(Commons.getElementText(driver, t)
                    .substring(1)
                    .replace(",", "")
                    .replace("+", "")
                    .trim())));
        }

        for(int i = 0; i < prices.size(); i++)
        {
            if (prices.get(i) > 850000 || prices.get(i) < 950000)
            {
                log.info(prices.get(i) + "true");
                inRange = true;
            } else {
                inRange = false;
                break;
            }

        }

        return inRange;
    }

}
