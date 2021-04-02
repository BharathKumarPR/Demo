package Test_script;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class WebDynamicTable {
	@Test
	public void handlingDynamicWebTable() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "./exefiles/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a[@title='Organizations']"));
		ArrayList<String> A1=new ArrayList<String>();
		ArrayList<String> A2=new ArrayList<String>();
	    for(WebElement org:list)
	    {
	    	String orgName = org.getText();
	    	A1.add(orgName);
	    }
	    Collections.sort(A1);
	    System.out.println(A1);
	    
	    driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[1]/td[3]/a")).click();
	    Thread.sleep(4000);
	    List<WebElement> list1 = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a[@title='Organizations']"));
	    for(WebElement org1:list1)
	    {
	    	String orgName1 = org1.getText();
	    	A2.add(orgName1);
	    }
	    
	    System.out.println(A1);
	    System.out.println(A2);
	    Assert.assertEquals(A1, A2);
	    
	}
}


