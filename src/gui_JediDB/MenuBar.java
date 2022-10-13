package gui_JediDB;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenu mFile = new JMenu("Data");
    private JMenuItem cmdReload = new JMenuItem("Load");
    private JMenuItem cmdFind = new JMenuItem("Find...");
    private JMenuItem cmdRegister = new JMenuItem("Register...");
    private JMenuItem cmdQuit = new JMenuItem("Quit");

    MenuBar() {

	mFile = new JMenu("Data");
	cmdReload = new JMenuItem("Load");
	cmdFind = new JMenuItem("Find...");
	cmdRegister = new JMenuItem("Register...");
	cmdQuit = new JMenuItem("Quit");
	
	mFile.setMnemonic ('D');
	cmdReload.setMnemonic ('L');
	cmdFind.setMnemonic ('F');
	cmdRegister.setMnemonic ('R');
	cmdQuit.setMnemonic ('Q');
	
	this.add(mFile);
	mFile.add(cmdReload);
	mFile.add(cmdFind);
	mFile.add(cmdRegister);
	mFile.add(cmdQuit);

    }
}
