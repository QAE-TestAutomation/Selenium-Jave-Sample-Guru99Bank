package com.fleetcycle.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Properties;

public class Project {

  public Project() {
  }

  private static Project project;
  
  /**
   * Constructor.
   * {@link Constructor}
   * @return Project instance
   */
  public static Project getInstance() {
    if (project == null) {
      project = new Project();
    }
    return project;
  }

  private String browser = readProfFile().getProperty("browser");
  private String url = readProfFile().getProperty("url");
  private String userName = readProfFile().getProperty("userName");
  private String password = readProfFile().getProperty("password");
  private String iuserName = readProfFile().getProperty("iUserName");
  private String ipassword = readProfFile().getProperty("iPassword");

  private String customerName  = readProfFile().getProperty("customerName");
  private String gender = readProfFile().getProperty("gender");
  private String dateOfBirth = readProfFile().getProperty("dateOfBirth");
  private String address = readProfFile().getProperty("address");
  private String city = readProfFile().getProperty("city");
  private String state = readProfFile().getProperty("state");
  private String pin = readProfFile().getProperty("pin");
  private String mobileNumber = readProfFile().getProperty("mobileNumber");
  private String email = readProfFile().getProperty("email");
  private String ncPassword = readProfFile().getProperty("ncPassword");
  
  /**
   * customerName.
   * @return the customerName
   */
  public String getCustomerName() {
    return customerName;
  }

  /**
   * gender.
   * @return the gender
   */
  public String getGender() {
    return gender;
  }

  /**
   * dateOfBirth.
   * @return the dateOfBirth
   */
  public String getDateOfBirth() {
    return dateOfBirth;
  }

  /**
   * address.
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   * city.
   * @return the city
   */
  public String getCity() {
    return city;
  }

  /**
   * state.
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * pin.
   * @return the pin
   */
  public String getPin() {
    return pin;
  }

  /**
   * mobileNumber.
   * @return the mobileNumber
   */
  public String getMobileNumber() {
    return mobileNumber;
  }

  /**
   * email.
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * ncPassword.
   * @return the ncPassword
   */
  public String getNcPassword() {
    return ncPassword;
  }
  
  /**
   * browser.
   * @return the browser
   */
  public String getBrowser() {
    return browser;
  }

  /**
   * url.
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * userName.
   * @return the userName
   */
  public String getUserName() {
    return userName;
  }

  /**
   * password.
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * iUserName.
   * @return the iUserName
   */
  public String getiUserName() {
    return iuserName;
  }

  /**
   * iPassword.
   * @return the iPassword
   */
  public String getiPassword() {
    return ipassword;
  }
  
  /**
   * Reads config properties file.
   * @return {@link Properties}
   */
  public Properties readProfFile() {
    File file = new File(".//src/resource//TestData//config.properties");
    FileInputStream fileInput = null;
    try {
      fileInput = new FileInputStream(file);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    Properties properties = new Properties();
    try {
      properties.load(fileInput);
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      fileInput.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return properties;
  }
}
