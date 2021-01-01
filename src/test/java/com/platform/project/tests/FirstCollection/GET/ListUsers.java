package com.platform.project.tests.FirstCollection.GET;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.*;

public class ListUsers
{
    @Test
    public void listUsers()
    {
        String baseURI = "https://reqres.in/api/users/";
        String perPage = "2";
        String pageNumber = "2";

        when().get(baseURI + "?" + pageNumber + "&" + perPage)
                .then()
                .statusCode(200)
                .and()
                .assertThat().body("data.findAll {it}.first_name", hasItems("Emma", "Eve"))
                .assertThat().statusLine("HTTP/1.1 200 OK");
    }

}
