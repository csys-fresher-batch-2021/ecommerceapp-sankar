package in.sankarvinoth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.sankarvinoth.model.Product;
import in.sankarvinoth.util.Connection.ConnectionUtil;

public class DisplayProductsDaoImp implements DisplayProductsDao {

	static DisplayProductsDao dao = new DisplayProductsDaoImp();

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
				int price = rst.getInt("Price");
				int quantity = rst.getInt("quantity");
				String status = rst.getString("Status");
				Product product = new Product();
				product.setProductName(productName);
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
			ConnectionUtil.close(con);
			ConnectionUtil.close(rst);
		}

		return products;

	}

}
