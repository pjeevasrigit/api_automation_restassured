package com.api.tests;

import com.api.base.AuthenticationService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class LoginAPITest_2 {
    @Test
    public void LoginAPITest() {
        AuthenticationService authenticationService=new AuthenticationService();
       // Response response = authenticationService.login("{\"username\": \"uday1234\",\"password\": \"uday1234\"}");


       // System.out.println(response.asPrettyString());
    }
}