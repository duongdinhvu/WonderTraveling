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

        <script type="text/javascript">
            function validate() {
                var categoryName = document.formEditTourCategory.txtTourCategoryName.value;
                var destination = document.formEditTourCategory.txtTourCategoryDestination.value;
                var status = false;

                var alphaExp = /[a-zA-Z.,-]/;

                if (categoryName.replace(/^\s+/g, '').length === 0) {
                    document.getElementById('tourCategoryNameError').innerHTML
                            = "<img src='assets/images/unchecked.gif'/><br/> Category Name Is Required!!";
                    document.getElementById('tourCategoryName').focus();
                    status = false;
                } else if (!categoryName.match(alphaExp)) {
                    document.getElementById('tourCategoryNameError').innerHTML
                            = "<img src='assets/images/unchecked.gif'/><br/> Category Name Invalid, Letters Only !";
                    document.getElementById('tourCategoryName').focus();
                    status = false;
                } else if (categoryName.replace(/^\s+/g, '').length < 5 || categoryName.replace(/^\s+/g, '').length > 60) {
                    document.getElementById('tourCategoryNameError').innerHTML
                            = "<img src='assets/images/unchecked.gif'/><br/> Category Name Must Be Between 5 - 60 !";
                    document.getElementById('tourCategoryName').focus();
                    status = false;
                } else {
                    document.getElementById('tourCategoryNameError').innerHTML
                            = "<img src='assets/images/checked.gif'/>";
                    status = false;
                    if (destination === "") {
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
                if (isOk === true) {
                    return confirm('Sure You Want To Change Information ?');
                } else {
                    return false;
                }
            }
        </script>

        <script type="text/javascript">
            $(document).ready(function() {
                var Update_DestinationString = "";
                //get tourCategoryDestination from Edit button
                var tourCategoryDestination = $('#tourCategoryDestination').val();
                //split tourCategoryName array into another array named desArray
                var desArray = tourCategoryDestination.split(', ');
                //create Destination Type CheckBox
                $.each(desArray, function(index, element) {
                    $('#divcbx').append('<b id="b_CheckBoxes_Update"><input type="checkbox" name="ckbUpdate" id="' + element + '" value="' + element + '"/>&nbsp;' + element + "&nbsp;&nbsp;&nbsp;</b>");
                });
                //assign Event when select items in Select Box
                $('#selectBoxDestination').change(selectBox);
                //Assign Event when click button Remove
                $('#btnDeleteDestination').click(Update_DeleteCheckBox);
                //Add CheckBox for id="cbx" when select provinces in select Box
                function selectBox() {
                    //Add Provinces in texarea tag has id="cbx" to an array named array
                    var array = new Array();
                    $('#b_CheckBoxes_Update input').each(function() {
                        array.push($(this).val());
                    });
                    var i = 0;
                    //check if province is already selected
                    $.each(array, function(index, item) {
                        if (($('#selectBoxDestination option:selected').text()).toString() === item.toString()) {
                            i++;
                        }
                    });
                    if (i > 0) {
                        alert($('#selectBoxDestination option:selected').text() + ' Province Is Alread Selected !');
                        return false;
                    } else {
                        var str = $('#selectBoxDestination option:selected').text().toString();
                        $('#divcbx').append('<b id="b_CheckBoxes_Update"><input type="checkbox" name="ckbUpdate"  id="' + str + '" value="' + str + '"/>&nbsp;' + str + '&nbsp;&nbsp;&nbsp;</b>');
                        getCheckBoxValues_Update();
                        return false;
                    }
                }
                // remove checked checkboxes when click on button Remove
                function Update_DeleteCheckBox() {
                    //get list Of Destination Is Already Generated Of Book
                    var stringOfDesGenerated = $('#stringOfDesGenerated').val();
                    var arrayOfDesGenerated = stringOfDesGenerated.split(', ');
                    var arrayOfChecked = new Array();
                    var i = 0;
                    //check if no of checked checkbox
                    if (($('input[name=ckbUpdate]:checked').length) === 0) {
                        alert('please select the ones want to remove !');
                        //check if checkBoxs checked that contain destionation is already Booked
                    } else {

                        $('input[name="ckbUpdate"]:checked').each(function() {
                            arrayOfChecked.push(($(this).val()));
                        });

                        $.each(arrayOfChecked, function(index, el) {
                            $.each(arrayOfDesGenerated, function(j, element) {
                                if (element === el) {
                                    i++;
                                }
                            });
                        });

                        if (i > 0) {
                            alert('Destination: ' + stringOfDesGenerated + ' Is\Are Already Generated Of Booking, Please Select Again !');
                            return false;
                        } else {
                            var check = confirm('Sure You Want To Delete This\These Destination ?');
                            if (check === true) {
                                $('input[name="ckbUpdate"]:checked').parent($('#b_CheckBoxes_Update')).remove();
                                getCheckBoxValues_Update();
                            } else {
                                return false;
                            }
                        }
                    }
                    return false;
                }

                function getCheckBoxValues_Update() {
                    //reset destination value
                    Update_DestinationString = "";
                    $('[name="ckbUpdate"]').each(function() {
                        Update_DestinationString += ($(this).val()) + ', ';
                    });
                    $('#tourCategoryDestination').val(Update_DestinationString);
                    //alert(Update_DestinationString);
                    //return false;
                }
            });</script>
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
                            <li class="active">Tour Category</li>
                            <li class="active">Tour Category Update</li>
                        </ul><!-- /.breadcrumb -->
                    </div>	
                    <!------------------------------------------------ PAGE CONTENT BEGINS ------------------------------------------->
                    <div class="container" style="width: 800px; margin-left: 50px;">
                        <div>
                            <h4 style="color: #0092ef; margin-left: 150px;">Edit Tour Category</h4>
                        </div><br/>
                        <form action="AdminTour_TourCategoryUpdate_Controller" method="post" name="formEditTourCategory" onsubmit="validate()">
                            <input type="hidden" id="stringOfDesGenerated" name="stringOfDesGenerated" value="${requestScope.stringOfDesGenerated}"/>
                            <label style="width: 200px;"><span>Tour Category ID</span></label>                                
                            <input id="tourCategoryID" style="text-align: center;" readonly="true" name="txtTourCategoryID" type="text" value="${requestScope.tourcategory.tourCategoryID}"/>
                            <br/><br/>
                            <label style="width: 200px;">
                                <span>Tour Category Name</span>
                            </label>

                            <!--DESTINATION TOOK FROM AdminTour_TourCategoryUpdate_Controller-->
                            <input id="tourCategoryName" name="txtTourCategoryName" type="text" value="${requestScope.tourcategory.tourCategoryName}"/>
                            <span id="tourCategoryNameError" style=" color:red;"></span>
                            <input id="tourCategoryDestination" name="txtTourCategoryDestination" type="hidden" value="${requestScope.tourcategory.destination}"/><br/><br/>

                            <label style="width: 200px;">
                                <span id="Des">Destination List</span>
                            </label>
                            <span id="destinationError" style="color: red; width: 300px; margin-left: 30px;"></span>
                            <div style="width: 500px; height: 150px; border: 1px #00BE67 solid; overflow: scroll;" id="divcbx">
                            </div>
                            <button style="margin-left: 433px; font-size: 13px; margin-top: 5px;" class="btn-info" id="btnDeleteDestination">Remove</button><br/><br/>
                            <!--DESTINATION AFTER SELECTED OR REMOVED-->


                            <table>
                                <tr>
                                    <td>
                                        <label>
                                            <span>Pick More Destination</span>
                                        </label><br/> 
                                    </td>
                                    <td>
                                        <select style="margin-left: 50px; width: 180px;" id="selectBoxDestination" name="txtSelectBoxDestination" style="width: 200px;">
                                            <c:forEach items="${requestScope.desString}" var="des">
                                                <option value="${des}">${des}</option>
                                            </c:forEach>                                  
                                        </select>
                                    </td>
                                </tr>
                            </table>
                            <div style="margin-top: 40px;">
                                <button type="submit" name="action" value="btnCancel" class="btn-danger" style="margin-left: 0px; width: 100px; font-size: 14px;">
                                    <i class="fa fa-window-close"> Cancel</i>
                                </button>

                                <button style="margin-left: 100px; width: 100px; font-size: 14px;" class="btn-info" onclick="return isValid();" value="btnUpdate_Action" name="action" type="submit">
                                    <i class="fa fa-edit"> Edit</i>
                                </button>

                                <button type="submit" name="action" value="btnReset" style="margin-left: 100px; width: 100px; font-size: 14px;" class="btn-default">
                                    <i class="fa fa-history"> Reset</i>
                                </button>
                            </div>
                        </form>
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
