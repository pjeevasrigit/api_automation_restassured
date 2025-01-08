package com.api.tests;

import com.api.base.AuthenticationService;
import com.api.model.Request.SignupRequest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ForgotPasswordTest {
    @Test
    public void LoginAPITest() {

       AuthenticationService authenticationService=new AuthenticationService();
       Response response = authenticationService.forgotPassword("test@gmail.com");
       System.out.println(response.asPrettyString());
    }
}