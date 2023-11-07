package com.sandeep.FirstSeleniumScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterOnZara {

	WebDriver driver;

	@BeforeMethod
	private void setup() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.zara.com/ca/en/logon");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	private void pageTitle() {

		String titleOfPage = driver.getTitle();
		Assert.assertEquals(titleOfPage, "LOG IN / CREATE ACCOUNT - ZARA Canada - Official Website");
		System.out.println("The title of this page is " + titleOfPage);

	}

	@Test
	private void pageUrlTest() {

		String pageUrl = driver.getCurrentUrl();
		System.out.println("The correct Url is " + pageUrl);

		Assert.assertEquals(pageUrl, "https://munni", "This is not correct Url");
	}

	@Test
	private void validateLogin() {

		WebElement emailInput = driver.findElement(By.cssSelector("input[name=logonId]"));
		emailInput.sendKeys("sandeep_virk@gmail.com");

		WebElement passwordInput = driver.findElement(By.cssSelector("input[name=password]"));
		passwordInput.sendKeys("Sandeep123");

		WebElement clickBtn = driver.findElement(By.cssSelector("div>button[role='button']"));
		clickBtn.click();

	}

	@Test
	private void tearDown() {
		driver.close();
	}

}
