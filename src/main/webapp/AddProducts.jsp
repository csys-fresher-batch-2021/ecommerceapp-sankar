
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="ISO-8859-1">
<title>E-CommerceApp</title>
</head>
<body>
 <jsp:include page="header.jsp"></jsp:include>
 <main class="container-fluid">
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
<form  action="AddProductsServlet" method="post">

<h3>Add Products feature</h3>
<label>ProductName</label>
<input type="text"  name="productName" placeholder="Enter ProductName" required ><br/>
<label>ProductId</label>
<input type="text"  name="productid" placeholder="Enter ProductId" required ><br/>
<label>Category</label>
<input type="text"  name="productcategory" placeholder="Enter product category" required ><br/>
<label>Price of the Product</label>
<input type="number"  name="productPrice" placeholder="Enter ProductPrice" required > <br/>
<label>Quantities available</label>
<input type="number"  name="productquantity" placeholder="Enter no.of.Quantity" min="1" max="500" required > <br/>
<label>Status of product</label>
<input type="text"  name="productstatus" placeholder="available or not available" required > <br/>
<button type="submit" class="btn btn-primary">Add</button>
<a href="homepage.jsp"><input type="button" class="btn btn-danger" value="Cancel"></a>
</form>
<h4>Instruction:</h4>
	<ul>
		<li>Product Id would be the first 3 letters of productname and first 3 letters of category</li> 
	</ul>
</body>
</html>