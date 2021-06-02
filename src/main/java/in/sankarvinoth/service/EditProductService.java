package in.sankarvinoth.service;

import java.util.ArrayList;
import java.util.List;

import in.sankarvinoth.dao.ProductsDao;
import in.sankarvinoth.dao.ProductsDaoImp;
import in.sankarvinoth.model.Product;

public class EditProductService {

	private EditProductService() {

	}

	private static final ProductsDao dao = new ProductsDaoImp();

	/**
	 * method to get the searched products result which is in the db .
	 * 
	 * @param productId
	 * @return
	 */
	public static List<Product> getSearchResults(String productId) {

		// calling the get all Products method .
		List<Product> productList = dao.searchProductByProductId(productId);
		// copy of getAllProducts List
		return new ArrayList<>(productList);
	}

	/**
	 * method to update the existing data in database .
	 * 
	 * @param product
	 */

	public static void updateProductsService(Product product) {
		dao.updateStock(product);
	}

}
