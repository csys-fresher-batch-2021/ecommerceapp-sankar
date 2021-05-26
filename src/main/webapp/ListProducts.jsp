<%@page import=" java.util.List" %>
<%@page import ="in.sankarvinoth.model.Product" %>
<%@page import="in.sankarvinoth.service.DisplayProductService"%>

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

		<table class="table table-bordered">
		<caption>Products name along with  its serial number </caption>
			<thead>
				<tr>
					<th scope="col">S.no</th>
					<th scope="col">Product Name</th>
					<th scope ="col">Product Price(in Rs.)</th>
					<th scope ="col">Product quantity</th>
					<th scope ="col">Service Status</th>
					<% List<Product> products=DisplayProductService.getAllProductsfromDb();
					 int  i=0;
					for(Product product:products){
						i++;
						String productName=product.getProductName();
						int amount=product.getAmount();
						int quantity=product.getQuantity();
						String status=product.getStatus();
						%>
			      <tr>
			     <td><%=i%></td>
			     <td><%=productName%></td> 
			      <td><%=amount%></td>
			      <td><%=quantity%></td>
			       <td><%=status%></td>
			     </tr>
				 <% } %>
			</thead>
				</table>
	</main>

</body>
</html>