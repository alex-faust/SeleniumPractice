package com.platform.project.steps;

import com.platform.project.commons.TestContext;
import org.junit.After;
import org.junit.Before;

public class Hooks
{
    TestContext testContext;

    public Hooks(TestContext context)
    {
        testContext = context;
    }

    @Before
    public void BeforeSteps() { }

    @After
    public void AfterSteps()
    {
        testContext.getWebDriverManager().quitDriver();
    }
}


