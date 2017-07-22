package com.fleetcycle.locators;

import org.openqa.selenium.By;

public class EditCustomerPage {
  
  public EditCustomerPage() {
  }
  
  private static EditCustomerPage editCustomerPage;
  
  /**
   * Constructor.
   * @return EditCustomerPage instance
   */
  public static EditCustomerPage getInstance() {
    if (editCustomerPage == null) {
      editCustomerPage = new EditCustomerPage();
    }
    return editCustomerPage;
  }
  
  private By customerIdTextBox = By.name("cusid");
  private By customerIdValidationTextArea = By.id("message14");
  private By submit = By.name("AccSubmit");
  private By reset = By.name("res");
  
  public static EditCustomerPage getEditCustomerPage() {
    return editCustomerPage;
  }
  public By getCustomerIdTextBox() {
    return customerIdTextBox;
  }
  public By getCustomerIdValidationTextArea() {
    return customerIdValidationTextArea;
  }
  public By getSubmit() {
    return submit;
  }
  public By getReset() {
    return reset;
  }
}
