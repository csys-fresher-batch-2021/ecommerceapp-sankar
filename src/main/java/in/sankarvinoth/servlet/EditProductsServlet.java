package in.sankarvinoth.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.sankarvinoth.model.Product;
import in.sankarvinoth.service.EditProductService;

/**
 * Servlet implementation class EditProductsServlet
 */
@WebServlet("/EditProductsServlet")
public class EditProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// getting form values
		String productId = request.getParameter("id");
		String productName = request.getParameter("name");
		String category = request.getParameter("category");
		String status = request.getParameter("pro");
		int price = Integer.parseInt(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("qty"));
		Product product = new Product();
		product.setProductId(productId);
		product.setProductName(productName);
		product.setCategory(category);
		product.setAmount(price);
		product.setQuantity(quantity);
		product.setStatus(status);
		EditProductService.updateProductsService(product);

	}

}
