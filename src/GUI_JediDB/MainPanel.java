package GUI_JediDB;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import appTools.ActionListenerClass;
import appTools.VisualPane;


@SuppressWarnings("serial")
public class MainPanel extends JPanel {

	private JPanel tablePanel = new JPanel();

	public static JLabel textTitle = new JLabel();



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


	public MainPanel (int width, int height) throws Exception {
		JButton[] buttons = { jediButton, sithButton, bhButton, smugglersButton, battlesButton, planetsButton, beingsButton };
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].addActionListener(new ActionListenerClass());
		}

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

		//this.tablePanel.setBackground(Color.blue);
		this.tablePanel.setSize(new Dimension(600, 350));
		this.tablePanel.setLocation(width / 2 - tablePanel.getWidth() / 2, height / 2 - tablePanel.getHeight() / 2 - 50);
		this.tablePanel.setLayout(new BorderLayout());
		//this.scrollPane.setOpaque(true);
		this.tablePanel.add(VisualPane.scrollPane, BorderLayout.CENTER);
		//scrollPane.getViewport().add(Operation.readQuery(Operation.SELECT_ALL_BEINGS, connection));
		this.add(tablePanel);

		textTitle = new JLabel("Root location", SwingConstants.CENTER);
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
	

}
