package com.naveenautomation.TestPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.NavigationBarOnEveryPage;
import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.RewardPage;

public class RewardPageTest extends TestBase {

	LoginPage loginPage;
	AccountPage accountPage;
	RewardPage rewardPage;

	@BeforeMethod
	public void launch() {
		intialisation();
		loginPage = new LoginPage();
	}

	@Test
	public void validateIfUserHasNoRewardPoints() {
		accountPage = loginPage.SubmitLogin("gurjapvirk@gmail.com", "gurjap");
		rewardPage = accountPage.checkYourRewardPoints(NavigationBarOnEveryPage.REWARD_POINTS);
		Assert.assertEquals(rewardPage.getMessageOfNoRewardPoints(), "You do not have any reward points!",
				"You have Reward Points!");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
