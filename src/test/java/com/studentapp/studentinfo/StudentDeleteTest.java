package com.studentapp.studentinfo;

import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class StudentDeleteTest extends TestBase {

    //HOMEWORK

    @Test
    public void deleteStudent(){

       Response response=  given()
                .pathParam("id", 2)
                .when()
                .delete("/{id}");
                response.then().statusCode(204);
                response.prettyPrint();
    }


}
