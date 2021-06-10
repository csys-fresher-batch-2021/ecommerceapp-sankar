package in.sankarvinoth.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import in.sankarvinoth.model.Customer;

import in.sankarvinoth.util.connection.ConnectionUtil;

public class CustomerEnquiriesDao {

	private CustomerEnquiriesDao() {

	}

	/**
	 * method to insert the new enquiry messages into the user table
	 * 
	 * @param
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void addMessages(String Username, String Subject, String Message)
			throws ClassNotFoundException, SQLException {

		Connection con = null;
		PreparedStatement pst = null;
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();

		try {
			// getting the connection
			con = ConnectionUtil.getConnection();
			String sql = "insert into CustomerEnquiry(username,subject,message,sendTo,messageSentDate,messageSenttime) values(?,?,?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, Username);
			pst.setString(2, Subject);
			pst.setString(3, Message);
			pst.setString(4, "admin34");
			pst.setObject(5, date);
			pst.setObject(6, time);
			// executing query
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con, pst);
		}

	}

	/**
	 * method to get all the messages stored in db for admin
	 * 
	 * @return
	 */

	public static List<Customer> getAllMessages() {
		List<Customer> messages = new ArrayList<>();
		Connection con = null;
		Statement st = null;
		ResultSet rst = null;

		try {
			// getting the connection
			con = ConnectionUtil.getConnection();

			st = con.createStatement();
			rst = st.executeQuery("select * from CustomerEnquiry");
			while (rst.next()) {

				String userName = rst.getString("username");
				String subject = rst.getString("subject");
				String message = rst.getString("message");

				String sentTo = rst.getString("sendTo");

				Date date1 = rst.getDate("messageSentDate");
				Time time1 = rst.getTime("messageSenttime");

				Customer customer = new Customer();
				customer.setUserName(userName);
				customer.setSubject(subject);
				customer.setMessage(message);
				customer.setSendTo(sentTo);
				customer.setDate(date1.toLocalDate());
				customer.setTime(time1.toLocalTime());

				// storing the values in ArrayList
				messages.add(customer);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// closing the connection
			ConnectionUtil.close(con, st, rst);

		}
		return messages;

	}
}
