package appTools;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import app.ConnectionFactory;
import app.Operation;
import GUI_JediDB.Frame;
import GUI_JediDB.MainPanel;


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
	public ActionListener toUpdateJediListener;
	public ActionListener confirmButtonListener;
	public ActionListener cancelAndEmptyListener;
	public ActionListener addDataListener;
	public ActionListener editDataListener;
	public ActionListener removeDataListener;


	public ALClass () {

		showAllBeingsListener = new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {

				try {
					Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
					Frame.gui.textTitle.setText("Luminous Beings");
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
					Frame.gui.textTitle.setText("Jedi");
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
					Frame.gui.textTitle.setText("Sith");
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
					Frame.gui.textTitle.setText("Bounty Hunters");
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
					Frame.gui.textTitle.setText("Smugglers");
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
					Frame.gui.textTitle.setText("Battles");
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

		toUpdateJediListener = new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				try {
					Frame.gui.setPanelToJMTextFieldsAdd("jedi");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		};

		confirmButtonListener = new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				if (e.getSource() == MainPanel.confirmJediUpdateButton) {
					try {
						Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
						Operation.insertData(Operation.INSERT_INTO_JEDI, connection);
					} catch (Exception e1) {
						e1.printStackTrace();

					}

				} else {
					System.out.println("No action defined");
				}
			}
		};

		cancelAndEmptyListener = new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				Frame.gui.clearInputTable();
			}

		};

		addDataListener = new ActionListener() {

			@Override
			public void actionPerformed (ActionEvent e) {
				if (e.getSource() == MainPanel.addDataButton && MainPanel.panelCheck == "JMAJedi") {
					try {
						System.out.println("ok");
						Frame.gui.setPanelToJMTextFieldsAdd("jedi");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}

			}

		};

		editDataListener = new ActionListener() {

			@Override
			public void actionPerformed (ActionEvent e) {
				if (e.getSource() == MainPanel.editDataButton && MainPanel.panelCheck == "JMAJedi") {
					try {
						System.out.println("ok");
						Frame.gui.setPanelToJMEdit("jedi");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}

			}

		};

	}
}
