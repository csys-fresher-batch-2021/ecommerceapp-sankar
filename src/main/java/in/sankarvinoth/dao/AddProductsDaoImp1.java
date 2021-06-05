package in.sankarvinoth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.sankarvinoth.model.Product;
import in.sankarvinoth.util.connection.ConnectionUtil;

public class AddProductsDaoImp1 implements AddProductsDao {

	@Override
	/**
	 * method to insert the products to the table in the database inputs:
	 * productId,productName,category,price,quantity,status
	 */
	public void save(Product product) throws ClassNotFoundException, SQLException {
		String productId = product.getProductId();
		int quantity = product.getQuantity();
		String productName = product.getProductName();
		String category = product.getCategory();
		int price = product.getAmount();
		String status = product.getStatus();
		// getting the connection
		Connection con =    null;
		PreparedStatement pst = null;
		try {
			 con =ConnectionUtil.getConnection();
			String sql = "insert into productInfo(ProductId,ProductName,Category,Price,quantity,Status) values(?,?,?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, productId);
			pst.setString(2, productName);
			pst.setString(3, category);
			pst.setInt(4, price);
			pst.setInt(5, quantity);
			pst.setString(6, status);
			// executing the query
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// closing the connection
			ConnectionUtil.close(con,pst);
			
		}

	}

	@Override
	/**
	 * method to search the product Id and Product category of given product exists
	 * in the database .
	 */
	public List<Product> findProductByProductId(Product product) throws ClassNotFoundException, SQLException {
		String productId = product.getProductId();
		String productName = product.getProductName();
		List<Product> productsInTheStock = new ArrayList<>();
		

// getting the  Connection
		Connection con = null;
		
		ResultSet rs = null;
		PreparedStatement st=null;
		try {
			con = ConnectionUtil.getConnection();
			// query for search operation
			String sql = ("select * from productInfo where ProductId =? and ProductName =? ");
			 st = con.prepareStatement(sql);
			 st.setString(1,productId);
			 st.setString(2,productName);
			// Execute Query
			rs = st.executeQuery();
			while( rs.next()) {
				
				
				Product product1 = new Product();
				product1.setProductName(productName);
				product1.setProductId(productId);
				
				// getting the values in ArrayList
				productsInTheStock.add(product1);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
			e.printStackTrace();

		} finally {
			// closing the connection
			ConnectionUtil.close(con,st,rs);
			

		}
		return productsInTheStock;
		
	}

}
