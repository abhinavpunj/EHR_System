'use strict';
 
var app = angular.module('Doctor');
 
app.factory('LabTechService',
    ['Base64', '$http', '$cookieStore', '$rootScope', '$timeout',
    function (Base64, $http, $cookieStore, $rootScope, $timeout) {
        var service = {};

        service.GetAllOrders = function (callback) {
        	$http.get('http://localhost:8080/Assignment4_REST/rest/lab/getAllOrders')
            .success(function (data, status) {
                callback(data);
            });
		};
        
        service.UpdateOrder = function (order, callback) {
        	$http.put('http://localhost:8080/Assignment4_REST/rest/lab/updateOrder', order)
            .success(function (data, status) {
                callback(data);
            });
		}
        
        return service;
    }]);