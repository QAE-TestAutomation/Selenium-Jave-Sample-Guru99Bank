package com.cycle.essentials;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="TestData")
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
