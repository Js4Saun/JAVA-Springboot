<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HomePage</title>
</head>
<body>
<h1 align="center">Welcome</h1>

<a href="/displayUsers">Welcome User</a>
${getUsers}
<div align="center">
	<table class ="table" border="1" cellpadding="2" cellspacing="2">
	<tr>
      	<th>Id</th>
      	<th>Username</th>
      	<th>email</th>
      	
      </tr>
     <c:forEach var = "customer" items="${getUsers}">
         <tr>
         	 <td><c:out value ="${customer.id}"/></td>
	         <td><c:out value ="${customer.userName}"/></td>
	         <td><c:out value ="${customer.email}"/></td>
	     </tr>
      
      </c:forEach>
      
      </table>
      <div class="col-md-4">
      <h3>Products</h3>        
      <table class ="table" border="1" cellpadding="2" cellspacing="2">
      <thead>
      
      <tr>
        <th> Id </th>
      	<th> Name </th>
      	<th> Category </th>
      	<th> price </th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var = "product" items="${products}">
         <tr>
         	 <td><c:out value ="${product.id}" /> </td>
	         <td><c:out value ="${product.productName}" /> </td>
	         <td><c:out value ="${product.productType}" /> </td>
	         <td> <c:out value ="${product.productPrice}" /></td>
	        
         
         </tr>
      
      </c:forEach>
      </tbody>
      </table>
      ${searchResult}
    </div>
      <p>Or <a href="/regproduct">Add Product</a> here.</p>
</div>
</body>
</html>