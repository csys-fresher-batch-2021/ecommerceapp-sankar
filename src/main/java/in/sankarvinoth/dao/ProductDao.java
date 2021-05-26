package in.sankarvinoth.dao;


import java.util.ArrayList;
import java.util.List;

import in.sankarvinoth.model.Product;

public class ProductDao {

	private static final List<Product> products=new ArrayList<>();

	public static List<Product> getProducts() {
		return products;
	}
	
	public static void addProductToStock(Product result) {
		products.add(result);
	}
	
}
