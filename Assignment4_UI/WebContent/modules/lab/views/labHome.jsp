<div ng-include="'logout.jsp'"></div>
	<div class="row">
		<div class="col-lg-2">
				<h4 id="drName">{{name}} </h4>
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
                        	<tr ng-click="selectOrder(o)" ng-repeat="o in orders">
                        		<td>{{o.workId}}</td>
                        		<td>{{o.encounter.encounterId}}</td>
                        		<td>{{o.testName}}</td>
                        		<td>{{o.sender.name}}</td>
                        		<td>{{o.result}}</td>
                        		<td>{{o.status}}</td>
                        		<td>{{o.assignedTo.name}}</td>
                        	</tr>
                        </tbody>
                    </table>
                    <h5 ng-show="!orders.length">No Lab Tests ordered</h5>
		</div>
	</div>
	<div ng-if="order != null" class="row">
		<div class="col-lg-4">
			
		</div>
		<div class="col-lg-4">
		<h5><strong>Report ID Selected : {{order.workId}}</strong></h5>
			<form class="form-horizontal">
						<div class="col-lg-12">
						  <div class="form-group">
						    <label for="status" class="col-sm-2 control-label">Status</label>
						    <div class="col-sm-10">
						      <select ng-model="order.status" class="form-control" id="encId">
							      <option>Not Started</option>
							      <option>Pending</option>
							      <option>Completed</option>
						      </select>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="result" class="col-sm-2 control-label">Result</label>
						    <div class="col-sm-10">
						      <textarea ng-model="order.result" class="form-control" id="result"></textarea>
						    </div>
						  </div>
						  </div>
				<div class="row">
				<div class="col-lg-3"></div>
				<div class="col-lg-8">
					<input type="button" ng-click="updateOrder()" class="btn btn-primary btn-md" value="Update" />
					<!-- <input type="button" class="btn btn-primary btn-md" value="Send Notification" /> -->
				</div>
				<div class="col-lg-1"></div>
				</div>
			</form>

						
		</div>
		<div class="col-lg-4">
		
		</div>
	</div>