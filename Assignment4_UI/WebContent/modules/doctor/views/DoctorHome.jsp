
	<div ng-app="Doctor" ng-controller="DoctorController" class="row">
		<div class="col-lg-2">
				<h4 id="drName">Hi Dr. {{name}} </h4>
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="#section1">Home</a></li>
				</ul>
		</div>
		<div class="col-lg-10">
			  <h2>Registered Patients</h2>
			  <div id="patientList" class="list-group">
			  <a ng-repeat="p in patients" ng-href="#/patientDetails/{{p.patientId}}" class="list-group-item">{{p.patientId}} : {{p.name}}</a>
			  </div>
		</div>
	</div>
