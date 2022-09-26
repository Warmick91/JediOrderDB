package GUI_JediDB;

import javax.swing.JFrame;
import javax.swing.JTable;


public class Frame extends JFrame {

	public final int FRAME_WIDTH = 1000;
	public final int FRAME_HEIGHT = 600;

	MenuBar mBar = new MenuBar();
	MainPanel mainPanel = new MainPanel(FRAME_WIDTH, FRAME_HEIGHT);
	

	public Frame () {
		super("Jedi Order's Data Archives");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setLocationRelativeTo(null);

		this.add(mainPanel);
		setJMenuBar(mBar);
		JTable table = new JTable();

		this.setVisible(true);
	}
}
