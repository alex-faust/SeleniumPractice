package com.platform.project.pageObjects;

import com.platform.project.commons.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RedfinHomePage
{
    @FindBy(className = "brandText")
    WebElement pageTitle;
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

    public String getClassName()
    {
        log.info("Getting class name.");
        return Commons.getElementClassName(driver, pageTitle, 3);
    }
}
