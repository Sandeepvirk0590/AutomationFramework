package com.sandeep.FirstSeleniumScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NaveenAutomationLabs extends SelectBrowser {

	@BeforeMethod
	private void setup() {
		openBrowser();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=information/contact");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	private void fillTheDetailsOnContactUsPage() {
		WebElement nameInput = driver.findElement(By.cssSelector("#input-name"));
		nameInput.sendKeys("Sandeep Kaur");

		WebElement emailInput = driver.findElement(By.cssSelector("#input-email"));
		emailInput.sendKeys("sandeep_virk@outlook.com");

		WebElement textArea = driver.findElement(By.cssSelector("#input-enquiry"));
		textArea.sendKeys("Do you have Iphone 15 in stock?");

		sleep();
		WebElement clickSubmitBtn = driver.findElement(By.cssSelector("input[type='submit']"));
		clickSubmitBtn.submit();

	}

	@AfterMethod
	private void closeBrowser() {
		driver.close();
	}

}
