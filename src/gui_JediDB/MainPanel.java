package gui_JediDB;

import java.awt.BorderLayout;
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
import java.sql.Connection;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import app.Operation;
import appTools.ActionListenerClass;


@SuppressWarnings("serial")
public class MainPanel extends JPanel {

	static File generalBG = new File("images/Jedi_Archives.jpg");
	static File jediBG = new File("images/hyperspacejump.jpg");
	static File sithBG = new File("images/Korriban.jpg");
	static File bountyHuntersBG = new File("images/BountyHunters.jpg");
	static File smugglersBG = new File("images/milleniumFalcon.jpg");
	static File battlesBG = new File("images/sabersCrossed.jpg");
	public static Image bgImage;

	static JScrollPane scrollPane = new JScrollPane();
	private JPanel tablePanel = new JPanel();

	public static JLabel textTitle = new JLabel("", SwingConstants.CENTER);

	JLabel buttonsLabel = new JLabel();
	JLabel advancedButtons = new JLabel();

	Font swFont;

	//Main buttons
	public static JButton beingsButton = new JButton("Root");
	public static JButton jediButton = new JButton("Jedi");
	public static JButton sithButton = new JButton("Sith");
	public static JButton bhButton = new JButton("Bounty Hunters");
	public static JButton smugglersButton = new JButton("Smugglers");
	public static JButton battlesButton = new JButton("Battles");
	public static JButton planetsButton = new JButton("Planets");
	public static JButton modifiedSearchButton = new JButton("Modified search");
	public static JButton manipulateButton = new JButton("Jedi Master Access");
	public static JButton goBackButton = new JButton("Back <<<");
	public static JButton confirmButton = new JButton("Confirm >>>");
	public static JButton emptyFieldsButton = new JButton("Empty all fields []");

	//Update button
	public static JButton updateJediButton = new JButton("Jedi");
	public static JButton updateSithButton = new JButton("Sith");
	public static JButton updateBountyHuntersButton = new JButton("Bounty Hunters");
	public static JButton updateSmugglersButton = new JButton("Smugglers");
	public static JButton updateBattlesButton = new JButton("Battles");
	public static JButton updatePlanetsButton = new JButton("Planets");


