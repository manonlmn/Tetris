var app = angular.module("tpAngular", [ 'ngRoute', 'ngResource' , 'tetrisModule']);

app.constant("API_URL", "http://localhost:8080/Tetris/api");

//Configuration du Tetris
app.config(function(tetrisProvider, tetriminosProvider, API_URL) {
	tetrisProvider.setLargeur(10);
	tetrisProvider.setHauteur(20);
	tetrisProvider.setSizeOfTetriminos(25);

	tetriminosProvider.setApiUrl(API_URL + "/tetrimino");
});


var app = angular.module("tpAngular", [ 'ngRoute', 'ngResource' , 'tetrisModule']);

app.constant("API_URL", "http://localhost:8080/Tetris/api");

//Configuration du Tetris
app.config(function(tetrisProvider, tetriminosProvider, API_URL) {
	tetrisProvider.setLargeur(10);
	tetrisProvider.setHauteur(20);
	tetrisProvider.setSizeOfTetriminos(25);

	tetriminosProvider.setApiUrl(API_URL + "/tetrimino");
});


app.run(['$rootScope', '$location', 'loginResources', function($rootScope, $location, loginResources) {
	$rootScope.$on('$routeChangeStart', function(event, nextRoute, previousRoute) {
		var veutSeLogger = true;
		var veutSinscrire = true;
		var veutLive = true;
		var veutJouer = true;
		var veutListeTetri = true;
		var veutAccueil = true;
		var veutTopScore = true;
		var veutFaq = true;

		if (nextRoute.originalPath) {
			veutSeLogger = nextRoute.originalPath.indexOf('/Login') !== -1;
			veutSinscrire = nextRoute.originalPath.indexOf('/Register') !== -1;
			veutLive = nextRoute.originalPath.indexOf('/Bonus') !== -1;
			veutJouer = nextRoute.originalPath.indexOf('/Play') !== -1;
			veutListeTetri = nextRoute.originalPath.indexOf('/Tetrimino_List') !== -1;
			veutAccueil = nextRoute.originalPath.indexOf('/') !== -1;
			veutTopScore = nextRoute.originalPath.indexOf('/Top_Scores') !== -1;
			veutFAQ = nextRoute.originalPath.indexOf('/FAQ') !== -1;
		}

		if (!veutSeLogger && !veutSinscrire && !veutLive && !veutJouer && !veutListeTetri && !veutAccueil && !veutTopScore && !veutFaq && !loginResources.isConnected()) {
			event.preventDefault();
			$location.path('/Login');
		}
		else if (!veutSeLogger && !veutSinscrire && !veutLive && !veutJouer && !veutListeTetri && !veutAccueil && !veutTopScore && !veutFaq && loginResources.isConnected()) {
			event.preventDefault();
			$location.path('/');
		}
		else if (!veutSeLogger && !veutSinscrire && !veutLive && !loginResources.isConnected()) {
			event.preventDefault();
			$location.path('/Login');
		}	
		
	});
}]);
// Ca marche maintenant?
