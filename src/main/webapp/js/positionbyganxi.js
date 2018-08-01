function setCopyright() {
    height = $(window).height() - $('.copyright').height();
    $(".copyright").css("margin-top", height * 0.97 + 'px');
}

$(window).resize(function () {
    setCopyright();
});
$(document).ready(function () {
    setCopyright();
});
