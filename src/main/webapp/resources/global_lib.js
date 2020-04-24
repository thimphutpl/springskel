$(document).ajaxSend(function (e, xhr, options) {
    var token = $('input[name="_csrf"]').val();
    xhr.setRequestHeader("X-CSRF-TOKEN", token);
    NProgress.start();
}).ajaxStart(function () {
    NProgress.set(0.4);
}).ajaxStop(function () {
    NProgress.done();
}).ajaxError(function () {
    NProgress.done();
}).ajaxComplete(function () {
    NProgress.done();
}).ajaxSuccess(function () {
    NProgress.done();
});

$(document).ajaxError(function (event, jqxhr, settings, thrownError) {
    switch (jqxhr.status) {
        case 500:
            errorMsg("There is an unwanted exception. Please contact with concern developer.");
            break;
        case 404:
            errorMsg("Invalid Request - 404");
            break;
        case 400:
            errorMsg("Bad Request - 400");
            break;
    }
});

spms = (function () {

    function getUrl() {
        //return 'http://www.kaw.com.bt/spms/'
        //return 'http://192.168.1.10:8080/lungten_workshop/'
        return 'http://192.168.1.102:8080/spms/'
        //return 'http://localhost:8080/spms/'
        //return '/'
    }

    function baseReportLocation() {
        return window.location.protocol + '//' + window.location.host + '/spms/resources/reports/';
        //return window.location.protocol + '//' + window.location.host + '/lungten_workshop/resources/reports/';
        //return window.location.protocol + '//' + window.location.host + '/resources/reports/';
    }

    $.validator.messages.required = null;

    //index the table grid
    function _formIndexing(tableBody, row, serialNo, iterator) {
        if (!iterator)
            iterator = 0;

        for (var i = 0; i < row.length; i++) {
            tableBody.children().eq(i).children().children().each(
                function () {
                    if (this.name) {
                        this.name = this.name.replace(
                            /\[(\d+)\]/, function (str, p) {
                                return '[' + (i + iterator) + ']';
                            }
                        );
                    }

                    if ($(this).hasClass(serialNo)) {
                        $(this).val(i + 1);
                    }
                }
            );
        }
    }

    function loadGridDropDown(element, data) {
        if (!data) {
            data = [];
        }

        if (data.length) {

            element.append(
                $(
                    '<option/>', {
                        value: "",
                        text: "-- Please Select --"
                    }
                )
            );

            $.each(
                data, function (index, itemData) {
                    element.append(
                        $(
                            '<option/>', {
                                value: itemData.value,
                                text: itemData.text
                            }
                        )
                    );
                });
        }
    }

    /**
     * number to words conversion
     * @param s
     * @returns {string}
     */
    function numberToWords(s) {

        var th = ['', 'thousand', 'million', 'billion', 'trillion'];

        var dg = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine'];
        var tn = ['ten', 'eleven', 'twelve', 'thirteen', 'fourteen', 'fifteen', 'sixteen', 'seventeen', 'eighteen', 'nineteen'];
        var tw = ['twenty', 'thirty', 'forty', 'fifty', 'sixty', 'seventy', 'eighty', 'ninety'];
        s = s.toString();
        s = s.replace(/[\, ]/g, '');
        if (s != parseFloat(s)) return 'not a number';
        var x = s.indexOf('.');
        if (x == -1) x = s.length;
        if (x > 15) return 'too big';
        var n = s.split('');
        var str = '';
        var sk = 0;
        for (var i = 0; i < x; i++) {
            if ((x - i) % 3 == 2) {
                if (n[i] == '1') {
                    str += tn[Number(n[i + 1])] + ' ';
                    i++;
                    sk = 1;
                } else if (n[i] != 0) {
                    str += tw[n[i] - 2] + ' ';
                    sk = 1;
                }
            } else if (n[i] != 0) {
                str += dg[n[i]] + ' ';
                if ((x - i) % 3 == 0) str += 'hundred ';
                sk = 1;
            }
            if ((x - i) % 3 == 1) {
                if (sk) str += th[(x - i - 1) / 3] + ' ';
                sk = 0;
            }
        }
        if (x != s.length) {
            var y = s.length;
            str += 'point ';
            for (var i = x + 1; i < y; i++) str += dg[n[i]] + ' ';
        }
        return str.replace(/\s+/g, ' ');
    }


    return {
        _formIndexing: _formIndexing,
        getUrl: getUrl,
        baseReportLocation: baseReportLocation,
        loadGridDropDown: loadGridDropDown,
        numberToWords: numberToWords
    }
})();


function openPrintList() {
    window.location.href = spms.getUrl() + 'viewPrintCopy';
    /* $.ajax({
     url: 'saleItem/printList',
     type: 'GET',
     async: false,
     success: function (res) {
     window.open(res, '_blank')
     }
     })*/
}

