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
        <script type="text/javascript">
            $(function() {
                $("#datepickerFrom").datepicker({
                    //format and contraint datepicker
                    dateFormat: 'dd-mm-yyyy', maxDate: 0, showButtonPanel: true
                });
                $("#datepickerTo").datepicker({
                    //format and contraint datepicker
                    dateFormat: 'dd-mm-yy', maxDate: 0, showButtonPanel: true
                })
                $("#datepickerTo").datepicker('setDate', new Date());
            });
        </script>

        <script>
            function validate() {
                var dateFrom = $('#datepickerFrom').val();
                var dateTo = $('#datepickerTo').val();

                //var day = parseInt($('#datepickerFrom').datepicker('getDate').getDate());
                //var month = parseInt($('#datepickerFrom').datepicker('getDate').getMonth() + 1);
                //var year = parseInt($('#datepickerFrom').datepicker('getDate').getFullYear());

                var day = parseInt(dateFrom.toString().substring(0, 2));
                var month = parseInt(dateFrom.toString().substring(3, 5));
                var year = parseInt(dateFrom.toString().substring(6, 10));

                var dayTo = parseInt(dateTo.toString().substring(0, 2));
                var monthTo = parseInt(dateTo.toString().substring(3, 5));
                var yearTo = parseInt(dateTo.toString().substring(6, 10));

                var currentDate = new Date();
                var currentYear = parseInt($.format.date(currentDate, 'yyyy').toString());
                var currentMonth = parseInt($.format.date(currentDate, 'MM').toString());
                var currentDay = parseInt($.format.date(currentDate, 'dd').toString());

                var valid1 = $('#datepickerFrom').val().toString().substring(2, 3);
                var valid2 = $('#datepickerFrom').val().toString().substring(5, 6);
                var validNum1 = parseInt($('#datepickerFrom').val().toString().substring(0, 2));
                var validNum2 = parseInt($('#datepickerFrom').val().toString().substring(3, 5));
                var validNum3 = parseInt($('#datepickerFrom').val().toString().substring(6, 10));

                var validTo = $('#datepickerTo').val().toString().substring(2, 3);
                var validTo2 = $('#datepickerTo').val().toString().substring(5, 6);
                var validNumTo1 = parseInt($('#datepickerTo').val().toString().substring(0, 2));
                var validNumTo2 = parseInt($('#datepickerTo').val().toString().substring(3, 5));
                var validNumTo3 = parseInt($('#datepickerTo').val().toString().substring(6, 10));

                if (dateFrom.replace(/^\s+/g, '').length === 0) {
                    $('#error').text('Date From Must Be Fill !!!');
                    return false;
                } else if (valid1 !== '-' || valid2 !== '-' || validNum1 <= 0 || validNum2 <= 0 || validNum3 <= 0 || $('#datepickerFrom').val().toString().length < 10) {
                    $('#error').text('Date From Invalid, Please Input "DD-MM-YYYY"');
                    return false;
                } else if (year > currentYear) {
                    $('#error').text('Date From Invalid, Cannot Greater Than Current Date');
                    return false;
                } else if (year === currentYear && month > currentMonth) {
                    $('#error').text('Date From Invalid, Cannot Greater Than Current Date');
                    return false;
                } else if (year === currentYear && month === currentMonth && day >= currentDay) {
                    $('#error').text('Date From Invalid, Cannot Greater Than Or Equal Current Date');
                    return false;

                    ////DATE TO///////////////////////////////////////

                } else {
                    $('#error').text('');

                    if (dateTo.replace(/^\s+/g, '').length === 0) {
                        $('#errorDateTo').text('Date To Must Be Fill !!!');
                        return false;
                    } else if (validTo !== '-' || validTo2 !== '-' || validNumTo1 <= 0 || validNumTo2 <= 0 || validNumTo3 <= 0 || $('#datepickerTo').val().toString().length < 10) {
                        $('#errorDateTo').text('Date To Invalid, Please Input "DD-MM-YYYY"');
                        return false;
                    } else if (yearTo > currentYear) {
                        $('#errorDateTo').text('Date To Invalid, Cannot Greater Than Current Date');
                        return false;
                    } else if (yearTo === currentYear && monthTo > currentMonth) {
                        $('#errorDateTo').text('Date To Invalid, Cannot Greater Than Current Date');
                        return false;
                    } else if (yearTo === currentYear && monthTo === currentMonth && dayTo > currentDay) {
                        $('#errorDateTo').text('Date To Invalid, Cannot Greater Than Current Date');
                        return false;
                        ///////////COMPARE BETWEEN THE TWO YEARS/////////////////
                    } else if (year > yearTo) {
                        $('#error').text('Date From Cannot Greater Than Date To!!!');
                        return false;
                    } else if (year === yearTo && month > monthTo) {
                        $('#error').text('Date From Cannot Greater Than Date To!!!');
                        return false;
                    } else if (year === yearTo && month === monthTo && day >= dayTo) {
                        $('#error').text('Date From Cannot Greater Than Or Equal Date To!!!');
                        return false;
                    }
                }
            }
            ;
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
                            <li class="active">Dashboard</li>
                        </ul><!-- /.breadcrumb -->
                    </div>	
                    <!------------------------------------------------ PAGE CONTENT BEGINS ------------------------------------------->
                    <div class="well" style="width: 1158px; height: 800px;">
                        <div style="background-color: #ffffff; width: 800px; border-top: #006dcc double">
                            <div style="margin-left: 5px; margin-top: 10px;">
                                <h5>WONDER TRAVELING REPORT</h5>
                            </div>
                            <form action="AdminTour_TourReport_Controller" method="post">
                                <div style="margin-left: 5px; margin-top: 20px">
                                    <b style="font-weight: bold; width: 100px;">Date From</b><br/>
                                    <input id="datepickerFrom" pattern="(0[1-9]|1[0-9]|2[0-9]|3[01]).(0[1-9]|1[012]).[0-9]{4}" required="true" name="txtDateFrom" style="width: 300px; margin-bottom: 10px; margin-top: 5px; padding: 5px;"/>
                                    <p id="error" style="color: red;"></p><br/>

                                    <b style="font-weight: bold; width: 100px;">Date To</b>
                                    <br/>
                                    <input id="datepickerTo" pattern="(0[1-9]|1[0-9]|2[0-9]|3[01]).(0[1-9]|1[012]).[0-9]{4}" required="true"
                                           name="txtDateTo" style="width: 300px; margin-top: 5px; padding: 5px;"/>                                   
                                    <p id="errorDateTo" style="color: red;"></p>
                                    <br/><br/>

                                    <b style=" font-weight: bold; width: 100px;">Report Type</b><br/>
                                    <select name="slReportType" style="margin-top: 5px; width: 750px; font-size: 14px; padding: 5px;">
                                        <option value="Top 05 Highest Revenue Of Tours">Top 05 Highest Revenue Of Tours</option>
                                        <option value="Top 05 Most Booked Of Tours">Top 05 Most Booked Of Tours</option>
                                    </select>
                                </div>
                                <div style="background-color: #ffffff; width: 800px;">
                                    <button type="submit" name="action" value="btnViewReport" class="btn-info" style="width: 120px; height: 40px; margin-left: 630px; margin-top: 10px; margin-bottom: 10px;" onclick="return validate();">View Report</button>
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
