<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="row">
	<div class="col s1"></div>
	<div class="col s4">	
	<h4 style="text-align : right"><spring:message code="displayG.tab2" /></h4>
		<div class="divider"></div>
		<table >
			<thead>
				<tr>
					<th style="text-align : right"><spring:message code="displayG.id" /></th>
					<th style="text-align : right"><spring:message code="displayG.UsernameP1" /></th>
					<th style="text-align : right"><spring:message code="displayG.scoreP1" /></th>
					<th style="text-align : right"><spring:message code="displayG.status" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${GamesListSolo}" var="Game">
					<tr>
						<td style="text-align : right">${Game.idGame}</td>
						<td style="text-align : right">${Game.player1.username}</td>
						<td style="text-align : right">${Game.scoreA.points}</td>
						<td style="text-align : right"><c:if test="${Game.status == true}">
								<spring:message code="statusG.Over" />
							</c:if>
							<c:if test="${Game.status == false }">
								<spring:message code="statusG.IP" />
							</c:if></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	
	</div>
	<div class="col s1"></div>
	<div class="col s4">
	<h4><spring:message code="displayG.tab1" /></h4>
		<div class="divider"></div>
		<table>
			<thead>
				<tr>
					<th><spring:message code="displayG.id" /></th>
					<th><spring:message code="displayG.UsernameP1" /></th>
					<th><spring:message code="displayG.scoreP1" /></th>
					<th><spring:message code="displayG.VS" /></th>
					<th><spring:message code="displayG.UsernameP2" /></th>
					<th><spring:message code="displayG.scoreP2" /></th>
					<th><spring:message code="displayG.status" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${GamesListMulti}" var="Game">
					<tr>
						<td>${Game.idGame}</td>
						<td>${Game.player1.username}</td>
						<td>${Game.scoreA.points}</td>
						<td>VS</td>
						<td>${Game.player2.username}</td>
						<td>${Game.scoreB.points}</td>
						<td><c:if test="${Game.status == true}">
								<spring:message code="statusG.Over" />
							</c:if>
							<c:if test="${Game.status == false }">
								<spring:message code="statusG.IP" />
							</c:if></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>
	<div class="col s1"></div>
	</div>
</div>