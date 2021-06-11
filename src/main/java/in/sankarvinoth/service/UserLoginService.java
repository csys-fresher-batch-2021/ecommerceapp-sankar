package in.sankarvinoth.service;

import java.sql.SQLException;

import in.sankarvinoth.model.User;

import in.sankarvinoth.util.validator.UserInputsValidator;
import in.sankarvinoth.util.validator.UserValidator;

public class UserLoginService {

	private UserLoginService() {

	}

	/**
	 * method to check both inputs and user credentials true
	 * 
	 * @param user
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static boolean userLogin(User user) throws ClassNotFoundException, SQLException {
		boolean isValidLogin = false;
		// validating inputs such as UserName and password
		boolean isValidInputs = UserInputsValidator.userLoginValidator(user.getUserName(), user.getPassword());
		// validating whether the user is registered or not
		boolean isValidUser = UserValidator.userLoginValidation(user);
		if (isValidInputs && isValidUser) {
			isValidLogin = true;
		}
		return isValidLogin;
	}
}
