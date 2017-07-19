package com.fleetcycle.flows;

import com.fleetcycle.implementation.Login;
import com.fleetcycle.implementation.NewCustomer;
import com.fleetcycle.interfaceclass.ILogin;
import com.fleetcycle.interfaceclass.INewCustomer;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class NewCustomerFlow {

  private INewCustomer newCustomer = new NewCustomer();
  private ILogin login = new Login();
  
  @BeforeClass
  public void setUpSession() {
    newCustomer.setUpSession();
  }

  @AfterClass
  public void closeSession() {
    newCustomer.closeSession();
  }
  
  @Test(priority = 1)
  public void verifyLogin() {
    login.verifyLogin();
  }
  
  @Test(priority = 2)
  public void verifyAvailableFields() {
    newCustomer.verifyAvailableFields();
  }

  @Test(priority = 3)
  public void verifyHomeLinkInAddNewCustomer() {
    newCustomer.verifyHomeLinkInAddNewCustomer();
  }

  @Test(priority = 4)
  public void verifyResetWhileAddingNewCustomer() {
    newCustomer.verifyResetWhileAddingNewCustomer();
  }

  @Test(priority = 5)
  public void verifyMandatoryMsgForAddNewCustomerFields() {
    newCustomer.verifyMandatoryMsgForAddNewCustomerFields();
  }

  @Test(priority = 7)
  public void verifyFirstCharSpaceValidtaionForAddNewCustomerFields() {
    newCustomer.verifyFirstCharSpaceValidtaionForAddNewCustomerFields();
  }
  
  @Test(priority = 8)
  public void verifyNumbersNotAllowedValidationForNameCityAndState() {
    newCustomer.verifyNumbersNotAllowedValidationForNameCityAndState();
  }

  @Test(priority = 9)
  public void verifySpecialCharNotAllowedValidationForFields() {
    newCustomer.verifySpecialCharNotAllowedValidationForFields();
  }

  @Test(priority = 10)
  public void verifyCharactersNotAllowedValidtionForPinAndMobileFields() {
    newCustomer.verifyCharactersNotAllowedValidtionForPinAndMobileFields();
  }
  
  @Test(priority = 11)
  public void verifyInvalidEmailIdValidation() {
    newCustomer.verifyInvalidEmailIdValidation();
  }
  
  @Test(priority = 12)
  public void verifyAddingNewCustomer() {
    newCustomer.verifyAddingNewCustomer();
  }
  
  @Test(priority = 13)
  public void verifyAddingDuplicateCustomer() {
    newCustomer.verifyAddingDuplicateCustomer();
  }
  
  @Test(priority = 14)
  public void verifyAddNewCustomerWithMaxFields() {
    newCustomer.verifyAddNewCustomerWithMaxFields();
  }
}
