var app = angular.module("tpAngular");

app.controller("faqController", function($scope, Page, faqFrResources) {
	Page.setTitle("FAQ");

	$scope.faqList = faqFrResources.query();
});
