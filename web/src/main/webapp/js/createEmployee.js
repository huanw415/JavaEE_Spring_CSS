$(function(){

   var userName;
   $('.chooseUser').on('click', function(){

       userName = $(this).data('name');
       $('#dropdownMenu').text(userName);
   });

    var form = $('#new_employee');

    form.submit(function(ev){

        $.ajax({
            url: '/web/employees/creation',
            type: 'POST',
            data: form.serialize(),
            success: function(data){
                $(location).attr('href', '/web/employees');
            }
        });
        ev.preventDefault();

    });
});