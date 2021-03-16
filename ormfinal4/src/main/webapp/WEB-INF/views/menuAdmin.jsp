<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" 
rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<h1 class="h1">Menu Item</h1>
		<table class="table table-success table-striped table-bordered border-primary">
			<thead>
				<tr class="table-dark h4 text-uppercase">
					<th>MenuItem ID</th>
					<th>Name</th>
					<th>Price</th>
					<th>Active</th>
					<th>Date of Launch</th>
					<th>Category</th>
					<th>Free Delivery</th>
					
					<th>URL</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="item">
					<tr class="fs-5">
						<td>${item.id}</td>
						<td>${item.name}</td>
						<td>${item.price}</td>
						<td>${item.active}</td>
						<td>${item.dateOfLaunch}</td>
						<td>${item.category}</td>
						<td>${item.freeDelivery}</td>
						<td>${item.url }</td>
						<td><a href="#"  class="btn btn-primary">Edit</a></td>	
					</tr>
				</c:forEach>
			</tbody>
		</table></div>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
		
	
</body>
</html>