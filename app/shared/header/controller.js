var app = angular.module("tpAngular");

app.controller("headerController", function($scope, Page, loginResources) {
	$scope.Page = Page;
	$scope.loginResources = loginResources;
	
});