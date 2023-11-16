package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class AffiliateEditPage extends TestBase {

	public AffiliateEditPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "#input-company")
	WebElement inputCompany;

	@FindBy(css = "#input-website")
	WebElement inputWebsite;

	@FindBy(css = "#input-tax")
	WebElement inputTaxId;

	@FindBy(css = "input[value='cheque']")
	WebElement radioCheque;

	@FindBy(css = "input[value='paypal']")
	WebElement radioPaypal;

	@FindBy(css = "input[value='bank']")
	WebElement radioBankTransfer;

	@FindBy(css = "#input-cheque")
	WebElement inputChequePayeeName;

	@FindBy(css = "input[type='checkbox']")
	WebElement inputAgreeCheckbox;

	@FindBy(css = "input[type='submit']")
	WebElement submitButton;

	@FindBy(xpath = "//div[text()='Cheque Payee Name required!']")
	WebElement textThatPayeeNameIsRequired;

	private void enterCompanyName(String company) {
		inputCompany.sendKeys(company);
	}

	private void enterWebsiteName(String website) {
		inputWebsite.sendKeys(website);
	}

	private void enterTaxId(String taxId) {
		inputTaxId.sendKeys(taxId);
	}

	private void clickRadioCheque() {
		radioCheque.click();
	}

	private void clickRadioPaypal() {
		radioPaypal.click();
	}

	private void clickRadioBank() {
		radioBankTransfer.click();
	}

	private void enterChequePayeeName(String chequePayee) {
		inputChequePayeeName.sendKeys(chequePayee);
	}

//	private void clickAgreeCheckbox() {
//		inputAgreeCheckbox.click();
//	}

	private void clickSubmitButton() {
		submitButton.submit();
	}

	public void fillTheAffiliateEditForm(String company, String website, String taxId, boolean chooseRadioButtoncheque,
			String chequePayee) {
		inputCompany.clear();
		enterCompanyName(company);
		inputWebsite.clear();
		enterWebsiteName(website);
		inputTaxId.clear();
		enterTaxId(taxId);

		if (chooseRadioButtoncheque) {
			clickRadioCheque();
		} else if (!chooseRadioButtoncheque) {
			clickRadioPaypal();
		} else {
			clickRadioBank();
		}
		inputChequePayeeName.clear();
		enterChequePayeeName(chequePayee);
//		clickAgreeCheckbox();
		clickSubmitButton();

	}

	public String getTextThatPayeeNameIsRequired() {
		return textThatPayeeNameIsRequired.getText();
	}

	public boolean isChequeRadioButtonSelected() {
		return radioCheque.isSelected();
	}

	public boolean isPaypalRadioButtonSelected() {
		return radioPaypal.isSelected();
	}

	public boolean isBankRadioButtonSelected() {
		return radioBankTransfer.isSelected();
	}

}
