package in.sankarvinoth.util.validator;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringValidatorTest {

	@Test
	public void testCaseWithCorrectString() {
		boolean isValidString = StringValidator.isValidString("sankar");
		assertTrue(isValidString);
	}

	@Test
	public void testCaseWithnullString() {
		boolean isValidString = StringValidator.isValidString(null);
		assertFalse(isValidString);
	}

	@Test
	public void testCaseWithSpaces() {
		boolean isValidString = StringValidator.isValidString("   ");
		assertFalse(isValidString);
	}
}
