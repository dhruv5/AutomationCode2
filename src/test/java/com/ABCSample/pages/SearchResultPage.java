package com.ABCSample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ABCSample.selenium.framework.BasePage;

public class SearchResultPage extends BasePage {

	public SearchResultPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "loginFormRexModalButton")
	private WebElement logInBtn;

	@FindBy(id = "button-reward-details-evnt")
	private WebElement addCartBtn;

	@FindBy(id = "proceed_to_checkout")
	private WebElement proceedToCheckOutBtn;

	@FindBy(id = "checkout-basket-review")
	private WebElement checkOutBtn;

	@FindBy(id = "myMiles")
	private WebElement milesInputBox;

	@FindBy(id = "myCash")
	private WebElement aedInputBox;

	//Click on item on search result page
	public SearchResultPage clickOnParticularItem(String itemName) {

		getDriver().findElement(By.xpath("//a[contains(text(),'" + itemName + "')]")).click();
		return PageFactory.initElements(getDriver(), SearchResultPage.class);
	}

	//Go to detail of search item
	public NetScalarLoginPage goToDetailPageOfItem() {
		_waitForJStoLoad();
		clickOn(addCartBtn);
		waitForAjaxRequestsToComplete();
		waitAndClick(logInBtn);
		_waitForJStoLoad();
		// clickOn(logInBtn);
		return PageFactory.initElements(getDriver(), NetScalarLoginPage.class);
	}

	//Enter the Miles and AED details of selected item
	public SubmitPage fillMilesAndAEDOfItem(String miles, String aed) {

		inputText(milesInputBox, miles);
		inputText(aedInputBox, aed);
		clickOn(aedInputBox);
		//inputText(aedInputBox, aed);
		_waitForJStoLoad();
		return PageFactory.initElements(getDriver(), SubmitPage.class);
	}

	//Go to checkout page of selected item
	public SubmitPage goToCheckOutPageOfItem() {

		clickOn(addCartBtn);
		waitForAjaxRequestsToComplete();
		waitAndClick(proceedToCheckOutBtn);
		_waitForJStoLoad();
		clickOn(checkOutBtn);
		_waitForJStoLoad();
		return PageFactory.initElements(getDriver(), SubmitPage.class);
	}

}
