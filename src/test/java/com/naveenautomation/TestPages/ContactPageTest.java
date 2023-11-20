package com.naveenautomation.TestPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.ContactPage;
import com.naveenautomation.pages.LoginPage;

public class ContactPageTest extends TestBase {

	LoginPage loginPage;
	AccountPage accountPage;
	ContactPage contactPage;

	@BeforeMethod
	public void launch() {
		intialisation();
		loginPage = new LoginPage();
	}

	@Test
	public void validateIfContactUsFailedWithNoEmailInput() {
		accountPage = loginPage.SubmitLogin("gurjapvirk@gmail.com", "gurjap");
		contactPage = accountPage.ContactFormPage();
		contactPage.fillContactForm("Sandeep", " ", "Do You have Iphone 15 in stock?");
		Assert.assertEquals(contactPage.getTextForInvalidEmail(), "E-Mail Address does not appear to be valid!",
				"Enquiry Submitted");
	}

	@Test
	public void validateIfContactUsFailedWithLessEnquiryChar() {
		accountPage = loginPage.SubmitLogin("gurjapvirk@gmail.com", "gurjap");
		contactPage = accountPage.ContactFormPage();
		contactPage.fillContactForm("Sandeep", "sandeep@gmail.com", "Iphone15?");
		Assert.assertEquals(contactPage.getTextForLessCharForEnquiry(),
				"Enquiry must be between 10 and 3000 characters!", "Enquiry Submitted");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
