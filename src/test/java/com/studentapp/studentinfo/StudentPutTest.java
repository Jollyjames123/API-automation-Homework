package com.studentapp.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class StudentPutTest extends TestBase {

    //HOMEWORK

    @Test
    public void updateStudentWithPut(){

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("DONALD");
        studentPojo.setEmail("abc1@gmail.com");
        studentPojo.setProgramme("Computer Science");

        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id", 2)
                .body(studentPojo)

                .when()
                .put("/{id}");

        response.then().statusCode(200);
        response.prettyPrint();
    }

}
