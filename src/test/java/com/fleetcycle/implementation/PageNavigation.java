package com.fleetcycle.implementation;

import com.fleetcycle.essentials.Util;
import com.fleetcycle.interfaceclass.IPageNavigation;
import com.fleetcycle.locators.ManagerHomePage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 * IPageNavigation implementation class
 * 
 * @author shivaprasad.a
 */
public class PageNavigation extends Util implements IPageNavigation {

  private static PageNavigation pageNavigation;

  private ManagerHomePage managerHomePage = ManagerHomePage.getInstance();

  /**
   * Constructor.
   */
  public PageNavigation() {
  }

  /**
   * PageNavigation Constructor.
   * 
   * @return PageNavigation object
   */
  public PageNavigation getInstance() {
    if (pageNavigation == null) {
      pageNavigation = new PageNavigation();
    }
    return pageNavigation;
  }

  /**
   * Validate list of links in manager home page.
   */
  @Override
  public void validateListOfLinksInMangerHomePage() {
    startTest("Validate List of links in manager Home Page.");
    List<WebElement> listofLinks = getElements(managerHomePage.getListOfLinks());
    verifyResult(listofLinks.size() == 15, 
        "15 Links are available in manager home page.",
        "15 Links are not available in manager home page.");
    endTest(logger);
  }

  /**
   * Validate link names.
   */
  @Override
  public void validateLinksOrderAndThereTitles() {
    startTest("Validate Links Order and there title in manager Home Page.");
    List<WebElement> listofLinks = getElements(managerHomePage.getListOfLinks());
    // Actual links titles
    String[] actualLinksTitle = new String[15];
    for (int i = 0; i < listofLinks.size(); i++) {
      actualLinksTitle[i] = getWebElementTextByIndex(listofLinks, i);
    }
    String[] expectedLinksTitle = getLinksTitles();
    // Validate Titles
    for (int i = 0; i < actualLinksTitle.length; i++) {
      verifyResult(actualLinksTitle[i].equals(expectedLinksTitle[i]),
          expectedLinksTitle[i] + " link title as expected & order of link is " + i,
          expectedLinksTitle[i] + " link title not as expected or order of link incorrect " + i);
    }
    endTest(logger);
  }
  
  private String[] getLinksTitles() {
    String[] expectedLinksTitle = { getElementText(managerHomePage.getManager()),
        getElementText(managerHomePage.getNewCutomer()),
        getElementText(managerHomePage.getEditCustomer()),
        getElementText(managerHomePage.getDeleteCustomer()),
        getElementText(managerHomePage.getNewAccount()),
        getElementText(managerHomePage.getEditAccount()),
        getElementText(managerHomePage.getDeleteAccount()),
        getElementText(managerHomePage.getDeposit()),
        getElementText(managerHomePage.getWithDrawal()),
        getElementText(managerHomePage.getFundTransfer()),
        getElementText(managerHomePage.getChangePassword()),
        getElementText(managerHomePage.getBalanceEnquiry()),
        getElementText(managerHomePage.getMiniStatement()),
        getElementText(managerHomePage.getCustomisedStatement()),
        getElementText(managerHomePage.getLogout()) };
    return expectedLinksTitle;
  }
  
  private String[] getPageTitles() {
    String[] expectedLinksTitle = { " Guru99 Bank Manager HomePage ",
        " Guru99 Bank New Customer Entry Page ", " Guru99 Bank Edit Customer Page ", 
        " Guru99 Bank Delete Customer Page ", " Guru99 bank add new account ", 
        " Guru99 Edit Account Page ", "Guru99 Bank Delete Account Page ",
        " Guru99 Bank Amount Deposit Page ", " Guru99 Bank Amount Withdrawal Page ", 
        "Guru99 Bank Fund Transfer Entry Page ", " Guru99 Bank New Customer Entry Page ", 
        " Guru99 Bank Balance Enquiry Page ", "Guru99 Bank Mini Statement Page ", 
        "Guru99 Bank Statement Page ", " Guru99 Bank Home Page " };
    return expectedLinksTitle;
  }

  private String getElementText(By by) {
    return getElement(by).getText();
  }
  
  /**
   * Navigate to links in Manage Home page.
   */
  public void navigateToLinksInMangerHomePage() {
    startTest("Navigate to Links present in manager Home Page.");
    List<WebElement> listofLinks = getElements(managerHomePage.getListOfLinks());
    String[] expectedLinksTitle = getPageTitles();
    String logoutText = getElementText(managerHomePage.getLogout());
    for (int i = 0; i < listofLinks.size(); i++) {
      String currentLinkText = listofLinks.get(i).getText();
      listofLinks.get(i).click();
      waitForSpecificTime(2000);
      if (currentLinkText.equals(logoutText)) {
        acceptAlert();
      } 
      verifyResult(getPageTitle().toLowerCase().equals(expectedLinksTitle[i].trim().toLowerCase()),
          "Navigate to " + expectedLinksTitle[i] + " page is pass.",
          "Navigate to " + expectedLinksTitle[i] + " page is fail.");  
      listofLinks = getElements(managerHomePage.getListOfLinks());
    }
    endTest(logger);
  }
}
