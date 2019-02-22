$( document ).ready(function() {
	
    $('.sendTaskRequest').submit(function(event) {
		event.preventDefault();
		console.log(event);
		ajaxPost();
	});
    
    
    function ajaxPost(){
    	var formData = {
    		id : event.target[1].value, 
    		id2 : event.target[2].value
    	}
    	
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/api/sendTaskRequest/" + formData.id + "/" + formData.id2,
			data : JSON.stringify(formData),
			dataType : 'json',
			success : function(result) {
				if(result.status != "Done"){
					$("#sendTaskRequestDiv").html("<strong>Error</strong>");
				} else {
					$("#sendTaskRequestDiv").html("<strong>Richiesta mandata a: </strong>" + result.data );
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