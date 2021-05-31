
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
<input type="text"  name="username"  placeholder="Enter your username"  required><br/>
<label>Password</label>
<input type="password"  name="password"  placeholder="Enter your password"  required><br/>


<button class="btn btn-primary">Login</button>
<button class="btn btn-danger" type="reset">cancel</button>

<p>Don't have an account ?<a href="register.jsp">  Register</a></p> 
</form>

</body>
</html>