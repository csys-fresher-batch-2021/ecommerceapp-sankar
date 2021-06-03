<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>E-CommerceApp</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid"></main>
	<%
	String infoMessage = request.getParameter("infoMessage");
	if (infoMessage != null) {
		out.println("<font color='green'>" + infoMessage + "</font>");
	}
	%>
	<%
	String errorMessage = request.getParameter("errorMessage");
	if (errorMessage != null) {
		out.println("<font color ='red'>" + errorMessage + "</font>");
	}
	%>
	<form action="registrationservlet" method="post">
		<h3>User Registration</h3>

		<label>FullName</label> <input type="text" name="fullname"
			placeholder="Enter Fullname" pattern="^[A-Z][A-Za-z]{4,29}$"
			title="Name should be in alphabets"
			title="fullname should be in given format" autofocus required><br />
		<label>UserName</label> <input type="text" name="username"
			placeholder="Enter username" pattern="^[A-Za-z][A-Za-z0-9]{5,12}$"
			title="username should be in given format" required><br /> <label>MobileNumber</label>
		<input type="number" name="mobilenumber" placeholder="Enter phone.no"
			pattern="^[6-9][0-9]{9}$ "
			title="phonenumber should be in given format" required><br />
		<label>E-mail</label> <input type="email" name="email"
			placeholder="Enter your email" required><br /> <label>Password</label>
		<input type="password" name="password" placeholder="Enter password"
			pattern="^[A-Za-z0-9]{5,8}$"
			title="password should be in given format" required><br /> <label>Confirm
			Password</label> <input type="password" name="confirmPassword"
			placeholder="retype password" pattern="^[A-Za-z0-9]{5,8}$"
			title="password should be in given format" required><br />
			Security Question:<select name="securityQuestions">
  <option value="What was the name of your first manager at your first job?">What was the name of your first manager at your first job?</option>
  <option value="What was your favorite subject in high school?">What was your favorite subject in high school?</option>
  <option value="What is your employee ID number?">What is your employee ID number?</option>
  <option value="Where did you go on your favorite vacation as a child?">Where did you go on your favorite vacation as a child?</option>
  <option value="What is the name of the road you grew up on?">What is the name of the road you grew up on?</option>
</select><br/>
<label>SecurityAnswer</label> <input type="text" name="securityanswer"
			placeholder="Enter Security Answer " 
			  required><br />
		<button class="btn btn-primary">Register</button>
		<button class="btn btn-danger" type="reset">Reset</button>
		<h5>
			<a href="LoginPage.jsp">Login</a>
		</h5>
	</form>


</body>
</html>