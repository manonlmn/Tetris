var app = angular.module("tpAngular");

app.controller("tetriController", function($scope, Page, tetriResources) {
	Page.setTitle("Liste des Tetriminos");

  $scope.tetriminos = tetriResources.query();

});
