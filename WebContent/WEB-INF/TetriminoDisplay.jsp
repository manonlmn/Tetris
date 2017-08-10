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
<title>Display of the Tetriminos</title>
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
	<h5>List of the Tetriminos</h5>
	<table>
        <thead>
          <tr>
              <th>Id</th>
              <th>Tetrimino's Name</th>
              <th>Color</th>
              <th></th>
              <th></th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td>id1</td>
            <td>nom1</td>
            <td>coleur1</td>
            <td><a href="#!" class="secondary-content"><i class="material-icons">mode_edit</i></a></td>
            <td><a href="#!" class="secondary-content"><i class="material-icons">delete</i></a></td>
          </tr>
          <tr>
            <td>Alan</td>
            <td>Jellybean</td>
            <td>$3.76</td>
            <td><a href="#!" class="secondary-content"><i class="material-icons">mode_edit</i></a></td>
            <td><a href="#!" class="secondary-content"><i class="material-icons">delete</i></a></td>
          </tr>
       
        </tbody>
      </table>
      <div class="fixed-action-btn left">
      	<a class="btn-floating btn-large waves-effect waves-light red"><i class="medium material-icons">add</i></a>
      </div>
</body>
<script src="jquery-3.2.1.min.js"></script>
<script src="materialize/js/materialize.min.js"></script>
</html>