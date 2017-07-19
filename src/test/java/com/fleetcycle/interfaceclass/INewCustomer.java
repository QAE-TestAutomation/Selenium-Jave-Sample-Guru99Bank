package com.fleetcycle.interfaceclass;

public interface INewCustomer extends IUtil {

  public void verifyAvailableFields();
  
  public void verifyHomeLinkInAddNewCustomer();
  
  public void verifyResetWhileAddingNewCustomer();
  
  public void verifyAddingNewCustomer();
  
  public void verifyAddingDuplicateCustomer();
  
  public void verifyMandatoryMsgForAddNewCustomerFields();
  
  public void verifyFirstCharSpaceValidtaionForAddNewCustomerFields();
  
  public void verifyNumbersNotAllowedValidationForNameCityAndState();
  
  public void verifySpecialCharNotAllowedValidationForFields();
  
  public void verifyCharactersNotAllowedValidtionForPinAndMobileFields();
  
  public void verifyInvalidEmailIdValidation();
  
  public void verifyAddNewCustomerWithMaxFields();
  
}
