package com.studentapp.storesinfo;

import com.studentapp.testbase.TestBase1;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class StoreDeleteTest extends TestBase1 {
    @Test
    public void test001(){
        Response response = given()
                .pathParam("id",10)
                .when()
                .delete("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
