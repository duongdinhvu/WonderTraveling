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
        <link rel="stylesheet" href="assets/css/jquery-ui.min.css"/>
        <script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/jspdf.min.js"></script>
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
                                    Add Car
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
                            <li class="active">Dashboard</li>
                        </ul><!-- /.breadcrumb -->
                    </div>	
                    <!------------------------------------------------ PAGE CONTENT BEGINS ------------------------------------------->
                    <div style="width: 1025px; height: 500px;">
                        <div style="margin-left: 5px; margin-top: 15px;">
                            <h5 style=" font-weight: bold;">WONDER TRAVELING REPORT</h5><br/>
                            <p style="font-weight: bold;">Address: 590 CMT8 - District 3 - Ho Chi Minh City</p>
                            <p style="font-weight: bold;">Contact: 0948 277 065 - Mr.Khoa</p>
                        </div>
                        <div style="font-style: oblique; margin-bottom: 50px;">
                            <center>
                                <h3>TOP 5 OF CAR REVENUE</h3>
                            </center>
                        </div>
                        <div>
                            <center>
                                <label style="font-weight: bold">From: ${requestScope.dateFromString}</label>
                                <label style="margin-left: 100px; font-weight: bold;">To: ${requestScope.dateToString}</label>                            
                            </center>
                        </div>
                        <div style="width: 1150px;">
                            <center>
                                <table class="table-striped table-hover">
                                    <thead>
                                        <tr>
                                            <th style="width: 50px; text-align: center; height: 35px;">Top</th>
                                            <th style="width: 120px; text-align: center; height: 35px;">Car ID</th>
                                            <th style="width: 300px; text-align: center; height: 35px;">Car Name</th>
                                            <th style="width: 120px; text-align: center; height: 35px;">Car Revenue</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${requestScope.list}" var="car" varStatus="num">
                                            <tr style="height: 30px;">
                                                <c:if test="${car.revenue != 0}" >
                                                    <td style="width: 50px; text-align: center;">${num.count}</td>
                                                    <td style="width: 120px; text-align: center;">${car.carID}</td>
                                                    <td style="width: 300px; text-align: center;">${car.carName}</td>
                                                    <td style="width: 120px; text-align: center;">${car.revenue} $</td>
                                                </c:if>
                                                <c:if test="${car.revenue == 0}" >
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                </c:if>
                                            </tr>
                                        </c:forEach>
                                        <tr>
                                            <td colspan="4">
                                                <p style="margin-left: 480px;">Total: ${requestScope.sum}$</p>
                                            </td>
                                        </tr>
                                    </tbody>
                                    <tfoot>
                                        <tr>
                                            <th style="width: 50px; text-align: center; height: 35px;">Top</th>
                                            <th style="width: 120px; text-align: center; height: 35px;">Car ID</th>
                                            <th style="width: 300px; text-align: center; height: 35px;">Car Name</th>
                                            <th style="width: 120px; text-align: center; height: 35px;">Car Revenue</th>
                                        </tr>
                                    </tfoot>
                                </table>
                            </center>
                        </div>
                    </div>
                    <div style="width: 1025px;">
                        <div style="margin-left: 10px;">
                            <form action="AdminCar_ReportTour_FilePDF_Controller" method="get">
                                <label style="font-weight: bold;">
                                    Day Of Issued: ${requestScope.dayOfIssued}
                                </label>
                                <input type="hidden" name="txtDateFrom" value="${requestScope.dateFromString}"/>
                                <input type="hidden" name="txtDateTo" value="${requestScope.dateToString}"/>
                                <button name="action" value="btnPrintTop05OfRevenue" type="submit" style="margin-left: 900px; width: 100px; height: 25px; color: #ffffff;" class="btn-info">Print</button>
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
