var app = angular.module("tpAngular");

app.controller("playController", function($scope, Page, tetrisBoard, tetrisScore, playResources, gameResources, playerResources, loginResources) {

		Page.setTitle("Jouer");

		var game = {};
		$scope.isHidden = true;
		$scope.isActiv = false;
		$scope.isChoiceVS = false;
		$scope.games = gameResources.query(function() {
			setTimeout(function() {
				$('select').material_select();
			}, 100);
		});

		var joueur = loginResources.player;



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
	        player1 : joueur,
					status : false, //statut de la partie true pour finie et false pour en cours
					type : false //boolean pour le type de partie : false = solo & true = vs
				});
				$scope.isHidden = false;
				$scope.isActiv = true;
			};

			$scope.newVS = function(){
				game = gameResources.add(
					{
		        player1 : joueur,
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
			gameResources.save({id:game.idGame}, game);//modification de la partie -> changement du status en true + récupération de l'idpour modifs,
			//ajout du score dans la bdd
			playResources.add({
			level : tetrisScore.level,
			lines : tetrisScore.lines,
			points : tetrisScore.points,
			game : game,
			player : joueur});
			alert("Game Over !");

			game = {};
			$scope.isHidden = true;
			$scope.isActiv = false;
			//trouver un moyen de reinit le board de tetris
		};

		$scope.choiceVS = function(){
			$scope.isHidden = false;
			$scope.isChoiceVS = true;
		}

		$scope.secondPlayerVS = function(){
			game.idGame = $scope.selectedGame;
			game.player2 = joueur;
			gameResources.save({id:game.idGame}, game);
			$scope.isChoiceVS = false;
			$scope.isActiv = true;
		}
	});
