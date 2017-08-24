<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="Resources/materialize/css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<title>Players' List</title>
</head>
<body class="green lighten-5">
<nav>
	<div class="nav-wrapper amber lighten-2">
		<a href="home" class="brand-logo">Home Page</a>
		<ul id="nav-mobile" class="right hide-on-med-and-down">
			<li><a href="displayGamesList">Games list</a></li>
			<li class="active"><a href="displayplayer">Players' list</a></li>
			<li><a href="displaytetrimino">Tetriminos' list</a></li>
		</ul>
	</div>
	</nav>
	
	<h5>List of Players</h5>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>First name</th>
				<th>Last name</th>
				<th>Username</th>
				<th>Ban</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${PlayersList}" var="player">
				<tr>
					<td>${player.idPerson}</td>
					<td>${player.lastName}</td>
					<td>${player.name}</td>
					<td>${player.username}</td>
					<td>
						<c:if test="${player.banned == false}">No</c:if>
						<c:if test="${player.banned == true}">Yes</c:if>
					</td>
					<td>
						<c:if test="${player.banned == false}">
							<a href="BanPlayer?id=${player.idPerson}" class="secondary-content"><i class="material-icons">block</i>
						</c:if>
						<c:if test="${player.banned == true}">
							<a href="BanPlayer?id=${player.idPerson}" class="secondary-content"><i class="material-icons">check</i>
						</c:if>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</body>

<script src="Resources/jquery-3.2.1.min.js"></script>
<script src="Resources/materialize/js/materialize.min.js"></script>
</html>