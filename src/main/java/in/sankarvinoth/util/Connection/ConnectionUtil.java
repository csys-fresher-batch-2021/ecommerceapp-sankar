package in.sankarvinoth.util.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String driverClass = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost/ecommerce_db";
		String username = "postgres";
		String password = "postgresql";

		Class.forName(driverClass);
		// getting connection from db
		Connection connection = DriverManager.getConnection(url, username, password);
		System.out.println("Connection Established");
		return connection;
	}

	public static void close(Connection con) {
		try {
			if (con != null) {
				con.close();
				System.out.println("connection released");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static void close(PreparedStatement pst) {
		try {

			if (pst != null) {
				pst.close();
				System.out.println("prepared statement released");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static void close(ResultSet rst) {
		try {

			if (rst != null) {
				rst.close();
				System.out.println("resultset released");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
