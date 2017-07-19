package com.fleetcycle.essentials;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TestData")
public class TestData {
  
  String browser;
  String url;
  String userName;
  String password;
  String iUserName;
  String iPassword;
  
  String customerName;
  String gender;
  String dateOfBirth;
  String address;
  String city;
  String state;
  String pin;
  String mobileNumber;
  String email;
  String ncPassword; 
  
  // # Global Test data
  String specialCharacter;
  String twentyChar;
  String fiftyChar;
  String twentyFiveChar;
  String sixChar;
  String fifteenChar;
  String fifteenCharMobile;
  String thirtyChar;
  String thirtyCharEmail;
  
  @XmlElement
  public String getThirtyCharEmail() {
    return thirtyCharEmail;
  }

  public void setThirtyCharEmail(String thirtyCharEmail) {
    this.thirtyCharEmail = thirtyCharEmail;
  }

  public String getFifteenChar() {
    return fifteenChar;
  }
  
  @XmlElement
  public void setFifteenChar(String fifteenChar) {
    this.fifteenChar = fifteenChar;
  }

  public String getFifteenCharMobile() {
    return fifteenCharMobile;
  }

  @XmlElement
  public void setFifteenCharMobile(String fifteenCharMobile) {
    this.fifteenCharMobile = fifteenCharMobile;
  }

  public String getThirtyChar() {
    return thirtyChar;
  }
  
  @XmlElement
  public void setThirtyChar(String thirtyChar) {
    this.thirtyChar = thirtyChar;
  }
  
  public String getSixChar() {
    return sixChar;
  }
  
  @XmlElement
  public void setSixChar(String sixChar) {
    this.sixChar = sixChar;
  }

  public String getSpecialCharacter() {
    return specialCharacter;
  }
  
  @XmlElement
  public void setSpecialCharacter(String specialCharacter) {
    this.specialCharacter = specialCharacter;
  }

  public String getTwentyChar() {
    return twentyChar;
  }

  @XmlElement
  public void setTwentyChar(String twentyChar) {
    this.twentyChar = twentyChar;
  }

  public String getFiftyChar() {
    return fiftyChar;
  }

  @XmlElement
  public void setFiftyChar(String fiftyChar) {
    this.fiftyChar = fiftyChar;
  }

  public String getTwentyFiveChar() {
    return twentyFiveChar;
  }

  @XmlElement
  public void setTwentyFiveChar(String twentyFiveChar) {
    this.twentyFiveChar = twentyFiveChar;
  }
 
  public String getBrowser() {
    return browser;
  }
  
  @XmlElement
  public void setBrowser(String browser) {
    this.browser = browser;
  }
  
  public String getUrl() {
    return url;
  }
  
  @XmlElement
  public void setUrl(String url) {
    this.url = url;
  }
  
  public String getUserName() {
    return userName;
  }
  
  @XmlElement
  public void setUserName(String userName) {
    this.userName = userName;
  }
  
  public String getPassword() {
    return password;
  }
  
  @XmlElement
  public void setPassword(String password) {
    this.password = password;
  }
  
  public String getiUserName() {
    return iUserName;
  }
  
  @XmlElement
  public void setiUserName(String iUserName) {
    this.iUserName = iUserName;
  }
  
  public String getiPassword() {
    return iPassword;
  }
  
  @XmlElement
  public void setiPassword(String iPassword) {
    this.iPassword = iPassword;
  }
  
  public String getCustomerName() {
    return customerName;
  }
  
  @XmlElement
  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }
  
  public String getGender() {
    return gender;
  }
  
  @XmlElement
  public void setGender(String gender) {
    this.gender = gender;
  }
  
  public String getDateOfBirth() {
    return dateOfBirth;
  }
  
  @XmlElement
  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }
  
  public String getAddress() {
    return address;
  }
  
  @XmlElement
  public void setAddress(String address) {
    this.address = address;
  }
  
  public String getCity() {
    return city;
  }
  
  @XmlElement
  public void setCity(String city) {
    this.city = city;
  }
  
  public String getState() {
    return state;
  }
  
  @XmlElement
  public void setState(String state) {
    this.state = state;
  }
  
  public String getPin() {
    return pin;
  }
  
  @XmlElement
  public void setPin(String pin) {
    this.pin = pin;
  }
  
  public String getMobileNumber() {
    return mobileNumber;
  }
  
  @XmlElement
  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }
  
  public String getEmail() {
    return email;
  }
  
  @XmlElement
  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getNcPassword() {
    return ncPassword;
  }
  
  @XmlElement
  public void setNcPassword(String ncPassword) {
    this.ncPassword = ncPassword;
  }
}
