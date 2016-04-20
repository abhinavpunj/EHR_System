function searchPatientById() {
	
	var patient = {
		"patientId" : $("#search").val()
	};
	
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "http://localhost:8080/Assignment4_REST/rest/nurse/searchPatient",
		dataType : "json",
		data : JSON.stringify(patient),
		success : function(data) {
			var val = JSON.stringify(data);
			var json = $.parseJSON(val);
			//$('#patId').val(data.patientId);
			$('#name').val(data.name);
		},
		error : function(er) {
			alert("error");
		},
		failure : function(errormsg) {
			alert(errormsg);
		}
	});
}

function addAllEncounter() {
	//console.log('addAllEncounter')
	// var myObj = new Object();
	// myObj.patientId = $("#patId").val();
	// myObj.chiefComplaint = $("#cc").val();
	// myObj.doctor = $("#doctor").val();
	// myObj.vitalSign = [ respRate = $("#respRate").val() ]
	
	var str = $("#med").val();
	var med = str.split(",");
	var str2 = $("#allergies").val();
	var allergies = str2.split(",");
	var str3 = $("#symptoms").val();
	var symptoms = str3.split(",");
	var patientData = {
		patientId : {
			patientId : $("#search").val()
		},
		chiefComplaint : $("#complaint").val(),
		//doctor : $("#doctor").val(),
		vitalSign : {
			temp : $("#temp").val(),
			respRate : $("#respRate").val(),
			weight : $("#weight").val(),
			bloodPressure : $("#bp").val(),
			height : $("#height").val(),
			glucose : $("#glucose").val(),
			bmi : $("#bmi").val(),
			pulse : $("#pulse").val()
		},
		activeMeds : med,
		allergies : allergies,
		symptoms : symptoms
		
	};
	//alert(JSON.stringify(patientData));

	$.ajax({
				type : 'POST',
				contentType : 'application/json',
				url : "http://localhost:8080/Assignment4_REST/rest/nurse/addEncounter",
				dataType : "json",
				data : JSON.stringify(patientData),
				success : function(data) {
					alert("encounter created successfully");

				},
				error : function(er) {
					alert("error in vital");
				},
				failure : function(errormsg) {
					alert(errormsg);
				}
			});
}