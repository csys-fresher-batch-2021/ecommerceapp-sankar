package in.sankarvinoth.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import in.sankarvinoth.model.Analytics;

import in.sankarvinoth.util.connection.ConnectionUtil;

public class AnalyticsDAO{

	public AnalyticsDAO() {

	}

	/**
	 * method to for productsold vs Productname analysis this method will calculate
	 * the total number of products sold in individual product
	 * 
	 * @return
	 */
	public List<Analytics> getAllPlacedOrders() {

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rst = null;
		List<Analytics> SoldItems = new ArrayList<>();

		try {
			// getting the connection
			con = ConnectionUtil.getConnection();

			String sql = "select productName, sum(quantity) from placedOrders group by productName";
			st = con.prepareStatement(sql);

			rst = st.executeQuery();
			while (rst.next()) {

				String productName = rst.getString("productName");

				int quantitiesSold = rst.getInt("sum");

				Analytics soldItems = new Analytics();

				soldItems.setProductName(productName);
				soldItems.setQuantitiesSold(quantitiesSold);

				// getting the values in ArrayList
				SoldItems.add(soldItems);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// closing the connection
			ConnectionUtil.close(con, st, rst);

		}
		return SoldItems;

	}

}