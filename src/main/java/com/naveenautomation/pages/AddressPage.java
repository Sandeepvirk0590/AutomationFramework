package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class AddressPage extends TestBase {

	public AddressPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//a[text()='New Address']")
	WebElement ButtonToAddNewAddress;

	@FindBy(css = "div.alert-success")
	WebElement addedAddressSuccessMessage;

	@FindBy(xpath = "//a[text()='Edit']")
	WebElement editAddressButton;
	
	@FindBy(css = "div.alert-success")
	WebElement updatedAddressSuccessMessage;

	public AddressAddPage clickButtonToAddAddress() {
		ButtonToAddNewAddress.click();
		return new AddressAddPage();
	}

	public String getUpdateForAddingNewAddress() {
		return addedAddressSuccessMessage.getText();
	}

	public EditAddressPage clickButtonToEditAddress() {
		editAddressButton.click();
		return new EditAddressPage();
	}
	
	public String getMessageForAddressUpdated() {
		return updatedAddressSuccessMessage.getText();
		
	}
}
