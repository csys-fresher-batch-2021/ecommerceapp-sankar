package in.sankarvinoth.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.sankarvinoth.model.Product;
import in.sankarvinoth.util.connection.ConnectionUtil;

public class ProductsDaoImp implements ProductsDao {

	
     // method to get list tye products available in the store 
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();
		Connection con = null;
		Statement st = null;
		ResultSet rst = null;
		       

		try {
			// getting the connection
			con = ConnectionUtil.getConnection();

			st = con.createStatement();
			rst = st.executeQuery("select * from productInfo");
			while (rst.next()) {

				String productName = rst.getString("ProductName");
				String productId=rst.getString("ProductId");
				String category=rst.getString("Category");
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
			ConnectionUtil.close(con,st,rst);
			
		}

		return products;

	}

	@Override
	/**
	 *  method to get the list of products that is in the database which matches with the search
	 */
	public List<Product> searchForProduct(String searchedProduct) {
		List<Product> searchProducts = new ArrayList<>();
		Connection con = null;
		Statement st = null;
		ResultSet rst = null;

		try {
			// getting the connection
			con = ConnectionUtil.getConnection();

			st = con.createStatement();
			String sql="select * from productInfo where ProductName ~* '"+searchedProduct+"'  or Category ~* '"+searchedProduct+"'";
			rst = st.executeQuery(sql);
			while (rst.next()) {

				String productName = rst.getString("ProductName");
				String productId=rst.getString("ProductId");
				String category=rst.getString("Category");
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
			ConnectionUtil.close(con,st,rst);
			
		}
		return searchProducts;

		

	}
	


		
	}


