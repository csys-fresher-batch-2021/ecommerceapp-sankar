package in.sankarvinoth.util.validator;

public class IsPasswordSame {
	/**
	 * method to check whether the password and confirm password same
	 * 
	 * @param password
	 * @param confirmPassword
	 * @return
	 */
	public static boolean IsPasswordAndConfirmPasswordSame(String password, String confirmPassword) {
		boolean isSamePassword = false;
		boolean isValidPassword=UserInputValidator.passwordValidation(password);
		boolean isValidConfirmPassword=UserInputValidator.passwordValidation(confirmPassword);
		if(isValidPassword && isValidConfirmPassword) {
		if (password.equals(confirmPassword)) {
			isSamePassword = true;
		} else {
			isSamePassword = false;
		}
		
	}
		return isSamePassword;
}
}
