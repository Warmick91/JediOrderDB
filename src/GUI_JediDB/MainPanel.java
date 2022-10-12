package GUI_JediDB;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import App.ConnectionFactory;
import App.Operation;
import appTools.ActionListenerClass;


@SuppressWarnings("serial")
public class MainPanel extends JPanel {

	private JPanel tablePanel = new JPanel();

	public static JLabel textTitle = new JLabel();

	static File generalBG = new File("src/images/Jedi_Archives.jpg");
	static File jediBG = new File("src/images/hyperspacejump.jpg");
	static File sithBG = new File("src/images/Korriban.jpg");
	static File bountyHuntersBG = new File("src/images/BountyHunters.jpg");
	static File smugglersBG = new File("src/images/milleniumFalcon.jpg");
	static File battlesBG = new File("src/images/sabersCrossed.jpg");
	static Image bgImage;

	JLabel buttonsLabel = new JLabel();

	Font swFont;

	//Buttons
	public static JButton beingsButton = new JButton("Root");
	public static JButton jediButton = new JButton("Jedi");
	public static JButton sithButton = new JButton("Sith");
	public static JButton bhButton = new JButton("Bounty Hunters");
	public static JButton smugglersButton = new JButton("Smugglers");
	public static JButton battlesButton = new JButton("Battles");
	public static JButton planetsButton = new JButton("Planets");

	static JScrollPane scrollPane = new JScrollPane();


	public MainPanel (int width, int height) throws Exception {
		JButton[] buttons = { jediButton, sithButton, bhButton, smugglersButton, battlesButton, planetsButton, beingsButton };
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].addActionListener(new ActionListenerClass());
		}

		setPanelToRoot();

		//Registering font
		try {
			swFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/starjedi/Starjedi.ttf")).deriveFont(30f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/starjedi/Starjedi.ttf")));
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}

		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.red);
		this.setLayout(null);

		this.tablePanel.setSize(new Dimension(600, 350));
		this.tablePanel.setLocation(width / 2 - tablePanel.getWidth() / 2, height / 2 - tablePanel.getHeight() / 2 - 50);
		this.tablePanel.setLayout(new BorderLayout());
		this.tablePanel.add(scrollPane, BorderLayout.CENTER);
		this.add(tablePanel);

		textTitle = new JLabel("Luminous Beings", SwingConstants.CENTER);
		textTitle.setFont(swFont);
		textTitle.setForeground(Color.yellow);
		textTitle.setBounds(tablePanel.getX(), tablePanel.getY() - 50, 600, 30);
		this.add(textTitle);

		buttonsLabel.setBackground(Color.green);
		buttonsLabel.setBounds(tablePanel.getX(), tablePanel.getY() + tablePanel.getHeight() + 20, 600, 75);
		buttonsLabel.setLayout(new GridLayout(0, 2, 5, 5));
		buttonsLabel.add(jediButton);
		buttonsLabel.add(sithButton);
		buttonsLabel.add(bhButton);
		buttonsLabel.add(smugglersButton);
		buttonsLabel.add(battlesButton);
		buttonsLabel.add(planetsButton);
		this.add(buttonsLabel);

		beingsButton.setBounds(tablePanel.getX() / 2 - 45, tablePanel.getHeight() / 2 + tablePanel.getY() - 30, 100, buttonsLabel.getHeight() / 2);
		this.add(beingsButton);

	}


	public static void setPanelToRoot () throws IOException {

		bgImage = ImageIO.read(generalBG).getScaledInstance(1000, 600, Image.SCALE_DEFAULT);

	}


	public static void setPanelToJedi () throws IOException {
		bgImage = ImageIO.read(jediBG).getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
	}


	public static void setPanelToSith () throws IOException {
		bgImage = ImageIO.read(sithBG).getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
	}


	public static void setPanelToBountyHunters () throws IOException {
		bgImage = ImageIO.read(bountyHuntersBG).getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
	}


	public static void setPanelToSmugglers () throws IOException {
		bgImage = ImageIO.read(smugglersBG).getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
	}


	public static void setPanelToBattles () throws IOException {
		bgImage = ImageIO.read(battlesBG).getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
	}


	public static void setScrollPane (String data, Connection connection) throws Exception {
		Connection con = connection;
		switch (data) {
			case "beings":
				MainPanel.scrollPane.getViewport().add(Operation.readQuery(Operation.SELECT_ALL_BEINGS, con));
				MainPanel.setPanelToRoot();
				break;
			case "jedi":
				MainPanel.scrollPane.getViewport().add(Operation.readQuery(Operation.SELECT_ALL_JEDI, con));
				MainPanel.setPanelToJedi();
				break;
			case "sith":
				MainPanel.scrollPane.getViewport().add(Operation.readQuery(Operation.SELECT_ALL_SITH, con));
				MainPanel.setPanelToSith();
				break;
			case "bountyHunters":
				MainPanel.scrollPane.getViewport().add(Operation.readQuery(Operation.SELECT_ALL_BOUNTYHUNTERS, con));
				MainPanel.setPanelToBountyHunters();
				break;
			case "smugglers":
				MainPanel.scrollPane.getViewport().add(Operation.readQuery(Operation.SELECT_ALL_SMUGGLERS, con));
				MainPanel.setPanelToSmugglers();
				break;
			case "battles":
				MainPanel.scrollPane.getViewport().add(Operation.readQuery(Operation.SELECT_ALL_BATTLES, con));
				MainPanel.setPanelToBattles();
		}
	}


	@Override
	protected void paintComponent (Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgImage, 0, 0, null);

	}
}
