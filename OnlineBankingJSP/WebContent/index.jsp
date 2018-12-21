<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style >
body {font-family: Arial, Helvetica, sans-serif;}
form {
width:50%;
border: 3px solid #f1f1f1;}

input[type=text], input[type=password] {
  width: 50%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  
}

button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 40%;
}

button:hover {
  opacity: 0.8;
}

.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
  margin-right:50%;
}

.container {
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
     margin-left:100%;
  }
}
</style>
</head>
<body bgcolor="lightgreen" >
	<h1 align="center"> Admin Login page</h1>
	
	<font color="red">
 <strong> <%
/* String m=(String)request.getAttribute("msg");
if(m!=null)
	out.println(m); */
 %>
 ${msg}
 </strong>
</font>
	
<center>
<form action="AdminLogin" method="post">
  

  <div class="container">
    <label for="uname"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="aid" required>
     <br></br>
    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="apassword" required>
        
   <center> <button type="submit">Login</button></center>
    <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me
    </label>
  </div>

  <div class="container" style="background-color:#f1f1f1">
    <button type="button" class="cancelbtn">Cancel</button>
    <span class="psw">Forgot <a href="#">password?</a></span>
  </div>
</form>
</center>

<center><a href=CustomerLogin.jsp><h2>Go for Customer Login Page Here</h2></a></center>;
</body>
</html>