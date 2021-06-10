package in.sankarvinoth.service;

import java.sql.SQLException;
import java.util.List;

import in.sankarvinoth.dao.CustomerEnquiriesDao;
import in.sankarvinoth.model.Customer;

public class CustomerService {

	private CustomerService() {

	}

	/**
	 * method to get add messages to db
	 * 
	 * @param username
	 * @param subject
	 * @param message
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public static void addMessagesService(String username, String subject, String message)
			throws ClassNotFoundException, SQLException {
		CustomerEnquiriesDao.addMessages(username, subject, message);
	}

	/**
	 * method to get all the messages that are stored in the database
	 * 
	 * @return
	 */

	public static List<Customer> getAllMessagesService() {
		List<Customer> Customers = CustomerEnquiriesDao.getAllMessages();
		return Customers;

	}

}
