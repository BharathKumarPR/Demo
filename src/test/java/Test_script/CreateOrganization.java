package Test_script;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateOrganization {
	String SheetName="Sheet1";
	int colIndex;
	Random random=new Random();
	int randomint = random.nextInt(1000);
	
	@Test(dataProvider="getdata")
	public void handlingDynamicWebTable(String org) throws InterruptedException
	{
		String rand = Integer.toString(randomint);
		//String phone=Integer.toString(mob);
		System.setProperty("webdriver.gecko.driver", "./exefiles/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,20);
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@title='Create Organization...']")));
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(org+rand);
		//driver.findElement(By.id("phone")).sendKeys(phone);
		driver.findElement(By.id("email1")).sendKeys("bha12345@gmail.com");
		driver.findElement(By.xpath("(//input[@value='  Save  '])[1]")).click();
	}
	
	public String getdataExe(String SheetName) throws IOException
	{
		FileInputStream fis=new FileInputStream("./excel/dat.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row row = sh.getRow(0);
		Cell col = row.getCell(0);
		String val = col.getStringCellValue();
	    //int colIndex =row.getLastCellNum();
	    //this.colIndex=colIndex;
		wb.close();
		return val;
	}
	@DataProvider
	public Object[][] getdata() throws EncryptedDocumentException, IOException
	 {
		
		Object[][] objarr=new Object[1][1];
		
		
		objarr[0][0]=getdataExe(SheetName);
		 return objarr;
		
		
	}
}
