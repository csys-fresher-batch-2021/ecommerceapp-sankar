package in.sankarvinoth.util.validator;

import static org.junit.Assert.*;

import org.junit.Test;

public class PhoneNumberValidationTest {

	@Test
	public void testCaseForphoneNumberValidationAsCorrectFormat() {
		boolean isValidphoneNumber = UserInputValidator.phoneNumberValidation(9678563456L);
		assertTrue(isValidphoneNumber);
	}

	@Test
	public void testCaseForphoneNumberValidationStartsWithNumberSix() {
		boolean isValidphoneNumber = UserInputValidator.phoneNumberValidation(6678563456L);
		assertTrue(isValidphoneNumber);
	}

	@Test
	public void testCaseForphoneNumberValidationStartsWithNumbrSeven() {
		boolean isValidphoneNumber = UserInputValidator.phoneNumberValidation(7678563456L);
		assertTrue(isValidphoneNumber);
	}

	@Test
	public void testCaseForphoneNumberValidationStartsWithNumbrEight() {
		boolean isValidphoneNumber = UserInputValidator.phoneNumberValidation(8767856345L);
		assertTrue(isValidphoneNumber);
	}

	@Test
	public void testCaseForphoneNumberValidationWithNegativeNumbers() {
		boolean isValidphoneNumber = UserInputValidator.phoneNumberValidation(-987678563L);
		assertFalse(isValidphoneNumber);
	}

	@Test
	public void testCaseForphoneNumberValidationStartsWithzero() {
		boolean isValidphoneNumber = UserInputValidator.phoneNumberValidation(57856345L);
		assertFalse(isValidphoneNumber);
	}

}
