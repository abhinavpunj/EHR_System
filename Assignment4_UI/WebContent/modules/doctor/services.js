//'use strict';
 
var app = angular.module('Doctor');
 
app.factory('PateintDetailsService',
    ['Base64', '$http', '$cookieStore', '$rootScope', '$timeout',
    function (Base64, $http, $cookieStore, $rootScope, $timeout) {
        var service = {};

        service.Details = function (patientId, personId, callback) {

            $http.get('http://localhost:8080/Assignment4_REST/rest/doctor/patientDetails/' + personId + '/' + patientId)
                .success(function (data, status) {
                    callback(data);
                });
            	
        };
        
        service.UpdateDiagnosis = function (encounter, callback) {
			$http.put('http://localhost:8080/Assignment4_REST/rest/doctor/updateDiagnosis', encounter)
				.success(function (data, status) {
					callback(data);
				})
		}
        return service;
    }]);

app.factory('LabResultsService',
	    ['Base64', '$http', '$cookieStore', '$rootScope', '$timeout',
	     function (Base64, $http, $cookieStore, $rootScope, $timeout) {
	         var service = {};

	         service.GetEncounters = function (patientId, callback) {
				$http.get('http://localhost:8080/Assignment4_REST/rest/lab/getEncounters/' + patientId)
					.success(function (data, status) {
						callback(data);
					});
			};
			
			service.GetOrders = function (patientId, callback) {
				$http.get('http://localhost:8080/Assignment4_REST/rest/lab/getOrders/' + patientId)
					.success(function (data, status) {
						callback(data);
				});
			};
			
			service.OrderTest = function (personId, encounterId, testName, callback) {
				labOrder = {};
				labOrder.encounter = encounterId;
				labOrder.testName = testName;
				labOrder.sender = {};
				labOrder.sender.personId = personId;

				$http.post('http://localhost:8080/Assignment4_REST/rest/lab/orderTest', labOrder)
					.success(function(data, status) {
						callback(data);
					});
			};
			
     
			
	         
	         return service;
	     }]);