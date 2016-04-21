
	<div class="row">
		<div class="col-lg-2">
			<h4>Hi {{name}}</h4>
				<ul class="nav nav-pills nav-stacked">
					<li><a href="NurseHome.jsp">Register Patient</a></li>
					<li class="active"><a href="#section1">Search Patient</a></li>
				</ul>
		</div>
		<div class="col-lg-10">
		<h4>Search Patient</h4>
		<form class="form-horizontal">
			<div class="form-group">
					  <label class="control-label col-sm-3" for="search">Patient Id:</label>
					  <div class="col-sm-9">          
					  	<input ng-model="encounter.patientId.patientId" type="text" class="form-control" id="search" placeholder="Search Patient">
					  	<textarea ng-hide="{{hide}}" class="form-control"></textarea>
					  </div>
					</div>
					<div class="form-group">        
			      	<div class="col-sm-offset-5 col-sm-10">
			        <input type="button" ng-click="getPatient(encounter.pId)" value="Search" class="btn btn-default"></input>
			      </div>
			    </div>
					<div class="form-group">
					  <label class="control-label col-sm-3" for="name">Patient Name:</label>
					  <div class="col-sm-9">          
					  	<input type="text" ng-model="pName" class="form-control" id="name" disabled>
					  </div>
					</div>
			<div class="panel panel-default">
				  <div class="panel-heading">Encounter Details</div>
				  <div class="panel-body">
					<div class="form-group">
					  <label class="control-label col-sm-3" for="med">Active Medications:</label>
					  <div class="col-sm-9">          
					  	<input type="text" ng-model="encounter.activeMeds" class="form-control" id="med" placeholder="comma separated">
					  </div>
					</div>
					<div class="form-group">
					  <label class="control-label col-sm-3" for="allergies">Active Allergies:</label>
					  <div class="col-sm-9">          
					  	<input type="text" ng-model="encounter.allergies" class="form-control" id="allergies" placeholder="comma separated">
					  </div>
					</div>
					<div class="form-group">
					  <label class="control-label col-sm-3" for="symptoms">Symptoms/Conditions:</label>
					  <div class="col-sm-9">          
					  	<input type="text" ng-model="encounter.symptoms" class="form-control" id="symptoms" placeholder="comma separated">
					  </div>
					</div>
					<div class="form-group">
					  <label class="control-label col-sm-3" for="complaint">Chief Complaint:</label>
					  <div class="col-sm-9">          
					  	<textarea type="text" ng-model="encounter.chiefComplaint" class="form-control" id="complaint" placeholder="Enter complaint"></textarea>
					  </div>
					</div>
				  	<strong>Vital Signs</strong>
				  	<div class="row">
                    	<div class="col-lg-6">
                    	<table>
                        <tr>
                            <td>Temp:</td>
                            <td><input id="temp" ng-model="encounter.vitalSign.temp" type="text"> F</td>
                        </tr>
                        <tr>
                            <td>Pulse:</td>
                            <td><input id="pulse" ng-model="encounter.vitalSign.pulse" type="text"/> beats per minute</td>
                        </tr>
                        <tr>
                            <td>Blood Pressure:</td>
                            <td><input id="bp" ng-model="encounter.vitalSign.bloodPressure" type="text"> mm Hg</td>
                        </tr>
                        <tr>
                            <td>Glucose Level:</td>
                            <td><input id="glucose" ng-model="encounter.vitalSign.glucose" type="text">mg/dL</td>
                        </tr>
                    </table>
                    </div>
                    <div class="col-lg-6">
                    <table>
                        <tr>
                            <td>Respiratory Rate:</td>
                            <td><input id="respRate" ng-model="encounter.vitalSign.respRate" type="text"> breaths/min</td>
                        </tr>
                        <tr>
                            <td>Weight:</td>
                            <td><input id="weight" ng-model="encounter.vitalSign.weight" type="text"> lbs</td>
                        </tr>
                        <tr>
                            <td>Height:</td>
                            <td><input id="height" ng-model="encounter.vitalSign.height" type="text"> ft</td>
                        </tr>
                        <tr>
                            <td>BMI:</td>
                            <td><input id="bmi" ng-model="encounter.vitalSign.bmi" type="text"></td>
                        </tr>
                    </table>
                    </div>
                    </div>
                    <br/>
                    <div class="form-group">        
			      	<div class="col-sm-offset-4 col-sm-10">
			        <input type="button" ng-click="addEncounter(encounter)" value="Create Encounter" class="btn btn-default"></input>
			      </div>
			    </div>
				  </div>
				</div>
				</form>
		</div>
	</div>
