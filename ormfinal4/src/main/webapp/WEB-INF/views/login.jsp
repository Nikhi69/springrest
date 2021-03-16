<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.nikhil.truyum.*"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="movie_list_admin.css" type="text/css">
<title>Movie Cruiser</title>
<style>
.label-1 {
	margin-left: 13px;
	display: inline-block;
	padding: 10px;
}
button {
	background-color: tomato;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}
.label-2 {
	margin-left: 143px;
	display: inline-block;
	padding: 10px;
}

form p {
	font-size: 30px;
	padding: 20px;
	margin: 0;
	margin-left: 10px;
}
input[type="password"] {
	padding: 13px 10px;
	border-radius: 8px;
	margin: 8px;
	display: inline-block;
	border-color: dimgrey;
	margin-right: 7px;
	margin-left: 19px;
	padding-right: 35px;
}

input[type="text"] {
	padding: 13px 10px;
	border-radius: 8px;
	margin: 8px;
	display: inline-block;
	border-color: dimgrey;
	margin-right: 7px;
	margin-left: 19px;
	padding-right: 35px;
}
</style>

</head>
<body>
	<div class="maincontainer">
		<div class="navbar">
			<h3>Movie Cruiser</h3>
			<img src="film.png">
			<div class="right">
				<a href="/signup"><h3>SignUp</h3></a>
				  <a href="/login"><h3>Login</h3></a>
			</div>
		</div>
		<br>
		<form name="myForm" action="" 
		method=POST>
		<h1>Login</h1>
		<div class="formFields">
			<label for="uname"><b>Username</b></label> <input type="text"
				placeholder="Enter Username" name="uname">
			<p id="error" style="color: red;"></p>
			<label for="pwd"><b>Password</b></label> <input type="password"
				placeholder="Enter Pasword" name="pwd">
			<p id="error1" style="color: red;"></p>
			
			<button type="submit">Login</button>
			<span class="pass">New Here?<a href="/signup">SignUp</a></span>
		</div>

	</form>
		
		
		<div class="footer">
			<div class="foot">
				<p>Copyright @ 2021</p>
			</div>
		</div>
	</div>

</body>
</html>