<div class="row" style="margin-left: auto; margin-right: auto; width: 900px">
	<form class="col s12" method="post">
		<div class="row">
			<div class="input-field col s3">
				<input id="name" type="text" name="nameNewTetrimino"
					placeholder="${nameNewTetrimino.message}"> <label
					for="name">Name of the Tetrimino</label>
			</div>
			<div class="input-field col s3">
				<input id="coef" type="number" min="0" name="coefNewTetrimino"
					placeholder="${coefNewTetrimino.message}"> <label
					for="name">Coefficient of the Tetrimino</label>
			</div>
			<div class="input-field col s3">
				<input id="color" type="color" name="colourNewTetrimino"
					placeholder="${colourNewTetrimino.message}"> <label
					for="color">Color of the Tetrimino</label>
			</div>
			<div class="input-field col s3">
				<button class="btn waves-effect waves-light" type="submit">
					Save<i class="material-icons right">save</i>
				</button>
			</div>
		</div>
	</form>
</div>