package com.naveenautomation.pages;

import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class ShoppingCartPage extends TestBase{
	
	public ShoppingCartPage() {
		PageFactory.initElements(wd, this);
	}


}
