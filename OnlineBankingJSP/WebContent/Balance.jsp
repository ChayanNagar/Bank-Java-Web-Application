<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.sql.*" %>

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
	<%
     String cname= (String)session.getAttribute("cname");
	 if(uid==null)
		  response.sendRedirect("index.jsp");

	%>
	<%
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/productinf","root","root");
		PreparedStatement ps=con.prepareStatement("select balance from customer where accountno=?");
		ps.setString(1, cname);
		ResultSet rs1=ps.executeQuery();
		while(rs1.next()) {
			out.println("Balance is :"+rs1.getDouble("balance"));
		}
	   
	}catch(Exception e)
	{
		out.println(e);
	}
	
	%>
			
	

</body>
</html>