$(document).ready(function () {

    var datePickerOptions = {
        dateFormat: "dd-M-yy",
        changeMonth: true,
        changeYear: true,
        beforeShow: function (input, inst) {
            if ($(input).prop("readonly")) {
                return false;
            }
        }
    };

    $(".datepicker").datepicker(datePickerOptions);

    $(".datepicker").keypress(function (e) {
        if (e.keyCode === 8)
            $(this).val('');
        e.preventDefault();
    });

    $('body').on('focus', '.datepicker', function () {
        if ($(this).hasClass('dynamic')) {
            $(this).datepicker(datePickerOptions);
        }
    });

    $('.mobileNoControl').attr('maxlength', '8');
    $('body').on(
        'keydown',
        '.numeric, .consumerIDControl, .mobileNoControl, .rtioControl',
        function (e) {
            if (allowKeys(e)) {
                return;
            }

            // Ensure that it is number and stop the key press
            if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
                e.preventDefault();
            }
        });

    function allowKeys(e) {
        //Allow: backspace, delete, tab, escape, enter
        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110]) !== -1 ||
                //Allow: Ctr+A
            (e.keyCode == 65 && e.ctrlKey === true) ||
                //Allow: home, end, left, right, down, up
            (e.keyCode >= 35 && e.keyCode <= 40)) {
            return true;
        }
        return false;
    }

});


function errorMsg(msg, callback) {
    swal({
        title: msg,
        text: "Click OK to exit",
        type: "warning"
    }, function (e) {
        if (callback != undefined)
            callback(e);
    });
}


function successMsg(msg, callback) {
    swal({
        title: msg,
        text: "Click OK to exit",
        type: "success"
    }, function (e) {
        if (callback != undefined)
            callback(e);
    });
}

/**
 * Responsible to populate the entire form
 * @param {json} data
 * @return {void}
 */
function populate(data) {
    for (var i in data) {
        if (typeof (data[i]) === 'object') {
            //populate(data[i]);
        } else {
            $(
                "input[type='text'][name='" + i + "']," +
                " input[type='hidden'][name='" + i + "'], " +
                "input[type='checkbox'][name='" + i + "'], " +
                "input[type='email'][name='" + i + "'], " +
                "select[name='" + i + "'], textarea[name='" + i + "']"
            )
                .val(data[i]);

            $("input[type='radio'][name='" + i + "'][value='" + data[i] + "']").prop('checked', true);
            if ($("input[name='" + i + "']").hasClass('datepicker')) {
                $("input[name='" + i + "']").val($.datepicker.formatDate("dd-M-yy", new Date(data[i])));
            }
        }
    }

    $('form').find('input[type="checkbox"]').each(
        function () {
            if ($(this).siblings('input[type="hidden"]').val() == "true" ||
                $(this).siblings('input[type="hidden"]').val() == 1) {
                $(this).prop('checked', true);
            } else {
                $(this).prop('checked', false);
            }
        }
    );
}

$.fn.disableElements = function (status) {
    $(this).removeClass('error');
    $(this).each(
        function () {
            $(this).attr('readonly', status);
            $(this).find('option').prop('disabled', status);

            if ($(this).is(':checkbox') || $(this).is(':radio')) {
                $(this).attr('disabled', status);
            }
            $('input:checkbox[name=checkme]').attr('disabled', status);
        }
    );
};

$.fn.SPMSSimpleGrid = function (data, column_def) {
    //debugger;
    $(this).dataTable().fnDestroy();
    $(this).dataTable(
        {
            "scrollY": "200px",
            "data": data,
            "columns": column_def
        }
    );
};


function formatAsDate(date) {
    if (date)
        var dateSplit = date.split('-');
    var year = dateSplit[0];
    var month = dateSplit[1];
    var day = dateSplit[2];
    var monthNames = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];

    if (parseInt(month) == 1) {
        month = monthNames[0];
    } else if (parseInt(month) == 2) {
        month = monthNames[1];
    } else if (parseInt(month) == 3) {
        month = monthNames[2];
    } else if (parseInt(month) == 4) {
        month = monthNames[3];
    } else if (parseInt(month) == 5) {
        month = monthNames[4];
    } else if (parseInt(month) == 6) {
        month = monthNames[5];
    } else if (parseInt(month) == 7) {
        month = monthNames[6];
    } else if (parseInt(month) == 8) {
        month = monthNames[7];
    } else if (parseInt(month) == 9) {
        month = monthNames[8];
    } else if (parseInt(month) == 10) {
        month = monthNames[9];
    } else if (parseInt(month) == 11) {
        month = monthNames[10];
    } else if (parseInt(month) == 12) {
        month = monthNames[11];
    }
    return day + '-' + month + '-' + year;
}



