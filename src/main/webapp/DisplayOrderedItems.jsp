<%@page import=" java.util.List" %>
<%@page import ="in.sankarvinoth.model.Cart" %>
<%@page import="in.sankarvinoth.service.CartService"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<% String userName=(String)request.getAttribute("Logged_in_User"); %>
	
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>E-CommerceApp</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	
		<h3>Your Orders</h3>
		        
		

		<table class="table table-bordered">
		<caption>Orders</caption>
			<thead>
				<tr>
					<th scope="col">S.no</th>
					<th scope="col">UserName</th>
					<th scope="col">ProductName</th>
					<th scope="col">ProductTotal(in Rs.)</th>
					<th scope="col">Quantity</th>
					
					
					</tr>
				 
					<% List<Cart> cartItems=CartService.getAllOrderedItemsService(userName);
					 int  i=0;
		    		  %>
		    		  
		    		  
		    		 <% if (cartItems.size() == 0){ 
		    			 out.println("<tr><td>No Records</td></tr>");
		    		 }else{
					for(Cart item:cartItems){
						i++;
						String UserName=item.getUsername();
						String ProductName=item.getProductName();
						int productTotal=item.getProductTotal();
						int quantity=item.getQuantity();
						
						
						%>
			     <tr>
			     <td><%=i%></td>
			     <td><%=UserName%></td>
			      <td><%=ProductName%></td>
			     
			      <td><%=productTotal%></td>
			       <td><%=quantity%></td>
			        </tr>
				 <% }
					} %>
				
				 
				 
			</thead>
				</table>
				
			
	</main>

</body>
</html>
 
