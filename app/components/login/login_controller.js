var app = angular.module("tpAngular");

app.controller("loginController", function($scope, $resource, Page, playerResources, loginResources, $location) {
	Page.setTitle("Connexion");
	
	$scope.player = {
		username: "",
		password: ""
	};
	
	
	$scope.login = function() 
	{
		
		loginResources.player = playerResources.recuperer($scope.player, function() {
			
			$location.path("/");
		});
	};
	
});