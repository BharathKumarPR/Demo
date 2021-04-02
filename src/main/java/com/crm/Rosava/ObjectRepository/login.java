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
public class login {
	
@FindBy(name="user_name")
private WebElement UserNameEdt; 

@FindBy(name="user_password")
private WebElement PasswordEdt; 

@FindBy(id="submitButton")
private WebElement LoginBtn; 

public login(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getUserNameTxtField() {
	return UserNameEdt;
}

public WebElement getPasswordTxtField() {
	return PasswordEdt;
}

public WebElement getLoginBtn() {
	return LoginBtn;
}

/**
 * to login to application
 */
 
public void loginToAPP(String username , String password) {
	UserNameEdt.sendKeys(username);
	PasswordEdt.sendKeys(password);
	LoginBtn.click();
}

}
