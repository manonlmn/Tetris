<div style="margin-left: auto; margin-right: auto; width: 900px">
	<table>
		<thead>
			<tr>
				<th style="text-align: center;">Id</th>
				<th style="text-align: center;">Tetrimino's Name</th>
				<th style="text-align: center;">Coefficient</th>
				<th style="text-align: center;">Color</th>
				<th style="text-align: center;">Order of rotation</th>
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
<form method="POST">
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
						Save<i class="material-icons right">save</i>
					</button>
				</td>

			</tr>
		</table>
	</div>
</form>