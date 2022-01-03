package com.studentapp.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class StudentPatchTest extends TestBase {

    @Test
    public void updateStudentWithPatch(){

        StudentPojo studentPojo = new StudentPojo(); //creating object of the Pojoclass
        studentPojo.setEmail("primetesting2@gmail.com"); //only updating email

        Response response = given()//stored the response in variable named "response" of Response Interface
                .header("Content-Type", "application/json")
                .pathParam("id", 103) // path parameter
                .body(studentPojo)
                .when()
                .patch("/{id}");

        response.then().statusCode(200);//validating the response
        response.prettyPrint(); // printing the response in the console




    }
}
