package App;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import GUI_JediDB.Frame;
import GUI_JediDB.MainPanel;


public class JediOrderDB {

	public static void main (String[] args) throws Exception {

		Frame frame = new Frame();

		try (Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL)) {
			System.out.println("Connected: " + connection.getMetaData().getDatabaseProductName());
			
		MainPanel.setScrollPane("beings", connection);
		//MainPanel.setScrollPane("jedi", connection);
		
		}
	}

	

}
