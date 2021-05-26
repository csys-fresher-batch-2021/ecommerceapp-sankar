package in.sankarvinoth.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import in.sankarvinoth.model.User;
import in.sankarvinoth.util.validator.UserValidator;

public class UserRegisterDao {
	private static final List<User> users = new ArrayList<>();

	/**
	 * method to get all users in the list
	 * 
	 * @return users in the list
	 */
	public static List<User> getAllUsers() {
		return users;
	}

	/**
	 * method to add user object to register
	 * 
	 * @param user object
	 */

	public static void addUserToRegister(User user) {
		users.add(user);
	}
}
