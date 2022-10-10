package GUI_JediDB;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import App.ConnectionFactory;
import App.Operation;


@SuppressWarnings("serial")
public class ActionListenerClass implements ActionListener {

	@Override
	public void actionPerformed (ActionEvent e) {
		if (e.getSource() == MainPanel.jediButton) {
			try {
				Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
				MainPanel.setScrollPane("jedi", connection);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			System.out.println("JEDI RULE");
			
		} else if (e.getSource() == MainPanel.sithButton) {
			try {
				Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
				MainPanel.setScrollPane("sith", connection);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			System.out.println("SITH RULE");
			
		} else if (e.getSource() == MainPanel.bhButton) {
			try {
				Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
				MainPanel.setScrollPane("bountyHunters", connection);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			System.out.println("BOUNTY HUNTERS RULE");
			
		} else if (e.getSource() == MainPanel.smugglersButton) {
			try {
				Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
				MainPanel.setScrollPane("smugglers", connection);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			System.out.println("SMUGGLERS RULE");
			
		} else if (e.getSource() == MainPanel.battlesButton) {
			Connection connection;
			try {
				connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
				MainPanel.setScrollPane("battles", connection);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("STAR WARS BATTLES ARE AWESOME");
		}

	}

}
