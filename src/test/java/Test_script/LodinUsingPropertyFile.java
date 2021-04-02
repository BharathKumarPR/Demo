package Test_script;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LodinUsingPropertyFile {
@Test
public void Login() throws IOException
{
	System.setProperty("webdriver.gecko.driver", "./exefiles/geckodriver.exe");
	WebDriver driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//WebDriverWait wait = new WebDriverWait(driver,20);
	String[] app=PropertyFileData();
	driver.get(app[0]);
	
	//login to v_lion
	driver.findElement(By.name("user_name")).sendKeys(app[1]);
	driver.findElement(By.name("user_password")).sendKeys(app[2]);
	driver.findElement(By.id("submitButton")).click();
	
	driver.close();
}
public String[] PropertyFileData() throws IOException
{
	FileInputStream fis=new FileInputStream("./userdata.properties");
	Properties pobj=new Properties();
	pobj.load(fis);
	String URL= pobj.getProperty("URL");
	String USERNAME= pobj.getProperty("USERNAME");
	String PASSWORD= pobj.getProperty("PASSWORD");
	String[] arr={URL,USERNAME,PASSWORD};
	return arr;
}
}
