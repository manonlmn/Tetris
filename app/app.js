var app = angular.module("tpAngular", [ 'ngRoute', 'ngResource' ]);

app.constant("API_URL", "http://localhost:8080/Tetris/api");


//creation d'une factory pour récupérer la liste des Tetriminos
app.factory('tetriResources', ['$resource', 'API_URL', function($resource, API_URL) {
  return $resource(API_URL + '/tetrimino', null, {
  });
}]);
