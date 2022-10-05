package App;

import java.sql.*;
import javax.swing.JTable;


public class Operation {

	public static final String SELECT_ALL_BEINGS = "SELECT * FROM Beings ORDER BY beingID";
	public static final String SELECT_ALL_JEDI = "SELECT * FROM Jedi ORDER BY JediID";

	private static PreparedStatement ps;
	private static ResultSet rs;
	private static String[][] data;

	private static final String[] beingsColumns = { "ID", "Last Name", "First Name", "Birth Date", "Birtplace", "Death Date", "Deathplace", "Class" };
	private static final String[] jediColumns = { "ID", "Last Name", "Rank", "Specialization", "Saber Type", "Saber Color" };


	public static JTable readQuery (String query, Connection con) throws SQLException {

		JTable queryTable = null;

		switch (query) {
			case SELECT_ALL_BEINGS:

				ps = con.prepareStatement("SELECT COUNT(*) FROM Beings");
				rs = ps.executeQuery();
				if (rs.next()) {
					data = new String[rs.getInt(1)][8];
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
					i++;
				}
				queryTable = new JTable(data, beingsColumns);
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
		}

		return queryTable;
	}

}
