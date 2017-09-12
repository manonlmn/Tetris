var app = angular.module("tpAngular", [ 'ngRoute', 'ngResource' , 'tetrisModule']);

app.constant("API_URL", "http://localhost:8080/Tetris/api");

//Configuration du Tetris
app.config(function(tetrisProvider, tetriminosProvider, API_URL) {
	tetrisProvider.setLargeur(10);
	tetrisProvider.setHauteur(20);
	tetrisProvider.setSizeOfTetriminos(25);

	tetriminosProvider.setApiUrl(API_URL + "/tetrimino");
});


app.run(['$rootScope', '$location', 'Auth', function($rootScope, $location, Auth) {
	$rootScope.$on('$routeChangeStart', function(event, nextRoute, previousRoute) {
		var toLogin = true;
		if (nextRoute.originalPath) {
			toLogin = nextRoute.originalPath.indexOf('/account/login') !== -1;
		}
		if (!toLogin && !Auth.isLogged()) {
			event.preventDefault(); $location.path('/account/login');
		}
	});
}]);