<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Roboto:400,700"
	rel="stylesheet">
<title>Update Event</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
body {
	color: #999;
	background-image: url("drawable/eventAdd.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	font-family: 'Roboto', sans-serif;
}

.form-control, .form-control:focus, .input-group-addon {
	border-color: #e1e1e1;
	border-radius: 9px;
}

.signup-form {
	width: 390px;
	margin: 0 auto;
	padding: 30px 0;
	border-radius: 9px;
	margin-top:80px;
}

.signup-form h2 {
	color: #636363;
	margin: 0 0 15px;
	text-align: center;
}

.form-group{
margin:0;}
.error{
color:red;
}
.signup-form .lead {
	font-size: 14px;
	margin-bottom: 30px;
	text-align: center;
}

.signup-form form {
	border-radius: 1px;
	
	background: #fff;
	border: 1px solid #f3f3f3;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	padding: 30px;
	margin-top:100px;
}

.signup-form .form-group {
	margin-bottom: 20px;
}

.btn {
	
}

.btn:hover {
	
}

.signup-form label {
	font-weight: normal;
	font-size: 13px;
}

.signup-form .form-control {
	min-height: 38px;
	box-shadow: none !important;
	border-width: 0 0 1px 0;
}

.signup-form .input-group-addon {
	max-width: 42px;
	text-align: center;
	background: none;
	border-width: 0 0 1px 0;
	padding-left: 5px;
}

.signup-form .btn {
	font-size: 16px;
	font-weight: bold;
	background: linear-gradient(to bottom left, #EF8D9C 40%, #FFC39E 100%);
	border-color: light grey;
	border-radius: 20px;
	border: none;
	min-width: 140px;
	outline: none !important;
}

.signup-form .btn:hover, .signup-form .btn:focus {
	background: linear-gradient(to top right, #EF8D9C 40%, #FFC39E 100%);
}

.signup-form a {
	color: #19aa8d;
	text-decoration: none;
}

.signup-form a:hover {
	text-decoration: underline;
}

.signup-form .fa {
	font-size: 21px;
}

.signup-form .fa-paper-plane {
	font-size: 17px;
}

.signup-form .fa-check {
	color: #fff;
	left: 9px;
	top: 18px;
	font-size: 7px;
	position: absolute;
}
</style>
</head>
<body>
<%@include file="header.html" %>
	<div class="signup-form">
	
		<form:form action="updateEventF" method="post" modelAttribute="event">
			<h2>Edit Your Event</h2>
			
				
					<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<form:input path="eventId" class="form-control" name="eventId"
									placeholder="Event Id" required="required" readonly="true" />
							</div>
						</div>

					<form:errors class="error" path="eventId"></form:errors>
				
				
					<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<form:input class="form-control" path="eventName"
									name="eventName" required="required" readonly="true"
									placeholder="Event Name" />
							</div>
						</div>

					<form:errors class="error" path="eventName"></form:errors>
				
				
					<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
								<form:input class="form-control" path="sportsName"
								 readonly="true"	name="sportsName" required="required" placeholder="Sports Name" />
							</div>
						</div>
					<form:errors class="error" path="sportsName"></form:errors>
				


				
					<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-phone"></i></span>
								<form:input type="date" class="form-control" name="Date"
									path="Date" required="required" placeholder="Date" />
							</div>
						</div>

					<form:errors class="error" path="Date"></form:errors>
				
				
					<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-id-card"></i></span>
								<form:input path="time" class="form-control" name="time"
									placeholder="Time" required="required" />
							</div>
						</div>
					<form:errors class="error" path="time"></form:errors>
				
				
					<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"> <i class="fa fa-lock"></i>
									<i class="fa fa-check"></i>
								</span>
								<form:input path="venue" class="form-control" name="venue"
									placeholder="Venue" required="required" />
							</div>
						</div>

					<form:errors class="error" path="venue"></form:errors>
				
				
					<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-phone"></i></span>
								<form:input class="form-control" name="noOfSlots"
									path="noOfSlots" required="required" placeholder="No Of Slots" />
							</div>
						</div>

					<form:errors class="error" path="noOfSlots"></form:errors>
				
				
					<div class="form-group">
							<input type="submit" name="Register" value="Register"
								class="btn btn-primary btn-block btn-lg" />
						</div>
				
				
					</form:form>
</body>
</html>

