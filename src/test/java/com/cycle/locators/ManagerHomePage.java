package com.cycle.locators;

import java.lang.reflect.Constructor;

import org.openqa.selenium.By;

public class ManagerHomePage {

  public ManagerHomePage() {
  }

  private static ManagerHomePage managerHomePage;
  
  /**
   * Constructor.
   * {@link Constructor}
   * @return ManagerHomePage object
   */
  public static ManagerHomePage getInstance() {
    if (managerHomePage == null) {
      managerHomePage = new ManagerHomePage();
    }
    return managerHomePage;
  }

  private By loggedManagerId = By.cssSelector(".heading3 td");
  private By welcomeMessage = By.tagName("marquee");
  private By listOfLinks = By.cssSelector(".menusubnav a");

  private By manager = By.linkText("Manager");
  private By newCutomer = By.linkText("New Customer");
  private By editCustomer = By.linkText("Edit Customer");
  private By deleteCustomer = By.linkText("Delete Customer");
  private By newAccount = By.linkText("New Account");
  private By editAccount = By.linkText("Edit Account");
  private By deleteAccount = By.linkText("Delete Account");
  private By deposit = By.linkText("Deposit");
  private By withDrawal = By.linkText("Withdrawal");
  private By fundTransfer = By.linkText("Fund Transfer");
  private By changePassword = By.linkText("Change Password");
  private By balanceEnquiry = By.linkText("Balance Enquiry");
  private By miniStatement = By.linkText("Mini Statement");
  private By customisedStatement = By.linkText("Customised Statement");
  private By logout = By.linkText("Log out");

  /**
   * listOfLinks link.
   * @return the listOfLinks
   */
  public By getListOfLinks() {
    return listOfLinks;
  }

  /**
   * welcomeMessage link.
   * @return the welcomeMessage
   */
  public By getWelcomeMessage() {
    return welcomeMessage;
  }

  /**
   * loggedManagerId link.
   * @return the loggedManagerId
   */
  public By getLoggedManagerId() {
    return loggedManagerId;
  }

  /**
   * manager link.
   * @return the manager
   */
  public By getManager() {
    return manager;
  }

  /**
   * newCutomer link.
   * @return the newCutomer
   */
  public By getNewCutomer() {
    return newCutomer;
  }

  /**
   * editCustomer link.
   * @return the editCustomer
   */
  public By getEditCustomer() {
    return editCustomer;
  }

  /**
   * deleteCustomer link.
   * @return the deleteCustomer
   */
  public By getDeleteCustomer() {
    return deleteCustomer;
  }

  /**
   * newAccount link.
   * @return the newAccount
   */
  public By getNewAccount() {
    return newAccount;
  }

  /**
   * editAccount link.
   * @return the editAccount
   */
  public By getEditAccount() {
    return editAccount;
  }

  /**
   * deleteAccount link.
   * @return the deleteAccount
   */
  public By getDeleteAccount() {
    return deleteAccount;
  }

  /**
   * deposit link.
   * @return the deposit
   */
  public By getDeposit() {
    return deposit;
  }

  /**
   * withDrawal link.
   * @return the withDrawal
   */
  public By getWithDrawal() {
    return withDrawal;
  }

  /**
   * fundTransfer link.
   * @return the fundTransfer
   */
  public By getFundTransfer() {
    return fundTransfer;
  }

  /**
   * changePassword link.
   * @return the changePassword
   */
  public By getChangePassword() {
    return changePassword;
  }

  /**
   * balanceEnquiry link.
   * @return the balanceEnquiry
   */
  public By getBalanceEnquiry() {
    return balanceEnquiry;
  }

  /**
   * miniStatement link.
   * @return the miniStatement
   */
  public By getMiniStatement() {
    return miniStatement;
  }

  /**
   * customisedStatement link.
   * @return the customisedStatement
   */
  public By getCustomisedStatement() {
    return customisedStatement;
  }

  /**
   * logout link.
   * @return the logout
   */
  public By getLogout() {
    return logout;
  }

}
