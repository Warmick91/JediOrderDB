package app;

import java.sql.*;
import GUI_JediDB.*;



public class JediOrderDB {

	public static void main (String[] args) throws Exception {
		
		@SuppressWarnings("unused")
		Frame frame = new Frame();
		
		Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
		System.out.println("Connected: " + connection.getMetaData().getDatabaseProductName());

		Frame.gui.setBackgroundToRoot();
		Frame.gui.setScrollPane("beings", connection);
		
		
		//close the connection
	}

	

}
