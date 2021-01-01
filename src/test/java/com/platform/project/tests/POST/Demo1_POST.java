package com.platform.project.tests.POST;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo1_POST
{
    @Test
    public void registrationSuccessful()
    {
        RestAssured.baseURI = "http://restapi.demoqa.com/customer/";
        RequestSpecification httpRequest = RestAssured.given();

        //request payload sending along with post request
        JsonObject requestParams = new JsonObject();
        //JsonObject rq = new JsonObject();

        requestParams.addProperty("FirstName", "JohnXYZ");
        requestParams.addProperty("LastName", "XYZJohn");
        requestParams.addProperty("UserName", "JohnXYZ");
        requestParams.addProperty("Password", "JohnXYZ");
        requestParams.addProperty("Email", "JohnXYZ");

        //rq.add("user 1", requestParams);


        //add header
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams);


        //pretty print
        //Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //System.out.println(gson.toJson(rq));


        Response response = httpRequest.request(Method.POST, "register");



        String responseBody = response.getBody().asString();
        System.out.println("Response body is: " + responseBody);

        //status code validation
        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);

        //status line verification
        String statusLine = response.getStatusLine();
        System.out.println("Status line is: " + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 201 OK");



    }
}
