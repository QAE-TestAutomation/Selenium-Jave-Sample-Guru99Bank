package com.fleetcycle.implementation;

import com.fleetcycle.essentials.Util;
import com.fleetcycle.interfaceclass.ILogin;
import com.fleetcycle.locators.LoginPage;
import com.fleetcycle.locators.ManagerHomePage;

public class Login extends Util implements ILogin {

  private LoginPage loginPage = new LoginPage();
  private ManagerHomePage managerHomePage = ManagerHomePage.getInstance();

  public Login() {
  }
  
  /**
   * Verify login with valid credentials.
   */
  @Override
  public void verifyLogin() {
    startTest("Verify login with valid username and valid password");
    login(testData.getUserName(), testData.getPassword(), true);
    verifyResult(getPageTitle().equals("Guru99 Bank Manager HomePage"),
        "Login to page using valid username and password.",
        "Could not login to page using valid username and password.");
    endTest(logger);
    // assertNotEquals(getPageTitle(), "Guru99 Bank Home Page");
  }
  
  /**
   * Validate logged manager id in manager homepage.
   */
  public void verifyLoggedManagerId() {
    startTest("Verify manager is is displaying in manager home page.");
    verifyResult(
        getElement(managerHomePage.getLoggedManagerId()).getText().contains(testData.getUserName()),
        "Logged manager id is displaying in homepage",
        "Logged manager id is not displaying in homepage");
    endTest(logger);
  }

  private void login(String userName, String password, boolean clickLogin) {
    enterTextIntoTextBox(getElement(loginPage.getUserName()), userName);
    enterTextIntoTextBox(getElement(loginPage.getPassword()), password);
    if (clickLogin) {
      clickOnElement(getElement(loginPage.getLogin()));
    } else {
      clickOnElement(getElement(loginPage.getReset()));
    }
  }

  /**
   * Verify login with in-valid credentials.
   */
  @Override
  public void verifyLoginWithInvalidPassword() {
    startTest("Verify login with valid username and invalid password");
    login(testData.getUserName(), testData.getiPassword(), true);
    acceptAlert();
    verifyResult(getPageTitle().equals("Guru99 Bank Home Page"),
        "Could not login to page using valid username and invalid password.",
        "Able to login using blank username and password.");
    endTest(logger);
    // assertEquals(getPageTitle(), "Guru99 Bank Home Page");
  }

  /**
   * Verify login with blank user name and password.
   */
  @Override
  public void verifyLoginWithBlankUnameAndPwd() {
    startTest("Verify login with blank user name and password");
    login("", "", true);
    acceptAlert();
    verifyResult(getPageTitle().equals("Guru99 Bank Home Page"),
        "Could not login to page using blank username and password.",
        "Able to login using blank username and password.");
    endTest(logger);
    // assertEquals(getPageTitle(), "Guru99 Bank Home Page");
  }

  /**
   * Verify login with invalid userName and password.
   */
  @Override
  public void verifyLoginWithInvalidUserName() {
    startTest("Verify login with Invalid user name and valid password");
    login(testData.getiUserName(), testData.getPassword(), true);
    acceptAlert();
    verifyResult(getPageTitle().equals("Guru99 Bank Home Page"),
        "Could not login to page using invalid username and valid password.",
        "Able to login using invalid username and valid password.");
    endTest(logger);
    // assertEquals(getPageTitle(), "Guru99 Bank Home Page");
  }

  /**
   * Verify reset user name and password.
   */
  @Override
  public void verifyReset() {
    startTest("Verify reset user name and password");
    login(testData.getUserName(), testData.getPassword(), false);
    verifyResult(getTextBoxValue(getElement(loginPage.getUserName())).equals(""),
        "Able to Reset username.", "Could not Reset username.");
    verifyResult(getTextBoxValue(getElement(loginPage.getPassword())).equals(""),
        "Able to Reset password.", "Could not Reset password.");
    endTest(logger);
    // assertEquals(getTextBoxValue(getElement(loginPage.getUserName())), "");
    // assertEquals(getTextBoxValue(getElement(loginPage.getPassword())), "");
  }

  /**
   * Verify required message when user name is blank.
   */
  @Override
  public void verifyReqMessageWhenUserNameIsBlank() {
    startTest("Verify username mandatory text when username is blank.");
    clickOnElement(getElement(loginPage.getUserName()));
    clickOnElement(getElement(loginPage.getPassword()));
    verifyResult(
        getElement(loginPage.getUserNameMandatoryText()).getText()
            .equals("User-ID must not be blank"),
        "User name mandatory text is displaying.", "User name mandatory text is not displaying.");
    endTest(logger);
    // assertEquals(getElement(loginPage.getUserNameMandatoryText()).getText(), "User-ID must not be
    // blank");
  }

  /**
   * Verify required message when password is blank.
   */
  @Override
  public void verifyReqMessageWhenPasswordIsBlank() {
    startTest("Verify password mandatory text when password is blank.");
    clickOnElement(getElement(loginPage.getPassword()));
    clickOnElement(getElement(loginPage.getUserName()));
    verifyResult(
        getElement(loginPage.getPasswordMandatoryText()).getText()
            .equals("Password must not be blank"),
        "Password mandatory text is displaying.", "Password mandatory text is not displaying.");
    endTest(logger);
    // assertEquals(getElement(loginPage.getPasswordMandatoryText()).getText(), "Password must not
    // be blank");
  }
  
  /**
   * Security Feature: Verify logout when navigate to back after login.
   */
  public void verifyLogoutWhenNavigateBack() {
    startTest("Verify logout when navigate back after login.");
    clickOnElement(getElement(managerHomePage.getLogout()));
    acceptAlert();
    waitForSpecificTime(2000);
    String currentUrl = getCurrentUrl();
    navigateTo(currentUrl);
    login(testData.getUserName(), testData.getPassword(), true);
    navigateToBack();
    waitForSpecificTime(2000);
    navigateForward();
    waitForSpecificTime(2000);
    verifyResult(getPageTitle().equals("Guru99 Bank Home Page"),
        "Logout on navigating back is pass.",
        "Security Breach: Could not logout on navigating back.");
    endTest(logger);
  }
}
