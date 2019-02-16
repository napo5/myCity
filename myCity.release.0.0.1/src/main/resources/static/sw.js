self.addEventListener('install', function(e) {
 e.waitUntil(
   caches.open('mysite-dynamic').then(function(cache) {
     return cache.addAll([
    	 '/offline'
     ]);
   })
 );
});
//network before cache; otherwhise it goes to /offline
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
