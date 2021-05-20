package in.sankarvinoth.util.validator;

import static org.junit.Assert.*;

import org.junit.Test;

public class isPasswordSameTest {

	@Test
	public void testCaseForPasswordMatch() {
		boolean isValidPassword = IsPasswordSame.IsPasswordAndConfirmPasswordSame("sankar12", "sankar12");
		assertTrue(isValidPassword);
	}

	@Test
	public void testCaseForPasswordMatch1() {
		boolean isValidPassword = IsPasswordSame.IsPasswordAndConfirmPasswordSame("sankar", "sankar12");
		assertFalse(isValidPassword);
	}
}
