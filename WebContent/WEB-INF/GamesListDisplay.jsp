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
	<nav class="nav-extended ">
	<div class="nav-wrapper amber lighten-2">
		<a href="home" class="brand-logo">Home Page</a>
		<ul id="nav-mobile" class="right hide-on-med-and-down">
			<li class="active"><a href="displayGamesList">Games list</a></li>
			<li><a href="displayplayer">Players' list</a></li>
			<li><a href="displaytetrimino">Tetriminos' list</a></li>
			<li><a class="waves-effect waves-light btn" href="disconnect">Quit</a></li>
		</ul>
	</div>
	<div class="nav-content amber lighten-2">
		<span class="nav-title">Played Games History</span>
		</div>
	</nav>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Player1</th>
				<th>Score</th>
				<th>VS</th>
				<th>Player2</th>
				<th>Score</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${GamesList}" var="Game">
				<tr>
					<td>${Game.idGame}</td>
					<td>${Game.player1.username}</td>
					<td>${Game.scoreA.points}</td>
					<td>
						<c:if test="${empty Game.player2}"></c:if>
						<c:if test="${not empty Game.player2}">VS</c:if>
					</td>
					<td>
						<c:if test="${not empty Game.player2.username}">${Game.player2.username}</c:if>
					</td>
					<td>
						<c:if test="${not empty Game.player2.username}">${Game.scoreB.points}</c:if>
					</td>
					<td>${Game.status}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</body>

<script src="Resources/jquery-3.2.1.min.js"></script>
<script src="Resources/materialize/js/materialize.min.js"></script>
</html>