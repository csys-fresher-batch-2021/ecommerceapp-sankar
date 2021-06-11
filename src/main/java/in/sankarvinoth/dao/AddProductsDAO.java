package in.sankarvinoth.dao;

import java.sql.SQLException;
import java.util.List;

import in.sankarvinoth.exceptions.DBException;
import in.sankarvinoth.exceptions.ProductIdExistsException;
import in.sankarvinoth.model.Product;

public interface AddProductsDAO {
	// method declaration for add Product into db
	void save(Product product) throws ClassNotFoundException, SQLException, DBException, ProductIdExistsException;

	// method declaration for method used to check whether the product already  exists in the db or not
	List<Product> findProductByProductId(Product product) throws ClassNotFoundException, SQLException;

}
