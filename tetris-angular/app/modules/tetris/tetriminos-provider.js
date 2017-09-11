tetrisModule.provider('tetriminos', function() {
	var apiUrl = "";


	this.setApiUrl = function(_apiUrl) {
		apiUrl = _apiUrl;
	};


	this.$get = ['$resource', function($resource) {
		return $resource(apiUrl);
	}];
});
