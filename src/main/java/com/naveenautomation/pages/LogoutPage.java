package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class LogoutPage extends TestBase {

	public LogoutPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//h1[text()='Account Logout']")
	WebElement logoutHeading;

	@FindBy(css = "a[class='btn btn-primary']")
	WebElement continueButton;

	public String getAccountLogoutText() {
		return logoutHeading.getText();
	}

}
