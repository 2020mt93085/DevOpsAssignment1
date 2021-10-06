<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/login.css"/ >
</head>
<body>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header"></div>

	</div>
	</nav>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
        </div>
			<h2 style="text-align: center"><font color="white">	Fill up the details to register </font></h2>
	</div>
	</nav>


	<form action="register" method="post">
	<div class="container">
    			
        <div class="form-group"><label for="userName">Name: </label>
		    <input type="text" class="form-control" name="userName" placeholder="Enter your username"><br>
		</div>

        <div class="form-group"><label for="dob">Date of Birth: </label>
            <input type="date" class="form-control" id="dob"name="dob">
        </div>

        <div class="form-group"><label for="password">Create Password: </label>
		   <input type="password" name="password" placeholder="Enter your password"><br>
        </div>
        <h6 align="center">
        	<button type="submit" value="Register">Submit</button>
        <h6 align="center">

	</form>
	
</body>
</html>