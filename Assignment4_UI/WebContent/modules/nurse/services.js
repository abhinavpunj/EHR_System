'use strict';
 
angular.module('Nurse')
 
.factory('NurseService',
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