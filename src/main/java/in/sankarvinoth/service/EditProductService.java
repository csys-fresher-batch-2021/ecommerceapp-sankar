package in.sankarvinoth.service;

import java.util.ArrayList;
import java.util.List;

import in.sankarvinoth.dao.ProductsDAO;
import in.sankarvinoth.dao.ProductsDAOImp;
import in.sankarvinoth.exceptions.DBException;
import in.sankarvinoth.model.Product;

public class EditProductService {

	private EditProductService() {

	}

	private static final ProductsDAO dao = new ProductsDAOImp();

	/**
	 * method to get the searched products result which is in the db .
	 * 
	 * @param productId
	 * @return
	 * @throws DBException 
	 */
	public static List<Product> getSearchResults(String productId) throws DBException {

		// calling the get all Products method .
		List<Product> productList = dao.searchProductByProductId(productId);
		// copy of getAllProducts List
		return new ArrayList<>(productList);
	}

	/**
	 * method to update the existing data in database .
	 * 
	 * @param product
	 * @throws DBException 
	 */

	public static void updateProductsService(Product product) throws DBException {
		dao.updateStock(product);
	}

}
