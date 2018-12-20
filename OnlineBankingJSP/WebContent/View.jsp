<%@page import="java.util.ArrayList,beans.EmpBean" %>
 <%@include file="Header.jsp" %>
 
 	  <%
 	  String uid=(String)session.getAttribute("uid");
	   %>
	<center><font color=red><h1>Welcome,<%=uid%></h1></font><hr/>
	</center>
 <div class="container">
   
 <table class="table table-bordered">
 <tr><th>Cid</th><th>Name</th><th>Address</th><th>MobileNo</th><th>Emailid</th><th>Accno</th><th>Password</th><th>Balance</th></tr>
 <% 
 ArrayList<EmpBean> list=(ArrayList<EmpBean>)request.getAttribute("LIST");
 
 %>
 
 <%
   for(EmpBean ee:list)
   {
	  %>
   	 <tr>
   	<td> <%=ee.getCid()%> </td>
   	<td> <%=ee.getCname()%> </td>
	<td> <%=ee.getAddress()%> </td>
	 <td><%=ee.getMobile()%> </td>
	 <td><%=ee.getEmail()%> </td>
	 <td><%=ee.getAccno()%> </td>
	 <td><%=ee.getPassword()%> </td>
	 <td><%=ee.getBalance()%> </td>
	 <tr/>
	 <%
	 }
  %>
  </table></div>
  
  
