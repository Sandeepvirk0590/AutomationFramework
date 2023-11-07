package com.sandeep.FirstSeleniumScript;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class webrootAssignment extends SelectBrowser {

	@BeforeMethod
	private void openTheWebsite() {
		openBrowser();
		driver.manage().window().maximize();
		driver.get("https://www.webroot.com/us/en/cart?key=9C8868A3-2846-4BC4-AAFC-C7B9B69AF60C");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	private void fillFormOnWebroot() {

		Select sc;

		WebElement acceptCookie = driver.findElement(By.xpath("//button[text () = 'Accept All']"));
		acceptCookie.click();

		WebElement emailAddressInput = driver.findElement(By.cssSelector("input[name='billing.customer_email']"));
		emailAddressInput.sendKeys("sandeep_virk@gmail.com");

		Assert.assertEquals(emailAddressInput, "sandeep_virk@gmail.com", "This email is already registered!");

		WebElement firstNameInput = driver.findElement(By.cssSelector("input[name='billing.first_name']"));
		firstNameInput.sendKeys("Sandeep");

		WebElement lastNameInput = driver.findElement(By.cssSelector("input[name='billing.last_name']"));
		lastNameInput.sendKeys("Kaur");

		WebElement addressInput = driver.findElement(By.cssSelector("input[name='billing.address_1']"));
		addressInput.sendKeys("66 Drake Blvd");

		WebElement selectCountry = driver.findElement(By.cssSelector("select[name='billing.country']"));
		sc = new Select(selectCountry);
		sc.selectByVisibleText("Canada");

		WebElement selectProvince = driver.findElement(By.cssSelector("select[name='billing.state']"));
		sc = new Select(selectProvince);
		sc.selectByValue("ON");

		WebElement cityInput = driver.findElement(By.cssSelector("input[name='billing.city']"));
		cityInput.sendKeys("Brampton");
		WebElement postalCodeInput = driver.findElement(By.cssSelector("input[name='billing.postal_code']"));
		postalCodeInput.sendKeys("L6T3K9");

	}

//	public void validateIfRadioButtonOnPaymentIsSelected() {
//		Scanner scan = new Scanner(System.in);
//		System.out.println("What Payment option you want to select? (Visa/PayPal)");
//		String selectButton = scan.nextLine();
//
//		switch (selectButton.toLowerCase()) {
//		case "visa":
//			WebElement visaRadioButton = driver.findElement(By.cssSelector("input[value='CreditCard']"));
//			visaRadioButton.click();
//			System.out.println("Payment option you selected is Visa");
//			break;
//
//		case "paypal":
//			WebElement paypalRadioButton = driver.findElement(By.cssSelector("input[value='PayPalSetup']"));
//			paypalRadioButton.click();
//			System.out.println("Payment option you selected is PayPal");
//
//			break;
//		default:
//			System.out.println("You need to select a mode of payment");
//		}
//	}

	@Test
	private void validateIfCheckBoxForAgreementIsSelected() {
		try {
			WebElement checkBox = driver.findElement(By.cssSelector("#opt-in"));
			checkBox.click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	private void closeBrowser() {
		driver.close();

	}

}
