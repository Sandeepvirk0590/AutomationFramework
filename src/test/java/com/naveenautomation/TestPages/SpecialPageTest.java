package com.naveenautomation.TestPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.SpecialsPage;

public class SpecialPageTest extends TestBase {

	LoginPage loginPage;
	AccountPage accountPage;
	SpecialsPage specialPage;

	@BeforeMethod
	public void launch() {
		intialisation();
		loginPage = new LoginPage();
	}

	@Test
	public void validateIfUserCanAddProductToCompareList() {
		accountPage = loginPage.SubmitLogin("gurjapvirk@gmail.com", "gurjap");
		specialPage = accountPage.checkTheSpecialOffers();
		specialPage.addToCompareList();
		Assert.assertEquals(specialPage.getAddToCompareSucessMessgae(), "product comparison",
				"Product Failed to add for comparison!");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
