package com.api.tests;

import com.api.base.AuthenticationService;
import com.api.model.Request.LoginRequest;
import com.api.model.Response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.api.listners.APITestListener.class)
public class LoginAPITest_3 {
    @Test(description = "Verify Login API")
    public void LoginAPITest() {
        AuthenticationService authenticationService=new AuthenticationService();
        LoginRequest loginRequest=new LoginRequest("uday1234","uday1234");

        Response response = authenticationService.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);

        System.out.println(response.asPrettyString());
        System.out.println(loginResponse.getToken());
       // Assert.assertEquals(loginResponse.getEmail(),"rish@gmail.com");
    }
}