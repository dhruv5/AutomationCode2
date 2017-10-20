package com.ABCSample.testscript;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.ABCSample.constant.GlobalConstant.FileNames;
import com.ABCSample.dataproviders.DataProviders;
import com.ABCSample.selenium.framework.BaseTest;
import com.ABCSample.selenium.framework.Configuration;;

public class HomePageTests extends BaseTest {

	@Factory(dataProvider = "Config", dataProviderClass = DataProviders.class)
	public HomePageTests(String browser) {
		super(browser);
	}
	
	Configuration propertyReader;
	String itemDetails = null;
	String userNameNetScaler =null; 
	String passwordNetScaler = null;
	String userNameEtihad = null;
	String passwordEtihad = null;
	String companyName = null;
	String cardHolderName = null;
	String address = null;
	String cardNumber = null;
	String cvvCode = null;
	String month = null;
	String year = null;
	String miles = null;
	String aed = null;

	@BeforeMethod
	public void initiData() throws Exception {
		propertyReader = new Configuration(FileNames.UserProperties.toString());
		itemDetails = propertyReader.readApplicationData("itemName");
		userNameNetScaler = Configuration.readApplicationFile("usernameNetScaler");
		passwordNetScaler = Configuration.readApplicationFile("passwordNetScaler");
		userNameEtihad = Configuration.readApplicationFile("userNameEtihad");
		passwordEtihad = Configuration.readApplicationFile("passwordEtihad");
		companyName = propertyReader.readApplicationData("companyName");
		address = propertyReader.readApplicationData("address");
		cardNumber = propertyReader.readApplicationData("cardNumber");
		cardHolderName = propertyReader.readApplicationData("cardHolderName");
		month = propertyReader.readApplicationData("month");
		year = propertyReader.readApplicationData("year");
		cvvCode = propertyReader.readApplicationData("cvv");
		miles = propertyReader.readApplicationData("miles");
		aed = propertyReader.readApplicationData("aed");

	}

	
	@Test(description = "Jira ID: 1234, Desc: Add item in cart")
	public void AddingItemInCart() throws Exception {
		
		reportLog("Login with user name " + userName + " and password " + password);
		String data = "Watches";

		reportLog("Search " + data + " on search header");
       // searchresultpage = homepage.searchOnHomePage(data);
		

		searchresultpage.clickOnParticularItem(itemDetails);

		reportLog("Search " + data + " on search header");
		netscalarloginpage = searchresultpage.goToDetailPageOfItem();

		reportLog("Login in to Etihad with username " + userNameNetScaler + " and password " + passwordNetScaler + "");
		netscalarloginpage.logInNetscalar(userNameNetScaler, passwordNetScaler);

		reportLog("Login in to Etihad with username " + userNameEtihad + " and password " + passwordEtihad + "");
		netscalarloginpage.logInEtihad(userNameEtihad, passwordEtihad);

		reportLog("Fill miles and AED amount");
		//searchresultpage.fillMilesAndAEDOfItem(miles, aed);
		
		reportLog("Go to checkout page");
		submitpage = searchresultpage.goToCheckOutPageOfItem();
		submitpage.completeCheckOutDetailsOfItem(companyName, address, cardHolderName, cardNumber, cvvCode, month, year);
				
		
	}
}
