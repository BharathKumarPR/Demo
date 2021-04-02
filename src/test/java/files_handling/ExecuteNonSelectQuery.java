package files_handling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteNonSelectQuery {
	
	public static void main(String[] args) throws SQLException {
	 Connection conn = null;
	 int result=0;
	 try{
     Driver driverref=new Driver();
     DriverManager.registerDriver(driverref);
     conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bharath", "root", "root");
	  System.out.println("done");
	  Statement stat= conn.createStatement();
	  String query = "insert into userdata value('naresh',953264863,'Delhi','BE')";
	  result=stat.executeUpdate(query);
	  System.out.println(result);
	  if(result==0) {
			System.err.println("project not created==FAIL");
		}else {
			System.out.println("project succuessFully cretaed==PASS");
		}
	 }catch(Exception e){
	 }
	 finally {
		   conn.close();
	 }
	}
	  
	}
