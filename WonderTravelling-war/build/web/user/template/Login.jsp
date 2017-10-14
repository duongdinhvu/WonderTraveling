
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta charset="utf-8" />
        <title>Login & Register Pages</title>

        <meta name="description" content="User login page" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

        <!-- bootstrap & fontawesome -->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css" />
        <link rel="stylesheet" href="assets/font-awesome/4.5.0/css/font-awesome.min.css" />

        <!-- text fonts -->
        <link rel="stylesheet" href="assets/css/fonts.googleapis.com.css" />

        <!-- ace styles -->
        <link rel="stylesheet" href="assets/css/ace.min.css" />

        <!--[if lte IE 9]>
                <link rel="stylesheet" href="assets/css/ace-part2.min.css" />
        <![endif]-->
        <link rel="stylesheet" href="assets/css/ace-rtl.min.css" />
       <!-- <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script> -->
        <script src="js/jquery.validate.min.js"></script>
        <script src='js/jquery.min.js'></script>
        <script src='js/bootstrapvalidator.min.js'></script>
        
        
        <!-- Login Form Validation -->
            <script type="text/javascript">          
                function submitFunction() {
                    
                    var username = document.forms["login_form"]["txtUsername"].value;
                     var password = document.forms["login_form"]["txtPassword"].value;
                     
                     if(username == null || username== ""){
                         alert("Username can't be blank");
                         return false;
                     }
                     if(password === null || password === ""){
                         alert("Password can't be blank");
                         return false;
                     }                   
                }
            </script>
        
         
      
    </head> 
    <body class="login-layout">
        <div class="main-container">
            <div class="main-content">
                <div class="row">
                    <div class="col-sm-10 col-sm-offset-1">
                        <div class="login-container">
                            <div class="center">
                        
                                <h1>
                                    <i class="ace-icon fa fa-leaf green"></i>
                                    <span class="red">Account Information</span>
                                </h1>
                            </div>

                            <div class="space-6"></div>

                            <div class="position-relative">
                                <div id="login-box" class="login-box visible widget-box no-border">
                                    <div class="widget-body">
                                        <div class="widget-main">
                                            <h4><p style="color: red"><%=request.getAttribute("error")!=null?request.getAttribute("error"):"" %></p></h4> 
                                            <h4><p style="color: red"><%=request.getAttribute("msgLogin")!=null?request.getAttribute("msgLogin"):"" %></p></h4> 
                                            <h4 class="header blue lighter bigger">
                                                <i class="ace-icon fa fa-coffee green"></i>
                                                <b>Your Login Information</b>
                                            </h4>

                                            <div class="space-6"></div>

                                            <form id="login_form"   action="LoginController" method="POST">
                                                <fieldset>
                                                    <label class="block clearfix">
                                                        <span class="block input-icon input-icon-right" id="username_error_message">
                                                            <input type="text" class="form-control" id="form_username" name="txtUsername" placeholder="Username" />
                                                            <i class="ace-icon fa fa-user"></i>
                                                        </span>
                                                    </label>

                                                    <label class="block clearfix">
                                                        <span class="block input-icon input-icon-right" id="password_error_message">
                                                            <input type="password" class="form-control" id="form_password"  name="txtPassword" placeholder="Password" />
                                                            <i class="ace-icon fa fa-lock"></i>
                                                        </span>
                                                    </label>

                                                    <div class="space"></div>
                                                    <div><font color="red">${ERROR}</font></div>
                                                    <div class="clearfix">
                          

                                                        <input type="submit" name="action" value="Login" class="width-35 pull-right btn btn-sm btn-primary">

                                                    </div>

                                                    <div class="space-4"></div>
                                                </fieldset>
                                            </form>

                                     

                    


                                        </div><!-- /.widget-main -->

                                        <div class="toolbar clearfix">
                                            <div>
                                                <a href="#" data-target="#signup-box" class="user-signup-link">
                                                    Register
                                                    <i class="ace-icon fa fa-arrow-right"></i>
                                                </a>
                                            </div>
                                        </div>
                                    </div><!-- /.widget-body -->
                                </div><!-- /.login-box -->

                                <div id="signup-box" class="signup-box widget-box no-border">
                                    <div class="widget-body">
                                        <div class="widget-main">
                                            <h4 class="header green lighter bigger">
                                                <b>Register</b>
                                            </h4>

                                            <div class="space-6"></div>
                                            <h4><b>Register Information</b></h4>

                                            <form action="RegisterController" method="POST" id="register_form" ">
                                                <fieldset>
                                                    <label class="block clearfix">
                                                        <div id="errorUsername"></div>
                                                        <span class="block input-icon input-icon-right">
                                                            <input type="text" class="form-control" name="txtUsernameReg" required="true" placeholder="Username" />
                                                            <i class="ace-icon fa fa-user"></i>
                                                        </span>
                                                    </label>


                                                    <label class="block clearfix">
                                                         <div id="errorPassword"></div>
                                                        <span class="block input-icon input-icon-right">
                                                            <input type="password" class="form-control" required="true" name="txtPasswordReg" placeholder="Password" />
                                                            <i class="ace-icon fa fa-lock"></i>
                                                        </span>
                                                    </label>

                                                    <label class="block clearfix">
                                                         <div id="errorRepeatPassword"></div>
                                                        <span class="block input-icon input-icon-right">
                                                            <input type="password" class="form-control" required="true" name="txtRepeatPassword" placeholder="Confirm password" />
                                                            <i class="ace-icon fa fa-retweet"></i>
                                                        </span>
                                                    </label>


                                                    <label class="block clearfix">
                                                         <div id="errorFullName"></div>
                                                        <span class="block input-icon input-icon-right">
                                                            <input type="text" class="form-control" required="true" name="txtFullName" placeholder="Full Name" />
                                                            <i class="ace-icon fa fa-user"></i>
                                                        </span>
                                                    </label>
                                                    
                                                       <label class="block clearfix">
                                                            <div id="errorPhone"></div>
                                                        <span class="block input-icon input-icon-right">
                                                            <input type="text" class="form-control" required="true" name="txtPhone" placeholder="Phone Number" />
                                                            <i class="ace-icon fa fa-user"></i>
                                                        </span>
                                                    </label>
                                                    <label class="block clearfix">
                                                         <div id="errorEmail"></div>
                                                        <span class="block input-icon input-icon-right">
                                                            <input type="email" class="form-control" required="true" name="txtEmail" placeholder="Email Address" />
                                                            <i class="ace-icon fa fa-envelope"></i>
                                                        </span>
                                                    </label>

                                                    <div class="clearfix">
                                                        <button type="reset" class="width-30 pull-left btn btn-sm">
                                                            <i class="ace-icon fa fa-refresh"></i>
                                                            <span class="bigger-110">Reset</span>
                                                        </button>

                                                        
                                                        <input name="action" type="submit" value="Register" class="width-65 pull-right btn btn-sm btn-success" >
                                                        </input>
                                                    </div>
                                                </fieldset>
                                            </form>
                                        </div>

                                        <div class="toolbar center">
                                            <a href="#" data-target="#login-box" class="back-to-login-link">
                                                <i class="ace-icon fa fa-arrow-left"></i>
                                                Login
                                            </a>
                                        </div>
                                    </div><!-- /.widget-body -->
                                </div><!-- /.signup-box -->
                            </div><!-- /.position-relative -->

                            <div class="navbar-fixed-top align-right">
                                <br />
                                &nbsp;
                                <a id="btn-login-dark" href="#">Dark</a>
                                &nbsp;
                                <span class="blue">/</span>
                                &nbsp;
                                <a id="btn-login-blur" href="#">Blue</a>
                                &nbsp;
                                <span class="blue">/</span>
                                &nbsp;
                                <a id="btn-login-light" href="#">Light</a>
                                &nbsp; &nbsp; &nbsp;
                            </div>
                        </div>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.main-content -->
        </div><!-- /.main-container -->

        <!-- basic scripts -->

        <!--[if !IE]> -->
      <!--  <script src="assets/js/jquery-3.2.1.js"></script>-->

        <!-- <![endif]-->

        <!--[if IE]>
