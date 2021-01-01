package com.platform.project.tests.GET;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;


public class Demo1_GET
{


    @Test
    public void getWeatherDetails()
    {
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";
        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET, "Hyderabad");


        String responseBody = response.getBody().asString();
        System.out.println(responseBody);

        //pretty print
        //Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //System.out.println(gson.toJson(rq));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);

        //status line verification
        String statusLine = response.getStatusLine();
        System.out.println("Status line is: " + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
    }

    @Test
    public void getWeatherDetails1()
    {
        String baseURI = " http://restapi.demoqa.com/utilities/weather/city/";

        when().get(baseURI + "Hyderabad")
                .then()
                .statusCode(200)
                .assertThat().body("Wind Direction degree", equalTo("270 Degree"))
                .and()
                .assertThat().statusLine("HTTP/1.1 200 OK");
    }
}
