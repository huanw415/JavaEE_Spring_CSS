$(function(){

    function hideCustomer(){
        $('#title').hide();
        $('#noneCustomer').hide();
        $('.customer').hide();
    }

    function showCustomers(){
        $('#title').show();

        var courseName = $("#selector").find("option:selected").data('course');

        if(courseName !== 'private'){
            $('#title').hide();
            $("#none").attr("checked",true);
        }else{
            $('.customer').show();
        }
    }

    hideCustomer();
    showCustomers();

    $('#selector').on('change', function(){
        //hideCustomer();
        showCustomers();
    });

    var form = $('#new_schedule');

    form.submit(function (ev) {
        $.ajax({
            type: "POST",
            url: "/web/schedules/creation",
            data: form.serialize(),
            success: function (result) {
                if(result == 'coach is busy'){
                    $('#time').css('border', "red 1px solid");
                }else{
                    $(location).attr('href', '/web/schedules');
                }
            }
        });
        ev.preventDefault();
    });
});