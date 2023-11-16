package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class ContactPage extends TestBase {

	public ContactPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "#input-name")
	WebElement inputName;

	@FindBy(css = "#input-email")
	WebElement inputEmail;

	@FindBy(css = "#input-enquiry")
	WebElement inputEnquiry;

	@FindBy(css = "input[type='submit']")
	WebElement submitButton;

	@FindBy(xpath = "//div[text()='E-Mail Address does not appear to be valid!']")
	WebElement textForInvalidEmail;

	@FindBy(xpath = "//div[text()='Enquiry must be between 10 and 3000 characters!']")
	WebElement textForLessCharForEnquiry;

	private void enterYourName(String name) {
		inputName.clear();
		inputName.sendKeys(name);
	}

	private void enterYourEmail(String email) {
		inputEmail.clear();
		inputEmail.sendKeys(email);
	}

	private void enterYourEnquiry(String enquiry) {
		inputEnquiry.sendKeys(enquiry);
	}

	private void submitContactForm() {
		submitButton.submit();
	}

	public ContactSuccessPage fillContactForm(String name, String email, String enquiry) {
		enterYourName(name);
		enterYourEmail(email);
		enterYourEnquiry(enquiry);
		submitContactForm();
		return new ContactSuccessPage();
	}

	public String getTextForInvalidEmail() {
		return textForInvalidEmail.getText();
	}

	public String getTextForLessCharForEnquiry() {
		return textForLessCharForEnquiry.getText();
	}

}
