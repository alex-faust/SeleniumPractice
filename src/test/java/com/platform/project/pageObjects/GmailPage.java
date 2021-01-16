package com.platform.project.pageObjects;

import com.platform.project.commons.ReadPropertyFile;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Set;

public class GmailPage
{
    private WebDriver driver;
    private JavascriptExecutor javascriptExecutor;
    private Logger log = Logger.getLogger(GmailPage.class);

    //login page
    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    WebElement signInButton;




    public GmailPage(WebDriver driver)
    {
        this.driver = driver;
        javascriptExecutor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void openHomePage()
    {
        log.info("Opening gmail home page");
        driver.get(ReadPropertyFile.getConfigPropertyVal("gmailHomePage"));
    }

    public void openNextPage()
    {
        signInButton.click();
    }


    public void openNewWindow(WebDriver driver) throws InterruptedException
    {
        String parent = driver.getWindowHandle();
        System.out.println("Parent window ID is: " + parent);
        driver.findElement(By.xpath("//a[contains(text(),'About')]")).click();
        driver.navigate().back();
        Set<String> allWindows = driver.getWindowHandles();

        int count = allWindows.size();
        System.out.println(count);

        for(String child: allWindows)
        {
            System.out.println("parent is: " + parent + " child is: " + child);

            if(!parent.equalsIgnoreCase(child))
            {
                System.out.println("parent is: " + parent + " child is: " + child);
                driver.switchTo().window(child);
                driver.findElement(By.tagName("input"))
                        .sendKeys("Selenium Web Driver");
                Thread.sleep(3000);
                driver.close();
            }
            System.out.println(child);
            System.out.println("Parent window title is: " + driver.getTitle());

        }

    }

    public void openNewWindows(WebDriver driver) throws InterruptedException
    {
        String parent = driver.getWindowHandle();
        System.out.println("Parent window ID is: " + parent);
        driver.findElement(By.xpath("//a[contains(text(),'About')]")).click();
        driver.navigate().back();

        WebElement body = driver.findElement(By.tagName("body"));
        body.sendKeys(Keys.chord(Keys.CONTROL, "n"));


        Set<String> allWindows = driver.getWindowHandles();



        int count = allWindows.size();
        System.out.println(count);

        for(String child: allWindows)
        {
            System.out.println("parent is: " + parent + " child is: " + child);

            if(!parent.equalsIgnoreCase(child))
            {
                System.out.println("parent is: " + parent + " child is: " + child);
                driver.switchTo().window(child);
                System.out.println("Child window is: " + driver.getTitle());

                Thread.sleep(3000);
                driver.close();
            }
            System.out.println(child);
            System.out.println("Parent window title is: " + driver.getTitle());

        }
    }

    public void openTabs(WebDriver driver)
    {
        driver.manage().window().maximize();

        ((JavascriptExecutor)driver).executeScript("window.open();");
        driver.navigate().to("facebook.com");

        
    }
}
