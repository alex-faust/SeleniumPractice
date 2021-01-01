package com.platform.project.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TabPractice
{
    @Test
    public void openNewTab()
    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.get("www.google.com");
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
    }
}
