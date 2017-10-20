package com.ABCSample.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ABCSample.selenium.framework.BasePage;

public class SubmitPage extends BasePage {

	public SubmitPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "companyName")
	private WebElement companyField;

	@FindBy(id = "addressLine2")
	private WebElement addressField;

	@FindBy(id = "cardNumber")
	private WebElement cardNumberField;

	@FindBy(id = "cardHolderName")
	private WebElement cardHolderNameField;

	@FindBy(xpath = "//select[@id='cardExpiryMonth']/following-sibling::input")			//cardExpiryMonth
	private WebElement cardExpiryMonthField;
	
	@FindBy(xpath = "//select[@id='cardExpiryYear']/following-sibling::input")//cardExpiryYear
	private WebElement cardExpiryYearField;

	@FindBy(id = "cardSecurityCode")
	private WebElement cardSecurityCodeField;

	@FindBy(name = "isTermsAndConditionsAccepted")
	private WebElement checkBoxRadioBtn;

	@FindBy(id = "validateCheckout")
	private WebElement payAmountBtn;

	//Entering the details of customer on check out page 
	public SubmitPage completeCheckOutDetailsOfItem(String companyName,String address,
			String cardHolderName, String cardNumber, String cvv,
			String month, String year) {

		cardHolderName = cardHolderName +"_"+generateRandomNumber(10000, 99999);
		inputText(addressField, address);
		inputText(cardNumberField, cardNumber);
		inputText(cardHolderNameField, cardHolderName);		
		
		waitForAjaxRequestsToComplete();
		selectRadioBtn(checkBoxRadioBtn);		
		
		clickOn(cardExpiryMonthField);	
		
		inputText(cardExpiryMonthField, month);		
		
		//selectDropDownByValue(cardExpiryYearField, year);		
		inputText(cardSecurityCodeField, cvv);
		
		inputText(cardExpiryYearField, year);		
		
		javascriptButtonClick(checkBoxRadioBtn);		
		
		javascriptButtonClick(payAmountBtn);	
		
		_waitForJStoLoad();		

		return PageFactory.initElements(getDriver(), SubmitPage.class);
	}
}
