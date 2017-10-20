package com.ABCSample.testscript;

import java.util.ArrayList;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.ABCSample.constant.GlobalConstant.FileNames;
import com.ABCSample.dataproviders.DataProviders;
import com.ABCSample.selenium.framework.BaseTest;
import com.ABCSample.selenium.framework.Configuration;

public class OnCommerceTests extends BaseTest {

	@Factory(dataProvider = "Config", dataProviderClass = DataProviders.class)
	public OnCommerceTests(String browser) {
		super(browser);
	}

	Configuration propertyReader;
	Configuration customerReader;
	String userNameCommerce = null;
	String passwordCommerce = null;
	String merName = null;
	String region = null;
	String currency = null;
	String commision = null;

	ArrayList<String> list = new ArrayList<String>();
	ArrayList<String> listOfBankDetail = new ArrayList<String>();

	@BeforeMethod
	public void initiData() throws Exception {
		propertyReader = new Configuration(FileNames.UserProperties.toString());
		customerReader = new Configuration(FileNames.CustomerProperties.toString());

		userNameCommerce = Configuration.readApplicationFile("userNameCommerce");
		passwordCommerce = Configuration.readApplicationFile("passwordCommerce");

		merName = customerReader.readApplicationData("merchantName");
		region = customerReader.readApplicationData("region");
		currency = customerReader.readApplicationData("currency");
		commision = customerReader.readApplicationData("commision");

		list.add(customerReader.readApplicationData("type"));
		list.add(customerReader.readApplicationData("name"));
		list.add(customerReader.readApplicationData("fname"));
		list.add(customerReader.readApplicationData("lname"));
		list.add(customerReader.readApplicationData("email"));
		list.add(customerReader.readApplicationData("phone"));
		list.add(customerReader.readApplicationData("address1"));
		list.add(customerReader.readApplicationData("city"));
		list.add(customerReader.readApplicationData("country"));
		list.add("(GMT +03:30) Tehran");
		list.add("5");
		list.add("123456789");

		listOfBankDetail.add("Axis");
		listOfBankDetail.add("Patel Nagar");
		listOfBankDetail.add("Delhi");
		listOfBankDetail.add("110057");
		listOfBankDetail.add("India");
		listOfBankDetail.add("111612345678");
		listOfBankDetail.add("12345");
		listOfBankDetail.add("Lee");
		listOfBankDetail.add("Nehru Nagar");
		listOfBankDetail.add("Goa");
		listOfBankDetail.add("114578");
		listOfBankDetail.add("Finland");
		listOfBankDetail.add("2");
		listOfBankDetail.add("Daily");

	}

	@Test(description = "Jira ID: 12223, Desc: Adding Merchant on On-Commerce Client")
	public void AddingMerchantOnCommerce() throws Exception {

		String name = null;
		String[] keyData = { merName, region, currency, commision };

		reportLog("Login with user name " + userName + " and password " + password);

		reportLog("Go to OnCommerce URL");
	//	oncommercepage = homepage.goToOnCommerceURL();

		reportLog("Log in to Netscaler login page with username: " + userNameCommerce + " and Password: "
				+ passwordCommerce + "");
		oncommercepage.logInOnCommerce(userNameCommerce, passwordCommerce);

		reportLog("Click on Add Merchant Sub-menu");
		addMerchantPage = oncommercepage.clickOnAddMerchant();

		reportLog("Enter KeyData on Add Merchant Page");
		name = addMerchantPage.enterKeyData(keyData);

		// Adding Member Contact
		reportLog("Go to ContactsandVAT Tab ");
		addMerchantPage.goToContactsandVATTab();

		reportLog("Enter contact details of Member type");
		addMerchantPage.enterContactDetails(list, "member");

		// Adding Admin contact
		reportLog("Go to ContactsandVAT Tab ");
		addMerchantPage.goToContactsandVATTab();

		reportLog("Enter contact details of Admin Type");
		addMerchantPage.enterContactDetails(list, "admin");

		// Adding WareHouse contact
		reportLog("Go to ContactsandVAT Tab ");
		addMerchantPage.goToContactsandVATTab();

		reportLog("Enter contact details of Warehouse Type");
		addMerchantPage.enterContactDetails(list, "warehouse");

		reportLog("Go to SiteParticipation Tab");
		addMerchantPage.goToTabByName("siteparticipation");

		reportLog("Add Sites on Site Policy Page");
		addMerchantPage.addSites("ALES");

		reportLog("Go to Shop Policy Tab");
		addMerchantPage.goToTabByName("shoppolicies");

		reportLog("Add template on Shop Policy Tab");
		addMerchantPage.addTemplateInShopPolicyTab("Template5(Donations)");

		reportLog("Go to Bank Payment Tab");
		addMerchantPage.goToTabByName("bankpayment");

		reportLog("Enter the details on Bank Payment detail page");
		addMerchantPage.enterBankDetails(listOfBankDetail);

		reportLog("Verify the adding merchant message on UI");
		addMerchantPage.verifySuccessMsgAfterAddingMerchant(name);

	}

}
