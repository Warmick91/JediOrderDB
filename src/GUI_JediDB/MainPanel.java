package GUI_JediDB;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTable;

public class MainPanel extends JPanel {

    private JPanel tablePanel = new JPanel();
    private JTable table = new JTable();
    private String[][] data;

    /**
     * 
     */
    public MainPanel(int width, int height) {

	setPanelToMain(width, height);
	this.tablePanel.setBackground(Color.blue);
	this.tablePanel.setSize(new Dimension(600, 350));
	this.tablePanel.setLocation(width / 2 - tablePanel.getWidth() / 2,
		height / 2 - tablePanel.getHeight() / 2 - 50);
	this.add(tablePanel);
    }

    public void setPanelToMain(int width, int height) {
	this.setPreferredSize(new Dimension(width, height));
	this.setBackground(Color.red);
	this.setLayout(null);
    }

}
