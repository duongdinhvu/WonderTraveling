$(document).ready(function() {
    jQuery.noConflict();

    // Only number
    $('#txtAdult').keypress(function(event) {
        return isNumber(event, this);
    });
    $('#txtKid').keypress(function(event) {
        return isNumber(event, this);
    });
    $('#txtBaby').keypress(function(event) {

        return isNumber(event, this);
    });
    $('#txtRoom').keypress(function(event) {

        return isNumber(event, this);

    });

    var adult, kid, baby, tmp, room, tmpTickets;
    $('#txtRoom').keyup(function() {

        if ($(this).val() > tmpTickets) {
            var modal = $('#myModal');
            modal.find('.modal-title').css('color', 'blue');
            modal.find('.modal-title').text('Warning');
            modal.find('.modal-body p').css('color', "red");
            modal.find('.modal-body p').text('Individual room not greater than (Adult + Kid) !');
            modal.modal('show');
            $(this).val(0);

        }
    });



    // var form_customer = $('#form_row');
    var totalCustomer = {adults: 0, kids: 0, babies: 0, rooms: 0};
    $('#txtRoom').keyup(function() {
        if ($(this).val().trim().length === 0) {
            $(this).val(0);
        }
        room = parseInt($("#txtRoom").val());
        adult = parseInt($("#txtAdult").val());
        kid = parseInt($("#txtKid").val());
        baby = parseInt($("#txtBaby").val());
        tmp = adult + kid + baby;

        $("#txtNumPeople").val(tmp);
        totalCustomer.adults = adult;
        totalCustomer.kids = kid;
        totalCustomer.babies = baby;
        totalCustomer.rooms = room;


        controlData.getPrice(totalCustomer, tmp);
    });

    $("#txtAdult").on('change', function() {

        if ($(this).val().trim().length === 0) {
            $(this).val(0);
        }

        if ($(this).val() > 0) {
            $('#booking-complete').css("pointer-events", "visible");

        } else {
            $('#booking-complete').css("pointer-events", "none");
        }


        adult = parseInt($("#txtAdult").val());
        kid = parseInt($("#txtKid").val());
        baby = parseInt($("#txtBaby").val());
        tmp = adult + kid + baby;
        tmpTickets = adult + kid;


        $("#txtNumPeople").val(tmp);
        totalCustomer.adults = adult;
        totalCustomer.kids = kid;
        totalCustomer.babies = baby;

        var isGroup = $('#hdGroup').val();

        if (isGroup !== 'group') {
            checkNumPeople.check(tmpTickets);
        } else {
            if (tmp < 20 || tmp > 200) {
                $('#booking-complete').css("pointer-events", "none");
                $('#myModal').find('.modal-header').css('color', "blue");
                $('#myModal').find('.modal-title').text('Warning');
                $('#myModal').find('.modal-body p').css("color", "red");
                $('#myModal').find('.modal-body p').text('You have greater than 20 or less than 200 0 !!!');
                $('#myModal').modal();
                $('#txtAdult').val(0);
                $('#txtKid').val(0);
                $('#txtBaby').val(0);
                $('#txtNumPeople').val(0);
            }
        }

        controlData.getPrice(totalCustomer, tmp);

    });

    $("#txtKid").on('change', function() {
        if ($(this).val().trim().length === 0) {
            $(this).val(0);
        }


        adult = parseInt($("#txtAdult").val());
        kid = parseInt($("#txtKid").val());
        baby = parseInt($("#txtBaby").val());
        tmp = adult + kid + baby;
        tmpTickets = adult + kid;
        $("#txtNumPeople").val(tmp);

        totalCustomer.adults = adult;
        totalCustomer.kids = kid;
        totalCustomer.babies = baby;

        var isGroup = $('#hdGroup').val();

        if (isGroup !== 'group') {
            checkNumPeople.check(tmpTickets);
        } else {
            if (tmp < 20 || tmp > 200) {
                $('#myModal').find('.modal-header').css('color', "blue");
                $('#myModal').find('.modal-title').text('Warning');
                $('#myModal').find('.modal-body p').css("color", "red");
                $('#myModal').find('.modal-body p').text('You have greater than 20 or less than 200 !!!');
                $('#myModal').modal();
                $('#txtAdult').val(0);
                $('#txtKid').val(0);
                $('#txtBaby').val(0);
                $('#txtNumPeople').val(0);
            }
        }

        controlData.getPrice(totalCustomer, tmp);


    });
    $("#txtBaby").on('change', function() {
        if ($(this).val().trim().length === 0) {
            $(this).val(0);
        }


        adult = parseInt($("#txtAdult").val());
        kid = parseInt($("#txtKid").val());
        baby = parseInt($("#txtBaby").val());
        tmp = adult + kid + baby;
        tmpTickets = adult + kid;
        $("#txtNumPeople").val(tmp);

        totalCustomer.adults = adult;
        totalCustomer.kids = kid;
        totalCustomer.babies = baby;

        var isGroup = $('#hdGroup').val();

        if (isGroup !== 'group') {
            // checkNumPeople.check(tmpTickets);
            if (baby > adult) {
                $('#myModal').find('.modal-header').css('color', "blue");
                $('#myModal').find('.modal-title').text('Warning');
                $('#myModal').find('.modal-body p').css("color", "red");
                $('#myModal').find('.modal-body p').text(' Baby not greater than Adult');
                $('#myModal').modal();
                $('#txtBaby').val(0);
                $('#txtAdult').val(0);
                $('#txtKid').val(0);
            }
        } else {
            if (tmp < 20 || tmp > 200) {
                $('#myModal').find('.modal-header').css('color', "blue");
                $('#myModal').find('.modal-title').text('Warning');
                $('#myModal').find('.modal-body p').css("color", "red");
                $('#myModal').find('.modal-body p').text('You have greater than 20 or less than 200 !!!');
                $('#myModal').modal();
                $('#txtAdult').val(0);
                $('#txtKid').val(0);
                $('#txtBaby').val(0);
                $('#txtNumPeople').val(0);
            }
        }

        controlData.getPrice(totalCustomer, tmp);


    });

// Complete booking validate fullname
    $('#btnCompleteBooking').click(function() {
        var numPeople = parseInt($('#txtNumPeople').val());



        for (var i = 0; i < numPeople; i++) {
            var tmp = '#txtFullName';
            var j = i + 1;
            tmp = tmp + j;
            var fullName = $(tmp).val();
            fullName = fullName.replace(/\s/g, "");
            if (fullName.trim().length === '' || fullName.trim().length < 5 || fullName.trim().length > 25) {

                $('#error_tb').css('color', 'red');
                $('#error_tb').text('Full Name not empty or greater 5 chacracters , less than 25 characters');

                return false;
            }
            var tmpDay = '#slDay';
            tmpDay = tmpDay + j;
            var tmpMonth = '#slMonth';
            tmpMonth = tmpMonth + j;
            var tmpYear = '#slYear';
            tmpYear = tmpYear + j;


            var day = parseInt($(tmpDay).val());
            var month = parseInt($(tmpMonth).val());
            var year = parseInt($(tmpYear).val());

            if (year % 4 !== 0 && year % 400 !== 0) {
                if (month === 4 || month === 6 || month === 9 || month === 11) {
                    if (day === 31) {
                        $('#error_tb').css('color', 'red');
                        $('#error_tb').text('Invalid Date - 4,6,9,11-month (30-day)');
                        return false;
                    }
                }
                if (month === 2) {
                    if (day === 29 || day === 30 || day === 31) {

                        $('#error_tb').css('color', 'red');
                        $('#error_tb').text('Invalid Date - 29,30,31-day of February of common year');
                        return false;
                    }
                }
            } else {
                if (month === 4 || month === 6 || month === 9 || month === 11) {
                    if (day === 31) {
                        $('#error_tb').css('color', 'red');
                        $('#error_tb').text('Invalid Date - 4,6,9,11-month (30-day)');
                        return false;
                    }
                }
                if (month === 2) {
                    if (day === 30 || day === 31) {

                        $('#error_tb').css('color', 'red');
                        $('#error_tb').text('Invalid Date - 29,30,31-day of February of common year');
                        return false;
                    }
                }
            }
        }


    });

});


