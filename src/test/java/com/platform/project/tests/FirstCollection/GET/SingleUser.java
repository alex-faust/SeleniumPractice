package com.platform.project.tests.FirstCollection.GET;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

public class SingleUser
{
    @Test
    public void singleUserA()
    {
        RestAssured.baseURI = "https://reqres.in/api/users";
        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET, "3");

        String responseBody = response.getBody().asString();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);

        //status line verification
        String statusLine = response.getStatusLine();
        System.out.println("Status line is: " + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

        //String firstName = responseBody.
    }

    @Test
    public void singleUserB()
    {
        String baseURI = "https://reqres.in/api/users/";

        when().get(baseURI + 3)
                .then()
                .statusCode(200)
                .and()
                .assertThat().body("data.first_name", equalTo("Emma"))
                .assertThat().statusLine("HTTP/1.1 200 )K");
    }
}
