package in.sankarvinoth.util.validator;

import java.util.List;

import in.sankarvinoth.service.AddToCartService;

public class RepeatedProductsValidator {
	/**
	 * method to test whether the products Id is already present in an arraylist or
	 * not returns true if arraylist doesnot contain the same element
	 */

	private RepeatedProductsValidator() {

	}

	public static boolean isNewProductTocart(String productId) {
       boolean isValid=true;
		List<String> productsIdsInList = AddToCartService.getAllProductIds(productId);
		// contains method used to check the productId already exists or not
		boolean isValidNewProduct = productsIdsInList.contains(productId);
		if(isValidNewProduct) {
			isValid=false;
		}
		return isValid;
		

	}
}
