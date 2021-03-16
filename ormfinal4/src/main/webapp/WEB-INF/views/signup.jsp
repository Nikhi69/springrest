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
		
			
			<section>

		<div id="mid-container">
			<form method=POST class="form-1" onsubmit="return validateSignup()"
				name="signupform" id="signupform" action="/signupsuccess">
				<p>SignUp</p>
				<label class="label-1" for="username">User Name</label><br> <input
					type="text" id="username" name="User" placeholder="Enter Username" /><br>
				<label class="label-1" for="firstname">First Name</label> <label
					class="label-2" for="lastname">Last Name</label><br> <input
					type="text" id="firstname" name="firstname"
					placeholder="Enter Firstname" /> <input type="text" id="lastname"
					name="lastname" placeholder="Enter Lastname" /><br> <label
					class="label-1" for="password">Password</label> <label
					class="label-2" for="confirm-password">Confirm-Password</label><br>
				<input type="password" id="password" name="password"
					placeholder="Enter Password"> <input type="password"
					id="confirm-password" name="confirm-password"
					placeholder="Confirm-Password"> <input type="submit"
					value="Signup" class="BTN1">
			</form>
		</div>
	</section>
			
			<div class="footer">
			<div class="foot">
				<p>Copyright @ 2021</p>
			</div>
		</div>
	</div>

</body>
</html>