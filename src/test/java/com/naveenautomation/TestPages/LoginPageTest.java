package com.naveenautomation.TestPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naveenautomation.Utils.ExcelUtils;
import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.ForgottenPasswordPage;
import com.naveenautomation.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	AccountPage accountPage;
	ForgottenPasswordPage forgottenPasswordPage;

	@BeforeMethod
	public void launch() {
		intialisation();
		loginPage = new LoginPage();

	}

	@Test
	public void validateUserCanLoginWithValidCredentials() {
		accountPage = loginPage.SubmitLogin("sandeepkaur1@gmail.com", "sandy");
		Assert.assertEquals(accountPage.getMyAccountText(), "My Account", "User not logged in");
	}

	@Test
	public void validateUserCanNotLoginWithInValidCredentials() {
		loginPage.SubmitLogin("sandy@gmail.com", "sandeep");
		Assert.assertEquals(loginPage.getAlertText(), "Warning: No match for E-Mail Address and/or Password.",
				"User logged in");
	}

	@Test
	public void validateEmailForForgottenPassword() {
		forgottenPasswordPage = loginPage.resetPasswordIfForgot();
		forgottenPasswordPage.resetPasswordIfForgotten("sandeepkaur@gmail.com");
		Assert.assertEquals(forgottenPasswordPage.getFailedMessage(),
				"Warning: The E-Mail Address was not found in our records, please try again!",
				"Email sent to reset Password!");
	}

	@Test(dataProvider = "UserCredentials")
	public void validateLoginWithMultipleCredentials(String userName, String password) {
		accountPage = loginPage.SubmitLogin(userName, password);
		Assert.assertEquals(accountPage.getMyAccountText(), "My Account", "User Failed to Login");

	}

	@DataProvider(name = "UserCredentials")
	public String[][] getDataFromExcel() throws Exception {
		String filename = "C:\\Users\\gurja\\OneDrive\\Desktop\\UsernameAndPassword.xlsx";
		String sheetName = "Sheet1";
		int rowCount = ExcelUtils.getRowCount(filename, sheetName);
		int cellCount = ExcelUtils.getCellCount(filename, sheetName, rowCount);
	
		// Ceating two dimentional array in order to fetch data from rows and columns//
		String[][] virtualSheet = new String[rowCount][cellCount];
		
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				virtualSheet[i - 1][j] = ExcelUtils.getCellData(filename, sheetName, i, j+1);
			}

		}
		return virtualSheet;
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
