$( document ).ready(function() {
	
    $('.customerForm').submit(function(event) {
		event.preventDefault();
		console.log(event);
		ajaxPost();
	});
    
    
    function ajaxPost(){
    	var formData = {
    		description : event.target[0].value,
    		id : event.target[1].value
    	}
    	
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/api/addComment/" + formData.id ,
			data : JSON.stringify(formData),
			dataType : 'json',
			success : function(result) {
				if(result.status == "Done"){
					}else{
					$(".postResultDiv").html("<strong>Error</strong>");
					$(".postResultDiv").style.display = "block";
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
    	event.target[0].value = "Messaggio inviato! Ricarica la pagina per vederlo!";
    }
})