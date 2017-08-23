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
<title>Registration</title>
</head>
<body class="green lighten-5">
	<nav>
	<div class="nav-wrapper amber lighten-2">
		<a href="home" class="brand-logo">Home Page</a>
	</div>
	</nav>

	<div class="row">
		<form class="col s12" method="post">
			
						<div class="input-field col s6 offset-s3">
							<input type="text" name="usernameField" id="usernameField">
								<label for="usernameField">Your Username</label>
						</div>
				
						<div class="input-field col s6 offset-s3">
							<input type="password" name="passwordField" id="passwordField">
							<label for="passwordField">Your Password</label>
						</div>
					
						<div class="input-field col s6 offset-s3">
							<input type="password" name="confirmPasswordField" id="confirmPasswordField">
							<label for="confirmPasswordField">Confirm your password</label>
						</div>
					
						<div class="input-field col s6 offset-s3">
							<input type="text" name="firstNameField" id="firstNameField">
							<label for="firstNameField">Your first name</label>
						</div>
					
						<div class="input-field col s6 offset-s3">
							<input type="text" name="lastNameField" id="lastNameField">
							<label for="lastNameField">Your first name</label>
						</div>
				
						<div class="input-field col s6 offset-s5">
							<button class="btn waves-effect waves-light teal darken-3" type="submit">Register<i class="material-icons right">save</i></button>
						</div>
			
		</form>
	</div>

</body>

<script src="Resources/jquery-3.2.1.min.js"></script>
<script src="Resources/materialize/js/materialize.min.js"></script>
</html>