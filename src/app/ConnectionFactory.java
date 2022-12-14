package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {

	private static Connection con = null;

	static DatabaseType database = DatabaseType.MYSQL;
	
	
	public final static Connection getConnection () throws Exception {

		
		try {
			if (con != null) return con;

			else {

				con = newJdbcConnection(database);
				return con;

			}

		} catch (SQLException e) {
			throw new SQLException("Problem reaching the Jedi Archives...");
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


	static public enum DatabaseType {
		MYSQL, ORACLE_DB
	}

}