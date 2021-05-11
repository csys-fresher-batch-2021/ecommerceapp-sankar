<%@page import="java.util.Map"%>
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

		<table class="table table-bordered">
		<caption>Products name along with  its serial number </caption>
			<thead>
				<tr>
					<th scope="col">S.no</th>
					<th scope="col">Product Name</th>
					<%Map<Integer,String>Products=ProductService.getProducts();
					int i=0;
					for(Integer serialNo:Products.keySet()){
						String productName=Products.get(serialNo);
						i++;
						%>
			      <tr>
			     <td><%=serialNo%></td>
			     <td><%=productName%></td> 
			     </tr>
				 <% } %>
			</thead>
				</table>
	</main>

</body>
</html>