package app;

import java.awt.Color;
import java.sql.*;
import javax.swing.JTable;
import GUI_JediDB.Frame;
import GUI_JediDB.MainPanel;
import GUI_JediDB.MainPanel.PanelCheckEnum;


public class Operation {

	public enum OperationType {
		SELECT_ALL_BEINGS, SELECT_ALL_JEDI, SELECT_ALL_JEDI_FOR_EDIT, SELECT_ALL_SITH, SELECT_ALL_BOUNTYHUNTERS, SELECT_ALL_SMUGGLERS, SELECT_ALL_BATTLES, SELECT_CUSTOM, INSERT_INTO_JEDI_CALL, EDIT_JEDI_CALL
	}


	public static final String SELECT_ALL_BEINGS = "SELECT * FROM Beings ORDER BY beingID";
	public static final String SELECT_ALL_JEDI = "SELECT * FROM Jedi ORDER BY JediID";
	public static final String SELECT_ALL_JEDI_FOR_EDIT = "SELECT j.JediID, b.LastName, b.firstName, b.species, b.birthdate, b.birthplace, b.deathdate, b.deathplace, j.jedirank, j.jedispecialization, j.sabertype, j.sabercolor FROM beings AS b, jedi AS j WHERE beingID = JediID ORDER BY beingID";

	public static final String SELECT_ALL_SITH = "SELECT * FROM Sith ORDER BY SithID";
	public static final String SELECT_ALL_BOUNTYHUNTERS = "SELECT * FROM BountyHunters ORDER BY HunterID";
	public static final String SELECT_ALL_SMUGGLERS = "SELECT * FROM Smugglers ORDER BY SmugglerID";
	public static final String SELECT_ALL_BATTLES = "SELECT * FROM Battles ORDER BY BattleID";
	public static final String SELECT_CUSTOM = "";

