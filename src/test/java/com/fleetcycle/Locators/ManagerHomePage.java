package com.fleetcycle.Locators;

import org.openqa.selenium.By;

public class ManagerHomePage {
	
	public ManagerHomePage(){
	}
	
	public static ManagerHomePage getInstance() {
		return new ManagerHomePage();
	}

	private By loggedManagerId = By.cssSelector(".heading3 td");
	private By welcomeMessage = By.tagName("marquee");
	
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
	 * @return the welcomeMessage
	 */
	public By getWelcomeMessage() {
		return welcomeMessage;
	}
	/**
	 * @param welcomeMessage the welcomeMessage to set
	 */
	public void setWelcomeMessage(By welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}
	
	/**
	 * @return the loggedManagerId
	 */
	public By getLoggedManagerId() {
		return loggedManagerId;
	}
	/**
	 * @param loggedManagerId the loggedManagerId to set
	 */
	public void setLoggedManagerId(By loggedManagerId) {
		this.loggedManagerId = loggedManagerId;
	}
	/**
	 * @return the manager
	 */
	public By getManager() {
		return manager;
	}
	/**
	 * @param manager the manager to set
	 */
	public void setManager(By manager) {
		this.manager = manager;
	}
	/**
	 * @return the newCutomer
	 */
	public By getNewCutomer() {
		return newCutomer;
	}
	/**
	 * @param newCutomer the newCutomer to set
	 */
	public void setNewCutomer(By newCutomer) {
		this.newCutomer = newCutomer;
	}
	/**
	 * @return the editCustomer
	 */
	public By getEditCustomer() {
		return editCustomer;
	}
	/**
	 * @param editCustomer the editCustomer to set
	 */
	public void setEditCustomer(By editCustomer) {
		this.editCustomer = editCustomer;
	}
	/**
	 * @return the deleteCustomer
	 */
	public By getDeleteCustomer() {
		return deleteCustomer;
	}
	/**
	 * @param deleteCustomer the deleteCustomer to set
	 */
	public void setDeleteCustomer(By deleteCustomer) {
		this.deleteCustomer = deleteCustomer;
	}
	/**
	 * @return the newAccount
	 */
	public By getNewAccount() {
		return newAccount;
	}
	/**
	 * @param newAccount the newAccount to set
	 */
	public void setNewAccount(By newAccount) {
		this.newAccount = newAccount;
	}
	/**
	 * @return the editAccount
	 */
	public By getEditAccount() {
		return editAccount;
	}
	/**
	 * @param editAccount the editAccount to set
	 */
	public void setEditAccount(By editAccount) {
		this.editAccount = editAccount;
	}
	/**
	 * @return the deleteAccount
	 */
	public By getDeleteAccount() {
		return deleteAccount;
	}
	/**
	 * @param deleteAccount the deleteAccount to set
	 */
	public void setDeleteAccount(By deleteAccount) {
		this.deleteAccount = deleteAccount;
	}
	/**
	 * @return the deposit
	 */
	public By getDeposit() {
		return deposit;
	}
	/**
	 * @param deposit the deposit to set
	 */
	public void setDeposit(By deposit) {
		this.deposit = deposit;
	}
	/**
	 * @return the withDrawal
	 */
	public By getWithDrawal() {
		return withDrawal;
	}
	/**
	 * @param withDrawal the withDrawal to set
	 */
	public void setWithDrawal(By withDrawal) {
		this.withDrawal = withDrawal;
	}
	/**
	 * @return the fundTransfer
	 */
	public By getFundTransfer() {
		return fundTransfer;
	}
	/**
	 * @param fundTransfer the fundTransfer to set
	 */
	public void setFundTransfer(By fundTransfer) {
		this.fundTransfer = fundTransfer;
	}
	/**
	 * @return the changePassword
	 */
	public By getChangePassword() {
		return changePassword;
	}
	/**
	 * @param changePassword the changePassword to set
	 */
	public void setChangePassword(By changePassword) {
		this.changePassword = changePassword;
	}
	/**
	 * @return the balanceEnquiry
	 */
	public By getBalanceEnquiry() {
		return balanceEnquiry;
	}
	/**
	 * @param balanceEnquiry the balanceEnquiry to set
	 */
	public void setBalanceEnquiry(By balanceEnquiry) {
		this.balanceEnquiry = balanceEnquiry;
	}
	/**
	 * @return the miniStatement
	 */
	public By getMiniStatement() {
		return miniStatement;
	}
	/**
	 * @param miniStatement the miniStatement to set
	 */
	public void setMiniStatement(By miniStatement) {
		this.miniStatement = miniStatement;
	}
	/**
	 * @return the customisedStatement
	 */
	public By getCustomisedStatement() {
		return customisedStatement;
	}
	/**
	 * @param customisedStatement the customisedStatement to set
	 */
	public void setCustomisedStatement(By customisedStatement) {
		this.customisedStatement = customisedStatement;
	}
	/**
	 * @return the logout
	 */
	public By getLogout() {
		return logout;
	}
	/**
	 * @param logout the logout to set
	 */
	public void setLogout(By logout) {
		this.logout = logout;
	}
}
