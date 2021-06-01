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
		String productId = request.getParameter("Id");
		boolean isNewProductId = RepeatedProductsValidator.isNewProductTocart(productId);
		//validating whether the productId is new to the arraylist;
		if (!isNewProductId) {
			List<String> productsIds = CartService.getAllProductIds(productId);
			List<Product> products = CartService.addProductToCartService(productsIds);
			HttpSession session = request.getSession();
			// storing the list in the session
			session.setAttribute("productslist", products);
			String message = "successfully added to cart";
			response.sendRedirect("ListProducts.jsp?infoMessage=" + message);
		} else {
			String message = "Product already added to cart";
			response.sendRedirect("ListProducts.jsp?errorMessage=" + message);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
