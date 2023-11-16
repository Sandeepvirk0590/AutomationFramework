package com.naveenautomation.TestPages;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.Path33Page;

public class Path33PageTest extends TestBase {

	LoginPage loginPage;
	AccountPage accountPage;
	Path33Page path33Page;

	@BeforeMethod
	public void launch() {
		intialisation();
		loginPage = new LoginPage();
	}

	@Test(enabled = false)
	public void validateCamerasAsTextAvailable() {
		accountPage = loginPage.SubmitLogin("sandeepkaur1@gmail.com", "sandy");
		path33Page = accountPage.getPath33PageLink();
		Assert.assertEquals(path33Page.getTextAsCameras(), "Cameras", "Failed to get Page!");
	}

	@Test(enabled = false)
	public void validateIfUserCanAddCanonForComparisonSuccessfully() {
		accountPage = loginPage.SubmitLogin("sandeepkaur1@gmail.com", "sandy");
		path33Page = accountPage.getPath33PageLink();
		path33Page.addingCanonCameraInCompareList();
		Assert.assertEquals(path33Page.getSuccessMessageIfCanonAddedToComparison(), "Success: You have added",
				"Failed To add Canon for comparison");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
