package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class RewardPage extends TestBase {

	public RewardPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//td[text()='You do not have any reward points!']")
	WebElement discriptionOfRewardPoints;

	public String getMessageOfNoRewardPoints() {
		return discriptionOfRewardPoints.getText();

	}

}
