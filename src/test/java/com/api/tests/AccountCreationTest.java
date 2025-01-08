package com.api.tests;

import com.api.base.AuthenticationService;
import com.api.model.Request.LoginRequest;
import com.api.model.Request.SignupRequest;
import com.api.model.Response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountCreationTest {
    @Test
    public void LoginAPITest() {

        SignupRequest signupRequest = new SignupRequest.Builder().username("DishaUser")
                .email("disha@gmail.com")
                .firstName("Disha")
                .lastName("test")
                .password("1234")
                .mobileNumber("9894455077")
                .build();


        AuthenticationService authenticationService=new AuthenticationService();
        Response response = authenticationService.sighUp(signupRequest);
        System.out.println(response.asPrettyString());
        System.out.println("------");

        //Assert.assertEquals(loginResponse.getEmail(),"rish@gmail.com");
    }
}