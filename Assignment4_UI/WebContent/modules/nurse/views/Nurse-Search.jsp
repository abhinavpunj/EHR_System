<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nurse-Search Patient</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="js/search.js"></script>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-lg-2">
			<h4>Hi Nurse </h4>
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
					  	<input type="text" class="form-control" id="search" placeholder="Search Patient">
					  </div>
					</div>
					<div class="form-group">        
			      	<div class="col-sm-offset-5 col-sm-10">
			        <input type="button" onclick="searchPatientById()" value="Search" class="btn btn-default"></input>
			      </div>
			    </div>
					<div class="form-group">
					  <label class="control-label col-sm-3" for="name">Patient Name:</label>
					  <div class="col-sm-9">          
					  	<input type="text" class="form-control" id="name" disabled>
					  </div>
					</div>
			<div class="panel panel-default">
				  <div class="panel-heading">Encounter Details</div>
				  <div class="panel-body">
					<div class="form-group">
					  <label class="control-label col-sm-3" for="med">Active Medications:</label>
					  <div class="col-sm-9">          
					  	<input type="text" class="form-control" id="med" placeholder="comma separated">
					  </div>
					</div>
					<div class="form-group">
					  <label class="control-label col-sm-3" for="allergies">Active Allergies:</label>
					  <div class="col-sm-9">          
					  	<input type="text" class="form-control" id="allergies" placeholder="comma separated">
					  </div>
					</div>
					<div class="form-group">
					  <label class="control-label col-sm-3" for="symptoms">Symptoms/Conditions:</label>
					  <div class="col-sm-9">          
					  	<input type="text" class="form-control" id="symptoms" placeholder="comma separated">
					  </div>
					</div>
					<div class="form-group">
					  <label class="control-label col-sm-3" for="complaint">Chief Complaint:</label>
					  <div class="col-sm-9">          
					  	<textarea type="text" class="form-control" id="complaint" placeholder="Enter complaint"></textarea>
					  </div>
					</div>
				  	<strong>Vital Signs</strong>
				  	<div class="row">
                    	<div class="col-lg-6">
                    	<table>
                        <tr>
                            <td>Temp:</td>
                            <td><input id="temp" type="text"> F</td>
                        </tr>
                        <tr>
                            <td>Pulse:</td>
                            <td><input id="pulse" type="text"/> beats per minute</td>
                        </tr>
                        <tr>
                            <td>Blood Pressure:</td>
                            <td><input id="bp" type="text"> mm Hg</td>
                        </tr>
                        <tr>
                            <td>Glucose Level:</td>
                            <td><input id="glucose" type="text">mg/dL</td>
                        </tr>
                    </table>
                    </div>
                    <div class="col-lg-6">
                    <table>
                        <tr>
                            <td>Respiratory Rate:</td>
                            <td><input id="respRate" type="text"> breaths/min</td>
                        </tr>
                        <tr>
                            <td>Weight:</td>
                            <td><input id="weight" type="text"> lbs</td>
                        </tr>
                        <tr>
                            <td>Height:</td>
                            <td><input id="height" type="text"> ft</td>
                        </tr>
                        <tr>
                            <td>BMI:</td>
                            <td><input id="bmi" type="text"></td>
                        </tr>
                    </table>
                    </div>
                    </div>
                    <br/>
                    <div class="form-group">        
			      	<div class="col-sm-offset-4 col-sm-10">
			        <input type="button" onclick="addAllEncounter()" value="Create Encounter" class="btn btn-default"></input>
			      </div>
			    </div>
				  </div>
				</div>
				</form>
		</div>
	</div>
</div>
</body>
</html>