package in.sankarvinoth.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.sankarvinoth.service.CartService;

/**
 * Servlet implementation class EmptyCartServlet
 */
@WebServlet("/EmptyCartServlet")
public class EmptyCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// getting the list of productIds
		List<String> productsids = CartService.getAllProductIds();
		// clearing the list
		productsids.clear();

		session.removeAttribute("productslist");

		response.sendRedirect("Cart.jsp");
	}

}
