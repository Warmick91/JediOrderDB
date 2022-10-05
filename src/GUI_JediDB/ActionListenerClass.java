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
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("JEDI RULE");
		} else if (e.getSource() == MainPanel.sithButton) {
			try {
				Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
				MainPanel.setScrollPane("sith", connection);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("SITH RULE");
		}

	}



}
