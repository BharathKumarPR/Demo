package com.crm.Rosava.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Rosava.Generic.WebDriverUtilities;


/**
 * 
 * @author Bharath Kumar
 *
 */
public class Home {
	
@FindBy(xpath="//a[@href='index.php?module=Accounts&action=index']")
private WebElement organizationTab;

@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
private WebElement ProfileIcon;

@FindBy(xpath="//a[.='Sign Out']")
private WebElement signoutBtn;

WebDriver driver;
public Home(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public WebElement getOrganizationTab() 
{
	return organizationTab;
}

public WebElement getProfileIcon() {
	return ProfileIcon;
}

public WebElement getSignoutBtn() {
	return signoutBtn;
}

/*
 * 
 * to log out of the application 
 * 
 */
public void logout() throws Throwable
{
	WebDriverUtilities util=new WebDriverUtilities();
	//util.waitAndClick(ProfileIcon);
	util.mouseoverAction(driver, ProfileIcon);
	signoutBtn.click();
}

}
