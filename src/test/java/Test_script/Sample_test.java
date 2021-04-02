package Test_script;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Sample_test extends ExcelUtility {
	String SheetName="Data1";
	int count=0;
	ExcelUtility excel=new ExcelUtility();
@Test(dataProvider="getdata")
public void AirTicket(String src,String dst) throws EncryptedDocumentException, IOException
{	
	//System.setProperty("webdriver.gecko.driver", "./exefiles/geckodriver.exe");
	WebDriver driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.get("https://www.makemytrip.com/flights");
	
	Actions act=new Actions(driver);
	act.moveByOffset(15,15).click().perform();
	
	driver.findElement(By.xpath("//span[.='From']")).click();
	driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(src);
	driver.findElement(By.xpath("//div[.='"+src+"']")).click();
	
	driver.findElement(By.xpath("//span[.='To']")).click();
	driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(dst);
	driver.findElement(By.xpath("//div[.='"+dst+"']")).click();
	
	driver.findElement(By.xpath("//a[.='Search']")).click();

	List<WebElement> flights = driver.findElements(By.xpath("//span[@class='airways-name ']"));
    int num = flights.size();
    String value = Integer.toString(num);
    
    excel.setExcelData("Data1",count, 2, value);
	count++;
	driver.close();
}

@DataProvider
public Object[][] getdata() throws EncryptedDocumentException, IOException
 {
	//
	int rowIndex = excel.getRowCount("Data1");
	Object[][] objarr=new Object[rowIndex][2];
	
	for(int i=0;i<rowIndex;i++)
	{
	objarr[i][0]=excel.getExcelData("Data1", i, 0);
	objarr[i][1]=excel.getExcelData("Data1", i, 1);
	}
	 return objarr;
	
	
}
}
