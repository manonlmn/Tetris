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
<title>List of Tetrimino Figures</title>
</head>


<body class="green lighten-5">
	<nav class="nav-extended z-depth-4">
	<div class="nav-wrapper amber lighten-2">
		<a href="home" class="brand-logo">Home Page</a>
		<ul id="nav-mobile" class="right hide-on-med-and-down">
			<li><a href="displayGamesList">Games list</a></li>
			<li><a href="displayplayer">Players' list</a></li>
			<li class="active"><a href="displaytetrimino">Tetriminos'
					list</a></li>
			<li><a class="waves-effect waves-light btn z-depth-4"
				href="disconnect">Quit<i class="material-icons right">exit_to_app</i></a></li>
		</ul>
	</div>
	<div class="nav-content amber lighten-2">
		<span class="nav-title">List of Tetrimino Figures</span>
		<c:if test="${FiguresList.size() < 4 }">
		<a class="btn-floating btn-large halfway-fab waves-effect waves-light z-depth-3 teal" href="AddFigure?id=${Tetrimino.idTetrimino }" type="submit"> <i class="material-icons">add</i>
		</c:if>
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
				</tr>
			</thead>

			<tbody>
				<tr>
					<td style="text-align: center;">${Tetrimino.idTetrimino}</td>
					<td style="text-align: center;">${Tetrimino.nameTetrimino }</td>
					<td style="text-align: center;">${Tetrimino.coef }</td>
					<td style="text-align: center;"><div class="chip z-depth-2"
							style="height:20px; width:100px; background-color:${Tetrimino.colourTetrimino};border-style: solid; border-width: 1px; border-color : #bdbdbd;"></div></td>
					</td>
				</tr>
			</tbody>
		</table>

		<c:if test="${empty FiguresList }">
		No figures were assigned to this tetrimino yet.<br/>
		</c:if>
		<c:if test="${not empty FiguresList }">

			<table>
				<tr>
					<c:forEach items="${FiguresList }" var="figure">
						<td style="text-align:center">Rotation No.${figure.rotationNumber }
							<table
								style="padding: 5px; margin-left: auto; margin-right: auto; width: 200px; height: 200px; border: solid 1px #c8e6c9">

								<c:forEach var="x" begin="0" end="4">
									<tr>
										<c:forEach var="y" begin="0" end="4">
											<c:set var="color" value="#e8f5e9 " />
											<c:forEach items="${figure.myBlocks}" var="blockExistant">
												<c:if test="${blockExistant.x == x && blockExistant.y == y}">
													<c:set var="color" value="${Tetrimino.colourTetrimino}" />
												</c:if>
											</c:forEach>
											<td id="${x}_${y}" class="bloc a"
												style="background-color: ${ color }; width: 40px; height: 40px; border-radius:0px">
											</td>
										</c:forEach>
									</tr>
								</c:forEach>
								<tr>
								
								
								
									<td style="text-align: center;"><a
										href="modifyFigure?id=${figure.idFigure}"
										class="secondary-content"><i class="material-icons">mode_edit</i></a></td>
									<td style="text-align: center;"><a
										href="deleteFigure?id=${figure.idFigure}"
										class="secondary-content"><i class="material-icons">delete</i></a></td>
									<td></td>
									<td></td>
									<td></td>
										
										
										
								</tr>

							</table>
						</td>
					</c:forEach>
				</tr>
			</table>

		</c:if>

	</div>
</body>

<script src="Resources/jquery-3.2.1.min.js"></script>
<script src="Resources/materialize/js/materialize.min.js"></script>
</html>