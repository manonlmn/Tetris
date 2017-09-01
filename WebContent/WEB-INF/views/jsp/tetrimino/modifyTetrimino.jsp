<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="row" style="margin-left: auto; margin-right: auto; width: 900px">
	<form:form class="col s12" method="post" action="doModifyTetri" modelAttribute="tetritoModify">
		<div class="row">
			<div class="input-field col s1">
				<form:input path="idTetrimino" id="name" type="text"/>
				<form:label path="idTetrimino"><spring:message code="addT.id"/></form:label>
				<form:errors path="idTetrimino" style="color :#d32f2f "/>
			</div>

			<div class="input-field col s3">
				<form:input path="nameTetrimino" id="name" type="text"/>
				<form:label path="nameTetrimino"><spring:message code="addT.name"/></form:label>
				<form:errors path="nameTetrimino" style="color :#d32f2f "/>
			</div>
			<div class="input-field col s3">
				<form:input path="coef" id="coef" type="number" min="0"/>
				<form:label path="coef"><spring:message code="addT.coef"/></form:label>
				<form:errors path="coef" style="color : #d32f2f"/>
			</div>
			<div class="input-field col s2">
				<form:input path="colourTetrimino" id="color" type="color"/>
				<form:label path="colourTetrimino"><spring:message code="addT.colour"/></form:label>
				<form:errors path="colourTetrimino" style="color : #d32f2f"/>
			</div>
			<div class="input-field col s3">
				<button class="btn waves-effect waves-light" type="submit">
					<spring:message code="modT.button"/><i class="material-icons right ">save</i>
				</button>
			</div>
		</div>
	</form:form>
</div>