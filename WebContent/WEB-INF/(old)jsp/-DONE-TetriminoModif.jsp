<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="Resources/materialize/css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<title>Modification of the Tetrimino</title>
</head>
<body class="green lighten-5">
	<nav class="z-depth-4 ">
	<div class="nav-wrapper amber lighten-2 ">
		<a href="home" class="brand-logo">Home Page</a>
		<ul id="nav-mobile" class="right hide-on-med-and-down">
			<li><a href="displayGamesList">Games list</a></li>
			<li><a href="displayplayer">Players' list</a></li>
			<li><a href="displaytetrimino">Tetriminos' list</a></li>			
			<li><a class="waves-effect waves-light btn z-depth-4" href="disconnect">Quit<i class="material-icons right">exit_to_app</i></a></li>
		</ul>
	</div>
	</nav>
	<div class="row" style="margin-left: auto; margin-right: auto; width: 900px">
		<form class="col s12" method="post">
			<div class="row">
				<div class="input-field col s1">
					<input disabled id="id" type="number" name="id" value="${myTetri.idTetrimino}"> <label for="id">Id</label>
				</div>

				<div class="input-field col s3">
					<input id="name" type="text" name="name" value="${myTetri.nameTetrimino}" placeholder="${nameNewTetrimino.message}"> <label for="name">Name of the Tetrimino</label>
				</div>
				<div class="input-field col s3">
					<input id="coef" type="number" min="0" name="coef" value="${myTetri.coef}" placeholder="${coefNewTetrimino.message}"> <label for="coef">Coefficient of the Tetrimino</label>
				</div>
				<div class="input-field col s2">
					<input id="colour" type="color" name="colour"  value="${myTetri.colourTetrimino}" placeholder="${colourNewTetrimino.message}"> <label
						for="colour">Colour of the Tetrimino</label>
				</div>
				<div class="input-field col s3">
				<button class="btn waves-effect waves-light" type="submit">
						Modify<i class="material-icons right ">save</i>
					</button>
				</div>
			</div>
		</form>
	</div>
</body>
<script src="Resources/jquery-3.2.1.min.js"></script>
<script src="Resources/materialize/js/materialize.min.js"></script>
</html>