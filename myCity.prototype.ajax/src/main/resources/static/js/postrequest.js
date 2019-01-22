$( document ).ready(function() {
	
	// SUBMIT FORM
    $('.customerForm').submit(function(event) {
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		console.log(event);
		ajaxPost();
	});
    
    
    function ajaxPost(){
    	// PREPARE FORM DATA
    	var formData = {
    		description : event.target[0].value,
    		id : event.target[1].value
    	}
    	
    	
    	// DO POST
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/api/customer/save/" + formData.id ,
			data : JSON.stringify(formData),
			dataType : 'json',
			success : function(result) {
				if(result.status != "Done"){
					$(".postResultDiv").html("<strong>Error</strong>");
				}
				console.log(result);
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});
    	
    	// Reset FormData after Posting
    	resetData();

    }
    
    function resetData(){
    	event.target[0].value = "Messaggio inviato!";
    }
})