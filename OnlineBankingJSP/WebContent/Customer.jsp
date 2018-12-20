<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <%@include file="Header.jsp" %>
   <body background="images/bg1.jpg">
       <% 
	  	String uid=(String)session.getAttribute("uid");
	   %>
	<center><font color=red><h1>Welcome,<%=uid%></h1></font><hr/>
	
	</center>
	
<% String m=(String)request.getAttribute("msg"); 
    if(m!=null)
    {
  %>	
	<div class="alert alert-success alert-dismissible">
  <strong><%=m%></strong> 
</div>
<%
}
    %>


	<div class="container">
	<div class="col-sm-3">
    <form action="./CustInsert" method="post">
 
  <div class="form-group">
    <label for="Name">Cname:</label>
    <input type="text" class="form-control" name="name" id="name">
  </div>
 
  <div class="form-group">
    <label for="address">CAddress:</label>
     <textarea name="address" class="form-control" ></textarea>
     </div>
 
  <div class="form-group">
    <label for="Mobile No">Mobile No:</label>
    <input type="text" class="form-control" name="mobile" id="Mobile No.">
  </div>
 
  <div class="form-group">
    <label for="email">Email Id:</label>
   <input type="text" class="form-control" id="email" name="email" />
  </div>
  
  <div class="form-group">
    <label for="accno">Account No:</label>
   <input type="text" class="form-control" id="accno" name="account" />
  </div>
  
   <div class="form-group">
    <label for="password">Password:</label>
   <input type="password" class="form-control" id="password" name="cpassword" />
  </div>
  
   <div class="form-group">
    <label for="balance">Balance:</label>
   <input type="text" class="form-control" id="balance" name="bal" />
  </div>
  
  <button type="submit" class="btn btn-default">Submit</button>
</form>
</div>
</div>
	
</body>
</html>