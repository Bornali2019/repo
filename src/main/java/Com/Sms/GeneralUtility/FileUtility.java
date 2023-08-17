package Com.Sms.GeneralUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstants.FilePath);
		Properties ppt =new Properties();
		ppt.load(fis);
		
		String value=ppt.getProperty(key);
 		return value;
		
	}

}


