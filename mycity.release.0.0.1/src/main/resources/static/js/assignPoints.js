$( document ).ready(function() {
	
    $('.assignPoints').submit(function(event) {
		event.preventDefault();
		console.log(event);
		ajaxPost();
		$("#assignPointsBtn").attr('disabled', true);
	});
    
    
    function ajaxPost(){
    	var formData = {
    		value : event.target[1].value
    	}
    	
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/api/assignPoints",
			data : JSON.stringify(formData),
			dataType : 'json',
			success : function(result) {
				if(result.status != "Done"){
					$(".assignPointsDiv").html("<strong>Errore: </strong>" + result.data);
				} else {
					$(".assignPointsDiv").html("<strong>Punti assegnati a </strong>" + result.data + "<strong> con successo! </strong>" );
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
