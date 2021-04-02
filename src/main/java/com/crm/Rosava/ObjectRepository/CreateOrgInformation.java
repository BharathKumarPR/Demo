package com.crm.Rosava.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Bharath Kumar
 *
 */
public class CreateOrgInformation {

	@FindBy(className="dvHeaderText")
	private WebElement successfulMsg;
	
	WebDriver driver;
	public CreateOrgInformation(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getsuccessfulMsg() {
		return successfulMsg;
	}
	
}
