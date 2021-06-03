package in.sankarvinoth.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import in.sankarvinoth.model.User;
import in.sankarvinoth.service.UserRegistrationservice;
import in.sankarvinoth.util.validator.UserInputsValidator;

/**
 * Servlet implementation class registrationservlet
 */
@WebServlet("/registrationservlet")
public class Registrationservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registrationservlet() {
        super();
       
    }

     @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullName= request.getParameter("fullname");
		String username= request.getParameter("username");
		String email= request.getParameter("email");
		Long  mobileNumber= Long.parseLong(request.getParameter("mobilenumber"));
		String password= request.getParameter("password");
		String confirmPassword= request.getParameter("confirmPassword");
		String securityQuestion=request.getParameter("securityQuestions");
		String securityAnswer=request.getParameter("securityanswer");
		// validating the form values
		boolean isvalidUserInputs=UserInputsValidator.usersInputValidator(fullName,username,email,mobileNumber);
		
		     if(password.equals(confirmPassword) && isvalidUserInputs ) {
			 User user =new User();
			 user.setFullName(fullName);
			 user.setUserName(username);
			 user.setEmail(email);
			 user.setPhoneNumber(mobileNumber);
			 user.setPassword(password);
			 user.setSecurityQuestion(securityQuestion);
			 user.setSecurityAnswer(securityAnswer);
			 boolean isValidRegistration;
			 try {
				isValidRegistration = UserRegistrationservice.userregistrationService(user);
				if(isValidRegistration) {
					 String message="Successfully Registered !!!!";
					 response.sendRedirect("register.jsp?infoMessage="+message);
				 }
				 else {
					 String message="User already Exists";
					 response.sendRedirect("register.jsp?errorMessage="+message);
				 }
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			 
		     }
			 else {
				 String message="Invalid Inputs";
				 response.sendRedirect("register.jsp?errorMessage="+message);
			 }
			 
		     
	}

}
