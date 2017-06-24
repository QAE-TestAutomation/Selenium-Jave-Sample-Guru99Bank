package com.fleetcycle.Locators;

import org.openqa.selenium.By;

public class LoginPage {

	private By userName = By.name("uid");
	private By password = By.name("password");
	private By login = By.name("btnLogin");
	private By reset = By.name("btnReset");
	private By userNameMandatoryText = By.id("message23");
	private By passwordMandatoryText = By.id("message18");
	
	/**
	 * @return the userName
	 */
	public By getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(By userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public By getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(By password) {
		this.password = password;
	}
	/**
	 * @return the login
	 */
	public By getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(By login) {
		this.login = login;
	}
	/**
	 * @return the reset
	 */
	public By getReset() {
		return reset;
	}
	/**
	 * @param reset the reset to set
	 */
	public void setReset(By reset) {
		this.reset = reset;
	}
	/**
	 * @return the userNameMandatoryText
	 */
	public By getUserNameMandatoryText() {
		return userNameMandatoryText;
	}
	/**
	 * @param userNameMandatoryText the userNameMandatoryText to set
	 */
	public void setUserNameMandatoryText(By userNameMandatoryText) {
		this.userNameMandatoryText = userNameMandatoryText;
	}
	/**
	 * @return the passwordMandatoryText
	 */
	public By getPasswordMandatoryText() {
		return passwordMandatoryText;
	}
	/**
	 * @param passwordMandatoryText the passwordMandatoryText to set
	 */
	public void setPasswordMandatoryText(By passwordMandatoryText) {
		this.passwordMandatoryText = passwordMandatoryText;
	}
}
