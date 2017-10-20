package com.ABCSample.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ABCSample.selenium.framework.BasePage;

public class NetScalarLoginPage extends BasePage {

	public NetScalarLoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "login")
	private WebElement userNameTextBox;

	@FindBy(name = "passwd")
	private WebElement passwordTextBox;

	@FindBy(id = "Log_On")
	private WebElement logInBtn;
	
	@FindBy(name = "GuestLoginForm_Username")
	private WebElement userNameEtihadTextBox;
	
	@FindBy(name = "GuestLoginForm_Password")
	private WebElement passwordEtihadTextBox;
	
	@FindBy(id = "guestLoginSubmitButton")
	private WebElement logInBtnEtihad;

	public NetScalarLoginPage logInNetscalar(String userName, String password) {

		inputText(userNameTextBox, userName);
		inputText(passwordTextBox, password);
		clickOn(logInBtn);
		return PageFactory.initElements(getDriver(), NetScalarLoginPage.class);
	}

	
	
	public NetScalarLoginPage logInEtihad(String userName, String password) {

		inputText(userNameEtihadTextBox, userName);
		inputText(passwordEtihadTextBox, password);
		clickOn(logInBtnEtihad);
		_waitForJStoLoad();
		return PageFactory.initElements(getDriver(), NetScalarLoginPage.class);
	}
	
	
}
