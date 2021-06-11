package in.sankarvinoth.service;

import java.util.ArrayList;
import java.util.List;

import in.sankarvinoth.dao.ProductsDAO;
import in.sankarvinoth.dao.ProductsDAOImp;
import in.sankarvinoth.model.Product;

public class ProductService {
	

	private ProductService() {

	}

	private static final ProductsDAO dao = new ProductsDAOImp();

	/**
	 * method to get all products based upon the select query
	 * 
	 * @return
	 */

	public static List<Product> getAllProductsfromDb() {

		// calling the get all Products method .
		List<Product> products = dao.getAllProducts();
		// copy of getAllProducts List

		return new ArrayList<>(products);

	}

	
	
}
