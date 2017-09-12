var app = angular.module("tpAngular");

app.controller("playController", function($scope, Page, tetrisBoard, tetrisScore, playResources, gameResources) {

		Page.setTitle("Jouer");

		var game = null;
		$scope.isHidden = true;
		$scope.isActiv = false;
		$scope.isChoiceVS = false;
		$scope.games = gameResources.query();

	//initialisation pour les selects :
	$(document).ready(function() {
	    $('select').material_select();
	 });
		/*
		 * Fonction de démarrage de la partie
		 */
		$scope.start = function() {
			tetrisBoard.start();

			angular.element(tetrisBoard).on('gameOver', this.onGameOver);
		};

		//creation partie solo
		$scope.newSolo = function(){
			game = gameResources.add(
				{
	        player1 : {idPerson : 7},
					status : false, //statut de la partie true pour finie et false pour en cours
					type : false //boolean pour le type de partie : false = solo & true = vs
				});
				$scope.isHidden = false;
				$scope.isActiv = true;
			};

			$scope.newVS = function(){
				game = gameResources.add(
					{
		        player1 : {idPerson : 7},
						status : false, //statut de la partie true pour finie et false pour en cours
						type : true //boolean pour le type de partie : false = solo & true = vs
					});
					$scope.isChoiceVS = false;
					$scope.isActiv = true;
				};

		/*
		 * Fonction de game over
		 */
		$scope.onGameOver = function() {
			angular.element(tetrisBoard).off('gameOver', this.onGameOver);
			game.status = true;
			gameResources.save({id:game.idGame}, game);
			//ajout du score dans la bdd
			playResources.add({
			level : tetrisScore.level,
			lines : tetrisScore.lines,
			points : tetrisScore.points,
			game : game, //modification de la partie -> changement du status en true + récupération de l'idée pour modifs,
			player : {idPerson : 7}});
			alert("Game Over !");

			game = null;
			$scope.isHidden = true;
			$scope.isActiv = false;
		};

		$scope.choiceVS = function(){
			$scope.isHidden = false;
			$scope.isChoiceVS = true;
		}
	});
