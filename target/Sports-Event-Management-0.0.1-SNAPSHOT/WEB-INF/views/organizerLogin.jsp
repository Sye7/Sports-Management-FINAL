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
<title>Organizer Login</title>
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
	background-image: url("drawable/login.jpeg");
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
}

.signup-form h2 {
	color: #636363;
	margin: 0 0 15px;
	text-align: center;
}

.signup-form .lead {
	font-size: 14px;
	margin-bottom: 30px;
	text-align: center;
}

.signup-form form {
	border-radius: 1px;
	margin-bottom: 15px;
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

#fadeout {
	opacity: 1;
	transition: 1s opacity;
	text-align: center;
	font-size: 32px;
}
</style>



<script type="text/javascript">
	window.onload = function() {
		window.setTimeout(fadeout, 1000); //8 seconds
	}

	function fadeout() {
		document.getElementById('fadeout').style.opacity = '0';
	}
	
	
	history.pushState(null, null, location.href);
	history.back();
	history.forward();
	window.onpopstate = function() {
		history.go(1);
	};
	
</script>


</head>
<body>

	<%
		String succ = (String) request.getAttribute("successful");
		if (succ != null && succ != null)
			out.println(" <div  style='color:#fff; margin-top:90px;' id='fadeout'>" + succ + "</div> ");

		String fail = (String) request.getAttribute("failed");
		
		if (fail != null && fail.length() != 0)
			out.println(" <div  style='color:#fff; margin-top:90px;' id='fadeout'>" + fail + "</div> ");
	%>
	
	
	
	<%@include file="headerLogin.html"%>


	
	
	

	<div class="signup-form">

		<form:form action="orgSub" method="post" modelAttribute="credentials">
			<h2>Login</h2>

			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-id-card"></i></span>
					<form:input type="text" class="form-control" name="id" path="id"
						placeholder="Organizer Id" required="required" />


				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon"> <i class="fa fa-lock"></i>
						<i class="fa fa-check"></i>
					</span>
					<form:input type="password" class="form-control" name="password"
						path="password" placeholder="    Password" required="required" />
				</div>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary btn-block btn-lg">Log
					In</button>
			</div>
		</form:form>
	</div>
</body>
</html>
