package in.sankarvinoth.util.validator;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserNameTest {
	// Test Cases for UserName Validation
	@Test
	public void testCaseForUserNameAsCorrectFormat() {
		boolean isValidUserName = UserInputValidator.usernameValidation("sankar12");
		assertTrue(isValidUserName);
	}

	@Test
	public void testCaseForUserNameStartsWithNumber() {
		boolean isValidUserName = UserInputValidator.usernameValidation("12sankarVi");
		assertFalse(isValidUserName);
	}

	@Test
	public void testCaseForUserNameWithInbetweenWhiteSpaces() {
		boolean isValidUserName = UserInputValidator.usernameValidation("sankar Vino");
		assertFalse(isValidUserName);
	}

	@Test
	public void testCaseForUserNameWithLessThanEightCharacters() {
		boolean isValidUserName = UserInputValidator.usernameValidation("sanka");
		assertFalse(isValidUserName);
	}

}
