package com.api.tests;

import com.api.base.AuthenticationService;
import com.api.base.UserService;
import com.api.model.Request.LoginRequest;
import com.api.model.Response.LoginResponse;
import com.api.model.Response.UserProfileResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetProfileTest {
    @Test
    public void getProfileTest(){
        AuthenticationService authenticationService=new AuthenticationService();
        Response response = authenticationService.login(new LoginRequest("uday1234","uday1234"));
        LoginResponse loginResponse=response.as(LoginResponse.class);
        System.out.println(loginResponse.getToken());


        UserService userService=new UserService();
        response = userService.getProfile(loginResponse.getToken());
        UserProfileResponse userProfileResponse=response.as(UserProfileResponse.class);
        System.out.println(userProfileResponse.getUsername());
    }
}
