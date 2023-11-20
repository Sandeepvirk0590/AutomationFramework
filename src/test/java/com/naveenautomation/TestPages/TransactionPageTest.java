package com.naveenautomation.TestPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.NavigationBarOnEveryPage;
import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.TransactionPage;

public class TransactionPageTest extends TestBase {

	LoginPage loginPage;
	AccountPage accountPage;
	TransactionPage transactionPage;

	@BeforeMethod
	public void launch() {
		intialisation();
		loginPage = new LoginPage();
	}

	@Test
	public void validateIfUserHasNotAnyTransaction() {
		accountPage = loginPage.SubmitLogin("gurjapvirk@gmail.com", "gurjap");
		transactionPage = accountPage.checkYourTransactions(NavigationBarOnEveryPage.TRANSACTIONS);
		Assert.assertEquals(transactionPage.getTextForNoTransaction(), "You do not have any transactions!",
				"Your transactions are displayed!");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
