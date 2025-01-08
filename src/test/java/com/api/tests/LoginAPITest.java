package com.api.tests;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class LoginAPITest {
    @Test
    public void LoginAPITest() {
        //Utility class is a class where variables and methods are static, RestAssured is an utility class hence we dont
        //to create object for that class. Even Arrays are utility class
        //  'http://64.227.160.186:8080/api/auth/login' \
        baseURI = "http://64.227.160.186:8080";

        /*
        What is static import:
        normal import - import io.restassured.RestAssured;
        static import - import static io.restassured.RestAssured.*
        change the line from RestAssured.baseURI to
        RestAssured.given() to given() only -- remove class name is the use of static import
        it is used for better readability

         */

        Response response =given().header("Content-Type", "application/json")
                .body("{\"username\": \"uday1234\",\"password\": \"uday1234\"}").post("/api/auth/login");
        System.out.println(response.asPrettyString());

    }
}