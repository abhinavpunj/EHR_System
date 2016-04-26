<div class="row">
		<div class="col-lg-2">
				<h4 id="drName">Hi Dr. {{name}}</h4>
				<ul class="nav nav-pills nav-stacked">
					<li><a href="#/doctor">Home</a></li>
					<li><a href="#/patientDetails/{{patientId}}">Patient Profile</a></li>
					<li><a href="#/labTests/{{patientId}}">Lab Tests</a></li>
					<li class="active"><a href="#/prescription/{{patientId}}">Add Prescription</a></li>
				</ul>
		</div>
		
		<div class="col-lg-10">
			<div ng-init="getPrescriptions()" class="row">
				<table class="table table-bordered table-striped">
                    	<thead>
                            <th>Encounter Id</th>
                            <th>Medicine Prescribed</th>
                            <th>Signed By</th>
                            <!-- <th>Date</th> -->
                        </thead>
                        <tbody id="encList">
                        	<tr ng-if="e.prescription.length != 0" ng-repeat="e in drugs">
                        		<td>{{e.encounterId}}</td>
                        		<td><span ng-repeat="d in e.prescription">{{d.drugName}}|&nbsp;</span></td>
                        		<td>{{e.doctor}}</td>
                        	</tr>
                        </tbody>
                    </table>
                    <h5 ng-show="!drugs.prescription.length">No Medicines prescribed yet</h5>
			</div>
			<div class="row">
			<div class="col-lg-3"></div>
			<div class="col-lg-6">
			<div class="panel panel-default">
                	<div class="panel-heading"><strong>Add Prescription</strong></div>
                    <div class="panel-body">
						<form class="form-horizontal">
						<div class="col-lg-12">
						  <div class="form-group">
						    <label for="encId" class="col-sm-2 control-label">Encounter ID</label>
						    <div class="col-sm-10">
						      <select ng-model="encounter" ng-options="e.encounterId for e in encs" ng-init="getEncounters()" class="form-control" id="encId">
						      
						      </select>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="testName" class="col-sm-2 control-label">Test Name</label>
						    <div class="col-sm-10">
						      <select multiple ng-model="encounter.prescription" ng-options="dn.drugName for dn in allDrugs" ng-init="getDrugs()" class="form-control" id="Drug Name">
						      
						      </select>
						    </div>
						  </div>
						  </div>
						  <div class="form-group">
						    <div class="col-sm-offset-2 col-sm-10">
						      <input type="button" ng-click="addPrescription(encounter)" class="btn btn-default" value="Add" />
						    </div>
						    <span style="color: red;" ng-if="drugAllergy.length>0">
						    	<strong>Allergic to:</strong>
						    	<div class="alert alert-danger" ng-repeat="da in drugAllergy">
						    		<strong>{{da.drugName}}:</strong>
						    		<span ng-repeat="c in da.components">
						    			{{c}}
						    		</span>
						    	</div>
						    </span>
						  </div>
						</form>
					</div>	
				</div>
			</div>
			<div class="col-lg-3"></div>
		</div>
		</div>
</div>