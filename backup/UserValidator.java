package in.sankarvinoth.util.validator;

import java.util.List;

import in.sankarvinoth.dao.UserRegisterDao;
import in.sankarvinoth.model.User;

public class UserValidator {
	/**
	 * method to validate whether user data is already exists in the list or not
	 * 
	 * @param user
	 * @return
	 */
	public static boolean userValidation(User user) {
		boolean isValidUser = true;
		List<User> users = UserRegisterDao.getAllUsers();
		for (User userdetails : users) {
			if (userdetails.getPhoneNumber().equals(user.getPhoneNumber())
					|| userdetails.getUserName().equals(user.getUserName())) {
				isValidUser = false;
				break;
			}
		}
		return isValidUser;
	}
}
