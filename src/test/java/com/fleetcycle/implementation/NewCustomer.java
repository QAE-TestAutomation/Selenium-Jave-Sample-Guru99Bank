package com.fleetcycle.implementation;

import com.fleetcycle.essentials.Util;
import com.fleetcycle.interfaceclass.INewCustomer;
import com.fleetcycle.locators.ManagerHomePage;
import com.fleetcycle.locators.NewCustomerPage;

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
        testData.getPin(), testData.getMobileNumber(), testData.getEmail(),
        testData.getNcPassword(),true,false);
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
        testData.getPin(), "+" + testData.getMobileNumber(), testData.getEmail(),
        testData.getNcPassword(),true,true);
    // add validation message
    verifyResult(getElement(newCustomerPage.getPageHeading()).getText()
        .equals("Customer Registered Successfully!!!"),"New customer added.", 
        "Failed to add new customer.");
    // get added customer id
    newCustomerId = getElement(newCustomerPage.getNewCustomerId()).getText(); 
    // back to link
    clickOnAddNewCustomerLink();
    endTest(logger);
  }
  
  private void enterDataIntoAddNewCustomerFields(String custName, String gender, String dob,
      String address, String city, String state, String pin, String mblNo, String email, String pwd,
      boolean selectAnyButon, boolean addOrReset) {
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
    
    if (selectAnyButon) {
      if (addOrReset) {
        clickOnElement(getElement(newCustomerPage.getSubmit()));
      } else {
        clickOnElement(getElement(newCustomerPage.getReset()));
      }  
    }
  }
  
  private void enterDataIntoAddNewCustomerFields(String custName, String gender, String dob,
      String address, String city, String state, String pin, String mblNo, 
      String email, String pwd) {
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
    // Enter blank into text box's
    enterTextIntoTextBox(getElement(newCustomerPage.getAddress()), address);
  }

  
  @Override
  public void verifyAddingDuplicateCustomer() {
    startTest("Verify adding duplicate customer in Add New Customer Page.");
    clickOnAddNewCustomerLink();
    enterDataIntoAddNewCustomerFields(testData.getCustomerName(), testData.getGender(),
        testData.getDateOfBirth(), testData.getAddress(), testData.getCity(), testData.getState(),
        testData.getPin(), testData.getMobileNumber(), testData.getEmail(),
        testData.getNcPassword(),true,true);
    waitForSpecificTime(5000);
    //accept alert with whose message consist duplicate email id
    Alert alert = webDriver.switchTo().alert();
    String alertText = alert.getText().trim(); 
    if (alertText.contains("Email Address Already Exist !!")) {
      alert.accept();
      pass(alertText + " validation message is displayed");
    } else {
      fail("Email Address Already Exist validation message is not displayed.");
    }
    endTest(logger);
  }

  @Override
  public void verifyMandatoryMsgForAddNewCustomerFields() {
    startTest("Verify mandatory message for fields in Add New Customer Page.");
    verifyMandatoryTextForFields();
    endTest(logger);
  }
  
  private void manadatoryTextForField(By validation,String fieldName,String message) {
    verifyResult(getWebElementText(validation).equals(message),
        "Mandatory message is displaying for " + fieldName, 
        "Mandatory message is not displaying for " + fieldName);
  }
  
  private void specificValidationForField(By validationElement,String validationMessage,String fieldName) {
    verifyResult(getWebElementText(validationElement).equals(validationMessage),
        validationMessage + " validation message is displaying for " + fieldName, 
        validationMessage + " validation message is not displaying for " + fieldName);
  }
  
  private void verifyMandatoryTextForFields() {
    enterDataIntoAddNewCustomerFields("", "", "", "", "", "", "", "", "", "");
    manadatoryTextForField(newCustomerPage.getCustomerNameValidationMsg(), "CustomerName",
        "Customer name must not be blank");
    manadatoryTextForField(newCustomerPage.getDateOfBirthValidationMsg(), "DateOfBirth",
        "Date Field must not be blank");
    manadatoryTextForField(newCustomerPage.getAddressValidationMsg(),
        "Address", "Address Field must not be blank");
    manadatoryTextForField(newCustomerPage.getCityValidationMsg(),
        "City", "City Field must not be blank");
    manadatoryTextForField(newCustomerPage.getStateValidationMsg(),
        "State", "State must not be blank");
    manadatoryTextForField(newCustomerPage.getPinValidationMsg(), "Pin",
        "PIN Code must not be blank");
    manadatoryTextForField(newCustomerPage.getMobileNumberValidationMsg(), "MobileNumber",
        "Mobile no must not be blank");
    manadatoryTextForField(newCustomerPage.getEmailValidationMsg(),
        "Email", "Email-ID must not be blank");
    manadatoryTextForField(newCustomerPage.getPasswordValidationMsg(), "Password",
        "Password must not be blank");
  }
  
  @Override
  public void verifyFirstCharSpaceValidtaionForAddNewCustomerFields() {
    startTest("Verify adding new customer in Add New Customer Page with space before text.");
    clickOnElement(getElement(newCustomerPage.getReset()));
    String space = " ";
    String[] inputTestData = {space + testData.getCustomerName(), testData.getGender(),
        testData.getDateOfBirth(), space + testData.getAddress(),
        space + testData.getCity(),space + testData.getState(),
        space + testData.getPin(), space + testData.getMobileNumber(), 
        space + testData.getEmail(),space + testData.getNcPassword()};
    enterDataIntoAddNewCustomerFields(inputTestData[0], inputTestData[1],
        inputTestData[2], inputTestData[3], inputTestData[4], inputTestData[5],
        inputTestData[6], inputTestData[7], inputTestData[8],inputTestData[9],false,false);
    By[] validationTextArea = { newCustomerPage.getCustomerNameValidationMsg(),
        newCustomerPage.getAddressValidationMsg(), newCustomerPage.getCityValidationMsg(),
        newCustomerPage.getStateValidationMsg(), newCustomerPage.getPinValidationMsg(),
        newCustomerPage.getMobileNumberValidationMsg(), newCustomerPage.getEmailValidationMsg()};
    String[] field = {"Customer Name","Address","City","State","Pin","Mobile","Email"};
    for (int i = 0; i < field.length; i++) {
      specificValidationForField(validationTextArea[i],"First character can not have space", field[i]);
    }
    endTest(logger);
  }
  
  public void verifyNumbersNotAllowedValidationForNameCityAndState() {
    startTest("Verify numbers not allowed validation while adding new customer in Add New Customer Page for Name,City And State.");
    clickOnElement(getElement(newCustomerPage.getReset()));
    String[] inputTestData = {testData.getMobileNumber(), testData.getGender(),
        testData.getDateOfBirth(), testData.getAddress(),
        testData.getMobileNumber(),testData.getMobileNumber(),
        testData.getPin(), testData.getMobileNumber(), 
        testData.getEmail(),testData.getNcPassword()};
    enterDataIntoAddNewCustomerFields(inputTestData[0], inputTestData[1],
        inputTestData[2], inputTestData[3], inputTestData[4], inputTestData[5],
        inputTestData[6], inputTestData[7], inputTestData[8],inputTestData[9],false,false);
    By[] validationTextArea = { newCustomerPage.getCustomerNameValidationMsg(),
        newCustomerPage.getCityValidationMsg(),newCustomerPage.getStateValidationMsg(), };
    String[] field = {"Customer Name","City","State"};
    for (int i = 0; i < field.length; i++) {
      specificValidationForField(validationTextArea[i],"Numbers are not allowed",field[i]);
    }
    endTest(logger);
  }
  
  public void verifySpecialCharNotAllowedValidationForFields() {
    startTest("Verify Special character not allowed validation while adding New Customer with special char.");
    clickOnElement(getElement(newCustomerPage.getReset()));
    String[] inputTestData = {testData.getSpecialCharacter(), testData.getGender(),
        testData.getDateOfBirth(), testData.getSpecialCharacter(),
        testData.getSpecialCharacter(),testData.getSpecialCharacter(),
        testData.getSpecialCharacter(), testData.getSpecialCharacter(), 
        testData.getEmail(),testData.getNcPassword()};
    enterDataIntoAddNewCustomerFields(inputTestData[0], inputTestData[1],
        inputTestData[2], inputTestData[3], inputTestData[4], inputTestData[5],
        inputTestData[6], inputTestData[7], inputTestData[8],inputTestData[9],false,false);
    By[] validationTextArea = { newCustomerPage.getCustomerNameValidationMsg(),
        newCustomerPage.getAddressValidationMsg(), newCustomerPage.getCityValidationMsg(),
        newCustomerPage.getStateValidationMsg(), newCustomerPage.getPinValidationMsg(),
        newCustomerPage.getMobileNumberValidationMsg()};
    String[] field = {"Customer Name","Address","City","State","Pin","Mobile"};
    for (int i = 0; i < field.length; i++) {
      specificValidationForField(validationTextArea[i],"Special characters are not allowed",field[i]);
    }
    endTest(logger);
  }
  
  public void verifyCharactersNotAllowedValidtionForPinAndMobileFields() {
    startTest("Verify Characters not allowed validation while adding new customer in Add New Customer Page for Pin and Mobile.");
    clickOnElement(getElement(newCustomerPage.getReset()));
    String[] inputTestData = {testData.getCustomerName(), testData.getGender(),
        testData.getDateOfBirth(), testData.getAddress(),
        testData.getCity(),testData.getState(),
        testData.getSixChar(), testData.getSixChar(), 
        testData.getEmail(),testData.getNcPassword()};
    enterDataIntoAddNewCustomerFields(inputTestData[0], inputTestData[1],
        inputTestData[2], inputTestData[3], inputTestData[4], inputTestData[5],
        inputTestData[6], inputTestData[7], inputTestData[8],inputTestData[9],false,false);
    By[] validationTextArea = { newCustomerPage.getPinValidationMsg(),
        newCustomerPage.getMobileNumberValidationMsg() };
    String[] field = {"Pin","Mobile"};
    for (int i = 0; i < field.length; i++) {
      specificValidationForField(validationTextArea[i],"Characters are not allowed",field[i]);
    }
    endTest(logger);
  }
  
  public void verifyInvalidEmailIdValidation() {
    startTest("Verify invalid email id validation while adding new customer in Add New Customer Page for email.");
    clickOnElement(getElement(newCustomerPage.getReset()));
    String[] inputTestData = {testData.getCustomerName(), testData.getGender(),
        testData.getDateOfBirth(), testData.getAddress(),
        testData.getCity(),testData.getState(),
        testData.getPin(), testData.getMobileNumber(), 
        testData.getCustomerName(),testData.getNcPassword()};
    enterDataIntoAddNewCustomerFields(inputTestData[0], inputTestData[1],
        inputTestData[2], inputTestData[3], inputTestData[4], inputTestData[5],
        inputTestData[6], inputTestData[7], inputTestData[8],inputTestData[9],false,false);
    specificValidationForField(newCustomerPage.getEmailValidationMsg(),"Email-ID is not valid","Email");
    endTest(logger);
  }
  
  public void verifyAddNewCustomerWithMaxFields() {
    startTest("Verify adding new customer in Add New Customer Page.");
    clickOnElement(getElement(newCustomerPage.getReset()));
    enterDataIntoAddNewCustomerFields(testData.getTwentyFiveChar(), testData.getGender(),
        testData.getDateOfBirth(), testData.getFiftyChar(), testData.getTwentyFiveChar(), testData.getTwentyFiveChar(),
        testData.getPin(), "+" + testData.getFifteenCharMobile(), testData.getThirtyCharEmail(),
        testData.getNcPassword(),true,true);
    // add validation message
    verifyResult(getElement(newCustomerPage.getPageHeading()).getText()
        .equals("Customer Registered Successfully!!!"),"New customer added.", 
        "Failed to add new customer.");
    // back to link
    clickOnAddNewCustomerLink();
    endTest(logger);
  }
}
