package com.api.base;


import com.api.model.Request.ProfileRequest;
import io.restassured.response.Response;

public class UserService extends BaseService{
    private static final String BASE_PATH="/api/users";

    public Response getProfile(String token){
        setAuthToken(token);
        return getRequest(BASE_PATH+"/profile");
    }

    public Response updateUserProfile(String token, ProfileRequest payload){
        setAuthToken(token);
        return putRequest(payload,BASE_PATH+"profile");
    }

}
