package com.naveenautomation.TestPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.NavigationBarOnEveryPage;
import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.OrderHistoryPage;

public class OrderHistoryPageTest extends TestBase {

	LoginPage loginPage;
	AccountPage accountPage;
	OrderHistoryPage orderHistoryPage;

	@BeforeMethod
	public void launch() {
		intialisation();
		loginPage = new LoginPage();
	}

	@Test
	public void validateIfUserHasNotAnyOrderHistory() {
		accountPage = loginPage.SubmitLogin("sandeepkaur1@gmail.com", "sandy");
		orderHistoryPage = accountPage.checkorderHistory(NavigationBarOnEveryPage.ORDER_HISTORY);
		Assert.assertEquals(orderHistoryPage.getMessageOfNoOrderHistory(), "You have not made any previous orders!",
				"You have some order history");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
