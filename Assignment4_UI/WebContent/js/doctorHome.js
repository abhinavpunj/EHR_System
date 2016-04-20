$(document).ready(function(){
	var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    var personId = 0;
    var key;
    for (var i = 0; i < sURLVariables.length; i++)
    {
    	var sParameterName = sURLVariables[i].split('=');
    	if (sParameterName[0] == 'personId')
    	{
    		personId = sParameterName[1];
    	}
    	else if(sParameterName[0] == 'AUTH_KEY')
    	{
    		key = sParameterName[1];
    	}
	}
    
    var perJson = {
    		personId : personId
    };
    $.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "http://localhost:8080/Assignment4_REST/rest/doctor",
		dataType : "json",
		data : JSON.stringify(perJson),
		beforeSend: function (xhr) {
            /////   Authorization header////////
              xhr.setRequestHeader("AUTH_KEY", key);
          },
		success : function(data) {
			var val = JSON.stringify(data);
			var json = $.parseJSON(val);
			$('#drName').append(json.name);
			var list = $("#patientList");
			for(var i=0; i<json.patients.length; i++){
				list.append('<a href="Doctor-PatientProfile.jsp?doctorId=' + 
						personId + '&patientId=' + json.patients[i].patientId + 
						'" class="list-group-item">' + json.patients[i].patientId +':' + json.patients[i].name + '</a>');
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