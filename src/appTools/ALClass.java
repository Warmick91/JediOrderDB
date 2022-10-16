package appTools;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JPanel;
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
				try {
					Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
					Operation.insertData(Operation.INSERT_INTO_JEDI, connection);
				} catch (Exception e1) {
					e1.printStackTrace();
					Frame.gui.confirmationLabel.setForeground(Color.red);
					Frame.gui.confirmationLabel.setText("input fields error");
				}				
				
			}
		};
	
		cancelAndEmptyListener = new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				Frame.gui.clearInputTable();				
			}
			
		};
	
	}
}





//	try {
//		Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
//	} catch (Exception e1) {
//		e1.printStackTrace();
//	}

//ELSE-IF OPTION -------------------------

//	@Override
//	public void actionPerformed (ActionEvent e) {
//
////		if (e.getSource() == MainPanel.beingsButton) {
////			try {
////				Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
////				MainPanel.textTitle.setText("Luminous Beings");
////				Frame.gui.setScrollPane("beings", connection);
////			} catch (Exception e1) {
////				e1.printStackTrace();
////			}
////			System.out.println("WE ARE ALL LUMINOUS BEINGS");
////		} else
//			
//			if (e.getSource() == MainPanel.jediButton) {
//			try {
//				Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
//				MainPanel.textTitle.setText("Jedi");
//				Frame.gui.setScrollPane("jedi", connection);
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//			System.out.println("JEDI RULE");
//
//		} else if (e.getSource() == MainPanel.sithButton) {
//			try {
//				Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
//				MainPanel.textTitle.setText("Sith");
//				Frame.gui.setScrollPane("sith", connection);
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//			System.out.println("SITH RULE");
//
//		} else if (e.getSource() == MainPanel.bhButton) {
//			try {
//				Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
//				MainPanel.textTitle.setText("Bounty Hunters");
//				Frame.gui.setScrollPane("bountyHunters", connection);
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//			System.out.println("BOUNTY HUNTERS RULE");
//
//		} else if (e.getSource() == MainPanel.smugglersButton) {
//			try {
//				Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
//				MainPanel.textTitle.setText("Smugglers");
//				Frame.gui.setScrollPane("smugglers", connection);
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//			System.out.println("SMUGGLERS RULE");
//
//		} else if (e.getSource() == MainPanel.battlesButton) {
//			try {
//				Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
//				MainPanel.textTitle.setText("Battles");
//				Frame.gui.setScrollPane("battles", connection);
//			} catch (Exception e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			System.out.println("STAR WARS BATTLES ARE AWESOME");
//
//		} else if (e.getSource() == MainPanel.modifiedSearchButton) {
//			Frame.gui.setPanelToCustomSearch();
//
//		} else if (e.getSource() == MainPanel.goBackButtonToMain) {
//			Frame.gui.setPanelToStart();
//
//		} else if (e.getSource() == MainPanel.manipulateButton || e.getSource() == MainPanel.goBackButtonToCategory) {
//			Frame.gui.setPanelToJMAccess();
//
//		} else if (e.getSource() == MainPanel.updateJediButton) {
//			Frame.gui.setPanelToJMTextFields("jedi");
//
//		} else if (e.getSource() == MainPanel.confirmButton) {
//			try {
//				Connection connection = ConnectionFactory.getConnection(ConnectionFactory.DatabaseType.MYSQL);
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//
//		} else if (e.getSource() == MainPanel.updateSithButton) {
//
//		} else if (e.getSource() == MainPanel.updateBountyHuntersButton) {
//
//		} else if (e.getSource() == MainPanel.updateSmugglersButton) {
//
//		} else if (e.getSource() == MainPanel.updateBattlesButton) {
//
//		} else if (e.getSource() == MainPanel.updatePlanetsButton) {
//
//		}
//
//	}
