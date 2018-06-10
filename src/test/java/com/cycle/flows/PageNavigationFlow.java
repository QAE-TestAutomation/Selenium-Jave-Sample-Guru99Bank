package com.cycle.flows;

import com.fleetcycle.implementation.Login;
import com.fleetcycle.implementation.PageNavigation;
import com.fleetcycle.interfaceclass.ILogin;
import com.fleetcycle.interfaceclass.IPageNavigation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * PageNavigation flow.
 * @author shivaprasad.a
 */
public class PageNavigationFlow {

  private IPageNavigation pageNavigation = new PageNavigation();
  private ILogin login = new Login();

  @BeforeClass
  public void setUpSession() {
    pageNavigation.setUpSession();
  }

  @AfterClass
  public void closeSession() {
    pageNavigation.closeSession();
  }
  
  @Test(priority = 1)
  public void verifyLogin() {
    login.verifyLogin();
  }

  @Test(priority = 2,dependsOnMethods = { "verifyLogin" })
  public void validateLinksInMangerHomePage() {
    pageNavigation.validateListOfLinksInMangerHomePage();
  }

  @Test(priority = 3,dependsOnMethods = { "verifyLogin" })
  public void validateLinksOrderAndThereTitles() {
    pageNavigation.validateLinksOrderAndThereTitles();
  }
  
  @Test(priority = 4,dependsOnMethods = { "verifyLogin" })
  public void navigateToLinksInMangerHomePage() {
    pageNavigation.navigateToLinksInMangerHomePage();
  }
}