var app = angular.module("tpAngular");

//creation d'une factory pour récupérer la liste des parties
app.factory('topscoresResources', ['$resource', 'API_URL', function($resource, API_URL) {
  return $resource(API_URL + '/score', null, {
  });
}]);
