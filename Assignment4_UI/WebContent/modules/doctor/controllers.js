'use strict';

var app = angular.module('Doctor');

app.controller('DoctorController', [ '$scope', '$rootScope', function($scope, $rootScope) {
	$scope.logout = "true";
	$scope.name = $rootScope.name;
	$scope.patients = $rootScope.patients;
	$scope.personId = $rootScope.personId;
} ]);

app.controller('PatientProfileController', [ '$scope', '$rootScope', '$routeParams', 'PateintDetailsService', 
                                             function($scope, $rootScope, $routeParams, PateintDetailsService) {
	$scope.patientId = $routeParams.patientId;
	PateintDetailsService.Details($scope.patientId, $rootScope.personId, function(data) {
		$scope.patient = data.patients[0];		
	})
	$scope.idSelected = null;
	$scope.getVitalSign = function (encs) {
		$scope.idSelected = encs.encounterId;
		$scope.encounter = encs;
		$scope.vs = encs.vitalSign;
		$scope.symptoms = encs.symptoms;
		$scope.activeMeds = encs.activeMeds;
		$scope.allergies = encs.allergies;
	}
	
	$scope.updateDiagnosis = function () {
		
		$scope.encounter.doctor = $scope.name;
		$scope.encounter.diagnosis = $scope.diagnosis;
		PateintDetailsService.UpdateDiagnosis($scope.encounter, function(data) {
			$scope.diagnosis = null;
		})
	}
}]);

app.controller('LabResultsController', [ '$scope', '$filter', '$rootScope', '$routeParams', 'LabResultsService', 
                                         function($scope, $filter, $rootScope, $routeParams, LabResultsService) {
	$scope.logout = "true";
	$scope.patientId = $routeParams.patientId;
	$scope.name = $rootScope.name;
	$scope.patients = $rootScope.patients;
	$scope.personId = $rootScope.personId;
	
	$scope.getEncounters = function() {
		LabResultsService.GetEncounters($scope.patientId, function(data) {
			$scope.encs = data;
		})
	}
	
	
	$scope.orderTest = function () {
		LabResultsService.OrderTest($scope.personId, $scope.selEncounter, $scope.testName, function(data) {
			$scope.orders.push(data);
		})
	}
	
	$scope.getOrders = function () {
		LabResultsService.GetOrders($scope.patientId, function(data) {
			$scope.orders = [];
			$scope.orders = data;
		})
		
	}
	
} ]);