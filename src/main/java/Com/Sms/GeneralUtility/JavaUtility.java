package Com.Sms.GeneralUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNo() {
		Random ran=new Random();
		int random=ran.nextInt(500);
		return random;
	}
public String getSystemDate() {
	Date d=new Date();
	String date=d.toString();
	return date;
	}
public String getSystemDateInFormat() {
	SimpleDateFormat dateformat=new SimpleDateFormat();
	Date d=new Date();
	String SystemDateInFormat=dateformat.format(d);
	return SystemDateInFormat;
}
}
