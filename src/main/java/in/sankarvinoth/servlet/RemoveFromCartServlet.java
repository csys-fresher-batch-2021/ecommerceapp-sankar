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

/**
 * Servlet implementation class RemoveFromCartServlet
 */
@WebServlet("/RemoveFromCartServlet")
public class RemoveFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveFromCartServlet() {
		super();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// getting Id from the view cart items page
		String productId = request.getParameter("Id");
		HttpSession session = request.getSession();
		List<Product> products = (List<Product>) session.getAttribute("productslist");
		// method to delete the productId respected product object
		boolean isRemoved = CartService.deleteProductFromCart(products, productId);
        
		if (isRemoved) {
			String message = "Product Removed From cart successfully";
			response.sendRedirect("Cart.jsp?infoMessage=" + message);
		} else {
			String message = "nothing to remove in your cart";
			response.sendRedirect("Cart.jsp?errorMessage=" + message);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
