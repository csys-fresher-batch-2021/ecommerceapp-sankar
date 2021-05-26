package in.sankarvinoth.service;

import java.util.ArrayList;
import java.util.List;

import in.sankarvinoth.dao.DisplayProductsDao;
import in.sankarvinoth.dao.DisplayProductsDaoImp;
import in.sankarvinoth.model.Product;

public class DisplayProductService {

     private DisplayProductService() {
		
		
	}

	public static List<Product> getAllProductsfromDb() {

		DisplayProductsDao dao = new DisplayProductsDaoImp();
		// calling the get all Products method .
		List<Product> products = dao.getAllProducts();
		// copy of getAllProducts List
		List<Product> product = new ArrayList<>(products);
		return product;

	}

}
