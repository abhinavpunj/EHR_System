'use strict';







// declare modules
angular.module('Authentication', []);
angular.module('Home', []);
angular.module('Contact', []);
angular.module('Doctor', []);
angular.module('Nurse', []);


angular.module('BasicHttpAuthExample', [
    'Authentication',
    'Home',
    'Contact',
    'Doctor',
    'Nurse',
    'ngRoute',
    'ngCookies'
])
 
.config(['$routeProvider', function ($routeProvider) {

    $routeProvider
        .when('/login', {
        		templateUrl : 'modules/authentication/views/login.jsp',
				controller : 'LoginController',
				hideMenus : false
			})

			// route for the about page
			.when('/doctor', {
				templateUrl : 'modules/doctor/views/DoctorHome.jsp',
				controller : 'DoctorController'
			})

			// route for the contact page
			.when('/nurse', {
				templateUrl : 'modules/nurse/views/NurseHome.jsp',
				controller : 'NurseController'
			})
			
			.when('/searchPatient', {
				templateUrl : 'modules/nurse/views/Nurse-Search.jsp',
				controller : 'EncounterController'
			})
			
			.when('/patientDetails/:patientId', {
				templateUrl : 'modules/doctor/views/Doctor-PatientProfile.jsp',
				controller : 'PatientProfileController',
				patientId : 'patientId'
			})
			
			.when('/', {
				templateUrl : 'modules/home/views/home.html',
				controller : 'HomeController',
			})
 
        .otherwise({ redirectTo: '/login' });
}])
 
.run(['$rootScope', '$location', '$cookieStore', '$http',
    function ($rootScope, $location, $cookieStore, $http) {
        // keep user logged in after page refresh
	
        $rootScope.globals = $cookieStore.get('globals') || {};
        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
            $http.defaults.headers.common['AUTH_KEY'] = $rootScope.globals.currentUser.authKey; // jshint ignore:line
            $rootScope.logout = "true";
        }
 
        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            // redirect to login page if not logged in
            if ($location.path() !== '/login' && !$rootScope.globals.currentUser) {
                $location.path('/login');
                $rootScope.logout = "false";
            }
        });
    }]);