package com.sandeep.FirstSeleniumScript;

import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowSwitch extends ChromeBrowser {

	@BeforeMethod
	private void setup() {
		launchBrowser();
		driver.get("https://demoqa.com/browser-windows");
	}

	@Test
	public void switchfromOneWindowToAnother() {

		String parent = driver.getWindowHandle();

		Set<String> s = driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();

			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

				System.out.println(driver.switchTo().window(child_window).getTitle());

				driver.close();
			}

		}
		// switch to the parent window
		driver.switchTo().window(parent);

	}

	@AfterMethod
	private void tearDown() {
		driver.close();
	}
}
