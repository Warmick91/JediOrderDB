package appTools;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import app.ConnectionFactory;
import app.Operation;
import app.Operation.OperationType;
import GUI_JediDB.Frame;
import GUI_JediDB.MainPanel;
import GUI_JediDB.MainPanel.PanelCheckEnum;


public class ALClass {

	public ActionListener showAllBeingsListener;
	public ActionListener showAllJediListener;
	public ActionListener showAllSithListener;
	public ActionListener showAllBHListener;
	public ActionListener showAllSmugglersListener;
	public ActionListener showAllBattlesListener;

	public ActionListener toModifiedSearchListener;
	public ActionListener backToStartPanelListener;
	public ActionListener toJMAccessListener;
	public ActionListener toAddJediListener;
	public ActionListener confirmButtonListener;
	public ActionListener cancelOrEmptyListener;
	public ActionListener addDataListener;
	public ActionListener toEditDataListener;
	public ActionListener removeDataListener;


	public ALClass () {

		showAllBeingsListener = new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {

				try {
					Connection connection = ConnectionFactory.getConnection();
					MainPanel.textTitle.setText("Luminous Beings");
					Frame.gui.setBackgroundTo("root");
					Frame.gui.setScrollPane("beings", connection);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				System.out.println("WE ARE ALL LUMINOUS BEINGS");

			}
		};

		showAllJediListener = new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				try {
					Connection connection = ConnectionFactory.getConnection();
					MainPanel.textTitle.setText("Jedi");
					Frame.gui.setBackgroundTo("jedi");
					Frame.gui.setScrollPane("jedi", connection);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				System.out.println("JEDI RULE");
			}
		};

		showAllSithListener = new ActionListener() {

			@Override
			public void actionPerformed (ActionEvent e) {
				try {
					Connection connection = ConnectionFactory.getConnection();
					MainPanel.textTitle.setText("Sith");
					Frame.gui.setBackgroundTo("sith");
					Frame.gui.setScrollPane("sith", connection);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				System.out.println("SITH RULE");

			}

		};

		showAllBHListener = new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				try {
					Connection connection = ConnectionFactory.getConnection();
					MainPanel.textTitle.setText("Bounty Hunters");
					Frame.gui.setBackgroundTo("bountyHunters");
					Frame.gui.setScrollPane("bountyHunters", connection);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				System.out.println("BOUNTY HUNTERS RULES");

			}
		};

		showAllSmugglersListener = new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				try {
					Connection connection = ConnectionFactory.getConnection();
					MainPanel.textTitle.setText("Smugglers");
					Frame.gui.setBackgroundTo("smugglers");
					Frame.gui.setScrollPane("smugglers", connection);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				System.out.println("SMUGGLERS RULE");
			}
		};

		showAllBattlesListener = new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				try {
					Connection connection = ConnectionFactory.getConnection();
					MainPanel.textTitle.setText("Battles");
					Frame.gui.setBackgroundTo("battles");
					Frame.gui.setScrollPane("battles", connection);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				System.out.println("STAR WARS BATTLES ARE AWESOME");

			}
		};

		toModifiedSearchListener = new ActionListener() {

			@Override
			public void actionPerformed (ActionEvent e) {
				try {
					Frame.gui.setPanelToCustomSearch();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		};

		backToStartPanelListener = new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				try {		
					Frame.gui.setPanelToStart();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		};

		toJMAccessListener = new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				try {
					Frame.gui.setPanelToJMAccess();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		};

		toAddJediListener = new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				if ((e.getSource() == MainPanel.updateJediButton && MainPanel.getPanelCheck() == MainPanel.PanelCheckEnum.JMA_MENU) 
					|| (e.getSource() == MainPanel.addDataButton && MainPanel.getPanelCheck() == MainPanel.PanelCheckEnum.JMA_JEDI_EDIT || MainPanel.getPanelCheck() == MainPanel.PanelCheckEnum.JMA_JEDI_REMOVE)) {
						try {
							Frame.gui.setPanelToJMAdd("jedi");
						} catch (Exception e1) {
							e1.printStackTrace();
						}
				}
			}
		};

		confirmButtonListener = new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				if (e.getSource() == MainPanel.confirmJediUpdateButton && MainPanel.getPanelCheck() == MainPanel.PanelCheckEnum.JMA_JEDI_ADD) {
					try {
						Connection connection = ConnectionFactory.getConnection();
						Operation.insertData(Operation.OperationType.INSERT_INTO_JEDI_CALL, connection);
					} catch (Exception e1) {
						e1.printStackTrace();

					}

				} else if (e.getSource() == MainPanel.confirmJediUpdateButton && MainPanel.getPanelCheck() == MainPanel.PanelCheckEnum.JMA_JEDI_EDIT) {
					try {
					Operation.editData(OperationType.EDIT_JEDI_CALL, ConnectionFactory.getConnection(), Frame.gui.savedOriginalArray);
					System.out.println("JMA_JEDI_EDIT button working");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		};

		cancelOrEmptyListener = new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				Frame.gui.clearInputTable();
			}

		};

		toEditDataListener = new ActionListener() {

			@Override
			public void actionPerformed (ActionEvent e) {
				if (e.getSource() == MainPanel.editDataButton && MainPanel.getPanelCheck() == PanelCheckEnum.JMA_JEDI_ADD || MainPanel.getPanelCheck() == PanelCheckEnum.JMA_JEDI_REMOVE) {
					try {
						Connection connection = ConnectionFactory.getConnection();
						Frame.gui.setPanelToJMEdit("jediEdit");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}

			}

		};

	}
}
