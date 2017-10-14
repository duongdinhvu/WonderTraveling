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

                $('#table_Pending').pageMe({pagerSelector: '#myPager_PendingList', showPrevNext: true, hidePageNumbers: false, perPage: 10});
                $('#table_Departing').pageMe({pagerSelector: '#myPager_DepartingList', showPrevNext: true, hidePageNumbers: false, perPage: 10});
                $('#table_CompletedList').pageMe({pagerSelector: '#myPager_CompletedList', showPrevNext: true, hidePageNumbers: false, perPage: 10});
                $('#table_CancelList').pageMe({pagerSelector: '#myPager_CancelList', showPrevNext: true, hidePageNumbers: false, perPage: 10});

            });
        </script>

        <script type="text/javascript">
            $.fn.pageMe = function(opts) {
                var $this = this,
                        defaults = {
                            perPage: 10,
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

        <script>
            function validPending() {
                var textSearch = $('#txtSearch').val();
                if (textSearch.replace(/^\s+/g, '').length === 0) {
                    $('#textSearchError').text('Enter Text Search Please !!!');
                    return false;
                }

            }
        </script>

        <script>
            function validDeparting() {
                var textSearch = $('#txtSearchDeparting').val();
                if (textSearch.replace(/^\s+/g, '').length === 0) {
                    $('#textSearchErrorDeparting').text('Enter Text Search Please !!!');
                    return false;
                }

            }
        </script>

        <script>
            function validCompleted() {
                var textSearch = $('#txtSearchCompleted').val();
                if (textSearch.replace(/^\s+/g, '').length === 0) {
                    $('#textSearchErrorCompleted').text('Enter Text Search Please !!!');
                    return false;
                }

            }
        </script>

        <script>
            function validCancel() {
                var textSearch = $('#txtSearchCancel').val();
                if (textSearch.replace(/^\s+/g, '').length === 0) {
                    $('#textSearchErrorCancel').text('Enter Text Search Please !!!');
                    return false;
                }

            }
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
                            <li class="active">Tour Booked Sub</li>
                        </ul><!-- /.breadcrumb -->
                    </div>	
                    <!------------------------------------------------ PAGE CONTENT BEGINS ------------------------------------------->
                    <div id="TabPanel" class="container" style="width: 1030px;">	
                        <ul  class="nav nav-pills">
                            <li class="active">
                                <a  href="#PendingList" data-toggle="tab">Pending</a>
                            </li>
                            <li>
                                <a href="#DepartingList" data-toggle="tab">Departing</a>
                            </li>
                            <li>
                                <a href="#CompletedList" data-toggle="tab">Completed</a>
                            </li>
                            <li>
                                <a href="#CancelList" data-toggle="tab">Cancel</a>
                            </li>
                        </ul>

                        <div class="tab-content clearfix" style="width: 1030px;">
                            <!--TABLE PENDING LIST-->
                            <div class="tab-pane active" id="PendingList">
                                <p id="textSearchError" style="color: red; margin-left: 630px;"></p>
                                <form action="AdminTour_SubTourReserved_Controller" method="post">
                                    <div style="margin-left: 480px; margin-bottom: 20px;">
                                        <select name="searchType">
                                            <option value="Tour Booked ID">Tour Booked ID</option>
                                            <option value="Tour ID">Tour ID</option>
                                            <option value="Departure Date">Departure Date</option>
                                            <option value="Booked Date">Booked Date</option>
                                        </select>
                                        <input style=" margin-left: 15px; height: 30px;" type="text" id="txtSearch" name="txtSearch" placeholder="Enter Search Text..."/>
                                        <button style="width: 80px; margin-left: 15px; height: 30px; font-size: 14px;" type="submit"
                                                onclick="return validPending()"
                                                name="action" value="SearchTourBookedSub_Pending">
                                            <i class="fa fa-search"> Search</i>
                                        </button>
                                        <button style="width: 80px; margin-left: 20px; height: 30px; font-size: 14px;" type="submit" name="action" value="btnReload">
                                            <i class="fa fa-repeat"> Reload</i>
                                        </button>
                                    </div>
                                </form>
                                <div class="table-responsive">
                                    <table class="table table-hover">
                                        <thead style="text-align: center">
                                        <th style="width: 115px; text-align: center;">TourBooked ID</th>
                                        <th style="width: 90px; text-align: center;">Tour ID</th>
                                        <th style="width: 115px; text-align: center;">Departure Date</th>
                                        <th style="width: 100px; text-align: center;">Book Date</th>
                                        <th style="width: 100px; text-align: center;">Represented Customer ID</th>
                                        <th style="width: 90px; text-align: center;">Number Of People</th>
                                        <th style="width: 50px;"></th>
                                        <th style="width: 50px;"></th>
                                        <th style="width: 50px;"></th>
                                        </thead>
                                        <tbody id="table_Pending">
                                            <c:forEach items="${requestScope.PendingList}" var="item">
                                                <tr>
                                                    <td style="text-align: center">
                                                        <c:if test="${item.isNew eq true}">
                                                            <img src="assets/images/New_icons_60.gif" style="width: 20px; height: 12px; margin-right: 5px;"/>
                                                            ${item.tourBookedSubID}
                                                        </c:if>
                                                        <c:if test="${item.isNew eq false}">
                                                            ${item.tourBookedSubID}
                                                        </c:if>
                                                    </td>
                                                    <td style="text-align: center">${item.tourID.tourID}</td>
                                                    <td style="text-align: center">
                                                        <fmt:formatDate value="${item.departureDate}" pattern="dd-MM-yyyy" /> 
                                                    </td>
                                                    <td style="text-align: center">
                                                        <fmt:formatDate value="${item.createdDate}" pattern="dd-MM-yyyy"/>
                                                    </td>
                                                    <td style="text-align: center">${item.customerID.customerID}</td>
                                                    <td style="text-align: center">${item.numberOfPeople}</td>
                                                    <td style="width: 50px;">
                                                        <form action="AdminTour_SubTourReserved_Controller" method="post">
                                                            <input type="hidden" name="txtTourBookedID_CancelSub" value="${item.tourBookedID.tourBookedID}"/>
                                                            <input type="hidden" name="txtRepresentativeID_CancelSub" value="${item.customerID.customerID}"/>
                                                            <input type="hidden" name="txtTourBookedSubID_CancelSub" value="${item.tourBookedSubID}"/>
                                                            <button style="width: 70px; font-size: 14px;" class="btn-app" type="submit" name="action" value="btnDetail_CancelSub">Detail</button>
                                                        </form>
                                                    </td>
                                                    <td style="width: 50px;">
                                                        <form action="AdminTour_SubTourReserved_Controller" method="post">
                                                            <input type="hidden" name="txtTourBookedSubID_Edit_Pending" value="${item.tourBookedSubID}"/>
                                                            <input type="hidden" name="txtTourBookedID_Edit_Pending" value="${item.tourBookedID.tourBookedID}"/>
                                                            <input type="hidden" name="txtRepresentativeID_Edit_Pending" value="${item.customerID.customerID}"/>
                                                            <input type="hidden" name="fromWhere" value="subTourReserved"/>
                                                            <button style="width: 80px; font-size: 14px;" style="width: 70px; font-size: 14px;" class="btn-warning" type="submit" name="action" value="btnEdit_Pending_Link">
                                                                <i class="fa fa-edit"> Edit</i>
                                                            </button>
                                                        </form>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="col-md-12 text-center">
                                    <ul class="pagination pagination-lg pager" id="myPager_PendingList"></ul>
                                </div>
                            </div>

                            <!--TABLE DEPARTING LIST-->
                            <div class="tab-pane" id="DepartingList">
                                <p id="textSearchErrorDeparting" style="color: red; margin-left: 630px;"></p>
                                <form action="AdminTour_SubTourReserved_Controller" method="post">
                                    <div style="margin-left: 480px; margin-bottom: 20px;">
                                        <select name="searchType">
                                            <option value="Tour Booked ID">Tour Booked ID</option>
                                            <option value="Tour ID">Tour ID</option>
                                            <option value="Departure Date">Departure Date</option>
                                            <option value="Booked Date">Booked Date</option>
                                        </select>
                                        <input style=" margin-left: 15px; height: 30px;" type="text" id="txtSearchDeparting" name="txtSearch" placeholder="Enter Search Text..."/>
                                        <button style="width: 80px; margin-left: 15px; height: 30px; font-size: 14px;" type="submit"
                                                onclick="return validDeparting()"
                                                name="action" value="SearchTourBookedSub_Departing">
                                            <i class="fa fa-search"> Search</i>
                                        </button>
                                        <button style="width: 80px; margin-left: 20px; height: 30px; font-size: 14px;" type="submit" name="action" value="btnReload">
                                            <i class="fa fa-repeat"> Reload</i>
                                        </button>
                                    </div>
                                </form>

                                <div class="table-responsive">
                                    <table class="table table-hover">
                                        <thead style="text-align: center">
                                        <th style="width: 115px; text-align: center;">TourBooked ID</th>
                                        <th style="width: 90px; text-align: center;">Tour ID</th>
                                        <th style="width: 115px; text-align: center;">Departure Date</th>
                                        <th style="width: 100px; text-align: center;">Book Date</th>
                                        <th style="width: 100px; text-align: center;">Represented Customer ID</th>
                                        <th style="width: 140px; text-align: center;">Number Of People</th>
                                        <th style="width: 50px;"></th>
                                        </thead>
                                        <tbody id="table_Departing">
                                            <c:forEach items="${requestScope.DepartingList}" var="item">
                                                <tr>
                                                    <td style="text-align: center">${item.tourBookedSubID}</td>
                                                    <td style="text-align: center">${item.tourID.tourID}</td>
                                                    <td style="text-align: center">
                                                        <fmt:formatDate value="${item.departureDate}" pattern="dd-MM-yyyy" /> 
                                                    </td>
                                                    <td style="text-align: center">
                                                        <fmt:formatDate value="${item.createdDate}" pattern="dd-MM-yyyy"/>
                                                    </td>
                                                    <td style="text-align: center">${item.customerID.customerID}</td>
                                                    <td style="text-align: center">${item.numberOfPeople}</td>
                                                    <td style="width: 50px;">
                                                        <form action="AdminTour_SubTourReserved_Controller" method="post">
                                                            <input type="hidden" name="txtTourBookedID_CancelSub" value="${item.tourBookedID.tourBookedID}"/>
                                                            <input type="hidden" name="txtRepresentativeID_CancelSub" value="${item.customerID.customerID}"/>
                                                            <input type="hidden" name="txtTourBookedSubID_CancelSub" value="${item.tourBookedSubID}"/>
                                                            <button style="width: 70px; font-size: 14px;" class="btn-app" type="submit" name="action" value="btnDetail_CancelSub">Detail</button>
                                                        </form>                          
                                                    </td>

                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="col-md-12 text-center">
                                    <ul class="pagination pagination-lg pager" id="myPager_DepartingList"></ul>
                                </div>
                            </div>

                            <!--TABLE COMPLETED LIST-->
                            <div class="tab-pane" id="CompletedList">
                                <p id="textSearchErrorCompleted" style="color: red; margin-left: 630px;"></p>
                                <form action="AdminTour_SubTourReserved_Controller" method="post">
                                    <div style="margin-left: 480px; margin-bottom: 20px;">
                                        <select name="searchType">
                                            <option value="Tour Booked ID">Tour Booked ID</option>
                                            <option value="Tour ID">Tour ID</option>
                                            <option value="Departure Date">Departure Date</option>
                                            <option value="Booked Date">Booked Date</option>
                                        </select>
                                        <input style=" margin-left: 15px; height: 30px;" type="text" id="txtSearchCompleted" name="txtSearch" placeholder="Enter Search Text..."/>
                                        <button style="width: 80px; margin-left: 15px; height: 30px; font-size: 14px;" onclick="return validCompleted();" type="submit" name="action" value="SearchTourBookedSub_Completed">
                                            <i class="fa fa-search"> Search</i>
                                        </button>
                                        <button style="width: 80px; margin-left: 20px; height: 30px; font-size: 14px;" type="submit" name="action" value="btnReload">
                                            <i class="fa fa-repeat"> Reload</i>
                                        </button>
                                    </div>
                                </form>

                                <div class="table-responsive">
                                    <table class="table table-hover">
                                        <thead style="text-align: center">
                                        <th style="width: 115px; text-align: center;">TourBooked ID</th>
                                        <th style="width: 90px; text-align: center;">Tour ID</th>
                                        <th style="width: 115px; text-align: center;">Departure Date</th>
                                        <th style="width: 100px; text-align: center;">Book Date</th>
                                        <th style="width: 100px; text-align: center;">Represented Customer ID</th>
                                        <th style="width: 140px; text-align: center;">Number Of People</th>
                                        <th style="width: 50px;"></th>
                                        </thead>
                                        <tbody id="table_CompletedList">
                                            <c:forEach items="${requestScope.CompletedList}" var="item">
                                                <tr>
                                                    <td style="text-align: center">${item.tourBookedSubID}</td>
                                                    <td style="text-align: center">${item.tourID.tourID}</td>
                                                    <td style="text-align: center">
                                                        <fmt:formatDate value="${item.departureDate}" pattern="dd-MM-yyyy" /> 
                                                    </td>
                                                    <td style="text-align: center">
                                                        <fmt:formatDate value="${item.createdDate}" pattern="dd-MM-yyyy"/>
                                                    </td>
                                                    <td style="text-align: center">${item.customerID.customerID}</td>
                                                    <td style="text-align: center">${item.numberOfPeople}</td>
                                                    <td style="width: 50px;">
                                                        <form action="AdminTour_SubTourReserved_Controller" method="post">
                                                            <input type="hidden" name="txtTourBookedID_CancelSub" value="${item.tourBookedID.tourBookedID}"/>
                                                            <input type="hidden" name="txtRepresentativeID_CancelSub" value="${item.customerID.customerID}"/>
                                                            <input type="hidden" name="txtTourBookedSubID_CancelSub" value="${item.tourBookedSubID}"/>
                                                            <button style="width: 70px; font-size: 14px;" class="btn-app" type="submit" name="action" value="btnDetail_CancelSub">Detail</button>
                                                        </form> 
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="col-md-12 text-center">
                                    <ul class="pagination pagination-lg pager" id="myPager_CompletedList"></ul>
                                </div>
                            </div>

                            <div class="tab-pane" id="CancelList">
                                <p id="textSearchErrorCancel" style="color: red; margin-left: 630px;"></p>
                                <form action="AdminTour_SubTourReserved_Controller" method="post">
                                    <div style="margin-left: 480px; margin-bottom: 20px;">
                                        <select name="searchType">
                                            <option value="Tour Booked ID">Tour Booked ID</option>
                                            <option value="Tour ID">Tour ID</option>
                                            <option value="Departure Date">Departure Date</option>
                                            <option value="Booked Date">Booked Date</option>
                                        </select>
                                        <input style=" margin-left: 15px; height: 30px;" type="text" id="txtSearchCancel" name="txtSearch" placeholder="Enter Search Text..."/>
                                        <button style="width: 80px; margin-left: 15px; height: 30px; font-size: 14px;"
                                                onclick="return validCancel()"
                                                type="submit" name="action" value="SearchTourBookedSub_Cancel">
                                            <i class="fa fa-search"> Search</i>
                                        </button>
                                        <button style="width: 80px; margin-left: 20px; height: 30px; font-size: 14px;" type="submit" name="action" value="btnReload">
                                            <i class="fa fa-repeat"> Reload</i>
                                        </button>
                                    </div>
                                </form>

                                <div class="table-responsive">
                                    <table class="table table-hover">
                                        <thead style="text-align: center">
                                        <th style="width: 115px; text-align: center;">TourBooked ID</th>
                                        <th style="width: 90px; text-align: center;">Tour ID</th>
                                        <th style="width: 115px; text-align: center;">Departure Date</th>
                                        <th style="width: 100px; text-align: center;">Book Date</th>
                                        <th style="width: 100px; text-align: center;">Represented Customer ID</th>
                                        <th style="width: 140px; text-align: center;">Number Of People</th>
                                        <th style="width: 50px;"></th>
                                        </thead>
                                        <tbody id="table_CancelList">
                                            <c:forEach items="${requestScope.CancelList}" var="item">
                                                <tr>
                                                    <td style="text-align: center">${item.tourBookedSubID}</td>
                                                    <td style="text-align: center">${item.tourID.tourID}</td>
                                                    <td style="text-align: center">
                                                        <fmt:formatDate value="${item.departureDate}" pattern="dd-MM-yyyy" /> 
                                                    </td>
                                                    <td style="text-align: center">
                                                        <fmt:formatDate value="${item.createdDate}" pattern="dd-MM-yyyy"/>
                                                    </td>
                                                    <td style="text-align: center">${item.customerID.customerID}</td>
                                                    <td style="text-align: center">${item.numberOfPeople}</td>
                                                    <td style="width: 50px;">
                                                        <form action="AdminTour_SubTourReserved_Controller" method="post">
                                                            <input type="hidden" name="txtTourBookedID_CancelSub" value="${item.tourBookedID.tourBookedID}"/>
                                                            <input type="hidden" name="txtRepresentativeID_CancelSub" value="${item.customerID.customerID}"/>
                                                            <input type="hidden" name="txtTourBookedSubID_CancelSub" value="${item.tourBookedSubID}"/>
                                                            <button style="width: 70px; font-size: 14px;" class="btn-app" type="submit" name="action" value="btnDetail_CancelSub">Detail</button>
                                                        </form> 
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="col-md-12 text-center">
                                    <ul class="pagination pagination-lg pager" id="myPager_CancelList"></ul>
                                </div>
                            </div>
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
