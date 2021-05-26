package in.sankarvinoth.util.validator;

public class NumberValidator {

	private NumberValidator() {
	}

	/**
	 * method to check the given number is a valid number or not ie. greater than
	 * zero and not equal to zero
	 * 
	 * @param number
	 * @return
	 */
	public static boolean numberValidation(int number) {
		return !(number == 0 || number < 0);
	}
}
