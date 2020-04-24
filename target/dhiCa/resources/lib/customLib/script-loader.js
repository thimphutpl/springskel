$(document).ready(function () {
    if (document.URL.search("companyRegistration") > 1)
        scriptLoader("resources/js/companyRegistration.js");

    if (document.URL.search("createUser") > 1)
        scriptLoader("resources/js/createUser.js");

    if (document.URL.search("changePassword") > 1)
        scriptLoader("resources/js/changePassword.js");

    if (document.URL.search("login") > 1)
        scriptLoader("resources/js/login.js");

    if (document.URL.search("home") > 1)
        scriptLoader("resources/js/home.js");

    if (document.URL.search("userAccessPermission") > 1)
        scriptLoader("resources/js/userAccessPermissionSetup.js");
});

var scriptLoader = function (url) {
    $.ajax(
        {
            type: "GET",
            url: url,
            dataType: "script",
            cache: false
        });
};



