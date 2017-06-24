package com.fleetcycle.interfaceclass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface IUtil {

  public WebDriver selectBrowser(String browserName);

  public WebElement getElement(By element);

  public List<WebElement> getElements(By element);

  public void enterTextIntoTextBox(WebElement webElement, String textToEnter);

  public void clickOnElement(WebElement webElement);

  public void clearTextBox(WebElement webElement);

  public void waitForSpecificTime(long millisecondsToWait);

  public void assertEquals(String expected, String actual);

  public void navigateTo(String url);

  public void setUpSuite();

  public String getPageTitle();

  public void assertNotEquals(String expected, String actual);

  public void acceptAlert();

  public void dimissAlert();

  public String getTextBoxValue(WebElement webElement);

  public void closeSuite();
  
  public void setUpSession();
  
  public void closeSession();
  
  public String getCurrentUrl();

  public void navigateToBack();

  public void refreshPage();

  public void navigateForward();

  public void createFolder();

  public String screenShot();

  public void verifyResult(boolean condition, String pass, String fail);

  public String getWebElementTextByIndex(List<WebElement> webElement, int index);
  
  public String getWebElementText(By criteria);
  
  public boolean isElementNotNull(By criteria);
}
