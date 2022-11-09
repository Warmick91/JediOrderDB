package app;

import java.awt.Color;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import GUI_JediDB.Frame;
import GUI_JediDB.MainPanel;
import GUI_JediDB.MainPanel.PanelCheckEnum;


public class Operation {

	public enum OperationType {
		SELECT_ALL_BEINGS, SELECT_ALL_JEDI, SELECT_ALL_JEDI_FOR_EDIT, SELECT_ALL_SITH, SELECT_ALL_SITH_FOR_EDIT, SELECT_ALL_BOUNTYHUNTERS, SELECT_ALL_SMUGGLERS, SELECT_ALL_BATTLES, SELECT_ALL_PLANETS, SELECT_CUSTOM, INSERT_INTO_JEDI_CALL, EDIT_JEDI_CALL, EDIT_SITH_CALL, REMOVE_JEDI, INSERT_INTO_SITH_CALL, REMOVE_SITH
	}


	public static final String SELECT_ALL_BEINGS = "SELECT * FROM Beings ORDER BY beingID";

	public static final String SELECT_ALL_JEDI = "SELECT j.jediid, b.lastname, j.jedirank, j.jedispecialization, j.sabertype, j.sabercolor FROM jedi AS j, beings AS b WHERE b.beingclass = 'jedi' AND j.beingRefID = b.beingid ORDER BY JediID";
	public static final String SELECT_ALL_JEDI_FOR_EDIT = "SELECT j.JediID, b.LastName, b.firstName, b.species, b.birthdate, b.birthplace, b.deathdate, b.deathplace, j.jedirank, j.jedispecialization, j.sabertype, j.sabercolor, j.beingRefId FROM beings AS b, jedi AS j WHERE b.beingID = j.beingRefID ORDER BY beingID";
	public static final String SELECT_ALL_SITH = "SELECT s.sithid, b.lastname, s.titleatdeath, s.sithspecialization, s.sabertype, s.sabercolor FROM sith as s, beings as b WHERE b.beingclass = 'sith' AND s.beingRefID = b.beingid ORDER BY SithID";
	public static final String SELECT_ALL_SITH_FOR_EDIT = "SELECT s.SithID, b.LastName, b.firstName, b.species, b.birthdate, b.birthplace, b.deathdate, b.deathplace, s.titleAtDeath, s.sithspecialization, s.sabertype, s.sabercolor, s.beingRefId FROM beings AS b, sith AS s WHERE b.beingID = s.beingRefID ORDER BY beingID";
	public static final String SELECT_ALL_BOUNTYHUNTERS = "SELECT * FROM BountyHunters ORDER BY HunterID";
	public static final String SELECT_ALL_SMUGGLERS = "SELECT * FROM Smugglers ORDER BY SmugglerID";
	public static final String SELECT_ALL_BATTLES = "SELECT * FROM Battles ORDER BY BattleID";
	public static final String SELECT_ALL_PLANETS = "SELECT * FROM Planets ORDER BY planetID";
	public static final String SELECT_CUSTOM = "";

