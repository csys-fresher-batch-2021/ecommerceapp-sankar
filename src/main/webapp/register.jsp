

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
	<form action="RegisterServlet" method="post">
	    <h3> User Registration</h3>
		<label>FullName</label> <input type="text" name="fullname"
			placeholder="Enter Fullname" size="30"
			pattern="^[A-Z][A-Za-z]{4,29}$" title="Name should be in alphabets"
			title="fullname should be in given format" autofocus required><br />
		<label>UserName</label> <input type="text" name="username"
			placeholder="Enter username" pattern="^[a-z][a-z0-9]{5,12}$"
			size="13" title="username should be in given format" required><br />

		<label>Phone.no</label> <input type="number" name="number"
			placeholder="Enter phone.no" pattern="^[6-9][0-9]{9}$ " size="10"
			title="phonenumber should be in given format" required><br />

		<label>Password</label> <input type="password" name="password"
			placeholder="Enter password" pattern="^[a-z][a-z0-9]{5,7}$" size="12"
			title="password should be in given format" required><br /> <label>Confirm
			Password</label>l <input type="password" name="confirmPassword"
			placeholder="retype password" pattern="^[a-z][a-z0-9]{5,7}$"
			size="12" title="password should be in given format" required><br />
      	<button class="btn btn-primary">Register</button>
		<button class="btn btn-danger" type="reset">Reset</button>
     </form>
	
		<h3>Instructions:</h3>
		<ol>
		<li>fullname should be in alphabets only,should not contain spaces</li>
		<li>minimum and maximum length for fullname (5-30)</li>
		<li>username should be in alphanumeric only,should not contain
			spaces,but captital letters are not allowed</li>
		<li>minimum and maximum length for fullname (6-13)</li>
		<li>password and confirm password should be in alphanumeric
			only,should not contain spaces,but captital letters are not allowed</li>
		<li>minimum and maximum length for fullname (6-13)</li>
		</ol>
</body>
</html>