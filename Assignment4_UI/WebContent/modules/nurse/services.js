'use strict';
 
var app = angular.module('Nurse');
 
app.factory('NurseService',
    ['Base64', '$http', '$cookieStore', '$rootScope', '$timeout',
    function (Base64, $http, $cookieStore, $rootScope, $timeout) {
        var service = {};

        service.AddPatient = function (patient, callback) {

            $http.post('http://localhost:8080/Assignment4_REST/rest/nurse/registerPatient', patient)
                .success(function (data, status) {
                    callback(data);
                });
            	
        };
        return service;
    }]);

app.factory('ListPatientsService',
	    ['Base64', '$http', '$cookieStore', '$rootScope', '$timeout',
	    function (Base64, $http, $cookieStore, $rootScope, $timeout) {
	        var service = {};

	        service.GetDiagnosis = function (callback) {
	        	$http.get('http://localhost:8080/Assignment4_REST/rest/doctor/getDiagnosis')
	            .success(function (data, status) {
	                callback(data);
	            });
			}
	        
	        service.GenerateList = function (diagnosis, callback) {
	        	$http.post('http://localhost:8080/Assignment4_REST/rest/nurse/generateList', diagnosis)
	            .success(function (data, status) {
	                callback(data);
	            });
			}
	        
	        return service;
	    }]);

app.factory('SearchPatientService',
	    ['Base64', '$http', '$cookieStore', '$rootScope', '$timeout',
	    function (Base64, $http, $cookieStore, $rootScope, $timeout) {
	        var service = {};

	        service.GetPatient = function (pId, callback) {

	            $http.get('http://localhost:8080/Assignment4_REST/rest/nurse/searchPatient/' + pId)
	                .success(function (data, status) {
	                    callback(data);
	                });
	            	
	        };
	        
	        service.SendEmail = function (patient, callback) {
	        	$http.post('http://localhost:8080/Assignment4_REST/rest/notify/send', patient)
                .success(function (data, status) {
                    callback(data);
                });
			}
	        
	        service.TransferPatient = function (patient, callback) {
	        	$http.post('http://localhost:8080/Assignment4_REST/rest/notify/transfer', patient)
                .success(function (data, status) {
                    callback(data);
                });
			}
	        
	        service.AddEncounter = function(encounter, callback) {
	        	encounter.activeMeds = encounter.activeMeds.split(",");
	        	encounter.allergies = encounter.allergies.split(",");
	        	encounter.symptoms = encounter.symptoms.split(",");
	        	encounter.status = "Open";
	        	$http.post('http://localhost:8080/Assignment4_REST/rest/nurse/addEncounter', encounter)
                .success(function (data, status) {
                    callback(data);
                });
			}
	        return service;
	    }]);