package com.crm.Rosava.Generic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * 
 * @author Bharath Kumar
 *
 */
public class Listener_Retry implements IRetryAnalyzer{
    int count=0;
    int retrylimit=4;
    
    /**
     * 
     * re-execute the failed test for specified number of times 
     * 
     */
	public boolean retry(ITestResult result) {
		if(count<retrylimit) {
			count++;
			return true;
		}
		return false;
	}

}
