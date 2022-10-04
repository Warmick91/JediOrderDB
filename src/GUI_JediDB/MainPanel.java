package GUI_JediDB;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class MainPanel extends JPanel {

	private JPanel tablePanel = new JPanel();
	private JTable table = new JTable();
	private String[][] data;

	JLabel textTitle = new JLabel();

	File pathToFile = new File("src/images/Jedi_Archives.jpg");
	Image bgImage;

	JLabel buttonsLabel = new JLabel();

	Font swFont;


	public MainPanel (int width, int height) {

		try {
			setPanelToMain(width, height);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		//Registering font
		try {
			swFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/starjedi/Starjedi.ttf")).deriveFont(30f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/starjedi/Starjedi.ttf")));
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.tablePanel.setBackground(Color.blue);
		this.tablePanel.setSize(new Dimension(600, 350));
		this.tablePanel.setLocation(width / 2 - tablePanel.getWidth() / 2, height / 2 - tablePanel.getHeight() / 2 - 50);
		this.add(tablePanel);

		textTitle = new JLabel("Root location", SwingConstants.CENTER);
		textTitle.setFont(swFont);
		textTitle.setForeground(Color.white);
		textTitle.setBackground(Color.green);
		textTitle.setBounds(tablePanel.getX(), tablePanel.getY() - 50, 600, 30);
		textTitle.setOpaque(true);
		this.add(textTitle);

		buttonsLabel.setBackground(Color.green);
		buttonsLabel.setBounds(tablePanel.getX(), tablePanel.getY() + tablePanel.getHeight() + 20, 600, 75);
		buttonsLabel.setLayout(new GridLayout(0, 2, 5, 5));
		//buttonsLabel.setOpaque(true);
		buttonsLabel.add(new JButton("Jedi"));
		buttonsLabel.add(new JButton("Sith"));
		buttonsLabel.add(new JButton("Bounty Hunters"));
		buttonsLabel.add(new JButton("Smugglers"));
		buttonsLabel.add(new JButton("Battles"));
		buttonsLabel.add(new JButton("Planets"));

		this.add(buttonsLabel);

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
