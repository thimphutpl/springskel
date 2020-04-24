/**
 * Created by jigme.dorji on 24-Apr-2020.
 */
login = (function () {
    function init() {

    }

    return {
        init: init
    }
})();

$(document).ready(function () {
    $(document).ready(function () {
        $('.forgot-pass').click(function(event) {
            $(".pr-wrap").toggleClass("show-pass-reset");
        });

        $('.pass-reset-submit').click(function(event) {
            $(".pr-wrap").removeClass("show-pass-reset");
        });
    });
    login.init();
});