	public static final String INSERT_INTO_JEDI_CALL = "CALL insertIntoJediAndBeings (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String INSERT_INTO_SITH_CALL = "CALL insertIntoSithAndBeings (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String EDIT_JEDI_CALL = "CALL editJediAndBeings(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String EDIT_SITH_CALL = "CALL editSithAndBeings(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String DELETE_BEINGS = "DELETE FROM Beings WHERE beingID = ?";

	private static PreparedStatement ps;
	private static CallableStatement cs;
	private static ResultSet rs;
	private static String[][] data;

	//Column names
	private static final String[] beingsColumns = { "ID", "Last Name", "First Name", "Birth Date", "Birtplace", "Death Date", "Deathplace", "Species", "Class" };
	private static final String[] jediColumns = { "ID", "Last Name", "Rank", "Specialization", "Saber Type", "Saber Color" };
	private static final String[] jediToEditColumns = { "ID", "Last name", "First name", "Species", "Birthdate", "Birthplace", "Death date", "Deathplace", "Rank", "Specialization", "Saber type", "Saber color", "beingRefID" };
	private static final String[] sithColumns = { "ID", "Last Name", "Title at death", "Specialization", "Saber Type", "Saber Color" };
	private static final String[] sithToEditColumns = { "ID", "Last Name", "First name", "Species", "Birthdate", "Birthplace", "Death date", "Deathplace", "Title at Death", "Specialitation", "Saber type", "Saber color", "beingRedIF" };
	private static final String[] bountyHuntersColumns = { "ID", "Last Name", "Organisation" };
	private static final String[] smugglersColumns = { "ID", "Last Name", "Organisation" };
	private static final String[] battlesColumns = { "ID", "Location", "Event Date", "Opponent A1", "Opponent A2", "Opponent B1", "Opponent B2", "Outcome" };
	private static final String[] planetsColumns = {"ID", "Name", "Region", "Sector", "Suns", "Diameter", "Atmosphere", "Climate", "Native species"};
	
	private static JTable queryTable = null;

	//counter
	private static int i;
	private static int numberOfSuccessfulOperations = 0;


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

			case SELECT_ALL_SITH_FOR_EDIT:
				selectAllSithForEdit(con);

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
			
			case SELECT_ALL_PLANETS:
				selectAllPlanets(con);
				
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
			if (Frame.gui.inputTable.getModel().getValueAt(i, 0) != null && Frame.gui.inputTable.getModel().getValueAt(i, 0) != "" && Frame.gui.inputTable.getModel().getValueAt(i, 0).toString().trim().length() != 0) {
				filledRowsNumberCheck++;
			}
		}

		if (filledRowsNumberCheck == 0) {
			Frame.gui.setNoDataErrorLabel();
			return;
		}

		numberOfSuccessfulOperations = 0;
		con.setAutoCommit(false);

		switch (operationType) {
			case INSERT_INTO_JEDI_CALL:

				cs = con.prepareCall(INSERT_INTO_JEDI_CALL);

				for (int i = 0; i < filledRowsNumberCheck; i++) {
					if (Frame.gui.inputTable.getModel().getValueAt(i, 0) != null && Frame.gui.inputTable.getModel().getValueAt(i, 0) != "" && Frame.gui.inputTable.getModel().getValueAt(i, 0).toString().trim().length() != 0) {

						try {

							cs.setString(1, (String) (Frame.gui.inputTable.getModel().getValueAt(i, 0))); //LastName
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

							cs.addBatch();

							numberOfSuccessfulOperations++;

						} catch (SQLException sqle) {
							Frame.gui.confirmationLabel.setForeground(Color.red);
							Frame.gui.confirmationLabel.setText("input error");
							System.out.println("Something went wrong while adding to the insert batch");
							sqle.printStackTrace();
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
						Frame.gui.confirmationLabel.setText("Duplicates/error");
						throw new BatchUpdateException("Something went wrong with the batch execution", null);
					}

				}

				break;

			case INSERT_INTO_SITH_CALL:

				cs = con.prepareCall(INSERT_INTO_SITH_CALL);

				for (int i = 0; i < filledRowsNumberCheck; i++) {
					if (Frame.gui.inputTable.getModel().getValueAt(i, 0) != null && Frame.gui.inputTable.getModel().getValueAt(i, 0) != "" && Frame.gui.inputTable.getModel().getValueAt(i, 0).toString().trim().length() != 0) {

						try {

							cs.setString(1, (String) (Frame.gui.inputTable.getModel().getValueAt(i, 0))); //LastName
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

							cs.addBatch();

							numberOfSuccessfulOperations++;

						} catch (SQLException sqle) {
							Frame.gui.confirmationLabel.setForeground(Color.red);
							Frame.gui.confirmationLabel.setText("input error");
							System.out.println("Something went wrong while adding to the insert batch");
							sqle.printStackTrace();
						}
					}

				}

				if (numberOfSuccessfulOperations == filledRowsNumberCheck) {
					try {
						cs.executeBatch();
						con.commit();
						Frame.gui.confirmationLabel.setForeground(Color.yellow);
						Frame.gui.confirmationLabel.setText("New Sith added");
					} catch (BatchUpdateException bue) {
						cs.clearBatch();
						con.rollback();
						Frame.gui.confirmationLabel.setForeground(Color.red);
						Frame.gui.confirmationLabel.setText("Duplicates/error");
						throw new BatchUpdateException("Something went wrong with the batch execution", null);
					}

				}

				break;

			default:
				System.out.println("insertData() didn't work. Default called.");
				break;
		}

	}


	public static void editData (OperationType operationType, Connection con, String[][] origArray) throws SQLException {

		
		//The original, unedited array (table) gets saved at the end of the setPanelToJMEdit(String s) method

		//new, edited array (table)
		String[][] editedArray = new String[Frame.gui.savedOriginalArray.length][Frame.gui.savedOriginalArray[0].length];
		for (int i = 0; i < editedArray.length; i++) {
			for (int j = 0; j < editedArray[0].length; j++) {
				editedArray[i][j] = (String) Frame.gui.viewTable.getValueAt(i, j);
			}
		}

		//Comparing two arrays and saving results to the bool table
		//If cells differ, the result is true
		int checkInt = 0;
		boolean[][] isCellDifferent = new boolean[Frame.gui.savedOriginalArray.length][Frame.gui.savedOriginalArray[0].length];
		for (int i = 0; i < isCellDifferent.length; i++) {
			for (int j = 0; j < isCellDifferent[0].length; j++) {
				if (editedArray[i][j] != Frame.gui.savedOriginalArray[i][j]) {
					isCellDifferent[i][j] = true;
					checkInt = 1;
				}
			}
		}

		//If no changes were made in reference to the original table, quit the method
		if (checkInt != 1) {
			Frame.gui.confirmationLabel.setForeground(Color.red);
			Frame.gui.confirmationLabel.setText("No changed data");
			return;
		}

		numberOfSuccessfulOperations = 0;

		switch (operationType) {
			case EDIT_JEDI_CALL:

				con.setAutoCommit(false);
				cs = con.prepareCall(EDIT_JEDI_CALL);

				for (int i = 0; i < Frame.gui.viewTable.getRowCount(); i++) {

					try {
						cs.setInt(1, Integer.parseInt((String) Frame.gui.viewTable.getModel().getValueAt(i, 12))); //ID
						cs.setString(2, (String) Frame.gui.viewTable.getModel().getValueAt(i, 1));  //Last Name
						cs.setString(3, (String) Frame.gui.viewTable.getModel().getValueAt(i, 2));  //First Name
						cs.setString(4, (String) Frame.gui.viewTable.getModel().getValueAt(i, 4));  //Birthdate
						cs.setString(5, (String) Frame.gui.viewTable.getModel().getValueAt(i, 5));  //Birthplace
						cs.setString(6, (String) Frame.gui.viewTable.getModel().getValueAt(i, 6)); 	//Deathdate
						cs.setString(7, (String) Frame.gui.viewTable.getModel().getValueAt(i, 7)); 	//Deathplace
						cs.setString(8, (String) Frame.gui.viewTable.getModel().getValueAt(i, 3));	//Species
						cs.setString(9, (String) Frame.gui.viewTable.getModel().getValueAt(i, 8)); 	//Rank
						cs.setString(10, (String) Frame.gui.viewTable.getModel().getValueAt(i, 9)); //Specialization
						cs.setString(11, (String) Frame.gui.viewTable.getModel().getValueAt(i, 10));//Saber Type
						cs.setString(12, (String) Frame.gui.viewTable.getModel().getValueAt(i, 11));//Saber Color

						cs.addBatch();

						numberOfSuccessfulOperations++;

					} catch (SQLException sqle) {
						Frame.gui.confirmationLabel.setForeground(Color.red);
						Frame.gui.confirmationLabel.setText("Edit error");
						System.out.println("Something went wrong with adding to the edit batch");
						sqle.printStackTrace();
					}
				}

				if (numberOfSuccessfulOperations == Frame.gui.viewTable.getRowCount()) {
					try {
						cs.executeBatch();
						con.commit();
						Frame.gui.confirmationLabel.setForeground(Color.yellow);
						Frame.gui.confirmationLabel.setText("Jedi info updated");
					} catch (BatchUpdateException bue) {
						cs.clearBatch();
						con.rollback();
						Frame.gui.confirmationLabel.setForeground(Color.red);
						Frame.gui.confirmationLabel.setText("Possible wrong inputs");
						System.out.println("Something went wrong with the batch execution");
						bue.printStackTrace();
					}

				}

				break;

			case EDIT_SITH_CALL:

				con.setAutoCommit(false);
				cs = con.prepareCall(EDIT_SITH_CALL);

				for (int i = 0; i < Frame.gui.viewTable.getRowCount(); i++) {

					try {
						cs.setInt(1, Integer.parseInt((String) Frame.gui.viewTable.getModel().getValueAt(i, 12))); //ID
						cs.setString(2, (String) Frame.gui.viewTable.getModel().getValueAt(i, 1));  //Last Name
						cs.setString(3, (String) Frame.gui.viewTable.getModel().getValueAt(i, 2));  //First Name
						cs.setString(4, (String) Frame.gui.viewTable.getModel().getValueAt(i, 4));  //Birthdate
						cs.setString(5, (String) Frame.gui.viewTable.getModel().getValueAt(i, 5));  //Birthplace
						cs.setString(6, (String) Frame.gui.viewTable.getModel().getValueAt(i, 6)); 	//Deathdate
						cs.setString(7, (String) Frame.gui.viewTable.getModel().getValueAt(i, 7)); 	//Deathplace
						cs.setString(8, (String) Frame.gui.viewTable.getModel().getValueAt(i, 3));	//Species
						cs.setString(9, (String) Frame.gui.viewTable.getModel().getValueAt(i, 8)); 	//Title
						cs.setString(10, (String) Frame.gui.viewTable.getModel().getValueAt(i, 9)); //Specialization
						cs.setString(11, (String) Frame.gui.viewTable.getModel().getValueAt(i, 10));//Saber Type
						cs.setString(12, (String) Frame.gui.viewTable.getModel().getValueAt(i, 11));//Saber Color

						cs.addBatch();

						numberOfSuccessfulOperations++;

					} catch (SQLException sqle) {
						Frame.gui.confirmationLabel.setForeground(Color.red);
						Frame.gui.confirmationLabel.setText("Edit error");
						System.out.println("Something went wrong with adding to the edit batch");
						sqle.printStackTrace();
					}
				}
				
				
				if (numberOfSuccessfulOperations == Frame.gui.viewTable.getRowCount()) {
					try {
						cs.executeBatch();
						con.commit();
						Frame.gui.confirmationLabel.setForeground(Color.yellow);
						Frame.gui.confirmationLabel.setText("Sith info updated");
					} catch (BatchUpdateException bue) {
						cs.clearBatch();
						con.rollback();
						Frame.gui.confirmationLabel.setForeground(Color.red);
						Frame.gui.confirmationLabel.setText("Possible wrong inputs");
						System.out.println("Something went wrong with the batch execution");
						bue.printStackTrace();
					}

				}

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


	public static void removeData (OperationType operationType, Connection con) throws SQLException {

		int[] selectedRows = Frame.gui.viewTable.getSelectedRows();

		if (selectedRows.length == 0) {
			Frame.gui.confirmationLabel.setForeground(Color.red);
			Frame.gui.confirmationLabel.setText("no rows selected");
			return;
		}

		int answer = JOptionPane.showConfirmDialog(null, "Are you certain you wish to proceed, Master Jedi?", "The Force is asking:", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, MainPanel.orderIcon);

		if (answer == 1) {
			Frame.gui.confirmationLabel.setForeground(Color.yellow);
			Frame.gui.confirmationLabel.setText("Remove cancelled");
			return;
		}

		numberOfSuccessfulOperations = 0;

		switch (operationType) {
			case REMOVE_JEDI:

				con.setAutoCommit(false);
				ps = con.prepareStatement(DELETE_BEINGS);

				for (int i = 0; i < selectedRows.length; i++) {
					ps.setInt(1, Integer.parseInt((String) Frame.gui.viewTable.getModel().getValueAt(selectedRows[i], 12)));
					ps.addBatch();
					numberOfSuccessfulOperations++;
				}

				if (selectedRows.length == numberOfSuccessfulOperations) {
					try {
						ps.executeBatch();
						con.commit();
						Frame.gui.viewTable.getModel();
						Frame.gui.confirmationLabel.setForeground(Color.yellow);
						Frame.gui.confirmationLabel.setText("Jedi deleted");
					} catch (BatchUpdateException bue) {
						ps.clearBatch();
						con.rollback();
						bue.printStackTrace();
					}
				} else {
					Frame.gui.confirmationLabel.setForeground(Color.red);
					Frame.gui.confirmationLabel.setText("Remove failed");
					throw new SQLException("Problem adding to the remove batch");
				}

				break;

			case REMOVE_SITH:

				con.setAutoCommit(false);
				ps = con.prepareStatement(DELETE_BEINGS);

				for (int i = 0; i < selectedRows.length; i++) {
					ps.setInt(1, Integer.parseInt((String) Frame.gui.viewTable.getModel().getValueAt(selectedRows[i], 12)));
					ps.addBatch();
					numberOfSuccessfulOperations++;
				}

				if (selectedRows.length == numberOfSuccessfulOperations) {
					try {
						ps.executeBatch();
						con.commit();
						Frame.gui.viewTable.getModel();
						Frame.gui.confirmationLabel.setForeground(Color.yellow);
						Frame.gui.confirmationLabel.setText("Sith deleted");
					} catch (BatchUpdateException bue) {
						ps.clearBatch();
						con.rollback();
						bue.printStackTrace();
					}
				} else {
					Frame.gui.confirmationLabel.setForeground(Color.red);
					Frame.gui.confirmationLabel.setText("Remove failed");
					throw new SQLException("Problem adding to the remove batch");
				}

				break;

			default:
				System.out.println("No OperationType in Operation.removeData()");
		}

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
			data = new String[rs.getInt(1)][13];
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
			data[i][12] = rs.getString(13); // beingRefID
			i++;
		}

		if (MainPanel.getPanelCheck() == PanelCheckEnum.JMA_JEDI_EDIT) {
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
		} else if (MainPanel.getPanelCheck() == PanelCheckEnum.JMA_JEDI_REMOVE) {
			queryTable = new JTable(data, jediToEditColumns) {
				public boolean editCellAt (int row, int column, java.util.EventObject e) {
					return false;
				}
			};
		}

		queryTable.removeColumn(queryTable.getColumnModel().getColumn(12)); // removes ONLY the display of the beingRefID column
		//queryTable.getColumnModel().getColumn(0).setPreferredWidth(25);
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


	private static void selectAllSithForEdit (Connection con) throws SQLException {
		ps = con.prepareStatement("SELECT COUNT(*) FROM Sith");
		rs = ps.executeQuery();
		if (rs.next()) {
			data = new String[rs.getInt(1)][13];
		}

		ps = con.prepareStatement(SELECT_ALL_SITH_FOR_EDIT);
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
			data[i][12] = rs.getString(13); // beingRefID
			i++;
		}

		if (MainPanel.getPanelCheck() == PanelCheckEnum.JMA_SITH_EDIT) {
			queryTable = new JTable(data, sithToEditColumns) {
				@Override
				public boolean isCellEditable (int row, int col) {
					if (col == 0) {
						return false;
					} else {
						return true;
					}
				}
			};
		} else if (MainPanel.getPanelCheck() == PanelCheckEnum.JMA_SITH_REMOVE) {
			queryTable = new JTable(data, sithToEditColumns) {
				public boolean editCellAt (int row, int column, java.util.EventObject e) {
					return false;
				}
			};
		}

		queryTable.removeColumn(queryTable.getColumnModel().getColumn(12)); // removes ONLY the display of the beingRefID column
		//queryTable.getColumnModel().getColumn(0).setPreferredWidth(25);
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
		
		queryTable.getColumnModel().getColumn(0).setPreferredWidth(25);
	}

	
	private static void selectAllPlanets (Connection con) throws SQLException {
		ps = con.prepareStatement("SELECT COUNT(*) FROM Planets");
		rs = ps.executeQuery();
		if (rs.next()) {
			data = new String[rs.getInt(1)][9];
		}
		
		ps = con.prepareStatement(SELECT_ALL_PLANETS);
		rs = ps.executeQuery();
		i = 0;
		while (rs.next()) {
			data[i][0] = Integer.toString(rs.getInt(1));
			data[i][1] = rs.getString(2);
			data[i][2] = rs.getString(3);
			data[i][3] = rs.getString(4);
			data[i][4] = Integer.toString(rs.getInt(5));
			data[i][5] = Integer.toString(rs.getInt(6));
			data[i][6] = rs.getString(7);
			data[i][7] = rs.getString(8);
			data[i][8] = rs.getString(9);
			i++;
		}
		
		queryTable = new JTable(data, planetsColumns) {
			public boolean editCellAt (int row, int column, java.util.EventObject e) {
				return false;
			}		
		};
		
		queryTable.getColumnModel().getColumn(0).setPreferredWidth(25);
		queryTable.getColumnModel().getColumn(4).setPreferredWidth(25);
	}
}
