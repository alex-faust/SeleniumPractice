package com.platform.project.steps;

import com.platform.project.commons.Commons;
import com.platform.project.commons.TestContext;
import com.platform.project.pageObjects.RedfinHomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class RedfinHomePageSteps
{
    WebDriver driver;
    RedfinHomePage redfinHomePage;
    TestContext testContext;

    public RedfinHomePageSteps(TestContext context)
    {
        testContext = context;
        driver = testContext.getWebDriverManager().getDriver();
        redfinHomePage = testContext.getPageObjectManager().getRedfinHomePage();
    }


    @Given("^I open the home page$")
    public void openHomePage()
    {
        redfinHomePage.openHomePage();
    }

    @Then("^Check that the home page logo is visible$")
    public void verifyHomePageLogo()
    {
        Commons.check(driver, redfinHomePage.isMainLogoVisible(),
                "The redfin homepage did not load.");
    }

    @When("^I get to the real estate page$")
    public void openSunnyvalePage()
    {
        redfinHomePage.getToRealEstatePage();
    }

    @Then("^I verify that I am taken to the sunnyvale page$")
    public void verifySunyvalePage()
    {

    }

}
