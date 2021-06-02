<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="in.sankarvinoth.model.Product"%>
    <%@page import="in.sankarvinoth.service.EditProductService"%>
    <%@page import=" java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>E-commerceApp</title>
</head>

<jsp:include page="header.jsp"></jsp:include>
<body>
<form action="EditProductsServlet" method="post">
 <% String productId= request.getParameter("Id"); %>
<% List<Product> productsDetails=EditProductService.getSearchResults(productId);
String productName=null;
String category=null;
int amount=0;
int quantity=0;
String status=null;
for(Product product:productsDetails){
	
	
	 productName=product.getProductName();
	 category=product.getCategory();
	amount=product.getAmount();
	quantity=product.getQuantity();
   status=product.getStatus();
}
    

%>
<h3>Edit Product </h3>
 ProductId:<input type="text" placeholder="Enter productId" name="id"  title ="ProductId field should not be empty" value="<%=productId%>" readonly required><br/>
 Product Name:<input type="text" placeholder="Enter productname" name="name"  title ="Productname field should not be empty" value="<%=productName%>" required><br/>
 product category:<input type="text" placeholder="Enter product category" name="category"   title ="ProductCategory field should not be empty " value="<%=category%>"  required><br/>
 productPrice:<input type="number" placeholder="Enter product price" name="price"  title ="Product price field should not be empty"  value="<%=amount%>" required><br/>
 product quantity:<input type="number" placeholder="Enter productQuantity" name="qty"  title ="ProductQuantity field should not be empty"  value="<%=quantity%>" required><br/>
   Product available status<select name="pro">
  <option value="available">available</option>
  <option value="not available">not available</option>
 
</select >
 <button type="submit"  class="btn btn-success" >Save</button>
 </form>
 
</body>
</html>