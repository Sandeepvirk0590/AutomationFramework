package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class SpecialsPage extends TestBase {

	public SpecialsPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "button[data-original-title='Compare this Product']")
	WebElement addAppleCinemaToCompareList;

	@FindBy(xpath = "//a[text()='product comparison']")
	WebElement successMessage;

	public void addToCompareList() {
		addAppleCinemaToCompareList.click();
	}

	public String getAddToCompareSucessMessgae() {
		return successMessage.getText();
	}

}
