package in.sankarvinoth.util.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.sankarvinoth.util.Logger;

public class ConnectionUtil {

	private ConnectionUtil() {
		
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		String driverClass = System.getenv("spring.datasource.driver-class-name");
		String url = System.getenv("spring.datasource.url");
		String username = System.getenv("spring.datasource.username");
		String password = System.getenv("spring.datasource.password");
		Class.forName(driverClass);
		// getting connection from db
		Connection connection = DriverManager.getConnection(url, username, password);
		Logger.log("connection established");
		return connection;
	}

	public static void close(Connection con) {
		try {
			if (con != null) {
				con.close();
				Logger.log("connection released");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static void close(PreparedStatement pst) {
		try {

			if (pst != null) {
				pst.close();
				Logger.log("prepared statement released");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static void close(ResultSet rst) {
		try {

			if (rst != null) {
				rst.close();
				Logger.log("resultset released");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public static void close(Statement st) {
		try {

			if (st!= null) {
				st.close();
			Logger.log("statement released");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}


