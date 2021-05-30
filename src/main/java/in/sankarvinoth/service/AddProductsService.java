package in.sankarvinoth.service;

import java.sql.SQLException;

import in.sankarvinoth.dao.AddProductsDao;
import in.sankarvinoth.dao.AddProductsDaoImp1;

import in.sankarvinoth.model.Product;
import in.sankarvinoth.util.validator.ProductDetailsValidator;

public class AddProductsService {
	private AddProductsService() {
		//// private constructor to avoid object creation
	}

	private static final AddProductsDao dao = new AddProductsDaoImp1();

	/**
	 * method to add check whether the product details input is valid or not
	 * 
	 * @param product
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static boolean addProductService(Product product) throws ClassNotFoundException, SQLException {

		boolean isValid = false;
		// validating product inputs
		boolean isValidProductDetails = ProductDetailsValidator.productValidator(product);
		// validating whether the product already exists or not in the database
		boolean isValidNewProduct = dao.findProductByProductId(product);
		if (isValidProductDetails) {
			if (isValidNewProduct) {

				isValid = false;
			} else {
				dao.save(product);
				isValid = true;
			}

		}
		return isValid;
	}
}
