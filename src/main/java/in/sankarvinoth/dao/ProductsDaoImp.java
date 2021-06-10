package in.sankarvinoth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.sankarvinoth.model.Product;
import in.sankarvinoth.util.connection.ConnectionUtil;

public class ProductsDaoImp implements ProductsDao {

	/** 
	 * method to get all the products in the database
	 */
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rst = null;
		String productName = null;

		try {
			// getting the connection
			con = ConnectionUtil.getConnection();

			String sql1 = "SELECT * FROM productinfo ORDER BY productname ";
			st = con.prepareStatement(sql1);
			rst = st.executeQuery();

			while (rst.next()) {

				productName = rst.getString("ProductName");
				String productId = rst.getString("ProductId");
				String category = rst.getString("Category");
				int price = rst.getInt("Price");
				int quantity = rst.getInt("quantity");
				String status = rst.getString("Status");
				Product product = new Product();
				product.setProductName(productName);
				product.setProductId(productId);
				product.setCategory(category);
				product.setAmount(price);
				product.setQuantity(quantity);
				product.setStatus(status);

				// getting the values in ArrayList
				products.add(product);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// closing the connection
			ConnectionUtil.close(con, st, rst);

		}

		return products;

	}
    
	/**
	 * method to get the list of products that is in the database which matches with
	 * the search
	 */
	@Override
	
	public List<Product> searchForProduct(String searchedProduct) {
		List<Product> searchProducts = new ArrayList<>();
		Connection con = null;
		Statement st = null;
		ResultSet rst = null;

		try {
			// getting the connection
			con = ConnectionUtil.getConnection();

			st = con.createStatement();
			String sql = "select * from productInfo where ProductName ~* '" + searchedProduct + "'  or Category ~* '"
					+ searchedProduct + "'";
			rst = st.executeQuery(sql);
			while (rst.next()) {

				String productName = rst.getString("ProductName");
				String productId = rst.getString("ProductId");
				String category = rst.getString("Category");
				int price = rst.getInt("Price");
				int quantity = rst.getInt("quantity");
				String status = rst.getString("Status");
				Product product = new Product();
				product.setProductName(productName);
				product.setProductId(productId);
				product.setCategory(category);
				product.setAmount(price);
				product.setQuantity(quantity);
				product.setStatus(status);
				// getting the values in ArrayList
				searchProducts.add(product);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// closing the connection
			ConnectionUtil.close(con, st, rst);

		}
		return searchProducts;

	}

	@Override
	/**
	 * method to get the list of products that is in the database which matches with
	 * the search
	 */
	public List<Product> searchProductByProductId(String productId) {
		List<Product> products = new ArrayList<>();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rst = null;

		try {
			// getting the connection
			con = ConnectionUtil.getConnection();
			String sql = "select * from productInfo where ProductId = '" + productId + "'";
			st = con.prepareStatement(sql);

			rst = st.executeQuery();
			while (rst.next()) {

				String productName = rst.getString("ProductName");

				String category = rst.getString("Category");
				int price = rst.getInt("Price");
				int quantity = rst.getInt("quantity");
				String status = rst.getString("Status");
				Product product = new Product();
				product.setProductName(productName);
				product.setProductId(productId);
				product.setCategory(category);
				product.setAmount(price);
				product.setQuantity(quantity);
				product.setStatus(status);
				// getting the values in ArrayList
				products.add(product);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// closing the connection
			ConnectionUtil.close(con, st, rst);

		}
		return products;

	}

	@Override
	/**
	 * method to update the data depends upon the changes in the corresponding
	 * fields
	 */
	public List<Product> updateStock(Product product) {
		List<Product> products = new ArrayList<>();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rst = null;

		try {

			String productId = product.getProductId();
			String productName = product.getProductName();
			String productCategory = product.getCategory();
			int amount = product.getAmount();
			int quantity = product.getQuantity();
			String status = product.getStatus();
			// getting the connection
			con = ConnectionUtil.getConnection();
			String sql = "update productInfo set productName='" + productName + "',Category='" + productCategory
					+ "',Price='" + amount + "',quantity='" + quantity + "',Status='" + status + "' where productId='"
					+ productId + "'";
			st = con.prepareStatement(sql);

			rst = st.executeQuery();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// closing the connection
			ConnectionUtil.close(con, st, rst);

		}
		return products;

	}

	@Override
	public void updateQuantity() {
		List<Product> productsQuantity = new ArrayList<>();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rst = null;

		try {

			// getting the connection
			con = ConnectionUtil.getConnection();
			String sql = "select productname,sum(quantity) from placedOrders group by productname";
			st = con.prepareStatement(sql);

			rst = st.executeQuery();
			while (rst.next()) {
				String productName = rst.getString("productname");
				int productQunatity = rst.getInt("sum");
				Product product = new Product();
				product.setProductName(productName);
				product.setQuantitiesSold(productQunatity);
				productsQuantity.add(product);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// closing the connection
			ConnectionUtil.close(con, st, rst);

		}

	}

}
