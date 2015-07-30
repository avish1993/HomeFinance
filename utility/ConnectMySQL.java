package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectMySQL {

	public static Connection getCon() throws SQLException {

		return DriverManager.getConnection(DB_URL, USER, PASS);

	}
	// Database URL and credentials
	private final static String DB_URL = "jdbc:mysql://localhost/Thomas_Home_Finance";
	private final static String USER = "root";

	private final static String PASS = "1234";

	static {

		// JDBC driver name
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Driver not found!");
		}

	}
}
