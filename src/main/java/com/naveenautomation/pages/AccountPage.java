package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.NavigationBarOnEveryPage;
import com.naveenautomation.base.TestBase;

public class AccountPage extends TestBase{

	public AccountPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "#content>h2:first-of-type")
	WebElement myAccountText;

	@FindBy(css = "div.alert-success")
	WebElement acccountInfoUpdateSuccessMessage;
	

	@FindBy(xpath = "//a[text()='Newsletter']")
	WebElement newspaperSubsciptionLink;

	@FindBy(css = "div.alert")
	WebElement newsletterSubsciptionSuccessMessage;

	@FindBy(xpath = "//a[text()='Edit your account information']")
	WebElement editYourInfoLink;

	@FindBy(css = "#column-right>div>a:nth-of-type(3)")
	WebElement changePasswordLink;

	@FindBy(css = "div.alert-success")
	WebElement changePasswordSuccessMessage;

	@FindBy(xpath="//a[text()='Desktops']")
	WebElement desktopLink;
	
	@FindBy(xpath="//a[text()='Mac (1)']")
	WebElement macLink;
	
	@FindBy(xpath="//a[text()='Gift Certificates']")
	WebElement giftCertificateLink;
	
	@FindBy(xpath="//a[text()='Specials']")
	WebElement specialOffersLink;

	public String getMyAccountText() {
		return myAccountText.getText();
	}

	public EditAccountInfoPage clickEditInfoLink(NavigationBarOnEveryPage sideMenuSelected) {
		sideNavBarMenu(sideMenuSelected);
		return new EditAccountInfoPage();
	}

	public String getInfoUpdateSuccessMessage() {
		return acccountInfoUpdateSuccessMessage.getText();
	}

	public NewsletterSubscriptionPage clickNewsletterSubscriptionLink(NavigationBarOnEveryPage sideMenuSelected) {
		sideNavBarMenu(sideMenuSelected);
		return new NewsletterSubscriptionPage();
	}

	public String getNewspaperSubsciptionSuccessMessage() {
		return newsletterSubsciptionSuccessMessage.getText();
	}

	public UpdatePasswordPage clickPasswordLink(NavigationBarOnEveryPage sideMenuSelected) {
		sideNavBarMenu(sideMenuSelected);
		return new UpdatePasswordPage();
	}

	public String getUpdatePasswordSuccessMessage() {
		return changePasswordSuccessMessage.getText();
	}

	public ProductReturnPage productReturnLink(NavigationBarOnEveryPage sideMenuSelected) {
		sideNavBarMenu(sideMenuSelected);
		return new ProductReturnPage();
	}
	
	public VoucherPage GiftCertificateFormPage() {
		giftCertificateLink.click();
        return new VoucherPage();
	}
	
	public MacPage_20_27 pageLinkToGoOnMac() {
		desktopLink.click();
		macLink.click();
		return new MacPage_20_27();
	}
	
	public DownloadsPage checkDownloads(NavigationBarOnEveryPage sideMenuSelected) {
		sideNavBarMenu(sideMenuSelected);
		return new DownloadsPage();		
	}
	
	public AddressPage addNewAddress(NavigationBarOnEveryPage sideMenuSelected) {
		sideNavBarMenu(sideMenuSelected);
		return new AddressPage();
	}
	
	public SpecialsPage checkTheSpecialOffers() {
		specialOffersLink.click();
		return new SpecialsPage();
	}
	
	public LogoutPage logoutYourAccount(NavigationBarOnEveryPage sideMenuSelected) {
		sideNavBarMenu(sideMenuSelected);
		return new LogoutPage();
	}
}
