'use strict';
 
angular.module('Doctor')
 
.factory('PateintDetailsService',
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