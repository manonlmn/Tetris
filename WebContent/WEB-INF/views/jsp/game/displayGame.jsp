<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div style="margin-left: auto; margin-right: auto; width: 900px">
	<table>
		<thead>
			<tr>
				<th><spring:message code="<spring:message code="displayG.id"/>"/></th>
				<th><spring:message code="displayG.UsernameP1"/></th>
				<th><spring:message code="displayG.scoreP1"/></th>
				<th><spring:message code="displayG.VS"/></th>
				<th><spring:message code="displayG.UsernameP2"/></th>
				<th><spring:message code="displayG.scoreP2"/></th>
				<th><spring:message code="displayG.status"/></th>
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
					<td><c:if test="${Game.status == true}"><spring:message code="statusG.Over"/></c:if><c:if test="${Game.status == false }"><spring:message code="statusG.IP"/></c:if></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</div>