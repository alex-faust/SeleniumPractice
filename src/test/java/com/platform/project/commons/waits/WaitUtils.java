package com.platform.project.commons.waits;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitUtils
{
    private static Logger log = Logger.getLogger(WaitHandler.class);
    private final WebDriver driver;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    public static void sleep(int timeoutInSeconds)
    {
        try
        {
            Thread.sleep(timeoutInSeconds * 1000);
        } catch (final InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void waitForVisibilityOfElement(WebElement element) {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibilityOfElement(WebElement element, int timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element, int timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForInVisibilityOfElement(WebElement element) {
        new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitImplicitlyInSeconds(int timeout){
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }
}