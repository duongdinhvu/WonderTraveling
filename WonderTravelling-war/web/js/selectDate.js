$(document).ready(function() {
    $(".btn-select").each(function(e) {
        var value = $(this).find("ul li.selected").html();
        if (value != undefined) {
            $(this).find(".btn-select-input").val(value);
            $(this).find(".btn-select-value").html(value);

        }
    });
});

$(document).on('click', '.btn-select', function(e) {
    e.preventDefault();
    var ul = $(this).find("ul");
    if ($(this).hasClass("active")) {
        if (ul.find("li").is(e.target)) {
            var target = $(e.target);
            target.addClass("selected").siblings().removeClass("selected");
            var value = target.html();
            $(this).find(".btn-select-input").val(value);
            $(this).find(".btn-select-value").html(value);

            checkTicketsAvailable.check(value);

        }
        ul.hide();
        $(this).removeClass("active");
    }
    else {
        $('.btn-select').not(this).each(function() {
            $(this).removeClass("active").find("ul").hide();
        });
        ul.slideDown(300);
        $(this).addClass("active");
    }
});

$(document).on('click', function(e) {
    var target = $(e.target).closest(".btn-select");
    if (!target.length) {
        $(".btn-select").removeClass("active").find("ul").hide();
    }
});

var postDepature = {
    post: function(dataDepature, dataAvailableTickets) {
        $.ajax({
            type: 'POST',
            url: 'TourBooking?action=postDate',
            data: {"depature": dataDepature, "aTickets": dataAvailableTickets},
            success: function() {

            }
        });
    }
};

var checkTicketsAvailable = {
    check: function(data) {
        var date = data;
        $.ajax({
            type: 'POST',
            url: 'TicketsAvailable?action=checktickets',
            dataType: 'JSON',
            data: {"depature": data},
            success: function(data, request) {

                displayAvailable.display(data);
                postDepature.post(date, data);

            },
            error: function(request, status, error) {
                console.log(error);
            }
        });
    }
};
var displayAvailable = {
    display: function(data) {
        if (data === 0 || data === 'undefined') {
            $('#available').text("Full");
            $('#available').css("color", "red");
            $('.book-btn').css("pointer-events","none");
            
        } else {
              $('.book-btn').css("pointer-events","visible");
            $('#available').text(data + " Available");
            $('#available').css("color", "red");
        }

    }
};