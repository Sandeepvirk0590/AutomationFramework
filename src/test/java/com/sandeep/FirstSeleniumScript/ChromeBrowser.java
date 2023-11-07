package com.sandeep.FirstSeleniumScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeBrowser{

	public ChromeDriver driver;
	public Actions actions;

	public void launchBrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		actions = new Actions(driver);
	}

	public void selectFromDropDown(WebElement element, String visibleText) {
		Select sc = new Select(element);
		sc.selectByVisibleText(visibleText);
	}

	public WebElement isElementClickable(By by, int timeInSec) {
		return new WebDriverWait(driver, timeInSec).until(ExpectedConditions.elementToBeClickable(by));
	}

	public WebElement isElementDisplayed(By by, int timeInSec) {
		return new WebDriverWait(driver, timeInSec).until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void sleep() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}