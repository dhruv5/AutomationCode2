package com.ABCSample.pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ABCSample.selenium.framework.BasePage;
import com.ABCSample.selenium.framework.Configuration;

public class AddMerchantPage extends BasePage {

	public AddMerchantPage(WebDriver driver) {
		super(driver);
	}

	

	@FindBy(name = "merchantName")
	private WebElement merchantNameFiled;

	@FindBy(name = "paymentRegion")
	private WebElement paymentRegionFiled;

	@FindBy(name = "settlementCurrency")
	private WebElement settlementCurrencyField;

	@FindBy(name = "brokerageCommission")
	private WebElement loylogicCommisionField;

	@FindBy(xpath = "//span[text()='Contacts & VAT']")
	private WebElement contactsTab;

	@FindBy(xpath = "//span[text()='Site participation']")
	private WebElement siteTab;

	@FindBy(xpath = "//span[text()='Shipping profile']")
	private WebElement shippingprofileTab;

	@FindBy(xpath = "//span[text()='Shop policies']")
	private WebElement shopPoliciesTab;

	@FindBy(xpath = "//span[text()='Bank & payment details']")
	private WebElement bankPaymentsTab;

	@FindBy(xpath = "(//span[text()='Actions'])[1]")
	private WebElement actionsBtn;

	@FindBy(xpath = "//span[text()='Add']")
	private WebElement addBtn;

	@FindBy(name = "contactType")
	private WebElement contactTypeField;

	@FindBy(name = "contactName")
	private WebElement contactNameField;

	@FindBy(name = "title")
	private WebElement titleField;

	@FindBy(name = "firstName")
	private WebElement firstNameField;

	@FindBy(name = "lastName")
	private WebElement lastNameField;

	@FindBy(name = "emailAddress")
	private WebElement emailAddressField;

	@FindBy(name = "address1")
	private WebElement address1Field;

	@FindBy(name = "city")
	private WebElement cityField;

	@FindBy(name = "country")
	private WebElement countryField;

	@FindBy(name = "zipcode")
	private WebElement zipcodeField;

	@FindBy(name = "officePhone")
	private WebElement officePhoneField;
	
	@FindBy(name = "relatedTo")
	private WebElement relatedToDD;
	
	@FindBy(name = "vat")
	private WebElement vatField;	

	@FindBy(name = "timeZone")
	private WebElement timeZoneField;	
	
	@FindBy(name = "vatAccountNumber")
	private WebElement vatAccountNumberField;

	@FindBy(xpath = "//span[text()='Confirm']")
	private WebElement confirmBtn;

	// ===============Site Participation Tab ==========================================

	@FindBy(linkText = "Add sites")
	private WebElement addsitesBtn;

	@FindBy(name = "siteName")
	private WebElement siteNameField;

	@FindBy(xpath = "//span[text()='Go']")
	private WebElement goBtn;

	@FindBy(xpath = "//span[text()='Select']")
	private WebElement selectBtn;

	// ================Shop Policy Tab==================================================

	@FindBy(name = "returnCode")
	private WebElement returnCodeField;

	
	// ================Bank Policy Tab==================================================
	
	@FindBy(name = "bankName")
	private WebElement bankNameField;
	
	@FindBy(name = "bankAdd")
	private WebElement bankAddField;	
	
	@FindBy(name = "bankCity")
	private WebElement bankCityField;
	
	@FindBy(name = "accountNumber")
	private WebElement accountNumberField;
	
	@FindBy(name = "bankZipCode")
	private WebElement bankZipCodeField;
	
	@FindBy(name = "bankCountryCode")
	private WebElement bankCountryCodeField;
	
	@FindBy(name = "beneficiaryName")
	private WebElement beneficiaryNameField;
	
	@FindBy(name = "swiftCode")
	private WebElement swiftCodeField;
	
	@FindBy(name = "beneficiaryAddress")
	private WebElement beneficiaryAddressField;
	
	@FindBy(name = "beneficiaryCity")
	private WebElement beneficiaryCityField;
	
	@FindBy(name = "beneficiaryZipCode")
	private WebElement beneficiaryZipCodeField;
	
	@FindBy(name = "beneficiaryCountry")
	private WebElement beneficiaryCountryField;
	
	@FindBy(name = "invoiceQualifyingPeriod")
	private WebElement invoiceQualifyingPeriodFiled;	
	
	@FindBy(name = "invoiceFrequency")
	private WebElement invoiceFrequencyDD;		

	@FindBy(xpath = "//div[contains(@id,'successmessage')]")
	private WebElement msgText;
	
	@FindBy(xpath = "(//span[text()='Save'])[2]")
	private WebElement saveBtn;
	
	
	// Search item on dashboard search menu
	public AddMerchantPage addContactType(String data)  {
		_waitForJStoLoad();
		clickOn(contactTypeField);		
		sleepExecution(3);
		WebElement element = driver.findElement(By.xpath("//li[text()='" + data + "']"));		
		clickOn(element);
		return PageFactory.initElements(getDriver(), AddMerchantPage.class);
	}

	// Go to Any Tab
	public AddMerchantPage goToTabByName(String choice) {
		//switch (choice.toLowerCase()) {
		if(choice.toLowerCase().equals("contacts"))		
			clickOn(contactsTab);
		else if(choice.toLowerCase().equals("siteparticipation"))	
			clickOn(siteTab);
		else if (choice.toLowerCase().equals("shippingprofile"))	
			clickOn(shippingprofileTab);
		
		else if (choice.toLowerCase().equals("shoppolicies"))
			clickOn(shopPoliciesTab);
		else if (choice.toLowerCase().equals("bankpayment"))
			clickOn(bankPaymentsTab);
		return PageFactory.initElements(getDriver(), AddMerchantPage.class);
	}

