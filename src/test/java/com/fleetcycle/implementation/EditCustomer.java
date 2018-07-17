package com.fleetcycle.implementation;

import com.fleetcycle.essentials.Util;
import com.fleetcycle.interfaceclass.IEditCustomer;

public class EditCustomer extends Util implements IEditCustomer {

  private static EditCustomer editCustomer;
  
  public EditCustomer() {
  }
  
  public static EditCustomer getInstance() {
    if (editCustomer == null) {
      editCustomer = new EditCustomer();
    }
    return editCustomer;
  }

  @Override
  public void verifyAvailableFieldsInEditCustomer() {
    
  }

  @Override
  public void verifyResetInEditCustomer() {
    
  }

  @Override
  public void verifyHomePageLinkInEditCustomerPage() {
    
  }
  
}
