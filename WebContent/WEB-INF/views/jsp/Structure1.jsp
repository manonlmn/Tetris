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
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<c:set var="titleCode" scope="request">
	<tiles:insertAttribute name="title" ignore="true" />
</c:set>
<title><spring:message code="${ titleCode }" /></title>
</head>
<body class="green lighten-5">
	<nav class="z-depth-4">
	<div class="nav-wrapper amber lighten-2">
		<a href="home" class="brand-logo"><spring:message
				code="${ titleCode }" /></a>
	</div>
	</nav>

	<tiles:insertAttribute name="body" />
</body>
<script src="/Tetris/Resources/jquery-3.2.1.min.js"></script>
<script src="/Tetris/Resources/materialize/js/materialize.min.js"></script>
</html>