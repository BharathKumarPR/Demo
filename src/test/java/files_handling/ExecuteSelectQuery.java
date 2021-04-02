package files_handling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteSelectQuery {

		public static void main(String[] args) throws Throwable {
			Connection conn = null;
	     try {
			  Driver driverRef = new Driver();
			  DriverManager.registerDriver(driverRef);
			  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bharath", "root", "root");
			  System.out.println("done");
			  Statement stat= conn.createStatement();
			  String query = "select * from userdata";
			  ResultSet resultSet =  stat.executeQuery(query);
			  while (resultSet.next()) 
			  {
			  System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2)+ "\t" + resultSet.getString(3)+ "\t" + resultSet.getString(4));
						
			  }
	         }catch (Exception e) {
					       e.printStackTrace();
			  }finally {
				        conn.close();
						System.out.println("close Connection ");
					}

		}

	}
