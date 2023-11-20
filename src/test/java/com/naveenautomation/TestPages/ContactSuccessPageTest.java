package com.naveenautomation.TestPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.ContactPage;
import com.naveenautomation.pages.ContactSuccessPage;
import com.naveenautomation.pages.LoginPage;

public class ContactSuccessPageTest extends TestBase {

	LoginPage loginPage;
	AccountPage accountPage;
	ContactPage contactPage;
	ContactSuccessPage contactSuccessPage;

	@BeforeMethod
	public void launch() {
		intialisation();
		loginPage = new LoginPage();
	}

	@Test
	public void validateIfUserCanSuccessfullySubmitEnquiryOnContactUs() {
		accountPage = loginPage.SubmitLogin("sandeepkaur1@gmail.com", "sandy");
		contactPage = accountPage.ContactFormPage();
		contactSuccessPage = contactPage.fillContactForm("Gurjap", "gurjapvirk@gmail.com",
				"Do You have Iphone 15 in stock?");
		Assert.assertEquals(contactSuccessPage.getTextThatEnquirySubmittedSuccessfully(),
				"Your enquiry has been successfully sent to the store owner!", "Failed to submit enquiry!");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
