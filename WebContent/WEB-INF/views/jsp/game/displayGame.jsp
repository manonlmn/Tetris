<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div style="margin-left: auto; margin-right: auto; width: 900px">
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Player1</th>
				<th>Score</th>
				<th>VS</th>
				<th>Player2</th>
				<th>Score</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${GamesList}" var="Game">
				<tr>
					<td>${Game.idGame}</td>
					<td>${Game.player1.username}</td>
					<td>${Game.scoreA.points}</td>
					<td><c:if test="${empty Game.player2}"></c:if> <c:if
							test="${not empty Game.player2}">VS</c:if></td>
					<td><c:if test="${not empty Game.player2.username}">${Game.player2.username}</c:if>
					</td>
					<td><c:if test="${not empty Game.player2.username}">${Game.scoreB.points}</c:if>
					</td>
					<td>${Game.status}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</div>