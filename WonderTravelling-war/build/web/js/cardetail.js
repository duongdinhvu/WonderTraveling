$(document).ready(function(){
    var username = $('#sessionUser').val();
    $('#btnBookCar').click(function() {

        if (username === '') {
            $('#myModal1').show();
            return false;
        } else {
            window.location.href = "userCarBooking";
        }
    });

    $('a#aLogin').click(function() {
        $('#myModal2').show();
    });


    $('#btnClose1').click(function() {
        $('#myModal1').hide();
        return false;
    });
    $('#xClose1').click(function() {
        $('#myModal1').hide();
        return false;
    });
    $('#btnOK1').click(function() {
        $('#myModal1').hide();
        $('#myModal2').show();
    });
    ////Login
    $('#btnClose2').click(function() {
        $('#myModal2').hide();
        return false;
    });


    $('#xClose2').click(function() {
        $('#myModal2').hide();
        return false;
    });

    $('#btnOK2').click(function() {
        control.login("Login");
    });

});

// Control login
var control = {
    login: function(data) {
        var username = $('#username').val();
        var password = $('#password').val();
        $.ajax({
            type: 'POST',
            url: 'LoginController',
            dataType: 'JSON',
            data: {"action": data, "txtUsername": username, "txtPassword": password},
            success: function(data) {

                // alert('data:' + data);
                if (data.message === 'success_user') {

                    $('#myModal2').hide();
                    $('#aLogin').text(data.user);
                    location.reload();
                } else if (data.message === 'success_admin') {
                    window.location.href = "AdminController";
                }
                else {
                    $('#error').text("Invalid Username or Password");
                    $('#error').css("color", "red");
                    $('#myModal2').show();
                }

            }
        });
    }
};