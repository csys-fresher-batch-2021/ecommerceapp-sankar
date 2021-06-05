package in.sankarvinoth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import in.sankarvinoth.model.Cart;
import in.sankarvinoth.model.Product;
import in.sankarvinoth.util.connection.ConnectionUtil;

public class CartDaoImp implements CartDao {

//	public List<Product> getAllProducts(Set<String> productIds) {
//
//		Connection con = null;
//		PreparedStatement st = null;
//		ResultSet rst = null;
//		List<Product> productsvia = new ArrayList<>();
//
//		try {
//			// getting the connection
//			con = ConnectionUtil.getConnection();
//			String inSql = String.join(",", Collections.nCopies(productIds.size(), "?"));
//			String sql = "select * from productInfo where ProductId IN ( " + inSql + ")";
//			
//			st = con.prepareStatement(sql);
//
//			for (int i = 1; i <= productIds.size(); i++) {
//				String productId = productIds.get(i - 1);
//				st.setString(i, productId);
//			}
//
//			rst = st.executeQuery();
//			while (rst.next()) {
//
//				String productName = rst.getString("ProductName");
//				String productId = rst.getString("ProductId");
//				String category = rst.getString("Category");
//				int price = rst.getInt("Price");
//
//				String status = rst.getString("Status");
//				Product product = new Product();
//				product.setProductName(productName);
//				product.setProductId(productId);
//				product.setCategory(category);
//				product.setAmount(price);
//
//				product.setStatus(status);
//				// getting the values in ArrayList
//				productsvia.add(product);
//			}
//
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		} finally {
//			// closing the connection
//			ConnectionUtil.close(con, st, rst);
//
//		}
//		return productsvia;
//
//	}
	/**
	 * method to get all the placed orders of particular users.
	 * @param userName
	 * @return
	 */
	
	public  List<Cart> getAllPlacedOrders(String userName) {

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rst = null;
		List<Cart> cartItems = new ArrayList<>();

		try {
			// getting the connection
			con = ConnectionUtil.getConnection();
			
			String sql = "select  * from orderReceived where Username=? ";
			st = con.prepareStatement(sql);
            st.setString(1,userName);
			rst = st.executeQuery();
			while (rst.next()) {

			
				String productName= rst.getString("productName");
				
				int producTotal = rst.getInt("productTotal");
				int quantity = rst.getInt("Quantity");
               
				
				Cart cart = new Cart();
				cart.setUsername(userName);
				cart.setProductName(productName);
				cart.setProductTotal(producTotal);
				cart.setQuantity(quantity);
				
				// getting the values in ArrayList
				cartItems.add(cart);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// closing the connection
			ConnectionUtil.close(con, st, rst);

		}
		return cartItems;
		

	}
	@Override
	public List<Product> getAllProducts(List<String> productIds) {

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rst = null;
		List<Product> productsvia = new ArrayList<>();

		try {
			// getting the connection
			con = ConnectionUtil.getConnection();
			String inSql = String.join(",", Collections.nCopies(productIds.size(), "?"));
			String sql = "select * from productInfo where ProductId IN ( " + inSql + ")";
			
			st = con.prepareStatement(sql);

			for (int i = 1; i <= productIds.size(); i++) {
				String productId = ( productIds).get(i - 1);
				st.setString(i, productId);
			}

			rst = st.executeQuery();
			while (rst.next()) {

				String productName = rst.getString("ProductName");
				String productId = rst.getString("ProductId");
				String category = rst.getString("Category");
				int price = rst.getInt("Price");

				String status = rst.getString("Status");
				Product product = new Product();
				product.setProductName(productName);
				product.setProductId(productId);
				product.setCategory(category);
				product.setAmount(price);

				product.setStatus(status);
				// getting the values in ArrayList
				productsvia.add(product);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// closing the connection
			ConnectionUtil.close(con, st, rst);

		}
		return productsvia;

	}
		
	
	
	
	
	

}
