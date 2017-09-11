var app = angular.module("tpAngular");


app.config(function($routeProvider) {
	$routeProvider
		.when("/", {
			templateUrl: "./app/components/home/home.html",
			controller: "homeController"
		});
});


app.config(function($routeProvider){
	$routeProvider
		.when("/Tetrimino_List", {
			templateUrl : "./app/components/listeTetriminos/listeTetri.html",
			controller : "./app/components/listeTetriminos/tetriController.js"
		});

});
