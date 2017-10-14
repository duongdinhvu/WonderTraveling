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
                                <a href="#">Trang Chủ</a>
                            </li>
                            <li class="active">Dashboard</li>
                        </ul><!-- /.breadcrumb -->
                    </div>	
                    <!------------------------------------------------ PAGE CONTENT BEGINS ------------------------------------------->
                    <div class=" container" style="width: 1025px; height: auto; margin-top: 15px; margin-left: 60px;">
                        <div style="width: 1000px; margin-bottom: 30px;">
                            <center><h4 style=" color: #00BE67;">${requestScope.tour.tourTitle}</h4>
                                <form action="AdminTour_TourInsert_Controller" method="post">
                                    <input type="hidden" name="txttourid" value="${requestScope.tour.tourID}"/>
                                    <h5 style="margin-left: 820px;"><button type="submit" name="action" value="btnCreateScheduleAfter" style="width: 150px;">Create Schedule</button></h5>
                                </form>
                            </center>
                        </div>
                        <div style="margin-top: 10px;">
                            <form action="AdminTour_TourDetail_Controller" method="post">
                                <table style="margin-bottom: 20px;">
                                    <tr>
                                        <td>
                                            <label style="width: 200px;">Tour ID: </label><input type="text" readonly="true" value="${requestScope.tour.tourID}" style="color: #0092ef; background: #ffffff; text-align: center;"/><br/><br/>

                                            <label style="width: 200px;">Tour Category Name: </label><input type="text" readonly="true" value="${requestScope.tour.tourCategoryID.tourCategoryName}" style="color: #0092ef; text-align: center;"/><br/><br/>

                                            <label style="width: 200px;">Destination: </label><input type="text" readonly="true" value="${requestScope.tour.headingTo}" style="color: #0092ef; text-align: center;"/><br/><br/>
                                        </td>
                                        <td>
                                            <label style="margin-left: 60px;">Representative Image:</label>
                                        </td>
                                        <td>
                                            <input style="width: 240px; height: 150px; margin-left: 40px; margin-top: 10px;" type="image" alt="${requestScope.tour.image}"  src="assets/images/${requestScope.tour.image}"/>
                                        </td>
                                    </tr>
                                </table>

                                <table>
                                    <tr>
                                        <td>
                                            <label style="width: 200px;">Group Tour Price: </label><input type="text" readonly="true" value="${requestScope.tour.evenTourPrice}" style="color: #0092ef; text-align: center;"/><br/><br/>

                                            <label style="width: 200px;">Odd Tour Price: </label><input type="text" readonly="true" value="${requestScope.tour.oddTourPrice}" style="color: #0092ef; text-align: center;"/><br/><br/>

                                            <label style="width: 200px;">Hotel Rank: </label><input type="text" readonly="true" value="${requestScope.tour.hotelRank}" style="color: #0092ef; text-align: center;"/><br/><br/>
                                        </td>
                                        <td>
                                            <label style="width: 200px; margin-left: 50px;">Departure Dates: </label>
                                        </td>
                                        <td>
                                            <textarea type="text" readonly="true" style="width: 320px; resize: none; height: 160px; overflow: scroll; color: #0092ef;">${requestScope.tour.depatureDay}</textarea><br/><br/>
                                        </td>
                                    </tr>
                                </table>


                                <label style="width: 200px;">Departure Point: </label><input type="text" readonly="true" value="${requestScope.tour.depaturePoint}" style="color: #0092ef; text-align: center; width: 195px"/>
                                <label style="width: 200px; margin-left: 50px;">Transportation: </label><input type="text" readonly="true" value="${requestScope.transport}" style="color: #0092ef; text-align: center; width: 195px"/><br/><br/>

                                <label style="width: 200px;">Available Ticket: </label><input readonly="true" type="text" value="${requestScope.tour.tickets}" style="color: #0092ef; text-align: center; width: 195px"/>

                                <label style="width: 200px; margin-left: 50px;">Status: </label><input type="text" readonly="true" value="${requestScope.status}" style="color: #0092ef; text-align: center; width: 195px"/>
                                <label style="width: 200px;">Created Date: </label><label style="width: 200px; margin-left: 50px; margin-top: 10px; color: #0092ef;"><button><fmt:formatDate value="${requestScope.tour.createdDate}" pattern="dd-MM-yyyy"/></button></label>

                                <br/>
                                <center>
                                    <button style="width: 100px; margin-top: 20px; font-weight: bold;" name="action" value="btnClose_TourDetal" type="submit">Back</button>
                                </center>
                            </form>
                        </div>

                    </div>
                    <!------------------------------------------------ PAGE CONTENT ENDS ---------------------------------------------->
                </div>
            </div>

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
