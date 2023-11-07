package com.sandeep.FirstSeleniumScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CarboniteTrialAccount extends ChromeBrowser {

	@BeforeMethod
	private void setup() {
		launchBrowser();
		driver.get("https://www.carbonite.com/personal/trial/");
	}

	@Test
	private void validateToSetUpAnAccount() {

		isElementDisplayed(By.cssSelector("input[placeholder='Provide your email address']"), 10)
				.sendKeys("sandeep_virk@gmail.com");

		driver.findElement(By.cssSelector("input[placeholder='Confirm your email']"))
				.sendKeys("Sandeep_virk@gmail.com");

		driver.findElement(By.cssSelector("input[placeholder='Create a password']")).sendKeys("Sandeep#123");

		driver.findElement(By.cssSelector("input[placeholder='Confirm your password']")).sendKeys("Sandeep#123");

		WebElement countryOptionsInDD = driver.findElement(By.cssSelector("div[class='css-iulkn0']>button>svg"));
		countryOptionsInDD.click();
		
		WebElement selectCountry = isElementDisplayed(By.cssSelector("#personal-trial-country-selection"), 5);
		selectCountry.sendKeys("Canada");
		
		isElementClickable(By.xpath("//button[text()='Canada']"), 5).click();

		WebElement reCaptchaSelect = driver.findElement(By.cssSelector("#recaptcha-anchor"));
		actions.click(reCaptchaSelect).perform();

		WebElement claimTrialBtn = driver.findElement(By.cssSelector("form>button>p"));
		actions.click(claimTrialBtn).perform();
	}

	@AfterMethod
	private void tearDown() {
		driver.close();
	}

}
