'use strict';
 
angular.module('Authentication')
 
.controller('LoginController',
    ['$scope', '$rootScope', '$location', 'AuthenticationService',
    function ($scope, $rootScope, $location, AuthenticationService) {
        // reset login status
        AuthenticationService.ClearCredentials();
 
        $scope.login = function () {
            $scope.dataLoading = true;
            AuthenticationService.Login($scope.username, $scope.password, function(data, headers) {
                if(data.personId > 0) {
                    AuthenticationService.SetCredentials($scope.username, $scope.password, headers);
                    $location.path('/' +  headers('AUTH_KEY'));
                    $rootScope.name = data.name;
                    $rootScope.patients = data.patients;
                    $rootScope.personId = data.personId;
                } else {
                    $scope.error = response.message;
                    $scope.dataLoading = false;
                }
            });
        };
    }]);