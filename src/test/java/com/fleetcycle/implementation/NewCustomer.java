package com.fleetcycle.implementation;

import org.openqa.selenium.By;

import com.fleetcycle.interfaceclass.INewCustomer;
import com.fleetcycle.locators.ManagerHomePage;
import com.fleetcycle.locators.NewCustomerPage;
import com.fleetcycle.util.Util;

public class NewCustomer extends Util implements INewCustomer {

  private static NewCustomer newCustomer;
  private NewCustomerPage newCustomerPage = NewCustomerPage.getInstance();
  
  public NewCustomer() {
  }
  
  /**
   * Constructor.
   * @return NewCustomer instance
   */
  public static NewCustomer getInstance() {
    if (newCustomer == null) {
      newCustomer = new NewCustomer();
    }
    return newCustomer;
  }
  
  @Override
  public void verifyAvailableFields() {
    startTest("Validate Add New Customer Fields.");
    clickOnAddNewCustomerLink();
    // Verify Heading
    verifyResult(getWebElementText(newCustomerPage.getPageHeading()).equals("Add New Customer"),
        "Page Heading is displaying.", "Page Heading is not displaying.");
    verifyElement(newCustomerPage.getCustomerName(), "CustomerName");
    verifyElement(newCustomerPage.getGender(), "Gender");
    verifyElement(newCustomerPage.getDateOfBirth(), "Date Of Birth");
    verifyElement(newCustomerPage.getAddress(), "Address");
    verifyElement(newCustomerPage.getCity(), "City");
    verifyElement(newCustomerPage.getState(), "State");
    verifyElement(newCustomerPage.getPin(), "Pin");
    verifyElement(newCustomerPage.getMobileNumber(), "MobileNumber");
    verifyElement(newCustomerPage.getEmail(), "Email");
    verifyElement(newCustomerPage.getPassword(), "Password");
    verifyElement(newCustomerPage.getSubmit(), "Submit");
    verifyElement(newCustomerPage.getReset(), "Reset");
    verifyElement(newCustomerPage.getHome(), "Home");
    endTest(logger);
  }
  
  public void clickOnAddNewCustomerLink() {
    clickOnElement(getElement(ManagerHomePage.getInstance().getNewCutomer()));
  }
   
  /**
   * Verify element test case.
   * @param criteria criteria
   * @param fieldName fieldName
   */
  public void verifyElement(By criteria,String fieldName) {
    verifyResult(isElementNotNull(criteria),
        fieldName + " field is available.", fieldName + " field is not available.");
  }
  
  @Override
  public void verifyHomeLinkInAddNewCustomer() {
    startTest("Verify Home Link in Add New Customer Page.");
    clickOnElement(getElement(newCustomerPage.getHome()));
    verifyResult(getPageTitle().equals("Guru99 Bank Manager HomePage"),
        "Selecting Home link navigated to Manager Home page.",
        "Selecting Home link not navigate to Manager Home page.");
    endTest(logger);
  }

  @Override
  public void verifyResetWhileAddingNewCustomer() {
    
  }

  @Override
  public void verifyAddingNewCustomer() {
    
  }

  @Override
  public void verifyAddingDuplicateCustomer() {
    
  }

  @Override
  public void verifyMandatoryMsgForAddNewCustomerFields() {
    
  }


}
