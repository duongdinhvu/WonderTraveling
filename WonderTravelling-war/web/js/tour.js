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
            max: 1500,
            values: [275, 1100],
            slide: function(event, ui) {
                ammount_from.val(ui.values[0] + 'USD');
                ammount_to.val(ui.values[1] + 'USD');
            },
            stop: function(event, ui) {
                var depatureParam = $('#depature').val();
                var arrivalParam = $('#arrival').val();
                var depatureDateParam = $('#date-inpt').val();
                $.ajax({
                    type: 'POST',
                    url: 'SearchController?action=searchbyprice',
                    dateType: 'JSON',
                    data: {"depature": depatureParam, "arrival": arrivalParam, "depatureDate": depatureDateParam, "priceFrom": ui.values[0], "priceTo": ui.values[1]},
                    success: function(data) {
                        tourControl.loadDataToResultSearch(data);
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

    $('#btnsearch').click(function() {
        tour.searchBySubmit();
    });
    $('#slider-range').slider(function() {
        tour.searchByPrice();
    });
    $("#dateOfBirth").datepicker({
        dateFormat: "dd-mm-yy",
        defaultDate: new Date()
    });
   
});

var tour = {
    searchBySubmit: function() {
        var depatureParam = $('#depature').val();
        var arrivalParam = $('#arrival').val();
        var depatureDateParam = $('#date-inpt').val();
        $.ajax({
            type: 'POST',
            url: 'SearchController?action=searchbysubmit',
            dateType: 'JSON',
            data: {"depature": depatureParam, "arrival": arrivalParam, "depatureDate": depatureDateParam},
            success: function(data) {
                tourControl.loadDataToResultSearch(data);
            },
            error: function(request, status, error) {
                if (request.status === 404) {
                    alert('No found data');
                }
            }
        });


    },
    searchByPrice: function() {
        var depatureParam = $('#depature').val();
        var arrivalParam = $('#arrival').val();
        var depatureDateParam = $('#date-inpt').val();
        $.ajax({
            type: 'POST',
            url: 'SearchController?action=searchbyprice',
            dateType: 'JSON',
            data: {"depature": depatureParam, "arrival": arrivalParam, "depatureDate": depatureDateParam, "priceFrom": ammount_from, "priceTo": ammount_to},
            success: function(data) {
                tourControl.loadDataToResultSearch(data);
            },
            error: function(request, status, error) {
                if (request.status === 404) {
                    alert('No found data');
                }
            }
        });


    }
};
var tourControl = {
    loadDataToResultSearch: function(data) {
        var result = $('#result-search');
        result.empty();

        if (typeof result !== 'undefined' && data.length > 0) {

            for (var i = 0; i < data.length; i++) {
                result.append("<div class='offer-slider-i catalog-i tour-grid fly-in'>"
                        + "<a href='#' class='offer-slider-img'>"
                        + "<img alt='' src='img/" + data[i].image + "'>"
                        + "<span class='offer-slider-overlay'>"
                        + "<span class='offer-slider-btn'>View</span><span></span>"
                        + "</span>"
                        + "</a>"
                        + "<div class='offer-slider-txt'>"
                        + "<div class='offer-slider-link'><a href='TourDetail?txtTourID=" + data[i].tourID + "'>" + data[i].tourTitle + "</a></div>"
                        + "<div class='offer-slider-l'>"
                        + "<div class='offer-slider-location'>Duration / " + data[i].duration + " days</div>"
                        + "<nav class='stars'>"
                        + "<ul>"
                        + "<li><a href='#'><img alt='' src='img/star-b.png' /></a></li>"
                        + "<li><a href='#'><img alt='' src='img/star-b.png' /></a></li>"
                        + "<li><a href='#'><img alt='' src='img/star-b.png' /></a></li>"
                        + "<li><a href='#'><img alt='' src='img/star-b.png' /></a></li>"
                        + "<li><a href='#'><img alt='' src='img/star-a.png' /></a></li>"
                        + "</ul>"
                        + "<div class='clear'></div>"
                        + "</nav>"
                        + "</div>"
                        + "<div class='offer-slider-r'>"
                        + "<b>" + data[i].oddTourPrice + "</b>"
                        + "<span>USD</span>"
                        + "</div>"
                        + "<div class='offer-slider-devider'></div>"
                        + "<div class='clear'></div>"
                        + "</div>"
                        + "</div>"
                        + "</div>"
                        + "</div>");


            }

        } else {
            result.append("<div class='srch-results-lbl fly-in'>"
                    + "<span> No found Tour(s).</span> "
                    + "</div>");

        }
    }
};


