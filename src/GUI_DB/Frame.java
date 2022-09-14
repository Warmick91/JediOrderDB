package GUI_DB;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Frame extends JFrame {
	
	JMenuBar	mBar		= new JMenuBar	();
	JMenu		mFile		= new JMenu 	("Data");
	JMenuItem	cmdReload	= new JMenuItem	("Load");
	JMenuItem	cmdSearch	= new JMenuItem	("Find...");
	JMenuItem	cmdRegister	= new JMenuItem	("Register...");
	JMenuItem	cmdQuit		= new JMenuItem	("Quit");
	
	private	JPanel			topPanel;
	private	JScrollPane		scrollPane;
	private JTable			table;
	private String [][]		data;

	
	public Frame(){
		super("Jedi Order's Data Archives");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
			
		
		mFile.setMnemonic ('D');
		cmdReload.setMnemonic ('L');
		cmdSearch.setMnemonic ('S');
		cmdRegister.setMnemonic ('R');
		cmdQuit.setMnemonic ('Q');
		
		mBar.add(mFile);
		mFile.add(cmdReload);
		mFile.add(cmdSearch);
		mFile.add(cmdRegister);
		mFile.addSeparator();
		mFile.add(cmdQuit);
		setJMenuBar(mBar);		
		
		topPanel	= new JPanel ();
		scrollPane	= new JScrollPane ();
		
		topPanel.setBackground(Color.red);
		this.getContentPane().add (topPanel);
		topPanel.setLayout (new BorderLayout ());
		topPanel.add (scrollPane, BorderLayout.EAST);
		
		this.setVisible(true);	
	}
}
