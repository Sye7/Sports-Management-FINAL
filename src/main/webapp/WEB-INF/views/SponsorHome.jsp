<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sponsor Home</title>
<style type="text/css">
@import "compass/css3";

.responstable {
	margin: 1em 0;
	width: 100%;
	overflow: hidden;
	background: #FFF;
	color: #024457;
	border-radius: 10px;
}

.responstable tr {
	border: 1px solid #D9E4E6;
}

.responstable tr:nth-child(odd) {
	background-color: #EAF3F3;
}

.responstable th {
	display: none;
	border: 1px solid #FFF;
	background-color: #167F92;
	color: #FFF;
	padding: 1em;
}

.responstable th:first-child {
	display: table-cell;
	text-align: center;
}

.responstable th:nth-child(2) {
	display: table-cell;
}

.responstable th:nth-child(2) span {
	display: none;
}

.responstable th:nth-child(2):after {
	content: attr(data-th);
}

@media ( min-width : 480px) {
	.responstable th:nth-child(2) span {
		display: block;
	}
	.responstable th:nth-child(2):after {
		display: none;
	}
}

.responstable td {
	display: block;
	word-wrap: break-word;
	max-width: 7em;
}

.responstable td:first-child {
	display: table-cell;
	text-align: center;
	border-right: 1px solid #D9E4E6;
}

@media ( min-width : 480px) {
	.responstable td {
		border: 1px solid #D9E4E6;
	}
}

.responstable th, .responstable td {
	text-align: left;
	margin: 0.5em 1em;
}

@media ( min-width : 480px) {
	.responstable th, .responstable td {
		display: table-cell;
		padding: 1em;
	}
}

body {
	padding: 0 2em;
	font-family: Arial, sans-serif;
	color: #024457;
	background-image: url("drawable/sponsor.jpeg");
	background-repeat: no-repeat;
	background-size: cover;
}

.h1 {
	font-family: Verdana;
	font-weight: normal;
	color: white;
	text-align: center;
	margin-top: 100px;
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
	<%@include file="headerSponsor.html"%>
	<h1 class="h1">All Events</h1>

	<center>
		<div style='margin-top: 50px;' id='fadeout'>${succ}</div>
	</center>
	
	<form:form action="requestSponsorship" method="post">

		<table class="responstable">

			<tr>

				<th>Event Name</th>
				<th>Sport Name</th>
				<th>Date Of Event</th>
				<th>Venue of Event</th>
				<th>Nominate for Sponsorship</th>
			</tr>
			<c:forEach var="event" items="${event}">
				<tr>
					<td>${event.getEventName()}</td>
					<td>${event.getSportsName() }</td>
					<td>${event.getTime()}</td>
					<td>${event.getVenue()}</td>

					<td><button type="submit" formaction="requestSponsorship"
							value="Nominate for Sponsorship">Nominate for
							Sponsorship</button></td>

					<input type="hidden" name="EventRegistration"
						name="EventRegistration" value="${event}" />


				</tr>

			</c:forEach>



		</table>

	</form:form>


</body>
</html>