package in.sankarvinoth.util.validator;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserCredentialsValidationTest {

	@Test

	public void testCaseForUserNameAndPhoneNumberAsCorrectFormat() {
		boolean isValidUser = UserInputValidator.usernameAndPhoneNumberValidation("Sankarv12", 9678456542L);
		assertTrue(isValidUser);
	}

	@Test

	public void testCaseForUserNameAndPhoneNumberWithInCorrectFormat() {
		boolean isValidUser = UserInputValidator.usernameAndPhoneNumberValidation("Sankarvinoth", 0456542L);
		assertFalse(isValidUser);
	}
}