	// Click Contacts&VAT Tab
	public AddMerchantPage goToContactsandVATTab() {

		clickOn(contactsTab);
		_waitForJStoLoad();
		javascriptButtonClick(actionsBtn);		
		javascriptButtonClick(addBtn);
		_waitForJStoLoad();
		return PageFactory.initElements(getDriver(), AddMerchantPage.class);
	}

	public  String enterKeyData(String[] data) {

		data[0] = data[0] + "_" + generateRandomNumber(10000, 99999);
		
		//data[0] = data[0] + "_" + generateRandomString(6);
		inputText(merchantNameFiled, data[0]);
		sleepExecution(1);
		inputText(paymentRegionFiled, data[1]);
		sleepExecution(1);
		inputText(settlementCurrencyField, data[2]);
		sleepExecution(1);
		inputText(loylogicCommisionField, data[3]);
		sleepExecution(3);
		return data[0];
	}

	// Enter the details on Add & contacts Tab
	public AddMerchantPage enterContactDetails(List<String> list, String type) {

		String[] tmp = list.toArray(new String[list.size()]);

		String name = "Polard_" +generateRandomNumber(10000, 99999) ;
		
		if(type.equalsIgnoreCase("admin"))
		{
			tmp[0] = "Administrative contact";
		}
		
		if(type.equalsIgnoreCase("member"))
		{
			tmp[0] = "Member contact";
		}
		
		if(type.equalsIgnoreCase("warehouse"))
		{
			tmp[0] = "Warehouse contact";
		}
		addContactType(tmp[0]);

		if(type.equalsIgnoreCase("warehouse"))
		{			
			clickOn(relatedToDD);
			sleepExecution(2);
			WebElement element = driver.findElement(By.xpath("//li[contains(text(),'Polard_')]"));
			clickOn(element);			
			inputText(timeZoneField, tmp[9]);
			inputText(vatField, tmp[10]);
			inputText(vatAccountNumberField, tmp[11]);
		}
		
		inputText(contactNameField, name);
		// inputText(titleField, tmp[2]);
		inputText(firstNameField, tmp[2]);
		inputText(lastNameField, tmp[3]);
		inputText(emailAddressField, tmp[4]);
		inputText(officePhoneField, tmp[5]);

		inputText(address1Field, tmp[6]);
		inputText(cityField, tmp[7]);
		inputText(countryField, tmp[8]);		
		clickOn(zipcodeField);

		
		javascriptButtonClick(confirmBtn);
		_waitForJStoLoad();
		return PageFactory.initElements(getDriver(), AddMerchantPage.class);
	}

	// Add site 
	public AddMerchantPage addSites(String siteCode) {
		_waitForJStoLoad();

		clickOn(addsitesBtn);
		sleepExecution(2);
		inputText(siteNameField, siteCode);
		javascriptButtonClick(goBtn);

		WebElement element = driver.findElement(By.xpath("//tr[@data-recordid='" + siteCode + "']/td[1]/div/div"));

		waitForElementPresent(element, DEFAULT_WAIT_4_ELEMENT);
		clickOn(element);
		javascriptButtonClick(selectBtn);
		return PageFactory.initElements(getDriver(), AddMerchantPage.class);
	}

	public AddMerchantPage addTemplateInShopPolicyTab(String data) {
		_waitForJStoLoad();
		clickOn(returnCodeField);
		_waitForJStoLoad();
		sleepExecution(2);
		WebElement element = driver.findElement(By.xpath("//li[text()='" + data + "']"));
		clickOn(element);
		return PageFactory.initElements(getDriver(), AddMerchantPage.class);
	}
	
	// Enter the details on Add & contacts Tab
		public AddMerchantPage enterBankDetails(List<String> list) {

			String[] tmp = list.toArray(new String[list.size()]);			

			inputText(bankNameField, tmp[0]);
			// inputText(titleField, tmp[2]);
			inputText(bankAddField, tmp[1]);
			inputText(bankCityField, tmp[2]);
			inputText(bankZipCodeField, tmp[3]);
			inputText(bankCountryCodeField, tmp[4]);
			inputText(accountNumberField, tmp[5]);
			inputText(swiftCodeField, tmp[6]);			
			
			inputText(beneficiaryNameField, tmp[7]);
			inputText(beneficiaryAddressField, tmp[8]);
			inputText(beneficiaryCityField, tmp[9]);
			
			inputText(beneficiaryZipCodeField, tmp[10]);
			inputText(beneficiaryCountryField, tmp[11]);
			inputText(invoiceQualifyingPeriodFiled, tmp[12]);
			
			clickOn(invoiceFrequencyDD);
			sleepExecution(2);
			WebElement element = driver.findElement(By.xpath("//li[text()='" + tmp[13] + "']"));
			clickOn(element);
			
			javascriptButtonClick(saveBtn);
			sleepExecution(4);			
			return PageFactory.initElements(getDriver(), AddMerchantPage.class);
		}

		//Verify adding merchant successfully message
		public void verifySuccessMsgAfterAddingMerchant(String name)
		{						
			String text ="Merchant "+name+" added successfully."; 
			boolean status = isTextPresentOnPage(text);
			assertEquals(status, true);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
