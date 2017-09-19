/**
 * Created by Alex.hu on 2017/6/19.
 */

$(function(){

$('#datetimeStart').datetimepicker({
    format: 'yyyy-mm-dd hh:ii ',
    weekStart: 1,
    todayBtn:  1,
    autoclose: 1,
    todayHighlight: 1,
    startView: 2,
    forceParse: 0,
    showMeridian: 1
});

    $('#datetimeEnd').datetimepicker({
        format: 'yyyy-mm-dd hh:ii ',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1
    });
});
