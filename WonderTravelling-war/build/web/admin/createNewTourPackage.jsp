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
                var destination = document.getElementById('selectDestination_add');
                var destinationVal = destination.options[destination.selectedIndex].value;
                var departure = document.getElementById('txtDeparturePoint_Insert');
                var departureVal = departure.options[departure.selectedIndex].value;

                var cbBus = document.getElementById('cbxBus').checked;
                var cbAirPlane = document.getElementById('cbxAirPlane').checked;
                var groupPrice = document.formCreateTourPackage.txtEvenTourPrice_Insert.value;
                var subPrice = document.formCreateTourPackage.txtOddTourPrice_Insert.value;
                var groupPriceInt = parseInt(groupPrice);
                var subPriceInt = parseInt(subPrice);

                var ticket = document.formCreateTourPackage.txtTickets_Insert.value;
                var ticketInt = parseInt(ticket);

                var tourTitle = document.formCreateTourPackage.txtTourTitle_Insert.value;
                var departureDates = document.formCreateTourPackage.txtTourDepartureDays_Insert.value;
                var image = document.formCreateTourPackage.txtImage.value;

                var status = false;
                //var alphaExp = /[a-zA-Z0-9.,-]/;
                var alphaExp = /^(?=.*[a-zA-Z])(?=.*[0-9])/;

                //Fill Number From Entered Title
                var titleArray = new Array("");
                titleArray = tourTitle.split(' ');
                var check = 0;
                var titleArrayMajor = new Array();
                $.each(titleArray, function(index, item) {
                    if (isNaN(item) === false) {
                        titleArrayMajor.push(item);
                    }
                });

                $.each(titleArrayMajor, function(index, item) {
                    //alert(item);
                    if (parseInt(item) > 10) {
                        check++;
                    }
                });

                if (destinationVal === departureVal) {
                    document.getElementById('destinationError').innerHTML
                            = "<img src='assets/images/unchecked.gif'/> Destination And Departure Can't be the Same!";
                    document.getElementById('selectDestination_add').focus();
                    status = false;
                    return false;
                } else {
                    document.getElementById('destinationError').innerHTML
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

                        if (groupPrice.replace(/^\s+/g, '').length === 0) {
                            document.getElementById('groupPriceError').innerHTML
                                    = "<img src='assets/images/unchecked.gif'/> Please Enter Group Tour Price !";
                            document.getElementById('txtEvenTourPrice_Insert').focus();
                            status = false;
                            return false;
                        } else if (groupPriceInt > 2000 || groupPriceInt < 50) {
                            document.getElementById('groupPriceError').innerHTML
                                    = "<img src='assets/images/unchecked.gif'/> Group Tour Price Must Be Between 50 - 2000 !";
                            document.getElementById('txtEvenTourPrice_Insert').focus();
                            status = false;
                            return false;
                        } else {
                            document.getElementById('groupPriceError').innerHTML
                                    = "<img src='assets/images/checked.gif'/>";

                            if (subPrice.replace(/^\s+/g, '').length == 0) {
                                document.getElementById('subPriceError').innerHTML
                                        = "<img src='assets/images/unchecked.gif'/> Please Enter Sub Tour Price !";
                                document.getElementById('txtOddTourPrice_Insert').focus();
                                status = false;
                                return false;
                            } else if (subPriceInt > 2000 || subPriceInt < 51) {
                                document.getElementById('subPriceError').innerHTML
                                        = "<img src='assets/images/unchecked.gif'/> Sub Tour Price Must Be Between 51 - 2000 !";
                                document.getElementById('txtOddTourPrice_Insert').focus();
                                status = false;
                                return false;
                            } else if (subPriceInt <= groupPriceInt) {
                                document.getElementById('subPriceError').innerHTML
                                        = "<img src='assets/images/unchecked.gif'/> Sub Tour Price Must Be Greater Than Group Tour Price !";
                                document.getElementById('txtOddTourPrice_Insert').focus();
                                status = false;
                                return false;
                            } else {
                                document.getElementById('subPriceError').innerHTML
                                        = "<img src='assets/images/checked.gif'/>";

                                if (tourTitle.replace(/^\s+/g, '').length == 0) {
                                    document.getElementById('titleError').innerHTML
                                            = "<img src='assets/images/unchecked.gif'/> Please Enter Tour Title !";
                                    document.getElementById('txtTourTitle_Insert').focus();
                                    status = false;
                                    return false;
                                } else if (tourTitle.replace(/^\s+/g, '').length < 5 || tourTitle.replace(/^\s+/g, '').length > 60) {
                                    document.getElementById('titleError').innerHTML
                                            = "<img src='assets/images/unchecked.gif'/> Tour Title Must Be Between 5 - 60 !";
                                    document.getElementById('txtTourTitle_Insert').focus();
                                    status = false;
                                    return false;
                                } else if (!tourTitle.match(alphaExp)) {
                                    document.getElementById('titleError').innerHTML
                                            = "<img src='assets/images/unchecked.gif'/> Tour Title Invalid (Must Be Included Both Letters And Numerics) !";
                                    document.getElementById('txtTourTitle_Insert').focus();
                                    status = false;
                                    return false;
                                } else if (check > 0) {
                                    document.getElementById('titleError').innerHTML
                                            = "<img src='assets/images/unchecked.gif'/> The Numbers In Title Cannot Greater Than 10 !!!";
                                    document.getElementById('txtTourTitle_Insert').focus();
                                    status = false;
                                    return false;
                                } else {
                                    document.getElementById('titleError').innerHTML
                                            = "<img src='assets/images/checked.gif'/>";

                                    if (departureDates.replace(/^\s+/g, '').length === 0) {
                                        document.getElementById('departuredateError').innerHTML
                                                = "<img src='assets/images/unchecked.gif'/> Select Departure Date Please !";
                                        document.getElementById('datepicker').focus();
                                        status = false;
                                        return false;
                                    } else {
                                        document.getElementById('departuredateError').innerHTML
                                                = "<img src='assets/images/checked.gif'/>";

                                        if (image.replace(/^\s+/g, '').length === 0) {
                                            document.getElementById('imageError').innerHTML
                                                    = "<img src='assets/images/unchecked.gif'/> Select Image Please !";
                                            document.getElementById('txtImage').focus();
                                            status = false;
                                            return false;
                                        } else {
                                            document.getElementById('imageError').innerHTML
                                                    = "<img src='assets/images/checked.gif'/>";

                                            if (ticket.replace(/^\s+/g, '').length === 0) {
                                                document.getElementById('ticketError').innerHTML
                                                        = "<img src='assets/images/unchecked.gif'/> Ticket Is Required !";
                                                document.getElementById('txtTickets_Insert').focus();
                                                status = false;
                                                return false;
                                            } else if (ticketInt < 20 || ticketInt > 100) {
                                                document.getElementById('ticketError').innerHTML
                                                        = "<img src='assets/images/unchecked.gif'/> Ticket Must Be Between 20-100 !";
                                                document.getElementById('txtTickets_Insert').focus();
                                                status = false;
                                                return false;
                                            } else {
                                                document.getElementById('ticketError').innerHTML
                                                        = "<img src='assets/images/checked.gif'/>";
                                                status = true;
                                            }
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
                    return confirm('Confirm To Create ?');
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
                var array = new Array("");
                var departureDaysString = "";
                $('#txtHeadingTo').val($('#selectDestination_add option:selected').text());
                //create event change for tourcategory and destination selectBox
                $('#selectTourCategory_Add').change(changgingDestination);

                function changgingDestination() {
                    var str = $('#selectTourCategory_Add option:selected').val();
                    var destinationArray = str.split(", ");
                    $('#selectDestination_add').empty();
                    $.each(destinationArray, function(index, item) {
                        $('#selectDestination_add').append("<option value=" + item + ">" + item + "</option>")
                    });
                    $('#txtHeadingTo').empty();
                    $('#txtHeadingTo').val($('#selectDestination_add option:selected').text());
                }
                ;


                $('#selectDestination_add').change(function() {
                    $('#txtHeadingTo').val($('#selectDestination_add option:selected').text());
                    //alert($('#selectDestination_add option:selected').text());
                });

                $("#btnCreateDate_Add").click(function() {
                    //Add all dates in div tag into an array named array
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
                        //alert(departureDaysString);
                    } else {
                        alert('Date ' + $("input#datepicker").val().toString() + ' Is Existed !');
                        return false;
                    }
                });

                //remove b tag when click on 'x' tag and remove it value in array at the same time
                $(document).on("click", "a.remove", function() {
                    $(this).parent().remove();
                    var it = ($(this).parent().html()).toString();
                    var itafter = it.substring(0, 10);
                    array.splice($.inArray(itafter, array), 1);
                    departureDaysRefresh();
                    alert(departureDaysString);
                });

                function departureDaysRefresh() {
                    departureDaysString = "";
                    if ((array.length) > 0) {
                        $.each(array, function(index, item) {
                            departureDaysString += item + ", ";
                        });
                        $('#txtTourDepartureDays_Insert').val(departureDaysString);
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
                            <li class="active">Tour Create</li>
                        </ul><!-- /.breadcrumb -->
                    </div>	
                    <!------------------------------------------------ PAGE CONTENT BEGINS ------------------------------------------->
                    <div style="width: 1010px; margin-top: 10px; margin-left: 70px;">
                        <center>    
                            <div style="width: 1010px;">
                                <h2 style=" color: #00BE67">Create Tour Package<font color="red">${requestScope.error}</font></h2>
                            </div>
                        </center>
                        <div style="margin-top: 40px; width: 1010px;">
                            <form action="AdminTour_TourInsert_Controller" method="post" name="formCreateTourPackage" onsubmit="return validateForm()">
                                <table class="table table-striped table-hover" style="width: 900px;">
                                    <tr>
                                        <td style="width: 150px;">
                                            <label style="width: 150px;">Tour Category:</label>&nbsp;
                                        </td>
                                        <td style=" width: 150px;">
                                            <select id="selectTourCategory_Add" style="width: 150px; text-align: center;"
                                                    name="txtTourCategoryDestination">
                                                <c:forEach items="${requestScope.TourCategoryList}" var="tourCategory">
                                                    <option value="${tourCategory.destination}">${tourCategory.tourCategoryName}</option>
                                                </c:forEach>
                                            </select>
                                        </td>

                                        <td style=" width: 150px;">
                                            <label style="width: 110px; margin-left: 100px;">Destination:</label>&nbsp;
                                        </td>
                                        <td style="width: 150px;">
                                            <!--SELECT ASSIGN DESTINATION FROM CHANGE EVENT OF TOUR CATEGORY SELECT BOX-->
                                            <select name="selectDestination_add" id="selectDestination_add" style="width: 150px; text-align: center;">
                                                <c:forEach items="${requestScope.listDestinationDefault}" var="des">
                                                    <option value="${des}">${des}</option>
                                                </c:forEach>
                                            </select>
                                            <label id="destinationError" style="color: red; width: 240px;"></label>
                                            <br/><br/>
                                            <!--Holding Heading To When Select Box selectDestination_add change-->
                                            <input type="hidden" name="txtHeadingTo" id="txtHeadingTo"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label style="width: 150px;">Departure:</label>&nbsp;
                                        </td>
                                        <td>

                                            <select style=" width: 150px;" name="txtDeparturePoint_Insert" id="txtDeparturePoint_Insert">
                                                <option value="An Giang">An Giang</option>
                                                <option value="Vung Tau">Vung Tau</option>
                                                <option value="Bac Giang">Bac Giang</option>
                                                <option value="Bac Kan">Bac Kan</option>
                                                <option value="Bac Lieu">Bac Lieu</option>
                                                <option value="Bac Ninh">Bac Ninh</option>
                                                <option value="Ben Tre">Ben Tre</option>
                                                <option value="Binh Dinh">Binh Dinh</option>
                                                <option value="Binh Duong">Binh Duong</option>
                                                <option value="Binh Phuoc">Binh Phuoc</option>
                                                <option value="Binh Thuan">Binh Thuan</option>
                                                <option value="Can Tho">Can Tho</option>
                                                <option value="Ca Mau">Ca Mau</option>
                                                <option value="Cao Bang">Cao Bang</option>
                                                <option value="Dak Lak">Dak Lak</option>
                                                <option value="Dak Nong">Dak Nong</option>
                                                <option value="Da Nang">Da Nang</option>
                                                <option value="Dien Bien">Dien Bien</option>
                                                <option value="Dong Nai">Dong Nai</option>
                                                <option value="Dong Thap">Dong Thap</option>
                                                <option value="Gia Lai">Gia Lai</option>
                                                <option value="Ha Giang">Ha Giang</option>
                                                <option value="Ha Nam">Ha Nam</option>
                                                <option value="Ha Tinh">Ha Tinh</option>
                                                <option value="Hai Phong">Hai Phong</option>
                                                <option value="Ha Noi">Ha Noi</option>
                                                <option value="Hai Duong">Hai Duong</option>
                                                <option value="Hau Giang">Hau Giang</option>
                                                <option value="Hoa Binh">Hoa Binh</option>
                                                <option value="Hung Yen">Hung Yen</option>
                                                <option value="Khanh Hoa">Khanh Hoa</option>
                                                <option value="Kien Giang">Kien Giang</option>
                                                <option value="Phu Quoc">Phu Quoc</option>
                                                <option value="Kon Tum">Kon Tum</option>
                                                <option value="Lai Chau">Lai Chau</option>
                                                <option value="Lam Dong">Lam Dong</option>
                                                <option value="Da Lat">Da Lat</option>
                                                <option value="Lang Son">Lang Son</option>
                                                <option value="Lao Cai">Lao Cai</option>
                                                <option value="Long An">Long An</option>
                                                <option value="Nam Dinh">Nam Dinh</option>
                                                <option value="Nghe An">Nghe An</option>
                                                <option value="Ninh Binh">Ninh Binh</option>
                                                <option value="Ninh Thuan">Ninh Thuan</option>
                                                <option value="Phu Tho">Phu Tho</option>
                                                <option value="Quang Binh">Quang Binh</option>
                                                <option value="Quang Nam">Quang Nam</option>
                                                <option value="Quang Ngai">Quang Ngai</option>
                                                <option value="Quang Ninh">Quang Ninh</option>
                                                <option value="Quang Tri">Quang Tri</option>
                                                <option value="Soc Trang">Soc Trang</option>
                                                <option value="Son La">Son La</option>
                                                <option value="Ho Chi Minh City">Ho Chi Minh City</option>
                                                <option value="Tay Ninh">Tay Ninh</option>
                                                <option value="Thai Binh">Thai Binh</option>
                                                <option value="Thai Nguyen">Thai Nguyen</option>
                                                <option value="Thanh Hoa">Thanh Hoa</option>
                                                <option value="Thua Thien Hue">Thua Thien Hue</option>
                                                <option value="Tien Giang">Tien Giang</option>
                                                <option value="Tra Vinh">Tra Vinh</option>
                                                <option value="Tuyen Quang">Tuyen Quang</option>
                                                <option value="Vinh Long">Vinh Long</option>
                                                <option value="Vinh Phuc">Vinh Phuc</option>
                                                <option value="Yen Bai">Yen Bai</option>
                                                <option value="Phu Yen">Phu Yen</option>
                                                <option value="Pleiku">Pleiku</option>
                                                <option value="Buon Me">Buon Me</option>
                                            </select>
                                            <span id="departurePointError" style=" color: red;"></span>
                                        </td>

                                        <td>
                                            <label style="width: 100px; margin-left: 100px;">Transportation:</label>&nbsp;
                                        </td>
                                        <td colspan="2">
                                            <input type="checkbox" id="cbxBus" name="cbxBus" value="2" style="margin-left: 10px; width: 20px; display: inline;"/> Bus
                                            <input type="checkbox" id="cbxAirPlane" name="cbxAirPlane" value="1" style="margin-left: 30px; width: 20px;" /> AirPlane
                                            <span id="transportationError" style="color: red;"></span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label style="width: 150px;">Group Tour Price:</label>&nbsp;
                                        </td>
                                        <td>
                                            <input id="txtEvenTourPrice_Insert" style="width: 150px; text-align: center;" name="txtEvenTourPrice_Insert" type="number" value="50" min="50" max="2000"/>
                                            <span id="groupPriceError" style="color: red;"></span>
                                        </td>
                                        <td>
                                            <label style="width: 110px; margin-left: 100px; text-align: left">Sub Tour Price:</label>

                                        </td>
                                        <td>
                                            <input id="txtOddTourPrice_Insert" style="width: 150px; text-align: center;" name="txtOddTourPrice_Insert" type="number" value="51" min="51" max="2000" class="form-control"/>
                                            <span id="subPriceError" style="color: red;"></span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label style="width: 150px;">Available Ticket:</label>
                                        </td>
                                        <td>
                                            <input style=" width: 150px; text-align: center; margin-left: 3px;" name="txtTickets_Insert" id="txtTickets_Insert" type="number" value="1" min="1" max="100" class="form-control"/>
                                            <span id="ticketError" style="color: red; width: 200px;"></span>
                                        </td>
                                        <td>
                                            <label style="width: 150px; margin-left: 100px;">Hotel Rank:</label>&nbsp;
                                        </td>
                                        <td>
                                            <input type="radio" name="hotel" value="2" checked="true"/> 2 Stars  &nbsp;
                                            <input type="radio" name="hotel" value="3"/> 3 Stars  &nbsp;
                                            <input type="radio" name="hotel" value="4"/> 4 Stars  &nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label style="width: 150px;">Tour Title:</label>&nbsp;
                                        </td>
                                        <td colspan="3">
                                            <textarea style=" width: 550px; height: 40px; resize: none;" id="txtTourTitle_Insert" name="txtTourTitle_Insert"></textarea>
                                            <label id="titleError" style="color: red; width: 500px;"></label>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label  style="width: 150px;">Departure Dates:</label>&nbsp;
                                        </td>
                                        <td colspan="2">
                                            <input style="width: 150px" id="txtTourDepartureDays_Insert" name="txtTourDepartureDays_Insert" type="hidden"/>
                                            <input type="text" name="datepicker" id="datepicker" style="width: 150px;">&nbsp;&nbsp;&nbsp;
                                            <button id="btnCreateDate_Add" type="button"><i class="fa fa-plus-circle"></i></button><br/>
                                            <span id="departuredateError" style="color: red;"></span>
                                        </td>
                                        <td style="text-align: left;">
                                            <div style=" margin-top: 10px; width: 360px; height: auto;" id="choosenDates"></div>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <!--Image Upload-->
                                            <div class="file-upload">
                                                <button class="file-upload-btn" type="button" onclick="$('.file-upload-input').trigger('click')">
                                                    Add Representative Image
                                                </button>
                                            </div>
                                        </td>
                                        <td>
                                            <input style="width: 150px;" type="text" name="txtImage" id="txtImage" readonly="true"/><br/>
                                            <span id="imageError" style="color: red;"></span>
                                        </td>
                                        <td>
                                            <div class="file-upload-content">
                                                <img class="file-upload-image" src="#" alt="your image" />

                                            </div>
                                        </td>
                                        <td>
                                            <div class="image-upload-wrap">
                                                <input class="file-upload-input" id="txtImage_Insert" name="txtImage_Insert" type='file' onchange="readURL(this);" accept="image/*" />
                                            </div>
                                        </td>
                                    </tr>
                                    <link rel="stylesheet" href="assets/css/style_Image_CreateNewTourPackage.css">
                                    <!--<script class="jsbin" src="assets/js/jquery.min.js"></script>-->
                                    <script src="assets/js/index_Image_CreateNewTourPackage.js"></script>
                                </table>

                                <div style="margin-bottom: 20px; margin-top: 50px;">
                                    <center>
                                        <button style="margin-left: 70px; font-size: 14px;" id="createTour" type="submit" name="action" value="btnCreateSchedule" class="btn-info" onclick="return isValid()">
                                            <i class="fa fa-pencil-square-o"> Create Schedule</i>
                                        </button>
                                    </center>
                                </div>                                                 

                            </form>

                            <form action="AdminTour_TourInsert_Controller" method="post">
                                <button class="btn-danger" type="submit" name="action" value="btnCancelTourCreate" style="width: 100px; margin-left: 15px; font-size: 14px;">Cancel</button>
                                <button type="submit" name="action" value="btnResetCreateTour" style="margin-left: 70px; width: 100px; font-size: 14px; height: 25px;">
                                    <i class="fa fa-history"> Reset</i>
                                </button>
                            </form>
                        </div>

                    </div>

                    <!------------------------------------------------ PAGE CONTENT ENDS ---------------------------------------------->
                </div>
            </div>

            <div class="footer">
                <div class="footer-inner">
                    <div class="footer-content">
                        <span class="bigger-120"><span class="blue bolder">Travel </span>Application &copy; 2017-2018</span>
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
