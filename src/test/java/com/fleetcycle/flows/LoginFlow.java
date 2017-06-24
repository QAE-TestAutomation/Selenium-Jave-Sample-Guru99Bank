package com.fleetcycle.flows;

import com.fleetcycle.implementation.Login;
import com.fleetcycle.interfaceclass.ILogin;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginFlow {

  private ILogin loginFlow = new Login();

  @BeforeClass
  public void setUpSession() {
    loginFlow.setUpSession();
  }
  
  @Test(priority = 1)
  public void verifyLoginWithBlankUnameAndPwd() {
    loginFlow.verifyLoginWithBlankUnameAndPwd();
  }

  @Test(priority = 2)
  public void verifyLoginWithInvalidPassword() {
    loginFlow.verifyLoginWithInvalidPassword();
  }

  @Test(priority = 3)
  public void verifyLoginWithInvalidUserName() {
    loginFlow.verifyLoginWithInvalidUserName();
  }

  @Test(priority = 4)
  public void verifyReset() {
    loginFlow.verifyReset();
  }
  
  @Test(priority = 5)
  public void verifyReqMessageWhenUserNameIsBlank() {
    loginFlow.verifyReqMessageWhenUserNameIsBlank();
  }

  @Test(priority = 6)
  public void verifyReqMessageWhenPasswordIsBlank() {
    loginFlow.verifyReqMessageWhenPasswordIsBlank();
  }

  @Test(priority = 7)
  public void verifyLogin() {
    loginFlow.verifyLogin();
  }

  @Test(priority = 8)
  public void verifyLoggedManagerId() {
    loginFlow.verifyLoggedManagerId();
  }

  @Test(priority = 9)
  public void verifyLogoutWhenNavigateBack() {
    loginFlow.verifyLogoutWhenNavigateBack();
  }
  
  @AfterClass
  public void closeSession() {
    loginFlow.closeSession();
  }
  
}
