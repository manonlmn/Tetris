var app = angular.module("tpAngular");


app.config(function($routeProvider) {
	$routeProvider
		.when("/", {
			templateUrl: "./app/components/home/home.html",
			controller: "homeController"
		})
		.when("/Tetrimino_List", {
			templateUrl : "./app/components/listeTetriminos/listeTetri.html",
			controller : "tetriController"
		})
		.when("/Top_Scores", {
			templateUrl : "./app/components/topscores/topscores.html",
			controller : "scoreController"
		})
		.when("/FAQ", {
			templateUrl : "./app/components/faq/faq.html",
			controller : "faqController"
		})
		.when("/Play", {
			templateUrl : "./app/components/play/play.html",
			controller : "playController"
		})
		.when("/Login", {
			templateUrl : "./app/components/login/login.html",
			controller : "loginController"
		})
		.when("/Bonus", {
			templateUrl : "./app/components/bonus/bonus.html",
			controller : "bonusController"
		})
		.when("/Register", {
			templateUrl : "./app/components/registration/register.html",
			controller : "registerController"
		})
		.otherwise({
			redirectTo: '/'
		});
});
