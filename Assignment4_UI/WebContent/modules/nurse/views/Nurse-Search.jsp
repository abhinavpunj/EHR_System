
<div ng-include="'logout.jsp'"></div>
	<div class="row">
		<div class="col-lg-2">
			<h4>{{name}}</h4>
				<ul class="nav nav-pills nav-stacked">
					<li><a href="#/nurse">Register Patient</a></li>
					<li class="active"><a href="#/searchPatient">Search Patient</a></li>
				</ul>
		</div>
		<div class="col-lg-10">
		<h4>Search Patient</h4>
		<form class="form-horizontal">
			<div class="form-group">
					  <label class="control-label col-sm-3" for="search">Patient Id:</label>
					  <div class="col-sm-9">          
					  	<input ng-model="encounter.patientId.patientId" type="text" class="form-control" id="search" placeholder="Search Patient">
					  </div>
					</div>
				<div class="form-group" ng-init="notify=true">        
			      	<div class="col-sm-offset-5 col-sm-10">
			        	<input type="button" ng-click="getPatient(encounter.pId)" value="Search" class="btn btn-default"></input>
			        	&nbsp;
			        	<input type="button" ng-disabled="notify" ng-click="sendEmail()" value="Send Last Encounter" class="btn btn-info"></input>
			      		<img ng-if="dataLoading" src="data:image/gif;base64,R0lGODlhEAAQAPIAAP///wAAAMLCwkJCQgAAAGJiYoKCgpKSkiH/C05FVFNDQVBFMi4wAwEAAAAh/hpDcmVhdGVkIHdpdGggYWpheGxvYWQuaW5mbwAh+QQJCgAAACwAAAAAEAAQAAADMwi63P4wyklrE2MIOggZnAdOmGYJRbExwroUmcG2LmDEwnHQLVsYOd2mBzkYDAdKa+dIAAAh+QQJCgAAACwAAAAAEAAQAAADNAi63P5OjCEgG4QMu7DmikRxQlFUYDEZIGBMRVsaqHwctXXf7WEYB4Ag1xjihkMZsiUkKhIAIfkECQoAAAAsAAAAABAAEAAAAzYIujIjK8pByJDMlFYvBoVjHA70GU7xSUJhmKtwHPAKzLO9HMaoKwJZ7Rf8AYPDDzKpZBqfvwQAIfkECQoAAAAsAAAAABAAEAAAAzMIumIlK8oyhpHsnFZfhYumCYUhDAQxRIdhHBGqRoKw0R8DYlJd8z0fMDgsGo/IpHI5TAAAIfkECQoAAAAsAAAAABAAEAAAAzIIunInK0rnZBTwGPNMgQwmdsNgXGJUlIWEuR5oWUIpz8pAEAMe6TwfwyYsGo/IpFKSAAAh+QQJCgAAACwAAAAAEAAQAAADMwi6IMKQORfjdOe82p4wGccc4CEuQradylesojEMBgsUc2G7sDX3lQGBMLAJibufbSlKAAAh+QQJCgAAACwAAAAAEAAQAAADMgi63P7wCRHZnFVdmgHu2nFwlWCI3WGc3TSWhUFGxTAUkGCbtgENBMJAEJsxgMLWzpEAACH5BAkKAAAALAAAAAAQABAAAAMyCLrc/jDKSatlQtScKdceCAjDII7HcQ4EMTCpyrCuUBjCYRgHVtqlAiB1YhiCnlsRkAAAOwAAAAAAAAAAAA=="/>
			      	</div>
			    </div>
			    
			    <div ng-if="success" class="alert alert-success fade in">
			    	<strong>Success!</strong> Notification Sent.
			    </div>

					<div class="form-group">
					  <label class="control-label col-sm-3" for="name">Patient Name:</label>
					  <div class="col-sm-9">          
					  	<input type="text" ng-model="pName" class="form-control" id="name" disabled>
					  </div>
					</div>
					<div style="margin-left: 11%;" align="center" class="form-group">
						<button ng-if="pName != null" type="button" data-toggle="modal" data-target="#myModal" class="btn btn-primary">Transfer Patient to Provider</button>
			      		<img ng-if="dataLoading" src="data:image/gif;base64,R0lGODlhEAAQAPIAAP///wAAAMLCwkJCQgAAAGJiYoKCgpKSkiH/C05FVFNDQVBFMi4wAwEAAAAh/hpDcmVhdGVkIHdpdGggYWpheGxvYWQuaW5mbwAh+QQJCgAAACwAAAAAEAAQAAADMwi63P4wyklrE2MIOggZnAdOmGYJRbExwroUmcG2LmDEwnHQLVsYOd2mBzkYDAdKa+dIAAAh+QQJCgAAACwAAAAAEAAQAAADNAi63P5OjCEgG4QMu7DmikRxQlFUYDEZIGBMRVsaqHwctXXf7WEYB4Ag1xjihkMZsiUkKhIAIfkECQoAAAAsAAAAABAAEAAAAzYIujIjK8pByJDMlFYvBoVjHA70GU7xSUJhmKtwHPAKzLO9HMaoKwJZ7Rf8AYPDDzKpZBqfvwQAIfkECQoAAAAsAAAAABAAEAAAAzMIumIlK8oyhpHsnFZfhYumCYUhDAQxRIdhHBGqRoKw0R8DYlJd8z0fMDgsGo/IpHI5TAAAIfkECQoAAAAsAAAAABAAEAAAAzIIunInK0rnZBTwGPNMgQwmdsNgXGJUlIWEuR5oWUIpz8pAEAMe6TwfwyYsGo/IpFKSAAAh+QQJCgAAACwAAAAAEAAQAAADMwi6IMKQORfjdOe82p4wGccc4CEuQradylesojEMBgsUc2G7sDX3lQGBMLAJibufbSlKAAAh+QQJCgAAACwAAAAAEAAQAAADMgi63P7wCRHZnFVdmgHu2nFwlWCI3WGc3TSWhUFGxTAUkGCbtgENBMJAEJsxgMLWzpEAACH5BAkKAAAALAAAAAAQABAAAAMyCLrc/jDKSatlQtScKdceCAjDII7HcQ4EMTCpyrCuUBjCYRgHVtqlAiB1YhiCnlsRkAAAOwAAAAAAAAAAAA=="/>
					</div>
			<div class="panel panel-default">
				  <div class="panel-heading">Encounter Details</div>
				  <div class="panel-body">
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
                    <div class="row">
                    	<div class="col-lg-6">
						<div class="form-group">
						  <label class="control-label col-sm-3" for="med">Active Medications:</label>
						  <div class="col-sm-9">          
						  	<input type="text" ng-model="encounter.activeMeds" class="form-control" id="med" placeholder="comma separated">
						  </div>
						</div>
						</div>
						<div class="col-lg-6">
						<div class="form-group">
						  <label class="control-label col-sm-3" for="allergies">Active Allergies:</label>
						  <div class="col-sm-9">          
						  	<input type="text" ng-model="encounter.allergies" class="form-control" id="allergies" placeholder="comma separated">
						  </div>
						</div>
						</div>
					</div>
					<div class="row">
					<div class="col-lg-6">
						<div class="form-group">
						  <label class="control-label col-sm-3" for="symptoms">Symptoms/ Conditions:</label>
						  <div class="col-sm-9">          
						  	<input type="text" ng-model="encounter.symptoms" class="form-control" id="symptoms" placeholder="comma separated">
						  </div>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="form-group">
						  <label class="control-label col-sm-3" for="complaint">Chief Complaint:</label>
						  <div class="col-sm-9">          
						  	<textarea type="text" ng-model="encounter.chiefComplaint" class="form-control" id="complaint" placeholder="Enter complaint"></textarea>
						  </div>
						</div>
					</div>
					</div>
                    
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
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Transfer to:</h4>
      </div>
      <div class="modal-body">
        <div class="form-group">
			<label class="control-label col-sm-3" for="transferEmail">Symptoms/ Conditions:</label>
			<div class="col-sm-9">          
				<input type="email" ng-model="patient.transferEmail" class="form-control" id="transferEmail" placeholder="Enter Email" >
			</div>
		</div>
      </div>
      <div class="modal-footer">
      <div ng-if="successTran" class="alert alert-success fade in">
	  	<strong>Success!</strong> Notification Sent.
	  </div>
      	<input type="button" ng-click="transferPatient()" value="Transfer" class="btn btn-info"></input>
    	<img ng-if="transferLoading" src="data:image/gif;base64,R0lGODlhEAAQAPIAAP///wAAAMLCwkJCQgAAAGJiYoKCgpKSkiH/C05FVFNDQVBFMi4wAwEAAAAh/hpDcmVhdGVkIHdpdGggYWpheGxvYWQuaW5mbwAh+QQJCgAAACwAAAAAEAAQAAADMwi63P4wyklrE2MIOggZnAdOmGYJRbExwroUmcG2LmDEwnHQLVsYOd2mBzkYDAdKa+dIAAAh+QQJCgAAACwAAAAAEAAQAAADNAi63P5OjCEgG4QMu7DmikRxQlFUYDEZIGBMRVsaqHwctXXf7WEYB4Ag1xjihkMZsiUkKhIAIfkECQoAAAAsAAAAABAAEAAAAzYIujIjK8pByJDMlFYvBoVjHA70GU7xSUJhmKtwHPAKzLO9HMaoKwJZ7Rf8AYPDDzKpZBqfvwQAIfkECQoAAAAsAAAAABAAEAAAAzMIumIlK8oyhpHsnFZfhYumCYUhDAQxRIdhHBGqRoKw0R8DYlJd8z0fMDgsGo/IpHI5TAAAIfkECQoAAAAsAAAAABAAEAAAAzIIunInK0rnZBTwGPNMgQwmdsNgXGJUlIWEuR5oWUIpz8pAEAMe6TwfwyYsGo/IpFKSAAAh+QQJCgAAACwAAAAAEAAQAAADMwi6IMKQORfjdOe82p4wGccc4CEuQradylesojEMBgsUc2G7sDX3lQGBMLAJibufbSlKAAAh+QQJCgAAACwAAAAAEAAQAAADMgi63P7wCRHZnFVdmgHu2nFwlWCI3WGc3TSWhUFGxTAUkGCbtgENBMJAEJsxgMLWzpEAACH5BAkKAAAALAAAAAAQABAAAAMyCLrc/jDKSatlQtScKdceCAjDII7HcQ4EMTCpyrCuUBjCYRgHVtqlAiB1YhiCnlsRkAAAOwAAAAAAAAAAAA=="/>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        
      </div>
    </div>

  </div>
</div>