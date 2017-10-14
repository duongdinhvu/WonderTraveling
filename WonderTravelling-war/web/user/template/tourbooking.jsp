<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
`<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>

<!-- main-cont -->
<div class="main-cont">
    <div class="body-wrapper">
        <div class="wrapper-padding">
            <div class="page-head">
                <div class="page-title">Tours - <span>booking</span></div>
                <div class="breadcrumbs">
                    <a href="#">Home</a> / <a href="#">Tours</a> / <span>booking</span>
                </div>
                <div class="clear"></div>
            </div>

            <div class="sp-page">
                <div class="sp-page-a">
                    <div class="sp-page-l">
                        <div class="sp-page-lb">
                            <div class="sp-page-p">
                                <div class="booking-left">
                                    <h2 class='passInfo'>Tour Information</h2>
                                    <form action="CompleteBooking" method="post"  id="book-form" >
                                        <div class="booking-form">
                                            <div class="form-row" id="form_booking">

                                                <div class="form-group col-md-3">
                                                    <label>Number of People</label>
                                                    <input type="text" class="form-control" id="txtNumPeople" name="txtNumPeople" readonly="true" value="0"/>
                                                </div>
                                                <div class="form-group col-md-3">
                                                    <label>Adult</label>
                                                    <input type="text" class="form-control" id="txtAdult" name="txtAdult" value="0" />
                                                </div>
                                                <div class="form-group col-md-3">
                                                    <label>Kid</label>
                                                    <input type="text" class="form-control" id="txtKid" name="txtKid" value="0" />
                                                </div>
                                                <div class="form-group col-md-3">
                                                    <label>Baby</label>
                                                    <input type="text" class="form-control" id="txtBaby" name="txtBaby" value="0" />
                                                </div>
                                                <div class="form-group col-md-3">
                                                    <label>Type</label>
                                                    <div class="input-group">
                                                        <div id="radioBtn1" class="btn-group ">
                                                            <span class="btn btn-primary btn-sm active" data-toggle="dtGroup" name="group" data-value="personal" style="height: 35px">Personal</span>
                                                            <span class="btn btn-default btn-sm notActive" data-toggle="dtGroup" name="group" data-value="group" style="height: 35px">Group</span>
                                                        </div>
                                                        <input type="hidden" name="hdGroup" id="hdGroup" value="personal">
                                                    </div>
                                                </div>
                                                <c:if test="${sTour.transportation == 3}">
                                                    <div class="form-group col-md-3">
                                                        <label>Transportation</label>

                                                        <div class="input-group">
                                                            <div id="radioBtn2" class="btn-group ">
                                                                <span class="btn btn-primary btn-sm active" data-toggle="dtTransport" data-value="bus" style="height: 35px"><i class="fa fa-bus" aria-hidden="true" style="padding: 2px;"></i></span>
                                                                <span class="btn btn-default btn-sm notActive" data-toggle="dtTransport" data-value="air" style="height: 35px"><i class="fa fa-plane" aria-hidden="true" style="padding: 2px;"></i></span>
                                                            </div>
                                                            <input type="hidden" name="hdTransport" id="hdTransport" value="bus">
                                                        </div>

                                                    </div>
                                                </c:if>
                                                <c:if test="${sTour.transportation == 2}">
                                                    <div class="form-group col-md-3">
                                                        <label>Transportation</label>

                                                        <div class="input-group">
                                                            <div id="radioBtn2" class="btn-group ">
                                                                <span class="btn btn-primary btn-sm active" data-toggle="dtTransport" data-value="bus" style="height: 35px"><i class="fa fa-bus" aria-hidden="true" style="padding: 2px;"></i></span>
                                                           
                                                            </div>
                                                            <input type="hidden" name="hdTransport" id="hdTransport" value="bus">
                                                        </div>

                                                    </div>
                                                </c:if>
                                                 <c:if test="${sTour.transportation == 1}">
                                                    <div class="form-group col-md-3">
                                                        <label>Transportation</label>

                                                        <div class="input-group">
                                                            <div id="radioBtn2" class="btn-group ">
                                                                <span class="btn btn-primary btn-sm active" data-toggle="dtTransport" data-value="air" style="height: 35px"><i class="fa fa-plane" aria-hidden="true" style="padding: 2px;"></i></span>
                                                           
                                                            </div>
                                                            <input type="hidden" name="hdTransport" id="hdTransport" value="air">
                                                        </div>

                                                    </div>
                                                </c:if>
                                                <div class='form-group  col-md-6'>
                                                    <label>Individual Room (+$15/room)</label>
                                                    <input type='text' class='form-control' id="txtRoom" name="txtRoom" value="0" onkeypress='return isNumber(event, this);'/>
                                                </div>

                                            </div>
                                            <div class="clear"></div>
                                            <h2 class="passInfo">Tour Passenger Information</h2>

                                            <div class="form-row" id="form_row">

                                            </div> 

                                            <!-- Booking Form Row end -->
                                        </div>

                                        <!-- Booking form end -->


                                        <div class="booking-devider no-margin"></div>	



                                        <div class="clear"></div>

                                        <div>
                                            <input type="hidden" name="txtTourId" id="txtTourId" value="${sTour.tourID}"/>
                                        </div>
                                        <div>
                                            <input type="hidden" name="txtTotalPrice" id="txtTotalPrice" value="0"/>
                                        </div>
                                        <div id="error_tb">

                                        </div>
                                        <div class="booking-complete" id="booking-complete" style="pointer-events: none">	
                                            <button type="submit" class="booking-complete-btn" id="btnCompleteBooking" name="action" value="complete_booking">COMPLETE BOOKING</button>
                                        </div>


                                    </form>  <!-- END FORM--> 
                                </div>
                                <!-- Display Error -->

                            </div>
                        </div>
                        <div class="clear"></div>
                    </div>
                </div>

                <div class="sp-page-r">

                    <div class="checkout-coll">
                        <div class="checkout-head">
                            <div class="checkout-headl">
                                <a href="#"><img alt="Wonder Travelling" src="img/${sTour.image}"></a>
                            </div>
                            <div class="checkout-headr">
                                <div class="checkout-headrb">
                                    <div class="checkout-headrp">
                                        <div class="chk-left">
                                            <div class="chk-lbl"><a href="#">${sTour.tourTitle}</a></div>
                                            <div class="chk-lbl-a">${depature}</div>
                                            <nav class="chk-stars">
                                                <ul>
                                                    <li><img alt="" src="img/chk-star-b.png"></li>
                                                    <li><img alt="" src="img/chk-star-b.png"></li>
                                                    <li><img alt="" src="img/chk-star-b.png"></li>
                                                    <li><img alt="" src="img/chk-star-b.png"></li>
                                                    <li><img alt="" src="img/chk-star-a.png"></li>
                                                </ul>
                                                <div class="clear"></div>
                                            </nav>

                                        </div>
                                        <div class="chk-right">
                                            <a href="#"><img alt="" src="img/chk-edit.png"></a>
                                        </div>
                                        <div class="clear"></div>
                                    </div>
                                </div>
                                <div class="clear"></div>
                            </div>
                        </div>

                        <div class="chk-lines">
                            <!-- <div class="chk-line">
                                 <span class="chk-nights">${tour.duration}</span>
                                 <span class="chk-dates"></span>
                             </div>-->
                            <div class="chk-line">
                                Depature: <span class="chk-persons">${depature}</span>
                            </div>
                            <div class="chk-line">
                                Available Tickets: <span class="chk-persons">${aTickets} Tickets</span>
                            </div>
                            <form>
                                <input type="hidden" id="aTickets" name="aTickets" value="${aTickets}"/>
                            </form>
                        </div>

                        <div class="chk-details">
                            <h2>Details</h2>
                            <div class="chk-detais-row">
                                <div class="chk-line">
                                    <span class="chk-l">Transportation:</span>

                                    <span class="chk-r" id="chk-r-Trans">
                                        <c:if test="${sTour.transportation == 2}">Bus</c:if>
                                        <c:if test="${sTour.transportation == 1}">Air</c:if>
                                        <c:if test="${sTour.transportation == 3}">Bus</c:if>
                                    </span>
                                    <div class="clear"></div>

                                </div>
                                <div class="chk-line">
                                    <span class="chk-l">price:</span>
                                    <span class="chk-r" id="chk-r-price">0$</span>
                                    <div class="clear"></div>
                                </div>
                                <div class="chk-line">
                                    <span class="chk-l">Adult</span>
                                    <span class="chk-r" id="rAdult">0</span>
                                    <div class="clear"></div>
                                </div>
                                <div class="chk-line">
                                    <span class="chk-l">Kids</span>
                                    <span class="chk-r" id="rKid">0</span>
                                    <div class="clear"></div>
                                </div>
                                <div class="chk-line">
                                    <span class="chk-l">Babies</span>
                                    <span class="chk-r" id="rBaby">0</span>
                                    <div class="clear"></div>
                                </div>
                            </div>
                            <div class="chk-total">
                                <div class="chk-total-l">Total Price</div>
                                <div class="chk-total-r" id="total"><p>$0</p></div>
                                <div class="clear"></div>
                            </div>					
                        </div>

                    </div>

                    <div class="h-help">
                        <div class="h-help-lbl">Need Wonder Traveling Help?</div>
                        <div class="h-help-lbl-a">We would be happy to help you!</div>
                        <div class="h-help-phone">2-800-256-124 23</div>
                        <div class="h-help-email">wonder_traveling@mail.com</div>
                    </div>


                    <!--Modal -- >
            
            
            
                    <!--Modal -->
                </div>
                <div class="clear"></div>
            </div>

        </div>	
    </div>  
</div>
<!-- /main-cont -->

<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close"  data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Modal Header</h4>
            </div>
            <div class="modal-body">
                <p>This is a small modal.</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<!-- End Modal -->

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

<script src="js/bootstrap-datepicker.min.js"></script>
<script src="js/tour.js"></script>


<script src="js/toggle_radio.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap.js"></script>



<script src="js/tourbooking.js"></script>
<%@include  file="footer.jsp" %>