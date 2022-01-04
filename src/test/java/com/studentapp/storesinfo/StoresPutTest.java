package com.studentapp.storesinfo;
import io.restassured.response.Response;
import com.studentapp.model.StorePojo;
import com.studentapp.testbase.TestBase1;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoresPutTest extends TestBase1 {

    @Test
    public void test001() {

        StorePojo storePojo = new StorePojo();
        storePojo.setName("Harrow");
        storePojo.setType("BigBox");
        storePojo.setAddress("12 1st Street A");
        storePojo.setAddress2("");
        storePojo.setCity("London");
        storePojo.setState("MN");
        storePojo.setZip("256879");
        storePojo.setLat(44.879314);
        storePojo.setLng(93.077156);
        storePojo.setHours("Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8");

        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id",4)
                .body(storePojo)
                .when()
                .put("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
