$( document ).ready(function() {
	
    $('#formCandidate').submit(function(event) {
		event.preventDefault();
		console.log(event);
		ajaxPost();
	});
    
    function ajaxPost(){
    	var formData = {
    		id : event.target[1].value
    	}
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/api/applyForTask/"+ formData.id ,
			data : JSON.stringify(formData),
			dataType : 'json',
			success : function(result) {
				if(result.status != "Done"){
					$("#divProva").html("<strong>Errore! (Forse ti sei già candidato)</strong>");
				} else {
					$("#divProva").html("<strong>Candidatura mandata con successo!</strong>");
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