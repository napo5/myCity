$( document ).ready(function() {
	
	// SUBMIT FORM
    $('.customerForm').submit(function(event) {
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		//console.log(event);
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
				if(result.status == "Done"){
					$('#getResultDiv ul').empty();
					var custList = "";
					$.each(result.data, function(i, person){
						var person = "Autore = Da vedere" + "<br>" + "Descrizione = " + person.description + "<br>" + "<br>";
						$('#getResultDiv .list-group').prepend(person)});
					}else{
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
    	document.getElementById("card-special").style.display = "block" ;

    }
    
    function resetData(){
    	event.target[0].value = "Messaggio inviato!";
    }
})