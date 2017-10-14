
$(document).ready(function() {
    'use strict';
    /** (function($) {
     $(function() {
     $('input:checkbox,input:radio,.search-engine-range-selection-container input:radio').styler();
     })
     })(jQuery);**/







    var slider_range = $("#slider-range");
    var ammount_from = $("#ammount-from");
    var ammount_to = $("#ammount-to");
    var from, to;
    $(function() {
        slider_range.slider({
            range: true,
            min: 0,
            max: 1600,
            values: [200, 1200],
            slide: function(event, ui) {
                ammount_from.val(ui.values[0] + 'USD');
                ammount_to.val(ui.values[1] + 'USD');
            },
            stop: function(event, ui) {
                var seatFromParam = $('#seatFrom').val();
                var seatToParam = $('#seatTo').val();
                $.ajax({
                    type: 'POST',
                    url: 'userCarSearchController?action=searchbyprice',
                    dateType: 'JSON',
                    data: {"seatFrom": seatFromParam, "seatTo": seatToParam, "priceFrom": ui.values[0], "priceTo": ui.values[1]},
                    success: function(data) {
                        carControl.loadDataToResultSearch(data);
                    },
                    error: function(request, status, error) {
                        if (request.status === 404) {
                            alert('No found data');
                        }
                    }
                });
            }
        });
        ammount_from.val(slider_range.slider("values", 0) + 'USD');
        ammount_to.val(slider_range.slider("values", 1) + 'USD');
    });
    $(".side-time").each(function() {
        var $this = $(this);
        $this.find('.time-range').slider({
            range: true,
            min: 0,
            max: 24,
            values: [3, 20],
            slide: function(event, ui) {
                $this.find(".time-from").text(ui.values[0]);
                $this.find(".time-to").text(ui.values[1]);
            }
        });
        $(this).find(".time-from").text($this.find(".time-range").slider("values", 0));
        $(this).find(".time-to").text($this.find(".time-range").slider("values", 1));
    });

    $("#date-inpt").datepicker({
        minDate: new Date(),
        dateFormat: "dd-mm-yy",
        defaultDate: new Date()
    });

    $('#date-inpt').datepicker().datepicker('setDate', 'today');

    $("#dt5").datepicker({
        dateFormat: "dd-mm-yy",
        minDate: 0,
        onSelect: function(date) {
            var date2 = $('#dt5').datepicker('getDate');
            date2.setDate(date2.getDate() + 1);
            $('#dt2').datepicker('setDate', date2);
            //sets minDate to dt1 date + 1
            $('#dt2').datepicker('option', 'minDate', date2);
        }
    });

    $('#dt2').datepicker({
        dateFormat: "dd-mm-yy",
        onClose: function() {

            var dt5 = $('#dt5').datepicker('getDate');
            console.log(dt5);
            var dt2 = $('#dt2').datepicker('getDate');

            if (dt2 < dt5) {
                var minDate = $('#dt2').datepicker('option', 'minDate');
                $('#dt2').datepicker('setDate', minDate);
            }

        }
    });



    $('#btnsearch').click(function() {
        car.searchBySubmit();
    });
    $('#slider-range').slider(function() {
        car.searchByPrice();
    });
    $("#dateOfBirth").datepicker({
        dateFormat: "dd-mm-yy",
        defaultDate: new Date()
    });

    $("#date-cre").datepicker({
        minDate: new Date(),
        dateFormat: "dd-mm-yy",
        defaultDate: new Date()
    });

    $('#date-cre').datepicker().datepicker('setDate', 'today');

});


