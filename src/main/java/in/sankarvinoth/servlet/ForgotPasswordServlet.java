package in.sankarvinoth.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.sankarvinoth.model.User;
import in.sankarvinoth.service.ForgotPasswordService;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// getting form values
		Long mobileNumber = Long.parseLong(request.getParameter("mobilenumber"));
		String securityQuestion = request.getParameter("securityQuestions");
		String securityAnswers = request.getParameter("securityanswer");
		String newPassword = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		// checking whether the password and forgot password same
		if (newPassword.equals(confirmPassword)) {
			User user = new User();
			user.setPhoneNumber(mobileNumber);
			user.setPassword(newPassword);
			user.setSecurityQuestion(securityQuestion);
			user.setSecurityAnswer(securityAnswers);
			boolean isUpdated;
			try {
				// checking whether the password updation is done or not
				isUpdated = ForgotPasswordService.userPasswordService(user);
				if (isUpdated) {
					String message = "Successfully updated";
					response.sendRedirect("LoginPage.jsp?infoMessage=" + message);
				} else {
					String message = "Not a Valid Credentials ";
					response.sendRedirect("ForgotPassword.jsp?errorMessage=" + message);
				}
			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			}
		} else {
			String message = "Password Mismatch";
			response.sendRedirect("ForgotPassword.jsp?errorMessage=" + message);
		}

	}
}
