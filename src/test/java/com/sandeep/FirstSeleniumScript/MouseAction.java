package com.sandeep.FirstSeleniumScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseAction extends ChromeBrowser {

	Actions actions;

	@BeforeMethod
	public void setup() {
		launchBrowser();
		driver.get("https://www.lambtoncollege.ca/");
		actions = new Actions(driver);
	}

	@Test
	public void validateActionClick() {

		WebElement cookieAcceptBtn = isElementClickable(By.xpath("//span[.='Accept']"), 5);
		cookieAcceptBtn.click();

		WebElement cartBtn = isElementClickable(By.cssSelector("#button#cart"), 5);
		actions.click(cartBtn).perform();
		
//		Assert.assertEquals(cartBtn.getText(), "Check Out", "Text not displayed");

//		WebElement cartBtn = driver.findElement(By.cssSelector("#button#cart"));
//		actions.click(cartBtn).perform();
	}

}
