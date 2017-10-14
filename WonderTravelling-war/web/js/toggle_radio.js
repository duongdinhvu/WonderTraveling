$(document).ready(function() {
    // Use only for V1
    $('#radioBtn1 span').on('click', function() {
        var sel = $(this).data('value');

        var tog = $(this).data('toggle');

        $('#hdGroup').val(sel);
        
        $('#' + tog).val(sel);
        // You can change these lines to change classes (Ex. btn-default to btn-danger)
        $('span[data-toggle="' + tog + '"]').not('[data-value="' + sel + '"]').removeClass('active btn-primary').addClass('notActive btn-default');
        $('span[data-toggle="' + tog + '"][data-value="' + sel + '"]').removeClass('notActive btn-default').addClass('active btn-primary');
    });

   $('#radioBtn2 span').on('click', function() {
        var sel = $(this).data('value');
      
        var tog = $(this).data('toggle');
      

        $('#hdTransport').val(sel);
        
        $('#chk-r-Trans').text(sel);
        $('#' + tog).val(sel);
        // You can change these lines to change classes (Ex. btn-default to btn-danger)
        $('span[data-toggle="' + tog + '"]').not('[data-value="' + sel + '"]').removeClass('active btn-primary').addClass('notActive btn-default');
        $('span[data-toggle="' + tog + '"][data-value="' + sel + '"]').removeClass('notActive btn-default').addClass('active btn-primary');
    });

});
