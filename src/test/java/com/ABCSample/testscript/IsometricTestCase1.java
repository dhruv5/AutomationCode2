package com.ABCSample.testscript;

import java.text.ParseException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.ABCSample.constant.GlobalConstant.FileNames;
import com.ABCSample.dataproviders.DataProviders;
import com.ABCSample.pages.AllControlPage;
import com.ABCSample.pages.HomePage;
import com.ABCSample.selenium.framework.BaseTest;
import com.ABCSample.selenium.framework.Configuration;

public class IsometricTestCase1 extends BaseTest {

	@Factory(dataProvider = "Config", dataProviderClass = DataProviders.class)
	public IsometricTestCase1(String browser) {
		super(browser);
	}

	Configuration propertyReader;
	String username = null;
	String password = null;
	String controlLevel= null;
	String controlView = null;
	String controlTextbox = null;
	String controlDefatultTextbox = null;
	String controlTextArea = null;
    String controlNumeric1 = null;
    String controlNumeric2 = null;
    String controlDate1 = null;
    String controlDate2 = null;
    String controlTime1 = null;
    String controlTime2 = null;
    String controlChkbox =null;
    String controlFormula = null;
    String controlDatalabel = null;
    String controlLookup = null;
    String userdefinedCBL1 = null;
    String userdefinedCBL2 = null;
    String userdefinedDDL1 = null;
    String userdefinedDDL2 = null;
    String mdsDDL1 =null;
    String mdsDDL2 =null;
    String mdsDDL3 =null;
    String mdsCBL1 = null;
    String mdsCBL2 = null;
    String mdsCBL3 = null;
    String mhdsDDL1 = null;
    String mhdsDDL2 = null;
    String mhdsDDL3 = null;
    String mhdsCBL1 = null;
    String mhdsCBL2 = null;
    String userUsers = null;
    String userList = null;
    
	@BeforeMethod
	public void initData() throws Exception{
	  	propertyReader = new Configuration(FileNames.TestdataProperties.toString());
		username = propertyReader.readApplicationData("username");
		password = propertyReader.readApplicationData("password");
	    controlLevel = propertyReader.readApplicationData("controlLevel");
	    controlView = propertyReader.readApplicationData("controlView");
	    controlTextbox= propertyReader.readApplicationData("controlTextbox");
	    controlDefatultTextbox = propertyReader.readApplicationData("controlDefaultTextbox");
	    controlTextArea = propertyReader.readApplicationData("controlTextArea");
	    controlNumeric1 = propertyReader.readApplicationData("controlNumeric1");
	    controlNumeric2 = propertyReader.readApplicationData("controlNumeric2");
	    controlDate1 = propertyReader.readApplicationData("controlDate1");
	    controlDate2 = propertyReader.readApplicationData("controlDate2");
	    controlTime1 = propertyReader.readApplicationData("controlTime1");
	    controlTime2 = propertyReader.readApplicationData("controlTime2");
	    controlChkbox = propertyReader.readApplicationData("controlChkbox");
	    controlFormula = propertyReader.readApplicationData("controlFormula");
	    controlDatalabel = propertyReader.readApplicationData("controlDatalabel");
	    controlLookup = propertyReader.readApplicationData("controlLookup");
	    userdefinedCBL1= propertyReader.readApplicationData("userdefinedCBL1"); 
	    userdefinedCBL2= propertyReader.readApplicationData("userdefinedCBL2");
	    userdefinedDDL1= propertyReader.readApplicationData("userdefinedDDL1");
	    userdefinedDDL2= propertyReader.readApplicationData("userdefinedDDL2");
	    mdsDDL1= propertyReader.readApplicationData("mdsDDL1");
	    mdsDDL2= propertyReader.readApplicationData("mdsDDL2");
	    mdsDDL3= propertyReader.readApplicationData("mdsDDL3");
	    mdsCBL1= propertyReader.readApplicationData("mdsCBL1");
	    mdsCBL2= propertyReader.readApplicationData("mdsCBL2");
	    mdsCBL3= propertyReader.readApplicationData("mdsCBL3");
	    mhdsDDL1 = propertyReader.readApplicationData("mhdsDDL1");
	    mhdsDDL2 = propertyReader.readApplicationData("mhdsDDL2");
	    mhdsDDL3 = propertyReader.readApplicationData("mhdsDDL3");
	    mhdsCBL1 = propertyReader.readApplicationData("mhdsCBL1");
	    mhdsCBL2 = propertyReader.readApplicationData("mhdsCBL2");
	    userUsers = propertyReader.readApplicationData("userUsers");
	    userList = propertyReader.readApplicationData("userList");
	}
	
	@Test
	public void Test1() throws ParseException {

		HomePage homePage = PageFactory.initElements(getWebDriver(), HomePage.class);

		// 1. User is required to login using a valid IsoMetrix username and
		// password.
		homePage.login(username,password);

		// The user will have access to the All controls interface and will have
		// access to the All Controls module as well as the Maintenance module.
		AllControlPage allControlPage = PageFactory.initElements(getWebDriver(), AllControlPage.class);
		allControlPage.selectAllControl();

		// The user will be able to select the [Add New] button on the All
		// controls module
		allControlPage.addentry();

		// The user will be required to fill in all the mandatory fields and
		// should then be able to save the record successfully.
		allControlPage.addentryControls(controlLevel,controlView,controlTextbox,controlDefatultTextbox,controlTextArea,controlNumeric1,controlNumeric2,controlDate1,controlDate2,controlTime1,controlTime2,controlChkbox,controlFormula,controlDatalabel,controlLookup);
		allControlPage.addentry_Userdefined(new String[] {userdefinedCBL1}, new String[] {userdefinedCBL2},userdefinedDDL1,userdefinedDDL2);
		allControlPage.addentryMDS(mdsDDL1,mdsDDL2, new String[] {mdsCBL1}, new String[] {mdsCBL2},mdsDDL3, new String[] {mdsCBL3});
		allControlPage.addentryMHDS(mhdsDDL1,mhdsDDL2,mhdsDDL3, new String[] {mhdsCBL1}, new String[] {mhdsCBL2});
		allControlPage.addentryUser(userUsers, new String[] {userList});
		

		// The user will need to navigate to the ‘Sub Module’ tab and select the
		// [Add New] button.

		// The user will be able to add data to the new blank sub module record
		// and [Save] without errors.

	}
}
