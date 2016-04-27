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

app.directive('myAlert', function($timeout){
	  return {
	    scope: {
	      isVisible: '='
	    },
	    link: link,
	    restrict: 'E',
	    replace: true,
	    template: '<div ng-if="isVisible" class="alert alert-success"><strong>Success!</strong> Notification Sent.</div>'
	  }
	  
	  function link(scope, element, attrs){
	    scope.isVisible = true;
	    
	    $timeout(function (){
	            scope.isVisible = false;
	            }, 5000);
	    
	  }
	});

app.controller('EncounterController', [ '$scope', '$rootScope', '$timeout', 'SearchPatientService', 
                                    function($scope, $rootScope, $timeout, SearchPatientService) {
$scope.name = $rootScope.name;
$scope.success = false;
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

$scope.addEncounter = function () {
	 SearchPatientService.AddEncounter($scope.encounter, function(data) {
		
		 $scope.encounter = null;
	});
}
}]);