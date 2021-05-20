package in.sankarvinoth.util.validator;

public class StringValidator {
	/**
	 * method to validate the string using the given conditions
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isValidString(String input) {
		boolean isValid = false;
		// Logic
		if (input == null || input.trim().equals("") || input.length() > 13) {
			isValid = false;
			return isValid;
		} else {
			isValid = true;
			return isValid;
		}
	}
}
