'use strict';

var app = angular.module('Nurse');

app.controller('NurseController', [ '$scope', '$rootScope', 'NurseService', 
                                             function($scope, $rootScope, NurseService) {
	$scope.name = $rootScope.name;

	$scope.register = function() {
		$scope.dataLoading = true;
        NurseService.AddPatient($scope.patient, function(data) {
        	$scope.dataLoading = false;
        });
	}	
}]);

app.controller('ListPatientsController', [ '$scope', '$rootScope', 'ListPatientsService', 
                                    function($scope, $rootScope, ListPatientsService) {
$scope.name = $rootScope.name;

$scope.getDiagnosis = function () {
	ListPatientsService.GetDiagnosis(function (data) {
		$scope.allDiag = data;
	})
}
$scope.generateList = function (diag) {
	ListPatientsService.GenerateList(diag, function (data) {
		$scope.list = data;
	})
}
}]);

app.controller('EncounterController', [ '$scope', '$rootScope', '$timeout', 'SearchPatientService', 
                                    function($scope, $rootScope, $timeout, SearchPatientService) {
$scope.name = $rootScope.name;
$scope.success = false;
$scope.successTran = false;
$scope.getPatient = function() {
	
	SearchPatientService.GetPatient($scope.encounter.patientId.patientId, function(data) {
		if(data.patientId>0){
			$scope.patient = data;
			$scope.pName = data.name;
			$scope.notify = false;
		}
	});
	}
$scope.sendEmail = function() {
	$scope.dataLoading = true;
	SearchPatientService.SendEmail($scope.patient, function (data) {
		$scope.dataLoading = false;
		$scope.success = data;
		$timeout(function () {
		      $scope.success = false;
		  }, 3000);
	})
}

$scope.transferPatient = function() {
	$scope.transferLoading = true;
	SearchPatientService.TransferPatient($scope.patient, function (data) {
		$scope.transferLoading = false;
		$scope.successTran = data;
		$timeout(function () {
		      $scope.successTran = false;
		  }, 3000);
	})
}

$scope.addEncounter = function () {
	 SearchPatientService.AddEncounter($scope.encounter, function(data) {
		
		 $scope.encounter = null;
	});
}
}]);