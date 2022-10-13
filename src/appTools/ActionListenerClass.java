package appTools;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JPanel;
import app.ConnectionFactory;
import gui_JediDB.Frame;
import gui_JediDB.MainPanel;


public class ActionListenerClass implements ActionListener {

	@Override
	public void actionPerformed (ActionEvent e) {

		if (e.getSource() == MainPanel.beingsButton) {
			try {
				Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
				MainPanel.textTitle.setText("Luminous Beings");
				Frame.gui.setScrollPane("beings", connection);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			System.out.println("WE ARE ALL LUMINOUS BEINGS");
		} else if (e.getSource() == MainPanel.jediButton) {
			try {
				Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
				MainPanel.textTitle.setText("Jedi");
				Frame.gui.setScrollPane("jedi", connection);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			System.out.println("JEDI RULE");

		} else if (e.getSource() == MainPanel.sithButton) {
			try {
				Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
				MainPanel.textTitle.setText("Sith");
				Frame.gui.setScrollPane("sith", connection);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			System.out.println("SITH RULE");

		} else if (e.getSource() == MainPanel.bhButton) {
			try {
				Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
				MainPanel.textTitle.setText("Bounty Hunters");
				Frame.gui.setScrollPane("bountyHunters", connection);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			System.out.println("BOUNTY HUNTERS RULE");

		} else if (e.getSource() == MainPanel.smugglersButton) {
			try {
				Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
				MainPanel.textTitle.setText("Smugglers");
				Frame.gui.setScrollPane("smugglers", connection);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			System.out.println("SMUGGLERS RULE");

		} else if (e.getSource() == MainPanel.battlesButton) {
			try {
				Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
				MainPanel.textTitle.setText("Battles");
				Frame.gui.setScrollPane("battles", connection);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("STAR WARS BATTLES ARE AWESOME");
			
		} else if (e.getSource() == MainPanel.modifiedSearchButton) {
			Frame.gui.setPanelToCustomSearch();
			
		} else if (e.getSource() == MainPanel.goBackButton) {
			Frame.gui.setPanelToStart();
			
		} else if (e.getSource() == MainPanel.manipulateButton) {
			Frame.gui.setPanelToJMAccess();
			
		} else if (e.getSource() == MainPanel.updateJediButton) {
			
		}

	}

}
