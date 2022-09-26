package App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {

	private static Connection con = null;


	public static Connection getConnection () throws Exception {

		try {
			if (con != null) return con;

			else {

				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jediarchives", "root", "root");
				return con;
			}

		} catch (SQLException e) {
			throw new SQLException("Problem reaching the Jedi Archives...");
		}
	}
}