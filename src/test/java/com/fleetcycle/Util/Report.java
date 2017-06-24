package com.fleetcycle.Util;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Report extends Email {
	
	public static ExtentReports extentReports;
	public ExtentTest logger;
	public static String reportName;
	public static String reportPath;
	
	public ExtentReports configExtentReport(String reportPath) {
		extentReports = new ExtentReports(reportPath, true);
		extentReports.addSystemInfo("Environment","Guru99Bank-Stage");
		return extentReports;
	}
	
	public ExtentTest startTest(String testName) {
		return logger = extentReports.startTest(testName);
	}
	
	public void endTest(ExtentTest extentTest) {
		extentReports.endTest(extentTest);
	}

	public void pass(String passMessage){
		logger.log(LogStatus.PASS, passMessage);
	}
	
	public void fail(String failMessage){
	    logger.log(LogStatus.FAIL, failMessage + logger.addScreenCapture(new Util().screenShot()));
	}
	
	public void closeTest() {
		extentReports.flush();
		extentReports.close();
		afterTest();
	}
}
