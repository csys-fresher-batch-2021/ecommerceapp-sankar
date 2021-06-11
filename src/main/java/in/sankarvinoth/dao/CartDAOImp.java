package in.sankarvinoth.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import in.sankarvinoth.exceptions.DBException;
import in.sankarvinoth.model.Cart;
import in.sankarvinoth.model.Product;
import in.sankarvinoth.util.connection.ConnectionUtil;

public class CartDAOImp implements CartDAO {
	/**
	 * method to get all the placed orders of particular users.
	 * 
	 * @param userName
	 * @return
	 * @throws DBException
	 */
	public List<Cart> getAllPlacedOrdersForUser(String userName) throws DBException {

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rst = null;
		List<Cart> cartItems = new ArrayList<>();
		String productName = null;
		int quantity = 0;

		try {
			// getting the connection
			con = ConnectionUtil.getConnection();
			String sql = "SELECT productName,productTotal,quantity,orderedDate,orderedTime FROM placedOrders where Username=? ";
			st = con.prepareStatement(sql);
			st.setString(1, userName);
			rst = st.executeQuery();
			while (rst.next()) {
				productName = rst.getString("productName");
				int producTotal = rst.getInt("productTotal");
				quantity = rst.getInt("Quantity");
				Date date = rst.getDate("orderedDate");
				Time time = rst.getTime("orderedTime");

				Cart cart = new Cart();
				cart.setUsername(userName);
				cart.setProductName(productName);
				cart.setProductTotal(producTotal);
				cart.setQuantity(quantity);
				cart.setOrderPlacedDate(date.toLocalDate());
				cart.setOrderPlacedTime(time.toLocalTime());

				// storing the values in ArrayList
				cartItems.add(cart);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("User doesn't exists");
		} finally {
			// closing the connection
			ConnectionUtil.close(con, st, rst);

		}
		return cartItems;

	}

	/**
	 * method to get all the orders by customers
	 */

	public List<Cart> getAllPlacedOrdersForAdmin() {

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rst = null;
		List<Cart> cartItems = new ArrayList<>();

		try {
			// getting the connection
			con = ConnectionUtil.getConnection();

	       String sql = "SELECT userName,productName,productTotal,quantity,orderedDate,orderedTime FROM placedOrders ORDER BY  ordereddate desc";
			st = con.prepareStatement(sql);
			rst = st.executeQuery();
			while (rst.next()) {

				String username = rst.getString("userName");
				String productName = rst.getString("productName");
				int producTotal = rst.getInt("productTotal");
				int quantity = rst.getInt("Quantity");
				Date date = rst.getDate("orderedDate");
				Time time = rst.getTime("orderedTime");

				Cart cart = new Cart();
				cart.setUsername(username);
				cart.setProductName(productName);
				cart.setProductTotal(producTotal);
				cart.setQuantity(quantity);
				cart.setOrderPlacedDate(date.toLocalDate());
				cart.setOrderPlacedTime(time.toLocalTime());

				// getting the values in ArrayList
				cartItems.add(cart);
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// closing the connection
			ConnectionUtil.close(con, st, rst);

		}
		return cartItems;

	}

	@Override
	/**
	 * this method will returns the productdetails which are maps with list of
	 * productId's in the arraylist
	 */
	public List<Product> getAllProducts(List<String> productIds) {

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rst = null;
		List<Product> products = new ArrayList<>();

		try {
			// getting the connection
			con = ConnectionUtil.getConnection();
			String inSql = String.join(",", Collections.nCopies(productIds.size(), "?"));
			String sql = "SELECT ProductName,ProductId,Category,Price,Status FROM productInfo where ProductId IN ( " + inSql + ")";

			st = con.prepareStatement(sql);

			for (int i = 1; i <= productIds.size(); i++) {
				String productId = (productIds).get(i - 1);
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

}
