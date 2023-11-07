package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.naveenautomation.base.TestBase;

public class AddressAddPage extends TestBase {

	public AddressAddPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "#input-firstname")
	WebElement inputFirstName;

	@FindBy(css = "#input-lastname")
	WebElement inputLastName;

	@FindBy(css = "#input-address-1")
	WebElement inputStreetAddress;

	@FindBy(css = "#input-city")
	WebElement inputCity;

	@FindBy(css = "#input-postcode")
	WebElement inputPostalCode;

	@FindBy(css = "#input-country")
	WebElement selectCountry;

	@FindBy(css = "#input-zone")
	WebElement selectRegion;

	@FindBy(css = "input[value='0']")
	WebElement radioButtonForNoOption;

	@FindBy(css = "input[type='submit']")
	WebElement submitButtonForAddress;


	private void enterFirstName(String firstName) {
		inputFirstName.sendKeys(firstName);
	}

	private void enterLastName(String lastName) {
		inputLastName.sendKeys(lastName);
	}

	private void enterAddressLine(String streetAddress) {
		inputStreetAddress.sendKeys(streetAddress);
	}

	private void enterCity(String cityName) {
		inputCity.sendKeys(cityName);
	}
	
	private void enterPostalCode(String postalCode) {
		inputPostalCode.sendKeys(postalCode);
	}

	private void selectCountryFromDropDown(String visibleTextOfCountry) {
		Select sc = new Select(selectCountry);
		sc.selectByVisibleText(visibleTextOfCountry);
	}
	
	private void selectRegionFromDropDown(String visibleTextOfRegion) {
		Select sc = new Select(selectRegion);
		sc.selectByVisibleText(visibleTextOfRegion);
	}

	public AddressPage formToAddNewAddress(String firstName, String lastName, String streetAddress, String cityName,
			String postalCode, String visibleTextOfCountry, String visibleTextOfRegion) {
		enterFirstName(firstName);
		enterLastName(lastName);
		enterAddressLine(streetAddress);
		enterCity(cityName);
		enterPostalCode(postalCode);
		selectCountryFromDropDown(visibleTextOfCountry);
		selectRegionFromDropDown(visibleTextOfRegion);
		radioButtonForNoOption.click();
		submitButtonForAddress.submit();
		return new AddressPage();
	}

}
