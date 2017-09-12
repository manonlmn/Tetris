var app = angular.module("tpAngular");

//creation d'une factory pour récupérer la liste des Tetriminos
app.factory('playResources', ['$resource', 'API_URL', function($resource, API_URL) {
  return $resource(API_URL + '/score', null, {
    'add': { method:'PUT' }
  });
}]);

//creation d'une factory pour récupérer les parties et en créer une
app.factory('gameResources', ['$resource', 'API_URL', function($resource, API_URL) {
  return $resource(API_URL + '/games/:id', null, {
    'add': { method:'PUT' }
  });
}]);
