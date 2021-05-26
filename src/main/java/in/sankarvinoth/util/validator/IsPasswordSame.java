package in.sankarvinoth.util.validator;

public class IsPasswordSame {
	/**
	 * method to check whether the password and confirm password same
	 * 
	 * @param password
	 * @param confirmPassword
	 * @return
	 */
	public static boolean isPasswordAndConfirmPasswordSame(String password, String confirmPassword) {
		return (password.equals(confirmPassword)); 
		
}
}
