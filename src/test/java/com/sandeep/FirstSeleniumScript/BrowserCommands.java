package com.sandeep.FirstSeleniumScript;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserCommands {

	// Command to open a browser
	ChromeDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		// Open a browser
		WebDriverManager.chromedriver().setup();

		// open a new web driver instance
		// this line opens the corresponding browser
		driver = new ChromeDriver();

		// this load the URL in the page
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		driver.manage().window().maximize();
	}

	@Test
	public void pageTitleTest() {

		// Get the title of the page
		String titleOfPage = driver.getTitle();
		Assert.assertEquals(titleOfPage, "Account Login");

	}

	@Test
	public void pageUrlTest() {

		// Get the URL of the page
		String pageUrl = driver.getCurrentUrl();
		Assert.assertEquals(pageUrl, "https://munni", "Url Not Found");
//		System.out.println(pageUrl);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();

	}

}
