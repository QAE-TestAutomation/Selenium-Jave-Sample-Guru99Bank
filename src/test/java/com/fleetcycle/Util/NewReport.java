package com.fleetcycle.Util;

/*
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;*/

public class NewReport extends Email {
  /*  
    public ExtentReports extentReports;
    public ExtentTest logger;
    public static String reportName;
    public static String reportPath;
    
    public ExtentReports configExtentReport(String reportPath) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
        // create ExtentReports and attach reporter(s)
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        //extentReports.addSystemInfo("Environment","Guru99Bank-Stage");
        return extentReports;
    }
    
    public ExtentTest startTest(String testName) {
        //return logger = extentReports.startTest(testName);
        logger = extentReports.createTest(testName);
        return logger;
    }
    
    public void endTest(ExtentTest extentTest) {
        extentReports.removeTest(extentTest);
    }

    public void pass(String passMessage){
        logger.log(Status.PASS, passMessage);
    }
    
    public void fail(String failMessage){
        try {
            logger.log(Status.FAIL, failMessage + logger.addScreenCaptureFromPath(new Util().screenShot()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void closeTest() {
        extentReports.flush();
        afterTest();
    }*/
}
