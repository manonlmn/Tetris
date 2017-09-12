var app = angular.module("tpAngular");

//creation d'une factory pour récupérer les parties et en créer une
app.factory('gameResources', ['$resource', 'API_URL', function($resource, API_URL) {
  return $resource(API_URL + '/games', null, {
    'add': { method:'PUT' }
  });
}]);
