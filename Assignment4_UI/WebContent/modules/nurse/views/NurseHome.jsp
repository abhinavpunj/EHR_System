<div class="container">
	<div class="row">
		<div class="col-lg-2">
			<h4>Hi {{name}} </h4>
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="NurseHome.jsp">Register Patient</a></li>
					<li><a href="Nurse-Search.jsp">Search Patient</a></li>
				</ul>
		</div>
		<div class="col-lg-10">
		<h4>Register Patient</h4>
			<form class="form-horizontal" role="form">
				
			    <div class="form-group">
			      <label class="control-label col-sm-2" for="name">Name:</label>
			      <div class="col-sm-10">
			        <input type="text" class="form-control" ng-model="patient.name" id="name" placeholder="Enter Name">
			      </div>
			    </div>
			    <div class="form-group">
			      <label class="control-label col-sm-2" for="age">Age:</label>
			      <div class="col-sm-10">          
			        <input type="text" class="form-control" ng-model="patient.age" id="age" placeholder="Enter Age">
			      </div>
			    </div>
			    <div class="form-group">
			      <label class="control-label col-sm-2" for="gender">Gender:</label>
			      <div class="col-sm-10">          
			        <input type="text" class="form-control" ng-model="patient.gender" id="gender" placeholder="Male/Female">
			      </div>
			    </div>
			    
			    <div class="form-group">
			      <label class="control-label col-sm-2" for="dob">Address:</label>
			      <div class="col-sm-10">          
			        <textarea class="form-control" id="address" ng-model="patient.address" placeholder="Enter Address"></textarea>
			      </div>
			    </div>
			    <div class="form-group">
			      <label class="control-label col-sm-2" for="phone">Phone:</label>
			      <div class="col-sm-10">          
			        <input type="text" class="form-control" ng-model="patient.phone" id="phone" placeholder="Enter Phone Number">
			      </div>
			    </div>
			    <div class="form-group">        
			      <div class="col-sm-offset-2 col-sm-10">
			        <input type="button" value="Register" ng-click="register(patient)" class="btn btn-default"></input>
			        <img ng-if="dataLoading" src="data:image/gif;base64,R0lGODlhEAAQAPIAAP///wAAAMLCwkJCQgAAAGJiYoKCgpKSkiH/C05FVFNDQVBFMi4wAwEAAAAh/hpDcmVhdGVkIHdpdGggYWpheGxvYWQuaW5mbwAh+QQJCgAAACwAAAAAEAAQAAADMwi63P4wyklrE2MIOggZnAdOmGYJRbExwroUmcG2LmDEwnHQLVsYOd2mBzkYDAdKa+dIAAAh+QQJCgAAACwAAAAAEAAQAAADNAi63P5OjCEgG4QMu7DmikRxQlFUYDEZIGBMRVsaqHwctXXf7WEYB4Ag1xjihkMZsiUkKhIAIfkECQoAAAAsAAAAABAAEAAAAzYIujIjK8pByJDMlFYvBoVjHA70GU7xSUJhmKtwHPAKzLO9HMaoKwJZ7Rf8AYPDDzKpZBqfvwQAIfkECQoAAAAsAAAAABAAEAAAAzMIumIlK8oyhpHsnFZfhYumCYUhDAQxRIdhHBGqRoKw0R8DYlJd8z0fMDgsGo/IpHI5TAAAIfkECQoAAAAsAAAAABAAEAAAAzIIunInK0rnZBTwGPNMgQwmdsNgXGJUlIWEuR5oWUIpz8pAEAMe6TwfwyYsGo/IpFKSAAAh+QQJCgAAACwAAAAAEAAQAAADMwi6IMKQORfjdOe82p4wGccc4CEuQradylesojEMBgsUc2G7sDX3lQGBMLAJibufbSlKAAAh+QQJCgAAACwAAAAAEAAQAAADMgi63P7wCRHZnFVdmgHu2nFwlWCI3WGc3TSWhUFGxTAUkGCbtgENBMJAEJsxgMLWzpEAACH5BAkKAAAALAAAAAAQABAAAAMyCLrc/jDKSatlQtScKdceCAjDII7HcQ4EMTCpyrCuUBjCYRgHVtqlAiB1YhiCnlsRkAAAOwAAAAAAAAAAAA=="/>
			      </div>
			    </div>
			    
			</form>
		</div>
	</div>
</div>