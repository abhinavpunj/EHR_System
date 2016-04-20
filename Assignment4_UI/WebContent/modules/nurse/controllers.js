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

app.controller('EncounterController', [ '$scope', '$rootScope', 'SearchPatientService', 
                                    function($scope, $rootScope, SearchPatientService) {
$scope.name = $rootScope.name;
$scope.hide = "true";
$scope.getPatient = function() {
	
	SearchPatientService.GetPatient($scope.encounter.patientId.patientId, function(data) {
		if(data.patientId>0){
			$scope.pName = data.name;
		}
	});		

	}

$scope.addEncounter = function () {
	 SearchPatientService.AddEncounter($scope.encounter, function(data) {
		
		 $scope.encounter = null;
	});
}
}]);