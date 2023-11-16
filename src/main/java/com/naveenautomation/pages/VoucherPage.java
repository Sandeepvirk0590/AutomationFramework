package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class VoucherPage extends TestBase {

	public VoucherPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "#input-to-name")
	WebElement inputRecipentsName;

	@FindBy(css = "#input-to-email")
	WebElement inputRecipentsEmail;

	@FindBy(css = "input[value='6']")
	WebElement radioBtnForChristmasTheme;

	@FindBy(css = "#input-message")
	WebElement messageBox;

	@FindBy(css = "#input-amount")
	WebElement inputAmount;

	@FindBy(css = "input[name='agree']")
	WebElement checkBoxForAgreement;

	@FindBy(css = "input[value='Continue']")
	WebElement continueButtonforGiftCertificate;

	@FindBy(xpath = "//div[text()='E-Mail Address does not appear to be valid!']")
	WebElement emailNotValidMessage;

	private void enterRecipentName(String rName) {
		inputRecipentsName.sendKeys(rName);
	}

	private void enterRecipentEmail(String rEmail) {
		inputRecipentsEmail.sendKeys(rEmail);
	}

	private void enterMessageForRecipient(String message) {
		messageBox.sendKeys(message);
	}

	private void enterAmount(String amount) {
		inputAmount.sendKeys(amount);
	}

	public VoucherSuccessPage fillGiftCertificateForm(String rName, String rEmail, String message, String amount) {
		enterRecipentName(rName);
		enterRecipentEmail(rEmail);
		radioBtnForChristmasTheme.click();
		enterMessageForRecipient(message);
		enterAmount(amount);
		checkBoxForAgreement.click();
		continueButtonforGiftCertificate.click();
		return new VoucherSuccessPage();
	}

	public String getEmailNotValidMessage() {
		return emailNotValidMessage.getText();

	}

}
