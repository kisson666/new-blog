function loader() {
    var loader = document.getElementById("loader");
    setTimeout(function () {
        loader.classList.add("hidden");
    }, 2000);
}

loader();

function random_bg() {
    var num = Math.floor(Math.random() * 7) + 1;
    document.body.style.backgroundImage = "url('static/background-" + num + ".jpg')";
}

random_bg();
