package in.sankarvinoth.dao;

import java.sql.SQLException;
import java.util.List;

import in.sankarvinoth.model.Product;

public interface AddProductsDao {
	// method declarations
	void save(Product product) throws ClassNotFoundException, SQLException;

	List<Product> findProductByProductId(Product product) throws ClassNotFoundException, SQLException;

}
