'use strict';

var app = angular.module('Nurse');

app.controller('NurseController', [ '$scope', '$rootScope', 'NurseService', 
                                             function($scope, $rootScope, NurseService) {
	$scope.name = $rootScope.name;
	//$scope.patients = $rootScope.patients;
	//$scope.personId = $rootScope.personId;
	$scope.register = function() {
		$scope.dataLoading = true;
        NurseService.AddPatient($scope.patient, function(data) {
        	$scope.dataLoading = false;
        });
	}	
}]);