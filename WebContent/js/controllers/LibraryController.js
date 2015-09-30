
var M4M = angular.module('m4mApp', []);


M4M.controller('LibraryController', ['$scope', '$http', function($scope,$http) {
	
	
	$http.get('http://localhost:9000/Cadastro').then(function(result) {
	$scope.cadastros = result.data;
	}); 
	
	
}]);

