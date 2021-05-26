package in.sankarvinoth.util.validator;


public class UserInputValidator {
	/**
	 * method to validate fullname
	 * 
	 * @param fullname
	 * @return
	 */
	public static boolean fullnameValidation(String fullname) {
		final String regularExpression = "^[A-Z][A-Za-z]{4,29}$";
		boolean isValidFullname = false;
		if (StringValidator.isValidString(fullname)) {
			if (fullname.matches(regularExpression)) {
				isValidFullname = true;
			} else {
				isValidFullname = false;
			}
		}
		return isValidFullname;
	}

	/**
	 * method to validate username
	 * 
	 * @param username
	 * @return
	 */
	public static boolean usernameValidation(String username) {
		final String regularExpression ="^[A-Za-z][A-Za-z0-9]{5,12}$";
		boolean isValidusername = false;
		if (StringValidator.isValidString(username)) {
			if (username.matches(regularExpression)) {
				isValidusername = true;
			} else {
				isValidusername = false;
			}

		}
		return isValidusername;
	}

	/**
	 * method to validate phonenumber
	 * 
	 * @param phonenumber
	 * @return
	 */
	public static boolean phoneNumberValidation(Long phonenumber) {
		final String regularExpression = "^[6-9][0-9]{9}$";
		String phoneNumber = phonenumber.toString();
		boolean isValidPhoneNumber = false;
		if (StringValidator.isValidString(phoneNumber)) {
			if (phoneNumber.matches(regularExpression)) {
				isValidPhoneNumber = true;
			} else {
				isValidPhoneNumber = false;
			}

		}
		return isValidPhoneNumber;
	}
	/**
	 * method to validate password 
	 * @param password
	 * @return
	 */
	
	public static boolean passwordValidation(String password) {
		final String regularExpression = "^[A-Za-z0-9]{5,8}$";
		
		boolean isValidPassword = false;
		if (StringValidator.isValidString(password)) {
			if (password.matches(regularExpression)) {
				isValidPassword= true;
			} else {
				isValidPassword = false;
			}

		}
		return isValidPassword;
	}

	/**
	 * method to validate both username and phonenumber
	 * 
	 * @param username
	 * @param phoneNumber
	 * @return
	 */
	public static boolean usernameAndPhoneNumberValidation(String username, Long phoneNumber) {
		boolean isValidInput = false;
		if (phoneNumberValidation(phoneNumber)) {
			if (usernameValidation(username)) {
				isValidInput = true;
			} else {
				isValidInput = false;
			}

		}
		return isValidInput;

	}
	
	public static boolean usernameAndPasswordValidation(String username, String password) {
		boolean isValidInput = false;
		if (StringValidator.isValidString(username) &&  StringValidator.isValidString(password)) {
			if (usernameValidation(username)&&UserInputValidator.passwordValidation(password)) {
				isValidInput = true;
			} else {
				isValidInput = false;
			}

		}
		return isValidInput;
    }
	
	}
	

