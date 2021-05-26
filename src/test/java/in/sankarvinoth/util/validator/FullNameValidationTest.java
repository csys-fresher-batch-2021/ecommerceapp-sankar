package in.sankarvinoth.util.validator;

import static org.junit.Assert.*;

import org.junit.Test;

public class FullNameValidationTest {

	@Test
	public void testCaseForFullNameAsCorrectFormat() {
		boolean isValidUserName = UserInputValidator.fullnameValidation("Sankarvinoth");
		assertTrue(isValidUserName);
	}

	@Test
	public void testCaseForFullNameStartsWithNumber() {
		boolean isValidUserName = UserInputValidator.fullnameValidation("12SankarVi");
		assertFalse(isValidUserName);
	}

	@Test
	public void testCaseForFullNameWithInbetweenWhiteSpaces() {
		boolean isValidUserName = UserInputValidator.fullnameValidation("Sankar Vino");
		assertFalse(isValidUserName);
	}

	

	

	@Test
	public void testCaseForFullNameWithNumberInName() {
		boolean isValidUserName = UserInputValidator.fullnameValidation("Sankavinoth12");
		assertFalse(isValidUserName);
	}
}
