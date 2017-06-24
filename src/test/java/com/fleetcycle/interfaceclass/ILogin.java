package com.fleetcycle.interfaceclass;

public interface ILogin extends IUtil {

  /**
   * Verify login with valid credentials.
   */
  public void verifyLogin();

  /**
   * Verify login with in-valid credentials.
   */
  public void verifyLoginWithInvalidPassword();

  /**
   * Verify login with blank user name and password.
   */
  public void verifyLoginWithBlankUnameAndPwd();

  /**
   * Verify login with invalid userName and password.
   */
  public void verifyLoginWithInvalidUserName();

  /**
   * Verify reset user name and password.
   */
  public void verifyReset();

  /**
   * Verify required message when user name is blank.
   */
  public void verifyReqMessageWhenUserNameIsBlank();

  /**
   * Verify required message when password is blank.
   */
  public void verifyReqMessageWhenPasswordIsBlank();

  /**
   * Verify logout when navigated back in page.
   */
  public void verifyLogoutWhenNavigateBack();

  /**
   * Verify logged manager id is displaying in manager home page.
   */
  public void verifyLoggedManagerId();
}
