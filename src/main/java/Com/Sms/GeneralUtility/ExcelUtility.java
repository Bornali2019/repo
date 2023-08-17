package Com.Sms.GeneralUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String readDataFromExcel(String sheetName, int rowNo,int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		String value=wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).toString();
		return value;	
	}
	public void writeDataIntoExcel(String sheetName, int rowNo,int cellNo, String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetName).createRow(rowNo).createCell(cellNo).setCellValue(data);
		FileOutputStream fos=new FileOutputStream(IPathConstants.ExcelPath);
		wb.write(fos);
		wb.close();
	}
	
	public int getLastRowNo(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		int count=sh.getLastRowNum();
		return count;
	}
	public HashMap<String, String> getMultipleDataFromExcel(String sheetName, int keyCellNo, int valuecellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		int count=sh.getLastRowNum();
		HashMap<String, String> map=new HashMap<String, String>();//empty map
		for(int i=0; i<=count; i++)
		{
			String key=sh.getRow(i).getCell(keyCellNo).toString();
			String value=sh.getRow(i).getCell(valuecellNo).toString();
			map.put(key,  value);
		}
		return map;

	}
	public Object[][]DPMultipleSetOfData(String sheetname) throws Throwable{
		FileInputStream fis= new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		int lastrow=sh.getLastRowNum()+1;
		int lastcell=sh.getRow(0).getLastCellNum();
		
		Object[][] obj=new Object[lastrow][lastcell];
		for(int i=0; i<lastrow; i++)	//row
		{
			for(int j=0; j<lastcell; j++)			//cell
			{
				obj[i][j]=sh.getRow(i).getCell(j).toString();
			}
		}
		return obj;
		
	}
}
