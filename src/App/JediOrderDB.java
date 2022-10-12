package App;

import java.sql.*;
import GUI_JediDB.*;



public class JediOrderDB {

	public static void main (String[] args) throws Exception {
		
		Frame frame = new Frame();
		
		Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
		System.out.println("Connected: " + connection.getMetaData().getDatabaseProductName());

		MainPanel.setPanelToRoot();
		MainPanel.setScrollPane("beings", connection);
		
		
		//close the connection
	}



}
