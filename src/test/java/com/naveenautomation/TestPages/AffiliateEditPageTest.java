package com.naveenautomation.TestPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.AffiliateEditPage;
import com.naveenautomation.pages.LoginPage;

public class AffiliateEditPageTest extends TestBase {

	LoginPage loginPage;
	AccountPage accountPage;
	AffiliateEditPage affiliateEditPage;

	@BeforeMethod
	public void launch() {
		intialisation();
		loginPage = new LoginPage();

	}

	@Test
	public void validateUserFailedToEditAffilateWithNoPayeeInput() {
		accountPage = loginPage.SubmitLogin("gurjapvirk@gmail.com", "gurjap");
		affiliateEditPage = accountPage.clickOnAffiliatePageLink();
		affiliateEditPage.fillTheAffiliateEditForm("XYZ Company", "naveenAutomation", "TD123", true, "");
		Assert.assertEquals(affiliateEditPage.getTextThatPayeeNameIsRequired(), "Cheque Payee Name required!",
				"Success: Your account has been successfully updated.");
	}
	
	
	
	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
