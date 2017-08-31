<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div style="margin-left: auto; margin-right: auto; width: 900px">
	<table>
		<thead>
			<tr>
				<th style="text-align: center;"><spring:message code="displayT.id"/></th>
				<th style="text-align: center;"><spring:message code="displayT.name"/></th>
				<th style="text-align: center;"><spring:message code="displayT.coef"/></th>
				<th style="text-align: center;"><spring:message code="displayT.colour"/></th>
				<th style="text-align: center;"></th>
				<th style="text-align: center;"></th>
				<th style="text-align: center;"></th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${TetriminoList}" var="Tetrimino">
				<tr>
					<td style="text-align: center;">${Tetrimino.idTetrimino}</td>
					<td style="text-align: center;">${Tetrimino.nameTetrimino }</td>
					<td style="text-align: center;">${Tetrimino.coef }</td>
					<td style="text-align: center;"><div class="chip z-depth-2"
							style="height:20px; width:100px; background-color:${Tetrimino.colourTetrimino};border-style: solid; border-width: 1px; border-color : #bdbdbd;"></div></td>
					<td style="text-align: center;"><a
						href="ModifyTetrimino?id=${Tetrimino.idTetrimino}"
						class="secondary-content"><i class="material-icons">mode_edit</i></a></td>
					<td style="text-align: center;"><a
						href="DeleteTetrimino?id=${Tetrimino.idTetrimino}"
						class="secondary-content"><i class="material-icons">delete</i></a></td>
					<td style="text-align: center;"><a
						href="ListFiguresTetrimino?id=${Tetrimino.idTetrimino}"
						class="secondary-content"> <i class="material-icons">library_books</i></a>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</div>