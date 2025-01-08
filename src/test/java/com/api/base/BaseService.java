package com.api.base;

import com.api.filters.LoggingFilter;
import com.api.model.Request.LoginRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

//import static io.restassured.RestAssured.*;


public class BaseService {
    //creating wrapper on RestAssured
    //this provides abstraction
    private static final String BASE_URL="http://64.227.160.186:8080";
    private RequestSpecification requestSpecification;
    static {
        RestAssured.filters(new LoggingFilter());
    }

    public BaseService(){
        requestSpecification = given().baseUri(BASE_URL);
    }
    public Response postRequest(Object payload, String endpoint) {
        return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
    }

    public Response putRequest(Object payload, String endpoint) {
        return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);
    }

    public Response getRequest(String endpoint) {
        return requestSpecification.get(endpoint);
    }

    public void setAuthToken(String token){
        requestSpecification.header("Authorization", "Bearer "+token);
    }
}
