package in.sankarvinoth.dao;

import java.util.List;

import in.sankarvinoth.exceptions.DBException;
import in.sankarvinoth.model.Product;

public interface ProductsDAO {
	// method declaration- get all the products in the db
	List<Product> getAllProducts();

	
	// method declarations- for stock updates
	void updateStock(Product product) throws DBException;
	
	 List<Product> searchProductByProductId(String productId) throws DBException;
	// method declarations-for update quantity
	void updateQuantity();

}
