var app = angular.module("tpAngular");

app.controller("playController", function($scope, Page, tetrisBoard, tetrisScore, playResources, gameResources) {

		Page.setTitle("Jouer");

		var game = null;
		$scope.isHidden = true;
		$scope.isActiv = false;
		/*
		 * Fonction de démarrage de la partie
		 */
		$scope.start = function() {
			tetrisBoard.start();

			angular.element(tetrisBoard).on('gameOver', this.onGameOver);
		};

		//creation partie solo
		$scope.newSolo = function(){
      gameResources.add(
				this.game : {
	        player1 : {idPerson : 7},
					status : false, //statut de la partie true pour finie et false pour en cours
					type : false //boolean pour le type de partie : false = solo & true = vs
				};
		)};

		/*
		 * Fonction de game over
		 */
		$scope.onGameOver = function() {
			angular.element(tetrisBoard).off('gameOver', this.onGameOver);
			//ajout du score dans la bdd
			playResources.add({
			level : tetrisScore.level,
			lines : tetrisScore.lines,
			points : tetrisScore.points,
			gameResources.save({ id: this.game.idGame },), //modification de la partie -> changement du status en true + récupération de l'idée pour modifs,
			player : {idPerson : 7}});
		}
	});
