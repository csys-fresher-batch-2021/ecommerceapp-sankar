package in.sankarvinoth.util.validator;

public class StringValidator {
	
	private StringValidator() {
		
	}

	/**
	 * method to validate the string using the given conditions
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isValidString(String input) {
		
		// Logic
		return  !(input == null || input.trim().equals(""));
			
}
}