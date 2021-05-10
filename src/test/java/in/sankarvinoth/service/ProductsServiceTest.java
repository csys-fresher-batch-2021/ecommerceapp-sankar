package in.sankarvinoth.service;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

public class ProductsServiceTest {

	@Test
	/**
	 * method to check the size of Products in map Test Case with valid output
	 */
	public void testCase1() {
		// calling the getProducts method to check the size of Products in map
		Map<Integer, String> productDisplay = ProductService.getProducts();
		assertEquals(10, productDisplay.size());
	}

	@Test
	/**
	 * method to check the size of Products in map Test Case with Invalid output
	 */
	public void testCase2() {
		// calling the getProducts method to check the size of Products in map
		Map<Integer, String> productDisplay = ProductService.getProducts();
		assertEquals(1, productDisplay.size());
	}
}
