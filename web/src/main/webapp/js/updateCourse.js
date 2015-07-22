$(function () {

    var previousCoach = $('#dropdown').data('coach');
    $('#dropdown').val(previousCoach);

    var form = $('#create_course');
    var courseId = $('.submit').data("id");
    
    form.submit(function (ev) {
        $.ajax({
            type: "POST",
            url: '/web/courses/update/' + courseId,
            data: form.serialize(),
            success: function (result) {
                $(location).attr('href', '/web/courses');
            }
        });
        ev.preventDefault();
    });
});