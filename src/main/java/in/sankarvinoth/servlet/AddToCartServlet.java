package in.sankarvinoth.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.sankarvinoth.model.Product;
import in.sankarvinoth.service.CartService;
import in.sankarvinoth.util.validator.RepeatedProductsValidator;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// getting the productId from jsp
		String productId = request.getParameter("Id");
		// passing the productids to the the arrylist to store the productids
		CartService.setAllProductIds(productId);
		// getting all the products Ids from the arraylist
		List<String> productsavailable = CartService.getAllProductIds();

		List<Product> products = CartService.addProductToCartService(productsavailable);
		HttpSession session = request.getSession();
		// storing the list in the session
		session.setAttribute("productslist", products);
		if (RepeatedProductsValidator.isNewProductTocart(productId)) {
			String message = "successfully added to cart";
			response.sendRedirect("ListProducts.jsp?infoMessage=" + message);
		} else {
			String message = "Product already in the cart";
			response.sendRedirect("ListProducts.jsp?errorMessage=" + message);
		}

	}

}
