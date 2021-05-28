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
			title="username should be in given format" required><br /> 
			<label>MobileNumber</label>
		<input type="number" name="mobilenumber" placeholder="Enter phone.no"
			pattern="^[6-9][0-9]{9}$ "
			title="phonenumber should be in given format" required><br />
		<label>E-mail</label> <input type="email" name="email"
			placeholder="Enter your email" required><br /> <label>Password</label>
		<input type="password" name="password" placeholder="Enter password"
			pattern="^[A-Za-z0-9]{5,8}$"
			title="password should be in given format" required><br /> 
			<label>Confirm
			Password</label>
			<input type="password" name="confirmPassword"
			placeholder="retype password" pattern="^[A-Za-z0-9]{5,8}$"
			title="password should be in given format" required><br />
		<button class="btn btn-primary">Register</button>
		<button class="btn btn-danger" type="reset">Reset</button>
		<h5><a href="LoginPage.jsp">Login</a></h5>
	</form>

	<h3>Instructions:</h3>
	<ol>
		<li>fullname should be in alphabets only,should not contain
			spaces.</li>
		<li>minimum and maximum length for fullname (5-30).</li>
		<li>username should be in alphanumeric only,should not contain
			spaces.</li>
		<li>minimum and maximum length for username (6-13).</li>
		<li>password and confirm password should be in alphanumeric
			only,should not contain spaces.</li>
		<li>minimum and maximum length for password(6-8).</li>
	</ol>
</body>
</html>