<script src="assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
        <script type="text/javascript">
            if ('ontouchstart' in document.documentElement)
                document.write("<script src='assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
        </script>

        <!-- inline scripts related to this page -->
        <script type="text/javascript">
            jQuery(function($) {
                $(document).on('click', '.toolbar a[data-target]', function(e) {
                    e.preventDefault();
                    var target = $(this).data('target');
                    $('.widget-box.visible').removeClass('visible');//hide others
                    $(target).addClass('visible');//show target
                });
            });



            //you don't need this, just used for changing background
            jQuery(function($) {
                $('#btn-login-dark').on('click', function(e) {
                    $('body').attr('class', 'login-layout');
                    $('#id-text2').attr('class', 'white'); 
                    $('#id-company-text').attr('class', 'blue');

                    e.preventDefault();
                });
                $('#btn-login-light').on('click', function(e) {
                    $('body').attr('class', 'login-layout light-login');
                    $('#id-text2').attr('class', 'grey');
                    $('#id-company-text').attr('class', 'blue');

                    e.preventDefault();
                });
                $('#btn-login-blur').on('click', function(e) {
                    $('body').attr('class', 'login-layout blur-login');
                    $('#id-text2').attr('class', 'white');
                    $('#id-company-text').attr('class', 'light-blue');

                    e.preventDefault();
                });

            });
            
            
            
        </script>
        
       <!-- <script src ="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.js"></script>
          <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.min.js"></script> -->
        
    </body>
</html>
