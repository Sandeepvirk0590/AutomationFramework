package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class VoucherSuccessPage extends TestBase {

	public VoucherSuccessPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//h1[text()='Purchase a Gift Certificate']")
	WebElement purchaseMessageForGiftCertificate;

	public String getpurchaseMessageForGiftCertificate() {
		return purchaseMessageForGiftCertificate.getText();
	}

}
