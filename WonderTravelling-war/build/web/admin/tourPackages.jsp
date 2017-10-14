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
        <link rel="stylesheet" href="assets/css/jquery.dataTables.min.css"/>
        <script type="text/javascript" src="assets/js/jquery.js"></script>

        <script src="assets/js/jquery-2.1.4.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/ace-elements.min.js"></script>
        <script src="assets/js/ace.min.js"></script>      
        <script type="text/javascript" src="assets/js/jquery.dataTables.min.js"></script>
        <!--dataTable Extra-->
        <link rel="stylesheet" href="assets/css/responsive.dataTable.min.css"/>
        <script src="assets/js/dataTables.responsive.min.js"></script>

        <script src="assets/js/jquery-ui.min.js"></script>
        <script>
            function assignId(no) {
                var tourid = $('#txtTourIdChangeStatus' + no).val();
                //alert(tourid);
                $.ajax({
                    type: 'POST',
                    url: 'AdminTour_TourInsert_Controller?action=changeStatus',
                    data: {"txtTourIdOnChange": tourid}
                });

            }
            ;
        </script>

        <script>
            $(document).ready(function() {
                var checkStatus = $('#txtCheckStatus').val();
                if (checkStatus == '1') {
                    $("#myModal").modal('show');
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
                            <img style="margin-top: 3px;" src="assets/images/avatars/user.jpg" />
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
                        </ul><!-- /.breadcrumb -->
                    </div>	
                    <!------------------------------------------------ PAGE CONTENT BEGINS ---------------------------------------------->
                    <div class="container" style="width: 900px;">
                        <div class="row header" style="text-align:center;color:green">
                            <h3>Tour Packages</h3>
                            <div style="margin-left: 800px;">
                                <form action="AdminTour_TourInsert_Controller" method="post">
                                    <button name="action" value="InsertLink"><i class="fa fa-plus-circle" aria-hidden="true"></i> Add New</button>
                                </form>
                            </div>
                        </div>
                        <table id="myTable" class="table table-striped table-hover">  
                            <thead>  
                                <tr>
                                    <th>Tour ID</th>  
                                    <th>Tour Name</th>
                                    <th>Tour Category</th>
                                    <th>Status</th>  
                                    <th></th>
                                    <th></th>
                                    <th></th>
                                </tr>  
                            </thead>  
                            <tbody>  
                                <c:forEach items="${requestScope.list}" var="Tours" varStatus="Num">
                                    <tr>
                                        <td>${Tours.tourID}</td>  
                                        <td>${Tours.tourTitle}</td>
                                        <td><span style="color: #0490A6; font-weight: bold;">${Tours.tourCategoryID.tourCategoryName}</span></td>
                                        <td>
                                            <c:if test="${Tours.status eq 'true'}"><span class="label label-success">Active</span></c:if>
                                            <c:if test="${Tours.status eq 'false'}"><span class="label label-danger">Deactive</span></c:if>
                                            </td>

                                            <td style="width: 35px;">
                                                <form action="AdminTour_TourDetail_Controller" method="post">
                                                    <input type="hidden" value="${Tours.tourID}" name="txtTourIDDetail"/>
                                                <button style="border-bottom-left-radius: 3px; border-bottom-right-radius: 3px; border-top-left-radius: 3px; border-top-right-radius: 3px;"
                                                        name="action" value="btnTourPackageDetail" type="submit" class="btn btn-sm btn-success btncustom" id="btnTourDetail">
                                                    <i class="fa fa-eye" aria-hidden="true"> Detail</i>
                                                </button>
                                            </form>
                                        </td>

                                        <td style="width: 35px;">
                                            <form action="AdminTour_Tour_Update_Controller" method="post">
                                                <input type="hidden" value="${Tours.tourID}" name="txtTourIDUpdate"/>
                                                <button style="border-bottom-left-radius: 3px; border-bottom-right-radius: 3px; border-top-left-radius: 3px; border-top-right-radius: 3px;"
                                                        type="submit" name="action" value="btnUpdate_tourPackages" class="btn btn-sm btn-warning btncustom">
                                                    <i class="fa fa-edit" aria-hidden="true"></i>
                                                </button>
                                            </form>
                                        </td>

                                        <td>
                                            <form action="AdminTour_Tour_ChangeStatus_Controller" method="post">
                                                <input type="hidden" value="${requestScope.checkStatus}" id="txtCheckStatus"/>
                                                <input type="hidden" value="${Tours.tourID}" id="txtTourIdChangeStatus${Num.count}" name="txtTourIdChangeStatus"/>
                                                <input type="hidden" value="${Tours.status}" name="txtTourStatus"/>
                                                <button id="btnChangeStatus" style="border-bottom-left-radius: 3px; border-bottom-right-radius: 3px; border-top-left-radius: 3px; border-top-right-radius: 3px;"
                                                        type="submit" onclick="assignId(${Num.count});
                                                                return confirm('Sure You Want To Change Its Status ?');"
                                                        class="btn btn-sm btn-danger btncustom">
                                                    Change Status
                                                </button>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>  
                            </tbody>  
                        </table>

                    </div>

                    <!--START POP UP-->
                    <div id="myModal" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><img src="assets/images/close.png"></button>
                                    <center><h4 class="modal-title" style="color: #0092ef;">Confirm</h4></center>
                                </div>

                                <div class="modal-body">
                                    <center><label style="margin-bottom: 7px;">You Need To Extra Schedule, Done It Now ?</label></center>
                                </div>

                                <div class="modal-footer">                        
                                    <center>
                                        <table>
                                            <tr>
                                                <td>
                                                    <form action="AdminTour_TourInsert_Controller" method="post">
                                                        <input type="hidden" name="maxSchedule" value="${requestScope.maxSchedule}"/>
                                                        <button type="submit" name="action"  value="btnCreateScheduleLate" class="btn btn-default">Yes</button>
                                                    </form>
                                                </td>
                                                <td>
                                                    <button style="margin-left: 150px;" type="button" class="btn btn-default" data-dismiss="modal">No</button>
                                                </td>
                                            </tr>
                                        </table>

                                    </center>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--END POP UP-->

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
    <script type="text/javascript">
        $(document).ready(function() {
            var table = $('#myTable').DataTable({
                "columnDefs": [
                    {"visible": false, "targets": 2}
                ],
                "order": [[2, 'asc']],
                "displayLength": 10,
                "drawCallback": function(settings) {
                    var api = this.api();
                    var rows = api.rows({page: 'current'}).nodes();
                    var last = null;

                    api.column(2, {page: 'current'}).data().each(function(group, i) {
                        if (last !== group) {
                            $(rows).eq(i).before(
                                    '<tr class="group"><td colspan="7">' + group + '</td></tr>'
                                    );

                            last = group;
                        }
                    });
                }
            });
            // Order by the grouping
            $('#myTable tbody').on('click', 'tr.group', function() {
                var currentOrder = table.order()[0];
                if (currentOrder[0] === 2 && currentOrder[1] === 'asc') {
                    table.order([2, 'desc']).draw();
                }
                else {
                    table.order([2, 'asc']).draw();
                }
            });
        });
    </script>
</html>
