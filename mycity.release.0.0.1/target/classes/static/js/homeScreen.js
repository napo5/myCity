window.addEventListener('beforeinstallprompt', (e) => {
  // Prevent Chrome 67 and earlier from automatically showing the prompt
  e.preventDefault();
  // Stash the event so it can be triggered later.
  deferredPrompt = e;
  var btnAdd = document.getElementById("btnAdd");
});



window.onload = function(){
	
btnAdd.addEventListener('click', (e) => {
	  // hide our user interface that shows our A2HS button
	  btnAdd.style.display = 'none';
	  deferredPrompt.prompt();
	  // Wait for the user to respond to the prompt
	  deferredPrompt.userChoice
	    .then((choiceResult) => {
	      if (choiceResult.outcome === 'accepted') {
	        console.log('User accepted the A2HS prompt');
	        localStorage.noFirstVisit = true;
	      } else {
	        console.log('User dismissed the A2HS prompt');
	      }
	      deferredPrompt = null;
	    });
	});

}

$( document ).ready(function() {
	//this is the first time
	if (!localStorage.noFirstVisit) {
	    document.getElementById("homeScreenDiv").style.display = "block";
	    $('#btnAdd').click(function(event){
	     // check this flag for escaping this if block next time
	    	localStorage.noFirstVisit = true;
	      });
	}
});
