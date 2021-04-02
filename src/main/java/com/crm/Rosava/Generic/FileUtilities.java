package com.crm.Rosava.Generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * 
 *@author Bharath Kumar
 *
 */
public class FileUtilities {
	
	/**
	 * 
	 * To get data from the Property file
	 * 
	 * @param Key
	 *@return data
	 *
	 */
	public String PropertyData(String key) throws IOException
	{
	FileInputStream fis=new FileInputStream(PathConstants.propertiespath);
	Properties pobj=new Properties();
	pobj.load(fis);
	return pobj.getProperty(key);
	}
}
