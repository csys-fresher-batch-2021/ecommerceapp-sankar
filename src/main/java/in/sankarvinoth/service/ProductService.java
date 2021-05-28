package in.sankarvinoth.service;

import java.util.ArrayList;
import java.util.List;


import in.sankarvinoth.dao.ProductsDao;
import in.sankarvinoth.dao.ProductsDaoImp;
import in.sankarvinoth.model.Product;

public class ProductService {

     private ProductService() {
		
		
	}
      private static final  ProductsDao dao = new ProductsDaoImp();
      /**
       * method to get all products based upon the select query
       * @return
       */

	   public static List<Product>  getAllProductsfromDb() {

		
		// calling the get all Products method .
		List<Product> products = dao.getAllProducts();
		// copy of getAllProducts List
	    
	    return  new ArrayList<>(products);
		
	}
	   /**
	    * method to get the searched products result which is in the db .
	    * @param searchedProduct
	    * @return
	    */
	   public static List<Product>  getSearchResults(String searchedProduct) {

			
			// calling the get all Products method .
			List<Product> searchedResults=dao.searchForProduct(searchedProduct);
			// copy of getAllProducts List
			return  new ArrayList<>(searchedResults);
		 }
	   
	  
	  
}
