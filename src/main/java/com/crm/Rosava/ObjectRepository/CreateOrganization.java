package com.crm.Rosava.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 *@author Bharath Kumar 
 *
 */
public class CreateOrganization {

	@FindBy(name="accountname")
	private WebElement organizationNameEdt;
	
	@FindBy(name="rating")
	private WebElement ratingBropdown;
	
	@FindBy(name="notify_owner")
	private WebElement notifyOwnerCkeckBox;

	@FindBy(xpath="(//input[@value='  Save  '])[1]")
	private WebElement saveBtn;
	
	@FindBy(xpath="//input[@onclick='return copyAddressLeft(EditView)']")
	private WebElement CopyShippingAddressRadiobutton;
	
	@FindBy(xpath="//input[@onclick='return copyAddressRight(EditView)']")
	private WebElement CopyBillingAddressRadiobutton;
	
	public CreateOrganization(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganizationNameEdt() {
		return organizationNameEdt;
	}
	
	public WebElement getRatingBropdown() {
		return ratingBropdown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getNotifyOwnerCkeckBox() {
		return notifyOwnerCkeckBox;
	}

	public WebElement getCopyShippingAddressRadiobutton() {
		return CopyShippingAddressRadiobutton;
	}

	public WebElement getCopyBillingAddressRadiobutton() {
		return CopyBillingAddressRadiobutton;
	}
	
}
