<div class="row" style="margin-left: auto; margin-right: auto; width: 900px">
	<form class="col s12" method="post">
		<div class="row">
			<div class="input-field col s1">
				<input disabled id="id" type="number" name="id"
					value="${myTetri.idTetrimino}"> <label for="id">Id</label>
			</div>

			<div class="input-field col s3">
				<input id="name" type="text" name="name"
					value="${myTetri.nameTetrimino}"
					placeholder="${nameNewTetrimino.message}"> <label
					for="name">Name of the Tetrimino</label>
			</div>
			<div class="input-field col s3">
				<input id="coef" type="number" min="0" name="coef"
					value="${myTetri.coef}" placeholder="${coefNewTetrimino.message}">
				<label for="coef">Coefficient of the Tetrimino</label>
			</div>
			<div class="input-field col s2">
				<input id="colour" type="color" name="colour"
					value="${myTetri.colourTetrimino}"
					placeholder="${colourNewTetrimino.message}"> <label
					for="colour">Colour of the Tetrimino</label>
			</div>
			<div class="input-field col s3">
				<button class="btn waves-effect waves-light" type="submit">
					Modify<i class="material-icons right ">save</i>
				</button>
			</div>
		</div>
	</form>
</div>