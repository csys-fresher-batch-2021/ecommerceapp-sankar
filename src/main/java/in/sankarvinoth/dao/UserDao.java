package in.sankarvinoth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;


import in.sankarvinoth.model.User;
import in.sankarvinoth.util.connection.ConnectionUtil;

public class UserDao {
	private UserDao() {

	}

	/**
	 * method to insert the new user datails into the user table
	 * 
	 * @param user
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void addUserToUserRegister(User user) throws ClassNotFoundException, SQLException {
		String fullName = user.getFullName();
		String userName = user.getUserName();
		String email = user.getEmail();
		Long mobileNumber = user.getPhoneNumber();
		String password = user.getPassword();
		// getting the connection
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pst = null;

		try {

			String sql = "insert into UserRegister (fullName,userName,email,mobileNumber,password) values(?,?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, fullName);
			pst.setString(2, userName);
			pst.setString(3, email);
			pst.setLong(4, mobileNumber);
			pst.setString(5, password);
			// executing query
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con, pst);
		}

	}

	/**
	 * method to collect all the matches related to select query in an arraylist
	 * 
	 * @param phoneNumber
	 * @param email
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static List<User> findUserByPhoneNumberandEmail(Long phoneNumber, String email)
			throws ClassNotFoundException, SQLException {

		List<User> users = new ArrayList<>();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rst = null;

		try {
			// getting the connection
			con = ConnectionUtil.getConnection();
			String sql = ("select * from UserRegister where mobileNumber='" + phoneNumber + "' and email='" + email
					+ "' ");

			st = con.prepareStatement(sql);

			rst = st.executeQuery();
			while (rst.next()) {
				String fullname = rst.getString("fullName");
				String username = rst.getString("userName");
				String emails = rst.getString("email");
				Long phoneNumber1 = rst.getLong("mobileNumber");
				User user = new User();
				user.setFullName(fullname);
				user.setUserName(username);
				user.setEmail(emails);
				user.setPhoneNumber(phoneNumber1);

				// getting the values in ArrayList
				users.add(user);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// closing the connection
			ConnectionUtil.close(con, st, rst);

		}
		return users;

	}

	/**
	 * method to verify Login , whether the user is registered or not
	 * 
	 * @param user
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static List<User> userLoginVerification(String userName, String password)
			throws ClassNotFoundException, SQLException {

		List<User> users = new ArrayList<>();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rst = null;

		try {
			// getting the connection
			con = ConnectionUtil.getConnection();
			String sql = ("select * from UserRegister where userName='" + userName + "' and password ='" + password
					+ "'");

			st = con.prepareStatement(sql);

			rst = st.executeQuery();
			while (rst.next()) {
				String fullname = rst.getString("fullName");
				String username = rst.getString("userName");
				String emails = rst.getString("email");
				Long phoneNumber1 = rst.getLong("mobileNumber");
				String password1 = rst.getString("password");
				User user = new User();
				user.setFullName(fullname);
				user.setUserName(username);
				user.setEmail(emails);
				user.setPhoneNumber(phoneNumber1);
				user.setPassword(password1);

				// getting the values in ArrayList
				users.add(user);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// closing the connection
			ConnectionUtil.close(con, st, rst);

		}
		return users;

	}
	
	
	/**
	 * method to update the data depends upon the changes in the corresponding
	 * fields
	 */
	public static void updateUserAddress(String address,String username) {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rst = null;

		try {
			// getting the connection
			con = ConnectionUtil.getConnection();
			String sql = "update UserRegister set address='" +address+ "' where userName='"
					+username+ "'";
			st = con.prepareStatement(sql);

			rst = st.executeQuery();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// closing the connection
			ConnectionUtil.close(con, st, rst);

		}
		

	}


}
