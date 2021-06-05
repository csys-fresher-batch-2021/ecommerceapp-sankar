package in.sankarvinoth.util.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import in.sankarvinoth.service.CartService;

public class RepeatedProductsValidator {
	private RepeatedProductsValidator() {

	}
	/**
	 * method to test whether the products Id is already present in an arraylist or
	 * not returns true if arraylist doesnot contain the same element
	 */
	public static boolean isNewProductTocart(String productId) {
        boolean isValid=false;
		List<String> productsIdsInList = CartService.setAllProductIds(productId);
		// contains method used to check the productId already exists or not
		Set<String> s = new HashSet<String>();

        for(String productIds :productsIdsInList ) {
            if(s.add(productIds)) {
            	isValid=true;
            } 
        }
		return isValid;
		
}
}
