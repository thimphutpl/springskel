/**
 * Created by jigme.dorji on 24-Apr-2020.
 */

userAccessPermission = (function () {

    var userAccessPermissionGrid = $('#userAccessPermissionGrid');

    //To save the data
    function save() {
        $('.globalForm').validate({
            submitHandler: function (form) {

                $(form).find('input[type="checkbox"]').each(function () {
                    if ($(this).is(':checked')) {
                        $(this).next('input[type="hidden"]').val('true');
                    } else {
                        $(this).next('input[type="hidden"]').val('false');
                    }
                });

                $.ajax({
                    url: 'userAccessPermission/save',
                    type: 'POST',
                    data: $(form).serializeArray(),
                    success: function (res) {
                        if (res.status == 0) {
                            errorMsg(res.text);
                        } else if (res.status == 1) {
                            loadScreenList($('#roleTypeId').val())
                            swal({
                                title: res.text,
                                text: "Click OK to exit",
                                type: "success"
                            }, function () {
                                window.location.reload();
                            });
                        }
                    }
                });
            }
        });
    }

    $('#roleTypeId').on('change', function () {
        var roleTypeId = $('#roleTypeId').find('option:selected').val();
        if (roleTypeId == '') {
            userAccessPermissionGrid.find('tbody').empty();
            userAccessPermissionGrid.find('tbody').empty();
        } else {
            userAccessPermissionGrid.find('tbody').empty();
            userAccessPermissionGrid.find('tbody').empty();
            loadScreenList(roleTypeId);
        }
    });

    function loadScreenList(roleTypeId) {
        $.ajax({
            url: 'userAccessPermission/getScreenList',
            type: 'GET',
            data: {roleTypeId: roleTypeId},
            success: function (res) {
                for (var i in res) {
                    var isScreenAccessAllowed = res[i].isScreenAccessAllowed ? 'checked=""' : '';
                    var isEditAccessAllowed = res[i].isEditAccessAllowed ? 'checked=""' : '';
                    var isDeleteAccessAllowed = res[i].isDeleteAccessAllowed ? 'checked=""' : '';
                    var isSaveAccessAllowed = res[i].isSaveAccessAllowed ? 'checked=""' : '';
                    var id = res[i].id == null ? '' : res[i].id;
                    var row;
                    row = '\
                   <tr>\
                        <td><input type="hidden" id="id" name="userAccessPermissionListDTO[' + i + '].id" class="form-control form-control-sm"  value="' + id + '"><input type="hidden" id="screenId" name="userAccessPermissionListDTO[' + i + '].screenId" class=" form-control form-control-sm" readonly="true" value="' + res[i].screenId + '">'+res[i].screenId+'</td>\
                        <td><input type="hidden" id="screenName" class="form-control form-control-sm" readonly="true" value="' + res[i].screenName + '">' + res[i].screenName + '</td>\
                        <td><div align="center">\
                        <input type="checkbox" ' + isScreenAccessAllowed + ' id="checkMe">\
                        <input type="hidden" id="permission" name="userAccessPermissionListDTO[' + i + '].isScreenAccessAllowed"/></div></td>\
                        <td><div align="center">\
                        <input type="checkbox" ' + isEditAccessAllowed + ' id="checkMe">\
                        <input type="hidden" id="permission" name="userAccessPermissionListDTO[' + i + '].isEditAccessAllowed"/> \
                        </div></td>\
                        <td><div align="center">\
                        <input type="checkbox" ' + isDeleteAccessAllowed + ' id="checkMe">\
                        <input type="hidden" id="permission" name="userAccessPermissionListDTO[' + i + '].isDeleteAccessAllowed"/> \
                        </div></td>\
                        <td><div align="center">\
                        <input type="checkbox" ' + isSaveAccessAllowed + ' id="checkMe">\
                        <input type="hidden" id="permission" name="userAccessPermissionListDTO[' + i + '].isSaveAccessAllowed"/> \
                        </div>\
                        </td>\
                    </tr>';

                    var tableBody = $('#userAccessPermissionGrid tbody');
                    var noMatch = $(tableBody).find('td').first().html();
                    if (noMatch == 'No data available in table')
                        $(tableBody).find('tr').remove();
                    $('#userAccessPermissionGrid').find('tbody').append(row);
                }
            }

        });
    }

    return {
        save: save
    }
})();

$(document).ready(function () {
    userAccessPermission.save();
});