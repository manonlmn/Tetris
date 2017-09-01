<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div style="margin-left: auto; margin-right: auto; width: 900px">
	<table>
		<thead>
			<tr>
				<th style="text-align: center;"><spring:message code="modF.id"/></th>
				<th style="text-align: center;"><spring:message code="modF.name"/></th>
				<th style="text-align: center;"><spring:message code="modF.coef"/></th>
				<th style="text-align: center;"><spring:message code="modF.color"/></th>
				<th style="text-align: center;"><spring:message code="modF.rotation"/></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td style="text-align: center;">${Tetrimino.idTetrimino}</td>
				<td style="text-align: center;">${Tetrimino.nameTetrimino}</td>
				<td style="text-align: center;">${Tetrimino.coef}</td>
				<td style="text-align: center;"><div class="chip z-depth-2"
						style="height:20px; width:100px; background-color:${Tetrimino.colourTetrimino};border-style: solid; border-width: 1px; border-color : #bdbdbd;"></div></td>
				<td style="text-align: center;">${figure.rotationNumber}</td>
			</tr>
		</tbody>
	</table>
</div>


<form:form action="doModifyFigure?id=${figure.idFigure }" method="POST">
	<!-- Affichage de la forme -->
	<div class="figure" style="margin-left: auto; margin-right: auto;">
		<c:forEach var="x" begin="0" end="4">
			<c:forEach var="y" begin="0" end="4">

				<c:set var="color" value="#c8e6c9" />

				<c:forEach items="${ListBlock}" var="blockExistant">
					<c:if test="${blockExistant.x == x && blockExistant.y == y}">
						<c:set var="color" value="${Tetrimino.colourTetrimino}" />
					</c:if>
				</c:forEach>

				<div id="${x}_${y}" class="bloc a"
					style="background-color: ${ color };">
					<a href="modifyBlock?x=${x}&y=${y}&id=${figure.idFigure}"></a>
				</div>
			</c:forEach>
		</c:forEach>
	</div>
	<!-- Affichage des boutons enregistrer et sauvergarder -->
	<div class="row"
		style="margin-left: auto; margin-right: auto; width: 250px;">
		<table>
			<tr>
				<td style="width: 250px; text-align: center">
					<button class="btn waves-effect waves-light" type="submit">
						<spring:message code="modF.save"/><i class="material-icons right">save</i>
					</button>
				</td>

			</tr>
		</table>
	</div>
</form:form>