
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>E-CommerceApp</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid"> </main>
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
<form action="Loginservlet" method ="post">
<h3> User Login</h3>
<label>Username</label>
<input type="text"  name="username"  placeholder="Enter your username" pattern="^[A-Za-z][A-Za-z0-9]{5,12}$"
			title="username should be in valid format"  required><br/>
<label>Password</label>
<input type="password"  name="password"  placeholder="Enter your password" pattern="^[A-Za-z0-9]{5,8}$"
			title="password should be in given format"  required><br/>


<button class="btn btn-primary">Login</button>
<button class="btn btn-danger" type="reset">cancel</button>

<p>Don't have an account ?<a href="register.jsp">  Register</a></p> 
<a href="ForgotPassword.jsp">Forgot password ?</a> 
<p>For admin Credentials use Username : "admin34"  and password="admin"</p>
</form>

</body>
</html>