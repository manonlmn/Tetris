var app = angular.module("tpAngular");

app.controller("choiceController", function($scope, Page, tetrisBoard, tetrisScore, gameResources){
  	Page.setTitle("Choix du type de partie");

    $scope.newSolo = function(){
      gameResources.add({
        player1 : {idPerson : 7},
        status : true,
        type : 0
      });

    }
});
