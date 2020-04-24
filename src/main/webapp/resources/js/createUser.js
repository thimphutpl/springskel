/**
 * Created by jigme.dorji on 24-Apr-2020.
 */
createUser = (function () {

    //To display list values to field
    function displayGridValueToField() {
        $('#createdUserGrid tbody').on('click', 'tr', function () {
            var data = {loginId: $(this).find("td:eq( 0 )").text()};
            $.ajax({
                url: 'createUser/getGridListToField',
                type: 'GET',
                data: data,
                success: function (res) {
                    populate(res);
                    $('#loginId').attr('disabled', true);
                    $('#createdDate').attr('disabled', true);
                    $('#btnDelete').attr('disabled', false);
                }
            });
        });
    }

    //To save the data
    function save() {
        $('#btnSave').on('click', function () {
            $('#createUsersForm').validate({
                submitHandler: function (form) {
                    $('#loginId').attr('disabled', false);
                    $.ajax({
                        url: 'createUser/save',
                        type: 'POST',
                        data: $(form).serializeArray(),
                        success: function (res) {
                            if (res.status == 1) {
                                $('#loginId').val('');

                                $('#txtUserName').val('');
                                $('#txtPassword').val('');
                                $('#txtConfirmPassword').val('');
                                swal({
                                    title: res.text,
                                    text: "Click OK to exit",
                                    type: "success"
                                }, function () {
                                    window.location.reload();
                                });
                            } else {
                                swal({
                                    title: res.text,
                                    text: "Click OK to exit",
                                    type: "error"
                                })
                            }

                        }
                    });
                }
            });
        })

    }


    /**
     * on button new click.
     */
    $('#btnNew').on('click', function () {
        $('#btnDelete').attr('disabled', true);
        $('#loginId').attr('readonly', false);
    });

    //to validate that similar login id doesnt exists
    $('#loginId').on('blur', function () {
        var loginValue = $('#loginId').val();
        if (loginValue == "") {

        } else {
            $.ajax({
                url: 'createUser/isLoginIdAlreadyExists',
                type: 'GET',
                data: {
                    loginValue: loginValue
                },
                success: function (res) {
                    if (res.status == 0) {
                        swal({
                            title: res.text,
                            text: "Click OK to exit",
                            type: "warning"
                        });
                        $('#loginId').val('');
                    } else {

                    }
                }
            });
        }
    })

    function loadCreatedUserList() {
        $.ajax({
            url: 'createUser/getUserList',
            type: 'GET',
            success: function (res) {
                var columnDef = [
                    {data: 'loginId'},
                    {data: 'txtUserName'},
                    {
                        data: 'createdDate',
                        render: function (data) {
                            return formatAsDate(data)
                        }
                    },
                    {data: 'roleName'}
                ];
                $('#createdUserGrid').DataTable({
                    data: res
                    , columns: columnDef
                    , destroy: true
                    , bSort: false
                });

            }

        });
    }

    //To validate that the password entered is same
    $('#txtConfirmPassword').on('blur', function () {
        var password = $('#txtPassword').val();
        var confirmPassword = $('#txtConfirmPassword').val();

        if (password != confirmPassword) {
            swal({
                title: "Your password doesn't match, Please type again",
                text: "Click OK to exit",
                type: "warning"
            });
            $('#txtConfirmPassword').val('');
        }
    });
    function deleteFunction() {
        $('#btnDelete').on('click', function () {
            var userId = $('#loginId').val();
            $.ajax({
                url: 'createUser/deleteUser',
                type: 'GET',
                data: {userId: userId},
                success: function (res) {
                    if (res.status == 0) {
                        swal({
                            title: res.text,
                            text: "Click OK to exit",
                            type: "success"
                        }, function (e) {
                            window.location.reload();
                        });
                    }
                }

            });

        })
    }

    function onDeleteBtnClick() {
        $('#btnDelete').on('click', function () {
            $('#myModal').modal('show');
        });
    }

    function onBtnCancelClick() {
        $('#btnCancel').on('click', function () {
            $('#myModal').modal('hide');
        });
    }

    return {
        save: save,
        loadCreatedUserList: loadCreatedUserList,
        displayGridValueToField: displayGridValueToField,
        deleteFunction: deleteFunction,
        onDeleteBtnClick: onDeleteBtnClick,
        onBtnCancelClick: onBtnCancelClick
    }
})();

$(document).ready(function () {
    createUser.save();
    createUser.loadCreatedUserList();
    createUser.displayGridValueToField();
    createUser.deleteFunction();
    createUser.onDeleteBtnClick();
    createUser.onBtnCancelClick();
});