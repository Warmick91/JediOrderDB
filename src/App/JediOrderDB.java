package App;

import java.sql.*;
import GUI_JediDB.*;
import appTools.VisualPane;



public class JediOrderDB {

	public static void main (String[] args) throws Exception {
		
		@SuppressWarnings("unused")
		Frame frame = new Frame();
		
		Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
		System.out.println("Connected: " + connection.getMetaData().getDatabaseProductName());

//		VisualPane.setPanelToRoot();
//		VisualPane.setScrollPane("beings", connection);
		
		
		//close the connection
	}

	

}
