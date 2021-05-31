package in.sankarvinoth.service;

import java.util.ArrayList;
import java.util.List;

import in.sankarvinoth.dao.CartDao;
import in.sankarvinoth.dao.CartDaoImp;
import in.sankarvinoth.model.Product;

public class AddToCartService {

	private AddToCartService() {

	}

	private static final CartDao cart = new CartDaoImp();
	// ArrayList to store the product Ids
	static List<String> productIds = new ArrayList<>();

	/**
	 * method to get all ProductId as a arrayList
	 * 
	 * @param productId
	 * @return
	 */
	public static List<String> getAllProductIds(String productId) {
		// getting the values in ArrayList
		productIds.add(productId);
		return productIds;
	}

	/**
	 * method to add products to cart gives the corresponding values inEqual of
	 * product Id as ArrayList
	 * 
	 * @param productIds
	 * @return
	 */
	public static List<Product> addProductToCartService(List<String> productIds) {

		List<Product> productsInTheCart = cart.getAllProducts(productIds);
		return productsInTheCart;

	}

}
