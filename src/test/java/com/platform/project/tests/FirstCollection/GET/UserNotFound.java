package com.platform.project.tests.FirstCollection.GET;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

public class UserNotFound
{
    @Test
    public void userNotFound()
    {
        String baseURI = "https://reqres.in/api/users/";

        when().get(baseURI + 23)
                .then()
                .statusCode(404)
                .and()
                .assertThat().statusLine("HTTP/1.1 404 Not Found");
    }

}
