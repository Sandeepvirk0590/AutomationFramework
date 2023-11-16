package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class EditAddressPage extends TestBase {

	public EditAddressPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "input[value='1']")
	WebElement yesButtonForDefaultAddress;

	@FindBy(css = "input[type='submit']")
	WebElement submitButtonForAddress;

	public AddressPage makeExistingAddressAsDefaultAddress() {
		yesButtonForDefaultAddress.click();
		submitButtonForAddress.submit();
		return new AddressPage();
	}

}
