package com.api.filters;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;


import java.util.logging.LogRecord;

public class LoggingFilter implements Filter {
private static final Logger logger=LogManager.getLogger(LoggingFilter.class);

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext filterContext) {
       logRequest(requestSpec);
        Response response = filterContext.next(requestSpec,responseSpec);
        logResponse(response);
        return response;
    }

    public void logRequest(FilterableRequestSpecification requestSpec)
    {
    logger.info("Base URI"+requestSpec.getBaseUri());
        logger.info("Request Header"+requestSpec.getHeaders());
        logger.info("Body"+requestSpec.getBody());
    }

    public static void logResponse(Response response){
    logger.info("Status code"+response.getStatusCode());
    logger.info("Response Header"+response.getHeaders());
    logger.info("Request Body"+response.getBody().prettyPrint());
    }
}
