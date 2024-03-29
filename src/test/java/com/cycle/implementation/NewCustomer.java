package com.cycle.implementation;

import com.cycle.essentials.Util;
import com.cycle.interfaceclass.INewCustomer;
import com.cycle.locators.ManagerHomePage;
import com.cycle.locators.NewCustomerPage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

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
    startTest("Verify reset in Add New Customer Page.");
    clickOnAddNewCustomerLink();
    enterDataIntoAddNewCustomerFields(testData.getCustomerName(), testData.getGender(),
        testData.getDateOfBirth(), testData.getAddress(), testData.getCity(), testData.getState(),
        testData.getPin(), testData.getMobileNumber(), testData.getEmail(), testData.getNcPassword(),
        false);
    verifyResetFields();
    endTest(logger);
  }
  
  private void verifyReset(By critieria,String field) {
    verifyResult(getTextBoxValue(getElement(newCustomerPage.getDateOfBirth())).equals(""),
        "Able to reset " + field, "Could not reset " + field);
  }
  
  private void verifyResetFields() {
    verifyReset(newCustomerPage.getCustomerName(), "CustomerName");
    verifyReset(newCustomerPage.getDateOfBirth(), "DateOfBirth");
    verifyReset(newCustomerPage.getAddress(), "Address");
    verifyReset(newCustomerPage.getCity(), "City");
    verifyReset(newCustomerPage.getState(), "State");
    verifyReset(newCustomerPage.getPin(), "Pin");
    verifyReset(newCustomerPage.getMobileNumber(), "MobileNumber");
    verifyReset(newCustomerPage.getEmail(), "Email");
    verifyReset(newCustomerPage.getPassword(), "Password");
  }

  @Override
  public void verifyAddingNewCustomer() {
    startTest("Verify adding new customer in Add New Customer Page.");
    clickOnElement(getElement(newCustomerPage.getReset()));
    enterDataIntoAddNewCustomerFields(testData.getCustomerName(), testData.getGender(),
        testData.getDateOfBirth(), testData.getAddress(), testData.getCity(), testData.getState(),
        testData.getPin(), testData.getMobileNumber(), testData.getEmail(), testData.getNcPassword(),
        true);
    endTest(logger);
  }
  
  private void enterDataIntoAddNewCustomerFields(String custName, String gender, String dob,
      String address, String city, String state, String pin, String mblNo, String email, String pwd,
      boolean addOrReset) {
    enterTextIntoTextBox(getElement(newCustomerPage.getCustomerName()), custName);
    if (gender.toLowerCase().equals("female")) {
      getElements(newCustomerPage.getGender()).get(1).click();
    }
    enterTextIntoTextBoxWithoutClear(getElement(newCustomerPage.getDateOfBirth()), dob);
    enterTextIntoTextBox(getElement(newCustomerPage.getAddress()), address);
    enterTextIntoTextBox(getElement(newCustomerPage.getCity()), city);
    enterTextIntoTextBox(getElement(newCustomerPage.getState()), state);
    enterTextIntoTextBox(getElement(newCustomerPage.getPin()), pin);
    enterTextIntoTextBox(getElement(newCustomerPage.getMobileNumber()), mblNo);
    enterTextIntoTextBox(getElement(newCustomerPage.getEmail()), email);
    enterTextIntoTextBox(getElement(newCustomerPage.getPassword()), pwd);
    if (addOrReset) {
      clickOnElement(getElement(newCustomerPage.getSubmit()));
    } else {
      clickOnElement(getElement(newCustomerPage.getReset()));
    }
  }

  @Override
  public void verifyAddingDuplicateCustomer() {
    startTest("Verify adding duplicate customer in Add New Customer Page.");
    clickOnAddNewCustomerLink();
    enterDataIntoAddNewCustomerFields(testData.getCustomerName(), testData.getGender(),
        testData.getDateOfBirth(), testData.getAddress(), testData.getCity(), testData.getState(),
        testData.getPin(), testData.getMobileNumber(), testData.getEmail(), testData.getNcPassword(),
        true);
    //accept alert with whose message consist duplicate email id
    Alert alert = getAlert();
    if (alert.getText().contains("")) {
      alert.accept();
    }
    verifyResetFields();
    endTest(logger);
  }

  @Override
  public void verifyMandatoryMsgForAddNewCustomerFields() {
    startTest("Verify mandatory message for fields in Add New Customer Page.");
    verifyMandatoryTextForFields();
    endTest(logger);
  }
  
  private void manadatoryTextForField(By criteria,String fieldName,String message) {
    enterTextIntoTextBoxWithoutClear(getElement(criteria), "");
    verifyResult(getTextBoxValue(getElement(criteria)).equals(message),
        "Mandatory message is displaying for " + fieldName, 
        "Mandatory message is not displaying for " + fieldName);
  }
  
  private void verifyMandatoryTextForFields() {
    manadatoryTextForField(newCustomerPage.getCustomerNameValidationMsg(), "CustomerName",
        "Customer name must not be blank");
    manadatoryTextForField(newCustomerPage.getDateOfBirthValidationMsg(), "DateOfBirth",
        "Date Field must not be blank");
    manadatoryTextForField(newCustomerPage.getAddressValidationMsg(), "Address",
        "Address Field must not be blank");
    manadatoryTextForField(newCustomerPage.getCityValidationMsg(),
        "City", "City Field must not be blank");
    manadatoryTextForField(newCustomerPage.getStateValidationMsg(), 
        "State", "State must not be blank");
    manadatoryTextForField(newCustomerPage.getPinValidationMsg(), 
        "Pin", "PIN Code must not be blank");
    manadatoryTextForField(newCustomerPage.getMobileNumberValidationMsg(), 
        "MobileNumber","Mobile no must not be blank");
    manadatoryTextForField(newCustomerPage.getEmailValidationMsg(),
        "Email", "Email-ID must not be blank");
    manadatoryTextForField(newCustomerPage.getPasswordValidationMsg(), 
        "Password", "Password must not be blank");
  }
}
