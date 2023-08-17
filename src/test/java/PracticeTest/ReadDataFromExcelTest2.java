package PracticeTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest2 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestDataExcel.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet1");
		int lastCell=sh.getRow(0).getLastCellNum();
		int rowCount=sh.getLastRowNum();
		for(int i=0; i<=rowCount; i++) {
			for(int j=0; j<=lastCell-1; j++) {
			String value=sh.getRow(i).getCell(j).getStringCellValue();
			System.err.println(value);
			}
		}
		
		wb.close();

	}}


