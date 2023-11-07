package com.sandeep.FirstSeleniumScript;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowExample extends ChromeBrowser {

	@BeforeMethod
	private void setup() {
		launchBrowser();
		driver.get("https://demoqa.com/browser-windows");
	}

	@Test
	public void validateTextFromTabs() {
		WebElement newTabBtn = isElementDisplayed(By.cssSelector("#tabButton"), 5);
		String parentWindowHandle = driver.getWindowHandle();
		newTabBtn.click();
		System.out.println(parentWindowHandle);
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles.toString());

		String childHandle = "";
		for (String handle : windowHandles) {
			if (!handle.equals(parentWindowHandle)) {
				childHandle = handle;
			}
		}
		driver.switchTo().window(childHandle);
		System.out.println(isElementDisplayed(By.cssSelector("#sampleHeading"), 10));
		driver.switchTo().window(parentWindowHandle);
		isElementClickable(By.id("windowButton"), 5).click();
		driver.switchTo().window(childHandle);
	}

	@AfterMethod
	private void tearDown() {
//		driver.close();
		driver.quit();
	}

}
