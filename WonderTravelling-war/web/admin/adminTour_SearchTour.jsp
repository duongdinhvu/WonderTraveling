
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

        <script src="assets/js/admintour_SearchTour.js"></script>

        <script type="text/javascript">
            $(function() {
                $("#datepicker").datepicker({
                    //format and contraint datepicker
                    dateFormat: 'dd-mm-yy', minDate: 0, showButtonPanel: true
                });
                $("#datepicker").datepicker('setDate', new Date());
            });
        </script>

        <script type="text/javascript">
            function showTourDetail(no) {
                var tourId = $('#tourId' + no).val();
                var tourTitle = $('#tourTitle' + no).val();
                var tourCategoryName = $('#tourCategoryName' + no).val();
                var destination = $('#destination' + no).val();
                var groupPrice = $('#groupPrice' + no).val();
                var oddPrice = $('#oddPrice' + no).val();
                var hotelRank = $('#hotelRank' + no).val();
                var departureDates = $('#departureDates' + no).val();
                var departurePoint = $('#departurePoint' + no).val();
                var transport = $('#transportation' + no).val();
                var duration = $('#duration' + no).val();
                var availableTicket = $('#availableTicket' + no).val();
                var status = $('#status' + no).val();
                var createDate = new Date($('#createDate' + no).val());
                var image = $('#image' + no).val();

                $('#pTourTitle').html(tourTitle);
                $('#pTourId').val(tourId);
                $('#pCategoryName').val(tourCategoryName);
                $('#pDestination').val(destination);
                $('#pImage').attr('src', 'assets/images/' + image);
                $('#pGroupPrice').val(groupPrice);
                $('#pOddPrice').val(oddPrice);
                $('#pHotelRank').val(hotelRank);
                $('#pDepartureDates').html(departureDates);
                $('#pDeparturePoint').val(departurePoint);

                if (transport == '1') {
                    $('#pTransportation').val('Air Plane');
                } else if (transport == '2') {
                    $('#pTransportation').val('Bus');
                } else {
                    $('#pTransportation').val('Bus, Air Plane');
                }

                if (status == 'True') {
                    $('#pStatus').val('Activate');
                } else {
                    $('#pStatus').val('Deactivate');
                }

                $('#pDuration').val(duration + ' Day(s) ' + parseInt(duration - 1) + ' Night(s)');
                $('#pAvailableTicket').val(availableTicket);

                var date = createDate.getDate();

                var month = createDate.getMonth();

                var year = createDate.getFullYear();
                $('#pCreatedDate').text(date + "/" + month + "/" + year);

                $("#myModal").modal('show');
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
                            <li class="active">Search Tour Packages</li>
                        </ul><!-- /.breadcrumb -->
                    </div>	
                    <!------------------------------------------------ PAGE CONTENT BEGINS ------------------------------------------->
                    <div style="width: 1025px; margin-left: 5px; margin-top: 10px;" class="container">
                        <div class="row">
                            <div class="col-sm-3">
                                <label>Departure</label><br/>
                                <select style="width: 150px;" id="txtSlDeparture">
                                    <option>Ho Chi Minh City</option>
                                </select><br/><br/>

                                <label>Destination</label><br/>
                                <select style="width: 150px;" id="txtSldestionation">
                                    <c:forEach items="${sessionScope.listDestination}" var="des">
                                        <option value="${des}" ${des == 'Vung tau' ? 'selected="selected"' : ''}>${des}</option>
                                    </c:forEach>
                                </select><br/><br/>

                                <label>Departure Date</label><br/>
                                <input type="text" id="datepicker" style="width: 150px;" class="txtDepartureDate"/><br/><br/>
                                <button id="btnSearch">Search</button>
                            </div>

                            <div class="col-sm-9" id="result-search">
                                <c:forEach items="${requestScope.listTour}" var="tour" varStatus="no">
                                    <div class="col-sm-3" style=" margin-bottom: 10px;">
                                        <div style="margin-top: 5px;">
                                            <a href="#">
                                                <img style="width: 170px; height: 100px;" alt="" src="assets/images/${tour.image}">
                                            </a>
                                            <div>
                                                <div><a href="#" style="font-weight: bold" onclick="showTourDetail(${no.count});">${tour.tourTitle}</a></div>

                                                <input type="hidden" value="${tour.tourID}" id="tourId${no.count}"/>
                                                <input type="hidden" value="${tour.tourTitle}" id="tourTitle${no.count}"/>
                                                <input type="hidden" value="${tour.tourCategoryID.tourCategoryName}" id="tourCategoryName${no.count}"/>

                                                <input type="hidden" value="${tour.headingTo}" id="destination${no.count}"/>
                                                <input type="hidden" value="${tour.evenTourPrice}" id="groupPrice${no.count}"/>
                                                <input type="hidden" value="${tour.oddTourPrice}" id="oddPrice${no.count}"/>
                                                <input type="hidden" value="${tour.hotelRank}" id="hotelRank${no.count}"/>
                                                <input type="hidden" value="${tour.depatureDay}" id="departureDates${no.count}"/>
                                                <input type="hidden" value="${tour.depaturePoint}" id="departurePoint${no.count}"/>
                                                <input type="hidden" value="${tour.transportation}" id="transportation${no.count}"/>
                                                <input type="hidden" value="${tour.duration}" id="duration${no.count}"/>
                                                <input type="hidden" value="${tour.tickets}" id="availableTicket${no.count}"/>
                                                <input type="hidden" value="${tour.status}" id="status${no.count}"/>
                                                <input type="hidden" value="${tour.createdDate}" id="createDate${no.count}"/>
                                                <input type="hidden" value="${tour.image}" id="image${no.count}"/>

                                                <div>
                                                    <div>Duration / ${tour.duration} days</div>                                                     
                                                </div>
                                                <div>
                                                    <span style="">Odd Price/ </span>
                                                    <b>${tour.oddTourPrice}</b>
                                                    <span>USD</span>
                                                </div>
                                                <div>
                                                    <span>Group Price/ </span>
                                                    <b>${tour.evenTourPrice}</b>
                                                    <span>USD</span>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </c:forEach>
                            </div>

                            <!--START POP UP-->
                            <div id="myModal" class="modal fade" style="height: auto;">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><img src="assets/images/close.png"/></button>
                                            <center><h4 style="color: #00BE67;" id="pTourTitle"></h4></center>
                                        </div>

                                        <div class="modal-body">

                                            <label style="width: 200px;">Tour ID: </label><input type="text" id="pTourId" readonly="true" style="color: #0092ef; background: #ffffff; text-align: center;"/><br/><br/>

                                            <label style="width: 200px;">Tour Category Name: </label><input type="text" id="pCategoryName" readonly="true" style="color: #0092ef; text-align: center;"/><br/><br/>

                                            <label style="width: 200px;">Destination: </label><input type="text" id="pDestination" readonly="true" style="color: #0092ef; text-align: center;"/><br/>

                                            <table style="margin-bottom: 7px;">
                                                <tr>
                                                    <td>
                                                        <label>Representative Image:</label>
                                                    </td>
                                                    <td>
                                                        <input style="width: 240px; height: 150px; margin-left: 40px; margin-top: 10px;" type="image" id="pImage"/>
                                                    </td>
                                                </tr>
                                            </table>

                                            <label style="width: 200px;">Group Tour Price: </label><input type="text" id="pGroupPrice" readonly="true" style="color: #0092ef; text-align: center;"/><br/><br/>

                                            <label style="width: 200px;">Odd Tour Price: </label><input type="text" id="pOddPrice" readonly="true" style="color: #0092ef; text-align: center;"/><br/><br/>

                                            <label style="width: 200px;">Hotel Rank: </label><input type="text" id="pHotelRank" readonly="true" style="color: #0092ef; text-align: center;"/><br/><br/>

                                            <table style="margin-bottom: 7px;">
                                                <tr>
                                                    <td>
                                                        <label style="width: 200px;">Departure Dates: </label>
                                                    </td>
                                                    <td>
                                                        <textarea type="text" id="pDepartureDates" readonly="true" style="width: 320px; resize: none; height: 160px; overflow: scroll; color: #0092ef;"></textarea>
                                                    </td>
                                                </tr>
                                            </table>                                                                                      

                                            <label style="width: 200px;">Departure Point: </label><input type="text" id="pDeparturePoint" readonly="true" style="color: #0092ef; text-align: center; width: 195px"/><br/><br/>
                                            <label style="width: 200px;">Transportation: </label><input type="text" id="pTransportation" readonly="true" style="color: #0092ef; text-align: center; width: 195px"/><br/><br/>

                                            <label style="width: 200px;">Duration: </label><input type="text" id="pDuration" readonly="true" style="color: #0092ef; text-align: center; width: 195px"/><br/><br/>
                                            <label style="width: 200px;">Available Ticket: </label><input readonly="true" id="pAvailableTicket" type="text" style="color: #0092ef; text-align: center; width: 195px"/><br/><br/>

                                            <label style="width: 200px;">Status: </label><input type="text" id="pStatus" readonly="true" style="color: #0092ef; text-align: center; width: 195px"/>
                                            <label style="width: 200px;">Created Date: </label><label id="pCreatedDate" style="width: 200px; margin-left: 50px; color: #0092ef;"></label>

                                        </div>

                                        <div class="modal-footer">
                                            <center><button type="button" class="btn btn-default" data-dismiss="modal">Close</button></center>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--END POP UP-->

                            <div class="pagination" style="margin-left: 20px;">
                                <c:if test="${requestScope.TotalPage gt 1}">

                                    <c:if test="${requestScope.CurrentPage gt 1}">
                                        <a href="AdminTour_PaginationController?txtCurrentPage=1" class="btn" style=" border-radius: 5px;">First</a>
                                        <a href="AdminTour_PaginationController?txtCurrentPage=${requestScope.CurrentPage - 1}" class="btn" style=" border-radius: 5px;">Previous</a>
                                    </c:if>
                                    <c:forEach begin="${requestScope.StartPage}" end="${requestScope.EndPage}"
                                               var="pages" step="1">
                                        <a href="AdminTour_PaginationController?txtCurrentPage=${pages}" class="btn" style=" border-radius: 5px;">${pages}</a> 
                                    </c:forEach>
                                    <c:if test="${requestScope.CurrentPage lt requestScope.TotalPage}">
                                        <a href="AdminTour_PaginationController?txtCurrentPage=${requestScope.CurrentPage + 1}" class="btn" style=" border-radius: 5px;">Next</a>
                                        <a href="AdminTour_PaginationController?txtCurrentPage=${requestScope.TotalPage}" class="btn" style=" border-radius: 5px;">Last</a>
                                    </c:if>
                                </c:if>
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
