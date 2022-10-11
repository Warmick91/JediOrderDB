package App;

import java.sql.*;
import GUI_JediDB.*;



public class JediOrderDB {

	public static void main (String[] args) throws Exception {
		
		Frame frame = new Frame();
		ActionListenerClass actionListenerClass = new ActionListenerClass();
		
		Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
		System.out.println("Connected: " + connection.getMetaData().getDatabaseProductName());

		MainPanel.setPanelToMain();
		MainPanel.setScrollPane("beings", connection);
		
		
		//close the connection
	}

	//	@Override
	//	public void actionPerformed (ActionEvent ae) {
	//		// TODO Auto-generated method stub
	//		if (ae.getSource() == MainPanel.jediButton) {
	//			try {
	//				Connection connection;
	//				MainPanel.setScrollPane("jedi", connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL));
	//			} catch (Exception e) {
	//				e.printStackTrace();
	//			}
	//		}
	//	}

}
