package com.naveenautomation.TestPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.VoucherPage;
import com.naveenautomation.pages.VoucherSuccessPage;

public class VoucherSuccessPageTest extends TestBase {

	LoginPage loginPage;
	AccountPage accountPage;
	VoucherPage voucherPage;
	VoucherSuccessPage voucherSuccessPage;

	@BeforeMethod
	public void launch() {
		intialisation();
		loginPage = new LoginPage();
	}

	@Test
	public void validateIfUserCanBuyVoucher() {
		accountPage = loginPage.SubmitLogin("sandeepkaur1@gmail.com", "sandy");
		voucherPage = accountPage.GiftCertificateFormPage();
		voucherSuccessPage = voucherPage.fillGiftCertificateForm();
		Assert.assertEquals(voucherSuccessPage.getpurchaseMessageForGiftCertificate(), "Purchase a Gift Certificate",
				"Failed to purchase Gift Certificate!");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
