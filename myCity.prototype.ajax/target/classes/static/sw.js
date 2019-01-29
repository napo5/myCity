//self.addEventListener('install', function(e) {
// e.waitUntil(
//   caches.open('airhorner').then(function(cache) {
//     return cache.addAll([
//    	 '/',
//    	 '/report',
//    	 "https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js",
//    	 "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js",
//    	 '/css/default.css',
//    	 'resources/css/layout.css',
//    	 '/api/customer/loadComment',
//    	 '/profile',
//    	 '/person'
//    	 
//     ]);
//   })
// );
//});

self.addEventListener('install', function(e) {
 e.waitUntil(
   caches.open('mysite-dynamic').then(function(cache) {
     return cache.addAll([
    	 '/offline'
     ]);
   })
 );
});

//prima network poi cache ; se cache non c'è allora carica /offline;
self.addEventListener('fetch', (event) => {
  event.respondWith(async function() {
    try {
      const cache = await caches.open('mysite-dynamic');
      const networkResponse = await fetch(event.request);
      event.waitUntil(
    	      cache.put(event.request, networkResponse.clone())
    	    );
      return networkResponse;
    } catch (err) {
    	const cachedResponse = await caches.match(event.request);
    	if (cachedResponse) {
    		return cachedResponse;
    	} else return await caches.match('/offline');
    }
  }());
});


//self.addEventListener('fetch', function(event) {
//	 console.log(event.request.url);  	
//	 event.respondWith(
//	   caches.match(event.request).then(function(response) {
//	     return response || fetch(event.request) ;
//	   })
//	 );
//	});


