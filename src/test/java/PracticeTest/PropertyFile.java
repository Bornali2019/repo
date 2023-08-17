package PracticeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\propertyfile.properties");
Properties ppt=new Properties();
ppt.load(fis);
String URL=ppt.getProperty("url");
String BROWSER=ppt.getProperty("browser");
String USERNAME=ppt.getProperty("username");
String PASSWORD=ppt.getProperty("password");
System.out.println(URL);
System.out.println(BROWSER);
	System.out.println(USERNAME);
	System.out.println(PASSWORD);
}
}