var checkNumPeople = {
    check: function(data) {
        var aTickets = parseInt($('#aTickets').val());

        if (data > aTickets) {
            $('#booking-complete').css("pointer-events", "none");
            $('#myModal').find('.modal-header').css('color', "blue");
            $('#myModal').find('.modal-title').text('Warning');
            $('#myModal').find('.modal-body p').css("color", "red");
            $('#myModal').find('.modal-body p').text('Only have ' + aTickets + ' available tickets (Adults + Kids)');
            $('#myModal').modal();
            $('#txtAdult').val(0);
            $('#txtKid').val(0);
            $('#txtBaby').val(0);
            $('#txtNumPeople').val(0);
        }

    }
};
var controlData = {
    getPrice: function(totalCustomer, tmp) {
        $.ajax({
            type: 'GET',
            url: 'GetTourPrice?action=getTourPrice',
            dataType: 'JSON',
            success: function(data) {
                controlForm.addForm(totalCustomer, tmp, data);
            },
            error: function(request, status, error) {
                console.log(error);
            }
        });
    }
};
var controlForm = {
    addForm: function(data, tmp, data_price) {

        var isGroup = $('#hdGroup').val();
        var isBusorAir = $('#hdTransport').val();
        var form_customer = $('#form_row');
        var total = 0;
        var isPriceGroup = 0;
        if (isGroup !== 'group') {
            isPriceGroup = data_price.oddTourPrice;
            total = (data.adults * data_price.oddTourPrice) + (data.kids * (data_price.oddTourPrice / 2)) + (data.rooms * 15);
        } else {
            isPriceGroup = data_price.evenTourPrice;
            total = (data.adults * data_price.evenTourPrice) + (data.kids * (data_price.evenTourPrice / 2)) + (data.rooms * 15);
        }


        $('#chk-r-price').text(isPriceGroup);
        $('#rAdult').text(data.adults);
        $('#rKid').text(data.kids);
        $('#rBaby').text(data.babies);
        $('#total').text("$" + total);
        $('#txtTotalPrice').val(total);
        form_customer.empty();
        if (data.adults > 0) {


            for (var i = 0; i < data.adults; i++) {


                var j = i + 1;
                form_customer
                        .append
                        ("<h2 class='passInfo1'> Passenger " + j + "</h2>"
                                + "<div class='form-group col-md-4'>"
                                + " <label>Full Name(*)</label>"
                                + " <input type='text' class='form-control'   id='txtFullName" + j + "' name='txtFullName" + j + "'  />"

                                + "</div>"


                                + "<div class='form-group col-md-2'>"
                                + "    <label>Sex</label>"
                                + "  <div class='input-group'>"
                                + "       <div class='btn-group radio-group'>"
                                + "          <label class='btn btn-primary active' id='lbMale" + j + "'>M<input type='radio' value='male' name='gender' id='gMale" + j + "' onclick='control.changeMale(" + j + ")'></label>"
                                + "          <label class='btn btn-primary not-active' id='lbFeMale" + j + "'>F<input type='radio' value='female' name='gender' id='gFeMale" + j + "' onclick='control.changeFeMale(" + j + ")'></label>"
                                + "       </div>   "
                                + "     <input type='hidden' name='hdSex" + j + "' id='hdSex" + j + "' value='male'>"
                                + "  </div> "
                                + "</div>"
                                + "<div class='form-group col-md-2'>"
                                + " <label>Day of Birth</label>"
                                + "  <select class='form-control' id='slDay" + j + "' name='slDay" + j + "'>"
                                + "    <option>01</option>"
                                + "    <option>02</option>"
                                + "    <option>03</option>"
                                + "    <option>04</option>"
                                + "    <option>05</option>"
                                + "    <option>06</option>"
                                + "    <option>07</option>"
                                + "    <option>08</option>"
                                + "    <option>09</option>"
                                + "    <option>10</option>"
                                + "    <option>11</option>"
                                + "    <option>12</option>"
                                + "    <option>13</option>"
                                + "    <option>14</option>"
                                + "    <option>15</option>"
                                + "    <option>16</option>"
                                + "    <option>17</option>"
                                + "    <option>18</option>"
                                + "    <option>19</option>"
                                + "    <option>20</option>"
                                + "    <option>21</option>"
                                + "    <option>22</option>"
                                + "    <option>23</option>"
                                + "    <option>24</option>"
                                + "    <option>25</option>"
                                + "    <option>26</option>"
                                + "    <option>27</option>"
                                + "    <option>28</option>"
                                + "    <option>29</option>"
                                + "    <option>30</option>"
                                + "    <option>31</option>"
                                + "  </select>"
                                + "</div>"
                                + "<div class='form-group col-md-2'>"
                                + " <label>Month</label>"
                                + "  <select class='form-control' id='slMonth" + j + "' name='slMonth" + j + "'>"
                                + "    <option>01</option>"
                                + "    <option>02</option>"
                                + "    <option>03</option>"
                                + "    <option>04</option>"
                                + "    <option>05</option>"
                                + "    <option>06</option>"
                                + "    <option>07</option>"
                                + "    <option>08</option>"
                                + "    <option>09</option>"
                                + "    <option>10</option>"
                                + "    <option>11</option>"
                                + "    <option>12</option>"
                                + "  </select>"
                                + "</div>"
                                + "<div class='form-group col-md-2'>"
                                + "<label>Year</label>"
                                + "  <select class='form-control' id='slYear" + j + "' name='slYear" + j + "'>"
                                + "    <option>1957</option>"
                                + "   <option>1958</option>"
                                + "   <option>1959</option>"
                                + "   <option>1960</option>"
                                + "   <option>1961</option>"
                                + "   <option>1962</option>"
                                + "   <option>1963</option>"
                                + "   <option>1964</option>"
                                + "   <option>1965</option>"
                                + "   <option>1966</option>"
                                + "   <option>1967</option>"
                                + "   <option>1968</option>"
                                + "   <option>1969</option>"
                                + "   <option>1970</option>"
                                + "   <option>1971</option>"
                                + "    <option>1972</option>"
                                + "   <option>1973</option>"
                                + "   <option>1974</option>"
                                + "   <option>1975</option>"
                                + "   <option>1976</option>"
                                + "   <option>1977</option>"
                                + "   <option>1978</option>"
                                + "   <option>1979</option>"
                                + "   <option>1980</option>"
                                + "   <option>1981</option>"
                                + "   <option>1982</option>"
                                + "   <option>1983</option>"
                                + "   <option>1984</option>"
                                + "   <option>1985</option>"
                                + "   <option>1986</option>"
                                + "    <option>1987</option>"
                                + "   <option>1988</option>"
                                + "   <option>1989</option>"
                                + "   <option>1990</option>"
                                + "   <option>1991</option>"
                                + "   <option>1992</option>"
                                + "   <option>1993</option>"
                                + "   <option>1994</option>"
                                + "   <option>1995</option>"
                                + "   <option>1996</option>"
                                + "   <option>1997</option>"
                                + "   <option>1998</option>"
                                + "   <option>1999</option>"
                                + "   <option>2000</option>"
                                + "   <option>2001</option>"

                                + "  </select>"
                                + "</div>"
                                + "<div class='form-group col-md-4'>"
                                + " <label>Age</label>"
                                + "  <input type='text' class='form-control' readonly='true' value='Adult'/>"
                                + "</div>"

                                + "<div class='form-group col-md-offset-6 col-md-2'>"
                                + " <label>Price</label>"
                                + "  <p class='form-control-static chk'>$" + isPriceGroup + "</p>"
                                + "</div>"
                                + "<div class='clear'></div>"
                                );
            }


        }
        if (data.kids > 0) {

            for (var i = 0; i < data.kids; i++) {

                var j = data.adults + 1 + i;
                form_customer
                        .append
                        ("<h2 class='passInfo1'> Passenger " + j + "</h2>"
                                + "<div class='form-group col-md-4'>"
                                + " <label>Full Name(*)</label>"
                                + " <input type='text' class='form-control' id='txtFullName" + j + "' name='txtFullName" + j + "' />"
                                + "</div>"


                                + "<div class='form-group col-md-2'>"
                                + "    <label>Sex</label>"
                                + "  <div class='input-group'>"
                                + "       <div class='btn-group radio-group'>"
                                + "          <label class='btn btn-primary active' id='lbMale" + j + "'>M<input type='radio' value='male' id='gMale" + j + "' name='gender' onclick='control.changeMale(" + j + ")'></label>"
                                + "          <label class='btn btn-primary not-active' id='lbFeMale" + j + "'>F<input type='radio' value='female' id='gFeMale" + j + "' name='gender' onclick='control.changeFeMale(" + j + ")'></label>"
                                + "       </div>   "
                                + "     <input type='hidden' name='hdSex" + j + "' id='hdSex" + j + "' value='male'>"
                                + "  </div> "
                                + "</div>"
                                + "<div class='form-group col-md-2'>"
                                + " <label>Day of Birth</label>"
                                + "  <select class='form-control' id='slDay" + j + "' name='slDay" + j + "'>"
                                + "    <option>01</option>"
                                + "    <option>02</option>"
                                + "    <option>03</option>"
                                + "    <option>04</option>"
                                + "    <option>05</option>"
                                + "    <option>06</option>"
                                + "    <option>07</option>"
                                + "    <option>08</option>"
                                + "    <option>09</option>"
                                + "    <option>10</option>"
                                + "    <option>11</option>"
                                + "    <option>12</option>"
                                + "    <option>13</option>"
                                + "    <option>14</option>"
                                + "    <option>15</option>"
                                + "    <option>16</option>"
                                + "    <option>17</option>"
                                + "    <option>18</option>"
                                + "    <option>19</option>"
                                + "    <option>20</option>"
                                + "    <option>21</option>"
                                + "    <option>22</option>"
                                + "    <option>23</option>"
                                + "    <option>24</option>"
                                + "    <option>25</option>"
                                + "    <option>26</option>"
                                + "    <option>27</option>"
                                + "    <option>28</option>"
                                + "    <option>29</option>"
                                + "    <option>30</option>"
                                + "    <option>31</option>"
                                + "  </select>"
                                + "</div>"
                                + "<div class='form-group col-md-2'>"
                                + " <label>Month</label>"
                                + "  <select class='form-control' id='slMonth" + j + "' name='slMonth" + j + "'>"
                                + "    <option>01</option>"
                                + "    <option>02</option>"
                                + "    <option>03</option>"
                                + "    <option>04</option>"
                                + "    <option>05</option>"
                                + "    <option>06</option>"
                                + "    <option>07</option>"
                                + "    <option>08</option>"
                                + "    <option>09</option>"
                                + "    <option>10</option>"
                                + "    <option>11</option>"
                                + "    <option>12</option>"
                                + "  </select>"
                                + "</div>"
                                + "<div class='form-group col-md-2'>"
                                + "<label>Year</label>"
                                + "  <select class='form-control' id='slYear" + j + "' name='slYear" + j + "'>"
                                + "    <option>2002</option>"
                                + "   <option>2003</option>"
                                + "   <option>2004</option>"
                                + "   <option>2005</option>"
                                + "   <option>2006</option>"
                                + "   <option>2007</option>"
                                + "   <option>2008</option>"
                                + "   <option>2009</option>"
                                + "   <option>2010</option>"
                                + "   <option>2011</option>"
                                + "  </select>"
                                + "</div>"
                                + "<div class='form-group col-md-4'>"
                                + " <label>Age</label>"
                                + "  <input type='text' class='form-control' readonly='true' value='Kid'/>"
                                + "</div>"

                                + "<div class='form-group col-md-offset-6 col-md-2'>"
                                + " <label>Price</label>"
                                + "  <p class='form-control-static chk'>$" + (isPriceGroup / 2) + "</p>"
                                + "</div>"
                                + "<div class='clear'></div>"
                                );
            }
        }
        if (data.babies > 0) {

            for (var i = 0; i < data.babies; i++) {
                var j = data.adults + data.kids + 1 + i;
                form_customer
                        .append
                        ("<h2 class='passInfo1'> Passenger " + j + "</h2>"
                                + "<div class='form-group col-md-4'>"
                                + " <label>Full Name(*)</label>"
                                + " <input type='text' class='form-control' id='txtFullName' name='txtFullName" + j + "' />"
                                + "</div>"

                                + "<div class='form-group col-md-2'>"
                                + "    <label>Sex</label>"
                                + "  <div class='input-group'>"
                                + "       <div class='btn-group radio-group'>"
                                + "          <label class='btn btn-primary active' id='lbMale" + j + "'>M<input type='radio' value='male'  id='gMale" + j + "' onclick='control.changeMale(" + j + ")' ></label>"
                                + "          <label class='btn btn-primary not-active' id='lbFeMale" + j + "'>F<input type='radio' value='female'  id='gFeMale" + j + "' onclick='control.changeFeMale(" + j + ")'></label>"
                                + "       </div>   "
                                + "       <input type='hidden' name='hdSex" + j + "' id='hdSex" + j + "' value='male'>"
                                + "  </div> "
                                + "</div>"

                                + "<div class='form-group col-md-2'>"
                                + " <label>Day of Birth</label>"
                                + "  <select class='form-control' id='slDay" + j + "' name='slDay" + j + "'>"
                                + "    <option>01</option>"
                                + "    <option>02</option>"
                                + "    <option>03</option>"
                                + "    <option>04</option>"
                                + "    <option>05</option>"
                                + "    <option>06</option>"
                                + "    <option>07</option>"
                                + "    <option>08</option>"
                                + "    <option>09</option>"
                                + "    <option>10</option>"
                                + "    <option>11</option>"
                                + "    <option>12</option>"
                                + "    <option>13</option>"
                                + "    <option>14</option>"
                                + "    <option>15</option>"
                                + "    <option>16</option>"
                                + "    <option>17</option>"
                                + "    <option>18</option>"
                                + "    <option>19</option>"
                                + "    <option>20</option>"
                                + "    <option>21</option>"
                                + "    <option>22</option>"
                                + "    <option>23</option>"
                                + "    <option>24</option>"
                                + "    <option>25</option>"
                                + "    <option>26</option>"
                                + "    <option>27</option>"
                                + "    <option>28</option>"
                                + "    <option>29</option>"
                                + "    <option>30</option>"
                                + "    <option>31</option>"
                                + "  </select>"
                                + "</div>"

                                + "<div class='form-group col-md-2'>"
                                + " <label>Month</label>"
                                + "  <select class='form-control' id='slMonth" + j + "' name='slMonth" + j + "'>"
                                + "    <option>01</option>"
                                + "    <option>02</option>"
                                + "    <option>03</option>"
                                + "    <option>04</option>"
                                + "    <option>05</option>"
                                + "    <option>06</option>"
                                + "    <option>07</option>"
                                + "    <option>08</option>"
                                + "    <option>09</option>"
                                + "    <option>10</option>"
                                + "    <option>11</option>"
                                + "    <option>12</option>"
                                + "  </select>"
                                + "</div>"

                                + "<div class='form-group col-md-2'>"
                                + "<label>Year</label>"
                                + "  <select class='form-control' id='slYear" + j + "' name='slYear" + j + "'>"
                                + "   <option>2012</option>"
                                + "   <option>2013</option>"
                                + "   <option>2014</option>"
                                + "   <option>2015</option>"
                                + "   <option>2016</option>"

                                + "  </select>"
                                + "</div>"

                                + "<div class='form-group col-md-4'>"
                                + " <label>Age</label>"
                                + "  <input type='text' class='form-control' name='txtAge" + j + "' readonly='true' value='Baby'/>"
                                + "</div>"

                                + "<div class='form-group col-md-offset-6 col-md-2'>"
                                + " <label>Price</label>"
                                + "  <p class='form-control-static chk'>$0</p>"
                                + "</div>"
                                + "<div class='clear'></div>"
                                );
            }
        }
    }
};
var control = {
    changeMale: function(data) {

        var str = "#lbMale" + data;
        var gMale = "#gMale" + data;
        var hdSex = "#hdSex" + data;
        $(str).removeClass('not-active').siblings().addClass('not-active');
        var tmp = $(gMale).val();
        $(hdSex).val(tmp);
    },
    changeFeMale: function(data) {
        var str = "#lbFeMale" + data;
        var gFemale = "#gFeMale" + data;
        var hdSex = "#hdSex" + data;
        $(str).removeClass('not-active').siblings().addClass('not-active');
        var tmp = $(gFemale).val();
        $(hdSex).val(tmp);
    }
};
// function to check number
function isNumber(evt, element) {


    var charCode = (evt.which) ? evt.which : event.keyCode

    if (
            (charCode != 8) && // “-” CHECK MINUS, AND ONLY ONE.
            (charCode != 0) && // “.” CHECK DOT, AND ONLY ONE.
            (charCode < 48 || charCode > 57))
        return false;
    return true;
}

/*
 * 
 * 
 
 }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 
 * 
 */