
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="row">
<div class="col s6 offset-s3" style="margin-top : 150px">
<a class="waves-effect waves-light btn-large" href="/Tetris/displaytetrimino" style="width : 300px">
<i class="material-icons right">reorder</i><spring:message code="link3.header" /></a>
</div>
<div class="col s3 pull-s3" style="margin-top : 150px">
<a class="waves-effect waves-light btn-large" href="/Tetris/addTetrimino" style="width : 300px">
<i class="material-icons right">add_circle_outline</i><spring:message code="admin.addT" /></a>
</div>
<div class="col s6 offset-s3" style="margin-top : 15px">
<a class="waves-effect waves-light btn-large" href="/Tetris/displayplayer" style="width : 300px"> <i class="material-icons right">group</i><spring:message code="link2.header" /></a>
</div>
<div class="col s6 offset-s3" style="margin-top : 15px">
<a class="waves-effect waves-light btn-large" href="/Tetris/displayGamesList" style="width : 300px">
<i class="material-icons right">games</i><spring:message code="link1.header" /></a>
</div>
<div class="col s6 offset-s3" style="margin-top : 15px">
<a class="waves-effect waves-light btn-large" href="/Tetris/displayFAQ.xhtml" style="width : 300px"><i
					class="material-icons right">question_answer</i>
				<spring:message code="link4.header" /></a>
</div>
<div class="col s3 pull-s3" style="margin-top : 15px">
<a class="waves-effect waves-light btn-large" href="/Tetris/addFAQ.xhtml" style="width : 300px">
<i class="material-icons right">add_circle_outline</i><spring:message code="admin.addFAQ" /></a>
</div>
</div>