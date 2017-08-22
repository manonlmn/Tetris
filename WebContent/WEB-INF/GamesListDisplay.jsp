<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="Resources/materialize/css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<title>Games List</title>
</head>


<body class="green lighten-5">
	<nav>
	<div class="nav-wrapper amber lighten-2">
		<a href="displayGamesList" class="brand-logo">Games List</a>
		<ul id="nav-mobile" class="right hide-on-med-and-down">
			<li class="active"><a href="displayplayer">Players' list</a></li>
			<li><a href="displaytetrimino">Tetriminos' list</a></li>
		</ul>
	</div>
	</nav>

	<h5>Played Games History</h5>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>VS</th>
				<th>Player1</th>
				<th>Player2</th>
				<th>Score</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${GamesList}" var="Game">
				<tr>
					<td>${Game.idGame}</td>
					<td>
					<c:when test="${Game.idPlayer2 == null}">Solo</c:when>
					<c:otherwise>VS</c:otherwise>
					</td>
					<td>${Game.idPlayer1}</td>
					<td>${Game.idPlayer2}</td>
					<td>${Game.score}</td>
					<td></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</body>

<script src="Resources/jquery-3.2.1.min.js"></script>
<script src="Resources/materialize/js/materialize.min.js"></script>
</html>