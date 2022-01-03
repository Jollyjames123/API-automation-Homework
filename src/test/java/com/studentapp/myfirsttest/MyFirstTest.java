package com.studentapp.myfirsttest;

import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class MyFirstTest extends TestBase {
    @Test
    public void getAllStudentInfo() {
//        given()
//                .when()
//                .get("http://localhost:8080/student/list")
//                .then()
//                .statusCode(200);

        Response response = given()//stored the response in variable named "response" of Response Interface
                .when()
                // .get("http://localhost:8080/student/list");
                // we have declared all the baseURI,port,basePath in Testbase
                // so we are now only using endpoint below for the request
                .get("/list");

        response.then().statusCode(200);//validating the response
        response.prettyPrint(); // printing the response in the console

    }

}
