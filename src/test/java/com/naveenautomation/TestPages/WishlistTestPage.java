package com.naveenautomation.TestPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.NavigationBarOnEveryPage;
import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.WishlistPage;

public class WishlistTestPage extends TestBase {

	LoginPage loginPage;
	AccountPage accountPage;
	WishlistPage wishlistPage;

	@BeforeMethod
	public void launch() {
		intialisation();
		loginPage = new LoginPage();
	}

	@Test
	public void validateIfUserCanRemoveItemFromWishlistIfNotInStock() {
		accountPage = loginPage.SubmitLogin("sandeepkaur1@gmail.com", "sandy");
		wishlistPage = accountPage.goToYourWishlist(NavigationBarOnEveryPage.WISH_LIST);
		wishlistPage.deleteItemFromWishlist();
		Assert.assertEquals(wishlistPage.getWishlistModifyingSuccessMessage(),
				"Success: You have modified your wish list! ", "Failed to remove item from wishlist");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
