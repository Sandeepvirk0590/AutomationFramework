package com.naveenautomation.TestPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.NavigationBarOnEveryPage;
import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.DownloadsPage;
import com.naveenautomation.pages.LoginPage;

public class DownloadPageTest extends TestBase {

	LoginPage loginPage;
	AccountPage accountPage;
	DownloadsPage downloadPage;

	@BeforeMethod
	public void launch() {
		intialisation();
		loginPage = new LoginPage();
	}

	@Test
	public void validateIfUserHasNotAnyDownloads() {
		accountPage = loginPage.SubmitLogin("gurjapvirk@gmail.com", "gurjap");
		downloadPage = accountPage.checkDownloads(NavigationBarOnEveryPage.DOWNLOADS);
		Assert.assertEquals(downloadPage.getMessageRegardingDownloads(),
				"You have not made any previous downloadable orders!", "You have some downloads");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
