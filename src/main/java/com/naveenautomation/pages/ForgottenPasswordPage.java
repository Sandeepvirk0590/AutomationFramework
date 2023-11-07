package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class ForgottenPasswordPage extends TestBase {

	public ForgottenPasswordPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(id = "input-email")
	WebElement inputEmailForForgottenPassword;

	@FindBy(css = "input[type='Submit']")
	WebElement continueButtonForForgottenPassword;

	@FindBy(css = "div.alert")
	WebElement emailFailedWaringMessage;

	private void enterEmail(String email) {
		inputEmailForForgottenPassword.sendKeys(email);
	}

	public void resetPasswordIfForgotten(String email) {
		enterEmail(email);
		continueButtonForForgottenPassword.click();
	}

	public String getFailedMessage() {
		return emailFailedWaringMessage.getText();
	}

}
