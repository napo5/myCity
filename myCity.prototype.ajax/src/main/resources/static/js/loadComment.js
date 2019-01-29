$( document ).ready(function() {
	
	// GET REQUEST
	$(".cstomerForm").submit(function(event){
		event.preventDefault();
		console.log(event);
		ajaxGet();
	});
	
	// DO GET
	function ajaxGet(){
		$.ajax({
			type : "GET",
			url : "api/customer/loadComment",
			success: function(result){
				if(result.status == "Done"){
					$('#getResultDiv ul').empty();
					var custList = "";
					$.each(result.data, function(i, person){
						var person = "Autore = Da vedere" + "<br>" + "Descrizione = " + person.description + "<br>";
						$('#getResultDiv .list-group').append(person)
			        });
					console.log("Success: ", result);
				}else{
					$("#getResultDiv").html("<strong>Error</strong>");
					console.log("Fail: ", result);
				}
			},
			error : function(e) {
				$("#getResultDiv").html("<strong>Error</strong>");
				console.log("ERROR: ", e);
			}
		});	
	}
})