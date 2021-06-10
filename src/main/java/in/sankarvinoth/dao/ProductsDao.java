package in.sankarvinoth.dao;

import java.util.List;

import in.sankarvinoth.model.Product;

public interface ProductsDao {
	// method declaration- get all the products in the db
	List<Product> getAllProducts();

	// method declaration - for search product from the db
	List<Product> searchForProduct(String searchedProduct);

	// method declarations - for search product by product id
	List<Product> searchProductByProductId(String productId);

	// method declarations- for stock updates
	List<Product> updateStock(Product product);

	// method declarations-for update quantity
	void updateQuantity();

}
