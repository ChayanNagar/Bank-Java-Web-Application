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
	<form action=Trans method=post ><pre>
	<center><h1>Transcation Page</h1><hr>
      <input type=hidden name=sender value="<%=uid%>" />
	Reciever Account No.: <input type=text name=receiver placeholder=EnterRxAccNo required><br>
	Amount to be transfer: <input type=text name=amount placeholder=EnterAmount required><br>
	   <input type=submit Value=Proceed />
		</pre></form></center>	
	
      <% String msg= (String)request.getAttribute("msg");
           %>
</body>
</html>