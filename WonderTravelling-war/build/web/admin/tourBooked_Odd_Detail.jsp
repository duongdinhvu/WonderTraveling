<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

        <script>
            function edit_row(no)
            {
                var id = $("#btn" + no).val();
                var fullname = $("#representativeFullname_row" + no).val();
                var phone = $("#representativePhone_row" + no).val();
                var email = $("#representativeEmail_row" + no).val();

                $('#lbID').text(id);
                $('#lbName').text(fullname);
                $('#lbPhone').text(phone);
                $('#lbEmail').text(email);

                $("#myModal").modal('show');
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
                            <li class="active">Tour Booked Detail (Grafted)</li>
                        </ul><!-- /.breadcrumb -->
                    </div>	
                    <!------------------------------------------------ PAGE CONTENT BEGINS ------------------------------------------->
                    <div style="margin: 20px 60px">
                        <div style="margin: 0px 0px 60px 250px; color: #008000;">
                            <p><h2>Tour Booked Detail</h2></p>
                        </div>
                        <label style="width: 200px;">Tour Booked ID</label>
                        <label style="width: 190px; height: 27px; text-align: center; border: 1px black solid; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; border-top-left-radius: 7px; border-top-right-radius: 7px;"
                               >${requestScope.tourBooked.tourBookedID}</label>

                        <label style="width: 100px; margin-left: 90px;">Tour ID</label>
                        <label style="width: 190px; height: 27px; text-align: center; border: 1px black solid; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; border-top-left-radius: 7px; border-top-right-radius: 7px;"
                               >${requestScope.tourBooked.tourID.tourID}</label><br/><br/>

                        <label style="width: 200px;">Departure Date</label>
                        <label style="width: 190px; height: 27px; text-align: center; border: 1px black solid; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; border-top-left-radius: 7px; border-top-right-radius: 7px;">
                            <fmt:formatDate value="${requestScope.tourBooked.departureDate}" pattern="dd-MM-yyyy"/>
                        </label>

                        <label style="width: 100px; margin-left: 90px;">Book Date</label>
                        <label style="width: 190px; height: 27px; text-align: center; border: 1px black solid; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; border-top-left-radius: 7px; border-top-right-radius: 7px;">
                            <fmt:formatDate value="${requestScope.tourBooked.createdDate}" pattern="dd-MM-yyyy"/>
                        </label><br/><br/>

                        <label style="width: 200px;">Promotion ID</label>
                        <label style="width: 190px; height: 27px; text-align: center; border: 1px black solid; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; border-top-left-radius: 7px; border-top-right-radius: 7px;"
                               >${requestScope.tourBooked.promotionID.promotionID}</label>

                        <label style="width: 100px; margin-left: 90px;">Number Of Kid</label>
                        <label style="margin-left: 40px; width: 100px; height: 27px; text-align: center; border: 1px black solid; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; border-top-left-radius: 7px; border-top-right-radius: 7px;"
                               >${requestScope.tourBooked.numberOfKid}</label><br/><br/>       

                        <label style="width: 200px;">Status</label>
                        <c:if test="${requestScope.tourBooked.status eq '1'}">
                            <label style="width: 190px; height: 27px; text-align: center; border: 1px black solid; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; border-top-left-radius: 7px; border-top-right-radius: 7px;"
                                   >Pending</label>
                        </c:if>
                        <c:if test="${requestScope.tourBooked.status eq '2'}">
                            <label style="width: 190px; height: 27px; text-align: center; border: 1px black solid; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; border-top-left-radius: 7px; border-top-right-radius: 7px;"
                                   >Departing</label>
                        </c:if>
                        <c:if test="${requestScope.tourBooked.status eq '3'}">
                            <label style="width: 190px; height: 27px; text-align: center; border: 1px black solid; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; border-top-left-radius: 7px; border-top-right-radius: 7px;"
                                   >Completed</label>
                        </c:if>
                        <c:if test="${requestScope.tourBooked.status eq '4'}">
                            <label style="width: 190px; height: 27px; text-align: center; border: 1px black solid; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; border-top-left-radius: 7px; border-top-right-radius: 7px;"
                                   >Cancel</label>
                        </c:if>        

                        <label style="width: 120px; margin-left: 90px">Number Of Baby</label>
                        <label style="width: 100px; margin-left: 20px; height: 27px; text-align: center; border: 1px black solid; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; border-top-left-radius: 7px; border-top-right-radius: 7px;"
                               >${requestScope.tourBooked.numberOfBaby}</label><br/><br/>

                        <label style="width: 200px;">Individual Room</label>
                        <label style="width: 190px; height: 27px; text-align: center; border: 1px black solid; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; border-top-left-radius: 7px; border-top-right-radius: 7px;"
                               >${requestScope.tourBooked.individualRoom}</label>

                        <label style="width: 130px; margin-left: 90px;">Number Of Adult</label>
                        <label style="width: 100px; margin-left: 10px; height: 27px; text-align: center; border: 1px black solid; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; border-top-left-radius: 7px; border-top-right-radius: 7px;"
                               >${requestScope.tourBooked.numberOfAdult}</label><br/><br/>

                        <label style="width: 200px;">Number Of People</label>
                        <label style="width: 190px; height: 27px; text-align: center; border: 1px black solid; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; border-top-left-radius: 7px; border-top-right-radius: 7px;"
                               >${requestScope.tourBooked.numberOfPeople}</label>

                        <label style="width: 130px; margin-left: 90px;">Available Ticket Remained:</label>
                        <label style="width: 100px; margin-left: 10px; height: 27px; text-align: center; border: 1px black solid; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; border-top-left-radius: 7px; border-top-right-radius: 7px;"
                               >${requestScope.availableTicket}</label>       

                        <div class="table-responsive">
                            <div style="font-weight: bold; margin-left: 360px; color: #00BE67; margin-top: 20px; margin-bottom: 20px;">
                                <p><h3>Customer List</h3></p>
                            </div>
                            <table class="table table-hover">
                                <thead>
                                <th style="width: 70px; text-align: center;">#</th>
                                <th style="width: 170px; text-align: center;">Full Name</th>
                                <th style="width: 170px; text-align: center;">Gender</th>
                                <th style="width: 170px; text-align: center;">Date Of Birth</th>
                                <th style="width: 170px; text-align: center;">Baby/Kid/Adult</th>
                                <th style="width: 170px; text-align: center;">Representative</th>
                                </thead>
                                <tbody id="table_CusList">
                                    <c:forEach items="${requestScope.listcus}" var="cus" varStatus="no">
                                        <tr>
                                            <td style="width: 70px; text-align: center;">${no.count}</td>
                                            <td style="width: 170px; text-align: center;">${cus.fullName}</td>
                                            <td style="width: 170px; text-align: center;">
                                                <c:if test="${cus.sex eq true}">
                                                    <img src="assets/images/Male_50px.png" style="width: 50px; height: 35px;"/>
                                                </c:if>
                                                <c:if test="${cus.sex eq false}">
                                                    <img src="assets/images/Female_50px.png" style="width: 50px; height: 35px;"/>
                                                </c:if>
                                            </td>
                                            <td style="width: 170px; text-align: center;">
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
                                                <td style="width: 170px; text-align: center; font-size: 14px;"><button id="btn${no.count}" class="btn-info" value="${cus.customerID.customerID}" onclick="edit_row(${no.count})">${cus.customerID.customerID}</button></td>
                                    <input id="representativeFullname_row${no.count}" type="hidden" value="${cus.customerID.fullName}"/>
                                    <input id="representativePhone_row${no.count}" type="hidden" value="${cus.customerID.phone}"/>
                                    <input id="representativeEmail_row${no.count}" type="hidden" value="${cus.customerID.email}"/>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>       
                        <div class="col-md-12 text-center">
                            <ul class="pagination pagination-lg pager" id="myPager"></ul>
                        </div>       
                        <div style="margin: 130px 0px 20px 400px; color: #008000;">
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
                            <center><button type="button" class="btn btn-default" data-dismiss="modal">Close</button></center>
                        </div>
                    </div>
                </div>
            </div>
            <!--END POP UP-->

            <div class="footer">
                <div class="footer-inner">
                    <div class="footer-content">
                        <span class="bigger-120"><span class="blue bolder">Travel</span>Application &copy; 2017-2018</span>
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
