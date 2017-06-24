package com.fleetcycle.Flows;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fleetcycle.Implementation.Login;
import com.fleetcycle.Interface.ILogin;

public class LoginFlow {

	private ILogin loginFlow = new Login();

	@BeforeTest
	public void setUp() {
		loginFlow.setUp();
	}
	
	@Test(priority = 1)
	public void verifyLoginWithBlankUnameAndPwd(){
		loginFlow.verifyLoginWithBlankUnameAndPwd();
	}
	
	@Test(priority = 2)
	public void verifyLoginWithInvalidPassword(){
		loginFlow.verifyLoginWithInvalidPassword();
	}
	
	@Test(priority = 3)
	public void verifyLoginWithInvalidUserName(){
		loginFlow.verifyLoginWithInvalidUserName();
	}

	@Test(priority = 4)
	public void verifyReset(){
		loginFlow.verifyReset();
	}
	
	@Test(priority = 5)
	public void verifyReqMessageWhenUserNameIsBlank(){
		loginFlow.verifyReqMessageWhenUserNameIsBlank();
	}

	@Test(priority = 6)
	public void verifyReqMessageWhenPasswordIsBlank(){
		loginFlow.verifyReqMessageWhenPasswordIsBlank();
	}
	
	@Test(priority = 7)
	public void verifyLogin(){
		loginFlow.verifyLogin();
	}
	
	@Test(priority = 8)
    public void verifyLoggedManagerId(){
        loginFlow.verifyLoggedManagerId();
    }
	
	@Test(priority = 9)
	public void verifyLogoutWhenNavigateBack(){
		loginFlow.verifyLogoutWhenNavigateBack();
	}
	
	@AfterTest
	public void close(){
		loginFlow.closeSession();
	}
}
