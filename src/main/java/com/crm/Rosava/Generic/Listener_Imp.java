package com.crm.Rosava.Generic;

import org.openqa.grid.internal.utils.HtmlRenderer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * 
 * @author Bharath Kumar
 *
 */
public class Listener_Imp extends BaseClass implements ITestListener {
            public ExtentTest test;
            public ExtentReports report;
            
            
		    public void onFinish(ITestContext result) {	
		    	
		       	report.flush();			
		        		
		    }		

		    		
		    public void onStart(ITestContext result) {					
		        		ExtentSparkReporter spark=new ExtentSparkReporter("./ExtentReport.html");
		        		spark.config().setTheme(Theme.DARK);
		        		spark.config().setDocumentTitle("vTiger App");
		        		spark.config().setReportName("Full Regression Test");
		        		report=new ExtentReports();
		        		report.attachReporter(spark);
		        		report.setSystemInfo("platform", "windows");
		        		report.setSystemInfo("OS", "Windows 10");
		        		report.setSystemInfo("Environment", "Testing Environment");
		        		report.setSystemInfo("Reporter", "Bharath");
		        		
		    }		

		    		
		    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
		       				
		        		
		    }		
			/**
			 * 
			 * take screenshot for the failed test
			 * 
			 */
					    		
		    public void onTestFailure(ITestResult result) {	
		    	
		    	test.log(Status.FAIL, result.getMethod().getMethodName()+" is fail");
		    	test.log(Status.FAIL, result.getThrowable());
		    	try{
		            String date = java.systemDateandTime();
		    		util.getphoto(BaseClass.staticdriver,result.getMethod().getMethodName()+date);
		    		test.addScreenCaptureFromPath(util.getphoto(BaseClass.staticdriver, result.getMethod().getMethodName()+date));
		    		}
		    		catch (Exception e) {
		    		e.printStackTrace();
		    		} 			
		        		
		    }		

		    		
		    public void onTestSkipped(ITestResult result) {					
		        			
		        	test.log(Status.SKIP, result.getMethod().getMethodName()+" is skipped")	;
		        	test.log(Status.SKIP, result.getThrowable());
		    }		

		    		
		    public void onTestStart(ITestResult result) {					
		       			
		        test=report.createTest(result.getMethod().getMethodName());		
		    }		

		    		
		    public void onTestSuccess(ITestResult result) {					
		       				
		       test.log(Status.PASS, result.getMethod().getMethodName()+" is passed");		
		    }
		
	}
