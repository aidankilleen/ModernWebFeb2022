
// Register the service worker
if ('serviceWorker' in navigator) {
    navigator.serviceWorker.register('/sw.js');
}





let btn = document.getElementById("btnTest");


btn.addEventListener("click", function(){

    let div = document.getElementById("message");

    div.innerHTML = `you clicked ${new Date()}`;
});

