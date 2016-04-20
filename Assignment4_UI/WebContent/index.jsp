<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="BasicHttpAuthExample">

<head>
<meta charset="utf-8" />
<title>EHR System</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
</head>

<body>

	<div class="jumbotron">
		<div class="container">
		<a href="#/login" ng-show="{{logout}}" class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-log-out"></span> Log out
        </a>
				<div ng-view></div>
		</div>
	</div>

	<div class="credits text-center">&copy;Abhinav Punj</div>

	<script src="//code.jquery.com/jquery-2.0.3.min.js"></script>
	<script src="//code.angularjs.org/1.5.0/angular.js"></script>
	<script src="//code.angularjs.org/1.5.0/angular-route.js"></script>
	<script src="//code.angularjs.org/1.5.0/angular-cookies.js"></script>
	<script src="scripts/app.js"></script>
	
	<!-- modules/authentication -->
	<script src="modules/authentication/services.js"></script>
	<script src="modules/authentication/controllers.js"></script>
	<script src="modules/doctor/controllers.js"></script>
	<script src="modules/doctor/services.js"></script>
	<script src="modules/nurse/controllers.js"></script>
	<script src="modules/nurse/services.js"></script>
	<!-- modules/home -->

	<!-- <script src="modules/home/controllers.js"></script>
	modules/contact
	<script src="modules/contact/controllers.js"></script>
	<script src="modules/contact/service.js"></script>

	modules/about
	 -->
<script src="js/jquery-1.7.1.min.js"></script>
</body>

</html>