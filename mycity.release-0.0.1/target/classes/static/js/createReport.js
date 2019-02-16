$( document ).ready(function() {
	
    $('#formReport').submit(function(event) {
		event.preventDefault();
		console.log(event);
		ajaxPost();
	});
    
    
    function ajaxPost(){
    	var formData = {
    		title : $('#titoloReport').val(),
    		description : $('#descrizioneReport').val(),
    		image : $('#immagineReport').val()
    	}
    	
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/api/createReport" ,
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
    	
    	resetData();

    }
    
    function resetData(){
    	$("#resultDiv").html("<p style='color:black; padding:20px 20px 20px 20px; max-width:500px;'>" + 
				"Il Report è stato aggiunto correttamente!" + "</p>");
    	$('#titoloReport').val("");
    	$('#immagineReport').val("");
    	$('#descrizioneReport').val("");
    }
})