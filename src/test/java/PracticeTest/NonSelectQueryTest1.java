package PracticeTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQueryTest1 {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		int result=0;
		try {
			//register the database
			Driver driver=new Driver();
	 		DriverManager.registerDriver(driver);
			//get connection for database
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet_50", "root", "root");
			//create statement
			Statement state=con.createStatement();
			String query="rename table rmg to rmg1;";
			//execute query
			result=state.executeUpdate(query);
		}
			catch(Exception e)
		{
		}
finally
{if(result>=0)
	 {
	System.out.println("Data updated succesfully");
	}
else{
	System.err.println("data not updated");
}
		
{
	//close db connection
	con.close();
}
	}}

	}


