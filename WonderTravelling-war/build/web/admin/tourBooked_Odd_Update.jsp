<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <!-- Date Format-->
        <script src="assets/js/jquery-dateFormat.min.js"></script> 

        <script>
            function validateFormAddCus() {
                var cusName = document.formAddCus.txtCusNameAdd.value;
                var alphaExp = /[a-zA-Z.,-]/;
                var status = false;

                if (cusName.replace(/^\s+/g, '').length === 0) {
                    document.getElementById('cusNameAddError').innerHTML
                            = "<img src='assets/images/unchecked.gif'/> Customer Name Is Required !";
                    document.getElementById('txtCusNameAdd').focus();
                    status = false;
                    return false;
                } else if (!isNaN(cusName)) {
                    document.getElementById('cusNameAddError').innerHTML
                            = "<img src='assets/images/unchecked.gif'/> Only Letters Please !";
                    document.getElementById('txtCusNameAdd').focus();
                    status = false;
                    return false;
                } else if (cusName.replace(/^\s+/g, '').length < 5 || cusName.replace(/^\s+/g, '').length > 60) {
                    document.getElementById('cusNameAddError').innerHTML
                            = "<img src='assets/images/unchecked.gif'/> Customer Name Must Be Between 5 - 60 !";
                    document.getElementById('txtCusNameAdd').focus();
                    status = false;
                    return false;
                } else if (!cusName.match(alphaExp)) {
                    document.getElementById('cusNameAddError').innerHTML
                            = "<img src='assets/images/unchecked.gif'/> Customer Name Invalid !";
                    document.getElementById('txtCusNameAdd').focus();
                    status = false;
                    return false;
                } else {
                    document.getElementById('cusNameAddError').innerHTML
                            = "<img src='assets/images/checked.gif'/>";
                    $('#DOBError').text('');
                    
                    var day = parseInt($('#txtDOB').datepicker('getDate').getDate());
                    var month = parseInt($('#txtDOB').datepicker('getDate').getMonth() + 1);
                    var year = parseInt($('#txtDOB').datepicker('getDate').getFullYear());

                    var currentDate = new Date();
                    var currentYear = parseInt($.format.date(currentDate, 'yyyy').toString());
                    var currentMonth = parseInt($.format.date(currentDate, 'MM').toString());
                    var currentDay = parseInt($.format.date(currentDate, 'dd').toString());

                    var valid1 = $('#txtDOB').val().toString().substring(2, 3);
                    var valid2 = $('#txtDOB').val().toString().substring(5, 6);
                    var validNum1 = parseInt($('#txtDOB').val().toString().substring(0, 2));
                    var validNum2 = parseInt($('#txtDOB').val().toString().substring(3, 5));
                    var validNum3 = parseInt($('#txtDOB').val().toString().substring(6, 10));

                    if (valid1 !== '-' || valid2 !== '-' || validNum1 <= 0 || validNum2 <= 0 || validNum3 <= 0 || $('#txtDOB').val().toString().length < 10) {
                        $('#DOBError').text('Day Of Birth Invalid, Please Input "DD-MM-YYYY"');
                        return false;
                        status = false;
                    } else if (year > currentYear) {
                        $('#DOBError').text('Day Of Birth Invalid, Cannot Greater Than Current Date');
                        return false;
                        status = false;
                    } else if (year === currentYear && month > currentMonth) {
                        $('#DOBError').text('Day Of Birth Invalid, Cannot Greater Than Current Date');
                        return false;
                        status = false;
                    } else if (year === currentYear && month === currentMonth && day >= currentDay) {

                        $('#DOBError').text('Day Of Birth Invalid, Cannot Greater Than Current Date');
                        return false;
                        status = false;
                    } else {

                        status = true;
                    }
                }

                return status;
            }

            function isValidFormAddCus() {
                var isOk = validateFormAddCus();
                if (isOk === true) {
                    return confirm('Sure You Want To Add/Edit This Customer ?');
                }
            }
        </script>

        <script type="text/javascript">
            $(function() {
                $("#txtDOB").datepicker({
                    //format and contraint datepicker
                    dateFormat: 'dd-mm-yy', showButtonPanel: true
                });
            });
        </script>

        <script>
            function getRepresentativeiD() {
                alert($('#passingRepreSentativeID').val());
            }
        </script>

        <script>
            function showRepresentative_row(no)
            {
                $('#isOutOfTicket').val('');
                $('#isOutOfKidAndAdult').val('');

                var id = $("#btn" + no).val();
                var fullname = $("#representativeFullname_row" + no).val();
                var phone = $("#representativePhone_row" + no).val();
                var email = $("#representativeEmail_row" + no).val();

                $('#lbID').text(id);
                $('#lbName').text(fullname);
                $('#lbPhone').text(phone);
                $('#lbEmail').text(email);
                $('#passingRepreSentativeID').val(id);

                $("#myModal").modal('show');
            }
        </script>

        <script>
            $(document).ready(function() {
                var ticket = $('#ticket').val();
                var numOfAdultAndKid = $('#numOfKidAndAdult').val();
                var isOutOfTicket = $('#isOutOfTicket').val();
                var isOutOfKidAndAdultTourBookedSub = $('#isOutOfKidAndAdult').val();
                var isOutOfKidAndAdultTourBookedSub_Edit = $('#isOutOfKidAndAdult_Edit').val();
                var babyError = $('#babyError').val();

                if (isOutOfTicket === '1') {
                    $('#errorContent').empty();
                    $('#errorContent').html(
                            "<div class = 'modal-body'>"
                            + "<center>"
                            + "<h5 style = 'color: red;' > It Out Of Ticket ! </h5>"
                            + "<h5 style = 'color: red;' > Available Ticket: " + ticket + "- Number Of Adult And Kid: " + numOfAdultAndKid + "</h5>"
                            + "</center>"
                            + "</div>"
                            + "<div class = 'modal-footer'>"
                            + "<center>"
                            + "<button style = 'height: 35px; text-align: center; width: 100px;' type = 'button' data-dismiss = 'modal'> Close </button>"
                            + "</center>"
                            + "</div>"
                            );
                    $("#myModalError").modal('show');
                }

                if (isOutOfKidAndAdultTourBookedSub === '1') {
                    $('#errorContent').empty();
                    $('#errorContent').html(
                            "<div class = 'modal-body'>"
                            + "<center>"
                            + "<h5 style = 'color: red;' > Cannot Delete ! </h5>"
                            + "<h5 style = 'color: red;' > Each Sub Team Must Has One Of Adult At Least. </h5>"
                            + "</center>"
                            + "</div>"
                            + "<div class = 'modal-footer'>"
                            + "<center>"
                            + "<button style = 'height: 35px; text-align: center; width: 100px;' type = 'button' data-dismiss = 'modal'> Close </button>"
                            + "</center>"
                            + "</div>"
                            );
                    $("#myModalError").modal('show');
                }
                if (isOutOfKidAndAdultTourBookedSub_Edit === '1') {
                    $('#errorContent').empty();
                    $('#errorContent').html(
                            "<div class = 'modal-body'>"
                            + "<center>"
                            + "<h5 style = 'color: red;' > Cannot Edit ! </h5>"
                            + "<h5 style = 'color: red;' > Each Sub Team Must Has One Adult At Least. </h5>"
                            + "</center>"
                            + "</div>"
                            + "<div class = 'modal-footer'>"
                            + "<center>"
                            + "<button style = 'height: 35px; text-align: center; width: 100px;' type = 'button' data-dismiss = 'modal'> Close </button>"
                            + "</center>"
                            + "</div>"
                            );
                    $("#myModalError").modal('show');
                }

                if (babyError === '1') {
                    $('#errorContent').empty();
                    $('#errorContent').html(
                            "<div class = 'modal-body'>"
                            + "<center>"
                            + "<h5 style = 'color: red;' > Cannot Add ! </h5>"
                            + "<h5 style = 'color: red;' > Numer Of Baby Cannot Greater Than Its Number Of Adult (Sub Team). </h5>"
                            + "</center>"
                            + "</div>"
                            + "<div class = 'modal-footer'>"
                            + "<center>"
                            + "<button style = 'height: 35px; text-align: center; width: 100px;' type = 'button' data-dismiss = 'modal'> Close </button>"
                            + "</center>"
                            + "</div>"
                            );
                    $("#myModalError").modal('show');
                }
            });
        </script>

        <script type="text/javascript">
            $(document).ready(function() {
                $('#slDepartureDates').change(function() {
                    var item = $('#slDepartureDates option:selected').text();
                    $('#lbDepartureDate').text(item);
                });

            });
        </script>

        <script>
            function edit_row(no)
            {
                var fullname = $("#fullname_row" + no).html();
                var gender = $("#cusSex_row" + no).val();
                var cusDOB = $("#cusDOB_row" + no).val();

                var cusid = $("#cusid_row" + no).val();

                var representativeId = $("#representativeId_row" + no).val();

                $('select option[value=' + representativeId + ']').attr("selected", true);

                $('#txtRepresentiveCustomerId_EditCus').val(representativeId);
                $('#txtCusNameAdd').val(fullname);
                if (gender == 'true') {
                    $('#rdGenderMale').prop('checked', true);
                } else {
                    $('#rdGenderFemale').prop('checked', true);
                }
                $('#txtDOB').val($.format.date(cusDOB, 'dd-MM-yyyy'));

                $('#txtCusId_EditCus').val(cusid);

                $("#btnAddCus").val("btnEditCus");
                $("#btnAddCus").html("Edit");

            }
        </script>

        <script type="text/css">
            #TabPanel .nav-pills > li > a {
                border-radius: 4px 4px 0 0 ;
            }

            #TabPanel .tab-content {
                color : white;
                background-color: #428bca;
            }
        </script>

        <script type="text/css">
            .table-responsive {height:180px;}
        </script>

        <script type="text/javascript">
            $(document).ready(function() {

                $('#table_CusList').pageMe({pagerSelector: '#myPager', showPrevNext: true, hidePageNumbers: false, perPage: 5});

            });
        </script>

        <script type="text/javascript">
            $.fn.pageMe = function(opts) {
                var $this = this,
                        defaults = {
                            perPage: 5,
                            showPrevNext: false,
                            hidePageNumbers: false
                        },
                settings = $.extend(defaults, opts);

                var listElement = $this;
                var perPage = settings.perPage;
                var children = listElement.children();
                var pager = $('.pager');

                if (typeof settings.childSelector != "undefined") {
                    children = listElement.find(settings.childSelector);
                }

                if (typeof settings.pagerSelector != "undefined") {
                    pager = $(settings.pagerSelector);
                }

                var numItems = children.size();
                var numPages = Math.ceil(numItems / perPage);

                pager.data("curr", 0);

                if (settings.showPrevNext) {
                    $('<li><a href="#" class="prev_link">«</a></li>').appendTo(pager);
                }

                var curr = 0;
                while (numPages > curr && (settings.hidePageNumbers == false)) {
                    $('<li><a href="#" class="page_link">' + (curr + 1) + '</a></li>').appendTo(pager);
                    curr++;
                }

                if (settings.showPrevNext) {
                    $('<li><a href="#" class="next_link">»</a></li>').appendTo(pager);
                }

                pager.find('.page_link:first').addClass('active');
                pager.find('.prev_link').hide();
                if (numPages <= 1) {
                    pager.find('.next_link').hide();
                }
                pager.children().eq(1).addClass("active");

                children.hide();
                children.slice(0, perPage).show();

                pager.find('li .page_link').click(function() {
                    var clickedPage = $(this).html().valueOf() - 1;
                    goTo(clickedPage, perPage);
                    return false;
                });
                pager.find('li .prev_link').click(function() {
                    previous();
                    return false;
                });
                pager.find('li .next_link').click(function() {
                    next();
                    return false;
                });

                function previous() {
                    var goToPage = parseInt(pager.data("curr")) - 1;
                    goTo(goToPage);
                }

                function next() {
                    var goToPage = parseInt(pager.data("curr")) + 1;
                    goTo(goToPage);
                }

                function goTo(page) {
                    var startAt = page * perPage,
                            endOn = startAt + perPage;

                    children.css('display', 'none').slice(startAt, endOn).show();

                    if (page >= 1) {
                        pager.find('.prev_link').show();
                    }
                    else {
                        pager.find('.prev_link').hide();
                    }

                    if (page < (numPages - 1)) {
                        pager.find('.next_link').show();
                    }
                    else {
                        pager.find('.next_link').hide();
                    }

                    pager.data("curr", page);
                    pager.children().removeClass("active");
                    pager.children().eq(page + 1).addClass("active");

                }
            };
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
                            <li class="active">Tour Booked</li>
                            <li class="active">Tour Booked Update (Grafted)</li>
                        </ul><!-- /.breadcrumb -->
                    </div>	
                    <!------------------------------------------------ PAGE CONTENT BEGINS ------------------------------------------->
                    <div style="margin: 20px 60px; border-bottom: #222A2D double; width: 920">
                        <div style="margin: 0px 0px 60px 300px; color: #008000;">
                            <h2>${requestScope.tourTitle}</h2>
                        </div>
                        <input type="hidden" id="ticket" value="${requestScope.ticket}"/>
                        <input type="hidden" id="numOfKidAndAdult" value="${requestScope.numOfKidAndAdult}"/>
                        <input type="hidden" id="isOutOfTicket" value="${requestScope.isOutOfTicket}"/>
                        <input type="hidden" id="isOutOfKidAndAdult" value="${requestScope.isOutOfKidAndAdult}"/>
                        <input type="hidden" id="isOutOfKidAndAdult_Edit" value="${requestScope.isOutOfKidAndAdult_Edit}"/>
                        <input type="hidden" id="babyError" value="${requestScope.babyError}"/>
                        <form action="AdminTour_OddTourReserved_DetailEdit_Controller" method="post">
                            <input type="hidden" name="txtTourBookIDUpdate" value="${requestScope.tourBookedupdate.tourBookedID}"/>
                            <input type="hidden" name="txtCustomerIdUpdate" value="${requestScope.tourBookedupdate.customerID.customerID}"/>

                            <label style="width: 170px;">Tour Booked ID:</label>&nbsp;
                            <label style="width: 190px; height: 27px; text-align: center; border: 1px black solid; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; border-top-left-radius: 7px; border-top-right-radius: 7px;"
                                   >${requestScope.tourBookedupdate.tourBookedID}</label>

                            <label style="width: 200px; margin-left: 100px; text-align: center;">Status:</label>
                            <label id="lbStatus" style="width: 190px; height: 27px; text-align: center; border: 1px black solid; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; border-top-left-radius: 7px; border-top-right-radius: 7px;">
                                ${requestScope.st}
                            </label><br/><br/>       

                            <label style="width: 175px;">Number Of Kid:</label>
                            <label style="width: 190px; height: 27px; text-align: center; border: 1px black solid; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; border-top-left-radius: 7px; border-top-right-radius: 7px;">${requestScope.numOfKid}</label>
                            <input type="hidden" name="txtNumbOfKid" value="${requestScope.numOfKid}"/>

                            <label style="width: 200px; margin-left: 100px; text-align: center;">Number Of Baby:</label>
                            <label id="lbStatus" style="width: 190px; height: 27px; text-align: center; border: 1px black solid; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; border-top-left-radius: 7px; border-top-right-radius: 7px;">
                                ${requestScope.numOfBaby}
                            </label><br/><br/>
                            <input type="hidden" value="${requestScope.numOfBaby}"/>

                            <label style="width: 175px;">Number Of People:</label>
                            <label style="width: 190px; height: 27px; text-align: center; border: 1px black solid; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; border-top-left-radius: 7px; border-top-right-radius: 7px;">${requestScope.tourBookedupdate.numberOfPeople}</label>
                            <input type="hidden" name="txtNumbOfPeople" value="${requestScope.tourBookedupdate.numberOfPeople}"/>

                            <label style="width: 200px; margin-left: 100px; text-align: center;">Number Of Adult:</label>
                            <label id="lbStatus" style="width: 190px; height: 27px; text-align: center; border: 1px black solid; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; border-top-left-radius: 7px; border-top-right-radius: 7px;">
                                ${requestScope.tourBookedupdate.numberOfAdult}
                            </label><br/><br/>

                            <label style="width: 175px;">Individual Room:</label>
                            <label style="width: 190px; height: 27px; text-align: center; border: 1px black solid; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; border-top-left-radius: 7px; border-top-right-radius: 7px;">${requestScope.tourBookedupdate.individualRoom}</label>
                            <input type="hidden" name="txtIndividualRoom" value="${requestScope.tourBookedupdate.individualRoom}"/>

                            <label style="width: 200px; margin-left: 100px; text-align: center;">Available Ticket Remained:</label>
                            <label id="lbStatus" style="width: 190px; height: 27px; text-align: center; border: 1px black solid; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; border-top-left-radius: 7px; border-top-right-radius: 7px;">
                                ${requestScope.availableTicket}
                            </label><br/><br/>

                            <label style="width: 170px;">Change Departure Date:</label>&nbsp;
                            <select id="slDepartureDates" name="txtDepartureDateSelectBox" style="width: 190px; text-align: center;">
                                <c:forEach items="${requestScope.departureDatesArray}" var="date">
                                    <option value="${date}" ${date == departureDate ? 'selected="selected"' : ''}>
                                        ${date}
                                    </option>
                                </c:forEach>
                            </select>
                            <span style="color: red; font-weight: bold; margin-left: 5px;">(*)</span>

                            <label style="width: 193px; margin-left: 83px; text-align: center;">Departure Date:</label>
                            <label id="lbDepartureDate" style="width: 190px; height: 27px; text-align: center; border: 1px black solid; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; border-top-left-radius: 7px; border-top-right-radius: 7px;">${requestScope.departureDate}</label><br/><br/>

                            <div style="margin-left: 400px;">
                                <button class="btn-info" style="width: 100px; font-weight: bold; margin-bottom: 30px; margin-top: 20px; font-size: 16px;" type="submit" name="action" value="btnEditTourBooked"
                                        onclick="return confirm('Sure You Want To Change Information ?')">
                                    <i class="fa fa-edit"> Edit</i>
                                </button>
                            </div>
                        </form>
                    </div>

                    <div style="margin: 20px 60px; width: 920px;">
                        <div class="table-responsive">
                            <div style="margin-left: 360px; margin-top: 20px; margin-bottom: 40px;">
                                <h3 style="font-weight: bold; color: #00BE67;">Customer List</h3>
                            </div>

                            <!--Form Add Edit Customer-->
                            <form action="AdminTour_OddTourReserved_DetailEdit_Controller" method="post" name="formAddCus" onsubmit="return validateFormAddCus()">
                                <input type="hidden" name="txtTourBookID_AddCus" value="${requestScope.tourBookedupdate.tourBookedID}"/>
                                <input type="hidden" id="txtRepresentiveCustomerId_EditCus" name="txtRepresentiveCustomerId_EditCus"/>
                                <input type="hidden" id="txtCusId_EditCus" name="txtCusId_EditCus"/>

                                <label style="margin-right: 10px; margin-bottom: 5px; margin-left: 10px;">Representative Customer</label>
                                <select name="txtRepresentiveCustomerId_AddCus" style="margin-bottom: 5px;">
                                    <c:forEach items="${requestScope.listRepresentativeId}" var="representativeId">
                                        <option value="${representativeId}">${representativeId}</option>
                                    </c:forEach>
                                </select>

                                <input type="text" id="txtCusNameAdd" name="txtCusNameAdd" placeholder="Customer Name" style="margin-bottom: 5px; margin-left: 29px;"/>
                                <input style="margin-left: 29px;" type="radio" name="rdGender" id="rdGenderMale" value="true" checked="true"/> Male 
                                <input type="radio" name="rdGender" id="rdGenderFemale" value="false" style="margin-left: 15px;"/> Female 
                                <input style="margin-left: 29px;" type="text" name="txtDOB" id="txtDOB" placeholder="Date Of Birth"
                                       pattern="(0[1-9]|1[0-9]|2[0-9]|3[01]).(0[1-9]|1[012]).[0-9]{4}" required="true"/>
                                <button style=" font-size: 14px; margin-bottom: 5px; margin-left: 40px; width: 80px; height: 30px;" class="btn-info" type="submit" id="btnAddCus" name="action" value="${requestScope.btnAdd_Edit_Value}" onclick="return isValidFormAddCus()">
                                    <i class="fa fa-plus-circle"> ${requestScope.btnAdd_Edit_Text}</i>
                                </button>
                                <br/><label id="cusNameAddError" style="color: red; width: 200px; margin-left: 250px;"></label>
                                <label id="DOBError" style="color: red; width: 220px; margin-left: 150px;"></label>
                            </form>

                            <table class="table table-hover" style="margin-top: 7px;">
                                <thead>
                                <th style="width: 50px; text-align: center;">#</th>
                                <th style="width: 170px; text-align: center;">Full Name</th>
                                <th style="width: 170px; text-align: center;">Gender</th>
                                <th style="width: 170px; text-align: center;">Date Of Birth</th>
                                <th style="width: 170px; text-align: center;">Baby/Kid/Adult</th>
                                <th style="width: 150px; text-align: center;">Representative</th>
                                <th style="width: 70px; text-align: center;"></th>
                                </thead>

                                <tbody id="table_CusList">

                                    <c:forEach items="${requestScope.listcus}" var="cus" varStatus="no">
                                        <tr onclick="edit_row(${no.count})">
                                            <td style="width: 70px; text-align: center;">${no.count}</td>

                                    <input type="hidden" value="${cus.cusID}" id="cusid_row${no.count}"/>
                                    <input type="hidden" value="${cus.customerID.customerID}" id="representativeId_row${no.count}"/>
                                    <input type="hidden" value="${cus.sex}" id="cusSex_row${no.count}"/>
                                    <input type="hidden" value="${cus.dateOfBirth}" id="cusDOB_row${no.count}"/>

                                    <td id="fullname_row${no.count}" style="width: 170px; text-align: center;">${cus.fullName}</td>
                                    <td style="text-align: center; width: 170px;">
                                        <c:if test="${cus.sex eq true}">
                                            <img src="assets/images/Male_50px.png" style="width: 50px; height: 35px;"/>
                                        </c:if>
                                        <c:if test="${cus.sex eq false}">
                                            <img src="assets/images/Female_50px.png" style="width: 50px; height: 35px;"/>
                                        </c:if>
                                    </td>
                                    <td style="text-align: center; width: 170px;">
                                        <fmt:formatDate pattern="dd-MM-yyyy" value="${cus.dateOfBirth}"/>
                                    </td>

                                    <td style="width: 170px; text-align: center;">
                                        <c:if test="${cus.age gt 15}"><label>Adult</label></c:if>

                                        <c:if test="${cus.age eq 15}"><label>Kid</label></c:if>
                                        <c:if test="${cus.age eq 14}"><label>Kid</label></c:if>
                                        <c:if test="${cus.age eq 13}"><label>Kid</label></c:if>
                                        <c:if test="${cus.age eq 12}"><label>Kid</label></c:if>
                                        <c:if test="${cus.age eq 11}"><label>Kid</label></c:if>
                                        <c:if test="${cus.age eq 10}"><label>Kid</label></c:if>
                                        <c:if test="${cus.age eq 9}"><label>Kid</label></c:if>
                                        <c:if test="${cus.age eq 8}"><label>Kid</label></c:if>
                                        <c:if test="${cus.age eq 7}"><label>Kid</label></c:if>
                                        <c:if test="${cus.age eq 6}"><label>Kid</label></c:if>

                                        <c:if test="${cus.age eq 5}"><label>Baby</label></c:if>
                                        <c:if test="${cus.age eq 4}"><label>Baby</label></c:if>
                                        <c:if test="${cus.age eq 3}"><label>Baby</label></c:if>
                                        <c:if test="${cus.age eq 2}"><label>Baby</label></c:if>
                                        <c:if test="${cus.age eq 1}"><label>Baby</label></c:if>
                                        <c:if test="${cus.age eq 0}"><label>Baby</label></c:if>
                                        </td>

                                        <!--Pop Up Button-->
                                        <td style="width: 150px; text-align: center; font-size: 14px; font-weight: bold;">
                                            <button id="btn${no.count}" value="${cus.customerID.customerID}" onclick="return showRepresentative_row(${no.count})">${cus.customerID.customerID}</button>
                                    </td>
                                    <input id="representativeFullname_row${no.count}" type="hidden" value="${cus.customerID.fullName}"/>
                                    <input id="representativePhone_row${no.count}" type="hidden" value="${cus.customerID.phone}"/>
                                    <input id="representativeEmail_row${no.count}" type="hidden" value="${cus.customerID.email}"/>
                                    <!--End Pop Up Button-->

                                    <td style="width: 70px;">
                                        <form action="AdminTour_OddTourReserved_DetailEdit_Controller" method="post">
                                            <input type="hidden" name="txtTourBookID_DeleteCus" value="${requestScope.tourBookedupdate.tourBookedID}"/>
                                            <input type="hidden" name="txtCusID_Delete" value="${cus.cusID}"/>
                                            <input type="hidden" name="txtCusName_Delete" value="${cus.fullName}"/>
                                            <button style="font-size: 14px; width: 100px;" class="btn-danger" name="action" value="btnDeleteCus" type="submit" onclick="return confirm('Sure You Want To Delete This Customer')">
                                                Delete
                                            </button>
                                        </form>
                                    </td>

                                    </tr>

                                </c:forEach>

                                </tbody>
                            </table>
                        </div>       
                        <div class="col-md-12 text-center">
                            <ul class="pagination pagination-lg pager" id="myPager"></ul>
                        </div>
                        <div style="margin: 100px 0px 20px 400px; color: #008000;">
                            <form action="AdminTour_OddTourReserved_DetailEdit_Controller" method="post">
                                <button
                                    style="width: 100px; font-size: 14px; font-weight: bold; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; border-top-left-radius: 7px; border-top-right-radius: 7px;"
                                    type="submit" name="action" value="btnBack">Back</button>
                            </form>
                        </div>
                    </div>


                    <!------------------------------------------------ PAGE CONTENT ENDS ---------------------------------------------->
                </div>
            </div>

            <!--START POP UP-->
            <div id="myModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><img src="assets/images/close.png"></button>
                            <center><h4 class="modal-title" style="color: #0092ef;">Representative Customer's Information</h4></center>
                        </div>

                        <div class="modal-body">
                            <p style="margin-left: 40px;">
                                <label style="width: 100px; margin-bottom: 7px; text-align: center">ID </label><label id="lbID" style="margin-left: 50px; margin-bottom: 7px;"></label><br/>
                                <label style="width: 100px; margin-bottom: 7px; text-align: center">Full Name </label><label id="lbName" style="margin-left: 50px; margin-bottom: 7px;"></label><br/>
                                <label style="width: 100px; margin-bottom: 7px; text-align: center">Phone </label><label id="lbPhone" style="margin-left: 50px; margin-bottom: 7px;"></label><br/>
                                <label style="width: 100px; text-align: center">Email </label><label id="lbEmail" style="margin-left: 50px;"></label>
                            </p>

                        </div>

                        <div class="modal-footer">                  
                            <center>
                                <form action="AdminTour_SubTourReserved_Controller" method="post">
                                    <input type="hidden" name="txtTourBookedID_Edit_Pending" value="${requestScope.tourBookedupdate.tourBookedID}"/>
                                    <input type="hidden" id="passingRepreSentativeID" name="txtRepresentativeID_Edit_Pending"/>
                                    <input type="hidden" name="fromWhere" value="oddUpdate"/>
                                    <button type="submit" class="btn-danger" name="action" value="btnEdit_Pending_Link" style="margin-left: 430px; width: 150px; font-size: 14px;">Edit It's Group</button>
                                </form>
                                <button style="height: 35px; text-align: center; width: 100px; font-size: 14px;" class="btn-app" type="button" data-dismiss="modal">Close</button>
                            </center>
                        </div>
                    </div>
                </div>
            </div>
            <!--END POP UP-->

            <!--START POP UP Error-->
            <div id="myModalError" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content" id="errorContent">

                    </div>
                </div>
            </div>
            <!--END POP UP Error-->                

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
