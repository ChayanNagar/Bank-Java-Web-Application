<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
   
 <body background="images/bg1.jpg">
   <%@include file="Header.jsp" %>
   
   <% 
	  	String uid=(String)session.getAttribute("uid");
        if(uid==null)
	   response.sendRedirect("index.jsp");
	   %>
	<center><font color=red><h1>Welcome,<%=uid %> at Admin Home</h1></font><hr/>
	</center>
</body>
</html>