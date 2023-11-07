package com.sandeep.FirstSeleniumScript;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectBrowser {

	WebDriver driver;

	enum Browser {
		GOOGLECHROME("chrome"), MICROSOFTEDGE("edge"), MOZILLAFIREFOX("firefox"),;

		String internetBrowser;

		Browser(String internetBrowser) {
			this.internetBrowser = internetBrowser;
		}
	}

	Scanner sc = new Scanner(System.in);

	public void openBrowser() {

		System.out.println("Which browser do you want to use? ");
		for (Browser choice : Browser.values()) {
			System.out.println(choice);
		}

		String enterChoice = sc.next();
		if (enterChoice.equals(Browser.GOOGLECHROME.internetBrowser)) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (enterChoice.equals(Browser.MICROSOFTEDGE.internetBrowser)) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (enterChoice.equals(Browser.MOZILLAFIREFOX.internetBrowser)) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("You did not select the valid browser");
		}
	}

	public void sleep() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public WebElement isElementClickable(By by, int timeInSec) {
		return new WebDriverWait(driver, timeInSec).until(ExpectedConditions.elementToBeClickable(by));
	}

}
