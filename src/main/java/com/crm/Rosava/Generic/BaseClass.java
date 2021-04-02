package com.crm.Rosava.Generic;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.Rosava.ObjectRepository.Home;
import com.crm.Rosava.ObjectRepository.login;

/**
 * 
 * @author Bharath Kumar
 *
 */
public class BaseClass {

	/**
	 * object creation
	 */
	public WebDriver driver;
	public static WebDriver staticdriver;
	public WebDriverUtilities util=new WebDriverUtilities();
	public FileUtilities file=new FileUtilities();
	public ExcelUtility excel=new ExcelUtility();
	public JavaUtilities java=new JavaUtilities();
	
	public DataBaseUtility database = new DataBaseUtility();

	@BeforeSuite
	/**
	 * 
	 * to register and connect to the database
	 * 
	 */
	public void configBeforeSuite() throws Throwable {
		database.connectToDB();
	}
	

	@BeforeClass(groups = {"smokeTest" , "RegressionTest"})
	/**
	 * 
	 * to launch the specific browser
	 * to read common data from property file
	 * 
	 */
	public void configBeforeClass() throws Throwable {
		String URL = file.PropertyData("URL");

		String BROWSER = file.PropertyData("BROWSER");
		
		 if(BROWSER.equals("firefox")) {
		    driver = new FirefoxDriver();
		 }else if(BROWSER.equals("chrome")) {
			 driver = new ChromeDriver();
		 }else if(BROWSER.equals("ie")) {
			 driver = new InternetExplorerDriver();
		 }else {
			 driver = new ChromeDriver();
		 }
		staticdriver=driver;
		 driver.get(URL);
	}
	
	
	@Parameters("BROWSER")
	//@BeforeClass(groups = {"smokeTest" , "RegressionTest"})
	/**
	 * 
	 * to launch the specific browser
	 * to read common data from property file
	 * 
	 */
	public void configBeforeClass(String Browser) throws Throwable {
		String URL = file.PropertyData("URL");
		
		 if(Browser.equals("firefox")) {
		    driver = new FirefoxDriver();
		 }else if(Browser.equals("chrome")) {
			 driver = new ChromeDriver();
		 }else if(Browser.equals("ie")) {
			 driver = new InternetExplorerDriver();
		 }else {
			 driver = new ChromeDriver();
		 }
		
		 driver.get(URL);
	}
	
	@BeforeMethod
	/**
	 * 
	 * to login to the application
	 * 
	 */
	public void configBeforeMtd() throws Throwable {
		String USERNAME = file.PropertyData("USERNAME");
		String PASSWORD = file.PropertyData("PASSWORD");
		login log=new login(driver);
		log.loginToAPP(USERNAME,PASSWORD);
	}
	
	@AfterMethod
	/**
	 * 
	 * to logout of the application
	 * 
	 */
	public void configAfterMethod() throws Throwable {
		Home home= new Home(driver);
			  home.logout();
    }
	
	
	@AfterClass
	/**
	 * 
	 * to close the browser
	 * 
	 */
	public void configAfterClass() {
		driver.close();
	}
	
	@AfterSuite
	/**
	 * to close the database connection
	 */
	public void configAfterSuite() throws Throwable {
		database.closeDb();
		
	}

}

