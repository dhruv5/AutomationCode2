package com.ABCSample.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ABCSample.selenium.framework.BasePage;

public class MaintenancePage extends BasePage {

	public MaintenancePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

@FindBy(id = "section_b36b1db8-e1a2-48d0-911e-b867d9fcc3fd")
 private WebElement maintenanceButton;	

public void selectmaintenance()
{
  waitForElement(maintenanceButton);
  clickOn(maintenanceButton);
}


}
