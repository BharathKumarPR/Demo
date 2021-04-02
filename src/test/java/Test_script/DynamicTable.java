package Test_script;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DynamicTable {
@Test
public void handlingDynamicWebTable() throws AWTException, InterruptedException
{
	System.setProperty("webdriver.gecko.driver", "./exefiles/geckodriver.exe");
	WebDriver driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	WebDriverWait wait = new WebDriverWait(driver,20);
	driver.get("http://localhost:8888/");
	
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	
	driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
	Thread.sleep(5000);
	List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a[@title='Organizations']"));
    System.out.println(list.size());
	for(WebElement org:list)
    {
    	String orgName = org.getText();
    	
    	if(orgName.equals("spider_4"))
    	{
    		 System.out.println("running");
    		 Thread.sleep(8000);
    		 //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='lvt small']/tbody/tr[4]/td[3]/a[.='spider_3']")));
    		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[4]/td[3]/a[.='spider_4']")).click();
    	    System.out.println("running");
    		Thread.sleep(8000);
    		driver.findElement(By.xpath("(//input[@value='Delete'])[1]")).click();
    		System.out.println("running");
    		break;
    		
    	}
    }
	Thread.sleep(8000);
    Alert a = driver.switchTo().alert();
	a.accept();
    
    driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
	
    driver.findElement(By.name("search_text")).sendKeys("spider_4");
	
	WebElement ele3 = driver.findElement(By.name("search_field"));
	Select s3=new Select(ele3);
	s3.selectByValue("accountname");
	
	Thread.sleep(8000);
	driver.findElement(By.name("search")).click();
    
    
    driver.close();

}
}
