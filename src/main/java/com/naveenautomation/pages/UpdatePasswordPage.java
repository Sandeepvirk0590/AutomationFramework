package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class UpdatePasswordPage extends TestBase {

	public UpdatePasswordPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(id = "input-password")
	WebElement changePasswordInput;

	@FindBy(id = "input-confirm")
	WebElement confirmPasswordInput;

	@FindBy(css = "input[type='Submit']")
	WebElement continueButtonForPasswordChange;

	private void enterNewPassword(String newPassword) {
		changePasswordInput.sendKeys(newPassword);
	}

	private void confirmNewPassword(String confirmPassword) {
		confirmPasswordInput.sendKeys(confirmPassword);
	}

	public AccountPage SubmitContinueForPasswordChange(String newPassword, String confirmPassword) {
		enterNewPassword(newPassword);
		confirmNewPassword(confirmPassword);
		continueButtonForPasswordChange.click();
		return new AccountPage();
	}

}
