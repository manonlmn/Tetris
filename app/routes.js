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
			controller : "tetriController"
		});
});


app.config(function($routeProvider){
	$routeProvider
		.when("/Top_Scores", {
			templateUrl : "./app/components/topscores/topscores.html",
			controller : "scoreController"
		});
});


app.config(function($routeProvider){
	$routeProvider
		.when("/FAQ", {
			templateUrl : "./app/components/faq/faq.html",
			controller : "faqController"
		});
});


app.config(function($routeProvider){
	$routeProvider
		.when("/Play", {
			templateUrl : "./app/components/play/play.html",
			controller : "playController"
		});
});


app.config(function($routeProvider){
	$routeProvider
		.when("/Login", {
			templateUrl : "./app/components/login/login.html",
			controller : "loginController"
		});
});


app.config(function($routeProvider){
	$routeProvider
		.when("/Bonus", {
			templateUrl : "./app/components/bonus/bonus.html",
			controller : "bonusController"
		});
});


app.config(function($routeProvider){
	$routeProvider
		.when("/choice", {
			templateUrl : "./app/components/gameChoice/gameChoice.html",
			controller : "choiceController"
		});
});
