package com.sandeep.FirstSeleniumScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWait extends SelectBrowser {

	@BeforeMethod
	public void setup() {
		
		openBrowser();
		driver.manage().window().maximize();
		driver.get("https://www.lambtoncollege.ca/");
	}
	
	@Test
	public void explicitWaitDemo() {
		WebElement cookieAcceptBtn = isElementClickable(By.xpath("//span[.='Accept']"), 5);
		cookieAcceptBtn.click();
	}
	
 
}
