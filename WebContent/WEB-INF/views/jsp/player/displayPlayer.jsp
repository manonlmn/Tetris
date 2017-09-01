<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div style="margin-left: auto; margin-right: auto; width: 900px">
	<table>
		<thead>
			<tr>
				<th style="text-align : center"><spring:message code="displayP.id"/></th>
				<th style="text-align : center"><spring:message code="displayP.FN"/></th>
				<th style="text-align : center"><spring:message code="displayP.LN"/></th>
				<th style="text-align : center"><spring:message code="displayP.username"/></th>
				<th style="text-align : center"><spring:message code="displayP.ban"/></th>
				<th style="text-align : center"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${PlayersList}" var="player">
				<tr>
					<td style="text-align : center">${player.idPerson}</td>
					<td style="text-align : center">${player.lastName}</td>
					<td style="text-align : center">${player.name}</td>
					<td style="text-align : center">${player.username}</td>
					<td style="text-align : center"><c:if test="${player.banned == false}"><spring:message code="displayP.ban.Y"/></c:if> <c:if
							test="${player.banned == true}"><spring:message code="displayP.ban.N"/></c:if></td>
					<td style="text-align : center"><c:if test="${player.banned == false}">
							<a href="BanPlayer?id=${player.idPerson}"
								class="secondary-content"><i class="material-icons">block</i></a>
						</c:if> <c:if test="${player.banned == true}">
							<a href="BanPlayer?id=${player.idPerson}"
								class="secondary-content"><i class="material-icons">check</i></a>
						</c:if></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>