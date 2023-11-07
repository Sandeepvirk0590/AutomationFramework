package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class ProductReturnPage extends TestBase {

	public ProductReturnPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//p[text()='You have not made any previous returns!']")
	WebElement productReturnText;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement continueButtonFromProductReturnPage;

	public AccountPage continueButton() {
		continueButtonFromProductReturnPage.click();
		return new AccountPage();
	}

	public String productReturn() {
		return productReturnText.getText();
	}

}
