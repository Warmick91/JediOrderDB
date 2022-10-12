package appTools;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import App.Operation;


public class VisualPane extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static File generalBG = new File("src/images/Jedi_Archives.jpg");
	static File jediBG = new File("src/images/hyperspacejump.jpg");
	static File sithBG = new File("src/images/Korriban.jpg");
	static File bountyHuntersBG = new File("src/images/BountyHunters.jpg");
	static File smugglersBG = new File("src/images/milleniumFalcon.jpg");
	static File battlesBG = new File("src/images/sabersCrossed.jpg");
	public static Image bgImage;

	public static JScrollPane scrollPane = new JScrollPane();


	public VisualPane () {};


	public static void setScrollPane (String data, Connection connection) throws Exception {
		Connection con = connection;
		switch (data) {
			case "beings":
				scrollPane.getViewport().add(Operation.readQuery(Operation.SELECT_ALL_BEINGS, con));
				setPanelToRoot();
				break;
			case "jedi":
				scrollPane.getViewport().add(Operation.readQuery(Operation.SELECT_ALL_JEDI, con));
				setPanelToJedi();
				break;
			case "sith":
				scrollPane.getViewport().add(Operation.readQuery(Operation.SELECT_ALL_SITH, con));
				setPanelToSith();
				break;
			case "bountyHunters":
				scrollPane.getViewport().add(Operation.readQuery(Operation.SELECT_ALL_BOUNTYHUNTERS, con));
				setPanelToBountyHunters();
				break;
			case "smugglers":
				scrollPane.getViewport().add(Operation.readQuery(Operation.SELECT_ALL_SMUGGLERS, con));
				setPanelToSmugglers();
				break;
			case "battles":
				scrollPane.getViewport().add(Operation.readQuery(Operation.SELECT_ALL_BATTLES, con));
				setPanelToBattles();
		}
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


	@Override
	protected void paintComponent (Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgImage, 0, 0, null);
	}

}
