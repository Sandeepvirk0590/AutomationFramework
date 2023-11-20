package com.naveenautomation.TestPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.NavigationBarOnEveryPage;
import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.AffiliateEditPage;
import com.naveenautomation.pages.UpdatePasswordPage;
import com.naveenautomation.pages.EditAccountInfoPage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.NewsletterSubscriptionPage;
import com.naveenautomation.pages.ProductReturnPage;

public class AccountPageTest extends TestBase {

	LoginPage loginPage;
	AccountPage accountPage;
	EditAccountInfoPage editPage;
	NewsletterSubscriptionPage newsletterSubscriptionPage;
	UpdatePasswordPage changePasswordPage;
	AffiliateEditPage affiliateEditPage;
	ProductReturnPage productReturnPage;

	@BeforeMethod
	public void launch() {
		intialisation();
		loginPage = new LoginPage();
	}

	@Test
	public void validateUserCanUpdatePersonalInfo() {
		accountPage = loginPage.SubmitLogin("gurjapvirk@gmail.com", "gurjap");
		editPage = accountPage.clickEditInfoLink(NavigationBarOnEveryPage.EDIT_ACCOUNT);
		editPage.enterFName("SandeepKaur");
		accountPage = editPage.clickSubmitBtn();
		Assert.assertEquals(accountPage.getInfoUpdateSuccessMessage(),
				"Success: Your account has been successfully updated.", "Info not updated");
	}

	@Test
	public void validateNewspaperSubsciption() {
		accountPage = loginPage.SubmitLogin("gurjapvirk@gmail.com", "gurjap");
		newsletterSubscriptionPage = accountPage.clickNewsletterSubscriptionLink(NavigationBarOnEveryPage.NEWSLETTER);
		newsletterSubscriptionPage.getNewspaperSubscription();
		Assert.assertEquals(accountPage.getNewspaperSubsciptionSuccessMessage(),
				"Success: Your newsletter subscription has been successfully updated!", "Subscription Failed!");
	}

	@Test
	public void validateIfUserCanFillAffiliateEditForm() {
		accountPage = loginPage.SubmitLogin("gurjapvirk@gmail.com", "gurjap");
		affiliateEditPage = accountPage.clickOnAffiliatePageLink();
		affiliateEditPage.fillTheAffiliateEditForm("XYZ Company", "naveenAutomation", "TD123", true, "SandeepK");
		Assert.assertEquals(accountPage.getEditAffiliateSuccessMessage(),
				"Success: Your account has been successfully updated.", "Failed to edit affiliate");
	}

	@Test
	public void validateProductReturn() {
		accountPage = loginPage.SubmitLogin("gurjapvirk@gmail.com", "gurjap");
		productReturnPage = accountPage.productReturnLink(NavigationBarOnEveryPage.RETURNS);
		Assert.assertEquals(productReturnPage.productReturn(), "You have not made any previous returns!",
				"Return in process!");
		productReturnPage.continueButton();
		Assert.assertEquals(accountPage.getMyAccountText(), "My Account");
	}

//	@Test
//	public void validateUserUpdatePassword() {
//		accountPage = loginPage.SubmitLogin("sandeepkaur1@gmail.com", "sandy");
//		changePasswordPage = accountPage.clickPasswordLink(NavigationBarOnEveryPage.PASSWORD);
//		changePasswordPage.SubmitContinueForPasswordChange("sandeep", "sandeep");
//	Assert.assertEquals(accountPage.getUpdatePasswordSuccessMessage(),
//				"Success: Your password has been successfully updated.", "Password not Changed!");
//	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
}
