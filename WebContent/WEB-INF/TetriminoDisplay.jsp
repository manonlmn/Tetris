<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="materialize/css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<nav>
	<div class="nav-wrapper  cyan darken-4">
		<a href="#" class="brand-logo">Home Page</a>
		<ul id="nav-mobile" class="right hide-on-med-and-down">
			<li><a href="displayplayer">Players' list</a></li>
			<li><a href="displaytetrimino">Tetriminos' list</a></li>
		</ul>
	</div>
	</nav>
	
	<ul class="collection with-header">
        <li class="collection-header"><h4>List of the available Tetriminos</h4></li>
        
        <li class="collection-item"><div>Alvin<a href="#!" class="secondary-content"><i class="material-icons">mode_edit</i></a><a href="#!" class="secondary-content"><i class="material-icons">delete</i></a></div></li>
        <li class="collection-item"><div>Alvin<a href="#!" class="secondary-content"><i class="material-icons">mode_edit</i></a><a href="#!" class="secondary-content"><i class="material-icons">delete</i></a></div></li>
        <li class="collection-item"><div>Alvin<a href="#!" class="secondary-content"><i class="material-icons">mode_edit</i><a href="#!" class="secondary-content"><i class="material-icons">delete</i></a></a></div></li>
        <li class="collection-item"><div>Alvin<a href="#!" class="secondary-content"><i class="material-icons">mode_edit</i><a href="#!" class="secondary-content"><i class="material-icons">delete</i></a></a></div></li>
      </ul>
</body>
<script src="jquery-3.2.1.min.js"></script>
<script src="materialize/js/materialize.min.js"></script>
</html>