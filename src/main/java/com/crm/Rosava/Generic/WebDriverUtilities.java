package com.crm.Rosava.Generic;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * 
 * 
 * @author Bharath Kumar
 *
 */
public class WebDriverUtilities {
	
	/**
	 * 
	 * To wait until the element is visible(Explicit Wait)
	 * 
	 * @param Driver
	 * @param Element
	 * 
	 * 
	 */
public void visibilityofelement(WebDriver driver,WebElement element)
{
	WebDriverWait wait =new WebDriverWait(driver, PathConstants.explicitelywait);
	wait.until(ExpectedConditions.visibilityOf(element));
}

/**
 * 
 * To wait until the element is Clickable(Explicit Wait)
 * 
 * @param Driver
 * @param Element
 * 
 * 
 */

public void elementtobeclicable(WebDriver driver,WebElement element)
{
	WebDriverWait wait =new WebDriverWait(driver, PathConstants.explicitelywait);
	wait.until(ExpectedConditions.elementToBeClickable(element));
}

/**
 * 
 * To do mouseover action 
 * 
 * @param Driver
 * @param Element
 * 
 * 
 */
public void mouseoverAction(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.moveToElement(element).perform();;
}

/**
 * 
 * To handle dropdown dased on index
 * 
 * @param Element
 * @param index
 * 
 * 
 */

public void dropdownselect(WebElement element,int index)
{
	Select select=new Select(element);
	select.selectByIndex(index);
}

/**
 * 
 * To handle dropdown based on visible text
 * 
 * @param Element
 * @param text
 * 
 * 
 */

public void dropdownselect(WebElement element,String visibletext)
{
	Select select=new Select(element);
	select.selectByVisibleText(visibletext);
}

/**
 * 
 * implicit wait
 * 
 * @param driver(address of the application)
 * 
 * 
 */

public void implicitelywait(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(PathConstants.implicitelywait, TimeUnit.SECONDS);
}

/**
 * 
 * To handle child browser popup
 * to switch the control 
 * 
 * @param driver(address of the application
 * @param browser title
 * 
 * 
 */

public void switchToBrowser(WebDriver driver,String browserTitle) {
	 Set<String> set = driver.getWindowHandles();
	  
	  for(String act : set) {
		  driver.switchTo().window(act);
		  String actPageTile = driver.getTitle();
		  if(actPageTile.contains(browserTitle)) {
			  break;
		  }
	  }
}

/**
 * 
 * To handle Frames based on index
 * 
 * @param driver(address of the application)
 * @param index
 * 
 * 
 */

public void swithchtoframe(WebDriver driver,int index)
{
	driver.switchTo().frame(index);
}

/**
 * 
 * To switch control to Frames based on element(frame) address
 * 
 * @param driver(address of the application)
 * @param Element
 * 
 * 
 */

public void swithchtoframe(WebDriver driver,WebElement element)
{
	driver.switchTo().frame(element);
}

/**
 * 
 * To switch control to Frames based on name or id
 * 
 * @param driver(address of the application)
 * @param name or id
 * 
 * 
 */

public void swithchtoframe(WebDriver driver,String nameorid)
{
	driver.switchTo().frame(nameorid);
}

/**
 * 
 * To switch the control to parent(frames concept)
 * 
 * @param driver(address of the application)
 * 
 * 
 */

public void switchtodefaultcontent(WebDriver driver)
{
	driver.switchTo().defaultContent();
}

/**
 * 
 * To handle alert popup(accept)
 * 
 * @param driver(address of the application)
 * 
 * 
 */

public void acceptallert(WebDriver driver)
{
	driver.switchTo().alert().accept();
}

/**
 * 
 * To handle alert popup(dismiss)
 * 
 * @param driver(address of the application)
 * 
 * 
 */

public void dismissallert(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}


/**
 * 
 * To take screenshot
 * 
 * @param driver(address of the application)
 * 
 * 
 */
public String getphoto(WebDriver driver,String methodName) throws IOException
{
	String photo="./photo/";
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	String path=""+photo+""+methodName+".PNG";
	File dst=new File(photo+methodName+".PNG");
	FileUtils.copyFile(src, dst);
	return path;
}

/**
 * 
 * generic method to wait and click on the element
 * 
 * @param element(address of the element)
 * 
 * 
 */

public void waitAndClick( WebElement element) throws Throwable {
	  int count = 0;
      while(count < 40) {
		   try {
			   element.click();
		     break;
		   }catch (Throwable e) {
			Thread.sleep(500);
			count++;
		   }
      }
}

/**
 * 
 * to wait for an element
 * 
 * @param element(address of the element)
 * 
 * 
 */
public void waitforElement( WebElement element) throws Throwable {
	  int count = 0;
      while(count < 40) {
		   try {
			   element.isDisplayed();
		     break;
		   }catch (Throwable e) {
			Thread.sleep(500);
			count++;
		   }
      }
}
}
