<%@page import=" java.util.List" %>
<%@page import ="in.sankarvinoth.model.Product" %>
<%@page import="in.sankarvinoth.service.ProductService"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>E-CommerceApp</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Products available in our shops</h3>
		        <form  action ="SearchProducts.jsp" method="post">
		      <input class="form-control me-2" type="search"  name="searchedProduct" placeholder="Search  for products,brands and more" required>
              <button type="submit" value="search" class="btn btn-outline-success">Search</button>
          </form>
		

		<table class="table table-bordered">
		<caption>Products name along with  its serial number </caption>
			<thead>
				<tr>
					<th scope="col">S.no</th>
					<th scope="col">Product Id</th>
					<th scope="col">Product Name</th>
					<th scope="col">Product category</th>
					<th scope ="col">Product Price(in Rs.)</th>
					<th scope ="col">Product quantity</th>
					<th scope ="col">Service Status</th>
					<th scope ="col">Order Here</th>
					</tr>
				 
					<% List<Product> products=ProductService.getAllProductsfromDb();
					 int  i=0;
		    		  %>
		    		  
		    		  
		    		 <% if (products.size() == 0){ 
		    			 out.println("<tr><td>No Records</td></tr>");
		    		 }else{
					for(Product product:products){
						i++;
						String  productId=product.getProductId();
						String productName=product.getProductName();
						String category=product.getCategory();
						int amount=product.getAmount();
						int quantity=product.getQuantity();
						String status=product.getStatus();
						%>
			     <tr>
			     <td><%=i%></td>
			     <td><%=productId%></td>
			      <td><%=productName%></td>
			      <td><%=category%></td>
			      <td><%=amount%></td>
			      <td><%=quantity%></td>
			       <td><%=status%></td>
			        <td><a href="" >Add to Cart</a></td>
			        </tr>
				 <% }
					} %>
				
				 
				 
			</thead>
				</table>
	</main>

</body>
</html>
 
  