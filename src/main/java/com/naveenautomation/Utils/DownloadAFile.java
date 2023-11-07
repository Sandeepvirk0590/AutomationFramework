package com.naveenautomation.Utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadAFile {
	WebDriver driver;

	@BeforeMethod
	public void setup() {

		WebDriverManager.chromedriver().setup();

		ChromeOptions option = new ChromeOptions();

		Map<String, Object> pref = new HashMap<>();
		String value = System.getProperty("java.io.tmpdir");
		String downloadPath = System.getProperty("java.io.tmpdir");
		String val=System.getProperty("user.dir")+ File.separator + "externalFiles" + File.separator + "downloadFiles";
		pref.put("download.default.directory", "C:\\Users\\gurja\\Downloads\\sampleFile.jpeg");

		option.setExperimentalOption("prefs", pref);

		driver = new ChromeDriver(option);

		driver.get("https://demoqa.com/upload-download");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void validateIfUserCanVerifyADownloadedFile() {
		driver.findElement(By.id("downloadButton")).click();

		Assert.assertTrue(isFileAvailable("sampleFile.jpeg", 60), "Downloaded document is not found");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	public boolean isFileAvailable(String fileName, int secondsToDownload) {
		try {
			Thread.sleep(secondsToDownload);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		File folder = new File("C:\\Users\\gurja\\Downloads\\sampleFile.jpeg");
		// List the files on that folder
		File[] listOfFiles = folder.listFiles();
		for (File listOfFile : listOfFiles) {
			if (listOfFile.isFile()) {
				if (listOfFile.getName().contains(fileName)) {
					System.out.println(listOfFile.getName());
					listOfFile.delete();
					return true;
				}
			}
		}
		return false;
	}

}
