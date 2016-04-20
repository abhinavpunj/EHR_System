function register(){
	var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    var key;
    for (var i = 0; i < sURLVariables.length; i++)
    {
    	var sParameterName = sURLVariables[i].split('=');
    	if(sParameterName[0] == 'AUTH_KEY')
    	{
    		key = sParameterName[1];
    	}
	}
	var dob = new Date($("#dob").val());
	var dobJSON = dob.toJSON();
	pat = {}
	pat["name"] = $("#name").val();
	pat["age"] = $("#age").val();
	pat["gender"] = $("#gender").val();
	pat["address"] = $("#address").val();
	pat["phone"] = $("#phone").val();
	
	$.ajax({
        url: "http://localhost:8080/Assignment4_REST/rest/nurse/registerPatient",
        data: JSON.stringify(pat),
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        type: "POST",
        beforeSend: function (xhr) {
            /////   Authorization header////////
              xhr.setRequestHeader("AUTH_KEY", key);
          },
        success: function(data) {
        	alert("Patient Registered");                 	
        },
        error: function(er) {
        	alert(er);
        },
		failure: function(errormsg) {
			alert(errormsg);
		}
    });
	/*actMed = {}
	for(var i=0; i<med.length; i++){
		actMed[i] = med[i];
	}
	pat[""]*/
}