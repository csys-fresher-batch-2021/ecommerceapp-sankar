package in.sankarvinoth.servlet;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import in.sankarvinoth.model.Product;
import in.sankarvinoth.service.AddProductsService;



/**
 * Servlet implementation class AddProductsServlet
 */
@WebServlet("/AddProductsServlet")
public class AddProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProductsServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// getting all the form data
	    String productId = request.getParameter("productid");
		int quantity = Integer.parseInt(request.getParameter("productquantity"));
		String productName = request.getParameter("productName");
		String productCategory = request.getParameter("productcategory");
		int productPrice = Integer.parseInt(request.getParameter("productPrice"));
		String availableStatus = request.getParameter("productstatus");

		Product product = new Product();
		product.setProductName(productName);
		product.setCategory(productCategory);
		product.setAmount(productPrice );
		product.setStatus(availableStatus);
		product.setProductId(productId);
		product.setQuantity(quantity);
		try {
			// validating the product already exists in the database 
			if(AddProductsService.addProductService(product)) {
				String message = "Product added Successfully";
				response.sendRedirect("ListProducts.jsp?infoMessage=" + message);
			} 
			else {
				String message = "Product already exists";
				response.sendRedirect("AddProducts.jsp?errorMessage=" + message);
			}
		} catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
            
		}
	}

	
}
