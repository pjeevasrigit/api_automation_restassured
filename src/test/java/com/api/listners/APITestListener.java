package com.api.listners;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class APITestListener implements ITestListener {
    private static final Logger logger= LogManager.getLogger(APITestListener.class);


    public void onTestSkipped(ITestResult result) {
        logger.info("Test Suite Skipped");
    }
    public void onStart(ITestContext context) {
        logger.info("Test Suite Started");
    }
    public void onFinish(ITestContext context) {
        logger.info("Test Suite Finished");
    }

    public void onTestSuccess(ITestResult result){
        logger.info("Passed!!!"+result.getMethod().getMethodName());
        logger.info("Description!!"+result.getMethod().getDescription());
    }

    public void onTestFailure(ITestResult result){
        logger.info("Failure!!!"+result.getMethod().getMethodName());
        logger.info("Description!!"+result.getMethod().getDescription());
    }

    public void onTestStart(ITestResult result){
        logger.info("Test Started!!!"+result.getMethod().getMethodName());
    }



}
