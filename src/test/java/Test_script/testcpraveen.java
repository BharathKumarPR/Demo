package Test_script;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.Rosava.Generic.FileUtilities;
import com.crm.Rosava.Generic.JavaUtilities;
import com.crm.Rosava.Generic.WebDriverUtilities;

public class testcpraveen {
	WebDriver driver = new FirefoxDriver();
	ExcelUtility eut = new ExcelUtility();
	FileUtilities fut = new FileUtilities();
	JavaUtilities jut =new JavaUtilities();
	WebDriverUtilities wut = new WebDriverUtilities();
	
	
	
@Test
public void test() throws IOException
{
	System.setProperty("webdriver.gecko.driver", "./exefiles/geckodriver.exe");
	wut.implicitelywait(driver);
	driver.get(fut.PropertyData("URL"));
	driver.findElement(By.name("user_name")).sendKeys(fut.PropertyData("USERNAME"));
	driver.findElement(By.name("user_password")).sendKeys(fut.PropertyData("PASSWORD"));
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.xpath("//a[.='Leads']")).click();
	
}
}
