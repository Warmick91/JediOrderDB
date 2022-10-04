package App;

import java.sql.*;

import GUI_JediDB.Frame;


public class JediOrderDB {
	static private enum DatabaseType {
		MYSQL, ORACLE_DB
	}


	private static final String SELECT_ALL_BEINGS = "SELECT * FROM Beings ORDER BY beingID";
	private static final String SELECT_ALL_JEDI = "SELECT * FROM Jedi ORDER BY JediID";


	public static void main (String[] args) throws SQLException {

		Frame frame = new Frame();

		try (Connection connection = newJdbcConnection(DatabaseType.MYSQL)) {
			System.out.println("Connected: " + connection.getMetaData().getDatabaseProductName());

			try (PreparedStatement sql = connection.prepareStatement(SELECT_ALL_JEDI)) {
				try (ResultSet rs = sql.executeQuery()) {

				}
			}
		}
	}


	static private Connection newJdbcConnection (final DatabaseType type) throws NullPointerException, SQLException {
		switch (type) {
			case MYSQL:
				return DriverManager.getConnection("jdbc:mysql://localhost:3306/jediarchives", "root", "root");
			case ORACLE_DB:
				return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "root");
			default:
				throw new AssertionError();
		}
	}

}
