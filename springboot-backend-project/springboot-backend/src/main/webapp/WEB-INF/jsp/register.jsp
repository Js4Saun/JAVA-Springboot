<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Register</title>
</head>
<body>
	<div>
		<h1>Fill the details below</h1>
	</div>
	<div class="container">
		<form action="/register" method="post">
				<div class="form-group">
					<label for="userName">User Name</label> <input type="text"
						name="userName" class="from-control" placeholder="John Smith">
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						name="password" class="from-control" placeholder="*******">
				</div>
				<div class="form-group">
					<label for="email">Email</label> <input type="text" name="email"
						class="from-control" placeholder="john.smith@johnsmith.me">
				</div>
				
				<button type="submit" class="btn btn-primary">Register</button>
			</form>
		</div>
</body>
</html>