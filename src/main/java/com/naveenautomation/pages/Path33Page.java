package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class Path33Page extends TestBase {

	public Path33Page() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//h2[text()='Cameras']")
	WebElement camerasAsText;

	@FindBy(css = "button[onclick=\"compare.add('30');\"]")
	WebElement addCanonToCompare;

	@FindBy(css = "div.alert")
	WebElement successMessageForAddingInComparison;

	public String getTextAsCameras() {
		return camerasAsText.getText();
	}

	public void addingCanonCameraInCompareList() {
		addCanonToCompare.click();
	}

	public String getSuccessMessageIfCanonAddedToComparison() {
		return successMessageForAddingInComparison.getText();

	}

}
