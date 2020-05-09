<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<style type="text/css">

/* Font */
@import url('https://fonts.googleapis.com/css?family=Quicksand:400,700')
	;

@import
	url('https://fonts.googleapis.com/css?family=Kaushan+Script|Lobster+Two|Viaoda+Libre&display=swap')
	;

/* Design */
*, *::before, *::after {
	box-sizing: border-box;
}

html {
	background-repeat: no-repeat;
	background-size: cover;
	background-image: url("drawable/SportsHome.jpg");
}

body {
	color: #272727;
	font-family: 'Quicksand', serif;
	font-style: normal;
	font-weight: 400;
	letter-spacing: 0;
	padding: 1rem;
}

.main {
	max-width: 1200px;
	margin: 0 auto;
}

h1 {
	font-size: 70px;
	font-weight: 400;
	text-align: center;
	margin-bottom: 150px;
	font-family: 'Kaushan Script';
	color: #fff;
}

img {
	height: 300px;
	max-width: 100%;
	vertical-align: middle;
}

.btn {
	color: #ffffff;
	padding: 0.8rem;
	font-size: 14px;
	margin-bottom: 5px;
	text-transform: uppercase;
	border-radius: 4px;
	font-weight: 400;
	display: block;
	width: 100%;
	cursor: pointer;
	border: 1px solid rgba(255, 255, 255, 0.2);
	background: transparent;
}

.btn:hover {
	background-color: rgba(255, 255, 255, 0.12);
}

.cards {
	display: flex;
	flex-wrap: wrap;
	list-style: none;
	margin: 0;
	padding: 0;
}

.cards_item {
	display: flex;
	padding: 1rem;
}

@media ( min-width : 40rem) {
	.cards_item {
		width: 50%;
	}
}

@media ( min-width : 56rem) {
	.cards_item {
		width: 33.3333%;
	}
}

.card {
	background-color: white;
	border-radius: 0.25rem;
	box-shadow: 0 20px 40px -14px rgba(0, 0, 0, 0.25);
	display: flex;
	flex-direction: column;
	overflow: hidden;
}

.card_content {
	padding: 1rem;
	background: linear-gradient(to bottom left, #EF8D9C 40%, #FFC39E 100%);
}

.card_title {
	color: #ffffff;
	font-size: 1.1rem;
	font-weight: 700;
	letter-spacing: 1px;
	text-transform: capitalize;
	margin: 0px;
}

.card_text {
	color: #ffffff;
	font-size: 0.875rem;
	line-height: 1.5;
	margin-bottom: 1.25rem;
	font-weight: 400;
}
</style>

<script type="text/javascript">
	history.pushState(null, null, location.href);
	history.back();
	history.forward();
	window.onpopstate = function() {
		history.go(1);
	};

	window.onload = function() {
		window.setTimeout(fadeout, 3000); //8 seconds
	}

	function fadeout() {
		document.getElementById('fadeout').style.opacity = '0';
	}
</script>

</head>
<body>

	<%
		String fail = (String) request.getAttribute("session");

		if (fail != null && fail.length() != 0)
			out.println(" <center><h3><div  style='color:#fff;' id='fadeout'>" + fail
					+ "</div></h3></center> ");
	%>


	<div class="main">
		<h1>Sports Event Management</h1>
		<ul class="cards">
			<li class="cards_item">
				<div class="card">
					<div class="card_image">
						<img
							src="https://images.unsplash.com/photo-1543062370-c0f03471ae6b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80">
					</div>
					<div class="card_content">
						<h2 class="card_title">Sponsors</h2>
						<p class="card_text">Sponsors can login with their
							credentianls or can register by giving basic details.</p>
						<a href="/sponsorLogin" style="text-decoration: none">
							<button class="btn card_btn">Login</button>
						</a> <a href="/sponsorRegistration" style="text-decoration: none">
							<button class="btn card_btn">Register</button>
						</a>
					</div>
				</div>
			</li>
			<li class="cards_item">
				<div class="card">
					<div class="card_image">
						<img
							src="https://images.unsplash.com/photo-1529932398402-e0b30f66a559?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80">
					</div>
					<div class="card_content">
						<h2 class="card_title">Coach</h2>
						<p class="card_text">Coaches can login with their credentianls
							or can register by giving basic details.</p>
						<a href="/coachLogin" style="text-decoration: none">
							<button class="btn card_btn">Login</button>
						</a> <a href="/coachRegistration" style="text-decoration: none">
							<button class="btn card_btn">Register</button>
						</a>

					</div>
				</div>
			</li>
			<li class="cards_item">
				<div class="card">
					<div class="card_image">
						<img
							src="https://images.unsplash.com/photo-1553034710-47f9e03ff808?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80">
					</div>
					<div class="card_content">
						<h2 class="card_title">Organizer</h2>
						<p class="card_text">Organizer can login with their
							credentianls or can register by giving basic details.</p>


						<a href="/organizerLogin" style="text-decoration: none">
							<button href="" class="btn card_btn">Login</button>

						</a> <a href="organizerRegistration" style="text-decoration: none">
							<button class="btn card_btn">Register</button>
						</a>
					</div>
				</div>
			</li>

		</ul>
	</div>
</body>
</html>
