
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="row"
	style="margin-left: auto; margin-right: auto; width: 1000px">
	<form class="col s12" method="post">
		<div class="row">
			<div class="input-field col s5">
				<i class="material-icons prefix">account_circle</i> 
				<input id="username" type="text" class="validate" name="username">
				<label for="username"><spring:message code="home.username" /></label>
			</div>

			<div class="input-field col s4">
				<input id="password" type="password" class="validate"
					name="password"> <label for="password"><spring:message
						code="home.pwd" /></label>
			</div>
			<div class="input-field col s3">
				<button class="btn waves-effect waves-light" type="submit">
					<spring:message code="home.button" />
					<i class="material-icons right">send</i>
				</button>
			</div>
		</div>
	</form>
</div>