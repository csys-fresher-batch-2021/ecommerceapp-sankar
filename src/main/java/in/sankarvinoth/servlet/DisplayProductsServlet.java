package in.sankarvinoth.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import in.sankarvinoth.model.Product;

import in.sankarvinoth.service.ProductService;

/**
 * Servlet implementation class DisplayProductsServlet
 */
@WebServlet("/DisplayProductsServlet")
public class DisplayProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayProductsServlet() {
		super();

	}
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// calling the service class to get all products List
	    
		
		
		 List<Product> products = ProductService.getAllProductsfromDb();
		Gson gson = new Gson();
		// converting the list to JSON
		String json = gson.toJson(products);
		// Writing JSon response
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
	}

}
