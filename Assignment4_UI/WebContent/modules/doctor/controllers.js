'use strict';

var app = angular.module('Doctor');

app.controller('DoctorController', [ '$scope', '$rootScope', function($scope, $rootScope) {
	$scope.logout = "true";
	$scope.name = $rootScope.name;
	$scope.patients = $rootScope.patients;
	$scope.personId = $rootScope.personId;
} ]);

app.controller('PatientProfileController', [ '$scope', '$routeParams', 'PateintDetailsService', 
                                             function($scope, $routeParams, PateintDetailsService) {
	$scope.patientId = $routeParams.patientId;
	PateintDetailsService.Details($scope.patientId, $scope.personId, function(data) {
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