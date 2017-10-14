<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <!--NEW-->
        <link rel="stylesheet" href="assets/css/ace-rtl.min.css" />
        <link rel="stylesheet" href="assets/css/jquery-ui.custom.min.css" />
        <link rel="stylesheet" href="assets/css/buttons.dataTables.min.css">
        <script type="text/javascript" src="assets/js/jquery.dataTables.min.js"></script>
        <script src="assets/js/ace-extra.min.js"></script>

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
                                <a href="#">
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
                                <a href="adminCarListController">Car</a>
                            </li>
                            <li class="active">Add New Car</li>
                        </ul><!-- /.breadcrumb -->
                    </div>	

                    <!------------------------------------------------ PAGE CONTENT BEGINS ------------------------------------------->

                    <div class="page-header">
                        <h1>
                            Add New Car
                        </h1>
                    </div><!-- /.page-header -->



                    <form class="form-horizontal" id="form" name="form" role="form" action="adminCarAddController" method="post" onsubmit="return valid();" >

                        <div class="form-group"> 
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Image </label>
                            <div class="col-sm-4">
                                <div class="widget-box">
                                    <div class="widget-body">
                                        <div class="widget-main">                                                     
                                            <div class="form-group">
                                                <div class="col-xs-12">
                                                    <input  type="file" id="id-input-file-3" accept="image/*" name="txtCarImage"  onchange="PreviewImage();" required="true" value=""  />


                                                    <input type="text" id="txtImg" style="height: max-content; width: 400px; border: 0" readonly="true" />
                                                    <span class="help-button" data-rel="popover" data-trigger="hover" data-placement="left" data-content="Image Only !" title="Required !">!</span>
                                                    <label type="text" id="message" style="height: 20px; width: 320px; font-family: serif; color: red;" ></label>

                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Car Name </label>

                            <div class="col-sm-9">
                                <input data-rel="tooltip" type="text" id="form-field-6" data-placement="bottom" name="txtCarName" required="true" pattern="[a-zA-Z0-9\s]{3,50}"
                                       oninvalid="this.setCustomValidity('Car Name must be with WORDS, in range between 3-50 words !')" 
                                       oninput="setCustomValidity('')" title="Car Name"  />
                                <span class="help-button" data-rel="popover" data-trigger="hover" data-placement="left" data-content="From 3 to 50 words !" title="Required !">!</span>
                            </div>
                        </div>                     

                        <div class="form-group">                                     
                            <div class="control-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> GPS </label>

                                <div class="col-sm-9 radio">
                                    <label>
                                        <input name="radGPS" type="radio" class="ace" value="true" checked="true" />
                                        <span class="col-xs-10 col-sm-5 lbl">Yes</span>
                                    </label>
                                    <label>
                                        <input name="radGPS" type="radio" class="ace" value="false" />
                                        <span class="col-xs-10 col-sm-5 lbl">No</span>
                                    </label>
                                </div>
                            </div>                                       
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Price </label>

                            <div class="col-sm-9">
                                <input data-rel="tooltip" type="number" id="form-field-6" min="1" max="999" data-placement="bottom" 
                                       step="0.001" title="Price" name="txtPrice" 
                                       required="true" oninvalid="this.setCustomValidity('Price must be a in range $1-999 !')" 
                                       oninput="setCustomValidity('')" title="Price"  />
                                <span class="help-button" data-rel="popover" data-trigger="hover" data-placement="left" data-content="Smaller than $1000 !" title="Required !">!</span>
                            </div>
                        </div>

                        <div class="form-group">                                     
                            <div class="control-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Push Chair </label>

                                <div class="col-sm-9 radio">
                                    <label>
                                        <input name="radChair" type="radio" class="ace" value="true" />
                                        <span class="col-xs-10 col-sm-5 lbl">Yes</span>
                                    </label>
                                    <label>
                                        <input name="radChair" type="radio" class="ace" value="false" checked="true" />
                                        <span class="col-xs-10 col-sm-5 lbl">No</span>
                                    </label>
                                </div>
                            </div>                                       
                        </div>


                        <div class="form-group">                                     
                            <div class="control-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Air Conditioning </label>

                                <div class="col-sm-9 radio">
                                    <label>
                                        <input name="radAir" type="radio" class="ace" value="true" checked="true" />
                                        <span class="col-xs-10 col-sm-5 lbl">Yes</span>
                                    </label>
                                    <label>
                                        <input name="radAir" type="radio" class="ace" value="false" />
                                        <span class="col-xs-10 col-sm-5 lbl">No</span>
                                    </label>
                                </div>
                            </div>                                       
                        </div>                       

                        <div class="form-group">
                            <div class="widget-body">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Number of Seats </label>
                                <div class="widget-main">
                                    <div class="control-group">
                                        <div class="row">
                                            <div class="col-xs-10 col-sm-5 lbl">
                                                <div class="knob-container inline">
                                                    <input  type="text" class="input-small knob" value="4" name="txtSeat" data-min="2" data-max="50" data-width="120" data-height="120" data-thickness=".2" data-fgcolor="#87B87F" data-displayprevious="true" data-anglearc="250" data-angleoffset="-125" />
                                                </div>
                                            </div>
                                        </div>                                           
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">                                     
                            <div class="control-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Tranmission </label>

                                <div class="col-sm-9 radio">
                                    <label>
                                        <input name="radTrans" type="radio" class="ace" value="automatic" checked="true" />
                                        <span class="col-xs-10 col-sm-5 lbl">Automatic</span>
                                    </label>
                                    <label>
                                        <input name="radTrans" type="radio" class="ace" value="manual" />
                                        <span class="col-xs-10 col-sm-5 lbl">Manual</span>
                                    </label>
                                </div>
                            </div>                                       
                        </div>

                        <div class="form-group">
                            <div class="widget-body">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Number of Doors </label>
                                <div class="widget-main">
                                    <div class="control-group">
                                        <div class="row">
                                            <div class="col-xs-10 col-sm-5 lbl">
                                                <div class="knob-container inline">
                                                    <input type="text" class="input-small knob" value="3" name="txtDoor" data-min="1" data-max="4" data-width="120" data-height="120" data-thickness=".2" data-fgcolor="#87B87F" data-displayprevious="true" data-anglearc="250" data-angleoffset="-125" />
                                                </div>
                                            </div>
                                        </div>                                           
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> License Plate </label>

                            <div class="col-sm-9">
                                <input data-rel="tooltip" type="text" id="form-field-6" data-placement="bottom" name="txtCarLic" title="License Plate" required="true" pattern="[a-zA-Z0-9\s]{7,50}"
                                       oninvalid="this.setCustomValidity('License Plate must be WORDS, in range between 7-50 words !')" 
                                       oninput="setCustomValidity('')"  />
                                <span class="help-button" data-rel="popover" data-trigger="hover" data-placement="left" data-content="From 7 to 50 words !" title="Required !">!</span>
                            </div>
                        </div> 


                        <div class="form-group">                                     
                            <div class="control-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Status </label>

                                <div class="col-sm-9 radio">
                                    <label>
                                        <input name="radStatus" type="radio" class="ace" value="true" />
                                        <span class="col-xs-10 col-sm-5 lbl">Available</span>
                                    </label>
                                    <label>
                                        <input name="radStatus" type="radio" class="ace" value="false" checked="true" />
                                        <span class="col-xs-10 col-sm-5 lbl">Disable</span>
                                    </label>
                                </div>
                            </div>                                       
                        </div>

                        <div class="space-4"></div>

                        <div class="clearfix form-actions">
                            <div class="col-md-offset-3 col-md-9">                                                           
                                &nbsp; &nbsp; &nbsp;  
                                <button class="btn btn-info" type="submit" name="action" value="add" id="btnSub" onclick="buttonSubmitClicked(event)" >
                                    <i class="ace-icon fa fa-check bigger-110"></i>
                                    Insert
                                </button>
                                &nbsp; &nbsp; &nbsp;
                                <button class="btn" type="reset" onclick="return confirm('Reset ? All Unsave Info Will Be Lost !')">
                                    <i class="ace-icon fa fa-undo bigger-110"></i>
                                    Reset
                                </button>
                            </div>
                        </div>
                    </form>


                    <script >
                        function valid() {

                            if (!document.getElementById("id-input-file-3").value) {
                                //event.preventDefault();
                                //alert("Must Select any of your photo for upload!");
                                //return false;
                            }
                            else {
                                var x = confirm('Are you sure ?');
                                if (x) {
                                    alert("Operation Successful !");
                                    return true;
                                }
                                else {
                                    return false;
                                }
                            }
                        }
                    </script>

                    <script >
                        function buttonSubmitClicked(event) {
                            if (!document.getElementById("id-input-file-3").value) {
                                event.preventDefault();
                                $('#message').html("Must Select any of your photo for upload !");
                                document.form.txtImg.focus();
                            }
                            if (document.getElementById("id-input-file-3").value) {
                                $('#message').html("");
                                document.form.message.focus();
                            }
                        }
                    </script>




                    <!--
                            if (!document.getElementsByName("txtCarName").value) {
                                event.preventDefault();
                                alert("Car Name is requried !");
                                document.form.txtCarName.focus();
                                return false;
                            }
                            if (!document.getElementsByName("txtPrice").value) {
                                event.preventDefault();
                                alert("Price is requried !");
                                document.form.txtPrice.focus();
                                return false;
                            }
                            if (!document.getElementsByName("txtCarLic").value) {
                                event.preventDefault();
                                alert("License Plate is requried !");
                                document.form.txtCarLic.focus();
                                return false;
                            }
                    -->





                    <!-- basic scripts -->

                    <!--[if !IE]> -->
                    <script src="assets/js/jquery-2.1.4.min.js"></script>

                    <!-- <![endif]-->

                    <!--[if IE]>
            <script src="assets/js/jquery-1.11.3.min.js"></script>
            <![endif]-->
                    <script type="text/javascript">
                        if ('ontouchstart' in document.documentElement)
                            document.write("<script src='assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
                        function PreviewImage() {
                            var oFReader = new FileReader();
                            oFReader.readAsDataURL(document.getElementById("uploadImage").files[0]);
                            oFReader.onload = function(oFREvent) {
                                document.getElementById("uploadPreview").src = oFREvent.target.result;
                            };
                        }
                        ;</script>
                    <script src="assets/js/bootstrap.min.js"></script>



                    <!-- page specific plugin scripts -->

                    <!--[if lte IE 8]>
                      <script src="assets/js/excanvas.min.js"></script>
                    <![endif]-->
                    <script src="assets/js/jquery-ui.custom.min.js"></script>
                    <script src="assets/js/jquery.ui.touch-punch.min.js"></script>
                    <script src="assets/js/chosen.jquery.min.js"></script>
                    <script src="assets/js/spinbox.min.js"></script>
                    <script src="assets/js/bootstrap-datepicker.min.js"></script>
                    <script src="assets/js/bootstrap-timepicker.min.js"></script>
                    <script src="assets/js/moment.min.js"></script>
                    <script src="assets/js/daterangepicker.min.js"></script>
                    <script src="assets/js/bootstrap-datetimepicker.min.js"></script>
                    <script src="assets/js/bootstrap-colorpicker.min.js"></script>
                    <script src="assets/js/jquery.knob.min.js"></script>
                    <script src="assets/js/autosize.min.js"></script>
                    <script src="assets/js/jquery.inputlimiter.min.js"></script>
                    <script src="assets/js/jquery.maskedinput.min.js"></script>
                    <script src="assets/js/bootstrap-tag.min.js"></script>

                    <!-- ace scripts -->
                    <script src="assets/js/ace-elements.min.js"></script>
                    <script src="assets/js/ace.min.js"></script>

                    <!-- inline scripts related to this page -->
                    <script type="text/javascript">
                        jQuery(function($) {
                            $('#id-disable-check').on('click', function() {
                                var inp = $('#form-input-readonly').get(0);
                                if (inp.hasAttribute('disabled')) {
                                    inp.setAttribute('readonly', 'true');
                                    inp.removeAttribute('disabled');
                                    inp.value = "This text field is readonly!";
                                }
                                else {
                                    inp.setAttribute('disabled', 'disabled');
                                    inp.removeAttribute('readonly');
                                    inp.value = "This text field is disabled!";
                                }
                            });
                            if (!ace.vars['touch']) {
                                $('.chosen-select').chosen({allow_single_deselect: true});
                                //resize the chosen on window resize

                                $(window)
                                        .off('resize.chosen')
                                        .on('resize.chosen', function() {
                                            $('.chosen-select').each(function() {
                                                var $this = $(this);
                                                $this.next().css({'width': $this.parent().width()});
                                            })
                                        }).trigger('resize.chosen');
                                //resize chosen on sidebar collapse/expand
                                $(document).on('settings.ace.chosen', function(e, event_name, event_val) {
                                    if (event_name != 'sidebar_collapsed')
                                        return;
                                    $('.chosen-select').each(function() {
                                        var $this = $(this);
                                        $this.next().css({'width': $this.parent().width()});
                                    })
                                });
                                $('#chosen-multiple-style .btn').on('click', function(e) {
                                    var target = $(this).find('input[type=radio]');
                                    var which = parseInt(target.val());
                                    if (which == 2)
                                        $('#form-field-select-4').addClass('tag-input-style');
                                    else
                                        $('#form-field-select-4').removeClass('tag-input-style');
                                });
                            }


                            $('[data-rel=tooltip]').tooltip({container: 'body'});
                            $('[data-rel=popover]').popover({container: 'body'});
                            autosize($('textarea[class*=autosize]'));
                            $('textarea.limited').inputlimiter({
                                remText: '%n character%s remaining...',
                                limitText: 'max allowed : %n.'
                            });
                            $.mask.definitions['~'] = '[+-]';
                            $('.input-mask-date').mask('99/99/9999');
                            $('.input-mask-phone').mask('(999) 999-9999');
                            $('.input-mask-eyescript').mask('~9.99 ~9.99 999');
                            $(".input-mask-product").mask("a*-999-a999", {placeholder: " ", completed: function() {
                                    alert("You typed the following: " + this.val());
                                }});
                            $("#input-size-slider").css('width', '200px').slider({
                                value: 1,
                                range: "min",
                                min: 1,
                                max: 8,
                                step: 1,
                                slide: function(event, ui) {
                                    var sizing = ['', 'input-sm', 'input-lg', 'input-mini', 'input-small', 'input-medium', 'input-large', 'input-xlarge', 'input-xxlarge'];
                                    var val = parseInt(ui.value);
                                    $('#form-field-4').attr('class', sizing[val]).attr('placeholder', '.' + sizing[val]);
                                }
                            });
                            $("#input-span-slider").slider({
                                value: 1,
                                range: "min",
                                min: 1,
                                max: 12,
                                step: 1,
                                slide: function(event, ui) {
                                    var val = parseInt(ui.value);
                                    $('#form-field-5').attr('class', 'col-xs-' + val).val('.col-xs-' + val);
                                }
                            });
                            //"jQuery UI Slider"
                            //range slider tooltip example
                            $("#slider-range").css('height', '200px').slider({
                                orientation: "vertical",
                                range: true,
                                min: 0,
                                max: 100,
                                values: [17, 67],
                                slide: function(event, ui) {
                                    var val = ui.values[$(ui.handle).index() - 1] + "";
                                    if (!ui.handle.firstChild) {
                                        $("<div class='tooltip right in' style='display:none;left:16px;top:-6px;'><div class='tooltip-arrow'></div><div class='tooltip-inner'></div></div>")
                                                .prependTo(ui.handle);
                                    }
                                    $(ui.handle.firstChild).show().children().eq(1).text(val);
                                }
                            }).find('span.ui-slider-handle').on('blur', function() {
                                $(this.firstChild).hide();
                            });
                            $("#slider-range-max").slider({
                                range: "max",
                                min: 1,
                                max: 10,
                                value: 2
                            });
                            $("#slider-eq > span").css({width: '90%', 'float': 'left', margin: '15px'}).each(function() {
                                // read initial values from markup and remove that
                                var value = parseInt($(this).text(), 10);
                                $(this).empty().slider({
                                    value: value,
                                    range: "min",
                                    animate: true

                                });
                            });
                            $("#slider-eq > span.ui-slider-purple").slider('disable'); //disable third item


                            $('#id-input-file-1 , #id-input-file-2').ace_file_input({
                                no_file: 'No File ...',
                                btn_choose: 'Choose',
                                btn_change: 'Change',
                                droppable: false,
                                onchange: null,
                                thumbnail: false //| true | large
                                        //whitelist:'gif|png|jpg|jpeg'
                                        //blacklist:'exe|php'
                                        //onchange:''
                                        //
                            });
                            //pre-show a file name, for example a previously selected file
                            //$('#id-input-file-1').ace_file_input('show_file_list', ['myfile.txt'])


                            $('#id-input-file-3').ace_file_input({
                                style: 'well',
                                btn_choose: 'Drop files here or click to choose',
                                btn_change: null,
                                no_icon: 'ace-icon fa fa-cloud-upload',
                                droppable: true,
                                thumbnail: 'small'//large | fit
                                        //,icon_remove:null//set null, to hide remove/reset button
                                        /**,before_change:function(files, dropped) {
                                         //Check an example below
                                         //or examples/file-upload.html
                                         return true;
                                         }*/
                                        /**,before_remove : function() {
                                         return true;
                                         }*/
                                ,
                                preview_error: function(filename, error_code) {
                                    //name of the file that failed
                                    //error_code values
                                    //1 = 'FILE_LOAD_FAILED',
                                    //2 = 'IMAGE_LOAD_FAILED',
                                    //3 = 'THUMBNAIL_FAILED'
                                    //alert(error_code);
                                }

                            }).on('change', function() {
                                //console.log($(this).data('ace_input_files'));
                                //console.log($(this).data('ace_input_method'));
                            });
                            //$('#id-input-file-3')
                            //.ace_file_input('show_file_list', [
                            //{type: 'image', name: 'name of image', path: 'http://path/to/image/for/preview'},
                            //{type: 'file', name: 'hello.txt'}
                            //]);




                            //dynamically change allowed formats by changing allowExt && allowMime function
                            $('#id-file-format').removeAttr('checked').on('change', function() {
                                var whitelist_ext, whitelist_mime;
                                var btn_choose
                                var no_icon
                                if (this.checked) {
                                    btn_choose = "Drop images here or click to choose";
                                    no_icon = "ace-icon fa fa-picture-o";
                                    whitelist_ext = ["jpeg", "jpg", "png", "gif", "bmp"];
                                    whitelist_mime = ["image/jpg", "image/jpeg", "image/png", "image/gif", "image/bmp"];
                                }
                                else {
                                    btn_choose = "Drop files here or click to choose";
                                    no_icon = "ace-icon fa fa-cloud-upload";
                                    whitelist_ext = null; //all extensions are acceptable
                                    whitelist_mime = null; //all mimes are acceptable
                                }
                                var file_input = $('#id-input-file-3');
                                file_input
                                        .ace_file_input('update_settings',
                                                {
                                                    'btn_choose': btn_choose,
                                                    'no_icon': no_icon,
                                                    'allowExt': whitelist_ext,
                                                    'allowMime': whitelist_mime
                                                })
                                file_input.ace_file_input('reset_input');
                                file_input
                                        .off('file.error.ace')
                                        .on('file.error.ace', function(e, info) {
                                            //console.log(info.file_count);//number of selected files
                                            //console.log(info.invalid_count);//number of invalid files
                                            //console.log(info.error_list);//a list of errors in the following format

                                            //info.error_count['ext']
                                            //info.error_count['mime']
                                            //info.error_count['size']

                                            //info.error_list['ext']  = [list of file names with invalid extension]
                                            //info.error_list['mime'] = [list of file names with invalid mimetype]
                                            //info.error_list['size'] = [list of file names with invalid size]


                                            /**
                                             if( !info.dropped ) {
                                             //perhapse reset file field if files have been selected, and there are invalid files among them
                                             //when files are dropped, only valid files will be added to our file array
                                             e.preventDefault();//it will rest input
                                             }
                                             */


                                            //if files have been selected (not dropped), you can choose to reset input
                                            //because browser keeps all selected files anyway and this cannot be changed
                                            //we can only reset file field to become empty again
                                            //on any case you still should check files with your server side script
                                            //because any arbitrary file can be uploaded by user and it's not safe to rely on browser-side measures
                                        });
                                /**
                                 file_input
                                 .off('file.preview.ace')
                                 .on('file.preview.ace', function(e, info) {
                                 console.log(info.file.width);
                                 console.log(info.file.height);
                                 e.preventDefault();//to prevent preview
                                 });
                                 */

                            });
                            $('#spinner1').ace_spinner({value: 0, min: 0, max: 200, step: 10, btn_up_class: 'btn-info', btn_down_class: 'btn-info'})
                                    .closest('.ace-spinner')
                                    .on('changed.fu.spinbox', function() {
                                        //console.log($('#spinner1').val())
                                    });
                            $('#spinner2').ace_spinner({value: 0, min: 0, max: 10000, step: 100, touch_spinner: true, icon_up: 'ace-icon fa fa-caret-up bigger-110', icon_down: 'ace-icon fa fa-caret-down bigger-110'});
                            $('#spinner3').ace_spinner({value: 0, min: -100, max: 100, step: 10, on_sides: true, icon_up: 'ace-icon fa fa-plus bigger-110', icon_down: 'ace-icon fa fa-minus bigger-110', btn_up_class: 'btn-success', btn_down_class: 'btn-danger'});
                            $('#spinner4').ace_spinner({value: 0, min: -100, max: 100, step: 10, on_sides: true, icon_up: 'ace-icon fa fa-plus', icon_down: 'ace-icon fa fa-minus', btn_up_class: 'btn-purple', btn_down_class: 'btn-purple'});
                            //$('#spinner1').ace_spinner('disable').ace_spinner('value', 11);
                            //or
                            //$('#spinner1').closest('.ace-spinner').spinner('disable').spinner('enable').spinner('value', 11);//disable, enable or change value
                            //$('#spinner1').closest('.ace-spinner').spinner('value', 0);//reset to 0


                            //datepicker plugin
                            //link
                            $('.date-picker').datepicker({
                                autoclose: true,
                                todayHighlight: true
                            })
                                    //show datepicker when clicking on the icon
                                    .next().on(ace.click_event, function() {
                                $(this).prev().focus();
                            });
                            //or change it into a date range picker
                            $('.input-daterange').datepicker({autoclose: true});
                            //to translate the daterange picker, please copy the "examples/daterange-fr.js" contents here before initialization
                            $('input[name=date-range-picker]').daterangepicker({
                                'applyClass': 'btn-sm btn-success',
                                'cancelClass': 'btn-sm btn-default',
                                locale: {
                                    applyLabel: 'Apply',
                                    cancelLabel: 'Cancel',
                                }
                            })
                                    .prev().on(ace.click_event, function() {
                                $(this).next().focus();
                            });
                            $('#timepicker1').timepicker({
                                minuteStep: 1,
                                showSeconds: true,
                                showMeridian: false,
                                disableFocus: true,
                                icons: {
                                    up: 'fa fa-chevron-up',
                                    down: 'fa fa-chevron-down'
                                }
                            }).on('focus', function() {
                                $('#timepicker1').timepicker('showWidget');
                            }).next().on(ace.click_event, function() {
                                $(this).prev().focus();
                            });
                            if (!ace.vars['old_ie'])
                                $('#date-timepicker1').datetimepicker({
                                    //format: 'MM/DD/YYYY h:mm:ss A',//use this option to display seconds
                                    icons: {
                                        time: 'fa fa-clock-o',
                                        date: 'fa fa-calendar',
                                        up: 'fa fa-chevron-up',
                                        down: 'fa fa-chevron-down',
                                        previous: 'fa fa-chevron-left',
                                        next: 'fa fa-chevron-right',
                                        today: 'fa fa-arrows ',
                                        clear: 'fa fa-trash',
                                        close: 'fa fa-times'
                                    }
                                }).next().on(ace.click_event, function() {
                                    $(this).prev().focus();
                                });
                            $('#colorpicker1').colorpicker();
                            //$('.colorpicker').last().css('z-index', 2000);//if colorpicker is inside a modal, its z-index should be higher than modal'safe

                            $('#simple-colorpicker-1').ace_colorpicker();
                            //$('#simple-colorpicker-1').ace_colorpicker('pick', 2);//select 2nd color
                            //$('#simple-colorpicker-1').ace_colorpicker('pick', '#fbe983');//select #fbe983 color
                            //var picker = $('#simple-colorpicker-1').data('ace_colorpicker')
                            //picker.pick('red', true);//insert the color if it doesn't exist


                            $(".knob").knob();
                            var tag_input = $('#form-field-tags');
                            try {
                                tag_input.tag(
                                        {
                                            placeholder: tag_input.attr('placeholder'),
                                            //enable typeahead by specifying the source array
                                            source: ace.vars['US_STATES'], //defined in ace.js >> ace.enable_search_ahead
                                            /**
                                             //or fetch data from database, fetch those that match "query"
                                             source: function(query, process) {
                                             $.ajax({url: 'remote_source.php?q='+encodeURIComponent(query)})
                                             .done(function(result_items){
                                             process(result_items);
                                             });
                                             }
                                             */
                                        }
                                )

                                //programmatically add/remove a tag
                                var $tag_obj = $('#form-field-tags').data('tag');
                                $tag_obj.add('Programmatically Added');
                                var index = $tag_obj.inValues('some tag');
                                $tag_obj.remove(index);
                            }
                            catch (e) {
                                //display a textarea for old IE, because it doesn't support this plugin or another one I tried!
                                tag_input.after('<textarea id="' + tag_input.attr('id') + '" name="' + tag_input.attr('name') + '" rows="3">' + tag_input.val() + '</textarea>').remove();
                                //autosize($('#form-field-tags'));
                            }


                            /////////
                            $('#modal-form input[type=file]').ace_file_input({
                                style: 'well',
                                btn_choose: 'Drop files here or click to choose',
                                btn_change: null,
                                no_icon: 'ace-icon fa fa-cloud-upload',
                                droppable: true,
                                thumbnail: 'large'
                            })

                            //chosen plugin inside a modal will have a zero width because the select element is originally hidden
                            //and its width cannot be determined.
                            //so we set the width after modal is show
                            $('#modal-form').on('shown.bs.modal', function() {
                                if (!ace.vars['touch']) {
                                    $(this).find('.chosen-container').each(function() {
                                        $(this).find('a:first-child').css('width', '210px');
                                        $(this).find('.chosen-drop').css('width', '210px');
                                        $(this).find('.chosen-search input').css('width', '200px');
                                    });
                                }
                            })
                            /**
                             //or you can activate the chosen plugin after modal is shown
                             //this way select element becomes visible with dimensions and chosen works as expected
                             $('#modal-form').on('shown', function () {
                             $(this).find('.modal-chosen').chosen();
                             })
                             */



                            $(document).one('ajaxloadstart.page', function(e) {
                                autosize.destroy('textarea[class*=autosize]')

                                $('.limiterBox,.autosizejs').remove();
                                $('.daterangepicker.dropdown-menu,.colorpicker.dropdown-menu,.bootstrap-datetimepicker-widget.dropdown-menu').remove();
                            });
                        });
                    </script>

                    <!------------------------------------------------ PAGE CONTENT ENDS ---------------------------------------------->



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
            </div>
        </div>
    </body>  
</html>
