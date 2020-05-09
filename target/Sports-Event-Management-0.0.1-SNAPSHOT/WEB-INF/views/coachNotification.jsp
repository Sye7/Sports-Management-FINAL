<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Coach Notifications</title>
<style type="text/css">
@import "compass/css3";

body {
	background-image: url("drawable/coach.jpeg");
	background-repeat: no-repeat;
	background-size: cover;
}
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
}

.h1 {
	font-family: Verdana;
	font-weight: normal;
	color: white;
	text-align: center;
	margin-top: 100px;
}
</style>
</head>
<body>


	<%@include file="headerCoach.html"%>
	<h1 class="h1">All Notifications</h1>

	<form:form action="hello" method="post">

		<table class="responstable">

			<tr>

				<th>Coach Name</th>
				<th>Event Name</th>
				<th>Date Of Event</th>
				<th>Venue</th>
				<th>Status</th>
			</tr>
			<c:forEach var="notificationCoachList" items="${notificationCoachList}">
				<tr>
					<td>${notificationCoachList.getCoachName()}</td>
					<td>${notificationCoachList.getEventName()}</td>
					<td>${notificationCoachList.getDate()}</td>
					<td>${notificationCoachList.getVenue()}</td>
					<td>${notificationCoachList.getStatus()}</td>


					<td><button type="submit" formaction="remcoachNotify"
							name="action" value="reject">Okay</button>
						</td>



					<td><input type="hidden" id="EventRegistration"
						name="EventRegistration" value="${notificationCoachList}" /></td>


				</tr>

			</c:forEach>



		</table>
	</form:form>



</body>
</html>