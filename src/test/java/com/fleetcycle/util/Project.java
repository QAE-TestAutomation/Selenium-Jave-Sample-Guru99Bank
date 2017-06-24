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
