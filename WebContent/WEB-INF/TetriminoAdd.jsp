<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="Resources/materialize/css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<title>Adding a Tetrimino</title>
</head>
<body class="green lighten-5">
<nav class="z-depth-4">
	<div class="nav-wrapper amber lighten-2">
		<a href="home" class="brand-logo">Home Page</a>
		<ul id="nav-mobile" class="right hide-on-med-and-down">
			<li><a href="displayGamesList">Games list</a></li>
			<li><a href="displayplayer">Players' list</a></li>
			<li><a href="displaytetrimino">Tetriminos' list</a></li>
			<li><a class="waves-effect waves-light btn z-depth-4" href="disconnect">Quit</a></li>
		</ul>
	</div>
	
	</nav>
	<div class="row">
		<form class="col s12" method="post">
			<div class="row">
				<div class="input-field col s6">
					<input id="name" type="text" name="nameNewTetrimino" placeholder="${nameNewTetrimino.message}" > <label for="name">Name of the Tetrimino</label>
				</div>
				<div class="input-field col s4">
					<input id="color" type="color" name="colourNewTetrimino" placeholder="${colourNewTetrimino.message}"> <label
						for="color">Color of the Tetrimino</label>
				</div>
				<div class="input-field col s2">
				<button class="btn waves-effect waves-light" type="submit">
						Save<i class="material-icons right">save</i>
					</button>
				</div>
			</div>
		</form>
	</div>
</body>

<script src="Resources/jquery-3.2.1.min.js"></script>
<script src="Resources/materialize/js/materialize.min.js"></script>
</html>