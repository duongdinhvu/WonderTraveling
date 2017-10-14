<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WonderTraveling Admin</title>
        <meta name="description" content="" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
        <link rel="stylesheet" href="assets/css/bootstrap.min.css" />
        <link rel="stylesheet" href="assets/font-awesome/4.5.0/css/font-awesome.min.css" />
        <link rel="stylesheet" href="assets/css/fonts.googleapis.com.css" />
        <link rel="stylesheet" href="assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style"/>
        <link rel="stylesheet" href="assets/css/ace-skins.min.css" />
        <script src="assets/js/jquery-2.1.4.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/ace-elements.min.js"></script>
        <script src="assets/js/ace.min.js"></script>
        <!-- NEW DatePicker -->
        <script src="assets/js/jquery-ui.min.js"></script>              
        <link rel="stylesheet" href="assets/css/jquery-ui.min.css"/>

        <script>

            function validateForm() {
                var headingTo = document.getElementById('txtHeadingTo_Update');
                var headingToVal = headingTo.options[headingTo.selectedIndex].value;
                var departure = document.getElementById('txtDeparturePoint_Update');
                var departureVal = departure.options[departure.selectedIndex].value;

                var cbBus = document.getElementById('cbxBus').checked;
                var cbAirPlane = document.getElementById('cbxAirPlane').checked;

                var groupPrice = document.formEditTourPackage.txtEvenTourPrice_Update.value;
                var subPrice = document.formEditTourPackage.txtOddTourPrice_Update.value;

                var groupPriceInt = parseInt(groupPrice);
                var subPriceInt = parseInt(subPrice);

                var tourTitle = document.formEditTourPackage.txtTourTitle_Update.value;

                var ticket = document.formEditTourPackage.txtTickets_Update.value;
                var ticketInt = parseInt(ticket);

                var departureDates = document.formEditTourPackage.txtTourDepartureDays_Update.value;
                var image = document.formEditTourPackage.txtImage.value;

                var status = false;
                var alphaExp = /^(?=.*[a-zA-Z])(?=.*[0-9])/;


                if (tourTitle.replace(/^\s+/g, '').length === 0) {
                    document.getElementById('titleError').innerHTML
                            = "<img src='assets/images/unchecked.gif'/> Please Enter Tour Title !";
                    document.getElementById('txtTourTitle_Update').focus();
                    status = false;
                    return false;
                } else if (tourTitle.replace(/^\s+/g, '').length < 5 || tourTitle.replace(/^\s+/g, '').length > 60) {
                    document.getElementById('titleError').innerHTML
                            = "<img src='assets/images/unchecked.gif'/> Tour Title Must Be Between 5 - 60 !";
                    document.getElementById('txtTourTitle_Update').focus();
                    status = false;
                    return false;
                } else if (!tourTitle.match(alphaExp)) {
                    document.getElementById('titleError').innerHTML
                            = "<img src='assets/images/unchecked.gif'/> Tour Title Invalid (Must Be Included Both Letters And Numerics) !!!";
                    document.getElementById('txtTourTitle_Update').focus();
                    status = false;
                    return false;
                } else {
                    document.getElementById('titleError').innerHTML
                            = "<img src='assets/images/checked.gif'/>";

                    if (headingToVal === departureVal) {
                        document.getElementById('destinationError').innerHTML
                                = "<img src='assets/images/unchecked.gif'/> Destination And Departure Can't be the Same!";
                        document.getElementById('txtDeparturePoint_Update').focus();
                        status = false;
                        return false;
                    } else {
                        document.getElementById('destinationError').innerHTML
                                = "<img src='assets/images/checked.gif'/>";
                        if (groupPrice.replace(/^\s+/g, '').length === 0) {
                            document.getElementById('groupPriceError').innerHTML
                                    = "<img src='assets/images/unchecked.gif'/> Please Enter Group Tour Price !";
                            document.getElementById('txtEvenTourPrice_Update').focus();
                            status = false;
                            return false;
                        } else if (groupPriceInt > 2000 || groupPriceInt < 50) {
                            document.getElementById('groupPriceError').innerHTML
                                    = "<img src='assets/images/unchecked.gif'/> Group Tour Price Must Be Between 50 - 2000 !";
                            document.getElementById('txtEvenTourPrice_Update').focus();
                            status = false;
                            return false;
                        } else {
                            document.getElementById('groupPriceError').innerHTML
                                    = "<img src='assets/images/checked.gif'/>";

                            if (subPrice.replace(/^\s+/g, '').length === 0) {
                                document.getElementById('subPriceError').innerHTML
                                        = "<img src='assets/images/unchecked.gif'/> Please Enter Sub Tour Price !";
                                document.getElementById('txtOddTourPrice_Update').focus();
                                status = false;
                                return false;
                            } else if (subPriceInt > 2000 || subPriceInt < 51) {
                                document.getElementById('subPriceError').innerHTML
                                        = "<img src='assets/images/unchecked.gif'/> Sub Tour Price Must Be Between 51 - 2000 !";
                                document.getElementById('txtOddTourPrice_Update').focus();
                                status = false;
                                return false;
                            } else if (subPriceInt <= groupPriceInt) {
                                document.getElementById('subPriceError').innerHTML
                                        = "<img src='assets/images/unchecked.gif'/> Sub Tour Price Must Be Greater Than Group Tour Price !";
                                document.getElementById('txtOddTourPrice_Update').focus();
                                status = false;
                                return false;
                            } else {

                                document.getElementById('subPriceError').innerHTML
                                        = "<img src='assets/images/checked.gif'/>";
                                if (!cbBus && !cbAirPlane) {
                                    document.getElementById('transportationError').innerHTML
                                            = "<img src='assets/images/unchecked.gif'/> Select Transportation Please!";
                                    document.getElementById('cbxBus').focus();
                                    status = false;
                                    return false;
                                } else {
                                    document.getElementById('transportationError').innerHTML
                                            = "<img src='assets/images/checked.gif'/>";
                                    if (ticket.replace(/^\s+/g, '').length === 0) {
                                        document.getElementById('availableTicketError').innerHTML
                                                = "<img src='assets/images/unchecked.gif'/> Please Enter Tour Ticket !";
                                        document.getElementById('txtTickets_Update').focus();
                                        status = false;
                                        return false;
                                    } else if (ticketInt > 100 || ticketInt <= 0) {
                                        document.getElementById('availableTicketError').innerHTML
                                                = "<img src='assets/images/unchecked.gif'/> Ticket Must Be Between 1 - 100 !";
                                        document.getElementById('txtTickets_Update').focus();
                                        status = false;
                                        return false;
                                    } else {
                                        document.getElementById('availableTicketError').innerHTML
                                                = "<img src='assets/images/checked.gif'/>";

                                        if (departureDates.replace(/^\s+/g, '').length === 0) {
                                            $('#departureDateDeleteError').text('Select Departure Date !!!');
                                            document.getElementById('datepicker').focus();
                                            status = false;
                                            return false;
                                        } else {
                                            status = true;
                                        }
                                    }
                                }
                            }

                        }
                    }
                }

                return status;
            }

            function isValid() {
                var isOk = validateForm();
                if (isOk === true) {
                    return confirm('Sure You Want To Edit ?');
                } else {
                    return false;
                }
            }
        </script>

        <script type="text/javascript">
            $(function() {
                $("#datepicker").datepicker({
                    //format and contraint datepicker
                    dateFormat: 'dd-mm-yy', minDate: 0, showButtonPanel: true
                });
            });
        </script>

        <script type="text/javascript">
            $(document).ready(function() {
                $('.image-upload-wrap').hide();
            });
        </script>

        <script type="text/javascript">
            $(document).ready(function() {
                var transShort = parseInt($('#txtTransportation_Update').val());
                if (transShort == 1) {
                    $('#tdCbx').append('<input type="checkbox" id="cbxBus" name="cbxBus" value="2"/> Bus<input style="margin-left: 25px;" type="checkbox" id="cbxAirPlane" name="cbxAirPlane" value="1" checked/> AirPlane');
                } else if (transShort == 2) {
                    $('#tdCbx').append('<input type="checkbox" id="cbxBus" name="cbxBus" value="2" checked/> Bus<input style="margin-left: 25px;" type="checkbox" id="cbxAirPlane" name="cbxAirPlane" value="1"/> AirPlane');
                } else {
                    $('#tdCbx').append('<input type="checkbox" id="cbxBus" name="cbxBus" value="2" checked/> Bus<input style="margin-left: 25px;" type="checkbox" id="cbxAirPlane" name="cbxAirPlane" value="1" checked/> AirPlane');
                }
                ;
            });
        </script>

        <script type="text/javascript">

            $(document).ready(function() {
                var array = new Array("");
                var departureDaysString = "";

                //appendding dates tag when the page loaded
                var datesCreatedBeforeUpdate = new Array("");
                datesCreatedBeforeUpdate = $('#txtTourDepartureDays_Update').val().split(", ");

                $.each(datesCreatedBeforeUpdate, function(index, item) {
                    $("div#choosenDates").append("<b>" + item + "<a href='javascript:void(0);' class='remove'>&nbsp;&times;</a></b>&nbsp;&nbsp;&nbsp;");
                    array.push(item);
                });

                $("#btnUpdateDepartureDays").click(function() {
                    //checking if the day user just selected is already existed in array 'array'
                    var count = 0;
                    $.each(array, function(index, item) {
                        if (item === $("input#datepicker").val()) {
                            count++;
                        }
                    });

                    if (count === 0) {
                        array.push($("input#datepicker").val());
                        var choosenDate = $("input#datepicker").val();
                        $("div#choosenDates").append("<b>" + choosenDate + "<a href='javascript:void(0);' class='remove'>&nbsp;&times;</a></b>&nbsp;&nbsp;&nbsp;");
                        departureDaysRefresh();
                        alert(departureDaysString);
                    } else {
                        alert('Date ' + $("input#datepicker").val().toString() + ' Is Already Existed !');
                        return false;
                    }
                });

                //remove b tag when click on 'x' tag and remove it value in array at the same time
                $(document).on("click", "a.remove", function() {
                    //get list Of Destination Is Already Generated Of Book
                    var stringOfDepartureDateAlreadyGenerated = $('#stringOfDepartureDateAlreadyGenerated').val();
                    var arrayOfGenerated = stringOfDepartureDateAlreadyGenerated.split(', ');

                    var it = ($(this).parent().html()).toString();
                    var itafter = it.substring(0, 10);

                    var i = 0;
                    $.each(arrayOfGenerated, function(index, el) {
                        if (el.toString() === itafter.toString()) {
                            i++;
                        }
                    });
                    if (i > 0) {
                        $('#departureDateDeleteError').text('Cannot Delete! Date ' + itafter + ' Is Already Generated Of Books !!!');
                        return false;
                    } else {
                        $(this).parent().remove();
                        $('#departureDateDeleteError').text('');
                        array.splice($.inArray(itafter, array), 1);
                        departureDaysRefresh();
                    }

                    //alert(departureDaysString);
                });

                function departureDaysRefresh() {
                    departureDaysString = "";
                    if ((array.length) > 0) {
                        $.each(array, function(index, item) {
                            departureDaysString += item + ", ";
                        });
                        $('#txtTourDepartureDays_Update').val(departureDaysString);
                    }
                }
                ;

            });
        </script>
    </head>
    <body class="no-skin">
        <div class="navbar navbar-default  ace-save-state">
            <div class="navbar-header pull-left">
                <a href="#" class="navbar-brand">
                    <small>
                        <i class="fa fa-leaf"></i>
                        Wonder Traveling Admin
                    </small>
                </a>
            </div>
            <div class="navbar-buttons navbar-header pull-right" role="navigation">
                <ul class="nav ace-nav">
                    <li class="light-blue dropdown-modal">
                        <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                            <img style="margin-top: 3px;" class="nav-user-photo" src="assets/images/avatars/user.jpg" alt="Jason's Photo" />
                            <span class="user-info">
                                Welcome Admin
                            </span>
                            <i class="ace-icon fa fa-caret-down"></i>
                        </a>
                        <!--USER SETTING-->
                        <ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                            <li>
                                <a href="#">
                                    <i class="ace-icon fa fa-cog"></i>
                                    Settings
                                </a>
                            </li>

                            <li>
                                <a href="#">
                                    <i class="ace-icon fa fa-user"></i>
                                    Profile
                                </a>
                            </li>

                            <li class="divider"></li>

                            <li>
                                <a href="LoginController?action=logout">
                                    <i class="ace-icon fa fa-power-off"></i>
                                    Logout
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul><!-- END USER SETTING-->
            </div>
        </div>
        <!----------------------------------------------------END HEADER---------------------------------------------------->
        <div class="main-container ace-save-state" id="main-container">
            <script type="text/javascript">
                try {
                    ace.settings.loadState('main-container');
                } catch (e) {
                }
            </script>
            <div id="sidebar" class="sidebar  responsive  ace-save-state">
                <script type="text/javascript">
                    try {
                        ace.settings.loadState('sidebar');
                    } catch (e) {
                    }
                </script>
                <div class="sidebar-shortcuts" id="sidebar-shortcuts">
                    <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
                        <button class="btn btn-success"><i class="ace-icon fa fa-signal"></i></button>
                        <button class="btn btn-info"><i class="ace-icon fa fa-pencil"></i></button>
                        <button class="btn btn-warning"><i class="ace-icon fa fa-users"></i></button>
                        <button class="btn btn-danger"><i class="ace-icon fa fa-cogs"></i></button>
                    </div>
                </div><!-- /.sidebar-shortcuts -->
                <ul class="nav nav-list"><!-- LEFT MENU -->
                    <li class="active">
                        <a href="#">
                            <i class="menu-icon fa fa-tachometer"></i>
                            <span class="menu-text"> Dashboard </span>
                        </a>
                        <b class="arrow"></b>
                    </li>
                    <li class="">
                        <a href="#" class="dropdown-toggle">
                            <i class="menu-icon fa fa-desktop"></i>
                            <span class="menu-text">
                                Tour
                            </span>
                            <b class="arrow fa fa-angle-down"></b>
                        </a>
                        <b class="arrow"></b>

                        <ul class="submenu">

                            <li class="">
                                <a href="AdminTour_TourCategorySelect_Controller">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Tour Category
                                </a>
                                <b class="arrow"></b>
                            </li>
                            <li class="">
                                <a href="AdminTour_TourSelect_Controller">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Tour package
                                </a>
                                <b class="arrow"></b>
                            </li>
                            <li class="">
                                <a href="AdminTour_SearchController_OpenPage">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Search Tour
                                </a>
                                <b class="arrow"></b>
                            </li>                      
                        </ul>
                    </li>
                    <li class="">
                        <a href="#" class="dropdown-toggle">
                            <i class="menu-icon fa fa-list"></i>
                            <span class="menu-text">Tour Ordered </span>

                            <b class="arrow fa fa-angle-down"></b>
                        </a>
                        <b class="arrow"></b>
                        <ul class="submenu">

                            <li class="">
                                <a href="AdminTour_TourReserved_Select_Controller">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Tour Reserved
                                </a>
                                <b class="arrow"></b>
                            </li>

                            <li class="">
                                <a href="AdminTour_SubTourReserved_Controller?action=selectList">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Sub Tour Reserved
                                </a>
                                <b class="arrow"></b>
                            </li>

                            <li class="">
                                <a href="AdminTour_TourReport_Controller?action=reportPageCalling">
                                    <i class="menu-icon fa fa-line-chart"></i>
                                    Tour Report
                                </a>
                            </li>

                        </ul>
                    </li>
                    <li class="">
                        <a href="#" class="dropdown-toggle">
                            <i class="menu-icon fa fa-car" aria-hidden="true"></i>
                            <span class="menu-text"> Car </span>
                            <b class="arrow fa fa-angle-down"></b>
                        </a>
                        <b class="arrow"></b>
                        <ul class="submenu">
                            <li class="">
                                <a href="adminCarListController">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Car Category
                                </a>
                                <b class="arrow"></b>
                            </li>                                                       
                        </ul>
                        <ul class="submenu">
                            <li class="">
                                <a href="adminCarAddController">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Add New Car
                                </a>
                                <b class="arrow"></b>
                            </li>                                                       
                        </ul>                       
                    </li>


                    <li class="">
                        <a href="#" class="dropdown-toggle">
                            <i class="menu-icon fa fa-list" aria-hidden="true"></i>
                            <span class="menu-text"> Car Booked </span>
                            <b class="arrow fa fa-angle-down"></b>
                        </a>
                        <b class="arrow"></b>
                        <ul class="submenu">
                            <li class="">
                                <a href="adminCarBookedDisplayController">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Car Order List 
                                </a>
                                <b class="arrow"></b>
                            </li>

                            <li class="">
                                <a href="AdminCar_CarReport_Controller?action=reportPageCalling">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Car Report 
                                </a>
                                <b class="arrow"></b>
                            </li>
                        </ul>                       
                    </li>


                    <li class="">
                        <a href="#" class="dropdown-toggle">
                            <i class="menu-icon fa fa-calendar" aria-hidden="true"></i>
                            <span class="menu-text"> Promotion </span>
                            <b class="arrow fa fa-angle-down"></b>
                        </a>
                        <b class="arrow"></b>
                        <ul class="submenu">
                            <li class="">
                                <a href="adminPromotionDisplayController">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Promotion List
                                </a>
                                <b class="arrow"></b>
                            </li>
                            <li class="">
                                <a href="adminPromotionAddController">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Create New Promotion
                                </a>
                                <b class="arrow"></b>
                            </li> 
                        </ul>                       
                    </li>
                </ul><!-- END LEFT MENU -->
                <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
                    <i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
                </div>
            </div>
            <div class="main-content">
                <div class="main-content-inner">
                    <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                        <ul class="breadcrumb">
                            <li>
                                <i class="ace-icon fa fa-home home-icon"></i>
                                <a href="#">Home</a>
                            </li>
                            <li class="active">Tour Packages</li>
                            <li class="active">Tour Update</li>
                        </ul><!-- /.breadcrumb -->
                    </div>	
                    <!------------------------------------------------ PAGE CONTENT BEGINS ------------------------------------------->
                    <div style="width: 1025px; margin-left: 70px;">
                        <center>
                            <h2 style="color: #00BE67">Edit Tour Package</h2>
                            <div style="margin-left: 800px;">
                                <form action="AdminTour_TourInsert_Controller" method="post">
                                    <input type="hidden" name="txttourid" value="${requestScope.tour.tourID}"/>
                                    <button style=" width: 150px; font-size: 14px;" name="action" value="btnCreateScheduleAfter" type="submit" class="btn-info">
                                        <i class="fa fa-pencil-square-o"> Create Schedule</i>
                                    </button>
                                </form> 
                            </div>
                        </center>    
                        <div style="margin-top: 40px;">

                            <form action="AdminTour_Tour_Update_Controller" method="post" name="formEditTourPackage" onsubmit="return validateForm()">
                                <input type="hidden" name="txtTourID_Update" value="${requestScope.tour.tourID}"/>
                                <input type="hidden" name="txtDuration_Update" value="${requestScope.tour.duration}"/>
                                <input type="hidden" id="stringOfDepartureDateAlreadyGenerated" name="stringOfDepartureDateAlreadyGenerated" value="${requestScope.stringOfDepartureDateAlreadyGenerated}"/>
                                <span id="titleError" style="color: red; margin-left: 180px;"></span>
                                <table class="table table-striped table-hover" style="width: 1000px;">
                                    <tr>
                                        <td>
                                            <label style="width: 150px;">Tour Title:</label>&nbsp; 
                                        </td>
                                        <td colspan="3">
                                            <input style="width: 550px;" name="txtTourTitle_Update" id="txtTourTitle_Update" type="text" value="${requestScope.tour.tourTitle}"/> 
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label style="width: 150px;">Tour Category:</label>&nbsp;
                                        </td>
                                        <td>
                                            <input style="width: 150px;" name="txtTourCategoryName_Update" value="${requestScope.tour.tourCategoryID.tourCategoryName}" type="text" readonly="true"/>
                                        </td>
                                        <td>
                                            <label style="width: 150px;">Heading To:</label>&nbsp;
                                        </td>
                                        <td>
                                            <select name="txtHeadingTo_Update" id="txtHeadingTo_Update" style="width: 150px; text-align: center;">
                                                <c:forEach items="${requestScope.destinationArray}" var="des">
                                                    <option value="${des}" ${des == headingTo ? 'selected="selected"' : ''}>
                                                        ${des}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label style="width: 150px;">Departure:</label>&nbsp; 
                                        </td>
                                        <td>
                                            <span id="destinationError" style="color: red;"></span>
                                            <select style=" width: 150px;" name="txtDeparturePoint_Update" id="txtDeparturePoint_Update">
                                                <c:forEach items="${requestScope.departureList}" var="des">
                                                    <option value="${des}" ${des == departure ? 'selected="selected"' : ''}>${des}</option>
                                                </c:forEach>
                                            </select>
                                            <span id="departurePointError" style=" color: red;"></span>
                                        </td>
                                        <td>
                                            <label style="width: 150px;">Group Tour Price:</label>&nbsp; 
                                        </td>
                                        <td>
                                            <input style=" width: 150px;" name="txtEvenTourPrice_Update" id="txtEvenTourPrice_Update" type="number" min="50" max="2000"  value="${requestScope.tour.evenTourPrice}"/> 
                                            <span id="groupPriceError" style="color: red; width: 200px;"></span>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <label style="width: 150px;">Transportation:</label>&nbsp;
                                        </td>
                                        <td id="tdCbx">
                                            <span id="transportationError" style="color: red;"></span><br/>
                                            <input type="hidden" id="txtTransportation_Update" value="${requestScope.tour.transportation}"/>
                                        </td>
                                        <td>
                                            <label style="width: 150px;">Odd Tour Price:</label>&nbsp;
                                        </td>
                                        <td>
                                            <input style="width: 150px;" id="txtOddTourPrice_Update" name="txtOddTourPrice_Update" type="number"  min="51" max="2000" value="${requestScope.tour.oddTourPrice}"/> 
                                            <span id="subPriceError" style="color: red; width: 200px;"></span>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <label style="width: 150px;">Hotel Rank:</label>&nbsp;

                                        </td>
                                        <td>
                                            <input type="radio" name="hotel" value="2"
                                                   <c:if test="${requestScope.tour.hotelRank =='2'}">checked</c:if> 
                                                       /> 2 Sao &nbsp;
                                                   <input type="radio" name="hotel" value="3"
                                                   <c:if test="${requestScope.tour.hotelRank =='3'}">checked</c:if> 
                                                       /> 3 Sao &nbsp;
                                                   <input type="radio" name="hotel" value="4"
                                                   <c:if test="${requestScope.tour.hotelRank =='4'}">checked</c:if> 
                                                       /> 4 Sao &nbsp;
                                            </td>
                                            <td>
                                                <label style="width: 150px;">Available Ticket:</label> 
                                            </td>
                                            <td>
                                                <input style="width: 150px; text-align: center;" name="txtTickets_Update" type="number" min="1" max="100" value="${requestScope.tour.tickets}"/> 
                                            <span id="availableTicketError" style="color: red; width: 200px;"></span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="width: 150px;">
                                            <label  style="width: 150px;">Departure Dates:</label>&nbsp;
                                        </td>
                                        <td style="width: 320px;" colspan="2">
                                            <label style="color: red;" id="departureDateDeleteError"></label>
                                            <input id="txtTourDepartureDays_Update" name="txtTourDepartureDays_Update" type="hidden" value="${requestScope.tour.depatureDay}"/>
                                            <div id="choosenDates" style="overflow: scroll;
                                                 width: 400px; height: 100px; border: 1px #4f8ab4 solid;"></div>
                                        </td>
                                        <td>
                                            <input style="width: 150px;" type="text" id="datepicker" placeholder="Click To Select A Day"/>
                                            <button style="margin-left: 10px;" class="btn-app" id="btnUpdateDepartureDays" type="button"><i class="fa fa-plus-circle"></i></button><br/><br/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <!--Image Upload-->
                                            <div class="file-upload">
                                                <button class="file-upload-btn" type="button" onclick="$('.file-upload-input').trigger('click')">
                                                    Change Representative Image
                                                </button>
                                            </div>
                                        </td>

                                        <td>
                                            <div class="file-upload-content">
                                                <img class="file-upload-image" src="assets/images/${requestScope.tour.image}" alt="your image" />
                                            </div>
                                        </td>
                                        <td>
                                            <div class="image-upload-wrap">
                                                <input class="file-upload-input" name="txtImage" src="${requestScope.tour.image}" type='file' onchange="readURL(this);" accept="image/*" />
                                            </div>
                                        </td>
                                    </tr>
                                    <link rel="stylesheet" href="assets/css/style_Image_EditTourPackage.css">
                                    <!--<script class="jsbin" src="assets/js/jquery.min.js"></script>-->
                                    <script src="assets/js/index_Image_EditTourPackage.js"></script>
                                </table>       

                                <div style="margin-left: 400px; margin-top: 50px;">
                                    <button style="width: 100px; font-size: 14px;" type="submit" name="action" class="btn-success" value="btnDone" onclick="return isValid();">Done</button>
                                    <button style="margin-left: 70px; width: 100px; font-size: 14px;" type="submit" name="action" value="btnReset" class="btn-default">
                                        <i class="fa fa-history"> Reset</i>
                                    </button>
                                </div>
                            </form>             
                        </div>
                    </div>

                    <!------------------------------------------------ PAGE CONTENT ENDS ---------------------------------------------->
                </div>
            </div>

            <div class="footer">
                <div class="footer-inner">
                    <div class="footer-content">
                        <span class="bigger-120"><span class="blue bolder">Travel </span>Application &copy; 2013-2014</span>
                        &nbsp; &nbsp;
                        <span class="action-buttons">
                            <a href="#"><i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i></a>
                            <a href="#"><i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i></a>
                            <a href="#"><i class="ace-icon fa fa-rss-square orange bigger-150"></i></a>
                        </span>
                    </div>
                </div>
            </div>
        </div>
    </body>  
</html>
