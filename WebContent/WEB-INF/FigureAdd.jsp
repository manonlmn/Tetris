<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="Resources/materialize/css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<title>Add a Figure</title>
</head>
<body class="green lighten-5">
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
	<div class="row"
		style="margin-left: auto; margin-right: auto; width: 900px">
		<table>
			<thead>
				<tr>
					<th style="text-align: center;">Name of the Tetrimino</th>
					<th style="text-align: center;">Colour of the Tetrimino</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td style="text-align: center;">${Tetrimino.nameTetrimino }</td>
					<td style="text-align: center;"><div class="chip z-depth-2"
							style="height:20px; width:100px; background-color:${Tetrimino.colourTetrimino};border-style: solid; border-width: 1px; border-color : #bdbdbd;"></div></td>

				</tr>
			</tbody>
		</table>
	</div>
	<div>
		<form class="col s12" method="post">
			<div class="row">
				<c:forEach var ="i" begin="0" end="4">
					<tr>
						<c:forEach var ="j" begin="0" end="4">
							<td>${i+j }</td>
						</c:forEach>
					</tr>
				</c:forEach>
				<div class="input-field col s3">
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