package in.sankarvinoth.service;

import in.sankarvinoth.dao.UserRegisterDao;
import in.sankarvinoth.model.User;
import in.sankarvinoth.util.validator.IsPasswordSame;
import in.sankarvinoth.util.validator.UserInputValidator;
import in.sankarvinoth.util.validator.UserValidator;

public class UserRegistrationService {
	private UserRegistrationService() {
		// private constructor to avoid object creation
	}

	/**
	 * method to add user to the user register after validation
	 * 
	 * @param user
	 * @return
	 */
	public static boolean addUserToUserRegister(User user) {
		boolean isAdded = false;
		// validation to check the user is already exists in the db or not
		boolean isValidUser = UserValidator.userValidation(user);
		// validation to check the user inputs such as username and phone Number
		boolean isValidUserInputs = UserInputValidator.usernameAndPhoneNumberValidation(user.getUserName(),
				user.getPhoneNumber());
		// validation to check the fullname of the user
		boolean isValidUserFullName = UserInputValidator.fullnameValidation(user.getFullName());
		// method to check whether the password and confirm password is same or not
		boolean isValid = IsPasswordSame.isPasswordAndConfirmPasswordSame(user.getPassword(),
				user.getConfirmPassword());

		if (isValidUser && isValidUserInputs && isValidUserFullName && isValid) {

			isAdded = true;
			UserRegisterDao.addUserToRegister(user);
		} else {
			isAdded = false;
		}

		return isAdded;

	}
}
