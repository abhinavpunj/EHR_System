'use strict';

var app = angular.module('Lab');

app.controller('LabTechController', [ '$scope', '$rootScope', 'LabTechService', 
                                      function($scope, $rootScope, LabTechService) {
	$scope.logout = "true";
	$scope.name = $rootScope.name;
	
	$scope.getAllOrders = function () {
		
	}
} ]);
