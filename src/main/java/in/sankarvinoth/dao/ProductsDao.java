package in.sankarvinoth.dao;


import java.util.List;

import in.sankarvinoth.model.Product;

public interface ProductsDao {
	List<Product> getAllProducts();
	List<Product> searchForProduct(String searchedProduct);
	List<Product> searchProductByProductId(String productId);
	List<Product> updateStock(Product product);
	
	}
