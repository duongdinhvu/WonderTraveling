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
                if(data === '') {
                    alert('aaaaaaaaa');
                }
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

                result.append("<div class='col-sm-3' style=' margin-bottom: 10px;'>"
                 + "<div style='margin-top: 5px;'>"
                 + "<a href='#'>"
                 + "<img style='width: 170px; height: 100px;' alt='Image' src='assets/images/" + data[i].image + "'/>"
                 + "</a>"
                 + "<div>"
                 + "<div><a href='#' style='font-weight: bold' onclick='showTourDetail(" +(i + 1)+ ");'" + ">" + data[i].tourTitle + "</a></div>"
         
                 + "<input type='hidden' value='" + data[i].tourID +"'" +  " id='tourId" + (i + 1)+"'/>"
                 + "<input type='hidden' value='" + data[i].tourTitle +"'" +  " id='tourTitle" + (i + 1)+"'/>"
                 + "<input type='hidden' value='" + data[i].tourCategoryName +"'" +  " id='tourCategoryName" + (i + 1)+"'/>"
                 + "<input type='hidden' value='" + data[i].headingTo +"'" +  " id='destination" + (i + 1)+"'/>"
                 + "<input type='hidden' value='" + data[i].evenTourPrice +"'" +  " id='groupPrice" + (i + 1)+"'/>"
                 + "<input type='hidden' value='" + data[i].oddTourPrice +"'" +  " id='oddPrice" + (i + 1)+"'/>"
                 + "<input type='hidden' value='" + data[i].hotelRank +"'" +  " id='hotelRank" + (i + 1)+"'/>"
                 + "<input type='hidden' value='" + data[i].depatureDay +"'" +  " id='departureDates" + (i + 1)+"'/>"
                 + "<input type='hidden' value='" + data[i].depaturePoint +"'" +  " id='departurePoint" + (i + 1)+"'/>"
                 + "<input type='hidden' value='" + data[i].transportation +"'" +  " id='transportation" + (i + 1)+"'/>"
                 + "<input type='hidden' value='" + data[i].duration +"'" +  " id='duration" + (i + 1)+"'/>"
                 + "<input type='hidden' value='" + data[i].tickets +"'" +  " id='availableTicket" + (i + 1)+"'/>"
                 + "<input type='hidden' value='" + data[i].status +"'" +  " id='status" + (i + 1)+"'/>"
                 + "<input type='hidden' value='" + data[i].image +"'" +  " id='image" + (i + 1)+"'/>"
                 
                 + "<div>"
                 + "<div>Duration /" + data[i].duration +  " days</div>"                                                     
                 + "</div>"
                 + "<div>"
                 + "<span>Odd Price/ </span>"
                 + "<b>" + data[i].oddTourPrice + "</b>"
                 + "<span>USD</span>"
                 + "</div>"
                 + "<div>"
                 + "<span>Group Price/ </span>"
                 + "<b>" + data[i].evenTourPrice + "</b>"
                 + "<span>USD</span>"
                 + "</div>"
                 + "</div>"
                 + "</div>"
                 
                 + "</div>");              

            }

        } else{

            result.append("<div class='col-sm-3' style=' margin-bottom: 10px;'><center><h4>No Result Found</h4></center></div>");
        }
    }
};


