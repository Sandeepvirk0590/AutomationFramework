package com.sandeep.FirstSeleniumScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EliteHomeStore extends SelectBrowser {

	@BeforeMethod
	private void openEliteHomeStoreLoginPage() {
		openBrowser();
		driver.manage().window().maximize();
		driver.get("https://www.elitehomestore.com/my-account/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	private void pageFindUrl() {

		String pageUrl = driver.getCurrentUrl();
		Assert.assertEquals(pageUrl, "https://munni", "Url Not Found");
	}

	@Test(priority = 3)
	private void loginToAccount() {

		WebElement usernameInput = driver.findElement(By.cssSelector("#username"));
		usernameInput.sendKeys("Sandeep");

		WebElement passwordInput = driver.findElement(By.cssSelector("password-input"));
		passwordInput.sendKeys("Sandeep123");

		System.out.println("Do you want to save login info? (Yes/No");
		String remember = sc.next();
		if (!remember.equalsIgnoreCase("No")) {
			WebElement rememberMe = driver.findElement(By.cssSelector("#rememberme"));
			rememberMe.click();
		}

		WebElement loginBtn = driver.findElement(By.cssSelector("button[name=login]"));
		loginBtn.click();
	}

	@Test(priority = 2)
	private void registerAccount() {
		WebElement emailInput = driver.findElement(By.cssSelector("#reg_email"));
		emailInput.sendKeys("sandeep_virk@gmail.com");

		WebElement clickRegisterBtn = driver.findElement(By.cssSelector("button[name='register']"));
		clickRegisterBtn.click();

	}

	@AfterMethod
	private void closeBrowser() {
		driver.close();

	}

}
