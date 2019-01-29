$( document ).ready(function() {
	
	// SUBMIT FORM
    $('#formReport').submit(function(event) {
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		console.log(event);
		ajaxPost();
	});
    
    
    function ajaxPost(){
    	// PREPARE FORM DATA
    	var formData = {
    		title : $('#titoloReport').val(),
    		description : $('#descrizioneReport').val(),
    		name : $('#autoreReport').val(),
    		image : $('#immagineReport').val()
    	}
    	
    	// DO POST
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/api/customer/createReport" ,
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
    	$("#resultDiv").html("<p style='background-color:#888E90; color:white; padding:20px 20px 20px 20px; max-width:500px;'>" + 
				"Il Report è stato aggiunto correttamente! <br>" +
				"Titolo report = " + 
				$('#titoloReport').val() + "<br>" + "Descrizione report = " + $('#descrizioneReport').val() + "<br>" + "URL = " + $('#immagineReport').val() + "</p>");
    	$('#titoloReport').val("");
    	$('#immagineReport').val("");
    	$('#descrizioneReport').val("");
    	$('#autoreReport').val("");
    }
})