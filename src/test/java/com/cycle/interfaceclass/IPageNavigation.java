package com.cycle.interfaceclass;

/**
 * Interface of Page Navigation
 * 
 * @author shivaprasad.a
 */
public interface IPageNavigation extends IUtil {

  /**
   * Validate list of links present in manager home page.
   */
  public void validateListOfLinksInMangerHomePage();

  public void validateLinksOrderAndThereTitles();

  public void navigateToLinksInMangerHomePage();
}
