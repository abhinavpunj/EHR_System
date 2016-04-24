
	<div class="row">
		<div class="col-lg-2">
				<h4 id="drName">Hi {{name}} </h4>
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="#/labTech">Home</a></li>
				</ul>
		</div>
		<div ng-init="getAllOrders()" class="col-lg-10">
			  <h2>Tests Requested</h2>
			  <table class="table table-bordered table-striped">
                    	<thead>
                            <th>Report Id</th>
                            <th>Encounter Id</th>
                            <th>Test Name</th>
                            <th>Sent By</th>
                            <th>Result</th>
                            <th>Status</th>
                            <th>Assigned To</th>
                        </thead>
                        <tbody id="encList">
                        	<tr ng-click="getVitalSign(encs)" ng-class="encs.encounterId == idSelected ? 'selected' : ''" ng-repeat="encs in patient.encounterHistory">
                        		<td>{{encs.encounterId}}</td>
                        		<td>{{encs.chiefComplaint}}</td>
                        		<td>{{encs.diagnosis}}</td>
                        		<td>{{encs.doctor}}</td>
                        	</tr>
                        </tbody>
                    </table>
                    <h5 ng-show="!patient.encounterHistory.length">No Lab Tests ordered</h5>
		</div>
	</div>
	<div ng-if="enc != null" class="row">
		<div class="col-lg-4">
			
		</div>
		<div class="col-lg-4">
		<h5><strong>Report ID Selected : </strong></h5>
			<form class="form-horizontal">
						<div class="col-lg-12">
						  <div class="form-group">
						    <label for="status" class="col-sm-2 control-label">Status</label>
						    <div class="col-sm-10">
						      <select class="form-control" id="encId">
							      <option>Not Started</option>
							      <option>Pending</option>
							      <option>Completed</option>
						      </select>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="result" class="col-sm-2 control-label">Result</label>
						    <div class="col-sm-10">
						      <textarea class="form-control" id="result"></textarea>
						    </div>
						  </div>
						  </div>
				<div class="row">
				<div class="col-lg-3"></div>
				<div class="col-lg-8">
					<input type="button" class="btn btn-primary btn-md" value="Update" />
					<input type="button" class="btn btn-primary btn-md" value="Send Notification" />
				</div>
				<div class="col-lg-1"></div>
				</div>
			</form>

						
		</div>
		<div class="col-lg-4">
		
		</div>
	</div>