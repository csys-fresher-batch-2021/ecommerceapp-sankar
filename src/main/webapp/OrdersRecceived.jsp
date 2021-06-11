<%@page import=" java.util.List"%>
<%@page import="in.sankarvinoth.model.Cart"%>
<%@page import="in.sankarvinoth.service.CartService"%>
<%@page import="java.time.format.DateTimeFormatter"%>
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

		<h3>Orders Received</h3>
		<table class="table table-bordered">
			<caption>Orders</caption>
			<thead>
				<tr>
					<th scope="col">S.no</th>

					<th scope="col">ProductName</th>
					<th scope="col">ProductTotal(in Rs.)</th>
					<th scope="col">Quantity</th>
					<th scope="col">Ordered Date</th>
					<th scope="col">Ordered Time</th>

				</tr>

				<%
				List<Cart> cartItems = CartService.getAllOrderedItemsServiceForAdmin();
				int i = 0;
				%>
				<%
				if (cartItems.size() == 0) {
					out.println("<tr><td>No Records</td></tr>");
				} else {
					for (Cart item : cartItems) {
						i++;
						String ProductName = item.getProductName();
						int productTotal = item.getProductTotal();
						int quantity = item.getQuantity();
						String date = item.getOrderPlacedDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
						String time = item.getOrderPlacedTime().format(DateTimeFormatter.ofPattern("HH:mm"));
				%>
				<tr>
					<td><%=i%></td>

					<td><%=ProductName%></td>

					<td><%=productTotal%></td>
					<td><%=quantity%></td>
					<td><%=date%></td>
					<td><%=time%></td>

				</tr>
				<%
				}
				}
				%>
			</thead>
		</table>
	</main>

</body>
</html>

