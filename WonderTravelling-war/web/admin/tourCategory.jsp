<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Wonder Traveling Admin</title>
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
        <!--Select Box Scroll-->
        <link rel="stylesheet" href="assets/css/bootstrap-duallistbox.min.css" />
        <link rel="stylesheet" href="assets/css/bootstrap-multiselect.min.css" />
        <link rel="stylesheet" href="assets/css/select2.min.css" />
        <script src="assets/js/ace-extra.min.js"></script>

        <script type="text/javascript">
            function validate() {
                var categoryName = document.formCreateTourCategory.txtAdd_TourCateGoryName.value;
                var destination = document.formCreateTourCategory.txtAdd_Destination.value;
                var status = false;

                var alphaExp = /[a-zA-Z0-9.,-]/;

                if (categoryName.replace(/^\s+/g, '').length == 0) {
                    document.getElementById('tourCategoryNameError').innerHTML
                            = "<img src='assets/images/unchecked.gif'/><br/> Please enter Name !";
                    document.getElementById('txtInsertTourCateGoryName').focus();
                    status = false;
                } else if (!isNaN(categoryName)) {
                    document.getElementById('tourCategoryNameError').innerHTML
                            = "<img src='assets/images/unchecked.gif'/><br/> Cannot Only Digits !";
                    document.getElementById('txtInsertTourCateGoryName').focus();
                    status = false;
                } else if (!categoryName.match(alphaExp)) {
                    document.getElementById('tourCategoryNameError').innerHTML
                            = "<img src='assets/images/unchecked.gif'/><br/> Category Name Invalid !";
                    document.getElementById('txtInsertTourCateGoryName').focus();
                    status = false;
                } else if (categoryName.replace(/^\s+/g, '').length < 5 || categoryName.replace(/^\s+/g, '').length > 50) {
                    document.getElementById('tourCategoryNameError').innerHTML
                            = "<img src='assets/images/unchecked.gif'/><br/> Category Name Must Be Between 5 - 50 !";
                    document.getElementById('txtInsertTourCateGoryName').focus();
                    status = false;
                } else {
                    document.getElementById('tourCategoryNameError').innerHTML
                            = "<img src='assets/images/checked.gif'/>";
                    //status = true;
                    if (destination == "") {
                        document.getElementById('destinationError').innerHTML
                                = "<img src='assets/images/unchecked.gif'/> Please Select Destination !";
                        status = false;
                    } else {
                        document.getElementById('destinationError').innerHTML
                                = "<img src='assets/images/checked.gif'/>";
                        status = true;
                    }
                }

                return status;
            }
            ;

            function isValid() {
                var isOk = validate();
                if (isOk == true) {
                    return confirm('Sure You Want To Create Now ?');
                }
            }
        </script>

        <script type="text/javascript">
            function getTourList(no) {
                var tourCategoryId = $('#txtTourCategoryID' + no).val();
                $.ajax({
                    type: 'POST',
                    url: 'AdminTour_SearchItsToursController',
                    dateType: 'JSON',
                    data: {"tourCategoryId": tourCategoryId},
                    success: function(data) {
                        $('#itsTours').empty();
                        for (var i = 0; i < data.length; i++) {
                            $('#itsTours').append(
                                    "<tr>"
                                    + "<td style='width: 50px; text-align: center;'>" + (i + 1) + "</td>"
                                    + "<td style='width: 200px; text-align: center;'>" + data[i].tourID + "</td>"
                                    + "<td style='text-align: center;'>" + data[i].tourTitle + "</td>"
                                    + "</tr>"
                                    );
                        }

                        $("#myModal").modal('show');

                    },
                    error: function(request, status, error) {
                        if (request.status === 404) {
                            alert('No found data');
                        }
                    }
                });
            }
        </script>

        <script type="text/javascript">
            $(document).ready(function() {
                $('#lbDivSelect').hide();
                $('#Add_Deletebtn').hide();
            });
        </script>

        <!--Table Pagination-->
        <script type="text/css">
            .table-responsive {height:180px;}
        </script>
        <script type="text/javascript">
            $(document).ready(function() {

                $('#myTable').pageMe({pagerSelector: '#myPager', showPrevNext: true, hidePageNumbers: false, perPage: 5});

            });
        </script>
        <script type="text/javascript">
            $.fn.pageMe = function(opts) {
                var $this = this,
                        defaults = {
                            perPage: 7,
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
                        <i class="fa fa-check"></i>
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
                            <li class="active">Tour Category</li>
                        </ul><!-- /.breadcrumb -->
                    </div>	
                    <!------------------------------------------------ PAGE CONTENT BEGINS ---------------------------------------------->
                    <div style="width: 1025px;">
                        <div class="container" style="width: 1025px;">
                            <div class="row header" style="text-align:center; color:green">
                                <h3>Tour Category</h3>
                            </div>
                            <div class="row">
                                <div class="table-responsive">
                                    <table border="1" class="table table-hover" style="width: 900px; margin-left: auto; margin-right: auto" >  
                                        <thead>  
                                            <tr>  
                                                <th style="text-align: center;">Tour Category ID</th>  
                                                <th style="text-align: center;">Tour Category Name</th>  
                                                <th style="text-align: center;">Destination List</th>
                                                <th style="text-align: center;">Edit</th>
                                                <th style="text-align: center;">It's Tour List</th>
                                            </tr>  
                                        </thead>  
                                        <tbody id="myTable">
                                            <c:forEach items="${requestScope.list}" var="TourCategory" varStatus="No">
                                                <tr>
                                                    <td style="text-align: center;">${TourCategory.tourCategoryID}</td>
                                                    <td style="text-align: center;">${TourCategory.tourCategoryName}</td>
                                                    <td style="text-align: center;">${TourCategory.destination}</td>
                                                    <td style="text-align: center;">
                                                        <form action="AdminTour_TourCategoryUpdate_Controller" method="post">
                                                            <input type="hidden" name="txtTourCategoryIDUpdate" value="${TourCategory.tourCategoryID}"/>
                                                            <button class="btn-warning" type="submit" name="action" value="btnTourCategoryUpdate_Link">
                                                                <i class="fa fa-edit fa-align-center" aria-hidden="true"></i>
                                                            </button>
                                                        </form>
                                                    </td>
                                                    <td style="text-align: center;">
                                                        <button class="btn-app" id="txtTourCategoryID${No.count}" value="${TourCategory.tourCategoryID}" onclick="getTourList(${No.count});">
                                                            <i class="fa fa-list" aria-hidden="true"></i>
                                                        </button>
                                                    </td>
                                                </tr>
                                            </c:forEach>                                                              
                                        </tbody>  
                                    </table>
                                </div>
                                <div class="col-md-12 text-center">
                                    <ul class="pagination pagination-lg pager" id="myPager"></ul>
                                </div>

                                <!--START POP UP-->
                                <div id="myModal" class="modal fade" style="height: auto;">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><img src="assets/images/close.png"/></button>
                                                <center><h4 style="color: #00BE67;" id="pTourTitle">It's Tour List</h4></center>
                                            </div>

                                            <div class="modal-body">
                                                <table class="table table-striped table-hover">
                                                    <thead>
                                                    <th style="width: 50px; text-align: center;">*</th>
                                                    <th style="width: 200px; text-align: center;">Tour ID</th>
                                                    <th style="text-align: center;">Tour Name</th>
                                                    </thead>
                                                    <tbody id="itsTours">

                                                    </tbody>
                                                </table>
                                            </div>

                                            <div class="modal-footer">
                                                <center><button type="button" class="btn btn-default" data-dismiss="modal">Close</button></center>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--END POP UP-->

                            </div>                       
                        </div>

                        <!--CREATE NEW TOUR CATEGORY-->
                        <div style="width: 1025px; margin-left: 60px;">
                            <h3>Create New Category<font color="red">${requestScope.error}</font></h3>
                            <div style="margin-top: 20px;">
                                <form action="AdminTour_TourcategoryInsert_Controller" method="post" name="formCreateTourCategory" onsubmit="return validate();">
                                    <table>
                                        <tr>
                                            <td>
                                                <h4 style="color: #00BE67; margin-bottom: 20px;">
                                                    <i class="ace-icon fa fa-suitcase green" aria-hidden="true"></i>
                                                    Enter Information
                                                </h4>
                                            </td>
                                            <td style="width: 200px;">
                                                <label style="width: 200px; margin-left: 50px;">
                                                    <input type="text" id="txtInsertTourCateGoryName" name="txtAdd_TourCateGoryName" placeholder="Tour Category Name..." />
                                                </label>
                                                <label id="tourCategoryNameError" style=" margin-left: 20px;color:red; margin-left: 50px; width: 200px;"></label>
                                            </td>
                                            <td style="width: 200px;">
                                                <label style="margin-left: 30px; font-weight: bold;">Select Destination</label>
                                            </td>
                                            <td style="width: 200px;">
                                                <select id="Add_DestinationSelectBox" name="Add_DestinationSelectBox" style="width: 200px; height: 35px;">
                                                    <c:forEach items="${requestScope.desString}" var="des">
                                                        <option value="${des}">${des}</option>
                                                    </c:forEach>
                                                </select>
                                                <span id="destinationError" style="color: red; width: 200px;"></span>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td colspan="4">
                                                <label id="lbDivSelect" style="border: 2px #0490A6 solid; width: 500px; margin-left: 250px;">
                                                    <div id="Add_divSelectBox"></div> 
                                                </label><br/>
                                                <button style="margin-top: 10px; margin-left: 250px;" id="Add_Deletebtn" type="button">Remove</button><br/>
                                            </td>
                                        </tr>
                                    </table>



                                    <input type="hidden" id="DestinationServlet" name="txtAdd_Destination"/>

                                    <div style="margin-top: 20px; margin-left: 300px;">
                                            <button id="Add_btnCreate" style="width: 150px; background-color: #009ceb; color: whitesmoke; font-size: 15px; font-family: sans-serif" type="submit"  onclick="return isValid();">
                                                <i class="fa fa-plus-circle"> Create</i>
                                            </button>

                                    </div>

                                </form>


                            </div>
                        </div>
                    </div>

                    <!-- inline scripts related to this page -->
                    <script type="text/javascript">
                        jQuery(function($) {
                            var add_destinationString = "";
                            //Add CheckBox for id="cbx" when select provinces in select Box
                            $('#Add_DestinationSelectBox').change(selectBox);
                            // remove checked checkboxes when click on button Xóa
                            $('#Add_Deletebtn').click(deleteCheckBox);

                            function selectBox() {
                                $('#lbDivSelect').show();
                                $('#Add_Deletebtn').show();
                                //Add Provinces in div tag has id="cbx" to an array named array
                                var array = new Array();
                                $('#Add_divSelectBox input').each(function() {
                                    array.push($(this).val());
                                });
                                var i = 0;
                                //check if province is already selected
                                $.each(array, function(index, item) {
                                    if (($('#Add_DestinationSelectBox option:selected').text()) === item) {
                                        i++;
                                    }
                                });
                                if (i > 0) {
                                    alert($('#Add_DestinationSelectBox option:selected').text() + 'Already Selected !');
                                } else {
                                    var str = $('#Add_DestinationSelectBox option:selected').text().toString();
                                    $('#Add_divSelectBox').append('<b id="selectBox_Add"><input type="checkbox" name="ckb"  id="' + str + '" value="' + str + '"/>&nbsp;' + str + '&nbsp; &nbsp; &nbsp; &nbsp;</b>');
                                    getCheckBoxValues();
                                }
                            }
                            ;

                            function deleteCheckBox() {
                                //check if no of checked checkbox
                                if (($('#Add_divSelectBox input[name=ckb]:checked').length) === 0) {
                                    alert('Please Select Destination Want To Remove!');
                                    return false;
                                } else {
                                    $('#Add_divSelectBox input[name=ckb]:checked').parent($('#selectBox_Add')).remove();
                                    getCheckBoxValues();
                                    return false;
                                }
                            }

                            function getCheckBoxValues() {
                                add_destinationString = "";
                                $('[name="ckb"]').each(function() {
                                    add_destinationString += ($(this).val()) + ', ';
                                });
                                $('#DestinationServlet').val(add_destinationString);
                                //alert(add_destinationString);
                                return false;
                            }
                        });

                    </script>
                    <!-------------END CREATE NEW TOUR CATEGORY------------->
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
