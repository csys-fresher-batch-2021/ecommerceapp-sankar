package in.sankarvinoth.service;

import java.util.ArrayList;
import java.util.List;

import in.sankarvinoth.dao.CartDao;
import in.sankarvinoth.dao.CartDaoImp;
import in.sankarvinoth.model.Cart;
import in.sankarvinoth.model.Product;

public class CartService {

	private CartService() {

	}

	private static final CartDao cart = new CartDaoImp();
	// ArrayList to store the product Ids
	static List<String> productIds = new ArrayList<>();

	/**
	 * method to get all ProductId as a arrayList
	 * 
	 * @param productId
	 * @return
	 */
	public static List<String> getAllProductIds() {
		return productIds;
	}
	public static List<String> setAllProductIds(String productId) {
       productIds.add(productId);
	return productIds;
	}
	
	
	

	/**
	 * method to add products to cart gives the corresponding values inEqual of
	 * product Id as ArrayList
	 * 
	 * @param productIds
	 * @return
	 */
	public static List<Product> addProductToCartService(List<String> productIds) {

		List<Product> productsInTheCart = cart.getAllProducts(productIds);
	    return productsInTheCart;

	}
	
	/**
	 * method to delete the product which maps with the product Id given from remove from cart servlet
	 * @param products
	 * @param productId
	 * @return
	 */
	public static boolean deleteProductFromCart(List<Product> products,String productId,List<String> productIds) {
		boolean isDeleted=false;
		Product isExists = null;
		
		for(Product product:products ) {
			if(product.getProductId().equalsIgnoreCase(productId)) {
				isExists= product;
				break;
			}
		}
		if(isExists!= null) {
			products.remove(isExists);
			productIds.remove(productId);
			isDeleted=true;
			
		}
		return isDeleted;
		
		
		
	}
	 
	public static List<Cart> getAllOrderedItemsService(String userName) {
		 return cart.getAllPlacedOrders(userName);
	}
	

}

