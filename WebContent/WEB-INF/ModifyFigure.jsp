<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="Resources/materialize/css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="Resources/div.css" rel="stylesheet">
<title>Modification of the figure</title>
</head>
<body class="green lighten-5">
	<!--En Tete-->
	<nav class="z-depth-4">
	<div class="nav-wrapper amber lighten-2">
		<a href="home" class="brand-logo">Home Page</a>
		<ul id="nav-mobile" class="right hide-on-med-and-down">
			<li><a href="displayGamesList">Games list</a></li>
			<li><a href="displayplayer">Players' list</a></li>
			<li><a href="displaytetrimino">Tetriminos' list</a></li>
			<li><a class="waves-effect waves-light btn z-depth-4"
				href="disconnect">Quit<i class="material-icons right">exit_to_app</i></a></li>
		</ul>
	</div>
	</nav>

	<!-- Corps du html -->
	<form method="POST">
		<!-- Affichage de la forme -->
		<div class="figure" style="margin-left: auto; margin-right: auto;">
			<c:forEach var="x" begin="0" end="4">
				<c:forEach var="y" begin="0" end="4">

					<c:set var="color" value="#c8e6c9" />

					<c:forEach items="${ListBlock}" var="blockExistant">
						<c:if test="${blockExistant.x == x && blockExistant.y == y}">
							<c:set var="color" value="${Tetrimino.colourTetrimino}" />
						</c:if>
					</c:forEach>

					<div id="${x}_${y}" class="bloc a"
						style="background-color: ${ color };">
						<a href="modifyBlock?x=${x}&y=${y}&id=${figure.idFigure}"></a>
					</div>
				</c:forEach>
			</c:forEach>
		</div>
		<!-- Affichage des boutons enregistrer et sauvergarder -->
		<div class="row"
			style="margin-left: auto; margin-right: auto; width: 250px;">
			<table>
				<tr>
					<td style="width: 250px; text-align: center">
						<button class="btn waves-effect waves-light" type="submit">
							Save<i class="material-icons right">save</i>
						</button>
					</td>
					
				</tr>
			</table>
		</div>
	</form>
</body>
<script src="Resources/jquery-3.2.1.min.js"></script>
<script src="Resources/materialize/js/materialize.min.js"></script>
</html>