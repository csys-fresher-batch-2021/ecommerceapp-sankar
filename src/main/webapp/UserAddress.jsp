<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>
<meta charset="ISO-8859-1">
<title>E-Commerce App</title>
</head>
<body>
<% String username=(String)session.getAttribute("Logged_in_User");%>
<h3>User Address</h3>
<form action="AddAddressServlet" method ="post">
<input type="hidden" name="username" value="<%=username %>"> 
Address :<input type="text" placeholder="Enter your address" name="address"  title ="address field should not be empty"  autofocus  required><br/>
 
<button type="submit"  class="btn btn-success" >Save</button>
</form>
</body>
</html>