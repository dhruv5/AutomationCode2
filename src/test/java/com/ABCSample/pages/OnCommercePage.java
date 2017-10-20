package com.ABCSample.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ABCSample.selenium.framework.BasePage;


public class OnCommercePage extends BasePage {

	public OnCommercePage(WebDriver driver) {
		super(driver);
	}	

	@FindBy(name = "username")
	private WebElement userNameFiled;

	@FindBy(name = "password")
	private WebElement passwordField;

	@FindBy(id = "ext-gen1064")
	private WebElement loginButton;

	@FindBy(id = "menuMerchantsProducts_button-btnIconEl")
	private WebElement merchantMenu;

	@FindBy(xpath = "//a[text()='Add Product']")
	private WebElement addProductLink;
	
	@FindBy(id = "menuAddMerchant")
	private WebElement addMerchantLink;

	
	//Log-In to OnCommerce login page
	public OnCommercePage logInOnCommerce(String userName, String password) {

		inputText(userNameFiled, userName);
		inputText(passwordField, password);
		clickOn(loginButton);
		_waitForJStoLoad();
		return PageFactory.initElements(getDriver(), OnCommercePage.class);
	}

	//Click on add product sub-menu
	public OnCommercePage clickOnaddProduct() {

		clickOn(merchantMenu);
		clickOn(addProductLink);
		_waitForJStoLoad();
		return PageFactory.initElements(getDriver(), OnCommercePage.class);
	}
	
	//Click onSubMenu
	public AddMerchantPage clickOnAddMerchant() {
		
		clickOn(merchantMenu);
		clickOn(addMerchantLink);
		_waitForJStoLoad();		
		sleepExecution(5);
		return PageFactory.initElements(getDriver(), AddMerchantPage.class);
	}
}
