<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
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
.container {
  padding: 16px;
}
label{
font-size:20px;
font-family: comic sans ms;

}

</style>


</head>
<body bgcolor="#F3F153">
<form action=CustCheck method=post><pre>
<div class="container">
<center><h1>Customer Login Page</h1><hr>
 <label for="cname"><b>Customer Account No.</b></label>
 <input type=text name=account placeholder=EnterCname required><br>
 <label for="password"><b>Password</b></label>
 <input type=text name=pass placeholder=EnterPassword required><br>
  
  <center> <button type="submit">Login</button></center>
  </div>
</pre></form></center>
</body>
</html>