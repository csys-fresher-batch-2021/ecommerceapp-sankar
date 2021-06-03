<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>
<main class="container-fluid"></main>
<meta charset="ISO-8859-1">
<title>E-CommerceApp</title>
</head>
<body>
	<form action="ForgotPasswordServlet" method="post">

		<label>MobileNumber</label> <input type="number" name="mobilenumber"
			placeholder="Enter phone.no" pattern="^[6-9][0-9]{9}$ "
			title="phonenumber should be in given format" required><br />
		your Security Question:<select name="securityQuestions">
			<option
				value="What was the name of your first manager at your first job?">What
				was the name of your first manager at your first job?</option>
			<option value="What was your favorite subject in high school?">What
				was your favorite subject in high school?</option>
			<option value="What is your employee ID number?">What is
				your employee ID number?</option>
			<option
				value="Where did you go on your favorite vacation as a child?">Where
				did you go on your favorite vacation as a child?</option>
			<option value="What is the name of the road you grew up on?">What
				is the name of the road you grew up on?</option>
		</select><br /> <label> your SecurityAnswer:</label> <input type="text"
			name="securityanswer" placeholder="Enter Security Answer " required><br />
		<label> New Password</label> <input type="password" name="password"
			placeholder="Enter New password" pattern="^[A-Za-z0-9]{5,8}$"
			title="password should be in given format" required><br /> <label>Confirm
			Password</label> <input type="password" name="confirmPassword"
			placeholder="retype password" pattern="^[A-Za-z0-9]{5,8}$"
			title="password should be in given format" required><br />
		<button class="btn btn-primary" type="submit">Reset Password</button>
		<button class="btn btn-danger" type="reset">cancel</button>
		<a href="LoginPage.jsp">Login</a>

	</form>

</body>
</html>