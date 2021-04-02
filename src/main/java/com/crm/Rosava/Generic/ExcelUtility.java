package com.crm.Rosava.Generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Bharath Kumar
 *
 */
public class ExcelUtility {
	
	/**
	 * 
	 * To get data from the Excel
	 * 
	 * @param sheetName
	 * @param row Number
	 * @param column number
	 * @return data
	 *
	 */
	public String getExcelData(String SheetName,int rowNum,int colNum) throws EncryptedDocumentException, IOException
	{
		
	FileInputStream fis=new FileInputStream(PathConstants.excelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(SheetName);
	Row row = sh.getRow(rowNum);
	wb.close();
	return row.getCell(colNum).getStringCellValue();
	}
	
	/**
	 * 
	 * To get last row number from the Excel
	 * 
	 * @param sheetName
	 * @return last row number
	 *
	 */
	
	public  int getRowCount(String SheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(PathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		return sh.getLastRowNum();
	}
	
	/**
	 * 
	 * To set data into the Excel
	 * 
	 * @param sheetName
	 * @param row Number
	 * @param coiumn number
	 * @param data
	 * 
	 *
	 */
	
	public void setExcelData(String SheetName,int rowNum,int colNum,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(PathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row row = sh.getRow(rowNum);
		Cell col = row.createCell(colNum);
		col.setCellValue(data);
		FileOutputStream fout=new FileOutputStream(PathConstants.excelPath);
		wb.write(fout);
		wb.close();
	}
	
	/**
	 * 
	 * To get last column number from the Excel
	 * 
	 * @param sheetName
	 * @param row Number
	 * @return last row number
	 *
	 */
	
	public  int getColumnCount(String SheetName,int rowcount) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(PathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row row = sh.getRow(rowcount);
		return row.getLastCellNum();
	}
	
	/**
	 * used to read the data from excel workbook based on testId & ColumnHeader
	 * @param sheetName
	 * @param expTestID
	 * @param expColHEader
	 * @return
	 * @throws Throwable
	 */
	public String getExcelData(String sheetName , String expTestID , String expColHEader) throws Throwable {
		
				int expTestRow = 0;
				int expHeader = 0;
				FileInputStream fis = new FileInputStream(PathConstants.excelPath);
				Workbook wb = WorkbookFactory.create(fis);
				Sheet sh = wb.getSheet(sheetName);
				int rowCount = sh.getLastRowNum();
			    
		    for(int i=0; i<rowCount ; i++) {		
				Row row = sh.getRow(i);
				String zeroColData= row.getCell(0).getStringCellValue();
		        if(expTestID.contentEquals(zeroColData)) {
		        	//System.out.println("test is available");
		        	expTestRow = i;
		        	break;
		        }
		    }
		    
		    int expColHeader = expTestRow-1;
		    
		        int colCount = sh.getRow(expColHeader).getLastCellNum();
		         for(int j=0 ; j <colCount ; j++) {
		        	   String actColHeader = sh.getRow(expColHeader).getCell(j).getStringCellValue();
		        	   if(actColHeader.equals(expColHEader)) {
		        		        //System.out.println("header is available ");
		        		        expHeader = j;
		        		        break;
		        	   }
		         }
		         
      return sh.getRow(expTestRow).getCell(expHeader).getStringCellValue();
				
	}
	
}
