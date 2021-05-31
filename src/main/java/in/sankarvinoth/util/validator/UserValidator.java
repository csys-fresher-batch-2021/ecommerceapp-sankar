package in.sankarvinoth.util.validator;

import java.sql.SQLException;
import java.util.List;

import in.sankarvinoth.dao.UserDao;

import in.sankarvinoth.model.User;

public class UserValidator {

	private UserValidator() {

	}

	/**
	 * method to validate whether user data is already exists in the list or not
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static boolean userValidation(User user) throws ClassNotFoundException, SQLException {
		boolean isValidUser = true;
		List<User> users = UserDao.findUserByPhoneNumberandEmail(user.getPhoneNumber(), user.getEmail());
		for (User userdetails : users) {
			if (userdetails.getPhoneNumber().equals(user.getPhoneNumber())
					|| userdetails.getEmail().equals(user.getEmail())) {
				isValidUser = false;
				break;
			}
		}
		return isValidUser;
	}
	
	/**
	 * method to validate users login credentials already registered or not 
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static boolean userLoginValidation(User user) throws ClassNotFoundException, SQLException {
		boolean isValidUser = false;
		List<User> users = UserDao.userLoginVerification(user.getUserName(), user.getPassword());
		for (User userdetails : users) {
			if (userdetails.getUserName().equals(user.getUserName())
					&&  userdetails.getPassword().equals(user.getPassword())) {
				isValidUser = true;
				break;
			}
		}
		return isValidUser;
	}
}
