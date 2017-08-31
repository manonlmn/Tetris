<div style="margin-left: auto; margin-right: auto; width: 900px">
	<table>
		<thead>
			<tr>
				<th style="text-align: center;">Id</th>
				<th style="text-align: center;">Tetrimino's Name</th>
				<th style="text-align: center;">Coefficient</th>
				<th style="text-align: center;">Color</th>
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
						href="ModifyItem?id=${Tetrimino.idTetrimino}"
						class="secondary-content"><i class="material-icons">mode_edit</i></a></td>
					<td style="text-align: center;"><a
						href="DeleteItem?id=${Tetrimino.idTetrimino}"
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