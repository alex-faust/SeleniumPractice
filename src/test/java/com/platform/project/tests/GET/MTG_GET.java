package com.platform.project.tests.GET;

import org.junit.Before;
import org.junit.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class MTG_GET
{
    @BeforeClass
    public void setUp()
    {
        //String baseURI = "https://api.scryfall.com/";
    }
    @Test
    public void getSingleCard()
    {
        String baseURI = "https://api.scryfall.com/";

        when().get(baseURI + "cards/named?fuzzy=fireball")
                .then()
                .statusCode(200)
                .and()
                .assertThat().body("name", equalTo("Fireball"))
                .assertThat().statusLine("HTTP/1.1 200 OK");
    }
    @Test
    public void getCardList()
    {
        String baseURI = "https://api.scryfall.com/";
        List<Object> ar = given().when().get(baseURI + "cards/autocomplete?q=fire")
                .then()
                .statusCode(200)
                .and()
                .extract().body().jsonPath().getList("data");

        //ar.forEach(System.out::println);

        when().get(baseURI + "cards/autocomplete?q=fire")
                .then()
                .statusCode(200)
                .and()
                .assertThat().body("data", hasItem("Fire // Ice"))
                .assertThat().statusLine("HTTP/1.1 200 OK");
    }
}
