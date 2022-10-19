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
					Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
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
					Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
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
					Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
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
					Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
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
					Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
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
					Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
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
					Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
					Frame.gui.setScrollPane("beings", connection);
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
				if ((e.getSource() == MainPanel.updateJediButton && MainPanel.panelCheck == MainPanel.PanelCheckEnum.JMA_MENU) 
					|| (e.getSource() == MainPanel.addDataButton && MainPanel.panelCheck == MainPanel.PanelCheckEnum.JMA_JEDI_EDIT || MainPanel.panelCheck == MainPanel.PanelCheckEnum.JMA_JEDI_REMOVE)) {
						try {
							System.out.println("ok");
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
				if (e.getSource() == MainPanel.confirmJediUpdateButton && MainPanel.panelCheck == MainPanel.PanelCheckEnum.JMA_JEDI_ADD) {
					try {
						Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
						Operation.insertData(Operation.OperationType.INSERT_INTO_JEDI_CALL, connection);
					} catch (Exception e1) {
						e1.printStackTrace();

					}

				} else if (e.getSource() == MainPanel.confirmJediUpdateButton && MainPanel.panelCheck == MainPanel.PanelCheckEnum.JMA_JEDI_EDIT) {
					try {
					Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
					Operation.editData(OperationType.EDIT_JEDI_CALL, connection, Frame.gui.savedOriginalArray);
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
				if (e.getSource() == MainPanel.editDataButton && MainPanel.panelCheck == PanelCheckEnum.JMA_JEDI_ADD || MainPanel.panelCheck == PanelCheckEnum.JMA_JEDI_REMOVE) {
					try {
						Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
						System.out.println("ok");
						Frame.gui.setPanelToJMEdit("jediEdit", connection);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}

			}

		};

	}
}
