<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@include file="Headercust.jsp" %>

<% 
	  	String uid=(String)session.getAttribute("cname");
       if(uid==null)
	  response.sendRedirect("index.jsp");
	   %>
	  <center>
	  <font color=red>
	   
	<h1>Welcome,<%=uid%> at Home Page</h1>
	</font>
	<hr/>
	</center>

</body>
</html>