package app;

import java.awt.Color;
import java.sql.*;
import javax.swing.JTable;
import GUI_JediDB.Frame;


public class Operation {

	public static final String SELECT_ALL_BEINGS = "SELECT * FROM Beings ORDER BY beingID";
	public static final String SELECT_ALL_JEDI = "SELECT * FROM Jedi ORDER BY JediID";
	public static final String SELECT_ALL_SITH = "SELECT * FROM Sith ORDER BY SithID";
	public static final String SELECT_ALL_BOUNTYHUNTERS = "SELECT * FROM BountyHunters ORDER BY HunterID";
	public static final String SELECT_ALL_SMUGGLERS = "SELECT * FROM Smugglers ORDER BY SmugglerID";
	public static final String SELECT_ALL_BATTLES = "SELECT * FROM Battles ORDER BY BattleID";
	public static final String SELECT_CUSTOM = "";

	//Check the DB for specific column names
	public static final String INSERT_INTO_BEINGS = "INSERT INTO Beings " 
												+ "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, 'Jedi')";
	public static final String INSERT_INTO_JEDI = "INSERT INTO Jedi " 
												+ "VALUES (NULL, ?, ?, ?, ?, ?)";

	private static PreparedStatement ps;
	private static ResultSet rs;
	private static String[][] data;

	private static final String[] beingsColumns = { "ID", "Last Name", "First Name", "Birth Date", "Birtplace", "Death Date", "Deathplace", "Species", "Class" };
	private static final String[] jediColumns = { "ID", "Last Name", "Rank", "Specialization", "Saber Type", "Saber Color" };
	private static final String[] sithColumns = { "ID", "Last Name", "Title at death", "Specialization", "Saber Type", "Saber Color" };
	private static final String[] bountyHuntersColumns = { "ID", "Last Name", "Organisation" };
	private static final String[] smugglersColumns = { "ID", "Last Name", "Organisation" };
	private static final String[] battlesColumns = { "ID", "Location", "Event Date", "Opponent A1", "Opponent A2", "Opponent B1", "Opponent B2", "Outcome" };

	static JTable queryTable = null;


	public static JTable readQuery (String query, Connection con) throws SQLException {

		switch (query) {
			case SELECT_ALL_BEINGS:

				ps = con.prepareStatement("SELECT COUNT(*) FROM Beings");
				rs = ps.executeQuery();
				if (rs.next()) {
					data = new String[rs.getInt(1)][9];
				}

				ps = con.prepareStatement(SELECT_ALL_BEINGS);
				rs = ps.executeQuery();

				int i = 0;
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
				queryTable = new JTable(data, beingsColumns);
				queryTable.getColumnModel().getColumn(0).setPreferredWidth(20);

				break;

			case SELECT_ALL_JEDI:

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
				queryTable = new JTable(data, jediColumns);
				break;

			case SELECT_ALL_SITH:
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
				queryTable = new JTable(data, sithColumns);
				break;

			case SELECT_ALL_BOUNTYHUNTERS:
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
				queryTable = new JTable(data, bountyHuntersColumns);
				break;

			case SELECT_ALL_SMUGGLERS:
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
				queryTable = new JTable(data, smugglersColumns);
				break;

			case SELECT_ALL_BATTLES:
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
				queryTable = new JTable(data, battlesColumns);
				break;
		}

		return queryTable;
	}


	public static void insertData (String query, Connection con) throws SQLException {
		
		//Check how many rows were filled with data
		int filledRowsNumberCheck = 0;
		for (int i = 0; i < Frame.gui.inputTable.getRowCount(); i++) {
			if (Frame.gui.inputTable.getModel().getValueAt(i, 0) != null && Frame.gui.inputTable.getModel().getValueAt(i, 0) != "") {
				filledRowsNumberCheck++;
			}
		}
		
		if(filledRowsNumberCheck == 0) {
			Frame.gui.setNoDataErrorLabel();
			return;
		}

		
		int numberOfSuccessfulOperations = 0;		
		con.setAutoCommit(false);
		switch (query) {
			case INSERT_INTO_JEDI:
			
				for (int i = 0; i < filledRowsNumberCheck; i++) {
					if (Frame.gui.inputTable.getModel().getValueAt(i, 0) != null && Frame.gui.inputTable.getModel().getValueAt(i, 0) != "") {

						try {
							//Add a being				
							ps = con.prepareStatement(INSERT_INTO_BEINGS);

							ps.setString(1, (String) (Frame.gui.inputTable.getModel().getValueAt(i, 0))); //LastName (Beings)
							ps.setString(2, (String) (Frame.gui.inputTable.getModel().getValueAt(i, 1))); //FirstName
							ps.setString(3, (String) (Frame.gui.inputTable.getModel().getValueAt(i, 3))); //Birthday
							ps.setString(4, (String) (Frame.gui.inputTable.getModel().getValueAt(i, 4))); //Birthplace
							ps.setString(5, (String) (Frame.gui.inputTable.getModel().getValueAt(i, 5))); //Deathday
							ps.setString(6, (String) (Frame.gui.inputTable.getModel().getValueAt(i, 6))); //Deathplace
							ps.setString(7, (String) (Frame.gui.inputTable.getModel().getValueAt(i, 2))); //Species

							ps.executeUpdate();

							//Add a Jedi
							ps = con.prepareStatement(INSERT_INTO_JEDI);

							ps.setString(1, (String) (Frame.gui.inputTable.getModel().getValueAt(i, 0))); //LastName (Jedi)
							ps.setString(2, (String) (Frame.gui.inputTable.getModel().getValueAt(i, 7))); //Rank
							ps.setString(3, (String) (Frame.gui.inputTable.getModel().getValueAt(i, 8))); //Specialization
							ps.setString(4, (String) (Frame.gui.inputTable.getModel().getValueAt(i, 9))); //Saber type
							ps.setString(5, (String) (Frame.gui.inputTable.getModel().getValueAt(i, 10))); //Saber color

							ps.executeUpdate();												
							
							numberOfSuccessfulOperations++;
							System.out.println("DONE");
						} catch (SQLException sqle) {
							throw new SQLException("Possible duplicate entries");
						}
					}
					
					if (numberOfSuccessfulOperations == filledRowsNumberCheck) {
						Frame.gui.confirmationLabel.setForeground(Color.yellow);
						Frame.gui.confirmationLabel.setText("New Jedi added");
						con.commit();
					} else {
						con.rollback();
					}
				}

				con.setAutoCommit(true);
				break;

		}
	}


}
