<div class="row">
		<div class="col-lg-2">
				<h4 id="drName">Hi Dr. {{name}}</h4>
				<ul class="nav nav-pills nav-stacked">
					<li><a href="#/doctor">Home</a></li>
					<li><a href="#/patientDetails/{{patientId}}">Patient Profile</a></li>
					<li class="active"><a href="#/labTests/{{patientId}}">Lab Tests</a></li>
				</ul>
		</div>
		
		<div class="col-lg-10">
			<div ng-init="getOrders()" class="row">
				<table class="table table-bordered table-striped">
                    	<thead>
                            <th>Report Id</th>
                            <th>Encounter Id</th>
                            <th>Test Name</th>
                            <th>Status</th>
                            <th>Result</th>
                            <th>Signed By</th>
                            <!-- <th>Date</th> -->
                        </thead>
                        <tbody id="encList">
                        	<tr ng-repeat="o in orders">
                        		<td>{{o.workId}}</td>
                        		<td>{{o.encounter.encounterId}}</td>
                        		<td>{{o.testName}}</td>
                        		<td>{{o.status}}</td>
                        		<td>{{o.result}}</td>
                        		<td>{{o.assignedTo.name}}</td>
                        	</tr>
                        </tbody>
                    </table>
                    <h5 ng-show="!orders.length">No Lab Tests reported</h5>
			</div>
			<div class="row">
			<div class="col-lg-3"></div>
			<div class="col-lg-6">
			<div class="panel panel-default">
                	<div class="panel-heading"><strong>Order Lab Test</strong></div>
                    <div class="panel-body">
						<form class="form-horizontal">
						<div class="col-lg-12">
						  <div class="form-group">
						    <label for="encId" class="col-sm-2 control-label">Encounter ID</label>
						    <div class="col-sm-10">
						      <select ng-model="selEncounter" ng-options="e.encounterId for e in encs" ng-init="getEncounters()" class="form-control" id="encId">
						      
						      </select>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="testName" class="col-sm-2 control-label">Test Name</label>
						    <div class="col-sm-10">
						      <select ng-model="testName" class="form-control" id="Test Name">
						      <option>Blood Culture</option>
						      <option>Urine Test</option>
						      <option>Viral Tests</option>
						      <option>Serological Test</option>
						      <option>MRI</option>
						      <option>CT Scan</option>
						      <option>Autopsy</option>
						      <option>Folic Acid</option>
						      </select>
						    </div>
						  </div>
						  </div>
						  <div class="form-group">
						    <div class="col-sm-offset-2 col-sm-10">
						      <input type="button" ng-click="orderTest()" class="btn btn-default" value="Order" />
						    </div>
						  </div>
						</form>
					</div>	
				</div>
			</div>
			<div class="col-lg-3"></div>
		</div>
		</div>
</div>