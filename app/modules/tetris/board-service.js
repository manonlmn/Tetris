tetrisModule.service("tetrisBoard", ['tetris', 'tetrisGhost', 'tetrisScore', function(tetris, tetrisGhost, tetrisScore) {
	var that = this; //Permet de retrouver la référence dans les fonctions anonymes (closure)

	this.autoTetris = null; //Permet d'appliquer un intervale pour le défilement des tetriminos
	this.autoTetrisInterval = 1000; //Intervale de temps (en ms) pour le défilement des tetriminos


	/*
	* Démarrer la partie
	*/
	this.start = function() {
		angular.element('.board').children().remove();
		tetrisGhost.setBoard(angular.element('.board'));

		tetris.init();
		angular.element('.board').append(tetris.createTetrimino());

		this.nextMove();
	};



	/*
	* Préparation du prochain tetrimino
	*/
	this.nextMove = function() {
		//On vérifie si on a un tetrimino à suivre
		if (angular.element('.next-tetrimino .tetrimino').length) {
			//Si c'est le cas, on l'utilise comme tetrimino  à jouer
			angular.element('.board').append(angular.element('.next-tetrimino .tetrimino'));
		}

		//On supprime l'ancien tetrimino à suivre
		angular.element('.next-tetrimino').children().remove();

		//On demande un nouveau tetrimino, et on l'ajoute comme tetrimino à suivre
		angular.element('.next-tetrimino').append(tetris.createTetrimino());

		//On indique au Tetris la pièce utilisée, et on met à jour le fantôme
		tetris.tetrimino = angular.element('.board .tetrimino');
		tetrisGhost.update();

		//On prépare l'intervale pour que la pièce descende automatiquement toutes les secondes
		clearInterval(this.autoTetris);
		this.autoTetris = setInterval(function() {
			tetris.moveToBottom();
		}, (that.autoTetrisInterval / tetrisScore.level));
	};



	/*
	 * Interception des touches
	 */
	angular.element(document).on('keydown', function(e) {
		var prevent = true;

		switch (e.keyCode) {
			case 13: tetris.pause(); break;
			case 37: tetris.moveToLeft(); break;
			case 38: tetris.changeFigure(); break;
			case 39: tetris.moveToRight(); break;
			case 40: tetris.moveToBottom(); break;
			case 32:
				tetris.hit(tetrisGhost.tetriPosition);
				tetris.moveToBottom();
				break;
			default: prevent = false; break;
		}

		if (prevent) {
			e.preventDefault();
		}
	});





	/*
	 * Interception d'un coup joué
	 */
	angular.element(tetris).on('hitPlayed', function() {
		tetris.tetrimino.css('top', (tetris.tetriPosition.y * tetris.sizeOfTetriminos) + 'px');
		tetris.tetrimino.css('left', (tetris.tetriPosition.x * tetris.sizeOfTetriminos) + 'px');
	});







	/*
	 * Interception d'un Tetrimino placé
	 */
	angular.element(tetris).on('tetriminoPut', function(e, blocPositions) {
		blocPositions.forEach(function(blocPosition) {
			var myNewBloc = tetris.tetrimino.find('.bloc:nth-child(1)').clone();

			myNewBloc.attr('data-ligne', blocPosition.y);
			myNewBloc.css('background', tetris.tetrimino.find('.bloc:nth-child(1)').css('background'));
			myNewBloc.css('top', (blocPosition.y * tetris.sizeOfTetriminos));
			myNewBloc.css('left', (blocPosition.x * tetris.sizeOfTetriminos));

			angular.element('.board').append(myNewBloc);
		});


		angular.element('.board .tetrimino').remove();
		that.nextMove();
	});



	/*
	 * Interception d'une (ou plusieurs) ligne(s) complétée(s)
	 */
	angular.element(tetris).on('rowsCompleted', function(e, completedRows) {
		tetrisScore.score(completedRows.length);

		completedRows.forEach(function(row) {
			angular.element('.bloc[data-ligne="' + row + '"]').addClass('removing');
		});


		setTimeout(function() {
			completedRows.forEach(function(row) {
				angular.element('.bloc[data-ligne="' + row + '"]').remove();


				for (var i = row + 1; i > 0; i--) {
					angular.element('.bloc[data-ligne="' + (i - 1) + '"]').each(function() {
						angular.element(this).attr('data-ligne', i);
						angular.element(this).css('top', (i * tetris.sizeOfTetriminos));
					});
				}
			});
		}, 250);
	});



	/*
	 * Interception d'une modification du score
	 */
	angular.element(tetrisScore).on('scoring', function() {
		angular.element('.score > span').html(tetrisScore.points);
		angular.element('.score > small > span').html(tetrisScore.lines);
	});



	/*
	 * Interception du game over
	 */
	angular.element(tetris).on('gameOver', function() {
		angular.element(that).trigger('gameOver');
	});
}]);
