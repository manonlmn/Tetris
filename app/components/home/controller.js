


app.controller("homeController", function($scope, Page, loginResources) {
	Page.setTitle("Accueil");

	$scope.player = loginResources.player;
});
