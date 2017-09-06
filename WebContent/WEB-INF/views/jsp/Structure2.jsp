<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--Import materialize.css-->

<link rel="stylesheet"
	href="/Tetris/Resources/materialize/css/materialize.min.css">
<link rel="stylesheet" href="/Tetris/Resources/div.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<c:set var="titleCode" scope="request">
	<tiles:insertAttribute name="title" ignore="true" />
</c:set>
<title><spring:message code="${ titleCode }" /></title>
</head>
<body class="green lighten-5">
	<nav class="nav-extended z-depth-4">
	<div class="nav-wrapper amber lighten-2">
		<a href="/Tetris/admin/${username}" class="brand-logo"><i
			class="material-icons left" style="font-size: 50px">home</i>
		<spring:message code="title.welcome" /></a>
		<ul id="nav-mobile" class="right hide-on-med-and-down">

			<li>
				<!-- Dropdown Trigger --> <a class='dropdown-button' href='#'
				data-activates='dropdown1'><i class="material-icons left">language</i>
				<spring:message code="title.language" /></a> <!-- Dropdown Structure -->
				<ul id='dropdown1' class='dropdown-content'>
					<li><a href="?lang=en"><img
							src="Resources/img/flag_en.png" /> EN</a></li>
					<li><a href="?lang=fr"><img
							src="Resources/img/flag_fr.png" /> FR</a></li>
					<li><a href="?lang=zh"><img
							src="Resources/img/flag_zh.png" /> 中文</a></li>
				</ul>
			</li>

			<li><a href="/Tetris/displayGamesList"><i
					class="material-icons left">games</i>
				<spring:message code="link1.header" /></a></li>
			<li><a href="/Tetris/displayplayer"><i
					class="material-icons left">group</i>
				<spring:message code="link2.header" /></a></li>
			<li><a href="/Tetris/displaytetrimino"><i
					class="material-icons left">reorder</i>
				<spring:message code="link3.header" /></a></li>
			<li><a href="/Tetris/displayFAQ.xhtml"><i
					class="material-icons left">question_answer</i>
				<spring:message code="link4.header" /></a></li>
			<li><a class="waves-effect waves-light btn z-depth-4"
				href="/Tetris/disconnect"><spring:message code="button.header" /><i
					class="material-icons right">exit_to_app</i></a></li>
		</ul>
	</div>
	<tiles:insertAttribute name="header" /> </nav>
	<tiles:insertAttribute name="body" />
</body>
<script src="/Tetris/Resources/jquery-3.2.1.min.js"></script>
<script src="/Tetris/Resources/materialize/js/materialize.min.js"></script>
</html>