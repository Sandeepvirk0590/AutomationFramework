package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class MacPage_20_27 extends TestBase {

	public MacPage_20_27() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "#content>h2")
	WebElement macHeading;

	@FindBy(css = "button[data-original-title='Add to Wish List']")
	WebElement addToWishListButton;

	@FindBy(xpath = "//a[text()='iMac']")
	WebElement successMessageForAddingToWishlist;

	public void addItemToWishlist() {
		addToWishListButton.click();
	}

	public String getAddToWishList() {
		return successMessageForAddingToWishlist.getText();
	}
}
