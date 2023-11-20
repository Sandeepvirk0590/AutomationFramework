package com.naveenautomation.TestPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.NavigationBarOnEveryPage;
import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.AddressAddPage;
import com.naveenautomation.pages.AddressPage;
import com.naveenautomation.pages.EditAddressPage;
import com.naveenautomation.pages.LoginPage;

public class AddressPageTest extends TestBase {

	LoginPage loginPage;
	AccountPage accountPage;
	AddressPage addressPage;
	AddressAddPage addressFormPage;
	EditAddressPage editAddressPage;

	@BeforeMethod
	public void launch() {
		intialisation();
		loginPage = new LoginPage();
	}

	@Test
	public void validateIfUserCanAddNewAddress() {
		accountPage = loginPage.SubmitLogin("gurjapvirk@gmail.com", "gurjap");
		addressPage = accountPage.addNewAddress(NavigationBarOnEveryPage.ADDRESS_BOOK);
		addressFormPage = addressPage.clickButtonToAddAddress();
		addressFormPage.formToAddNewAddress("Sandeep", "Kaur", "89 Nova Scotia Rd", "Brampton", "L6Y5K1", "Canada",
				"Ontario");
		Assert.assertEquals(addressPage.getUpdateForAddingNewAddress(), "Your address has been successfully added",
				"Failed to add new Address!");
	}


	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
