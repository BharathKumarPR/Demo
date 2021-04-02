package Test_script;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CreateOrg {
	Random random=new Random();
	int randomint = random.nextInt(1000);
@Test
public void OrganizationCreation() throws InterruptedException
{
	System.setProperty("webdriver.gecko.driver", "./exefiles/geckodriver.exe");
	WebDriver driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebDriverWait wait = new WebDriverWait(driver,20);
	driver.get("http://localhost:8888/");
	
	//login to v_lion
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	
	//create organization
	driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	Thread.sleep(5000);
	driver.findElement(By.name("accountname")).sendKeys("TY"+randomint+"");
	driver.findElement(By.id("phone")).sendKeys("9632658695");
	driver.findElement(By.xpath("//img[@title='Select']")).click();
	
	//Handling child browser popup
	String parent_id = driver.getWindowHandle();
	Set<String> ids = driver.getWindowHandles();
	ids.remove(parent_id);
	for(String wh:ids)
	{
		driver.switchTo().window(wh);
		driver.findElement(By.id("search_txt")).sendKeys("spider_1");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[.='spider_1']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	//swithback control to parent browser
	driver.switchTo().window(parent_id);
	
	//Handling  Rating dropdowns
	WebElement ele = driver.findElement(By.name("rating"));
	Select s=new Select(ele);
	s.selectByValue("Active");
	
	//Handling  Industry dropdowns
	WebElement ele1 = driver.findElement(By.name("industry"));
	Select s1=new Select(ele1);
	s1.selectByValue("Education");
	
	//Handling  accountType dropdowns
	WebElement ele2 = driver.findElement(By.name("accounttype"));
	Select s2=new Select(ele2);
	s2.selectByValue("Investor");
	
	//click on save button
	driver.findElement(By.xpath("(//input[@value='  Save  '])[1]")).click();
	
	//validation
	Thread.sleep(5000);
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	driver.findElement(By.name("search_text")).sendKeys("TY"+randomint+"");
	
	WebElement ele3 = driver.findElement(By.name("search_field"));
	Select s3=new Select(ele3);
	s3.selectByValue("accountname");
	
	Thread.sleep(5000);
	driver.findElement(By.name("submit")).click();
}
}
