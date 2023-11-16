package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class OrderHistoryPage extends TestBase {

	public OrderHistoryPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//p[text()='You have not made any previous orders!']")
	WebElement messageIfUserHasNotAnyOrderHistory;

	public String getMessageOfNoOrderHistory() {
		return messageIfUserHasNotAnyOrderHistory.getText();
	}

}
