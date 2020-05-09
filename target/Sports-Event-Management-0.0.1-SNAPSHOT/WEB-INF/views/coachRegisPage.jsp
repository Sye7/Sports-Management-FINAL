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
<title>Coach Register</title>
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
	background-image: url("drawable/register.jpeg");
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

<script type="text/javascript">
	window.onload = function() {
		window.setTimeout(fadeout, 2000); //8 seconds
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
	
	
	function validatingForm() {
		if (document.form.firstName.value == "") {
			alert("Please update the highlighted field");
			document.loginform.firstName.focus();
			return false;
		}
		if (document.form.lastName.value == "") {
			alert("Please update the highlighted field");
			document.userform.lastName.focus();
			return false;
		}
		if (document.form.age.value == "") {
			alert("Please update the highlighted field");
			document.loginform.age.focus();
			return false;
		}
		if (document.form.contact.value == "") {
			alert("Please update the highlighted field");
			document.loginform.contact.focus();
			return false;
		}

		if (document.form.coachId.value == "") {
			alert("Please update the highlighted field");
			document.loginform.coachId.focus();
			return false;
		}

		
		if (document.form.password.value == "") {
			alert("Please update the highlighted field");
			document.loginform.password.focus();
			return false;
		}
	}
</script>


</head>
<body>

	<%
		String fail = (String) request.getAttribute("failed");

		if (fail != null && fail.length() != 0)
			out.println(
					" <center><h3><div  style='margin-top:50px;' id='fadeout'>" + fail + "</div></h3></center> ");
	%>


	<%@include file="headerLogin.html"%>


	<div class="signup-form">
		<form:form name="form" action="coachRegisterUser" method="post"
			modelAttribute="coach" onsubmit="return validatingForm()">
			<h2>Coach Registration</h2>
			
				
					<div class="form-group">
							<div class="input-group">
								
								<form:input path="firstName" class="form-control"
									name="firstName" placeholder="First Name"  />
							</div>
						</div>

					<form:errors class="error" path="firstName" ></form:errors>
				
				
					<div class="form-group">
							<div class="input-group">
								
								<form:input class="form-control" path="lastName" name="lastName"
									 placeholder="Last Name" />
							</div>
						</div>

					<form:errors class="error" path="lastName" ></form:errors>
				
				
					<div class="form-group">
							<div class="input-group">
								
								<form:input class="form-control" path="age" name="age"
								 placeholder="Age" />
							</div>
						</div>
					<form:errors class="error" path="age" ></form:errors>
				
				
					<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-mars"></i></span>
								<div class="form-control form-check-inline">
									<label class="form-check-label"> <form:radiobutton
											path="gender" id="gender" checked="true" value="Male"
											class="form-check-input" name="optradio" />Male
									</label>
								</div>

								<span class="input-group-addon"><i class="fa fa-venus"></i></span>
								<div class="form-control form-check-inline">
									<label class="form-check-label"> <form:radiobutton
											path="gender" id="gender" value="Female"
											class="form-check-input" name="optradio" />Female
									</label>
								</div>

					<form:errors class="error" path="gender"></form:errors>

					</div>

					</div>
				

				
					<div class="form-group">
							<div class="input-group">
								
								<form:input class="form-control" name="contact" path="contact"
									 placeholder="Contact Number" />
							</div>
						</div>

					<form:errors class="error" path="contact"></form:errors>
				
				
					<div class="form-group">
							<div class="input-group">
								
								<form:input path="coachId" class="form-control" name="coachId"
									placeholder="Coach Id" />
							</div>
						</div>
					<form:errors class="error" path="coachId" ></form:errors>
				
				
					<div class="form-group">
							<div class="input-group">
								
								<form:input type="password" path="password" class="form-control"
									name="password" placeholder="Password"  />
							</div>
						</div>

					<form:errors class="error" path="password" ></form:errors>
				
				
					<s class="form-group">
							<input type="submit" name="Register" value="Register"
								class="btn btn-primary btn-block btn-lg" />
						</div>
				
				
					</form:form>

					<div class="text-center">
						Already have an account? <a href="coachLogin">Login here</a>.
					</div>
					</div>
</body>
</html>
