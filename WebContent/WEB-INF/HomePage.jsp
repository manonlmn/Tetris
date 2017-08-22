<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--Import materialize.css-->

<link rel="stylesheet" href="Resources/materialize/css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">


<title>Homepage</title>
</head>
<body class="green lighten-5">
	<nav>
	<div class="nav-wrapper amber lighten-2">
		<a href="home" class="brand-logo">Home Page</a>
		
	</div>
	</nav>

	<div class="row">
		<form class="col s12" method="post">
			<div class="row">
				<div class="input-field col s5">
					<input id="username" type="text" class="validate" name="username">
					<label for="username">Username</label>
				</div>

				<div class="input-field col s5">
					<input id="password" type="password" class="validate"
						name="password"> <label for="password">Password</label>
				</div>
				<div class="input-field col s2">
					<button class="btn waves-effect waves-light" type="submit">
						Submit <i class="material-icons right">send</i>
					</button>
				</div>
			</div>
		</form>
	</div>
		<div class="fixed-action-btn left">
		<a class="btn-floating btn-large waves-effect waves-light red"
			href="newplayer"><i class="medium material-icons">add</i></a>
	</div>
</body>

<script src="Resources/jquery-3.2.1.min.js"></script>
<script src="Resources/materialize/js/materialize.min.js"></script>

</html>