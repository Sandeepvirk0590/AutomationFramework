package com.sandeep.FirstSeleniumScript;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NaveenAutomationTestingValidation extends ChromeBrowser {

	private String actualTitle;
	private String expectedTitle;

	@BeforeMethod
	private void setup() {
		launchBrowser();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}

	@Test(priority = 1)
	private void validateLoginCredentials() {
		WebElement emailInput = driver.findElement(By.cssSelector("input[name='email']"));
		emailInput.sendKeys("sandy@gmail.com");

		WebElement passwordInput = driver.findElement(By.cssSelector("input[name='password']"));
		passwordInput.sendKeys("Sandeep1");

		WebElement loginBtn = isElementClickable(By.cssSelector("input[type='submit']"), 5);
		loginBtn.click();

		WebElement myAccountText = isElementDisplayed(By.cssSelector("#content>h2:first-of-type"), 5);
		Assert.assertEquals(myAccountText.getText(), "My Account", "Text not displayed, hence login Failed");

	}

	@Test(priority = 2)
	private void validateMyAccountPage() {

		driver.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=account/account");
		actualTitle = driver.getTitle();
		expectedTitle = "My Account";
		Assert.assertEquals(actualTitle, expectedTitle, "The title is not what expected");

		WebElement navBarPhnPdaLink = isElementClickable(By.cssSelector("ul[class='nav navbar-nav']>li:nth-of-type(6)"),
				10);
		actions.click(navBarPhnPdaLink).perform();

	}

	@Test(priority = 3)
	private void validateSelectAnItem() {
		driver.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=product/category&path=24");

		actualTitle = driver.getTitle();
		expectedTitle = "Phones & PDAs";
		Assert.assertEquals(actualTitle, expectedTitle, "The title is not what expected");

		WebElement selectItem = isElementClickable(By.xpath("//a[text()='HTC Touch HD']"), 5);
		actions.click(selectItem).perform();
	}

	@Test(priority = 4)
	private void validateAddToCart() {
		try {
			driver.navigate().to(
					"https://naveenautomationlabs.com/opencart/index.php?route=product/product&path=24&product_id=28");
			WebElement addToCartButton = isElementClickable(By.xpath("//button[text()='Add to Cart']"), 5);
			actions.click(addToCartButton).perform();

			WebElement cartButton = driver.findElement(By.cssSelector("#cart>button[type='button']"));
			actions.click(cartButton).perform();
			Assert.assertEquals(cartButton.getAttribute("aria-expanded"), "true", "Item is not added in the cart");

			WebElement checkOutButton = driver.findElement(By.xpath("//strong[text()=' Checkout']"));
			actions.click(checkOutButton).perform();
		} catch (NoSuchElementException e) {

			driver.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=product/category&path=24");
			List<WebElement> listOfElements = driver
					.findElements(By.cssSelector("#column-left>div[class='list-group']"));
			for (int i = 0; i < listOfElements.size(); i++) {
				if (listOfElements.get(i).getText().equals("MP3 Players (4)")) {
					listOfElements.get(i).click();
				}
			}

		}

		driver.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=product/category&path=34");
		WebElement selectIpod = driver.findElement(By.xpath("//a[text()='iPod Touch']"));
		actions.click(selectIpod).perform();

	}

	@Test(priority = 5)
	private void validateCart() {
		driver.navigate()
				.to("https://naveenautomationlabs.com/opencart/index.php?route=product/product&path=34&product_id=32");
		WebElement addToCartButton2 = driver.findElement(By.xpath("//button[text()='Add to Cart']"));
		actions.click(addToCartButton2).perform();
		
		WebElement cartButton2 = driver.findElement(By.xpath("//span[text()=' 1 item(s) - $100.00']"));
		Assert.assertEquals(cartButton2.getText(), " 1 item(s) - $100.00", "Item is not added yet!");
		actions.click(cartButton2).perform();
		Assert.assertEquals(cartButton2.getAttribute("aria-expanded"), "true", "Item is not added in the cart");
		
		WebElement checkOutButton2 = driver.findElement(By.xpath("//strong[text()=' Checkout']"));
		actions.click(checkOutButton2).perform();
	}
	
	@Test(priority=6)
	private void validateCheckoutBillingDetails() {
		driver.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=checkout/checkout");
		
		WebElement nameInputInBilling = driver.findElement(By.cssSelector("#input-payment-firstname"));
		nameInputInBilling.sendKeys("Sandeep");

		WebElement lastInputInBilling = driver.findElement(By.cssSelector("#input-payment-lastname"));
		lastInputInBilling.sendKeys("Kaur");

		WebElement address1Input = driver.findElement(By.cssSelector("#input-payment-address-1"));
		address1Input.sendKeys("4014 anuri street");

		WebElement cityInput = driver.findElement(By.cssSelector("#input-payment-city"));
		cityInput.sendKeys("Iqaluit");

		WebElement postalCodeInput = driver.findElement(By.cssSelector("#input-payment-postcode"));
		postalCodeInput.sendKeys("X0B 1B0");

		selectFromDropDown(driver.findElement(By.cssSelector("#input-payment-country")), "Canada");
		selectFromDropDown(driver.findElement(By.cssSelector("#input-payment-zone")), "Nunavut");

		WebElement continueButton = driver.findElement(By.cssSelector("input[id=button-payment-address]"));
		actions.click(continueButton).perform();
		
		Assert.assertEquals(continueButton.getAttribute("disabled"), "disabled");
		
	}
		
	

	@AfterMethod
	private void tearDown() {
		driver.close();
	}
}
