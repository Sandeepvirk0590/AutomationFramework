package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class VoucherPage extends TestBase {
	
	public VoucherPage() {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(css="#input-to-name")
	WebElement inputRecipentsName;
	
	@FindBy(css="#input-to-email")
	WebElement inputRecipentsEmail;
	
	@FindBy(css="input[value='6']")
	WebElement radioBtnForChristmasTheme;
	
	@FindBy(css="#input-message")
	WebElement messageBox;
	
	@FindBy(css="#input-amount")
	WebElement inputAmount;
	
	@FindBy(css="input[name='agree']")
	WebElement checkBoxForAgreement;
	
	@FindBy(css="input[value='Continue']")
	WebElement continueButtonforGiftCertificate;
	
	public VoucherSuccessPage fillGiftCertificateForm() {
		inputRecipentsName.sendKeys("Gurjap");
		inputRecipentsEmail.sendKeys("gurjap@gmail.com");
		radioBtnForChristmasTheme.click();
		messageBox.sendKeys("MerryChristmas");
		inputAmount.sendKeys("00");
		checkBoxForAgreement.click();
		continueButtonforGiftCertificate.click();
		return new VoucherSuccessPage();		
	}

}
