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
		accountPage = loginPage.SubmitLogin("sandeepkaur1@gmail.com", "sandy");
		affiliateEditPage = accountPage.clickOnAffiliatePageLink();
		affiliateEditPage.fillTheAffiliateEditForm("XYZ Company", "naveenAutomation", "TD123", true, "");
		Assert.assertEquals(affiliateEditPage.getTextThatPayeeNameIsRequired(), "Cheque Payee Name required!",
				"Success: Your account has been successfully updated.");
	}
	
//	@Test
//	public void validateRadioButtonSelection() {
//	    accountPage = loginPage.SubmitLogin("sandeepkaur1@gmail.com", "sandy");
//	    affiliateEditPage = accountPage.clickOnAffiliatePageLink();
//	    
//	    affiliateEditPage.fillTheAffiliateEditForm("XYZ Company", "naveenAutomation", "TD123", false, "Sandeep");
//	    
//	    Assert.assertTrue(affiliateEditPage.isChequeRadioButtonSelected(), "Cheque radio button should be selected.");
//	    Assert.assertFalse(affiliateEditPage.isPaypalRadioButtonSelected(), "Paypal radio button should not be selected.");
//	    Assert.assertFalse(affiliateEditPage.isBankRadioButtonSelected(), "Bank radio button should not be selected.");
//
//	    affiliateEditPage.fillTheAffiliateEditForm("XYZ Company", "naveenAutomation", "TD123", false, "Sandeep");
//
//	    Assert.assertFalse(affiliateEditPage.isChequeRadioButtonSelected(), "Cheque radio button should not be selected.");
//	    Assert.assertTrue(affiliateEditPage.isPaypalRadioButtonSelected(), "Paypal radio button should be selected.");
//	    Assert.assertFalse(affiliateEditPage.isBankRadioButtonSelected(), "Bank radio button should not be selected.");
//
//	    affiliateEditPage.fillTheAffiliateEditForm("XYZ Company", "naveenAutomation", "TD123", true, "Sandeep");
//
//	    Assert.assertFalse(affiliateEditPage.isChequeRadioButtonSelected(), "Cheque radio button should not be selected.");
//	    Assert.assertFalse(affiliateEditPage.isPaypalRadioButtonSelected(), "Paypal radio button should not be selected.");
//	    Assert.assertTrue(affiliateEditPage.isBankRadioButtonSelected(), "Bank radio button should be selected");
//	}

	
	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
