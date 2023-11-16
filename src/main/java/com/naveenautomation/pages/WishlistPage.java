package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class WishlistPage extends TestBase {

	public WishlistPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//td[text()='Out Of Stock']")
	WebElement availabilityOfItem;

	@FindBy(css = "a[data-original-title='Remove']")
	WebElement clickRemoveButton;

	@FindBy(css = "div.alert")
	WebElement successMessageOfModifyingWishlist;

	public void deleteItemFromWishlist() {
		clickRemoveButton.click();
	}

	public String getWishlistModifyingSuccessMessage() {
		return successMessageOfModifyingWishlist.getText();
	}

}
