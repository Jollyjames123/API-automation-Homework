package com.studentapp.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class HomeworkExtraction {
    public static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then();
    }

    //1. Extract the limit
    @Test
    public void test001() {
        int limit = response.extract().path("limit");

        System.out.println("-------------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("-------------------------------");
    }

    //2. Extract the total
    @Test
    public void test002() {
        int total = response.extract().path("total");
        System.out.println("-------------------------------");
        System.out.println("The total is : " + total);
        System.out.println("-------------------------------");
    }

    //3. Extract the name of 5th store
    @Test
    public void test003() {
        String storeName = response.extract().path("data[4].name");
        System.out.println("------------------------------------");
        System.out.println("The name of the 5th store is : " + storeName);
        System.out.println("------------------------------------");
    }

    //4. Extract the names of all the store
    @Test
    public void test004() {
        List<String> storeNames = response.extract().path("data.name");
        System.out.println("------------------------------------");
        System.out.println("Names of all the stores are : " + storeNames);
        System.out.println("------------------------------------");
    }

    //5. Extract the storeId of all the store
    @Test
    public void test005() {
        List<Integer> storeIds = response.extract().path("data.id");
        System.out.println("------------------------------------");
        System.out.println("List of all the storeIds are : " + storeIds);
        System.out.println("------------------------------------");
    }

    //6. Print the size of the data list
    @Test
    public void test006() {
        List<HashMap<String, ?>> storeData = response.extract().path("data");
        System.out.println("------------------------------------");
        System.out.println("size of the shown data is : " + storeData.size());
        System.out.println("------------------------------------");
    }

    //7. Get all the value of the store where store name = Fargo
    @Test
    public void test007() {
        //List<HashMap<String, ?>> storeValue = response.extract().path("data.findAll{it.name=='Fargo'}");
        List<String> storeValue = response.extract().path("data.findAll{it.name=='Fargo'}");
        System.out.println("------------------------------------");
        System.out.println("All the value of the store is : " + storeValue);
        System.out.println("------------------------------------");
    }

    //8. Get the address of the store where store name = Maplewood
    @Test
    public void test008() {
        List<String> storeAddress = response.extract().path("data.findAll{it.name=='Maplewood'}.address");
        System.out.println("------------------------------------");
        System.out.println("The address of the store is : " + storeAddress);
        System.out.println("------------------------------------");
    }

    //9. Get all the services of 8th store
    @Test
    public void test009() {
        //List<String> storeAddress = response.extract().path("data[7].services");
        List<HashMap<String, ?>> storeServices = response.extract().path("data[7].services");
        System.out.println("------------------------------------");
        System.out.println("All the services of 8th store : " + storeServices);
        System.out.println("------------------------------------");
    }
    //10. Get storeservices of the store where service name = Sony Experience
    @Test
    public void test010() {
        List<HashMap<String, ?>> storeServices = response.extract().path("data.findAll{it.services.findAll{it.name=='Sony Experience '}}.services.storeservices");
        System.out.println("------------------------------------");
        System.out.println("Storeservices of the store where service name = Sony Experience : \n" + storeServices);
        System.out.println("------------------------------------");
    }

    //11. Get all the storeId of all the store
    @Test
    public void test011() {
        //List<HashMap<String, ?>> storeIds = response.extract().path("data.services.storeservices.storeId");
        List<String> storeIds = response.extract().path("data.services.storeservices.storeId");
        System.out.println("------------------------------------");
        System.out.println("The storeIds of all the stores are : " + storeIds);
        System.out.println("------------------------------------");
    }

    //12. Get id of all the store
    @Test
    public void test012() {
        List<HashMap<String, ?>> ids = response.extract().path("data.id");
        System.out.println("------------------------------------");
        System.out.println("The ids of all the stores are : " + ids);
        System.out.println("------------------------------------");
    }

    //13. Find the store names Where state = MN
    @Test
    public void test013() {
        List<HashMap<String, ?>> storeNames = response.extract().path("data.findAll{it.state=='MN'}.name");
        System.out.println("------------------------------------");
        System.out.println("The store names Where state = MN are : " + storeNames);
        System.out.println("------------------------------------");
    }


    //14. Find the Total number of services for the store where store name = Minnetonka
    @Test
    public void test014() {
        List<List<String>> services = response.extract().path("data.findAll{it.name=='Minnetonka'}.services.name");
        List<String> services1 = services.get(0);
        System.out.println("------------------------------------");
        System.out.println("The total number of services for the store where store name = Minnetonka are : " + services1.size());
        System.out.println("------------------------------------");
    }

    //15. Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void test015() {
        List<List<String>> createdAt = response.extract().path("data.findAll{it.services.findAll{it.name=='Windows Store'}}.services.createdAt");

        System.out.println("------------------------------------");
        System.out.println("the createdAt for all services whose name = Windows Store :\n" + createdAt);
        System.out.println("------------------------------------");
    }

    //16. Find the name of all services Where store name = “Inver Grove Heights”
    @Test
    public void test016() {
        List<String> servicesName = response.extract().path("data.findAll{it.name=='Inver Grove Heights'}.services.name");
        System.out.println("------------------------------------");
        System.out.println("The name of all services Where store name = “Inver Grove Heights” are : " + servicesName);
        System.out.println("------------------------------------");
    }
    //17. Find the zip of all the store
    @Test
    public void test017() {
        List<String> zip = response.extract().path("data.zip");
        System.out.println("------------------------------------");
        System.out.println("The zip of all the stores are : " + zip);
        System.out.println("------------------------------------");
    }
    //18. Find the zip of store name = Minnetonka
    @Test
    public void test018() {
        List<String> zip = response.extract().path("data.findAll{it.name=='Minnetonka'}.zip");
        System.out.println("------------------------------------");
        System.out.println("The zip of store name = Minnetonka : " + zip);
        System.out.println("------------------------------------");
    }
    //19. Find the storeservices details of the service name = Samsung Experience
    @Test
    public void test019() {
        List<String> storeServices = response.extract().path("data.findAll{it.services.findAll{it.name=='Samsung Experience'}}.services.storeservices");
        System.out.println("------------------------------------");
        System.out.println("The storeservices details of the service name = Samsung Experience :\n" + storeServices);
        System.out.println("------------------------------------");
    }

    //20. Find the lat of all the stores
    @Test
    public void test020() {
        List<HashMap<String,?>> lat = response.extract().path("data.lat");
        System.out.println("------------------------------------");
        System.out.println("The latitude of all the stores " + lat);
        System.out.println("------------------------------------");
    }
}
