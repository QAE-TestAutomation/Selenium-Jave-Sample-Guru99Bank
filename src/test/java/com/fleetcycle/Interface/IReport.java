package com.fleetcycle.Interface;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public interface IReport extends IUtil{
    
    public ExtentReports configExtentReport(String reportPath);
    
    public ExtentTest startTest(String testName);
    
    public void endTest(ExtentTest extentTest);

    public void pass(String passMessage);
    
    public void fail(String failMessage);
    
    public void closeTest();
}
