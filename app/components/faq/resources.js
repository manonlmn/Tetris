var app = angular.module("tpAngular");

//creation d'une factory pour récupérer la liste des Tetriminos
app.factory('faqFrResources', ['$resource', 'API_URL', function($resource, API_URL) {
  return $resource(API_URL + '/faq/FR', null, {
  });
}]);
