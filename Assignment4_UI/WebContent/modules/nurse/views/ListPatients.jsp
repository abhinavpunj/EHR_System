<div ng-include="'logout.jsp'"></div>
	<div class="row">
		<div class="col-lg-2">
				<h4 id="name">{{name}} </h4>
				<ul class="nav nav-pills nav-stacked">
					<li><a href="#/nurse">Register Patient</a></li>
					<li><a ng-href="#/searchPatient">Search Patient</a></li>
					<li class="active"><a href="#/listPatients">Condition Specific Patients</a></li>
				</ul>
		</div>
		<div class="col-lg-10">
			  <h2>Condition Specific Patients</h2>
			  <div class="row">
			  	<div class="col-lg-4">
			  	<div class="form-group">
				    <label for="diagnosis">Diagnosis:</label>
				    <select ng-change="generateList(diagObj)" ng-init="getDiagnosis()" ng-options="d.diagnosisName for d in allDiag" class="form-control" ng-model="diagObj" id="diagnosis"></select>
				</div>
				</div>
			  </div>
			  <div class="row">
			  	<div class="col-lg-6">
				  <ul id="patientList" class="list-group">
				  	<li class="list-group-item" ng-repeat="l in list">{{l}}</li>
				  </ul>
				 </div>
			  </div>
		</div>
	</div>
