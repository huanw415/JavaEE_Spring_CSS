$(function(){

    var role = $('#role').data('value');
    if(role == 'OPs'){
        $('#OPs').attr("checked", true);
    }else{
        if(role == "coach"){
            $('#coach').attr('checked', true);
        }else{
            $('#HR').attr('checked', true);
        }
    }

    var gender = $('#gender').data('value');
    if(gender == "男"){
        $('#male').attr("checked", true);
    }else{
        $('#female').attr("checked", true);
    }
});