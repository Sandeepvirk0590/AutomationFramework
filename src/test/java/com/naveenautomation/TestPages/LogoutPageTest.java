package com.naveenautomation.TestPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.NavigationBarOnEveryPage;
import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.LogoutPage;

public class LogoutPageTest extends TestBase {

	LoginPage loginPage;
	LogoutPage logoutPage;
	AccountPage accountPage;

	@BeforeMethod
	public void launch() {
		intialisation();
		loginPage = new LoginPage();
	}

	@Test
	public void validateLogoutFunctionality() {
		accountPage = loginPage.SubmitLogin("sandeepkaur1@gmail.com", "sandy");
		logoutPage= accountPage.logoutYourAccount(NavigationBarOnEveryPage.LOGOUT);
		Assert.assertEquals(logoutPage.getAccountLogoutText(), "Account Logout", "Click logout Button to logout!");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
