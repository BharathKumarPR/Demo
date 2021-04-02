package Test_script;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelUtility {
	String FilePath="./excel/Ticketdata.xlsx";
	public String getExcelData(String SheetName,int rowNum,int colNum) throws EncryptedDocumentException, IOException
	{
		
	FileInputStream fis=new FileInputStream("./excel/Ticketdata.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(SheetName);
	Row row = sh.getRow(rowNum);
	wb.close();
	return row.getCell(colNum).getStringCellValue();
	}
	
	public  int getRowCount(String SheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./excel/Ticketdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		return sh.getLastRowNum();
	}
	
	public void setExcelData(String SheetName,int rowNum,int colNum,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./excel/Ticketdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row row = sh.getRow(rowNum);
		Cell col = row.createCell(colNum);
		col.setCellValue(data);
		FileOutputStream fout=new FileOutputStream(FilePath);
		wb.write(fout);
		wb.close();
	}
	
}
