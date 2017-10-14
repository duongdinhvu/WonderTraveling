<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>

<!-- main-cont -->


<!-- main-cont -->
<div class="main-cont">
    <div class="body-wrapper">
        <div class="wrapper-padding">
            <div class="page-head">
                <div class="page-title">Cars - <span>Booking Information</span></div>
                <div class="breadcrumbs">
                    <a href="#">Home</a> / <a href="userCarFirstController">Cars Service</a> / <span>Booking Complete</span>
                </div>
                <div class="clear"></div>
            </div>

            <div class="sp-page">


                <div class="sp-page-a">
                    <div class="sp-page-l">
                        <div class="sp-page-lb">
                            <div class="sp-page-p">
                                <div class="h-tabs">
                                    <div class="h-tabs-left">
                                        <div class="h-tab-i active">
                                            <a href="#" class="h-tab-item-01">
                                                <i></i>
                                                <span>photos</span>
                                                <span class="clear"></span>
                                            </a>
                                        </div>
                                        <div class="h-tab-i">
                                            <a href="#" class="h-tab-item-03">
                                                <i></i>
                                                <span>calendar</span>
                                                <span class="clear"></span>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="h-tabs-right">
                                        <a href="#">
                                            <i></i>
                                            <span>More Car</span>
                                            <div class="clear"></div>
                                        </a>
                                    </div>
                                    <div class="clear"></div>
                                </div>

                                <div class="mm-tabs-wrapper">
                                    <!-- // tab item // -->
                                    <div class="tab-item">
                                        <div class="tab-gallery-big">
                                            <img alt="Wonder Travelling" src="img/${image}">
                                        </div>                                                 

                                    </div>
                                    <!-- \\ tab item \\ -->	
                                    <!-- // tab item // -->

                                    <!-- \\ tab item \\ -->	

                                </div>

                                <!-- Test -->




                                <!-- Test -->



                                <div class="content-tabs">
                                    <div class="content-tabs-head last-item"> 

                                        <ul class="nav nav-tabs">
                                            <li><a href="#" class="tabs-lamp"></a></li>
                                        </ul>

                                    </div>


                                    <div class="clear"></div>
                                    <div class="content-tabs-body">
                                        <!-- // content-tabs-i Detail tour // -->
                                        <div class="content-tabs-i">
                                            <h1 style="color: orange">Booking Complete</h1>

                                            <div class="comlete-alert">
                                                <div class="comlete-alert-a">
                                                    <b>Thank You. Your Order is Confirmed.</b>
                                                    <span>Our Customer Service Will Contact You SOON !</span>
                                                    <h2 style="padding-left: 30px">Your Booking Status: <a style="color: grey"><strong>PENDING</strong></a></h2>
                                                </div>
                                            </div>

                                            <div class="complete-info">
                                                <h1 style="color: blue">Your Personal Information</h1>
                                                <div class="complete-info-table">
                                                    <div class="complete-info-i">
                                                        <div class="complete-info-l">Your Name:</div>
                                                        <div class="complete-info-r">${cusID.fullName}</div>
                                                        <div class="clear"></div>
                                                    </div>
                                                    <div class="complete-info-i">
                                                        <div class="complete-info-l">E-Mail Address:</div>
                                                        <div class="complete-info-r">${cusID.email}</div>
                                                        <div class="clear"></div>
                                                    </div>
                                                    <div class="complete-info-i">
                                                        <div class="complete-info-l">Phone Number:</div>
                                                        <div class="complete-info-r">${cusID.phone}</div>
                                                        <div class="clear"></div>
                                                    </div>
                                                </div>

                                                <div class="complete-devider"></div>

                                                <div class="complete-txt">
                                                    <h1 style="color: blue">Payment Info</h1>
                                                    <c:if test="${pay == 1}"><p>Pay When Receiving Car</p></c:if>
                                                    <c:if test="${pay == 2}"><p>Through Credit Card</p></c:if>

                                                    <c:if test="${code != 0}"><p><strong> Credit Card Numbers: </strong> ${code}</p></c:if>
                                                    <c:if test="${code == 0}"><p></p></c:if>
                                                    </div>

                                                    <div class="complete-devider"></div>

                                                    <div class="complete-txt final">
                                                        <h1 style="color: blue">Booking Details</h1>
                                                        <p>Car Receive Date (expected): <input type="text"  style="width: 200px;" class="form-control" readonly="true" name="txtRecDate"  
                                                       value="<fmt:formatDate value="${rei}" pattern="dd-MM-yyyy"  />"></p>
                                                    
                                                    <p>Car Return Date (expected): <input type="text"  style="width: 200px;" class="form-control" readonly="true" name="txtRecDate"  
                                                       value="<fmt:formatDate value="${ret}" pattern="dd-MM-yyyy"  />"></p>
                                                    
                                                    
                                                    
                                                    <p>Car Quantities&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: ${quantity}</p>
                                                    
                                                    <p>Total Price&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: ${price}$</p>
                                                                                                                                                       
                                                    <c:if test="${pro==null}"><p></p></c:if>
                                                    <c:if test="${pro!=null}"><p>Promotion Code&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: ${pro}</p></c:if>
                                                    
                                                    <p>Deposit (When receive car)&nbsp;: ${dep}$</p>
                                                    
                                                    <p>Price payed when return car&nbsp;: ${price - dep}$ </p>
                                                    
                                                    
                                                    
                                                        <p>&nbsp;</p>

                                                        <h4 style="padding-left: 30px"><strong>${id.carName}</strong></h4>
                                                    <p style="padding-left: 30px"><img src="${id.carImage}"</p>
                                                    <p style="padding-left: 30px"><img style="width: 20px; height: 20px;" alt="" src="img/icon-seats.png" /> ${id.carSeats} seats</p>
                                                    <p style="padding-left: 30px"><img style="width: 20px; height: 20px;" alt="" src="img/icon-doors.png" /> ${id.carDoors} doors</p>
                                                    <p style="padding-left: 30px"><strong><img style="width: 20px; height: 20px;" alt="" src="img/icon-transmission.png" /> Car Tranmission type: ${id.carTrasmission}</strong></p>

                                                    <c:if test="${id.carAirConditioning eq true}"><p style="padding-left: 30px"><img style="width: 20px; height: 20px;" alt="" src="img/icon-aircon.png" /> Air Conditioning: Yes</p></c:if>
                                                    <c:if test="${id.carAirConditioning eq false}"><p style="padding-left: 30px"><img style="width: 20px; height: 20px;" alt="" src="img/icon-aircon.png" /> Air Conditioning: No</p></c:if>

                                                    <c:if test="${id.carGPS eq true}"><p style="padding-left: 30px"><img style="width: 20px; height: 20px;" alt="" src="img/extra-gps.png" /> GPS: Yes</p></c:if>
                                                    <c:if test="${id.carGPS eq false}"><p style="padding-left: 30px"><img style="width: 20px; height: 20px;" alt="" src="img/extra-gps.png" /> GPS: No</p></c:if>

                                                    <c:if test="${id.carPushChair eq true}"><p style="padding-left: 30px"><img style="width: 20px; height: 20px;" alt="" src="img/icons-i-03.png" />  Extra Chair(s): Yes</p></c:if>
                                                    <c:if test="${id.carPushChair eq false}"><p style="padding-left: 30px"><img style="width: 20px; height: 20px;" alt="" src="img/icons-i-03.png" />  Extra Chair(s): No</p></c:if>




                                                    </div>

                                                </div>
                                                <div class="complete-txt-link"><a href="userCarFirstController">Back To Home</a></div>
                                                <div class="tab-reasons">
                                                    <h2>4 Reasons to Choose Wonder Travelling</h2>
                                                    <div class="tab-reasons-h">
                                                        <!-- // -->
                                                        <div class="tab-reasons-i reasons-01">
                                                            <b>fully responsive</b>
                                                            <p>Voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia.</p>
                                                        </div>
                                                        <!-- \\ -->
                                                        <!-- // -->
                                                        <div class="tab-reasons-i reasons-02">
                                                            <b>757 verified reviews</b>
                                                            <p>Voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia.</p>
                                                        </div>
                                                        <!-- \\ -->
                                                        <!-- // -->
                                                        <div class="tab-reasons-i reasons-03">
                                                            <b>Manage your bookings online</b>
                                                            <p>Voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia.</p>
                                                        </div>
                                                        <!-- \\ -->
                                                        <!-- // -->
                                                        <div class="tab-reasons-i reasons-04">
                                                            <b>Booking is safe</b>
                                                            <p>Voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia.</p>
                                                        </div>
                                                        <!-- \\ -->
                                                        <div class="clear"></div>
                                                    </div>

                                                </div>
                                            </div>
                                            <!-- \\ content-tabs-i Detail tour \\ -->
                                            <!-- // content-tabs-i  // -->
                                            <div class="content-tabs-i">
                                                <h2>Hotel Facilities</h2>
                                                <p>Voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui voluptatem sequi nesciunt. </p>
                                                <ul class="preferences-list">
                                                    <li class="internet">High-speed Internet</li>
                                                    <li class="conf-room">Conference room</li>
                                                    <li class="play-place">Play Place</li>
                                                    <li class="restourant">Restourant</li>
                                                    <li class="bar">Bar</li>
                                                    <li class="doorman">Doorman</li>
                                                    <li class="kitchen">Kitchen</li>
                                                    <li class="spa">Spa services</li>
                                                    <li class="bike">Bike Rental</li>
                                                    <li class="entertaiment">Entertaiment</li>
                                                    <li class="hot-tub">Hot Tub</li>
                                                    <li class="pool">Swimming Pool</li>
                                                    <li class="parking">Free parking</li>
                                                    <li class="gym">Gym</li>
                                                    <li class="tv">TV</li>
                                                    <li class="pets">Pets allowed</li>
                                                    <li class="handicap">Handicap</li>
                                                    <li class="secure">Secure </li>
                                                </ul>
                                                <div class="clear"></div>
                                                <div class="preferences-devider"></div>
                                                <h2>Alternative Style</h2>
                                                <p>Quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui voluptatem sequi nesciunt eque porro quisqua.</p>
                                                <ul class="preferences-list-alt">
                                                    <li class="internet">High-speed Internet</li>
                                                    <li class="parking">Free parking</li>
                                                    <li class="gym">Gym</li>
                                                    <li class="restourant">Restourant</li>
                                                    <li class="pets">Pets allowed</li>
                                                    <li class="pool">Swimming Pool</li>
                                                    <li class="kitchen">Kitchen</li>
                                                    <li class="conf-room">Conference room</li>
                                                    <li class="bike">Bike Rental</li>
                                                    <li class="entertaiment">Entertaiment</li>
                                                    <li class="bar">Bar</li>
                                                    <li class="secure">Secure</li>
                                                </ul>
                                                <div class="clear"></div>
                                            </div>
                                            <!-- \\ content-tabs-i \\ -->
                                            <!-- // content-tabs-i  Reviews// -->
                                            <div class="content-tabs-i">
                                                <div class="reviews-a">

                                                    <div class="reviews-c">
                                                        <div class="reviews-l">
                                                            <div class="reviews-total">4.7/5.0</div>
                                                            <nav class="reviews-total-stars">
                                                                <section class="container">
                                                                    <input type="radio" name="example" id="rating" class="rating" value="1" />
                                                                    <input type="radio" name="example" id="rating" class="rating" value="2" />
                                                                    <input type="radio" name="example" id="rating" class="rating" value="3" />
                                                                    <input type="radio" name="example" id="rating" class="rating" value="4" />
                                                                    <input type="radio" name="example" id="rating" class="rating" value="5" />
                                                                </section>
                                                                <div class="clear"></div>
                                                            </nav>
                                                        </div>
                                                        <div class="reviews-r">
                                                            <div class="reviews-rb">
                                                                <div class="reviews-percents">
                                                                    <label>4.7 out of 5 stars</label>
                                                                    <div class="reviews-percents-i"><span></span></div>
                                                                </div>
                                                                <div class="reviews-percents">
                                                                    <label>100% clients recommeted</label>
                                                                    <div class="reviews-percents-i"><span></span></div>
                                                                </div>
                                                            </div>
                                                            <br class="clear" />
                                                        </div>
                                                    </div>
                                                    <div class="clear"></div>

                                                    <div class="reviews-devider"></div>

                                                    <div class="hotel-reviews">
                                                        <h2>Hotel Facilities</h2>
                                                        <div class="hotel-reviews-row">
                                                            <!-- // -->
                                                            <div class="hotel-reviews-i">
                                                                <div class="hotel-reviews-left">Cleanlines</div>
                                                                <nav class="hotel-reviews-right">
                                                                    <ul>
                                                                        <li><a href="#"><img alt="" src="img/sstar-b.png"></a></li>
                                                                        <li><a href="#"><img alt="" src="img/sstar-b.png"></a></li>
                                                                        <li><a href="#"><img alt="" src="img/sstar-b.png"></a></li>
                                                                        <li><a href="#"><img alt="" src="img/sstar-b.png"></a></li>
                                                                        <li><a href="#"><img alt="" src="img/sstar-b.png"></a></li>
                                                                    </ul>
                                                                </nav>
                                                                <div class="clear"></div>
                                                            </div>
                                                            <!-- \\ -->
                                                            <!-- // -->
                                                            <div class="hotel-reviews-i">
                                                                <div class="hotel-reviews-left">Price</div>
                                                                <nav class="hotel-reviews-right">
                                                                    <ul>
                                                                        <li><a href="#"><img alt="" src="img/sstar-b.png"></a></li>
                                                                        <li><a href="#"><img alt="" src="img/sstar-b.png"></a></li>
                                                                        <li><a href="#"><img alt="" src="img/sstar-b.png"></a></li>
                                                                        <li><a href="#"><img alt="" src="img/sstar-a.png"></a></li>
                                                                        <li><a href="#"><img alt="" src="img/sstar-a.png"></a></li>
                                                                    </ul>
                                                                </nav>
                                                                <div class="clear"></div>
                                                            </div>
                                                            <!-- \\ -->
                                                            <!-- // -->
                                                            <div class="hotel-reviews-i">
                                                                <div class="hotel-reviews-left">Sleep Quality</div>
                                                                <nav class="hotel-reviews-right">
                                                                    <ul>
                                                                        <li><a href="#"><img alt="" src="img/sstar-b.png"></a></li>
                                                                        <li><a href="#"><img alt="" src="img/sstar-b.png"></a></li>
                                                                        <li><a href="#"><img alt="" src="img/sstar-a.png"></a></li>
                                                                        <li><a href="#"><img alt="" src="img/sstar-a.png"></a></li>
                                                                        <li><a href="#"><img alt="" src="img/sstar-a.png"></a></li>
                                                                    </ul>
                                                                </nav>
                                                                <div class="clear"></div>
                                                            </div>
                                                            <!-- \\ -->
                                                            <!-- // -->
                                                            <div class="hotel-reviews-i">
                                                                <div class="hotel-reviews-left">Service & Stuff</div>
                                                                <nav class="hotel-reviews-right">
                                                                    <ul>
                                                                        <li><a href="#"><img alt="" src="img/sstar-b.png"></a></li>
                                                                        <li><a href="#"><img alt="" src="img/sstar-b.png"></a></li>
                                                                        <li><a href="#"><img alt="" src="img/sstar-b.png"></a></li>
                                                                        <li><a href="#"><img alt="" src="img/sstar-b.png"></a></li>
                                                                        <li><a href="#"><img alt="" src="img/sstar-a.png"></a></li>
                                                                    </ul>
                                                                </nav>
                                                                <div class="clear"></div>
                                                            </div>
                                                            <!-- \\ -->
                                                            <!-- // -->
                                                            <div class="hotel-reviews-i">
                                                                <div class="hotel-reviews-left">Location</div>
                                                                <nav class="hotel-reviews-right">
                                                                    <ul>
                                                                        <li><a href="#"><img alt="" src="img/sstar-b.png"></a></li>
                                                                        <li><a href="#"><img alt="" src="img/sstar-b.png"></a></li>
                                                                        <li><a href="#"><img alt="" src="img/sstar-b.png"></a></li>
                                                                        <li><a href="#"><img alt="" src="img/sstar-b.png"></a></li>
                                                                        <li><a href="#"><img alt="" src="img/sstar-b.png"></a></li>
                                                                    </ul>
                                                                </nav>
                                                                <div class="clear"></div>
                                                            </div>
                                                            <!-- \\ -->
                                                            <!-- // -->
                                                            <div class="hotel-reviews-i">
                                                                <div class="hotel-reviews-left">Comfort</div>
                                                                <nav class="hotel-reviews-right">
                                                                    <ul>
                                                                        <li><a href="#"><img alt="" src="img/sstar-b.png"></a></li>
                                                                        <li><a href="#"><img alt="" src="img/sstar-b.png"></a></li>
                                                                        <li><a href="#"><img alt="" src="img/sstar-b.png"></a></li>
                                                                        <li><a href="#"><img alt="" src="img/sstar-a.png"></a></li>
                                                                        <li><a href="#"><img alt="" src="img/sstar-a.png"></a></li>
                                                                    </ul>
                                                                </nav>
                                                                <div class="clear"></div>
                                                            </div>
                                                            <!-- \\ -->
                                                        </div>
                                                        <div class="clear"></div>
                                                    </div>

                                                    <div class="hotel-reviews-devider"></div>

                                                    <div class="guest-reviews">
                                                        <h2>Guest Reviews</h2>
                                                        <div class="guest-reviews-row">
                                                            <!-- // -->
                                                            <div class="guest-reviews-i">
                                                                <div class="guest-reviews-a">
                                                                    <div class="guest-reviews-l">
                                                                        <div class="guest-reviews-img">
                                                                            <span>5.0</span>
                                                                            <img alt="" src="img/guest-01.png">
                                                                        </div>
                                                                    </div>
                                                                    <div class="guest-reviews-r">
                                                                        <div class="guest-reviews-rb">
                                                                            <div class="guest-reviews-b">
                                                                                <div class="guest-reviews-bl">
                                                                                    <div class="guest-reviews-blb">
                                                                                        <div class="guest-reviews-lbl">Gabriela King</div>
                                                                                        <div class="guest-reviews-lbl-a">from United Kingdom</div>
                                                                                        <div class="guest-reviews-txt">Voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui voluptatem sequi nesciunt.</div>
                                                                                    </div>
                                                                                    <br class="clear" />
                                                                                </div>
                                                                            </div>
                                                                            <div class="guest-reviews-br">  													
                                                                                <div class="guest-reviews-padding">
                                                                                    <nav>
                                                                                        <ul>
                                                                                            <li><img alt="" src="img/g-star-b.png"></li>
                                                                                            <li><img alt="" src="img/g-star-b.png"></li>
                                                                                            <li><img alt="" src="img/g-star-b.png"></li>
                                                                                            <li><img alt="" src="img/g-star-b.png"></li>
                                                                                            <li><img alt="" src="img/g-star-a.png"></li>
                                                                                        </ul>
                                                                                    </nav>
                                                                                    <div class="guest-rating">4,5/5.0</div>
                                                                                    <div class="clear"></div>
                                                                                    <div class="guest-rating-txt">Recomended</div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <br class="clear" />
                                                                    </div>
                                                                </div>
                                                                <div class="clear"></div>
                                                            </div>
                                                            <!-- \\ -->
                                                            <!-- // -->
                                                            <div class="guest-reviews-i">
                                                                <div class="guest-reviews-a">
                                                                    <div class="guest-reviews-l">
                                                                        <div class="guest-reviews-img">
                                                                            <span>5.0</span>
                                                                            <img alt="" src="img/guest-02.png">
                                                                        </div>
                                                                    </div>
                                                                    <div class="guest-reviews-r">
                                                                        <div class="guest-reviews-rb">
                                                                            <div class="guest-reviews-b">
                                                                                <div class="guest-reviews-bl">
                                                                                    <div class="guest-reviews-blb">
                                                                                        <div class="guest-reviews-lbl">Robert Dowson</div>
                                                                                        <div class="guest-reviews-lbl-a">from Austria</div>
                                                                                        <div class="guest-reviews-txt">Qoluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui voluptatem sequi nesciunt. </div>
                                                                                    </div>
                                                                                    <br class="clear" />
                                                                                </div>
                                                                            </div>
                                                                            <div class="guest-reviews-br">  													
                                                                                <div class="guest-reviews-padding">
                                                                                    <nav>
                                                                                        <ul>
                                                                                            <li><img alt="" src="img/g-star-b.png"></li>
                                                                                            <li><img alt="" src="img/g-star-b.png"></li>
                                                                                            <li><img alt="" src="img/g-star-b.png"></li>
                                                                                            <li><img alt="" src="img/g-star-b.png"></li>
                                                                                            <li><img alt="" src="img/g-star-a.png"></li>
                                                                                        </ul>
                                                                                    </nav>
                                                                                    <div class="guest-rating">4,5/5.0</div>
                                                                                    <div class="clear"></div>
                                                                                    <div class="guest-rating-txt">Recomended</div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <br class="clear" />
                                                                    </div>
                                                                </div>
                                                                <div class="clear"></div>
                                                            </div>
                                                            <!-- \\ -->
                                                            <!-- // -->
                                                            <div class="guest-reviews-i">
                                                                <div class="guest-reviews-a">
                                                                    <div class="guest-reviews-l">
                                                                        <div class="guest-reviews-img">
                                                                            <span>4.4</span>
                                                                            <img alt="" src="img/guest-03.png">
                                                                        </div>
                                                                    </div>
                                                                    <div class="guest-reviews-r">
                                                                        <div class="guest-reviews-rb">
                                                                            <div class="guest-reviews-b">
                                                                                <div class="guest-reviews-bl">
                                                                                    <div class="guest-reviews-blb">
                                                                                        <div class="guest-reviews-lbl">Mike Tyson</div>
                                                                                        <div class="guest-reviews-lbl-a">from France</div>
                                                                                        <div class="guest-reviews-txt">Voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores</div>
                                                                                    </div>
                                                                                    <br class="clear" />
                                                                                </div>
                                                                            </div>
                                                                            <div class="guest-reviews-br">  													
                                                                                <div class="guest-reviews-padding">
                                                                                    <nav>
                                                                                        <ul>
                                                                                            <li><img alt="" src="img/g-star-b.png"></li>
                                                                                            <li><img alt="" src="img/g-star-b.png"></li>
                                                                                            <li><img alt="" src="img/g-star-b.png"></li>
                                                                                            <li><img alt="" src="img/g-star-b.png"></li>
                                                                                            <li><img alt="" src="img/g-star-a.png"></li>
                                                                                        </ul>
                                                                                    </nav>
                                                                                    <div class="guest-rating">4,5/5.0</div>
                                                                                    <div class="clear"></div>
                                                                                    <div class="guest-rating-txt">Recomended</div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <br class="clear" />
                                                                    </div>
                                                                </div>
                                                                <div class="clear"></div>
                                                            </div>
                                                            <!-- \\ -->
                                                            <!-- // -->
                                                            <div class="guest-reviews-i">
                                                                <div class="guest-reviews-a">
                                                                    <div class="guest-reviews-l">
                                                                        <div class="guest-reviews-img">
                                                                            <span>5.0</span>
                                                                            <img alt="" src="img/guest-04.png">
                                                                        </div>
                                                                    </div>
                                                                    <div class="guest-reviews-r">
                                                                        <div class="guest-reviews-rb">
                                                                            <div class="guest-reviews-b">
                                                                                <div class="guest-reviews-bl">
                                                                                    <div class="guest-reviews-blb">
                                                                                        <div class="guest-reviews-lbl">Lina King</div>
                                                                                        <div class="guest-reviews-lbl-a">from United Kingdom</div>
                                                                                        <div class="guest-reviews-txt">Voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores</div>
                                                                                    </div>
                                                                                    <br class="clear" />
                                                                                </div>
                                                                            </div>
                                                                            <div class="guest-reviews-br">  													
                                                                                <div class="guest-reviews-padding">
                                                                                    <nav>
                                                                                        <ul>
                                                                                            <li><img alt="" src="img/g-star-b.png"></li>
                                                                                            <li><img alt="" src="img/g-star-b.png"></li>
                                                                                            <li><img alt="" src="img/g-star-b.png"></li>
                                                                                            <li><img alt="" src="img/g-star-b.png"></li>
                                                                                            <li><img alt="" src="img/g-star-a.png"></li>
                                                                                        </ul>


                                                                                    </nav>
                                                                                    <div class="guest-rating">4,5/5.0</div>
                                                                                    <div class="clear"></div>

                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <br class="clear" />
                                                                    </div>
                                                                </div>
                                                                <div class="clear"></div>
                                                            </div>
                                                            <!-- \\ -->
                                                        </div>


                                                        <div class="review-form">

                                                            <label>User Name(*)</label>

                                                            <div class="input-a">
                                                                <input type="text" id="rvUsername"  />
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="exTextarea">Your Reviews (*)</label>
                                                                <textarea class="form-control" id="exTextarea" rows="3" style="width: 430px;"></textarea>
                                                            </div>

                                                            <label>When did you travel?</label>
                                                            <div class="input-a">
                                                                <input type="text"  id="rvTour" />
                                                            </div>
                                                            <button class="review-send">Submit Review</button>
                                                        </div>              
                                                    </div>		
                                                </div>
                                            </div>
                                            <!-- \\ content-tabs-i  close tag Reviews Tab\\ -->
                                            <!-- // content-tabs-i // -->
                                            <div class="content-tabs-i">
                                                <h2>Things to do</h2>
                                                <p class="small">Voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui voluptatem sequi nesciunt. </p>
                                                <div class="todo-devider"></div>
                                                <div class="todo-row">
                                                    <!-- // -->
                                                    <div class="cat-list-item">
                                                        <div class="cat-list-item-l">
                                                            <a href="#"><img alt="" src="img/todo-01.jpg"></a>
                                                        </div>
                                                        <div class="cat-list-item-r">
                                                            <div class="cat-list-item-rb">
                                                                <div class="cat-list-item-p">
                                                                    <div class="cat-list-content">
                                                                        <div class="cat-list-content-a">
                                                                            <div class="cat-list-content-l">
                                                                                <div class="cat-list-content-lb">
                                                                                    <div class="cat-list-content-lpadding">
                                                                                        <div class="offer-slider-link"><a href="#">Totam rem aperiam, eaque ipsa quae</a></div>
                                                                                        <div class="offer-rate">Exelent</div>
                                                                                        <p>Voluptatem quia voluptas sit aspernatur aut odit  aut figut, sed quia consequuntur magni dolores eos qui  voluptatem sequi nescuint. Neque porro quisqua. Sed ut perspiciatis  unde omnis ste.</p>
                                                                                    </div>
                                                                                </div>
                                                                                <br class="clear">
                                                                            </div>
                                                                        </div>
                                                                        <div class="cat-list-content-r">
                                                                            <div class="cat-list-content-p">
                                                                                <nav class="stars">
                                                                                    <ul>
                                                                                        <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                                        <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                                        <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                                        <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                                        <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                                    </ul>
                                                                                    <div class="clear"></div>
                                                                                </nav>
                                                                                <div class="cat-list-review">31 reviews</div>
                                                                                <a href="#" class="todo-btn">Read more</a>  
                                                                            </div>
                                                                        </div>
                                                                        <div class="clear"></div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <br class="clear">
                                                        </div>
                                                        <div class="clear"></div>
                                                    </div>
                                                    <!-- \\ --> 
                                                    <!-- // -->
                                                    <div class="cat-list-item">
                                                        <div class="cat-list-item-l">
                                                            <a href="#"><img alt="" src="img/todo-02.jpg"></a>
                                                        </div>
                                                        <div class="cat-list-item-r">
                                                            <div class="cat-list-item-rb">
                                                                <div class="cat-list-item-p">
                                                                    <div class="cat-list-content">
                                                                        <div class="cat-list-content-a">
                                                                            <div class="cat-list-content-l">
                                                                                <div class="cat-list-content-lb">
                                                                                    <div class="cat-list-content-lpadding">
                                                                                        <div class="offer-slider-link"><a href="#">Invertore veitatis et quasi architecto</a></div>
                                                                                        <div class="offer-rate">Exelent</div>
                                                                                        <p>Voluptatem quia voluptas sit aspernatur aut odit  aut figut, sed quia consequuntur magni dolores eos qui  voluptatem sequi nescuint. Neque porro quisqua. Sed ut perspiciatis  unde omnis ste.</p>
                                                                                    </div>
                                                                                </div>
                                                                                <br class="clear">
                                                                            </div>
                                                                        </div>
                                                                        <div class="cat-list-content-r">
                                                                            <div class="cat-list-content-p">
                                                                                <nav class="stars">
                                                                                    <ul>
                                                                                        <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                                        <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                                        <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                                        <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                                        <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                                    </ul>
                                                                                    <div class="clear"></div>
                                                                                </nav>
                                                                                <div class="cat-list-review">31 reviews</div>
                                                                                <a href="#" class="todo-btn">Read more</a>  
                                                                            </div>
                                                                        </div>
                                                                        <div class="clear"></div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <br class="clear">
                                                        </div>
                                                        <div class="clear"></div>
                                                    </div>
                                                    <!-- \\ --> 
                                                    <!-- // -->
                                                    <div class="cat-list-item">
                                                        <div class="cat-list-item-l">
                                                            <a href="#"><img alt="" src="img/todo-03.jpg"></a>
                                                        </div>
                                                        <div class="cat-list-item-r">
                                                            <div class="cat-list-item-rb">
                                                                <div class="cat-list-item-p">
                                                                    <div class="cat-list-content">
                                                                        <div class="cat-list-content-a">
                                                                            <div class="cat-list-content-l">
                                                                                <div class="cat-list-content-lb">
                                                                                    <div class="cat-list-content-lpadding">
                                                                                        <div class="offer-slider-link"><a href="#">Dolores eos qui ratione voluptatem</a></div>
                                                                                        <div class="offer-rate">Exelent</div>
                                                                                        <p>Voluptatem quia voluptas sit aspernatur aut odit  aut figut, sed quia consequuntur magni dolores eos qui  voluptatem sequi nescuint. Neque porro quisqua. Sed ut perspiciatis  unde omnis ste.</p>
                                                                                    </div>
                                                                                </div>
                                                                                <br class="clear">
                                                                            </div>
                                                                        </div>
                                                                        <div class="cat-list-content-r">
                                                                            <div class="cat-list-content-p">
                                                                                <nav class="stars">
                                                                                    <ul>
                                                                                        <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                                        <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                                        <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                                        <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                                        <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                                    </ul>
                                                                                    <div class="clear"></div>
                                                                                </nav>
                                                                                <div class="cat-list-review">31 reviews</div>
                                                                                <a href="#" class="todo-btn">Read more</a>  
                                                                            </div>
                                                                        </div>
                                                                        <div class="clear"></div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <br class="clear">
                                                        </div>
                                                        <div class="clear"></div>
                                                    </div>
                                                    <!-- \\ -->     
                                                    <!-- // -->
                                                    <div class="cat-list-item">
                                                        <div class="cat-list-item-l">
                                                            <a href="#"><img alt="" src="img/todo-04.jpg"></a>
                                                        </div>
                                                        <div class="cat-list-item-r">
                                                            <div class="cat-list-item-rb">
                                                                <div class="cat-list-item-p">
                                                                    <div class="cat-list-content">
                                                                        <div class="cat-list-content-a">
                                                                            <div class="cat-list-content-l">
                                                                                <div class="cat-list-content-lb">
                                                                                    <div class="cat-list-content-lpadding">
                                                                                        <div class="offer-slider-link"><a href="#">Neque porro quisquaem est qui dolorem</a></div>
                                                                                        <div class="offer-rate">Exelent</div>
                                                                                        <p>Voluptatem quia voluptas sit aspernatur aut odit  aut figut, sed quia consequuntur magni dolores eos qui  voluptatem sequi nescuint. Neque porro quisqua. Sed ut perspiciatis  unde omnis ste.</p>
                                                                                    </div>
                                                                                </div>
                                                                                <br class="clear">
                                                                            </div>
                                                                        </div>
                                                                        <div class="cat-list-content-r">
                                                                            <div class="cat-list-content-p">
                                                                                <nav class="stars">
                                                                                    <ul>
                                                                                        <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                                        <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                                        <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                                        <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                                        <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                                    </ul>
                                                                                    <div class="clear"></div>
                                                                                </nav>
                                                                                <div class="cat-list-review">31 reviews</div>
                                                                                <a href="#" class="todo-btn">Read more</a>  
                                                                            </div>
                                                                        </div>
                                                                        <div class="clear"></div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <br class="clear">
                                                        </div>
                                                        <div class="clear"></div>
                                                    </div>
                                                    <!-- \\ -->                
                                                </div>
                                                <a href="#" class="guest-reviews-more">Load more reviews</a>
                                            </div>
                                            <!-- \\ content-tabs-i \\ -->
                                            <!-- // content-tabs-i // -->
                                            <div class="content-tabs-i">
                                                <h2>FAQ</h2>
                                                <p class="small">Voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui voluptatem sequi nesciunt. </p>
                                                <div class="todo-devider"></div>
                                                <div class="faq-row">
                                                    <!-- // -->
                                                    <div class="faq-item">
                                                        <div class="faq-item-a">
                                                            <span class="faq-item-left">Totam rem aperiam, eaquie ipsa quae?</span>
                                                            <span class="faq-item-i"></span>
                                                            <div class="clear"></div>
                                                        </div>
                                                        <div class="faq-item-b">
                                                            <div class="faq-item-p">
                                                                Voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia aspernatur aut odit aut fugit consequuntur magni dolores eos qui voluptatem sequi nesciunt. aspernatur aut odit aut fugit  
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- \\ -->
                                                    <!-- // -->
                                                    <div class="faq-item">
                                                        <div class="faq-item-a">
                                                            <span class="faq-item-left">Dolores eos qui ratione voluptatem sequi nescuin?</span>
                                                            <span class="faq-item-i"></span>
                                                            <div class="clear"></div>
                                                        </div>
                                                        <div class="faq-item-b">
                                                            <div class="faq-item-p">
                                                                Voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia aspernatur aut odit aut fugit consequuntur magni dolores eos qui voluptatem sequi nesciunt. aspernatur aut odit aut fugit  
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- \\ -->
                                                    <!-- // -->
                                                    <div class="faq-item">
                                                        <div class="faq-item-a">
                                                            <span class="faq-item-left">Neque porro quisquam est, qui dolorem ipsum?</span>
                                                            <span class="faq-item-i"></span>
                                                            <div class="clear"></div>
                                                        </div>
                                                        <div class="faq-item-b">
                                                            <div class="faq-item-p">
                                                                Voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia aspernatur aut odit aut fugit consequuntur magni dolores eos qui voluptatem sequi nesciunt. aspernatur aut odit aut fugit  
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- \\ -->
                                                    <!-- // -->
                                                    <div class="faq-item">
                                                        <div class="faq-item-a">
                                                            <span class="faq-item-left">Dolor sit amet consectutur adipisci velit, sed?</span>
                                                            <span class="faq-item-i"></span>
                                                            <div class="clear"></div>
                                                        </div>
                                                        <div class="faq-item-b">
                                                            <div class="faq-item-p">
                                                                Voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia aspernatur aut odit aut fugit consequuntur magni dolores eos qui voluptatem sequi nesciunt. aspernatur aut odit aut fugit  
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- \\ -->
                                                    <!-- // -->
                                                    <div class="faq-item">
                                                        <div class="faq-item-a">
                                                            <span class="faq-item-left">Consectetur, adipisci velit, sed quia non numquam?</span>
                                                            <span class="faq-item-i"></span>
                                                            <div class="clear"></div>
                                                        </div>
                                                        <div class="faq-item-b">
                                                            <div class="faq-item-p">
                                                                Voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia aspernatur aut odit aut fugit consequuntur magni dolores eos qui voluptatem sequi nesciunt. aspernatur aut odit aut fugit  
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- \\ -->
                                                </div>
                                            </div>
                                            <!-- \\ content-tabs-i \\ -->

                                        </div>
                                    </div>

                                    <div class="clear"></div>
                                </div>
                                <!-- \\ content-tabs-i \\ -->
                                <!-- // content-tabs-i // -->

                                <!-- \\ content-tabs-i \\ -->
                                <!-- // content-tabs-i // -->

                                <!-- \\ content-tabs-i \\ -->
                                <!-- // content-tabs-i // -->
                                <div class="content-tabs-i">
                                    <h2>Things to do</h2>
                                    <p class="small">Voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui voluptatem sequi nesciunt. </p>
                                    <div class="todo-devider"></div>
                                    <div class="todo-row">
                                        <!-- // -->
                                        <div class="cat-list-item">
                                            <div class="cat-list-item-l">
                                                <a href="#"><img alt="" src="img/todo-01.jpg"></a>
                                            </div>
                                            <div class="cat-list-item-r">
                                                <div class="cat-list-item-rb">
                                                    <div class="cat-list-item-p">
                                                        <div class="cat-list-content">
                                                            <div class="cat-list-content-a">
                                                                <div class="cat-list-content-l">
                                                                    <div class="cat-list-content-lb">
                                                                        <div class="cat-list-content-lpadding">
                                                                            <div class="offer-slider-link"><a href="#">Totam rem aperiam, eaque ipsa quae</a></div>
                                                                            <div class="offer-rate">Exelent</div>
                                                                            <p>Voluptatem quia voluptas sit aspernatur aut odit  aut figut, sed quia consequuntur magni dolores eos qui  voluptatem sequi nescuint. Neque porro quisqua. Sed ut perspiciatis  unde omnis ste.</p>
                                                                        </div>
                                                                    </div>
                                                                    <br class="clear">
                                                                </div>
                                                            </div>
                                                            <div class="cat-list-content-r">
                                                                <div class="cat-list-content-p">
                                                                    <nav class="stars">
                                                                        <ul>
                                                                            <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                            <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                            <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                            <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                            <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                        </ul>
                                                                        <div class="clear"></div>
                                                                    </nav>
                                                                    <div class="cat-list-review">31 reviews</div>
                                                                    <a href="#" class="todo-btn">Read more</a>  
                                                                </div>
                                                            </div>
                                                            <div class="clear"></div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <br class="clear">
                                            </div>
                                            <div class="clear"></div>
                                        </div>
                                        <!-- \\ --> 
                                        <!-- // -->
                                        <div class="cat-list-item">
                                            <div class="cat-list-item-l">
                                                <a href="#"><img alt="" src="img/todo-02.jpg"></a>
                                            </div>
                                            <div class="cat-list-item-r">
                                                <div class="cat-list-item-rb">
                                                    <div class="cat-list-item-p">
                                                        <div class="cat-list-content">
                                                            <div class="cat-list-content-a">
                                                                <div class="cat-list-content-l">
                                                                    <div class="cat-list-content-lb">
                                                                        <div class="cat-list-content-lpadding">
                                                                            <div class="offer-slider-link"><a href="#">Invertore veitatis et quasi architecto</a></div>
                                                                            <div class="offer-rate">Exelent</div>
                                                                            <p>Voluptatem quia voluptas sit aspernatur aut odit  aut figut, sed quia consequuntur magni dolores eos qui  voluptatem sequi nescuint. Neque porro quisqua. Sed ut perspiciatis  unde omnis ste.</p>
                                                                        </div>
                                                                    </div>
                                                                    <br class="clear">
                                                                </div>
                                                            </div>
                                                            <div class="cat-list-content-r">
                                                                <div class="cat-list-content-p">
                                                                    <nav class="stars">
                                                                        <ul>
                                                                            <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                            <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                            <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                            <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                            <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                        </ul>
                                                                        <div class="clear"></div>
                                                                    </nav>
                                                                    <div class="cat-list-review">31 reviews</div>
                                                                    <a href="#" class="todo-btn">Read more</a>  
                                                                </div>
                                                            </div>
                                                            <div class="clear"></div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <br class="clear">
                                            </div>
                                            <div class="clear"></div>
                                        </div>
                                        <!-- \\ --> 
                                        <!-- // -->
                                        <div class="cat-list-item">
                                            <div class="cat-list-item-l">
                                                <a href="#"><img alt="" src="img/todo-03.jpg"></a>
                                            </div>
                                            <div class="cat-list-item-r">
                                                <div class="cat-list-item-rb">
                                                    <div class="cat-list-item-p">
                                                        <div class="cat-list-content">
                                                            <div class="cat-list-content-a">
                                                                <div class="cat-list-content-l">
                                                                    <div class="cat-list-content-lb">
                                                                        <div class="cat-list-content-lpadding">
                                                                            <div class="offer-slider-link"><a href="#">Dolores eos qui ratione voluptatem</a></div>
                                                                            <div class="offer-rate">Exelent</div>
                                                                            <p>Voluptatem quia voluptas sit aspernatur aut odit  aut figut, sed quia consequuntur magni dolores eos qui  voluptatem sequi nescuint. Neque porro quisqua. Sed ut perspiciatis  unde omnis ste.</p>
                                                                        </div>
                                                                    </div>
                                                                    <br class="clear">
                                                                </div>
                                                            </div>
                                                            <div class="cat-list-content-r">
                                                                <div class="cat-list-content-p">
                                                                    <nav class="stars">
                                                                        <ul>
                                                                            <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                            <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                            <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                            <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                            <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                        </ul>
                                                                        <div class="clear"></div>
                                                                    </nav>
                                                                    <div class="cat-list-review">31 reviews</div>
                                                                    <a href="#" class="todo-btn">Read more</a>  
                                                                </div>
                                                            </div>
                                                            <div class="clear"></div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <br class="clear">
                                            </div>
                                            <div class="clear"></div>
                                        </div>
                                        <!-- \\ -->     
                                        <!-- // -->
                                        <div class="cat-list-item">
                                            <div class="cat-list-item-l">
                                                <a href="#"><img alt="" src="img/todo-04.jpg"></a>
                                            </div>
                                            <div class="cat-list-item-r">
                                                <div class="cat-list-item-rb">
                                                    <div class="cat-list-item-p">
                                                        <div class="cat-list-content">
                                                            <div class="cat-list-content-a">
                                                                <div class="cat-list-content-l">
                                                                    <div class="cat-list-content-lb">
                                                                        <div class="cat-list-content-lpadding">
                                                                            <div class="offer-slider-link"><a href="#">Neque porro quisquaem est qui dolorem</a></div>
                                                                            <div class="offer-rate">Exelent</div>
                                                                            <p>Voluptatem quia voluptas sit aspernatur aut odit  aut figut, sed quia consequuntur magni dolores eos qui  voluptatem sequi nescuint. Neque porro quisqua. Sed ut perspiciatis  unde omnis ste.</p>
                                                                        </div>
                                                                    </div>
                                                                    <br class="clear">
                                                                </div>
                                                            </div>
                                                            <div class="cat-list-content-r">
                                                                <div class="cat-list-content-p">
                                                                    <nav class="stars">
                                                                        <ul>
                                                                            <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                            <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                            <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                            <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                            <li><a href="#"><img alt="" src="img/todostar-a.png"></a></li>
                                                                        </ul>
                                                                        <div class="clear"></div>
                                                                    </nav>
                                                                    <div class="cat-list-review">31 reviews</div>
                                                                    <a href="#" class="todo-btn">Read more</a>  
                                                                </div>
                                                            </div>
                                                            <div class="clear"></div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <br class="clear">
                                            </div>
                                            <div class="clear"></div>
                                        </div>
                                        <!-- \\ -->                
                                    </div>
                                    <a href="#" class="guest-reviews-more">Load more reviews</a>
                                </div>
                                <!-- \\ content-tabs-i \\ -->
                                <!-- // content-tabs-i // -->
                                <div class="content-tabs-i">
                                    <h2>FAQ</h2>
                                    <p class="small">Voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui voluptatem sequi nesciunt. </p>
                                    <div class="todo-devider"></div>
                                    <div class="faq-row">
                                        <!-- // -->
                                        <div class="faq-item">
                                            <div class="faq-item-a">
                                                <span class="faq-item-left">Totam rem aperiam, eaquie ipsa quae?</span>
                                                <span class="faq-item-i"></span>
                                                <div class="clear"></div>
                                            </div>
                                            <div class="faq-item-b">
                                                <div class="faq-item-p">
                                                    Voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia aspernatur aut odit aut fugit consequuntur magni dolores eos qui voluptatem sequi nesciunt. aspernatur aut odit aut fugit  
                                                </div>
                                            </div>
                                        </div>
                                        <!-- \\ -->
                                        <!-- // -->
                                        <div class="faq-item">
                                            <div class="faq-item-a">
                                                <span class="faq-item-left">Dolores eos qui ratione voluptatem sequi nescuin?</span>
                                                <span class="faq-item-i"></span>
                                                <div class="clear"></div>
                                            </div>
                                            <div class="faq-item-b">
                                                <div class="faq-item-p">
                                                    Voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia aspernatur aut odit aut fugit consequuntur magni dolores eos qui voluptatem sequi nesciunt. aspernatur aut odit aut fugit  
                                                </div>
                                            </div>
                                        </div>
                                        <!-- \\ -->
                                        <!-- // -->
                                        <div class="faq-item">
                                            <div class="faq-item-a">
                                                <span class="faq-item-left">Neque porro quisquam est, qui dolorem ipsum?</span>
                                                <span class="faq-item-i"></span>
                                                <div class="clear"></div>
                                            </div>
                                            <div class="faq-item-b">
                                                <div class="faq-item-p">
                                                    Voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia aspernatur aut odit aut fugit consequuntur magni dolores eos qui voluptatem sequi nesciunt. aspernatur aut odit aut fugit  
                                                </div>
                                            </div>
                                        </div>
                                        <!-- \\ -->
                                        <!-- // -->
                                        <div class="faq-item">
                                            <div class="faq-item-a">
                                                <span class="faq-item-left">Dolor sit amet consectutur adipisci velit, sed?</span>
                                                <span class="faq-item-i"></span>
                                                <div class="clear"></div>
                                            </div>
                                            <div class="faq-item-b">
                                                <div class="faq-item-p">
                                                    Voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia aspernatur aut odit aut fugit consequuntur magni dolores eos qui voluptatem sequi nesciunt. aspernatur aut odit aut fugit  
                                                </div>
                                            </div>
                                        </div>
                                        <!-- \\ -->
                                        <!-- // -->
                                        <div class="faq-item">
                                            <div class="faq-item-a">
                                                <span class="faq-item-left">Consectetur, adipisci velit, sed quia non numquam?</span>
                                                <span class="faq-item-i"></span>
                                                <div class="clear"></div>
                                            </div>
                                            <div class="faq-item-b">
                                                <div class="faq-item-p">
                                                    Voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia aspernatur aut odit aut fugit consequuntur magni dolores eos qui voluptatem sequi nesciunt. aspernatur aut odit aut fugit  
                                                </div>
                                            </div>
                                        </div>
                                        <!-- \\ -->


                                        <!-- \\ content-tabs-i \\ -->

                                    </div>
                                </div>

                            </div>

                        </div>
                        <div class="clear"></div>
                    </div>
                </div>

                <div class="sp-page-r">

                    <div class="h-detail-r">






                    </div>

                    <div class="h-help">
                        <div class="h-help-lbl">Need Wonder Travelling Help?</div>
                        <div class="h-help-lbl-a">We would be happy to help you!</div>
                        <div class="h-help-phone">0962-502-799</div>
                        <div class="h-help-email">duongdinhvu1991@gmail.com</div>
                    </div>

                    <div class="reasons-rating">
                        <div id="reasons-slider">
                            <!-- // -->
                            <div class="reasons-rating-i">
                                <div class="reasons-rating-txt">Sed ut perspiciatis unde omnis iste natus sit voluptatem accusantium doloremque laudantium, totam.</div>
                                <div class="reasons-rating-user">
                                    <div class="reasons-rating-user-l">
                                        <img alt="" src="img/r-user.png">
                                        <span>5.0</span>
                                    </div>
                                    <div class="reasons-rating-user-r">
                                        <b>Gabriela King</b>
                                        <span>from United Kingdom</span>
                                    </div>
                                    <div class="clear"></div>
                                </div>
                            </div>
                            <!-- \\ -->
                            <!-- // -->
                            <div class="reasons-rating-i">
                                <div class="reasons-rating-txt">Sed ut perspiciatis unde omnis iste natus sit voluptatem accusantium doloremque laudantium, totam.</div>
                                <div class="reasons-rating-user">
                                    <div class="reasons-rating-user-l">
                                        <img alt="" src="img/r-user.png">
                                        <span>5.0</span>
                                    </div>
                                    <div class="reasons-rating-user-r">
                                        <b>Robert Dowson</b>
                                        <span>from Austria</span>
                                    </div>
                                    <div class="clear"></div>
                                </div>
                            </div>
                            <!-- \\ -->
                            <!-- // -->
                            <div class="reasons-rating-i">
                                <div class="reasons-rating-txt">Sed ut perspiciatis unde omnis iste natus sit voluptatem accusantium doloremque laudantium, totam.</div>
                                <div class="reasons-rating-user">
                                    <div class="reasons-rating-user-l">
                                        <img alt="" src="img/r-user.png">
                                        <span>5.0</span>
                                    </div>
                                    <div class="reasons-rating-user-r">
                                        <b>Mike Tyson</b>
                                        <span>from France</span>
                                    </div>
                                    <div class="clear"></div>
                                </div>
                            </div>
                            <!-- \\ -->
                        </div>
                    </div>

                    <div class="h-liked">
                        <div class="h-liked-lbl">You May Also Like</div>
                        <div class="h-liked-row">
                            <!-- // -->
                            <div class="h-liked-item">
                                <div class="h-liked-item-i">
                                    <div class="h-liked-item-l">
                                        <a href="#"><img alt="" src="img/like-01.jpg"></a>
                                    </div>
                                    <div class="h-liked-item-c">
                                        <div class="h-liked-item-cb">
                                            <div class="h-liked-item-p">
                                                <div class="h-liked-title"><a href="#">Andrassy Thai Hotel</a></div>
                                                <div class="h-liked-rating">
                                                    <nav class="stars">
                                                        <ul>
                                                            <li><a href="#"><img alt="" src="img/star-b.png" /></a></li>
                                                            <li><a href="#"><img alt="" src="img/star-b.png" /></a></li>
                                                            <li><a href="#"><img alt="" src="img/star-b.png" /></a></li>
                                                            <li><a href="#"><img alt="" src="img/star-b.png" /></a></li>
                                                            <li><a href="#"><img alt="" src="img/star-a.png" /></a></li>
                                                        </ul>
                                                        <div class="clear"></div>
                                                    </nav>
                                                </div>
                                                <div class="h-liked-foot">
                                                    <span class="h-liked-price">850$</span>
                                                    <span class="h-liked-comment">avg/night</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="clear"></div>
                                    </div>
                                </div>
                                <div class="clear"></div>	
                            </div>
                            <!-- \\ -->
                            <!-- // -->
                            <div class="h-liked-item">
                                <div class="h-liked-item-i">
                                    <div class="h-liked-item-l">
                                        <a href="#"><img alt="" src="img/like-02.jpg"></a>
                                    </div>
                                    <div class="h-liked-item-c">
                                        <div class="h-liked-item-cb">
                                            <div class="h-liked-item-p">
                                                <div class="h-liked-title"><a href="#">Campanile Cracovie</a></div>
                                                <div class="h-liked-rating">
                                                    <nav class="stars">
                                                        <ul>
                                                            <li><a href="#"><img alt="" src="img/star-b.png" /></a></li>
                                                            <li><a href="#"><img alt="" src="img/star-b.png" /></a></li>
                                                            <li><a href="#"><img alt="" src="img/star-b.png" /></a></li>
                                                            <li><a href="#"><img alt="" src="img/star-b.png" /></a></li>
                                                            <li><a href="#"><img alt="" src="img/star-a.png" /></a></li>
                                                        </ul>
                                                        <div class="clear"></div>
                                                    </nav>
                                                </div>
                                                <div class="h-liked-foot">
                                                    <span class="h-liked-price">964$</span>
                                                    <span class="h-liked-comment">avg/night</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="clear"></div>
                                    </div>
                                </div>
                                <div class="clear"></div>	
                            </div>
                            <!-- \\ -->
                            <!-- // -->
                            <div class="h-liked-item">
                                <div class="h-liked-item-i">
                                    <div class="h-liked-item-l">
                                        <a href="#"><img alt="" src="img/like-03.jpg"></a>
                                    </div>
                                    <div class="h-liked-item-c">
                                        <div class="h-liked-item-cb">
                                            <div class="h-liked-item-p">
                                                <div class="h-liked-title"><a href="#">Ermin's Hotel</a></div>
                                                <div class="h-liked-rating">
                                                    <nav class="stars">
                                                        <ul>
                                                            <li><a href="#"><img alt="" src="img/star-b.png" /></a></li>
                                                            <li><a href="#"><img alt="" src="img/star-b.png" /></a></li>
                                                            <li><a href="#"><img alt="" src="img/star-b.png" /></a></li>
                                                            <li><a href="#"><img alt="" src="img/star-b.png" /></a></li>
                                                            <li><a href="#"><img alt="" src="img/star-a.png" /></a></li>
                                                        </ul>
                                                        <div class="clear"></div>
                                                    </nav>
                                                </div>
                                                <div class="h-liked-foot">
                                                    <span class="h-liked-price">500$</span>
                                                    <span class="h-liked-comment">avg/night</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="clear"></div>
                                    </div>
                                </div>
                                <div class="clear"></div>	
                            </div>
                            <!-- \\ -->
                        </div>			
                    </div>

                    <div class="h-reasons">
                        <div class="h-liked-lbl">Reasons to Book with us</div>
                        <div class="h-reasons-row">
                            <!-- // -->
                            <div class="reasons-i">
                                <div class="reasons-h">
                                    <div class="reasons-l">
                                        <img alt="" src="img/reasons-a.png">
                                    </div>
                                    <div class="reasons-r">
                                        <div class="reasons-rb">
                                            <div class="reasons-p">
                                                <div class="reasons-i-lbl">Awesome design</div>
                                                <p>Voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequunt.</p>
                                            </div>
                                        </div>
                                        <br class="clear" />
                                    </div>
                                </div>
                                <div class="clear"></div>
                            </div>
                            <!-- \\ -->	
                            <!-- // -->
                            <div class="reasons-i">
                                <div class="reasons-h">
                                    <div class="reasons-l">
                                        <img alt="" src="img/reasons-b.png">
                                    </div>
                                    <div class="reasons-r">
                                        <div class="reasons-rb">
                                            <div class="reasons-p">
                                                <div class="reasons-i-lbl">carefylly handcrafted</div>
                                                <p>Voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequunt.</p>
                                            </div>
                                        </div>
                                        <br class="clear" />
                                    </div>
                                </div>
                                <div class="clear"></div>
                            </div>
                            <!-- \\ -->	
                            <!-- // -->
                            <div class="reasons-i">
                                <div class="reasons-h">
                                    <div class="reasons-l">
                                        <img alt="" src="img/reasons-c.png">
                                    </div>
                                    <div class="reasons-r">
                                        <div class="reasons-rb">
                                            <div class="reasons-p">
                                                <div class="reasons-i-lbl">sustomer support</div>
                                                <p>Voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequunt.</p>
                                            </div>
                                        </div>
                                        <br class="clear" />
                                    </div>
                                </div>
                                <div class="clear"></div>
                            </div>
                            <!-- \\ -->				
                        </div>
                    </div>


                </div>
                <div class="clear"></div>
            </div>

        </div>	
    </div>  
</div>
<!-- /main-cont -->

<script src="js/jquery-2.1.4.min.js"></script>
<script src="js/idangerous.swiper.js"></script>
<script src="js/slideInit.js"></script>
<script src="js/jqeury.appear.js"></script>  
<script src="js/owl.carousel.min.js"></script>
<script src="js/bxSlider.js"></script>
<script src="js/custom.select.js"></script> 
<script src="js/jquery-ui.min.js"></script>  
<script type="text/javascript" src="js/twitterfeed.js"></script>
<script src="js/script.js"></script>
<!-- \\ scripts \\ --> 
<script src="js/custom.select.js"></script> 
<script src="js/jquery-ui.min.js"></script>    
<script src="js/bootstrap-datepicker.min.js"></script>
<script src="js/tour.js"></script>
<script src="js/rating.js"></script>
<%@include  file="footer.jsp" %>
