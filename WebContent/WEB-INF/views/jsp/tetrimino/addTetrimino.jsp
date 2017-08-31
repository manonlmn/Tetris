<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="row" style="margin-left: auto; margin-right: auto; width: 900px">
	<form:form method="post" action="doAddTetrimino" modelAttribute="newTetrimino" class="col s12">
		<div class="row">
			<div class="input-field col s3">
				<form:input path="nameTetrimino" id="name" type="text"/>
				<form:label path="nameTetrimino"><spring:message code="addT.name"/></form:label>
				<form:errors path="nameTetrimino"/>
			</div>
			<div class="input-field col s3">
				<form:input path="coef" id="coef" type="number" min="0"/>
				<form:label path="coef"><spring:message code="addT.coef"/></form:label>
				<form:errors path="coef"/>
			</div>
			<div class="input-field col s2">
				<form:input path="colourTetrimino" id="color" type="color"/>
				<form:label path="colourTetrimino"><spring:message code="addT.colour"/></form:label>
				<form:errors path="colourTetrimino"/>
			</div>
			<div class="input-field col s4">
				<button class="btn waves-effect waves-light" type="submit">
					<spring:message code="addT.button"/><i class="material-icons right">save</i>
				</button>
			</div>
		</div>
	</form:form>
</div>