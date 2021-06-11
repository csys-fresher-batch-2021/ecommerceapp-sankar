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
		<form action="AddProductsServlet" method="post">
			<h3>Add Products</h3>
			<label>ProductName</label> 
			<input type="text" name="productName"
				placeholder="Enter ProductName" pattern="^[A-Za-z_][A-Za-z0-9_ ]{4,56}$"
				title="ProductName should contains alphabets only" required><br/> 
				<label>ProductId</label>
			<input type="text" name="productid" placeholder="Enter ProductId"
				pattern="^[A-Z0-9]{4,20}$"
				title="ProductId should be in both alphabets and Capitals" required><br />
			<label>Category</label> 
			<input type="text" name="productcategory"
				placeholder="Enter product category"
				pattern="^[A-Za-z]{4,20}$"
				title="ProductCategory should be in alphabets" required><br />
			 <label>Price of the Product</label> <input type="number"
				name="productPrice" placeholder="Enter ProductPrice" min="1"
				max="100000000" pattern="^[0-100000000]{1,7}$"
				title="ProductPrice should be in numbers"
				required> <br /> 
				<label>Quantities available</label> 
				<input type="number" name="productquantity"
				placeholder="Enter no.of.Quantity" min="1" max="500"
				pattern="^[0-500]{1,3}$"
				title="ProductQuantity should be in numbers and not greater than 500 and not less than 1"
				required> <br /> 
				<label>Status of product</label> 
				<select name="productstatus">
				<option value="available">available</option>
				<option value="not available">not available</option>
			</select><br />

			<button type="submit" class="btn btn-primary">Add</button>
			<button type="reset" class="btn btn-danger" value="Cancel">Cancel</button>
		</form>
		<h4>Instruction:</h4>
		<ul>
			<li>Product Id would be the first 3 letters of productname and
				first 3 letters of category and if more than one versions in one
				product means need to specify version number (for exmaple: Apple7s
				Product Id would be like <strong>APPELE7s</strong>
			</li>
		</ul>
</body>
</html>