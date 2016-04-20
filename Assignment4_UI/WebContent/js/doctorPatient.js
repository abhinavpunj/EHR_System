$(document).ready(function(){
	var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    var docId = 0;
    var patientId = 0;
    for (var i = 0; i < sURLVariables.length; i++)
    {
    	var sParameterName = sURLVariables[i].split('=');
    	if (sParameterName[0] == 'doctorId')
    	{
    		docId = sParameterName[1];
    	}
    	else if (sParameterName[0] == 'patientId')
    	{
    		patientId = sParameterName[1];
    	}
    	
	}
    
    var perJson = {
    		personId : docId,
    		patients : [{
    			patientId : patientId}]
    };

    $.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "http://localhost:8080/Assignment4_REST/rest/doctor/patientDetails",
		dataType : "json",
		data : JSON.stringify(perJson),
		success : function(data) {
			var val = JSON.stringify(data);
			var json = $.parseJSON(val);
			$('#drName').append(json.name);
			//var list = $("#patientList");
			for(var i=0; i<json.patients.length; i++){
				$("#name").val(json.patients[i].name);
				$("#age").val(json.patients[i].age);
				$("#gender").val(json.patients[i].gender);
				$("#phone").val(json.patients[i].phone);
				var table = $("#encList");

				for(var j=0; j<json.patients[i].encounterHistory.length; j++){

					table.append("<tr><td><a href='javascript:void(0);' onclick='getVitalSign(" + json.patients[i].encounterHistory[j].encounterId + ")'>" 
							+ json.patients[i].encounterHistory[j].encounterId + "</a></td><td>" + json.patients[i].encounterHistory[j].chiefComplaint + "</td><td>"
							+ json.patients[i].encounterHistory[j].diagnosis + "</td><td>" + json.patients[i].encounterHistory[j].doctor + "</td></tr>");
				}
			}
		},
		error : function(er) {
			alert("error");
		},
		failure : function(errormsg) {
			alert(errormsg);
		}
	});
    
});

function getVitalSign(encounterId){

	$("#encId").val(encounterId);
	var encJson = {
			encounterId : encounterId
	};
	
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "http://localhost:8080/Assignment4_REST/rest/doctor/vitalsignDetails",
		dataType : "json",
		data : JSON.stringify(encJson),
		success : function(data) {
			var val = JSON.stringify(data);
			var json = $.parseJSON(val);
			
			$('#temp').val(json.vitalSign.temp);
			$('#pulse').val(json.vitalSign.pulse);
			$('#bloodPressure').val(json.vitalSign.bloodPressure);
			$('#glucose').val(json.vitalSign.glucose);
			$('#respRate').val(json.vitalSign.respRate);
			$('#weight').val(json.vitalSign.weight);
			$('#height').val(json.vitalSign.height);
			$('#bmi').val(json.vitalSign.bmi);
			
			var a = $("#allergies");
			$("#allergies > tr").remove();
			
			for(var i=0; i<json.allergies.length; i++){
				a.append("<tr><td>" + json.allergies[i] + "</td></tr>");
			}
			
			var m = $("#medications");
			$("#medication > tr").remove();
			
			for(var i=0; i<json.activeMeds.length; i++){
				m.append("<tr><td>" + json.activeMeds[i] + "</td></tr>");
			}
			
			var s = $("#symptoms");
			$("#symptoms > tr").remove();
			
			for(var i=0; i<json.symptoms.length; i++){
				s.append("<tr><td>" + json.symptoms[i] + "</td></tr>");
			}
			
		},
		error : function(er) {
			alert("error");
		},
		failure : function(errormsg) {
			alert(errormsg);
		}
	});
}

function updateDiagnosis(){
	var encId = $("#encId").val();
	var doctor = $("#drName").html();
	var diag = $("#diagnosis").val();
	var encJson = {
			encounterId : encId,
			doctor : doctor,
			diagnosis : diag
	};
	
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "http://localhost:8080/Assignment4_REST/rest/doctor/updateDiagnosis",
		dataType : "json",
		data : JSON.stringify(encJson),
		success : function(data) {
			alert("Diagnosis updated!");
			
		},
		error : function(er) {
			alert("error");
		},
		failure : function(errormsg) {
			alert(errormsg);
		}
	});
}