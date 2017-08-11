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
<body>
	<nav>
	<div class="nav-wrapper  cyan darken-4">
		<a href="#" class="brand-logo">Modification</a>
		<ul id="nav-mobile" class="right hide-on-med-and-down">
			<li><a href="displayplayer">Players' list</a></li>
			<li><a href="displaytetrimino">Tetriminos' list</a></li>
		</ul>
	</div>
	</nav>
	<div class="row">
		<form class="col s12" method="post">
			<div class="row">
				<div class="input-field col s1">
					<input disabled id="id" type="number" name="id" value="${Tetrimino.idTetrimino}"> <label for="id">Id</label>
				</div>

				<div class="input-field col s6">
					<input id="name" type="text" name="name"> <label for="name"  value="${Tetrimino.nameTetrimino}">Name of the Tetrimino</label>
				</div>
				<div class="input-field col s4">
					<input id="colour" type="text" name="colour"  value="${Tetrimino.colourTetrimino}"> <label
						for="colour">Colour of the Tetrimino</label>
				</div>
				<div class="input-field col s1"">
				<button class="btn waves-effect waves-light" type="submit">
						Modify <i class="material-icons right">send</i>
					</button>
				</div>
			</div>
		</form>
	</div>
</body>
<script src="Resources/jquery-3.2.1.min.js"></script>
<script src="Resources/materialize/js/materialize.min.js"></script>
</html>