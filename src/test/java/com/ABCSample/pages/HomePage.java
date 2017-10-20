package com.ABCSample.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ABCSample.selenium.framework.BasePage;
import com.ABCSample.selenium.framework.Configuration;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}	
	
	@FindBy(id="txtUsername")
	public WebElement userNameField;

	@FindBy(css = "#txtPassword")
	public WebElement passwordField;

	@FindBy(id = "btnLoginSubmit")
	private WebElement signInButton;
	
	@FindBy (id = "lblAccess")
	private WebElement requestAccessButton;
	
	@FindBy (id = "lblForgot")
	private WebElement resetpasswordButton;
	
	public HomePage login(String username, String password)
	{
	   setWaitTimeToZero(getDriver());
	   inputText(userNameField,username);
	   inputText(passwordField,password);
	   clickOn(signInButton);
	   return PageFactory.initElements(getDriver(),HomePage.class);
	 }
	
	
	
}
