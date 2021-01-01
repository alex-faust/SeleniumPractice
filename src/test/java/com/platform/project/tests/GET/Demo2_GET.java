package com.platform.project.tests.GET;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Demo2_GET
{
    @Test
    public void googleMapTest()
    {
        //specify base URI
        RestAssured.baseURI = "https://maps.googleapis.com/";

        //request object
        RequestSpecification httpRequest = RestAssured.given();

        //response object
        Response response = httpRequest.request(Method.GET, "maps/api/place/nearbysearch/" +
                "xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=" +
                "AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
    }
}
