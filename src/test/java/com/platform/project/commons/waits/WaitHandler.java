package com.platform.project.commons.waits;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitHandler
{
    private static Logger log = Logger.getLogger(WaitHandler.class);
    private final WebDriver driver;

    public WaitHandler(WebDriver driver) {
        this.driver = driver;
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
