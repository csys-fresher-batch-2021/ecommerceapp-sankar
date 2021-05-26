package in.sankarvinoth.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.jar.Attributes.Name;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.sankarvinoth.dao.UserRegisterDao;
import in.sankarvinoth.model.User;
import in.sankarvinoth.service.UserRegistrationService;
import in.sankarvinoth.util.validator.IsPasswordSame;
import in.sankarvinoth.util.validator.UserInputValidator;
import in.sankarvinoth.util.validator.UserValidator;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fullname = request.getParameter("fullname");
		String username = request.getParameter("username");
		long phonenumber = Long.parseLong(request.getParameter("number"));
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		User user = new User();
		user.setFullName(fullname);
		user.setPhoneNumber(phonenumber);
		user.setUserName(username);
		user.setPassword(password);
		user.setPassword(confirmPassword);
		// checking whether the user is already registered
	
		boolean isAdded = UserRegistrationService.addUserToUserRegister(user);
        if(isAdded) {
		  {
			response.sendRedirect("LoginPage.jsp");
		 }
       }
		else {
			String message = "Invalid credentials";
			response.sendRedirect("register.jsp?errorMessage=" + message);

		}
	}
}
	
