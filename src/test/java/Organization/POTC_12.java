package Organization;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.Rosava.Generic.ExcelUtility;
import com.crm.Rosava.Generic.FileUtilities;
import com.crm.Rosava.Generic.JavaUtilities;
import com.crm.Rosava.Generic.WebDriverUtilities;

public class POTC_12 {
	WebDriver driver=new FirefoxDriver();
	WebDriverUtilities util=new WebDriverUtilities();
	FileUtilities file=new FileUtilities();
	ExcelUtility excel=new ExcelUtility();
	JavaUtilities java=new JavaUtilities();
@Test
public void CreateOrderWithItem() throws EncryptedDocumentException, IOException
{
	int num = java.RandomNum();
	String name = excel.getExcelData("sheet1", 0, 0);
	String orgName=name+num;
	System.setProperty("webdriver.gecko.driver", "./exefiles/geckodriver.exe");
	util.implicitelywait(driver);
	driver.get(file.PropertyData("URL"));
	
	driver.findElement(By.name("user_name")).sendKeys(file.PropertyData("USERNAME"));
	driver.findElement(By.name("user_password")).sendKeys(file.PropertyData("PASSWORD"));
	driver.findElement(By.id("submitButton")).click();
	
	WebElement ele = driver.findElement(By.xpath("//a[.='More']"));
	util.mouseoverAction(driver, ele);
	ele.click();
	
	driver.findElement(By.xpath("//a[.='Purchase Order']")).click();
	driver.findElement(By.xpath("//img[@title='Create Purchase Order...']")).click();
	driver.findElement(By.name("subject")).sendKeys();
	
	
	driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
	
	//util.swithchtochildwindow(driver);
	driver.findElement(By.name("search_text")).sendKeys("spider");
	//driver.findElement(By.)
}
}
