

var control = {
    rating: function(rating) {
        var isUserRated = $('#sessionUser').val();
        if (isUserRated === '') {
            $('#myModal1').show();
            return false;
        }
        var tourId = $('#sTour').val();
        $.ajax({
            type: 'POST',
            url: 'Rating',
            dataType: 'JSON',
            data: {"action": "rate", "rating": rating, "isRated": isUserRated, "tourId": tourId},
            success: function(data) {
                loadDataToResult.load(data);
            },
            error: function(request, status, error) {
                var modal = $('#myModal1');
                modal.find('.modal-title').css('color', 'blue');
                modal.find('.modal-title').text('Warning');
                modal.find('.modal-body p').css('color', "red");
                modal.find('.modal-body p').text('You rated already, Thank you !');
                modal.find('.modal-footer #btnOK1').hide();
                modal.show();
            }

        });
    }
};
var loadDataToResult = {
    load: function(data) {

        var totalRating = 0;
        var totalNumPeople = data.length;
        var rated = 0;
        
        for (var i = 0; i < data.length; i++) {
    
            totalRating += data[i].rating;
        }
        rated = totalRating / totalNumPeople;
        rated = Math.round(rated);
        $('#resultRating').text(rated + "/5 in " + totalNumPeople + " rating(s)");

    }
};