	public static final String INSERT_INTO_JEDI_CALL = "CALL insertIntoJediAndBeings (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String EDIT_JEDI_CALL = "CALL editJediAndBeings(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static PreparedStatement ps;
	private static CallableStatement cs;
	private static ResultSet rs;
	private static String[][] data;

	//Column names
	private static final String[] beingsColumns = { "ID", "Last Name", "First Name", "Birth Date", "Birtplace", "Death Date", "Deathplace", "Species", "Class" };
	private static final String[] jediColumns = { "ID", "Last Name", "Rank", "Specialization", "Saber Type", "Saber Color" };
	private static final String[] jediToEditColumns = { "ID", "Last Name", "First Name", "Species", "Birthdate", "Birthplace", "Deathdate", "Deathplace", "Rank", "Specialization", "Saber Type", "Saber Color" };
	private static final String[] sithColumns = { "ID", "Last Name", "Title at death", "Specialization", "Saber Type", "Saber Color" };
	private static final String[] bountyHuntersColumns = { "ID", "Last Name", "Organisation" };
	private static final String[] smugglersColumns = { "ID", "Last Name", "Organisation" };
	private static final String[] battlesColumns = { "ID", "Location", "Event Date", "Opponent A1", "Opponent A2", "Opponent B1", "Opponent B2", "Outcome" };

	static JTable queryTable = null;

	//counter
	private static int i;


	public static JTable readQuery (OperationType operationType, Connection con) throws SQLException {

		switch (operationType) {
			case SELECT_ALL_BEINGS:
				selectAllBeingsOperation(con);

				break;

			case SELECT_ALL_JEDI:
				selectAllJedi(con);

				break;

			case SELECT_ALL_JEDI_FOR_EDIT:
				selectAllJediForEdit(con);

				break;

			case SELECT_ALL_SITH:
				selectAllSith(con);

				break;

			case SELECT_ALL_BOUNTYHUNTERS:
				selectAllBountyHunters(con);

				break;

			case SELECT_ALL_SMUGGLERS:
				selectAllSmugglers(con);

				break;

			case SELECT_ALL_BATTLES:
				selectAllBattles(con);

				break;

			default:
				System.out.println("readQuery() didn't work. Default called.");
				break;

		}

		return queryTable;
	}


	public static void insertData (OperationType operationType, Connection con) throws SQLException {

		//Check how many rows were filled with data
		int filledRowsNumberCheck = 0;
		for (int i = 0; i < Frame.gui.inputTable.getRowCount(); i++) {
			if (Frame.gui.inputTable.getModel().getValueAt(i, 0) != null && Frame.gui.inputTable.getModel().getValueAt(i, 0) != "") {
				filledRowsNumberCheck++;
			}
		}

		if (filledRowsNumberCheck == 0) {
			Frame.gui.setNoDataErrorLabel();
			return;
		}

		int numberOfSuccessfulOperations = 0;
		con.setAutoCommit(false);
		switch (operationType) {
			case INSERT_INTO_JEDI_CALL:

				cs = con.prepareCall(INSERT_INTO_JEDI_CALL);

				for (int i = 0; i < filledRowsNumberCheck; i++) {
					if (Frame.gui.inputTable.getModel().getValueAt(i, 0) != null && Frame.gui.inputTable.getModel().getValueAt(i, 0) != "") {

						try {

							cs.setString(1, (String) (Frame.gui.inputTable.getModel().getValueAt(i, 0))); //LastName (Beings and Jedi)
							cs.setString(2, (String) (Frame.gui.inputTable.getModel().getValueAt(i, 1))); //FirstName
							cs.setString(3, (String) (Frame.gui.inputTable.getModel().getValueAt(i, 3))); //Birthday
							cs.setString(4, (String) (Frame.gui.inputTable.getModel().getValueAt(i, 4))); //Birthplace
							cs.setString(5, (String) (Frame.gui.inputTable.getModel().getValueAt(i, 5))); //Deathday
							cs.setString(6, (String) (Frame.gui.inputTable.getModel().getValueAt(i, 6))); //Deathplace
							cs.setString(7, (String) (Frame.gui.inputTable.getModel().getValueAt(i, 2))); //Species							

							cs.setString(8, (String) (Frame.gui.inputTable.getModel().getValueAt(i, 7))); //Rank
							cs.setString(9, (String) (Frame.gui.inputTable.getModel().getValueAt(i, 8))); //Specialization
							cs.setString(10, (String) (Frame.gui.inputTable.getModel().getValueAt(i, 9))); //Saber type
							cs.setString(11, (String) (Frame.gui.inputTable.getModel().getValueAt(i, 10))); //Saber color

							//cs.execute();
							cs.addBatch();

							numberOfSuccessfulOperations++;

						} catch (SQLException sqle) {
							Frame.gui.confirmationLabel.setForeground(Color.red);
							Frame.gui.confirmationLabel.setText("input error");
							sqle.printStackTrace();
							throw new SQLException("Something went wrong with adding to the batch");
						}
					}

				}

				if (numberOfSuccessfulOperations == filledRowsNumberCheck) {
					try {
						cs.executeBatch();
						con.commit();
						Frame.gui.confirmationLabel.setForeground(Color.yellow);
						Frame.gui.confirmationLabel.setText("New Jedi added");
					} catch (BatchUpdateException bue) {
						cs.clearBatch();
						con.rollback();
						Frame.gui.confirmationLabel.setForeground(Color.red);
						Frame.gui.confirmationLabel.setText("possible duplicates");
						throw new BatchUpdateException("Something went wrong with the batch execution", null);
					}

					break;

				}
			default:
				System.out.println("insertData() didn't work. Default called.");
				break;
		}

	}


	public static void editData (OperationType operationType, Connection con, String[][] origArray) throws SQLException {

		//new Array
		String[][] editedArray = new String[Frame.gui.savedOriginalArray.length][Frame.gui.savedOriginalArray[0].length];
		for (int i = 0; i < editedArray.length; i++) {
			for (int j = 0; j < editedArray[0].length; j++) {
				editedArray[i][j] = (String) Frame.gui.viewTable.getValueAt(i, j);
			}
		}

		switch (operationType) {
			case EDIT_JEDI_CALL:
				//Comparing two arrays and saving results to the bool table
				//If cells are different than the result is true		
				boolean[][] isCellDifferent = new boolean[Frame.gui.savedOriginalArray.length][Frame.gui.savedOriginalArray[0].length];
				for (int i = 0; i < isCellDifferent.length; i++) {
					for (int j = 0; j < isCellDifferent[0].length; j++) {
						if (editedArray[i][j] != Frame.gui.savedOriginalArray[i][j]) {
							isCellDifferent[i][j] = true;
						}
					}
				}

				//				for (int i = 0; i < isCellDifferent.length; i++) {
				//					for (int j = 0; j < isCellDifferent[0].length; j++) {
				//						System.out.println(isCellDifferent[i][j]);
				//					}
				//				}
				//				
				//				System.out.println(isCellDifferent.length * isCellDifferent[0].length);

				cs = con.prepareCall(EDIT_JEDI_CALL);

				break;

			default:
				System.out.println("editData() didn't work. Default called.");
				break;

		}

	}


	public static String[][] saveOriginalTable () {
		String[][] arrayOriginal = new String[Frame.gui.viewTable.getRowCount()][Frame.gui.viewTable.getColumnCount()];
		for (int i = 0; i < arrayOriginal.length; i++) {
			for (int j = 0; j < arrayOriginal[0].length; j++) {
				arrayOriginal[i][j] = (String) Frame.gui.viewTable.getValueAt(i, j);
			}
		}

		return arrayOriginal;
	}


	private static void selectAllBeingsOperation (Connection con) throws SQLException {
		ps = con.prepareStatement("SELECT COUNT(*) FROM Beings");
		rs = ps.executeQuery();
		if (rs.next()) {
			data = new String[rs.getInt(1)][9];
		}

		ps = con.prepareStatement(SELECT_ALL_BEINGS);
		rs = ps.executeQuery();

		i = 0;
		while (rs.next()) {
			data[i][0] = rs.getString(1);
			data[i][1] = rs.getString(2);
			data[i][2] = rs.getString(3);
			data[i][3] = rs.getString(4);
			data[i][4] = rs.getString(5);
			data[i][5] = rs.getString(6);
			data[i][6] = rs.getString(7);
			data[i][7] = rs.getString(8);
			data[i][8] = rs.getString(9);
			i++;
		}		
		
		System.out.println(MainPanel.getPanelCheck());
		switch (MainPanel.getPanelCheck()) {
			case JMA_MENU:
			case START_PANEL:
				queryTable = new JTable(data, beingsColumns) {
					public boolean editCellAt (int row, int column, java.util.EventObject e) {
						return false;
					}
				};

				break;

			case JMA_JEDI_EDIT:
				queryTable = new JTable(data, beingsColumns);

				break;

			default:
				System.out.println("No panel enum set");

		}

		queryTable.getColumnModel().getColumn(0).setPreferredWidth(20);
	}


	private static void selectAllJedi (Connection con) throws SQLException {

		ps = con.prepareStatement("SELECT COUNT(*) FROM Jedi");
		rs = ps.executeQuery();
		if (rs.next()) {
			data = new String[rs.getInt(1)][6];
		}

		ps = con.prepareStatement(SELECT_ALL_JEDI);
		rs = ps.executeQuery();
		i = 0;
		while (rs.next()) {
			data[i][0] = rs.getString(1);
			data[i][1] = rs.getString(2);
			data[i][2] = rs.getString(3);
			data[i][3] = rs.getString(4);
			data[i][4] = rs.getString(5);
			data[i][5] = rs.getString(6);
			i++;
		}

		queryTable = new JTable(data, jediColumns) {
			public boolean editCellAt (int row, int column, java.util.EventObject e) {
				return false;
			}
		};

		queryTable.getColumnModel().getColumn(0).setPreferredWidth(25);
	}


	private static void selectAllJediForEdit (Connection con) throws SQLException {
		ps = con.prepareStatement("SELECT COUNT(*) FROM Jedi");
		rs = ps.executeQuery();
		if (rs.next()) {
			data = new String[rs.getInt(1)][12];
		}

		ps = con.prepareStatement(SELECT_ALL_JEDI_FOR_EDIT);
		rs = ps.executeQuery();
		i = 0;
		while (rs.next()) {
			data[i][0] = rs.getString(1);
			data[i][1] = rs.getString(2);
			data[i][2] = rs.getString(3);
			data[i][3] = rs.getString(4);
			data[i][4] = rs.getString(5);
			data[i][5] = rs.getString(6);
			data[i][6] = rs.getString(7);
			data[i][7] = rs.getString(8);
			data[i][8] = rs.getString(9);
			data[i][9] = rs.getString(10);
			data[i][10] = rs.getString(11);
			data[i][11] = rs.getString(12);
			i++;
		}

		queryTable = new JTable(data, jediToEditColumns) {
			@Override
			public boolean isCellEditable (int row, int col) {
				if (col == 0) {
					return false;
				} else {
					return true;
				}
			}
		};

		queryTable.getColumnModel().getColumn(0).setPreferredWidth(25);
	}


	private static void selectAllSith (Connection con) throws SQLException {
		ps = con.prepareStatement("SELECT COUNT(*) FROM Sith");
		rs = ps.executeQuery();
		if (rs.next()) {
			data = new String[rs.getInt(1)][6];
		}

		ps = con.prepareStatement(SELECT_ALL_SITH);
		rs = ps.executeQuery();
		i = 0;
		while (rs.next()) {
			data[i][0] = rs.getString(1);
			data[i][1] = rs.getString(2);
			data[i][2] = rs.getString(3);
			data[i][3] = rs.getString(4);
			data[i][4] = rs.getString(5);
			data[i][5] = rs.getString(6);
			i++;
		}
		queryTable = new JTable(data, sithColumns) {
			public boolean editCellAt (int row, int column, java.util.EventObject e) {
				return false;
			}
		};
	}


	private static void selectAllBountyHunters (Connection con) throws SQLException {
		ps = con.prepareStatement("SELECT COUNT(*) FROM Bountyhunters");
		rs = ps.executeQuery();
		if (rs.next()) {
			data = new String[rs.getInt(1)][3];
		}

		ps = con.prepareStatement(SELECT_ALL_BOUNTYHUNTERS);
		rs = ps.executeQuery();
		i = 0;
		while (rs.next()) {
			data[i][0] = rs.getString(1);
			data[i][1] = rs.getString(2);
			data[i][2] = rs.getString(3);
			i++;
		}
		queryTable = new JTable(data, bountyHuntersColumns) {
			public boolean editCellAt (int row, int column, java.util.EventObject e) {
				return false;
			}
		};
	}


	private static void selectAllSmugglers (Connection con) throws SQLException {
		ps = con.prepareStatement("SELECT COUNT(*) FROM Smugglers");
		rs = ps.executeQuery();
		if (rs.next()) {
			data = new String[rs.getInt(1)][3];
		}

		ps = con.prepareStatement(SELECT_ALL_SMUGGLERS);
		rs = ps.executeQuery();
		i = 0;
		while (rs.next()) {
			data[i][0] = rs.getString(1);
			data[i][1] = rs.getString(2);
			data[i][2] = rs.getString(3);
			i++;
		}
		queryTable = new JTable(data, smugglersColumns) {
			public boolean editCellAt (int row, int column, java.util.EventObject e) {
				return false;
			}
		};
	}


	@SuppressWarnings("serial")
	private static void selectAllBattles (Connection con) throws SQLException {
		ps = con.prepareStatement("SELECT COUNT(*) FROM Battles");
		rs = ps.executeQuery();
		if (rs.next()) {
			data = new String[rs.getInt(1)][8];
		}

		ps = con.prepareStatement(SELECT_ALL_BATTLES);
		rs = ps.executeQuery();
		i = 0;
		while (rs.next()) {
			data[i][0] = rs.getString(1);
			data[i][1] = rs.getString(2);
			data[i][2] = rs.getString(3);
			data[i][3] = rs.getString(4);
			data[i][4] = rs.getString(5);
			data[i][5] = rs.getString(6);
			data[i][6] = rs.getString(7);
			data[i][7] = rs.getString(8);
			i++;
		}
		queryTable = new JTable(data, battlesColumns) {
			public boolean editCellAt (int row, int column, java.util.EventObject e) {
				return false;
			}
		};
	}

}
