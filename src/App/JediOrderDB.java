package App;

import java.sql.*;

import GUI_JediDB.Frame;

public class JediOrderDB {
	
	public static void main (String[] args) throws SQLException {
		Frame frame = new Frame();
		
		try(Connection oracleConnection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "root")){
		    System.out.println("Connected: " + oracleConnection.getMetaData().getDatabaseProductName());
		    
		    
		}
		
	}
}
