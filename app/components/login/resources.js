var app = angular.module("tpAngular");

//creation d'une factory pour récupérer la liste des joueurs
app.factory('playerResources', ['$resource', 'API_URL', function($resource, API_URL) {
  return $resource(API_URL + '/player/login', null, {
	  "recuperer": {method:"POST"}
  });
}]);


app.factory('loginResources', function() {
  return {
		player: {},
		isConnected: function() {
			return (this.player.idPerson);
		}
	}
});