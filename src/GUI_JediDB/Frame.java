package GUI_JediDB;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

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

	File cantinaBandFile = new File("Music/CantinaTheme.wav").getAbsoluteFile();
	AudioInputStream ass = AudioSystem.getAudioInputStream(cantinaBandFile);
	Clip clip = AudioSystem.getClip();
	
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
		
		clip.open(ass);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
}
