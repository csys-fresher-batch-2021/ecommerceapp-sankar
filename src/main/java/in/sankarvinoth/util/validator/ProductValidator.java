package in.sankarvinoth.util.validator;

import java.sql.SQLException;
import java.util.List;

import in.sankarvinoth.dao.AddProductsDao;
import in.sankarvinoth.dao.AddProductsDaoImp1;

import in.sankarvinoth.model.Product;

public class ProductValidator {
	
	 private ProductValidator() {
		
		 
	}
  /**
   * method to check whether the product already exists in the product table or not 
   * @param product
   * @return
   * @throws ClassNotFoundException
   * @throws SQLException
   */
	public static boolean isNewProductToRegister(Product product) throws ClassNotFoundException, SQLException {
		 boolean isNewProduct=true;
		 AddProductsDao dao=new AddProductsDaoImp1();
		 List<Product> products= dao.findProductByProductId(product);
		for(Product product1:products) {
			 if(product1.getProductId().equals(product.getProductId())
					 ||  product1.getProductName().equalsIgnoreCase(product.getProductName())) {
				 isNewProduct=false;
				 break;
			 }
		 }
		return isNewProduct;
		 
	 }
	
}
