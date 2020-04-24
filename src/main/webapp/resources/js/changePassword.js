/**
 * Created by jigme.dorji on 24-Apr-2020.
 */
changePassword = (function () {

    /**
     * save.
     */
    function save() {
        $('.globalForm').validate({
            submitHandler: function (form) {
                $.ajax({
                    url: 'changePassword/save',
                    type: 'POST',
                    data: $(form).serializeArray(),
                    success: function (res) {
                        if (res.status == 0) {
                            swal({
                                title: res.text,
                                text: "Click OK to exit",
                                type: "error"
                            });
                            $('#oldPassword').val('');
                            $('#confirmPassword').val('');
                            $('#newPassword').val('');
                        } else if (res.status == 1) {
                            swal({
                                title: res.text,
                                text: "Click OK to exit",
                                type: "success"
                            }, function (e) {
                                window.location.reload();
                            });
                            $('#oldPassword').val('');
                            $('#confirmPassword').val('');
                            $('#newPassword').val('');
                        }
                    }
                });
            }
        });
    }


    //To validate that the password entered is same
    $('#confirmPassword').on('blur', function () {
        var password = $(this).val();
        var confirmPassword = $('#newPassword').val();

        if (password != confirmPassword) {
            swal({
                title: "Your password doesn't match, Please type again",
                text: "Click OK to exit",
                type: "warning"
            });
            $('#confirmPassword').val('');
        }
    })


    return {
        save: save
    }
})();

$(document).ready(function () {
    changePassword.save();
});






