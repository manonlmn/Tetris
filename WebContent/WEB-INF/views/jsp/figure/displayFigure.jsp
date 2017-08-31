<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div style="margin-left: auto; margin-right: auto; width: 900px">

	<table>
		<thead>
			<tr>
				<th style="text-align: center;">Id</th>
				<th style="text-align: center;">Tetrimino's Name</th>
				<th style="text-align: center;">Coefficient</th>
				<th style="text-align: center;">Color</th>
			</tr>
		</thead>

		<tbody>
			<tr>
				<td style="text-align: center;">${Tetrimino.idTetrimino}</td>
				<td style="text-align: center;">${Tetrimino.nameTetrimino }</td>
				<td style="text-align: center;">${Tetrimino.coef }</td>
				<td style="text-align: center;"><div class="chip z-depth-2" style="height:20px; width:100px; background-color:${Tetrimino.colourTetrimino};border-style: solid; border-width: 1px; border-color : #bdbdbd;"></div></td>
			</tr>
		</tbody>
	</table>

	<c:if test="${empty Tetrimino.myFigures }">
		No figures were assigned to this tetrimino yet.<br />
	</c:if>
	<c:if test="${not empty Tetrimino.myFigures }">

		<table>
			<tr>
				<c:forEach items="${Tetrimino.myFigures }" var="figure">
					<td style="text-align: center">Rotation
						No.${figure.rotationNumber }
						<table
							style="padding: 5px; margin-left: auto; margin-right: auto; width: 200px; height: 200px; border: solid 1px #c8e6c9">

							<c:forEach var="x" begin="0" end="4">
								<tr>
									<c:forEach var="y" begin="0" end="4">
										<c:set var="color" value="#e8f5e9 " />
										<c:forEach items="${figure.myBlocks}" var="blockExistant">
											<c:if test="${blockExistant.x == x && blockExistant.y == y}">
												<c:set var="color" value="${Tetrimino.colourTetrimino}" />
											</c:if>
										</c:forEach>
										<td id="${x}_${y}" class="bloc a"
											style="background-color: ${ color }; width: 40px; height: 40px; border-radius:0px">
										</td>
									</c:forEach>
								</tr>
							</c:forEach>
							<tr>

								<td style="text-align: center; width: 40px; height: 40px;"><a
									href="modifyFigure?id=${figure.idFigure}"
									class="secondary-content"><i class="material-icons">mode_edit</i></a></td>
								<td style="text-align: center; width: 40px; height: 40px;"><a
									href="deleteFigure?id=${figure.idFigure}"
									class="secondary-content"><i class="material-icons">delete</i></a></td>
								<td style="text-align: center; width: 40px; height: 40px;"></td>
								<td style="text-align: center; width: 40px; height: 40px;"><a
									href="leftOffsetFigure?id=${figure.idFigure}"
									class="secondary-content"><i class="material-icons">navigate_before</i></a></td>
								<td style="text-align: center; width: 40px; height: 40px;"><a
									href="rightOffsetFigure?id=${figure.idFigure}"
									class="secondary-content"><i class="material-icons">navigate_next</i></a></td>

							</tr>

						</table>
					</td>
				</c:forEach>
			</tr>
		</table>

	</c:if>

</div>