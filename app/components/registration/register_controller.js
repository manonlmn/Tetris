var app = angular.module("tpAngular");

app.controller("registerController", function($scope, Page, registerResources, $location, loginResources) {
	
	Page.setTitle("Inscription");
	
	$scope.newplayer = {
		username: "",
		password: "",
		lastName: "",
		name: "",
		banned: false
	};
	
	$scope.sinscrire = function() 
	{
		registerResources.ajouter(this.newplayer, function() {
			$location.path("/Login");
		});
	};
	
});