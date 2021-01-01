package com.platform.project.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class FirstCollectRestAssuredTest
{
    String link = "https://reqres.in/api/users/";
    String pageNumber = "2";

    @Test
    public void getFirstName()
    {
        get(link + "3").then().statusCode(200)
             .assertThat().body("data.first_name",equalTo("Emma"));
    }

    @Test
    public void statusCode200()
    {
        get(link).then().
                assertThat().statusCode(200);
    }
    @Test
    public void userNotFound()
    {
        when().
                get(link + "23").
        then().
                assertThat().statusCode(404);
    }

    @Test
    public void listUsers()
    {
        get(link + "?page=2&per_page=2").then().statusCode(200)
                .assertThat().body("per_page", equalTo(2));
    }
    
}
