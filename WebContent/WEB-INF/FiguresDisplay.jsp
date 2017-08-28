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
	</div>
	</nav>
	<div style="margin-left: auto; margin-right: auto; width: 900px">
		<table>
			<tr>
				<c:forEach items="${ListFigures }" var="figure">
					<td>
						<table>
							<c:forEach var="x" begin="0" end="4">
								<tr>
									<c:forEach var="y" begin="0" end="4">
										<td>
											<c:set var="color" value="#c8e6c9 " />
											<c:forEach items="${Figure.myBlocks}" var="blockExistant">
											<c:if test="${blockExistant.x == x && blockExistant.y == y}">
											<c:set var="color" value="${Tetrimino.colourTetrimino}" />
											</c:if>
											</c:forEach>
										</td>
									</c:forEach>
								</tr>
							</c:forEach>
						</table>
					</td>
				</c:forEach>
			</tr>
		</table>

	</div>
</body>

<script src="Resources/jquery-3.2.1.min.js"></script>
<script src="Resources/materialize/js/materialize.min.js"></script>
</html>