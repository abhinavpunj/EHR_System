
	<div class="row">
		<div class="col-lg-2">
				<h4 id="drName">Dr. {{name}}</h4>
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="DoctorHome.jsp?personId=1">Home</a></li>
				</ul>
		</div>
		<div class="col-lg-10">
			  <div class="row">
        	<div class="col-lg-4">
            	<div class="panel panel-default">
                	<div class="panel-heading">Patient Profile</div>
                    <div class="panel-body">
	                    <div class="row">
		                    <div class="col-lg-12">
			                    <form class="form-horizontal" role="form">
								    <div class="form-group form-group-sm">
								      <label class="control-label col-sm-2" for="name">Name:</label>
								      <div class="col-sm-10">
								        <input type="text" ng-model="patient.name" class="form-control" id="name" disabled>
								      </div>
								    </div>
								    <div class="form-group form-group-sm">
								      <label class="control-label col-sm-2" for="age">Age:</label>
								      <div class="col-sm-10">          
								        <input type="text" ng-model="patient.age" class="form-control" id="age" disabled>
								      </div>
								    </div>
								    <!-- <div class="form-group form-group-sm">
								      <label class="control-label col-sm-2" for="dob">Date of Birth:</label>
								      <div class="col-sm-10">          
								        <input type="text" class="form-control" id="dob" disabled>
								      </div>
								    </div> -->
								    <div class="form-group form-group-sm">
								      <label class="control-label col-sm-2" for="gender">Gender:</label>
								      <div class="col-sm-10">          
								        <input type="text" ng-model="patient.gender" class="form-control" id="gender" disabled>
								      </div>
								    </div>
								    
								    <!-- <div class="form-group form-group-sm">
								      <label class="control-label col-sm-2" for="dob">Address:</label>
								      <div class="col-sm-10">          
								        <textarea class="form-control" id="address" disabled></textarea>
								      </div>
								    </div> -->
								    <div class="form-group form-group-sm">
								      <label class="control-label col-sm-2" for="phone">Phone:</label>
								      <div class="col-sm-10">          
								        <input type="text" ng-model="patient.phone" class="form-control" id="phone" disabled>
								      </div>
								    </div>
								 </form>
		                    </div>
	                    </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-8">
            	<table class="table table-bordered table-striped">
                    	<thead>
                            <th>Encounter Id</th>
                            <th>Chief Complaint</th>
                            <th>Diagnosis</th>
                            <th>Doctor</th>
                            <!-- <th>Date</th> -->
                        </thead>
                        <tbody id="encList">
                        	
                        </tbody>
                    </table>
            </div>
        </div>
        <div class="row">
        	<div class="col-lg-8">
            	<div class="panel panel-default">
                	<div class="panel-heading">Vital Signs</div>
                    <div class="panel-body">
                    <div class="row">
                    	<div class="col-lg-6">
                    	<table>
                        <tr>
                            <td>Temp:</td>
                            <td><input id="temp" type="text" disabled> F</td>
                        </tr>
                        <tr>
                            <td>Pulse:</td>
                            <td><input id="pulse" type="text" disabled /> beats per minute</td>
                        </tr>
                        <tr>
                            <td>Blood Pressure:</td>
                            <td><input id="bloodPressure" type="text" disabled> mm Hg</td>
                        </tr>
                        <tr>
                            <td>Glucose Level:</td>
                            <td><input id="glucose" type="text" disabled>mg/dL</td>
                        </tr>
                    </table>
                    </div>
                    <div class="col-lg-6">
                    <table>
                        <tr>
                            <td>Respiratory Rate:</td>
                            <td><input id="respRate" type="text" disabled> breaths/min</td>
                        </tr>
                        <tr>
                            <td>Weight:</td>
                            <td><input id="weight" type="text" disabled> lbs</td>
                        </tr>
                        <tr>
                            <td>Height:</td>
                            <td><input id="height" type="text" disabled> ft</td>
                        </tr>
                        <tr>
                            <td>BMI:</td>
                            <td><input id="bmi" type="text" disabled></td>
                        </tr>
                    </table>
                    </div>
                    </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
            <form role="form">
			  <div class="form-group">
			    <label for="diagnosis">Diagnosis:</label>
			    <textarea class="form-control" id="diagnosis"></textarea>
			  </div>
			  <input type="button" onclick="updateDiagnosis()" value="Update" class="btn btn-default"></input>
			  <input type='hidden' id="encId" value='0'></input>
			 </form>
            </div>
        </div>
        <div class="row">
        	<div class="col-lg-3">
            	<div class="panel panel-danger">
                	<div class="panel-heading">Symptoms/Conditions</div>
                    <div class="panel-body">
                    	<table id="symptoms" class="table-striped">
                        	<tr>
                            	<td></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
            <div class="col-lg-3">
            	<div class="panel panel-danger">
                	<div class="panel-heading">Active Allergies</div>
                    <div class="panel-body">
                    	<table class="table-striped">
                        	<tbody id="allergies">
                        	
                        	</tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="col-lg-3">
            	<div class="panel panel-danger">
                	<div class="panel-heading">Active Medications</div>
                    <div class="panel-body">
                    	<table id="medications" class="table-striped">
                        	<tr>
                            	<td></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
            <div class="col-lg-3">
            </div>
        </div>
		</div>
	</div>