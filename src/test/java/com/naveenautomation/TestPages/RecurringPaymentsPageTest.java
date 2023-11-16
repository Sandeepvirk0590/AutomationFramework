package com.naveenautomation.TestPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.NavigationBarOnEveryPage;
import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.RecurringPaymentsPage;

public class RecurringPaymentsPageTest extends TestBase {
	LoginPage loginPage;
	AccountPage accountPage;
	RecurringPaymentsPage recurringPage;

	@BeforeMethod
	public void launch() {
		intialisation();
		loginPage = new LoginPage();
	}

	@Test (enabled=false)
	public void validateIfUserHasNoRecurringPayments() {
		accountPage = loginPage.SubmitLogin("sandeepkaur1@gmail.com", "sandy");
		recurringPage = accountPage.checkYourRecurringPayments(NavigationBarOnEveryPage.RECURRING_PAYMENTS);
		Assert.assertEquals(recurringPage.getTextForNoRecurringPayments(), "No recurring payments found!",
				"Your recurring payments are listed");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
