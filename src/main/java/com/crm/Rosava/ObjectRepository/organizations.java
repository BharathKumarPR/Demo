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
public class organizations {

	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrgBtn;
	
	public organizations(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrgBtn() {
		return createOrgBtn;
	}
	
}
