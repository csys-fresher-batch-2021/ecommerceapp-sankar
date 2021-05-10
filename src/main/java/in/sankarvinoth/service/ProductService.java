package in.sankarvinoth.service;

import java.util.Map;
import java.util.TreeMap;

public class ProductService {
	private static Map<Integer, String> productsAvailable = new TreeMap<Integer, String>();
	static {
		// List of products in the map
		productsAvailable.put(1, "Air Conditioner");
		productsAvailable.put(2, "Washing Machine");
		productsAvailable.put(3, "Water Purifier");
		productsAvailable.put(4, "Television");
		productsAvailable.put(5, "vacuum Cleaner");
		productsAvailable.put(6, "Refrigerator");
		productsAvailable.put(7, "Induction Stove");
		productsAvailable.put(8, "Camera");
		productsAvailable.put(9, "Microwave Oven");
		productsAvailable.put(10, "Mixer Grinder");
	}

	/**
	 * method to display the products available
	 * 
	 * @return
	 * 
	 */
	public static Map<Integer, String> getProducts() {
		return productsAvailable;
	}
}
