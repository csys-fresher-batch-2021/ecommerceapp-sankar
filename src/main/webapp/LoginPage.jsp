
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>E-CommerceApp</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid"> </main>
<form>
<h3> User Login</h3>
<label>UserName</label>
<input type="text"  name="username"  placeholder="Enter your Username" pattern ="^[A-Za-z][A-Za-z0-9]{7,12}$" required><br/>
<label>Password</label>
<input type="password"  name="password"  placeholder="Enter your password" pattern ="^[a-zA-Z0-9]{8}$" required><br/>
<button class="btn btn-primary">Register</button>
<button class="btn btn-danger" type="reset">Reset</button>
</form>

</body>
</html>