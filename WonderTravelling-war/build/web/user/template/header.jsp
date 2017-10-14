<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Wonder Travelling</title>
        <meta name="description" content="" />
        <meta name="keywords" content="" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<link rel="icon" href="favicon.png" />-->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" /> 
        <link rel="stylesheet" href="css/jquery-ui.css" />
        <link rel="stylesheet" href="css/owl.carousel.css" />
        <link rel="stylesheet" href="css/idangerous.swiper.css" />
        <link rel="stylesheet" href="css/style.css" />

        <link href='css/font.css' rel='stylesheet' type='text/css' />

        <link href='css/bootstrap.css' rel='stylesheet' />
        <link href='css/bootstrap.min.css' rel='stylesheet' />
        <link href='css/bootstrap-responsive.min.css' rel='stylesheet' />
        <link rel="stylesheet" href="css/jquery.formstyler.css">
        <link rel="stylesheet" href="css/rating.css">
        <link rel="stylesheet" href="css/font-awesome.css">
        <link rel="stylesheet" href="css/gender.css">
        <link rel="stylesheet" href="css/selectDate.css">
        <link rel="stylesheet" href="css/rating-star.css">


        <script type="text/javascript">
            function showfield(name) {
                if (name === '2')
                    document.getElementById('pay1').style.display = "block";
                else
                    document.getElementById('pay1').style.display = "none";
            }

            function hidefield() {
                document.getElementById('pay1').style.display = "none";
            }
        </script>


    </head>  
    <body onload="hidefield()" class="index-page"> 
        <!-- // authorize // -->
        <div class="overlay"></div>
        <div class="autorize-popup">
            <div class="autorize-tabs">
                <a href="#" class="autorize-tab-a current" >Login</a>
                <a href="#" class="autorize-tab-b">Sign up</a>
                <a href="#" class="autorize-close"></a>
                <div class="clear"></div>
            </div>
            <section class="autorize-tab-content">
                <div class="autorize-padding">
                    <form action="Login" method="post">
                        <input type="text" value="" name="username" placeholder="Username">
                        <input type="password" value="" name="password" placeholder="Password">
                        <div><font style="color:red">${ERROR}</font></div>
                        <footer class="autorize-bottom">
                            <button class="authorize-btn" id="btnLogin">Login</button>

                            <div class="clear"></div>
                        </footer>
                    </form>
                </div>
            </section>
            <section class="autorize-tab-content">
                <div class="autorize-padding">
                    <h6 class="autorize-lbl">Sign up</h6>
                    <input type="text" value="" placeholder="UserName">
                    <input type="text" value="" placeholder="FullName">

                    <footer class="autorize-bottom">
                        <button class="authorize-btn">Sign up</button>
                        <div class="clear"></div>
                    </footer>
                </div>
            </section>
        </div>
        <!-- \\ authorize \\-->
        <!-- \\ session for user \\-->
        <div>
            <form>
                <input type="hidden" name="txtUser" value="${sessionUser}" id="sessionUser"/>

            </form>
        </div>
        <header id="top">
            <div class="header-a">
                <div class="wrapper-padding">			
                    <div class="header-account">
                        <!-- <a href="#">Sign up</a> -->
                    </div>

                    <div class="header-account" id="header-account">
                        <c:if test="${empty sessionUser}"><a id="aLogin" href="#">Login</a></c:if>
                        <c:if test="${not empty sessionUser}"><a href="LoginController?action=logout">Logout</a></c:if>
                        </div>

                        <div class="header-account" id="header-account">
                            <a id="aLogin1" href="#">
                            <c:if test="${empty sessionUser}"> My Account</c:if>
                            <c:if test="${not empty sessionUser}"> ${sessionUser}</c:if>
                        </a>
                    </div>

                    <div class="header-social">
                        <a href="#" class="social-twitter"></a>
                        <a href="#" class="social-facebook"></a>
                        <a href="#" class="social-vimeo"></a>
                        <a href="#" class="social-pinterest"></a>
                        <a href="#" class="social-instagram"></a>
                    </div>
                    <div class="header-viewed">
                        <a href="#" class="header-viewed-btn">View</a>
                        <!-- // viewed drop // -->
                        <div class="viewed-drop">
                            <div class="viewed-drop-a">
                                <!-- // -->
                                <div class="viewed-item">
                                    <div class="viewed-item-l">
                                        <a href="#"><img alt="" src="img/v-item-01.jpg" /></a>
                                    </div>
                                    <div class="viewed-item-r">
                                        <div class="viewed-item-lbl"><a href="#">Andrassy Thai Hotel</a></div>
                                        <div class="viewed-item-cat">location: thailand</div>
                                        <div class="viewed-price">152$</div>
                                    </div>
                                    <div class="clear"></div>
                                </div>
                                <!-- \\ -->
                                <!-- // -->
                                <div class="viewed-item">
                                    <div class="viewed-item-l">
                                        <a href="#"><img alt="" src="img/v-item-02.jpg" /></a>
                                    </div>
                                    <div class="viewed-item-r">
                                        <div class="viewed-item-lbl"><a href="#">Ermin's Hotel</a></div>
                                        <div class="viewed-item-cat">location: dubai</div>
                                        <div class="viewed-price">300$</div>
                                    </div>
                                    <div class="clear"></div>
                                </div>
                                <!-- \\ -->
                                <!-- // -->
                                <div class="viewed-item">
                                    <div class="viewed-item-l">
                                        <a href="#"><img alt="" src="img/v-item-03.jpg" /></a>
                                    </div>
                                    <div class="viewed-item-r">
                                        <div class="viewed-item-lbl"><a href="#">Best Western Hotel Reither</a></div>
                                        <div class="viewed-item-cat">location: berlin</div>
                                        <div class="viewed-price">2300$</div>
                                    </div>
                                    <div class="clear"></div>
                                </div>
                                <!-- \\ -->
                            </div>
                        </div>
                        <!-- \\ viewed drop \\ -->
                    </div>

                    <div class="clear"></div>
                </div>
            </div>
            <div class="header-b">
                <!-- // mobile menu // -->
                <div class="mobile-menu">
                    <nav>
                        <ul>
                            <li><a class="has-child" href="index.jsp">Home</a>

                            </li>
                            <li><a class="has-child" href="#">Hotel</a>
                                <ul>
                                    <li><a href="hotel_list.html">Hotels standard list</a></li>
                                    <li><a href="hotel_simple_style.html">Hotels simple style</a></li>
                                    <li><a href="hotel_detail_style.html">Hotels detail style</a></li>
                                    <li><a href="hotel_detail.html">Hotel item page</a></li>
                                    <li><a href="hotel_booking.html">Hotel booking page</a></li>
                                    <li><a href="#">booking complete page</a></li>
                                </ul>
                            </li>						
                            <li>
                                <a  href="/tour/car.jsp">Car service</a>

                            </li>
                            <li>
                                <a href="tour/tour.jsp">Tour</a>

                            </li>						

                            <li><a class="has-child" href="tour/">Activities</a>
                                <ul>

                                    <li><a href="typography.html">typography</a></li>
                                    <li><a href="shortcodes.html">shortcodes</a></li>
                                    <li><a href="interactive_elements.html">interactive elements</a></li>
                                    <li><a href="cover_galleries.html">cover galleries</a></li>
                                    <li><a href="columns.html">columns</a></li>
                                </ul>
                            </li>						
                            <li><a id='aAmin' href="#">Contact</a></li>
                        </ul>
                    </nav>	
                </div>
                <!-- \\ mobile menu \\ -->

                <div class="wrapper-padding">
                    <div class="header-logo"><a href="index.html"><img alt="" src="img/logo.png" /></a></div>
                    <div class="header-right">
                        <div class="hdr-srch">
                            <a href="#" class="hdr-srch-btn"></a>
                        </div>
                        <div class="hdr-srch-overlay">
                            <div class="hdr-srch-overlay-a">
                                <input type="text" value="" placeholder="Start typing...">
                                <a href="#" class="srch-close"></a>
                                <div class="clear"></div>
                            </div>
                        </div>	
                        <div class="hdr-srch-devider"></div>
                        <a href="#" class="menu-btn"></a>
                        <nav class="header-nav">
                            <ul>
                                <li><a href="#">Home</a>

                                </li>
                                <li><a href="#">Hotel</a>
                                    <ul>
                                        <li><a href="hotel_list.html">Hotels standard list</a></li>
                                        <li><a href="hotel_simple_style.html">Hotels simple style</a></li>
                                        <li><a href="hotel_detail_style.html">Hotels detail style</a></li>
                                        <li><a href="hotel_detail.html">Hotel item page</a></li>
                                        <li><a href="hotel_booking.html">Hotel booking page</a></li>
                                        <li><a href="booking_complete.html">booking complete page</a></li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="userCarFirstController">Car service</a>

                                </li>
                                <li><a href="FirstController">Tour</a>

                                </li>

                                <li><a href="TourDetail">Activities</a>
                                    <ul>
                                        <li><a href="typography.html">typography</a></li>
                                        <li><a href="shortcodes.html">shortcodes</a></li>
                                        <li><a href="interactive_elements.html">interactive elements</a></li>
                                        <li><a href="cover_galleries.html">cover galleries</a></li>
                                        <li><a href="columns.html">columns</a></li>
                                    </ul>
                                </li>
                                <li><a id='aAdmin' href="#">Contact</a></li>
                            </ul>
                        </nav>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>	
        </header>
        <!-- Modal -->
        <!-- /Modal -->
        <!-- Modal -->
        <div class="modal" id="myModal1" role="dialog">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close"  data-dismiss="modal" id="xClose1">&times;</button>
                        <h4 class="modal-title ">Message</h4>
                    </div>
                    <div class="modal-body">
                        <p>You must be Login</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" id="btnOK1">OK</button>
                        <button type="button" class="btn btn-primary" data-dismiss="modal" id="btnClose1" >Close</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Modal -->

        <div class="modal" id="myModal2" role="dialog">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close"  data-dismiss="modal" id="xClose2">&times;</button>
                        <h4 class="modal-title">Login</h4>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="form-group">
                                <label>Username</label>
                                <input type="text" class="form-control" id="username"/>
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <input type="password" class="form-control" id="password" />
                            </div>

                        </form>
                        <div id="error"></div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" id="btnOK2">OK</button>
                        <button type="button" class="btn btn-primary" data-dismiss="modal" id="btnClose2" >Close</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Modal -->