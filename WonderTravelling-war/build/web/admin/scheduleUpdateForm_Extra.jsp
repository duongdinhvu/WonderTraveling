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
        <script src="assets/js/jquery.validate.min.js"></script>
        <!--NEW-->
        <script type="text/javascript">
            $(document).ready(function() {
                $('.image-upload-wrap').hide();
            });
        </script>

        <script>
            function validateForm() {
                var scheduleTitle = document.formScheduleUpdateFormExtra.txtScheduleTitle.value;
                var content = document.formScheduleUpdateFormExtra.txtAreaContent.value;

                var status = false;
                var alphaExp = /[a-zA-Z0-9.,-]/;

                if (scheduleTitle.replace(/^\s+/g, '').length === 0) {
                    document.getElementById('scheduleError').innerHTML
                            = "<img src='assets/images/unchecked.gif'/> Please Enter Schedule Title !";
                    document.getElementById('txtScheduleTitle').focus();
                    status = false;
                    return false;
                } else if (!isNaN(scheduleTitle)) {
                    document.getElementById('scheduleError').innerHTML
                            = "<img src='assets/images/unchecked.gif'/> Schedule Title Must Contain Letters !";
                    document.getElementById('txtScheduleTitle').focus();
                    status = false;
                    return false;
                } else if (scheduleTitle.replace(/^\s+/g, '').length < 5 || scheduleTitle.replace(/^\s+/g, '').length > 60) {
                    document.getElementById('scheduleError').innerHTML
                            = "<img src='assets/images/unchecked.gif'/> Schedule Title Must Be Between 5 - 60 !";
                    document.getElementById('txtScheduleTitle').focus();
                    status = false;
                    return false;
                } else if (!scheduleTitle.match(alphaExp)) {
                    document.getElementById('scheduleError').innerHTML
                            = "<img src='assets/images/unchecked.gif'/> Schedule Title Invalid !";
                    document.getElementById('txtScheduleTitle').focus();
                    status = false;
                    return false;
                } else {
                    document.getElementById('scheduleError').innerHTML
                            = "<img src='assets/images/checked.gif'/>";

                    if (content.replace(/^\s+/g, '').length === 0) {
                        document.getElementById('contentError').innerHTML
                                = "<img src='assets/images/unchecked.gif'/> Please Enter Content !";
                        document.getElementById('txtAreaContent').focus();
                        status = false;
                        return false;
                    } else if (!content.match(alphaExp)) {
                        document.getElementById('contentError').innerHTML
                                = "<img src='assets/images/unchecked.gif'/> Content Invalid !";
                        document.getElementById('txtAreaContent').focus();
                        status = false;
                        return false;
                    } else {
                        document.getElementById('contentError').innerHTML
                                = "<img src='assets/images/checked.gif'/>";
                        status = true;
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
                            <li class="active">Schedule Update</li>
                            <li class="active">Schedule Update Extra</li>
                        </ul><!-- /.breadcrumb -->
                    </div>	
                    <!------------------------------------------------ PAGE CONTENT BEGINS ------------------------------------------->
                    <div class="container" style="width: 1025px;">
                        <form name="formScheduleUpdateFormExtra" action="AdminTour_Schedule_Add_Update_Delete_Extra_Controller" method="post" onsubmit="return validateForm();">
                            <center>
                                <label style="margin-top: 10px; margin-left: auto; font-size: 25px; color: #00BE67; text-align: center">
                                    ${requestScope.tourTitle}</label>
                            </center>
                            <input type="hidden" name="txtTourID" value="${requestScope.tourID}"/>
                            <input type="hidden" name="txtScheduleID" value="${requestScope.schedule.scheduleID}"/>

                            <div style="width: 1000px; height: auto; border: 1px solid; margin-left: 5px; margin-top: 25px;" class="well">
                                <label style="margin-left: 50px; width: 60px; text-align: center">Title:</label>

                                <input name="txtScheduleTitle" id="txtScheduleTitle" style=" margin-left: 100px;width: 500px; margin-bottom: 10px; padding: 10px;" type="text" value="${requestScope.schedule.summary}"/>
                                <label id="scheduleError" style="color: red; width: 230px;"></label>
                                <table>
                                    <tr>
                                        <td>
                                            <!--Image Upload-->
                                            <div class="file-upload">
                                                <button class="file-upload-btn" type="button" onclick="$('.file-upload-input').trigger('click')">
                                                    Change Image
                                                </button>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="file-upload-content" style="margin-left: 65px;">
                                                <img class="file-upload-image" src="assets/images/${requestScope.schedule.image1}" alt="your image" />
                                            </div>
                                        </td>
                                        <td>
                                            <div class="image-upload-wrap">
                                                <input class="file-upload-input" name="txtImage" src="${requestScope.schedule.image1}" type='file' onchange="readURL(this);" accept="image/*" />
                                            </div>
                                        </td>
                                    </tr>
                                    <link rel="stylesheet" href="assets/css/style_Image_EditTourPackage.css">
                                    <!--<script class="jsbin" src="assets/js/jquery.min.js"></script>-->
                                    <script src="assets/js/index_Image_EditTourPackage.js"></script>
                                </table>

                                <div>
                                    <div style="width: 110px; margin-left: 50px">Content:</div>
                                    <span id="contentError" style="color: red;"></span>
                                    <br/>
                                    <textarea name="txtAreaContent" id="txtAreaContent" style="width: 980px; height: 350px; overflow: scroll; resize: none;">
                                        ${requestScope.schedule.content}
                                    </textarea><br/><br/>
                                    <center>
                                        <button name="action" value="btnUpdateSchedule_Extra" type="submit" class="btn-info" style=" width: 100px; font-size: 16px;" onclick="return isValid()">
                                            <i class="fa fa-edit"> Edit</i>
                                        </button>
                                    </center>
                                </div>
                            </div>
                        </form>
                        <center>
                            <div class="well" style="margin-left: 5px;">
                                <form id="formScheduleUpdateFormExtra" action="AdminTour_Schedule_Add_Update_Delete_Extra_Controller" method="post">
                                    <input type="hidden" name="txtTourID" value="${requestScope.tourID}"/>
                                    <input type="hidden" name="txtScheduleID" value="${requestScope.schedule.scheduleID}"/>
                                    <button style="width: 100px; font-size: 16px;" type="submit" name="action" value="btnResetScheduleUpdateFormExtra">
                                        <i class="fa fa-history"> Reset</i>
                                    </button>

                                    <button class="btn-danger" type="submit" name="action" value="btnCancelUpdateForm_Extra" style="margin-left: 200px; width: 100px; font-size: 16px;">
                                        <i class="fa"> Cancel</i>
                                    </button>
                                </form>
                            </div>
                        </center>
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
