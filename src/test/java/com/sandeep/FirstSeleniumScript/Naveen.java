package com.sandeep.FirstSeleniumScript;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Naveen extends ChromeBrowser {

	private String actualTitle;
	private String expectedTitle;

	@BeforeMethod
	private void setup() {
		launchBrowser();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}

	@Test
	private void validateFromLoginToCheckout() {
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("sandy@gmail.com");

		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Sandeep1");

		isElementClickable(By.cssSelector("input[type='submit']"), 5).click();

		WebElement myAccountText = isElementDisplayed(By.cssSelector("#content>h2:first-of-type"), 5);
		Assert.assertEquals(myAccountText.getText(), "My Account", "Text not displayed, hence login Failed");

		actualTitle = driver.getTitle();
		expectedTitle = "My Account";
		Assert.assertEquals(actualTitle, expectedTitle, "The title is not what expected");

		isElementClickable(By.cssSelector("ul[class='nav navbar-nav']>li:nth-of-type(6)"), 10).click();

		actualTitle = driver.getTitle();
		expectedTitle = "Phones & PDAs";
		Assert.assertEquals(actualTitle, expectedTitle, "The title is not what expected");

		isElementClickable(By.cssSelector("div[class='caption']>h4>a"), 5).click();

//		try {
//			driver.navigate().to(
//					"https://naveenautomationlabs.com/opencart/index.php?route=product/product&path=24&product_id=28");
			isElementClickable(By.xpath("//button[text()='Add to Cart']"), 5).click();

			WebElement cartButton = driver.findElement(By.cssSelector("#cart>button[type='button']"));
			cartButton.click();
			Assert.assertEquals(cartButton.getAttribute("aria-expanded"), "true", "Item is not added in the cart");

//			Click on checkout
			driver.findElement(By.xpath("//strong[text()=' Checkout']")).click();
			
//		} catch (NoSuchElementException e) {
			
			WebElement shoppingCartPage = isElementDisplayed(By.cssSelector("#checkout-cart"), 10);
			
			String availabilityWarning = shoppingCartPage.getText();
			
			if(availabilityWarning.equals("Products marked with *** are not available in the desired quantity or not in stock! ")) {

//			Remove unavailable product from cart
			driver.findElement(By.cssSelector("button[title='Remove']")).click();
			sleep();
			driver.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=product/category&path=24");
			List<WebElement> listOfElements = driver.findElements(By.cssSelector("#column-left>div[class='list-group']"));
			for (int i = 0; i < listOfElements.size(); i++) {
				if (listOfElements.get(i).getText().equals("MP3 Players (4)")) {
					listOfElements.get(i).click();
				}
			}
		}

//		driver.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=product/category&path=34");
//		Selecting IPod Touch
		driver.findElement(By.xpath("//a[text()='iPod Touch']")).click();

//		adding pod to cart
		driver.findElement(By.xpath("//button[text()='Add to Cart']")).click();

//		validating cart
		WebElement cartButton2 = driver.findElement(By.cssSelector("#cart-total"));
		Assert.assertEquals(cartButton2.getText(), " 1 item(s) - $122.00", "Item is not added yet!");
		cartButton2.click();
		Assert.assertEquals(cartButton2.getAttribute("aria-expanded"), "true", "Item is not added in the cart");

//      Click on checkout
		driver.findElement(By.xpath("//strong[text()=' Checkout']")).click();

//      Filling billing details Step 1
		driver.findElement(By.cssSelector("#input-payment-firstname")).sendKeys("Sandeep");
		driver.findElement(By.cssSelector("#input-payment-lastname")).sendKeys("Kaur");
		driver.findElement(By.cssSelector("#input-payment-address-1")).sendKeys("66 Drake Blvd");
		driver.findElement(By.cssSelector("#input-payment-city")).sendKeys("Brampton");
		driver.findElement(By.cssSelector("#input-payment-postcode")).sendKeys("L6T 3K9");

		selectFromDropDown(driver.findElement(By.cssSelector("#input-payment-country")), "Canada");
		selectFromDropDown(driver.findElement(By.cssSelector("#input-payment-zone")), "Nunavut");

//		continue from Step 2
		driver.findElement(By.cssSelector("input[id=button-payment-address]")).click();

//		click on radio button for existing address
		isElementClickable(By.cssSelector("input[name='shipping_address']"), 10).click();

		WebElement displayBlock = isElementDisplayed(By.cssSelector("div[id='shipping-existing']>select"), 10);
		Assert.assertEquals(displayBlock.getText(), "Sandeep Kaur, 66 Drake Blvd, Brampton, Nunavut, Canada",
				"Address didnt match!");

//		continue from Step 3
		driver.findElement(By.cssSelector("input[id='button-shipping-address']")).click();
		
//      radio button on Step 4 (Shipping method)
		isElementClickable(By.cssSelector("input[name='shipping_method']"), 10).click();
		
		driver.findElement(By.cssSelector("textarea[name='comment']")).sendKeys("Is this item comes with warranty?");

//		continue from Step 4
		driver.findElement(By.cssSelector("input[id='button-shipping-method']")).click();
		
		isElementClickable(By.cssSelector("input[name='payment_method']"), 10).click();
		
		
		
		

	}

	@AfterMethod
	private void tearDown() {
		driver.close();
	}

}
