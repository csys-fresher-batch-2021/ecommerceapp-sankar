package in.sankarvinoth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.sankarvinoth.exceptions.DBException;
import in.sankarvinoth.model.Product;
import in.sankarvinoth.util.connection.ConnectionUtil;

public class ProductsDAOImp implements ProductsDAO {

	/** 
	 * method to get all the products in the database 
	 * this method will return the product details in the form of list
	 */
	public List<Product> getAllProducts() {
		List<Product> availableProducts = new ArrayList<>();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rst = null;
	

		try {
			// getting the connection
			con = ConnectionUtil.getConnection();

			String sql1 = "SELECT ProductName,ProductId,Category,Price,quantity,Status FROM productinfo ORDER BY productname ";
			st = con.prepareStatement(sql1);
			rst = st.executeQuery();

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
				availableProducts.add(product);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// closing the connection
			ConnectionUtil.close(con, st, rst);

		}
		return availableProducts;

		

	}
    


	@Override
	/**
	 * method to get the list of products that is in the database which matches with
	 * the search
	 */
	public List<Product> searchProductByProductId(String productId) throws DBException {
		List<Product> products = new ArrayList<>();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rst = null;

		try {
			// getting the connection
			con = ConnectionUtil.getConnection();
			String sql = "SELECT ProductName,Category,Price,quantity,Status FROM productInfo where ProductId = ?";
			st = con.prepareStatement(sql);
			st.setString(1,productId);

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

		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Product Doesn't exist");
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
	 * @throws DBException 
	 */
	public void updateStock(Product product) throws DBException{
		
		Connection con = null;
		PreparedStatement st = null;
		

		try {

			String productId = product.getProductId();
			String productName = product.getProductName();
			String productCategory = product.getCategory();
			int amount = product.getAmount();
			int quantity = product.getQuantity();
			String status = product.getStatus();
			// getting the connection
			con = ConnectionUtil.getConnection();
			String sql = "UPDATE productInfo SET (productName,Category,Price,quantity,Status) = (?,?,?,?,?)where productId=?";
			st = con.prepareStatement(sql);
			st.setString(1,productName);
			st.setString(2,productCategory);
			st.setInt(3,amount);
			st.setInt(4,quantity);
			st.setString(5,status);
			st.setString(6,productId);
		    st.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("ProductId not exists in the Table");
			
		} finally {
			// closing the connection
			ConnectionUtil.close(con, st);
			}
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
			String sql = "SELECT productname,sum(quantity) FROM placedOrders group by productname";
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

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			// closing the connection
			ConnectionUtil.close(con, st, rst);

		}

	}


	


	



}
