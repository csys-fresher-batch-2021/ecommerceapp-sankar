package in.sankarvinoth.service;

import java.sql.SQLException;

import in.sankarvinoth.dao.UserDao;
import in.sankarvinoth.model.User;
import in.sankarvinoth.util.validator.UserValidator;

public class UserRegistrationservice {

	private UserRegistrationservice() {
		super();
	}

	/**
	 * method to validate and add the user datails to the register
	 * 
	 * @param user
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static boolean userregistrationService(User user) throws ClassNotFoundException, SQLException {
		boolean isValidRegistration = false;
		// validation for new user and existing user
		boolean isNewUser = UserValidator.userValidation(user);

		if(isNewUser) {
			UserDao.addUserToUserRegister(user);
			isValidRegistration = true;
		}
		return isValidRegistration;

	}
}
