<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Login</title>
</head>
<body>
<div>
<h2>${loggedout}</h2>
<h1>Enter username and password.</h1></div>
 <!-- Login -->
  <div class="col-md-8">
  
  <form action="/login" method="post">
    <div class="form-group">
      <label for="usr">Name:</label>
      <input type="text" class="form-control" id="usr" name="userEmail" placeholder="Your Email">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" name="password" placeholder="Your Password">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
  
   <p>Or <a href="/regpage">Register</a> here.</p>
</div>

<div><p class="warning">${errorMessage }</p></div>

</body>
</html>