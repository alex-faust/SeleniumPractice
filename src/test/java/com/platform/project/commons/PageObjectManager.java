package com.platform.project.commons;

import com.platform.project.pageObjects.RedfinHomePage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager
{
    private WebDriver driver;
    private RedfinHomePage redfinHomePage;

    public PageObjectManager(WebDriver driver)
    {
        this.driver = driver;
    }

    public RedfinHomePage getRedfinHomePage()
    {
        return (redfinHomePage == null) ? redfinHomePage = new RedfinHomePage(driver) : redfinHomePage;
    }
}
