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
	public ActionListener toBackStartPanelListener;
	public ActionListener toJMAccessListener;
	public ActionListener toAddJediListener;
	public ActionListener toEditDataListener;
	public ActionListener toRemoveDataListener;
	public ActionListener addDataListener;
	public ActionListener confirmJediButtonListener;
	public ActionListener cancelOrEmptyListener;
	public ActionListener unselectAllFieldsListener;


	public ALClass () {

		showAllBeingsListener = new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {

				try {
					MainPanel.textTitle.setText("Luminous Beings");
					Frame.gui.setBackgroundTo("start");
					Frame.gui.setScrollPane("beings", ConnectionFactory.getConnection());
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
					MainPanel.textTitle.setText("Jedi");
					Frame.gui.setBackgroundTo("jedi");
					Frame.gui.setScrollPane("jedi", ConnectionFactory.getConnection());
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
					MainPanel.textTitle.setText("Sith");
					Frame.gui.setBackgroundTo("sith");
					Frame.gui.setScrollPane("sith", ConnectionFactory.getConnection());
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
					MainPanel.textTitle.setText("Bounty Hunters");
					Frame.gui.setBackgroundTo("bountyHunters");
					Frame.gui.setScrollPane("bountyHunters", ConnectionFactory.getConnection());
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
					MainPanel.textTitle.setText("Smugglers");
					Frame.gui.setBackgroundTo("smugglers");
					Frame.gui.setScrollPane("smugglers", ConnectionFactory.getConnection());
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
					MainPanel.textTitle.setText("Battles");
					Frame.gui.setBackgroundTo("battles");
					Frame.gui.setScrollPane("battles", ConnectionFactory.getConnection());
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
					System.out.println("BUTTON -> to ModifiedSearch(Custom Search)");
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
					System.out.println("BUTTON -> to JMA Menu");
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		};

		toAddJediListener = new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				if ((e.getSource() == MainPanel.updateJediButton && MainPanel.getPanelCheck() == MainPanel.PanelCheckEnum.JMA_MENU) || (e.getSource() == MainPanel.toAddDataButton && MainPanel.getPanelCheck() == MainPanel.PanelCheckEnum.JMA_JEDI_EDIT || MainPanel.getPanelCheck() == MainPanel.PanelCheckEnum.JMA_JEDI_REMOVE)) {
					try {
						Frame.gui.setPanelToJMAdd("jedi");
						System.out.println("BUTTON -> to JMA_ADD");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		};

		toEditDataListener = new ActionListener() {

			@Override
			public void actionPerformed (ActionEvent e) {
				if (e.getSource() == MainPanel.toEditDataButton && MainPanel.getPanelCheck() == PanelCheckEnum.JMA_JEDI_ADD || MainPanel.getPanelCheck() == PanelCheckEnum.JMA_JEDI_REMOVE) {
					try {
						Frame.gui.setPanelToJMEdit("jediEdit");
						System.out.println("BUTTON -> to JMA_EDIT");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}

			}

		};

		toRemoveDataListener = new ActionListener() {

			@Override
			public void actionPerformed (ActionEvent e) {
				if (e.getSource() == MainPanel.toRemoveDataButton && MainPanel.getPanelCheck() == PanelCheckEnum.JMA_JEDI_ADD || MainPanel.getPanelCheck() == PanelCheckEnum.JMA_JEDI_EDIT);
				try {
					Frame.gui.setPanelToJMRemove("jediRemove");
					System.out.println("BUTTON -> to JMA_REMOVE");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		};

		toBackStartPanelListener = new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				try {
					Frame.gui.setPanelToStart();
					System.out.println("BUTTON -> to StartPanel");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		};

		confirmJediButtonListener = new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				if (e.getSource() == MainPanel.confirmJediUpdateButton && MainPanel.getPanelCheck() == MainPanel.PanelCheckEnum.JMA_JEDI_ADD) {
					try {
						Operation.insertData(Operation.OperationType.INSERT_INTO_JEDI_CALL, ConnectionFactory.getConnection());
						System.out.println("JMA_CONFIRM/ADD_BUTTON button working");
					} catch (Exception e1) {
						e1.printStackTrace();

					}

				} else if (e.getSource() == MainPanel.confirmJediUpdateButton && MainPanel.getPanelCheck() == MainPanel.PanelCheckEnum.JMA_JEDI_EDIT) {
					try {
						Operation.editData(OperationType.EDIT_JEDI_CALL, ConnectionFactory.getConnection(), Frame.gui.savedOriginalArray);
						System.out.println("JMA_CONFIRM/EDIT_BUTTON working");
					} catch (Exception e1) {
						e1.printStackTrace();
					}

				} else if (e.getSource() == MainPanel.confirmJediUpdateButton && MainPanel.getPanelCheck() == MainPanel.PanelCheckEnum.JMA_JEDI_REMOVE) {
					try {
						Operation.removeData(Operation.OperationType.REMOVE_JEDI, ConnectionFactory.getConnection());
						System.out.println("JMA_CONFIRM/REMOVE_BUTTON working");
					} catch (Exception e1) {

						e1.printStackTrace();
					}

				}
			}
		};

		cancelOrEmptyListener = new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				if (e.getSource() == MainPanel.emptyFieldsButton && MainPanel.getPanelCheck() == PanelCheckEnum.JMA_JEDI_ADD) {
					try {
						Frame.gui.clearInputTable();
						System.out.println("JMA_REMOVE_ADDS_BUTTON working");
					} catch (Exception e1) {
						System.out.println("cancelOrEmptyListener AL failed ");
						e1.printStackTrace();
					}

				} else if (e.getSource() == MainPanel.cancelChangesButton && MainPanel.getPanelCheck() == PanelCheckEnum.JMA_JEDI_EDIT) {
					try {
						Frame.gui.removeChanges();
						System.out.println("JMA_UNDO_CHANGES_BUTTON working");
					} catch (Exception e1) {
						System.out.println("cancelOrEmptyListener AL failed");
						e1.printStackTrace();
					}

				}
			}
		};

		unselectAllFieldsListener = new ActionListener() {

			@Override
			public void actionPerformed (ActionEvent e) {
				if (e.getSource() == MainPanel.unselectAllFieldsButton && MainPanel.getPanelCheck() == PanelCheckEnum.JMA_JEDI_REMOVE) {
					Frame.gui.viewTable.clearSelection();
					System.out.println("UNSELECT_BUTTON working");
				}
			}

		};

	}
}
