package in.sankarvinoth.dao;

import java.sql.SQLException;
import java.util.List;

import in.sankarvinoth.model.Product;

public interface ProductsDao {
	List<Product> getAllProducts();
	List<Product> searchForProduct(String searchedProduct);
	
	}
