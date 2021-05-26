<!DOCTYPE html>
<html lang="en">
<head>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
<title>E-CommerceApp</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<h3>Products  Available in our shop</h3>
	<table class="table	table-bordered">
		<caption>product details</caption>
		<thead>
			<tr>
			    <th scope="col">S.no</th>
				<th scope="col">ProductName</th>
				<th scope="col">Price(in.Rs)</th>
				<th scope="col">Quantity</th>
				<th scope="col">Service Status</th>
				
			</tr>
		</thead>
		<tbody id="productlist">
		</tbody>


	</table>
    <script>
	function getAllDetails(){
	
	let url ="DisplayProductsServlet";
	fetch(url).then(res=>res.json()).then(res=>{
		
		let products = res;		
		let productDetails = "";
		let i=0;
		for(let product of products){
			    
			productDetails += "<tr><td>" +(++i)+ "</td><td>" + product.productName + "</td><td>" +product.amount +"</td><td>"+product.quantity+"</td><td>"+product.status+"</td></tr>";
		}
		
		document.querySelector("#productlist").innerHTML =productDetails ;
	})
	
	}
getAllDetails();
	
	</script>
</body>
</html>