var car = {
    searchBySubmit: function() {
        var seatFromParam = $('#seatFrom').val();
        var seatToParam = $('#seatTo').val();
        $.ajax({
            type: 'POST',
            url: 'userCarSearchController?action=searchbysubmit',
            dateType: 'JSON',
            data: {"seatFrom": seatFromParam, "seatTo": seatToParam},
            success: function(data) {
                carControl.loadDataToResultSearch(data);
            },
            error: function(request, status, error) {
                if (request.status === 404) {
                    alert('No found data');
                }
            }
        });
    }

};
var carControl = {
    loadDataToResultSearch: function(data) {
        var result = $('#result-search');
        result.empty();
        if (typeof result !== 'undefined' && data.length > 0) {

            for (var i = 0; i < data.length; i++) {
                var air = "No";
                if (data[i].carAirConditioning === true) {
                    air = "Yes";
                }
                var gps = "No";
                if (data[i].carGPS === true) {
                    gps = "Yes";
                }
                var chair = "No";
                if (data[i].carPushChair === true) {
                    chair = "Yes";
                }
//                result.append("<div class='offer-slider-i catalog-i tour-grid fly-in'>"
//                        + "<a href='#' class='offer-slider-img'>"
//                        + "<img alt='' src='" + data[i].carImage + "'>"
//                        + "<span class='offer-slider-overlay'>"
//                        + "<span class='offer-slider-btn'>View</span><span></span>"
//                        + "</span>"
//                        + "</a>"
//                        + "<div class='offer-slider-txt'>"
//                        + "<div class='offer-slider-link'><a href='userCarDetail?txtCarID=" + data[i].carID + "'>" + data[i].carName + "</a></div>"
//                        + "<div class='offer-slider-l'>"
//                        + "<div class='offer-slider-location'>" + data[i].carSeats +  " seats</div>"
//                        + "<div class='offer-slider-location'>" + data[i].carDoors + " doors</div>"
//                        + "<nav class='stars'>"
//                        + "<ul>"
//                        + "<li><a href='#'><img alt='' src='img/star-b.png' /></a></li>"
//                        + "<li><a href='#'><img alt='' src='img/star-b.png' /></a></li>"
//                        + "<li><a href='#'><img alt='' src='img/star-b.png' /></a></li>"
//                        + "<li><a href='#'><img alt='' src='img/star-b.png' /></a></li>"
//                        + "<li><a href='#'><img alt='' src='img/star-a.png' /></a></li>"
//                        + "</ul>"
//                        + "<div class='clear'></div>"
//                        + "</nav>"
//                        + "</div>"
//                        + "<div class='offer-slider-r'>"
//                        + "<b>" + data[i].carPrice + "</b>"
//                        + "<span>USD</span>"
//                        + "</div>"
//                        + "<div class='offer-slider-devider'></div>"
//                        + "<div class='clear'></div>"
//                        + "<div class='offer-slider-lead'>Car Tranmission: " + data[i].carTrasmission + "</div>"
//                        + "<div class='offer-slider-lead'>Air Conditioning: " + air + "</div>"
//                        + "<div class='offer-slider-lead'>GPS: " + gps + "</div>"
//                        + "<div class='offer-slider-lead'>Extra Chair: " + chair + "</div>"
//                        + "</div>"
//                        + "</div>"
//                        + "</div>"
//                        + "</div>");
                result.append("<div class='cat-list-item fly-in'>"
                        + "<div class='cat-list-item-l'>"
                        + "<a href='#'><img alt='' + src='" + data[i].carImage + "'></a>"
                        + "</div>"
                        + "<div class='cat-list-item-r'>"
                        + "<div class = 'cat-list-item-rb'>"
                        + "<div class = 'cat-list-item-p'>"
                        + "<div class = 'cat-list-content'>"
                        + "<div class = 'cat-list-content-a'>"
                        + "<div class = 'cat-list-content-l'>"
                        + "<div class = 'cat-list-content-lb'>+"
                        + "<div class = 'cat-list-content-lpadding'>"
                        + "<div class = 'offer-slider-link'><strong><a href = 'userCarDetail?txtCarID=" + data[i].carID + "'>" + data[i].carName + "</a></strong> </div>"
                        + "<div class = 'offer-slider-location'> <img style = 'width: 20px; height: 20px;' alt = '' src = 'img/icon-seats.png'/>" + data[i].carSeats + " seats</div>"
                        + "<div class = 'offer-slider-location'> <img style = 'width: 20px; height: 20px;' alt = '' src = 'img/icon-doors.png'/>" + data[i].carDoors + " doors</div>"
                        + "<div class = 'offer-slider-location'> <img style = 'width: 20px; height: 20px;' alt = '' src = 'img/icon-transmission.png'/>" + data[i].carTrasmission + "</div>"
                        + "<div class = 'offer-slider-location'> <c:if test = '${car.carGPS eq true}'> <img style = 'width: 20px; height: 20px;' alt = '' src = 'img/extra-gps.png'/>" + gps + "</c:if></div>"
                        + "<div class = 'offer-slider-location'> <c:if test = '${car.carAirConditioning eq true}'> <img style = 'width: 20px; height: 20px;' alt = '' src = 'img/icon-aircon.png'/> " + air + "</c:if></div>"
                        + "<div class = 'offer-slider-location'> <c:if test = '${car.carPushChair eq true}'> <img style = 'width: 20px; height: 20px;' alt = '' src = 'img/icons-i-03.png'/> " + chair + " </c:if></div>"
                        + "</div>"
                        + "</div>"
                        + "<br class = 'clear'/>"
                        + "</div>"
                        + "</div>"
                        + "<div class = 'cat-list-content-r'>"
                        + "<div class = 'cat-list-content-p'>"
                        + "<nav class = 'stars'>"
                        + "<ul>"
                        + "<li><a href = '#'> <img alt = '' src = 'img/star-b.png'/></a></li>"
                        + "<li><a href = '#'> <img alt = '' src = 'img/star-b.png'/></a></li>"
                        + "<li><a href = '#'> <img alt = '' src = 'img/star-b.png'/></a></li>"
                        + "<li><a href = '#'> <img alt = '' src = 'img/star-b.png'/></a></li>"
                        + "<li><a href = '#'> <img alt = '' src = 'img/star-b.png'/></a></li>"
                        + "</ul>"
                        + "<div class = 'clear'></div>"
                        + "</nav>"
                        + "<div class = 'offer-slider-r'>"
                        + "<b>" + data[i].carPrice + "</b>"
                        + "<span> avg / day </span>"
                        + "</div>"
                        + "<a href = 'userCarDetail?txtCarID=" + data[i].carID + "' class = 'cat-list-btn'> View Detail </a>"
                        + "</div>"
                        + "</div>"
                        + "<div class = 'clear'></div>"
                        + "</div>"
                        + "</div>"
                        + "</div>"
                        + "<br class = 'clear'/>"
                        + "</div>"
                        + "<div class = 'clear'>"
                        + "</div>");
            }

        } else {
            result.append("<div class='srch-results-lbl fly-in'>"
                    + "<span> No found Car(s).</span> "
                    + "</div>");
        }
    }
};


