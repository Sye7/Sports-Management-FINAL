<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Event Report</title>
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
	background-image: url("drawable/organizerHome.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}

.h1 {
	font-family: Verdana;
	font-weight: normal;
	color: #024457;
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
	
	
	history.pushState(null, null, location.href); history.back();
	history.forward(); window.onpopstate = function() { history.go(1);


</script>





</head>


<body>
	<%@include file="header.html"%>
	<h1 class="h1">Event Report</h1>


	<form:form action="requestSponsorship" method="post">

		<table class="responstable">

			<tr>
				<th>Event Id</th>
				<th>Event Name</th>
				<th>Sport Name</th>
				<th>Date Of Event</th>
				<th>Time Of Event</th>
				<th>Venue of Event</th>
			</tr>
			<c:forEach var="eve" items="${eve}">
				<tr>
					<td>${eve.getEventId()}</td>
					<td>${eve.getEventName()}</td>
					<td>${eve.getSportsName() }</td>
					<td>${eve.getDate()}</td>
					<td>${eve.getTime()}</td>
					<td>${eve.getVenue()}</td>


				</tr>

			</c:forEach>



		</table>

	</form:form>


</body>
</html>