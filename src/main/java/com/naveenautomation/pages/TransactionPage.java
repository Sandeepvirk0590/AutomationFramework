package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class TransactionPage extends TestBase {

	public TransactionPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//td[text()='You do not have any transactions!']")
	WebElement textForNoTransaction;

	public String getTextForNoTransaction() {
		return textForNoTransaction.getText();

	}

}
