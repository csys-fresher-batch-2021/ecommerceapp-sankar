<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/style.css">
<%   String  LoggedUser= (String)session.getAttribute("Logged_in_User");
%>

<header>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
  <a class="navbar-brand" href="#">E-CommerceApp</a>
  <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
      aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavId">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Home<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="ListProducts.jsp">Products</a>
      </li>
     <%  if(LoggedUser!=null && LoggedUser.equals("admin34"))  { %> 
      <li class="nav-item">
        <a class="nav-link" href="AdminMessages.jsp">Message Received</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="AddProducts.jsp">Add Products</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="DisplayOrderedItems.jsp">Orders Received</a>
      </li>
     <%  }
       else if(LoggedUser!=null){ %> 
      <li class="nav-item">
        <a class="nav-link" href="CustomerEnquiries.jsp">Message us</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="Cart.jsp">Cart</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="DisplayOrderedItems.jsp">My Orders</a>
      </li>
     <%  }%>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
        <div class="dropdown-menu" aria-labelledby="dropdownId">
          <a class="dropdown-item" href="#">Action 1</a>
          <a class="dropdown-item" href="#">Action 2</a>
        </div>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="Cart.jsp">Cart</a>
      </li>
     
    </ul>
     <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
     <% if (LoggedUser==null) { %>
      <li class="nav-item active">
        <a class="nav-link" href="LoginPage.jsp">Login</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="register.jsp">Register</a>
      </li>
      <% }  else {%>
      <li class="nav-item">
        <a class="nav-link" href="#">Welcome  <%=LoggedUser%></a>
       
      </li>
       <li class="nav-item">
        <a class="nav-link" href="LogoutServlet">Logout</a>
       
      </li>
      <%} %>
      </ul>
   
  </div>
</nav>
</header>