// SW.js
// Implementation of a Service Worker

let appName = "modernwebie";

let filesToCache = [
    '/',
    '/css/styles.css',
    '/js/script.js',
    '/images/testimage.jpg'
];

self.addEventListener('install', function (e) {
    console.log("Install Event Triggered");

    e.waitUntil(
        caches.open(appName)
            .then(function (cache) {
                console.log("Adding files to cache");
                console.log(filesToCache);
                return cache.addAll(filesToCache);
            })
    );
});

self.addEventListener('fetch', function (e) {
    console.log(`Fetch API called: ${e.request.url}`);
    e.respondWith(
        caches.match(e.request)
            .then(function (response) {

                console.log(`response came from ${response ? 'cache' : 'server'}`)

                return response || fetch(e.request);
            })
    )
})