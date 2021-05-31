package in.sankarvinoth.dao;

import java.util.List;

import in.sankarvinoth.model.Product;

public interface CartDao {
	List<Product> getAllProducts(List<String> productIds);
}
