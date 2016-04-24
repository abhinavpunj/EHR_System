'use strict';

var app = angular.module('Lab');

app.controller('LabTechController', [ '$scope', '$rootScope', 'LabTechService', 
                                      function($scope, $rootScope, LabTechService) {
	$scope.logout = "true";
	$scope.name = $rootScope.name;
	$scope.person = $rootScope.person;
	$scope.getAllOrders = function () {
		LabTechService.GetAllOrders(function (data) {
			$scope.orders = data;
		})
	}
	
	$scope.selectOrder = function (order) {
		$scope.order = order;
	}
	
	$scope.updateOrder = function () {
		$scope.order.assignedTo = $scope.person;
		
		LabTechService.UpdateOrder($scope.order, function (data) {
			
		})
	}
	
} ]);
