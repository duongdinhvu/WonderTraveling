$(document).ready(function() {
    $('#btnSearch').click(function() {
        tour.searchBySubmit();
    });

});

var tour = {
    searchBySubmit: function() {
        var depatureParam = $('#txtSlDeparture').val();
        var arrivalParam = $('#txtSldestionation').val();
        var depatureDateParam = $('.txtDepartureDate').val();
        $.ajax({
            type: 'POST',
            url: 'AdminTour_SearchController?action=searchbysubmit',
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


    }
};
var tourControl = {
    loadDataToResultSearch: function(data) {
        var result = $('#result-search');
        result.empty();

        if (typeof result !== 'undefined' && data.length > 0) {
            for (var i = 0; i < data.length; i++) {
                var data1 = data[0];
                var data2 = data[1];
                result.append("<div class='col-sm-3' style=' margin-bottom: 10px;'>"
                 + "<div style='margin-top: 5px;'>"
                 + "<a href='#'>"
                 + "<img style='width: 170px; height: 100px;' alt='Image' src='assets/images/" + data1[i].image + "'/>"
                 + "</a>"
                 + "<div>"
                 + "<div><a href='#' style='font-weight: bold' onclick='showTourDetail(" +(i + 1)+ ");'" + ">" + data1[i].tourTitle + "</a></div>"
         
                 + "<input type='hidden' value='" + data1[i].tourID +"'" +  " id='tourId" + (i + 1)+"'/>"
                 + "<input type='hidden' value='" + data1[i].tourTitle +"'" +  " id='tourTitle" + (i + 1)+"'/>"
                 + "<input type='hidden' value='" + data2.tourCategoryName +"'" +  " id='tourCategoryName" + (i + 1)+"'/>"
                 + "<input type='hidden' value='" + data1[i].headingTo +"'" +  " id='destination" + (i + 1)+"'/>"
                 + "<input type='hidden' value='" + data1[i].evenTourPrice +"'" +  " id='groupPrice" + (i + 1)+"'/>"
                 + "<input type='hidden' value='" + data1[i].oddTourPrice +"'" +  " id='oddPrice" + (i + 1)+"'/>"
                 + "<input type='hidden' value='" + data1[i].hotelRank +"'" +  " id='hotelRank" + (i + 1)+"'/>"
                 + "<input type='hidden' value='" + data1[i].depatureDay +"'" +  " id='departureDates" + (i + 1)+"'/>"
                 + "<input type='hidden' value='" + data1[i].depaturePoint +"'" +  " id='departurePoint" + (i + 1)+"'/>"
                 + "<input type='hidden' value='" + data1[i].transportation +"'" +  " id='transportation" + (i + 1)+"'/>"
                 + "<input type='hidden' value='" + data1[i].duration +"'" +  " id='duration" + (i + 1)+"'/>"
                 + "<input type='hidden' value='" + data1[i].tickets +"'" +  " id='availableTicket" + (i + 1)+"'/>"
                 + "<input type='hidden' value='" + data1[i].status +"'" +  " id='status" + (i + 1)+"'/>"
                 + "<input type='hidden' value='" + data1[i].image +"'" +  " id='image" + (i + 1)+"'/>"
                 
                 + "<div>"
                 + "<div>Duration /" + data1[i].duration +  " days</div>"                                                     
                 + "</div>"
                 + "<div>"
                 + "<span>Odd Price/ </span>"
                 + "<b>" + data1[i].oddTourPrice + "</b>"
                 + "<span>USD</span>"
                 + "</div>"
                 + "<div>"
                 + "<span>Group Price/ </span>"
                 + "<b>" + data1[i].evenTourPrice + "</b>"
                 + "<span>USD</span>"
                 + "</div>"
                 + "</div>"
                 + "</div>"
                 
                 + "</div>");              

            }

        }
    }
};


