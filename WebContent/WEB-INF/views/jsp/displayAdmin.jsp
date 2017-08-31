
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<nav class="nav-extended z-depth-4">
	<div class="nav-wrapper amber lighten-2">
		<a href="/Tetris/home" class="brand-logo">Home Page</a>
		<ul id="nav-mobile" class="right hide-on-med-and-down">
			<li><a href="/Tetris/displayGamesList">Games list</a></li>
			<li><a href="/Tetris/displayplayer">Players' list</a></li>
			<li><a href="/Tetris/displaytetrimino">Tetriminos' list</a></li>
			<li><a class="waves-effect waves-light btn z-depth-4"
				href="/Tetris/disconnect">Quit<i class="material-icons right">exit_to_app</i></a></li>
		</ul>
	</div>
	<div class="nav-content amber lighten-2">
		<span class="nav-title"><spring:message code="message.welcome"
				arguments="${username}" /></span>
	</div>
</nav>