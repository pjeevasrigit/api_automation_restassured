package com.api.tests;

import com.api.base.AuthenticationService;
import com.api.base.UserService;
import com.api.model.Request.LoginRequest;
import com.api.model.Request.ProfileRequest;
import com.api.model.Response.LoginResponse;
import com.api.model.Response.UserProfileResponse;
import com.beust.ah.A;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateProfileTest {
    @Test
    public void updateProfileTest(){
        AuthenticationService authenticationService=new AuthenticationService();
        Response response = authenticationService.login(new LoginRequest("uday1234","uday1234"));
        LoginResponse loginResponse=response.as(LoginResponse.class);
        System.out.println(loginResponse.getToken());

        System.out.println("__________________________________________");

        UserService userService=new UserService();
        response = userService.getProfile(loginResponse.getToken());
        System.out.println(response.asPrettyString());

        UserProfileResponse userProfileResponse=response.as(UserProfileResponse.class);
        Assert.assertEquals(userProfileResponse.getUsername(),"uday1234");
        System.out.println(userProfileResponse.getUsername());
        System.out.println("__________________________________________");

        ProfileRequest profileRequest=new ProfileRequest.Builder()
                .firstName("Disha")
                .lastName("Bhat")
                .email("disha@gmail.com")
                .mobileNumber("9894455077")
                .build();

        response =  userService.updateUserProfile(loginResponse.getToken(), profileRequest);
        System.out.println(response.asPrettyString());




    }
}
