var app = angular.module("tetris", [ 'ngRoute', 'ngResource', 'tetrisModule' ]);

app.constant("API_URL", "http://localhost:8080/tetrimino/api");



//Configuration du Tetris
app.config(function(tetrisProvider, tetriminosProvider, API_URL) {
	tetrisProvider.setLargeur(10);
	tetrisProvider.setHauteur(20);
	tetrisProvider.setSizeOfTetriminos(25);
	
	tetriminosProvider.setApiUrl(API_URL + "/tetrimino");
});
