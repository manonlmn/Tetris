var app = angular.module("tpAngular");

app.controller("scoreController", function($scope, Page, topscoresResources) {
	Page.setTitle("Top Scores");
	$scope.topscores = topscoresResources.query();
});