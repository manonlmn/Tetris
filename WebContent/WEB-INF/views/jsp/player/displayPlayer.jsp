<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div style="margin-left: auto; margin-right: auto; width: 900px">
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>First name</th>
				<th>Last name</th>
				<th>Username</th>
				<th>Ban</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${PlayersList}" var="player">
				<tr>
					<td>${player.idPerson}</td>
					<td>${player.lastName}</td>
					<td>${player.name}</td>
					<td>${player.username}</td>
					<td><c:if test="${player.banned == false}">No</c:if> <c:if
							test="${player.banned == true}">Yes</c:if></td>
					<td><c:if test="${player.banned == false}">
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