	public MainPanel () throws Exception {

		//Registering font
		try {
			swFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/starjedi/Starjedi.ttf")).deriveFont(30f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/starjedi/Starjedi.ttf")));
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}

		//Adding Action Listener to
		JButton[] buttons = { updatePlanetsButton, updateBattlesButton, updateSmugglersButton, updateBountyHuntersButton, updateSithButton, updateJediButton, jediButton, sithButton, bhButton, smugglersButton, battlesButton, planetsButton, beingsButton, modifiedSearchButton, manipulateButton, goBackButton, confirmButton, emptyFieldsButton };
		for (JButton button : buttons) {
			button.addActionListener(new ActionListenerClass());
		}

		this.setPreferredSize(new Dimension(Frame.FRAME_WIDTH, Frame.FRAME_HEIGHT));
		this.setLayout(null);

		setPanelToStart();

	}


	public void setScrollPane (String data, Connection connection) throws Exception {
		Connection con = connection;
		switch (data) {
			case "beings":
				scrollPane.getViewport().add(Operation.readQuery(Operation.SELECT_ALL_BEINGS, con));
				Frame.gui.setBackgroundToRoot();
				break;
			case "jedi":
				scrollPane.getViewport().add(Operation.readQuery(Operation.SELECT_ALL_JEDI, con));
				Frame.gui.setBackgroundToJedi();
				break;
			case "sith":
				scrollPane.getViewport().add(Operation.readQuery(Operation.SELECT_ALL_SITH, con));
				Frame.gui.setBackgroundToSith();
				break;
			case "bountyHunters":
				scrollPane.getViewport().add(Operation.readQuery(Operation.SELECT_ALL_BOUNTYHUNTERS, con));
				Frame.gui.setBackgroundToBountyHunters();
				break;
			case "smugglers":
				scrollPane.getViewport().add(Operation.readQuery(Operation.SELECT_ALL_SMUGGLERS, con));
				Frame.gui.setBackgroundToSmugglers();
				break;
			case "battles":
				scrollPane.getViewport().add(Operation.readQuery(Operation.SELECT_ALL_BATTLES, con));
				Frame.gui.setBackgroundToBattles();
		}
	}


	public void setPanelToStart () {

		removeAll();
		revalidate();

		this.tablePanel.setSize(new Dimension(600, 350));
		this.tablePanel.setLocation(Frame.FRAME_WIDTH / 3, Frame.FRAME_HEIGHT / 2 - tablePanel.getHeight() / 2 - 50);
		this.tablePanel.setLayout(new BorderLayout());
		this.tablePanel.add(scrollPane, BorderLayout.CENTER);
		this.add(tablePanel);

		textTitle.setText("Luminous Beings");
		textTitle.setSize(600, 40);
		textTitle.setLocation(tablePanel.getX(), tablePanel.getY() - 60);
		textTitle.setFont(swFont);
		textTitle.setForeground(Color.yellow);
		this.add(textTitle);

		advancedButtons.setBackground(Color.green);
		advancedButtons.setBounds(tablePanel.getX() / 2 - 254 / 2, tablePanel.getY() + tablePanel.getHeight() / 2 - 100, 254, 200);
		advancedButtons.setLayout(new GridLayout(3, 0, 5, 20));
		advancedButtons.add(beingsButton);
		advancedButtons.add(modifiedSearchButton);
		advancedButtons.add(manipulateButton);
		this.add(advancedButtons);

		buttonsLabel.setBounds(tablePanel.getX(), tablePanel.getY() + tablePanel.getHeight() + 20, 600, 75);
		buttonsLabel.setLayout(new GridLayout(0, 2, 5, 5));
		buttonsLabel.add(jediButton);
		buttonsLabel.add(sithButton);
		buttonsLabel.add(bhButton);
		buttonsLabel.add(smugglersButton);
		buttonsLabel.add(battlesButton);
		buttonsLabel.add(planetsButton);
		this.add(buttonsLabel);

		repaint();
	}


	public void setPanelToCustomSearch () {
		removeAll();
		revalidate();
		goBackButton.setSize(100, 25);
		goBackButton.setLocation(15, 15);
		this.add(goBackButton);
		JLabel choiceQuestion = new JLabel("Choose search parameters:");

		repaint();
	}


	public void setPanelToJMAccess () {

		JPanel textFields = new JPanel();

		removeAll();
		revalidate();

		goBackButton.setSize(100, 25);
		goBackButton.setLocation(15, 15);
		this.add(goBackButton);

		textTitle.setText("update category:");
		textTitle.setLocation(this.getWidth() / 2 - textTitle.getWidth() / 2, tablePanel.getY());
		this.add(textTitle);
		
		textFields.setOpaque(false);
		textFields.setLayout(new GridLayout(3, 2, 15, 15));
		textFields.setSize(600, 200);
		textFields.setLocation(this.getWidth()/2 - textFields.getWidth()/2, this.getHeight()/2 - textFields.getHeight()/2);
		textFields.add(updateJediButton);
		textFields.add(updateSithButton);
		textFields.add(updateBountyHuntersButton);
		textFields.add(updateSmugglersButton);
		textFields.add(updateBattlesButton);
		textFields.add(updatePlanetsButton);
		this.add(textFields);

		repaint();
	}


	public void setBackgroundToRoot () throws IOException {
		bgImage = ImageIO.read(generalBG).getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
		repaint();
	}


	public void setBackgroundToJedi () throws IOException {
		bgImage = ImageIO.read(jediBG).getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
		repaint();
	}


	public void setBackgroundToSith () throws IOException {
		bgImage = ImageIO.read(sithBG).getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
		repaint();
	}


	public void setBackgroundToBountyHunters () throws IOException {
		bgImage = ImageIO.read(bountyHuntersBG).getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
		repaint();
	}


	public void setBackgroundToSmugglers () throws IOException {
		bgImage = ImageIO.read(smugglersBG).getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
		repaint();
	}


	public void setBackgroundToBattles () throws IOException {
		bgImage = ImageIO.read(battlesBG).getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
		repaint();
	}


	@Override
	protected void paintComponent (Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgImage, 0, 0, null);
	}
}
