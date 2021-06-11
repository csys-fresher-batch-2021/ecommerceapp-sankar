package in.sankarvinoth.dao;

import java.util.List;

import in.sankarvinoth.exceptions.DBException;
import in.sankarvinoth.model.Cart;
import in.sankarvinoth.model.Product;

public interface CartDAO {
	// method declarations
	List<Product> getAllProducts(List<String> productIds);

	List<Cart> getAllPlacedOrdersForUser(String userName) throws DBException;

	List<Cart> getAllPlacedOrdersForAdmin() throws DBException;

}
