package com.fleetcycle.locators;

import org.openqa.selenium.By;

public class LoginPage {

  public LoginPage() {
  }

  private static LoginPage loginPage;
  
  /**
   * Constructor.
   * @return LoginPage object
   */
  public LoginPage getInstance() {
    if (loginPage == null) {
      loginPage = new LoginPage();
    }
    return loginPage;
  }

  private By userName = By.name("uid");
  private By password = By.name("password");
  private By login = By.name("btnLogin");
  private By reset = By.name("btnReset");
  private By userNameMandatoryText = By.id("message23");
  private By passwordMandatoryText = By.id("message18");

  /**
   * userName.
   * @return the userName
   */
  public By getUserName() {
    return userName;
  }

  /**
   * password.
   * @return the password
   */
  public By getPassword() {
    return password;
  }

  /**
   * getLogin.
   * @return the login
   */
  public By getLogin() {
    return login;
  }

  /**
   * reset.
   * @return the reset
   */
  public By getReset() {
    return reset;
  }

  /**
   * userNameMandatoryText.
   * @return the userNameMandatoryText
   */
  public By getUserNameMandatoryText() {
    return userNameMandatoryText;
  }

  /**
   * passwordMandatoryText.
   * @return the passwordMandatoryText
   */
  public By getPasswordMandatoryText() {
    return passwordMandatoryText;
  }
}
