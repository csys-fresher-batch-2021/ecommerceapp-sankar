package in.sankarvinoth.dao;

import java.sql.SQLException;

import in.sankarvinoth.model.Product;

public interface AddProductsDao {
	// method declarations
	void save(Product product) throws ClassNotFoundException, SQLException;

	boolean findProductByProductId(Product product) throws ClassNotFoundException, SQLException;

}
