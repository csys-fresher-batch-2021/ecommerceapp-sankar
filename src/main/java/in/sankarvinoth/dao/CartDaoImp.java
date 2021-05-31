package in.sankarvinoth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import in.sankarvinoth.model.Product;
import in.sankarvinoth.util.connection.ConnectionUtil;

public class CartDaoImp implements CartDao {

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
			System.out.println(sql);
			st = con.prepareStatement(sql);

			for (int i = 1; i <= productIds.size(); i++) {
				String productId = productIds.get(i - 1);
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
