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
<title>Display of the Tetriminos</title>
</head>
<body class="green lighten-5">
	<nav class="nav-extended z-depth-4 ">
	<div class="nav-wrapper amber lighten-2 ">
		<a href="home" class="brand-logo">Home Page</a>
		<ul class="right hide-on-med-and-down">
			<li><a href="displayGamesList">Games list</a></li>
			<li><a href="displayplayer">Players' list</a></li>
			<li class="active"><a href="displaytetrimino">Tetriminos'
					list</a></li>
			<li><a class="waves-effect waves-light btn z-depth-4"
				href="disconnect">Quit<i class="material-icons right">exit_to_app</i></a></li>
		</ul>
	</div>
	<div class="nav-content amber lighten-2">
		<span class="nav-title">List of the Tetriminos</span> <a
			class="btn-floating btn-large halfway-fab waves-effect waves-light z-depth-3 teal"
			href="newitem" type="submit"> <i class="material-icons">add</i>
		</a>
	</div>
	</nav>
	<div style="margin-left: auto; margin-right: auto; width: 900px">
		<table>
			<thead>
				<tr>
					<th style="text-align: center;">Id</th>
					<th style="text-align: center;">Tetrimino's Name</th>
					<th style="text-align: center;">Coefficient</th>
					<th style="text-align: center;">Color</th>
					<th style="text-align: center;"></th>
					<th style="text-align: center;"></th>
					<th style="text-align: center;"></th>
					<th style="text-align: center;"></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${TetriminoList}" var="Tetrimino">
					<tr>
						<td style="text-align: center;">${Tetrimino.idTetrimino}</td>
						<td style="text-align: center;">${Tetrimino.nameTetrimino }</td>
						<td style="text-align: center;">${Tetrimino.coef }</td>
						<td style="text-align: center;"><div class="chip z-depth-2"
								style="height:20px; width:100px; background-color:${Tetrimino.colourTetrimino};border-style: solid; border-width: 1px; border-color : #bdbdbd;"></div></td>
						<td style="text-align: center;"><a
							href="ModifyItem?id=${Tetrimino.idTetrimino}"
							class="secondary-content"><i class="material-icons">mode_edit</i></a></td>
						<td style="text-align: center;"><a
							href="DeleteItem?id=${Tetrimino.idTetrimino}"
							class="secondary-content"><i class="material-icons">delete</i></a></td>

						<c:if test="${Tetrimino.myFigures.size() < 4 }">
							<td style="text-align: center;"><a
								href="AddFigure?id=${Tetrimino.idTetrimino}"
								class="secondary-content"> <i class="material-icons">add_to_photos</i></a></td>
						</c:if>
						<c:if test="${Tetrimino.myFigures.size() == 4 }">
							<td></td>
						</c:if>

						<td style="text-align: center;"><a
							href="ListFiguresTetrimino?id=${Tetrimino.idTetrimino}"
							class="secondary-content"> <i class="material-icons">library_books</i></a>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</body>
<script src="Resources/jquery-3.2.1.min.js"></script>
<script src="Resources/materialize/js/materialize.min.js"></script>
</html>