$( document ).ready(function() {
	
    $('.acceptRefuseTask').submit(function(event) {
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		console.log(event);
		ajaxPost();
		$("#acceptTask").attr('disabled', true);
		$("#refuseTask").attr('disabled', true);
		
	});
    
    
    function ajaxPost(){
    	var formData = {
    		idReport : event.target[1].value,
    		value : event.target[0].value,
    		idMessage : event.target[2].value
    	}
    	
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/api/acceptRefuseTask",
			data : JSON.stringify(formData),
			dataType : 'json',
			success : function(result) {
				if(result.status != "Done"){
					$("#messageResponse").html("<strong>Errore</strong>");
				} else {
					$("#messageResponse").html("<strong>Task </strong>" + result.data + "<strong> con successo! </strong>" );
				}
				console.log(result);
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});
    	
    }
})

