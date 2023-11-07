package com.naveenautomation.base;

public enum NavigationBarOnEveryPage {
	
	MY_ACCOUNT("My Account"), 
	EDIT_ACCOUNT("Edit Account"), 
	PASSWORD("Password"), 
	ADDRESS_BOOK("Address Book"),
	WISH_LIST("Wish List"), 
	ORDER_HISTORY("Order History"), 
	DOWNLOADS("Downloads"),
	RECURRING_PAYMENTS("Recurring Payments"), 
	REWARD_POINTS("Reward Points"), 
	RETURNS("Returns"),
	TRANSACTIONS("Transactions"), 
	NEWSLETTER("Newsletter"), 
	LOGOUT("Logout");

	String sideNavBar;

	NavigationBarOnEveryPage(String sideNavBar) {
		this.sideNavBar = sideNavBar;
	}
	
	public String getSideBar() {
		return sideNavBar;
	}

}
