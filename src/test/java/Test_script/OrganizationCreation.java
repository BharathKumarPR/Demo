package Test_script;

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

public class OrganizationCreation {
	
	WebDriver driver=new FirefoxDriver();
	JavaUtilities java=new JavaUtilities();
	ExcelUtility excel=new ExcelUtility();
	FileUtilities file=new FileUtilities();
	WebDriverUtilities util=new WebDriverUtilities();
	String SheetName="sheet1";
	@Test
	public void creation() throws EncryptedDocumentException, IOException, InterruptedException
	{
		int num = java.RandomNum();
		int Rowcount = excel.getRowCount(SheetName);
		String name = excel.getExcelData(SheetName, Rowcount, 0);
		String orgName=name+num;
		
		System.setProperty("webdriver.gecko.driver", "./exefiles/geckodriver.exe");
		util.implicitelywait(driver);
		driver.get(file.PropertyData("URL"));
		
		driver.findElement(By.name("user_name")).sendKeys(file.PropertyData("USERNAME"));
		driver.findElement(By.name("user_password")).sendKeys(file.PropertyData("PASSWORD"));
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.id("phone")).sendKeys("9632658695");
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		//util.swithchtochildwindow(driver);
		driver.findElement(By.id("search_txt")).sendKeys("spider_1");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[.='spider_1']")).click();
		util.acceptallert(driver);
		//util.swithchtoparentwindow(driver);
		WebElement ele = driver.findElement(By.name("rating"));
		util.dropdownselect(ele, "Active");
		WebElement ele1 = driver.findElement(By.name("industry"));
		util.dropdownselect(ele1, "Education");
		WebElement ele2 = driver.findElement(By.name("accounttype"));
		util.dropdownselect(ele2, "Investor");
		driver.findElement(By.xpath("(//input[@value='  Save  '])[1]")).click();
		Thread.sleep(10000);
		//driver.navigate().refresh();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("search_text")).sendKeys(orgName);
		WebElement ele3 = driver.findElement(By.name("search_field"));
		util.dropdownselect(ele3, "accountname");
		driver.findElement(By.name("submit")).click();
		
	}
}
