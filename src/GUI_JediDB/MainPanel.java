package GUI_JediDB;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTable;


public class MainPanel extends JPanel {

	private JPanel tablePanel = new JPanel();
	private JTable table = new JTable();
	private String[][] data;

	File pathToFile = new File("src/images/Jedi_Archives.jpg");
	Image bgImage;


	public MainPanel (int width, int height) {

		try {
			setPanelToMain(width, height);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		this.tablePanel.setBackground(Color.blue);
		this.tablePanel.setSize(new Dimension(600, 350));
		this.tablePanel.setLocation(width / 2 - tablePanel.getWidth() / 2, height / 2 - tablePanel.getHeight() / 2 - 50);
		this.add(tablePanel);
	}


	public void setPanelToMain (int width, int height) throws IOException {
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.red);
		this.setLayout(null);
		bgImage = ImageIO.read(pathToFile).getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
		
	}


	@Override
	protected void paintComponent (Graphics g) {
		super.paintComponent(g);

		g.drawImage(bgImage, 0, 0, null);
	}

}
