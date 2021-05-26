package in.sankarvinoth.util.validator;

import static org.junit.Assert.*;

import org.junit.Test;

public class isPasswordSameTest {

	@Test
	public void testCaseForPasswordMatch() {
		boolean isValidPassword = IsPasswordSame.isPasswordAndConfirmPasswordSame("sankar12", "sankar12");
		assertTrue(isValidPassword);
	}

	@Test
	public void testCaseForPasswordMatch1() {
		boolean isValidPassword = IsPasswordSame.isPasswordAndConfirmPasswordSame("sankar", "sankar12");
		assertFalse(isValidPassword);
	}
}
