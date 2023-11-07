package com.sandeep.FirstSeleniumScript;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EliteHomeAccountPage extends SelectBrowser {

	@BeforeMethod
	private void openEliteHomeStoreLoginPage() {
		openBrowser();
		driver.manage().window().maximize();
		driver.get("https://www.elitehomestore.com/my-account/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	private void findElementsInSidebarOfEveryPage() {
		List<WebElement> listOfElements = driver
				.findElements(By.cssSelector("div>[class='woocommerce-MyAccount-navigation']"));
		for (int i = 0; i < listOfElements.size(); i++) {
			if (listOfElements.get(i).getText().equals("Account details")) {
				sleep();
				listOfElements.get(i).click();
			}
		}
	}

	@AfterMethod
	private void closeBrowser() {
		driver.close();

	}

}
