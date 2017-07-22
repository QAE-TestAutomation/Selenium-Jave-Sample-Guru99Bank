package com.fleetcycle.locators;

import org.openqa.selenium.By;

public class NewCustomerPage {
  
  public NewCustomerPage() {
  }
  
  private static NewCustomerPage newCustomerPage;
  
  /**
   * Constructor.
   * @return NewCustomerPage instance
   */
  public static NewCustomerPage getInstance() {
    if (newCustomerPage == null) {
      newCustomerPage = new NewCustomerPage();
    }
    return newCustomerPage;
  }
  
  private By pageHeading = By.className("heading3");
  private By customerName = By.name("name");
  private By customerNameValidationMsg = By.id("message");
  private By gender = By.name("rad1");
  private By dateOfBirth = By.name("dob");
  private By dateOfBirthValidationMsg = By.id("message24");
  private By address = By.name("addr");
  private By addressValidationMsg = By.id("message3");
  private By city = By.name("city");
  private By cityValidationMsg = By.id("message4");
  private By state = By.name("state");
  private By stateValidationMsg = By.id("message5");
  private By pin = By.name("pinno");
  private By pinValidationMsg = By.id("message6");
  private By mobileNumber = By.name("telephoneno");
  private By mobileNumberValidationMsg = By.id("message7");
  private By email = By.name("emailid");
  private By emailValidationMsg = By.id("message9");
  private By password = By.name("password");
  private By passwordValidationMsg = By.id("message18");
  private By submit = By.name("sub");
  private By reset = By.name("res");
  private By home = By.linkText("Home");
  
  private By newCustomerId = By.cssSelector("#customer tr:nth-of-type(4) td:nth-of-type(2)");

  public By getNewCustomerId() {
    return newCustomerId;
  }

  /**
   * pageHeading.
   * @return the pageHeading
   */
  public By getPageHeading() {
    return pageHeading;
  }
  
  /**
   * customerName.
   * @return the customerName
   */
  public By getCustomerName() {
    return customerName;
  }
  
  /**
   * customerNameValidationMsg.
   * @return the customerNameValidationMsg
   */
  public By getCustomerNameValidationMsg() {
    return customerNameValidationMsg;
  }
  
  /**
   * gender.
   * @return the gender
   */
  public By getGender() {
    return gender;
  }
  
  /**
   * dateOfBirth.
   * @return the dateOfBirth
   */
  public By getDateOfBirth() {
    return dateOfBirth;
  }
  
  /**
   * dateOfBirthValidationMsg.
   * @return the dateOfBirthValidationMsg
   */
  public By getDateOfBirthValidationMsg() {
    return dateOfBirthValidationMsg;
  }
  
  /**
   * address.
   * @return the address
   */
  public By getAddress() {
    return address;
  }
  
  /**
   * addressValidationMsg.
   * @return the addressValidationMsg
   */
  public By getAddressValidationMsg() {
    return addressValidationMsg;
  }
  
  /**
   * city.
   * @return the city
   */
  public By getCity() {
    return city;
  }
  
  /**
   * cityValidationMsg.
   * @return the cityValidationMsg
   */
  public By getCityValidationMsg() {
    return cityValidationMsg;
  }
  
  /**
   * state.
   * @return the state
   */
  public By getState() {
    return state;
  }
  
  /**
   * stateValidationMsg.
   * @return the stateValidationMsg
   */
  public By getStateValidationMsg() {
    return stateValidationMsg;
  }
  
  /**
   * pin.
   * @return the pin
   */
  public By getPin() {
    return pin;
  }
  
  /**
   * pinValidationMsg.
   * @return the pinValidationMsg
   */
  public By getPinValidationMsg() {
    return pinValidationMsg;
  }
  
  /**
   * mobileNumber.
   * @return the mobileNumber
   */
  public By getMobileNumber() {
    return mobileNumber;
  }
  
  /**
   * mobileNumberValidationMsg.
   * @return the mobileNumberValidationMsg
   */
  public By getMobileNumberValidationMsg() {
    return mobileNumberValidationMsg;
  }
  
  /**
   * email.
   * @return the email
   */
  public By getEmail() {
    return email;
  }
  
  /**
   * emailValidationMsg.
   * @return the emailValidationMsg
   */
  public By getEmailValidationMsg() {
    return emailValidationMsg;
  }
  
  /**
   * password.
   * @return the password
   */
  public By getPassword() {
    return password;
  }
  
  /**
   * passwordValidationMsg.
   * @return the passwordValidationMsg
   */
  public By getPasswordValidationMsg() {
    return passwordValidationMsg;
  }
  
  /**
   * submit.
   * @return the submit
   */
  public By getSubmit() {
    return submit;
  }
  
  /**
   * reset.
   * @return the reset
   */
  public By getReset() {
    return reset;
  }
  
  /**
   * home.
   * @return the home
   */
  public By getHome() {
    return home;
  }

}
