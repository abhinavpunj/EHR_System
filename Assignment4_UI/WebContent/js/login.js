function login() {
			var loginData = {"username" : $("#username").val(), "password" : $("#inputPassword").val()};
			
			$.ajax({
                url: "http://localhost:8080/Assignment4_REST/rest/login",
                data: JSON.stringify(loginData),
                dataType: "json",
                contentType: "application/json; charset=utf-8",
                type: "POST",
                success: function(data) {
                	var str = JSON.stringify(data);
                	var json = JSON.parse(str);
                    if(json.role == "Doctor"){
                    	
                    	window.location = "DoctorHome.jsp?AUTH_KEY=doctor&personId=" + json.personId;
                    }
                    else if(json.role == "Nurse"){

                    	window.location = "NurseHome.jsp?AUTH_KEY=nurse&personId=" + json.personId;
                    	
                    }                    	
                },
				failure: function(errormsg) {
					alert(errormsg);
				}
            });
		}