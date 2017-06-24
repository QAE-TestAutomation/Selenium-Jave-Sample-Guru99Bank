package com.fleetcycle.Util;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;

import com.fleetcycle.Interface.IUtil;

/**
 * Util Class holds all common actions.
 * @author shivaprasad.b
 * @version 1.0
 */
public class Util extends Report implements IUtil{
	
    WebDriver webDriver = null;

    public static String CURRENTDIR = System.getProperty("user.dir") + "\\test-output";
    public static String filename = System.getProperty("user.dir")+"\\TestData\\Selection_Customer.xls";
    public boolean value;
    static DateFormat dateFormat = new SimpleDateFormat("dd_MM_yy_HH_mm");
    static Date date = new Date();
    static String datestring = dateFormat.format(date);
    public int BOWFlag = 0;

    //File Locations to capture screenshots and results 
    public static String STRDIRECTORY = CURRENTDIR + "\\Automation_Result_" + datestring;
    public static String SCREENSHOTFOLDER = STRDIRECTORY + "\\Screen shots";
    public static String EXCELREPORTFOLDER = STRDIRECTORY + "\\SmokeTest_Result_Excel";
    public static String FILEPATH = STRDIRECTORY + "\\SmokeTest_Result_Excel";
    public static String REPORTPATH = STRDIRECTORY + "\\AutomationResult.html";

    static {
        String driversPath = ".\\src\\resource";
        //Chrome 54
        System.setProperty("webdriver.chrome.driver", driversPath + "\\chromedriver.exe");
        // IE 11
        System.setProperty("webdriver.ie.driver", driversPath + "\\IEDriverServer.exe");
        // Search - Setting > System > About - OS Build 10586.962
        System.setProperty("webdriver.edge.driver", driversPath + "\\MicrosoftWebDriver.exe");
        // Opera 45
        System.setProperty("webdriver.opera.driver", driversPath + "\\operadriver.exe");
        // Safari 5 - no update for windows
        System.setProperty("webdriver.safari.driver", driversPath + "\\safari.exe");
        // Firefox - 54
        System.setProperty("webdriver.gecko.driver", driversPath + "\\geckodriver.exe");
    }
    
    /**
     * Select respective browser on selection.
     * Used java 1.8 to use switch statement for string
     * @return {@link WebDriver}
     */
    @Override
    public WebDriver selectBrowser(String browserName){
        switch (browserName.toLowerCase()) {
        case "chrome":
            webDriver = new ChromeDriver();
            break;
        case "ie":
            webDriver = new InternetExplorerDriver();
            break;
        case "edge":
            webDriver = new EdgeDriver();
            break;
        case "opera":
            webDriver = new OperaDriver();
            break;
        case "safari":
            webDriver = new SafariDriver();
            break;
        case "firefox":
            webDriver = new FirefoxDriver();
            break;
        default:
            break;
        }
        // Maximize the window
        webDriver.manage().window().maximize();
        //delete the cookies
        webDriver.manage().deleteAllCookies();
        return webDriver;
    }   
    
    /**
     * Holds webelement.
     * @param element elementCritera <br> Ex: By.id("xyz");
     * @return {@link WebElement}
     */
    @Override
    public WebElement getElement(By element) {
        return webDriver.findElement(element);
    }

    /**
     * Returns list of webelements.
     * @param element elementCritera <br> Ex: By.id("xyz");
     * @return {@link WebElements}
     */
    @Override
    public List<WebElement> getElements(By element) {
        return webDriver.findElements(element);
    }
    
    /**
     * Enters text in to text box.
     * @param webElement webElement
     * @param textToEnter textToEnter
     */
    @Override
    public void enterTextIntoTextBox(WebElement webElement,String textToEnter) {
        clickOnElement(webElement);
        clearTextBox(webElement);
        webElement.sendKeys(textToEnter);
    }
    
    @Override
    public void clickOnElement(WebElement webElement){
        webElement.click();
    }

    
    @Override
    public void clearTextBox(WebElement webElement) {
        webElement.clear(); 
    }

    @Override
    public void waitForSpecificTime(long millisecondsToWait){
        try {
            Thread.sleep(millisecondsToWait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void assertEquals(String expected,String actual){
        Assert.assertEquals(expected, actual);
    }

    @Override
    public void assertNotEquals(String expected,String actual){
        Assert.assertNotEquals(expected, actual);
    }

    @Override
    public void navigateTo(String url){
        webDriver.navigate().to(url);
    }

    @Override
    public void setUp() {
        createFolder();
        configExtentReport(REPORTPATH);
        Project project = new Project();
        selectBrowser(project.getBrowser());
        navigateTo(project.getUrl());
    }

    @Override
    public String getPageTitle() {
        return webDriver.getTitle().trim();
    }

    @Override
    public void acceptAlert() {
        waitForSpecificTime(1000);
        Alert alert = webDriver.switchTo().alert();
        alert.accept();
    }

    @Override
    public void dimissAlert() {
        Alert alert = webDriver.switchTo().alert();
        alert.dismiss();
    }

    /**
     * Get value present in text box.
     * @return String - value in text box.
     */
    @Override
    public String getTextBoxValue(WebElement webElement) {
        return webElement.getAttribute("value");
    }

    /**
     * Quit the webdriver instance, Close the extent report.
     */
    @Override
    public void closeSession() {
        webDriver.quit();
        closeTest();
        garbageClean();
    }

    /**
     * Gets current url.
     * @return String - url
     */
    @Override
    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    /**
     * Navigates to back.
     */
    @Override
    public void navigateToBack() {
        webDriver.navigate().back();
    }

    /**
     * Navigate forward.
     */
    @Override
    public void navigateForward() {
        webDriver.navigate().forward();
    }

    /**
     * Refresh the page.
     */
    @Override
    public void refreshPage() {
        webDriver.navigate().refresh();
    }

    /**
     * A garbage clean.
     */
    private void garbageClean() {
        Runtime runtime = Runtime.getRuntime();
        long maxMemory = runtime.maxMemory();
        long allocatedMemory = runtime.totalMemory();
        System.gc();
        long freeMemory = runtime.freeMemory();
        System.out.print("Max Memory: " + maxMemory);
        System.out.print(" Allocated Memory: " + allocatedMemory);
        System.out.println(" Free Memory: " + freeMemory);
    }

    /**
     * Create respective folders.
     */
    @Override
    public void createFolder() {
        try {
            // Create one directory
            boolean success = (new File(STRDIRECTORY)).mkdir();
            if (success) {
                System.out.println("Directory: " + STRDIRECTORY + " created");
            }
            boolean success1 = (new File(SCREENSHOTFOLDER)).mkdir();
            if (success1) {
                System.out.println("Directory: " + SCREENSHOTFOLDER + " created");
            }
        /*    boolean success2 = (new File(EXCELREPORTFOLDER)).mkdir();
            if (success2) {
                System.out.println("Directory: " + EXCELREPORTFOLDER + " created");
            }*/
        } catch (Exception e) { //Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    /**
     * Capture screenshot.
     */
    @Override
    public String screenShot() {
      //take screenshot and save it in a file
        String img = SCREENSHOTFOLDER + "\\FailedStep_screenshot_" + System.currentTimeMillis() + ".jpg";
        try { 
            Robot robot = new Robot();
            BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ImageIO.write(screenShot, "JPG", new File(img));
        } catch (Exception e) { //if it fails to take screenshot then this block will execute
            System.out.println("Failure to take screenshot ");
        }
        return img;
    }

    @Override
    public Project mapData(String fileName) {
        // TODO Auto-generated method stub
        return null;
    }
}
