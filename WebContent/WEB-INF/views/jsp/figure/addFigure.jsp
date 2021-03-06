<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<form:form action="doAddFigure?id=${Tetrimino.idTetrimino }" method="POST" modelAttribute="newFigure">
	<div class="row"
		style="margin-left: auto; margin-right: auto; width: 900px">
		<table>
			<thead>
				<tr>
					<th style="text-align: center;"><spring:message code="AddF.name"/></th>
					<th style="text-align: center;"><spring:message code="AddF.color"/></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td style="text-align: center;">${Tetrimino.nameTetrimino }</td>
					<td style="text-align: center;"><div class="chip z-depth-2"
							style="height:20px; width:100px; background-color:${Tetrimino.colourTetrimino};border-style: solid; border-width: 1px; border-color : #bdbdbd;"></div></td>

				</tr>
			</tbody>
		</table>
	</div>

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
					<a href="AddBlock?x=${x}&y=${y}&id=${Tetrimino.idTetrimino}"></a>
				</div>
			</c:forEach>
		</c:forEach>
	</div>
	<div class="row"
		style="margin-left: auto; margin-right: auto; width: 250px;">
		<div class="input-field col s12">
			<form:input id="rotationNumber" path="rotationNumber" type="number" min="1" max="4" class="validate"/>
			<form:label path="rotationNumber"><spring:message code="AddF.rotation"/></form:label>
			<form:errors path="rotationNumber" style="color :#d32f2f "/>
		</div>
	</div>
	<div class="row"
		style="margin-left: auto; margin-right: auto; width: 420px;">
		<table>
			<tr>
				<td style="width: 210px; text-align: center">
					<button class="btn waves-effect waves-light" type="submit">
						<spring:message code="AddF.save"/><i class="material-icons right">save</i>
					</button>
				</td>
				<td style="width: 210px; text-align: center;">
					<a href="resetFigure?id=${Tetrimino.idTetrimino}">
					<button class="btn waves-effect waves-light" type="button"><spring:message code="AddF.reset"/><i class="material-icons right">clear_all</i></button>
					</a>
				</td>
			</tr>
		</table>
	</div>
</form:form>