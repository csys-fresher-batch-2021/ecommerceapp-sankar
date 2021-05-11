package in.sankarvinoth.service;

import java.util.Map;
import java.util.TreeMap;

public class ProductService {
	
	private ProductService() {
		//private constructor to avoid object creation
	}
	private static final Map<Integer, String> products = new TreeMap<Integer, String>();
	static {
		// List of products in the map
		products.put(1, "Air Conditioner");
		products.put(2, "Washing Machine");
		products.put(3, "Water Purifier");
		products.put(4, "Television");
		products.put(5, "vacuum Cleaner");
		products.put(6, "Refrigerator");
		products.put(7, "Induction Stove");
		products.put(8, "Camera");
		products.put(9, "Microwave Oven");
		products.put(10, "Mixer Grinder");
	}

	/**
	 * method to display the products available
	 * 
	 * @return
	 * 
	 */
	public static Map<Integer, String> getProducts() {
		return products;
	}
}
