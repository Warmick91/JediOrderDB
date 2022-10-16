package GUI_JediDB;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static int FRAME_WIDTH = 1000;
	public final static int FRAME_HEIGHT = 600;

	MenuBar mBar = new MenuBar();
	ImageIcon lightsabersIcon = new ImageIcon("images/sabers.jpg");
	public static MainPanel gui;


	public Frame () throws Exception {
		super("Jedi Order's Data Archives");
		this.setIconImage(lightsabersIcon.getImage());
		gui = new MainPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setLocationRelativeTo(null);

		this.add(gui);
		setJMenuBar(mBar);

		this.setVisible(true);
	}
}
