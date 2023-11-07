package com.naveenautomation.TestPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.MacPage_20_27;

public class MacPageTest extends TestBase {

	LoginPage loginPage;
	AccountPage accountPage;
	MacPage_20_27 macPage;

	@BeforeMethod
	public void launch() {
		intialisation();
		loginPage = new LoginPage();
	}

	@Test
	public void validateIfUserCanAddMacToWishList() {
		accountPage = loginPage.SubmitLogin("sandeepkaur1@gmail.com", "sandy");
		macPage = accountPage.pageLinkToGoOnMac();
	    macPage.addItemToWishlist();
		Assert.assertEquals(macPage.getAddToWishList(), "iMac", "Item failed to add in Wish List.");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
}
