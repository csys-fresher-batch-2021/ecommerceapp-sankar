package in.sankarvinoth.util.validator;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberValidationTest {

	@Test
	public void testCaseWithNumberLessThanZero() {
		Boolean isValidNumber=NumberValidator.numberValidation(-4);
		assertFalse(isValidNumber);
	}
	@Test
	public void testCaseWithNumberEqualToZero() {
		Boolean isValidNumber=NumberValidator.numberValidation(0);
		assertFalse(isValidNumber);
	}
	@Test
	public void testCaseWithNumberInCorrectNumberFormat() {
		Boolean isValidNumber=NumberValidator.numberValidation(3);
		assertTrue(isValidNumber);
	}

}
