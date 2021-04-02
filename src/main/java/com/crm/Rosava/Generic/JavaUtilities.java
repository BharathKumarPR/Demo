package com.crm.Rosava.Generic;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Bharath Kumar
 *
 */

public class JavaUtilities {
	
	/**
	 * 
	 * To generate random number
	 * 
	 * @return random number
	 *
	 */
public int RandomNum()
{
	Random random=new Random();
	int randomint = random.nextInt(1000);
	return randomint;
}

Date dateobj=new Date();
String currentdate = dateobj.toString();
String[] arr = currentdate.split(" ");

/**
 * 
 * To get System Date
 * 
 * @return system date
 *
 */
public String systemDateandTime()
{
    String Systemdate = currentdate.replace(' ', '_').replace(':', '_');
	return Systemdate;
}

/**
 * 
 * To get System Date
 * 
 * @return year
 *
 */

public String getCurrentYear()
{
	return arr[5];
}

/**
 * 
 * To get System Date
 * 
 * @return month
 *
 */

public String getCurrentMonth()
{
	return arr[1];
}

/**
 * 
 * To get System Date
 * 
 * @return date
 *
 */
public String getCurrentDate()
{
	return arr[2];
}
}
