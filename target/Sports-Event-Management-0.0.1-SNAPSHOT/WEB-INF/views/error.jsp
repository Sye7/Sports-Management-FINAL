

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<style type="text/css">
* {
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
}

body {
	padding: 0;
	margin: 0;
}

#notfound {
	position: relative;
	height: 100vh;
	background-color: #222;
}

#notfound .notfound {
	position: absolute;
	left: 50%;
	top: 50%;
	-webkit-transform: translate(-50%, -50%);
	-ms-transform: translate(-50%, -50%);
	transform: translate(-50%, -50%);
}

.notfound {
	max-width: 460px;
	width: 100%;
	text-align: center;
	line-height: 1.4;
}

.notfound .notfound-404 {
	height: 158px;
	line-height: 153px;
}

.notfound .notfound-404 h1 {
	font-family: 'Josefin Sans', sans-serif;
	color: #222;
	font-size: 220px;
	letter-spacing: 10px;
	margin: 0px;
	font-weight: 700;
	text-shadow: 2px 2px 0px #c9c9c9, -2px -2px 0px #c9c9c9;
}

.notfound .notfound-404 h1>span {
	text-shadow: 2px 2px 0px #ffab00, -2px -2px 0px #ffab00, 0px 0px 8px
		#ff8700;
}

.notfound p {
	font-family: 'Josefin Sans', sans-serif;
	color: #c9c9c9;
	font-size: 25px;
	font-weight: 400;
	margin-top: 0px;
	margin-bottom: 15px;
}

.notfound a {
	font-family: 'Josefin Sans', sans-serif;
	font-size: 14px;
	text-decoration: none;
	text-transform: uppercase;
	background: transparent;
	color: #c9c9c9;
	border: 2px solid #c9c9c9;
	display: inline-block;
	padding: 10px 25px;
	font-weight: 700;
	-webkit-transition: 0.2s all;
	transition: 0.2s all;
}

.notfound a:hover {
	color: #ffab00;
	border-color: #ffab00;
}

@media only screen and (max-width: 480px) {
	.notfound .notfound-404 {
		height: 122px;
		line-height: 122px;
	}
	.notfound .notfound-404 h1 {
		font-size: 122px;
	}
}
</style>

<script type="text/javascript">
	history.pushState(null, null, location.href);
	history.back();
	history.forward();
	window.onpopstate = function() {
		history.go(1);
	};
</script>
<title>Oops 404</title>

<!-- Google font -->
<link
	href="https://fonts.googleapis.com/css?family=Josefin+Sans:400,700"
	rel="stylesheet">

<!-- Custom stlylesheet -->
<link type="text/css" rel="stylesheet" href="css/style.css" />

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

</head>

<body>

	<div id="notfound">
		<div class="notfound">
			<div class="notfound-404">
				<h1>
					4<span>0</span>4
				</h1>
			</div>
			<p>The page you are looking for could not be found.</p>
			<a href="/home">home page</a>
		</div>
	</div>

</body>

</html>

