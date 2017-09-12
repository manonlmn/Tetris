var app = angular.module("tpAngular");

app.controller("playController", function($scope, Page, tetrisBoard, tetrisScore, playResources) {

		Page.setTitle("Jouer");


		/*
		 * Fonction de démarrage de la partie
		 */
		$scope.start = function() {
			tetrisBoard.start();

			angular.element(tetrisBoard).on('gameOver', this.onGameOver);
		};



		/*
		 * Fonction de game over
		 */
		$scope.onGameOver = function() {
			angular.element(tetrisBoard).off('gameOver', this.onGameOver);
			playResources.add({
			level : tetrisScore.level,
			lines : tetrisScore.lines,
			points : tetrisScore.points,
			game : {idGame : 2},
			player : {idPerson : 7}});
		}
	});
