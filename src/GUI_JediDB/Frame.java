package GUI_JediDB;

import javax.swing.JFrame;


public class Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final int FRAME_WIDTH = 1000;
	public final int FRAME_HEIGHT = 600;

	MenuBar mBar = new MenuBar();
	MainPanel gui;


	public Frame () throws Exception {
		super("Jedi Order's Data Archives");
		gui = new MainPanel(FRAME_WIDTH, FRAME_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setLocationRelativeTo(null);

		this.add(gui);
		setJMenuBar(mBar);

		this.setVisible(true);
	}
}
