package PracticeTest;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.Sms.GeneralUtility.IPathConstants;

public class DataProv_ExcelTest {
	@Test(dataProvider="getDataFromExce")
	public void getDataFromExcel(String client, String location) {
		System.out.println(client+"............="+location);
	}
	
	
	
	
	@DataProvider
	public Object[][] getDataFromExce() throws Throwable  {
		FileInputStream fis= new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("dataprovider");
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
