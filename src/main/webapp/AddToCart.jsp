<%@page import=" java.util.List" %>
<%@page import ="in.sankarvinoth.model.Product" %>


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
		<h3>User Cart</h3>
		        
		

		<table class="table table-bordered">
		<caption>Products name along with  its serial number </caption>
			<thead>
				<tr>
					<th scope="col">S.no</th>
					
					<th scope="col">Product Name</th>
					<th scope="col">Product category</th>
					<th scope ="col">Product Price(in Rs.)</th>
					<th scope ="col">Product quantity</th>
					<th scope ="col">Service Status</th>
					<th scope ="col">Remove</th>
					</tr>
				 
					<% List<Product> products= (List<Product>)session.getAttribute("productslist");
					 int  i=0;
					 int quantity=1;
		    		  %>
		    		  
		    		  
		    		 <% if (products==null){ 
		    			 out.println("<tr>No Records</tr>");
		    		 }else{
					for(Product product:products){
						i++;
						String productId=product.getProductId();
						String productName=product.getProductName();
						String category=product.getCategory();
						int amount=product.getAmount();
						
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
			        <td>remove</td>
			   
			       
			        </tr>
				 <% }
					} %>
				
				 
				 
			</thead>
				</table>
				
				
	</main>

</body>
</html>
 
 



