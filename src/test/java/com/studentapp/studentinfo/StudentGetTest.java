package com.studentapp.studentinfo;

import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class StudentGetTest extends TestBase {

    @Test
    public void getAllStudentInfo() {
        Response response = given()//stored the response in variable named "response" of Response Interface
                .when()
                .get("/list");

        response.then().statusCode(200);//validating the response
        response.prettyPrint(); // printing the response in the console


    }

    @Test
    public void getSingleStudentsInfo() {
//        Response response = given()//stored the response in variable named "response" of Response Interface
//                .when()
//                .get("/3");
//
//        response.then().statusCode(200);//validating the response
//        response.prettyPrint(); // printing the response in the console


        //using path parameter
        Response response = given()//stored the response in variable named "response" of Response Interface
                .pathParam("id", 5)
                .when()
                .get("/{id}");

        response.then().statusCode(200);//validating the response
        response.prettyPrint(); // printing the response in the console
    }

    @Test
    public void searchStudentWithQueryParameter() {
        Response response = given()//stored the response in variable named "response" of Response Interface
                .queryParam("programme", "Financial Analysis") //first query param
                .queryParam("limit", 2)                 //second query param
                .when()
                .get("/list");

        response.then().statusCode(200);//validating the response
        response.prettyPrint(); // printing the response in the console

    }

    @Test
    public void searchStudentWithQueryParameterUsingMap() {
        HashMap<String, Object> qParams = new HashMap<>();
        qParams.put("programme", "Financial Analysis");
        qParams.put("limit", 3);

        Response response = given()//stored the response in variable named "response" of Response Interface
//                .queryParam("programme", "Financial Analysis") //first query param
//                .queryParam("limit", 2)                 //second query param
                .queryParams(qParams)
                .when()
                .get("/list");

        response.then().statusCode(200);//validating the response
        response.prettyPrint(); // printing the response in the console

    }

}
