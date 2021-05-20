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
		boolean isValidUser = UserValidator.userValidation(user);
		boolean isValidUserInputs = UserInputValidator.usernameAndPhoneNumberValidation(user.getUserName(),
				user.getPhoneNumber());
		boolean isValidUserFullName = UserInputValidator.fullnameValidation(user.getFullName());
		//boolean isSamePassword = IsPasswordSame.IsPasswordAndConfirmPasswordSame(user.getPassword(),
				//user.getConfirmPassword());
		
		if (isValidUser && isValidUserInputs && isValidUserFullName ) {
			isAdded = true;
			UserRegisterDao.addUserToRegister(user);
		} else {
			isAdded = false;
		}
		return isAdded;

	}
	
	
		
	}


