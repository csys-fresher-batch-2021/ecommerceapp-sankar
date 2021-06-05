<%@page import=" java.util.List"%>
<%@page import="in.sankarvinoth.model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<% String username=(String)session.getAttribute("Logged_in_User"); %>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
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
		<input type="hidden" id="username" value="<%=username%>">
		
		<table class="table table-bordered" id="table">
			<caption>Products name along with its serial number</caption>
			<thead>
				<tr>
					<th scope="col">S.no</th>
					<th scope="col">ProductId</th>
					<th scope="col">Product Name</th>
					<th scope="col">Product category</th>
					<th scope="col">Product Price(in Rs.)</th>
					<th scope="col">Product quantity</th>
					<th scope="col">Product Total</th>
					<th scope="col">Service Status</th>
					<th scope="col">Remove</th>
				</tr>

				<%
				List<Product> products = (List<Product>)session.getAttribute("productslist");
				int i = 0;
				
				%>


				<%
				if (products == null) {
					out.println("<tr>No Records</tr>");
				} else {
					for (Product product : products) {
						i++;
						String productId = product.getProductId();
						String productName = product.getProductName();
						String category = product.getCategory();
						int amount = product.getAmount();
						String status = product.getStatus();
				%>
				<tr>
					<td><%=i%></td>
					<td><%=productId%></td>
					<td><%=productName%></td>
					<td><%=category%></td>
					<td><input type="number"  id="amount_<%=productName%>"   readonly value="<%=amount%>" ></td>
					<td><input type="number" id="quantity_<%=productName%>" onchange="productTotal('<%=productName%>','<%=productId%>')" min="1" max="100"></td>
					<td><input type="number" id="producttotal_<%=productName%>" readonly ></td>
					<td><%=status%></td>
					
					<td><a href="RemoveFromCartServlet?Id=<%=productId%>">remove</a></td>


				</tr>
				<%
				}
				}
				%>



			</thead>
		</table>
		<a href="EmptyCartServlet">Empty cart</a>
	
	</main>
	
	Total Price(in Rs.) :<input type="number" name="TotalAmount" id="total" readonly >
	Total Price With  10 % Gst(in Rs.):<input type="number" name="TotalAmountwithgst" id="totalwithgst" readonly >
	<button type="button" class="btn btn-warning" onclick="placeOrder()">Confirm Order</button>
	<script>
	function productTotal(productName,productId) {
		let total = 0;
		
		let price=document.getElementById("amount_" +productName).value;
		let qty=document.getElementById("quantity_"+productName).value;
		let amount = price*qty;
		document.getElementById("producttotal_"+productName).value=amount;
		let obj = {productName:productName, qty: qty , amount : amount,totalCartAmount:totalwithgst,userId:username,totalAmountWithOutGST:total};
		let cartItemStr = localStorage.getItem("CART_ITEMS");
		let items = cartItemStr != null ? JSON.parse(cartItemStr) : [];
		//if productId already exists, remove old record by index.
		let index = items.findIndex(obj=> obj.productName=== productName);
		if(index != -1){
			items.splice(index,1);
		}
		items.push(obj);
		localStorage.setItem("CART_ITEMS", JSON.stringify(items));
		
		for(let item of items){
			total+= item.amount;
		}
		document.getElementById("total").value=total;
		let amountWithGst=((total*10)/100)+total;
		document.getElementById("totalwithgst").value=amountWithGst;
	}
	
	function emptyCart(){
		localStorage.removeItem("CART_ITEMS");
	}
	emptyCart();
	
	function placeOrder() {
		//let userName= (String)session.getAttribute("Logged_in_User");
		let totalAmounts=document.getElementById("total").value;
		let totalCartAmount=document.getElementById("totalwithgst").value;
		let username=document.getElementById("username").value;
		let url="http://localhost:9000/AddOrderServlet";
		let cartItemStr = localStorage.getItem("CART_ITEMS");
		let items = cartItemStr != null ? JSON.parse(cartItemStr) : [];
		
		let data={userId:username,items:items,totalAmount:totalCartAmount,totalAmountWithOutGST:totalAmounts};
		axios.post(url,data).then(res=> {
			console.log(res);
			alert("order placed successfully");
			window.location = "DisplayOrderedItems.jsp";
		});
	}

	</script>
	
	

</body>
</html>