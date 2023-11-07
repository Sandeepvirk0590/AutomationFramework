package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class NewsletterSubscriptionPage extends TestBase {

	public NewsletterSubscriptionPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "input[value='1']")
	WebElement yesRadioBtn;

	@FindBy(css = "input[type='submit']")
	WebElement continueButtonFromNewsletterSubscription;

	public AccountPage getNewspaperSubscription() {
		yesRadioBtn.click();
		continueButtonFromNewsletterSubscription.click();
		return new AccountPage();
	}

}
