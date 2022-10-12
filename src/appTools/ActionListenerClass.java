package appTools;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JPanel;
import App.ConnectionFactory;
import GUI_JediDB.MainPanel;


public class ActionListenerClass extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	public void actionPerformed (ActionEvent e) {

		if (e.getSource() == MainPanel.beingsButton) {
			try {
				Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
				MainPanel.textTitle.setText("Luminous Beings");
				VisualPane.setScrollPane("beings", connection);
				repaint();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			System.out.println("WE ARE ALL LUMINOUS BEINGS");
		} else if (e.getSource() == MainPanel.jediButton) {
			try {
				Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
				MainPanel.textTitle.setText("Jedi");
				VisualPane.setScrollPane("jedi", connection);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			System.out.println("JEDI RULE");

		} else if (e.getSource() == MainPanel.sithButton) {
			try {
				Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
				MainPanel.textTitle.setText("Sith");
				VisualPane.setScrollPane("sith", connection);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			System.out.println("SITH RULE");

		} else if (e.getSource() == MainPanel.bhButton) {
			try {
				Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
				MainPanel.textTitle.setText("Bounty Hunters");
				VisualPane.setScrollPane("bountyHunters", connection);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			System.out.println("BOUNTY HUNTERS RULE");

		} else if (e.getSource() == MainPanel.smugglersButton) {
			try {
				Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
				MainPanel.textTitle.setText("Smugglers");
				VisualPane.setScrollPane("smugglers", connection);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			System.out.println("SMUGGLERS RULE");

		} else if (e.getSource() == MainPanel.battlesButton) {
			try {
				Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
				MainPanel.textTitle.setText("Battles");
				VisualPane.setScrollPane("battles", connection);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("STAR WARS BATTLES ARE AWESOME");
		}

	}


	@Override
	protected void paintComponent (Graphics g) {
		super.paintComponent(g);
		g.drawImage(VisualPane.bgImage, 0, 0, null);
	}

}
