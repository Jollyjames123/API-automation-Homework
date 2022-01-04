package com.studentapp.homework;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class HomeworkAssertionStores {

    public static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }

    //1. Verify the if the total is equal to 1561
    @Test
    public void test001() {
        response.body("total", equalTo(1561));
    }

    //2. Verify the if the stores of limit is equal to 10
    @Test
    public void test002() {
        response.body("limit", equalTo(10));
    }

    //3. Check the single ‘Name’ in the Array list (Burnsville)
    @Test
    public void test003() {
        response.body("data.name", hasItem("Burnsville"));
    }

    //4. Check the multiple ‘Names’ in the ArrayList (Burnsville, Rochester, Minnetonka)
    @Test
    public void test004() {
        response.body("data.name", hasItems("Burnsville","Minnetonka","Rochester"));
    }

    //5. Verify the storied inside storeservices of the third store of second services
    @Test
    public void test005() {
        response.body("data[2].services[1].storeservices.storeId", equalTo(7));
    }

    //6. Check hash map values ‘createdAt’ inside storeservices map where store name = Burnsville
    @Test
    public void test006() {
        response.body("data.findAll{it.name=='Burnsville'}.services.storeservices", hasItem(hasItem(hasKey("createdAt"))));
    }

    //7. Verify the state = MN of third store
    @Test
    public void test007() {
        //response.body("data.findAll{it.name=='Roseville'}", hasItem(hasEntry("state", "MN")));
        response.body("data[2]", hasEntry("state", "MN"));
        //response.body("data[2]", hasValue("MN"));
    }

    //8. Verify the name = Rochester of 9th store
    @Test
    public void test008() {
        //response.body("data.findAll{it.name=='Rochester'}", hasItem(hasEntry("name", "Rochester")));
        response.body("data[8]", hasEntry("name", "Rochester"));
        //response.body("data[8].name", equalToIgnoringCase("rochester"));
    }

    //9. Verify the storeId = 11 for the 6th store
    @Test
    public void test009(){
        //response.body("data[5].services[0].storeservices", hasValue(11));
        response.body("data[5].services[0].storeservices", hasEntry("storeId", 11));
    }

    //10. Verify the serviceId = 14 for the 8th store
    @Test
    public void test010(){
        response.body("data[7].services[9].storeservices",hasEntry("serviceId",11));

    }
}
