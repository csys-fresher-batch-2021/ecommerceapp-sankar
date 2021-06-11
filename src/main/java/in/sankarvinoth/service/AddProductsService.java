package in.sankarvinoth.service;

import java.sql.SQLException;

import in.sankarvinoth.dao.AddProductsDAO;
import in.sankarvinoth.dao.AddProductsDAOImp1;
import in.sankarvinoth.exceptions.DBException;
import in.sankarvinoth.exceptions.ProductIdExistsException;
import in.sankarvinoth.model.Product;
import in.sankarvinoth.util.validator.ProductDetailsValidator;
import in.sankarvinoth.util.validator.ProductValidator;

public class AddProductsService {
	private AddProductsService() {
		//// private constructor to avoid object creation
	}

	private static final AddProductsDAO dao = new AddProductsDAOImp1();

	/**
	 * method to add check whether the product details input is valid or not
	 * 
	 * @param product
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws DBException
	 * @throws ProductIdExistsException 
	 * @throws ProductIdException
	 */
	public static boolean addProductService(Product product) throws ClassNotFoundException, SQLException, DBException, ProductIdExistsException {

		boolean isValid = false;
		// validating product inputs
		boolean isValidProductDetails = ProductDetailsValidator.productValidator(product);
		// validating whether the product already exists or not in the database
		boolean isvalidNewProductId = ProductValidator.isNewProductToRegister(product);

		if (isValidProductDetails) {
			if (isvalidNewProductId) {
				dao.save(product);
				isValid = true;

			} else {
				isValid = false;
			}
		}

		return isValid;
	}

}
