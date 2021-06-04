<%@page import=" java.util.List" %>
<%@page import ="in.sankarvinoth.model.Customer" %>
<%@page import="in.sankarvinoth.service.CustomerService"%>
<%@page import=" java.time.LocalDate" %>
<%@page import=" java.time.LocalTime" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<% String User=(String)request.getAttribute("Logged_in_User"); %>
	
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>E-CommerceApp</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	
		<h3>Received Messages</h3>
		        
		

		<table class="table table-bordered">
		<caption>Messages</caption>
			<thead>
				<tr>
					<th scope="col">S.no</th>
					<th scope="col">UserName</th>
					<th scope="col">Subject</th>
					<th scope="col">Messages or Issues</th>
					<th scope="col">Received Date</th>
					<th scope="col">Received Time</th>
					
					</tr>
				 
					<% List<Customer> messages=CustomerService.getAllMessagesService();
					 int  i=0;
		    		  %>
		    		  
		    		  
		    		 <% if (messages.size() == 0){ 
		    			 out.println("<tr><td>No Records</td></tr>");
		    		 }else{
					for(Customer message:messages){
						i++;
						String UserName=message.getUserName();
						String subject=message.getSubject();
						String receivedMessages=message.getMessage();
						LocalDate  date=message.getDate();
						LocalTime  time=message.getTime();
						
						
						%>
			     <tr>
			     <td><%=i%></td>
			     <td><%=UserName%></td>
			      <td><%=subject%></td>
			     
			      <td><%=receivedMessages%></td>
			      <td><%=date%></td>
			       <td><%=time%></td>
			      
			       
			       
			       
			        	
			       
			       
			        </tr>
				 <% }
					} %>
				
				 
				 
			</thead>
				</table>
				
			
	</main>

</body>
</html>
 
  