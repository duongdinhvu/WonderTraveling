<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp"%>

/>

<!-- main-cont -->
<div class="main-cont">
    <div class="body-wrapper">
        <div class="wrapper-padding">
            <div class="page-head">
                <div class="page-title">Car - <span>booking</span></div>
                <div class="breadcrumbs">
                    <a href="#">Home</a> / <a href="userCarFirstController">Car</a> / <span>Booking</span>
                </div>
                <div class="clear"></div>
            </div>

            <div class="sp-page">
                <div class="sp-page-a">
                    <div class="sp-page-l">
                        <div class="sp-page-lb">
                            <div class="sp-page-p">
                                <div class="booking-left">
                                    <h2 class='passInfo'>Booking Information</h2>
                                    <form action="userCarBooking" method="post"  id="book-form" onsubmit="return valid();" >


                                        <input type="hidden" name="txtCarBookedID" value="${id.carID}" />
                                        <div class="booking-form">
                                            <div class="form-row" id="form_booking">



                                                <div>
                                                    <input style="width: 200px;height: 100" type="image" id="form-field-6" data-placement="bottom"  src="${id.carImage}" disabled="true" value="${id.carImage}" />
                                                </div>


                                                <div class="form-group col-md-3">
                                                    <label>Car Name</label>
                                                    <input type="text"  class="form-control" id="txtNumPeople" name="txtCName" readonly="true" value="${id.carName}"/>
                                                </div>    


                                                <div class="form-group col-md-3">
                                                    <label>Car Quantity</label>
                                                    <input type="number"  max="10" class="form-control" id="txtQuantity" name="txtQuantity" value="${quan}" readonly="true"/>
                                                </div>

                                                <div class="form-group col-md-3">
                                                    <label><strong>Car Receive Date</strong></label>    
                                                    <input type="text"  class="form-control" id="txtNumPeople" readonly="true" name="txtRecDate"  
                                                           value="<fmt:formatDate value="${requestScope.rec}" pattern="dd-MM-yyyy" />"> 
                                                </div> 


                                                <div class="form-group col-md-3">
                                                    <label><strong>Car Return Date</strong></label>     
                                                    <input type="text"  class="form-control" id="txtNumPeople" readonly="true" name="txtRetDate"  
                                                           value="<fmt:formatDate value="${requestScope.ret}" pattern="dd-MM-yyyy" />"> 
                                                </div>

                                                <div class="form-group col-md-3">
                                                    <label>Price per Day</label>
                                                    <input type="text"  class="form-control" id="txtNumPeople" name="txtNumPeople" readonly="true" value="$${id.carPrice}"/>
                                                </div>    
                                                
                                                <div class="form-group col-md-3">
                                                    <label>Promotion Code</label>
                                                    <input type="text" class="form-control" id="txtProID" name="txtProID" readonly="true" value="${pro}"/>
                                                </div>

                                                <div class="form-group col-md-3">
                                                    <label>Total Price($)</label>
                                                    <input type="text"  class="form-control" id="txtTotal" name="txtTotal" readonly="true" value="${price}"/>
                                                </div> 

                                                <div class="form-group col-md-3">
                                                    <label>Deposit($)</label>
                                                    <input type="text"  class="form-control" id="txtDep" name="txtDep" readonly="true" value="${dep}"/>
                                                </div> 

                                            </div>

                                            <input type="hidden" name="txtcarIDBook" id="txtcarIDBook" value="${id.carID}" >
                                            <input type="hidden" name="txtcarPriceBook" id="txtcarPriceBook" value="${id.carPrice}" >
                                            <input type="hidden" name="txtStt" id="txtcarPriceBook" value="1" >
                                            <input type="hidden" readonly="true"  style="width: 200px;" class="form-control" id="date-cre" name="txtCreDate" value=""> 

                                        </div>

                                        <div class="clear"></div>
                                        <div class="form-row" id="form_row"></div> 
                                        <div class="booking-devider no-margin"></div>
                                        <h2 class="passInfo">Payment Information</h2>

                                        <div class="clear"></div>

                                        <div>
                                            <input type="hidden" name="txtCusID" id="txtCusID" value="${Customeruser.customerID}" >

                                            <label><strong>Customer Name</strong></label>
                                            <input type="text" readonly="true"  style="width: 686px; text-align: center" class="form-control" name="txtBaby"  
                                                   value="${Customeruser.fullName}" > 
                                        </div>

                                        <div>&nbsp;</div>

                                        <div>
                                            <input type="hidden" name="txtCusPhone" id="txtCusID" value="${Customeruser.phone}" >

                                            <label><strong>Phone Numbers</strong></label>
                                            <input type="text" readonly="true"  style="width: 686px; text-align: center" class="form-control" name="txtBaby"  
                                                   value="${Customeruser.phone}" > 
                                        </div>                                                                      

                                        <div>&nbsp;</div>

                                        <div>
                                            <input type="hidden" name="txtCusID" id="txtCusID" value="${Customeruser.email}" >

                                            <label><strong>Email</strong></label>
                                            <input type="text" readonly="true"  style="width: 686px; text-align: center" class="form-control" name="txtBaby"  
                                                   value="${Customeruser.email}" > 
                                        </div>                                                                      

                                        <div>&nbsp;</div>

                                        <div>
                                            <label><strong> Payment Method </strong></label>

                                            <select name="txtPay" class="form-control" style="width: 686px; text-align: center;" onChange="checkOption(this)">
                                                <option value="2">Credit Card</option>
                                                <option value="1">Direct</option>                                               
                                            </select>                               
                                            <br/><br/>
                                        </div>

                                        <div>
                                            <label><strong> Credit Card Numbers: </strong></label>                                                

                                            <input  id="inputCre" style="width: 686px; text-align: center" type="text" name="txtCode" pattern="[0-9]{10,20}" required="true" placeholder="Credit Card Numbers"
                                                    oninvalid="this.setCustomValidity('Numbers only, extra 20 numbers !')" 
                                                    oninput="setCustomValidity('')" title="Credit Card Numbers"  />

                                            <br/><br/>
                                        </div>

                                        <div>&nbsp;</div>

                                        <button class="button button4" onclick="goBack()" style="border-radius: 12px;">Go Back</button>
                                        &nbsp;&nbsp;&nbsp;&nbsp;
                                        <button class="button button2" type="submit" name="action" value="bookComplete" style="border-radius: 12px;">
                                            COMPLETE BOOKING
                                        </button>
                                </div>





                                </form> <!-- END FORM--> 
                            </div>
                        </div>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
        </div>

        <div class="sp-page-r">

            <div class="checkout-coll">
                <div class="checkout-head">
                    <div class="checkout-headl">
                        <a href="#"><img alt="Wonder Travelling" src="${id.carImage}" ></a>
                    </div>
                    <div class="checkout-headr">
                        <div class="checkout-headrb">
                            <div class="checkout-headrp">
                                <div class="chk-left">
                                    <div class="chk-lbl"><a href="#">${id.carName}</a></div>
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

                </div>

                <div class="chk-details">

                </div>

            </div>

            <div class="h-help">
                <div class="h-help-lbl">Need Wonder Traveling Help?</div>
                <div class="h-help-lbl-a">We would be happy to help you!</div>
                <div class="h-help-phone">2-800-256-124 23</div>
                <div class="h-help-email">wonder_traveling@mail.com</div>
            </div>
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

<script src="js/bootstrap-datepicker.min.js"></script>
<script src="js/tour.js"></script>
<script src="js/car.js"></script>
<script src="js/rating.js"></script>

<script src="js/toggle_radio.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap.js"></script>


<script src="js/bootstrapValidator.min.js"></script>
<script src="js/bootstrapValidator.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/jquery.validate.js"></script>
<!--<script src="js/validate_form_booking.js"></script>-->

<script >
                                            function valid() {
                                                var x = confirm('Confirm Booking ?');
                                                if (x) {
                                                    alert("  Congratulations !\n\
                                                    \nBooking Successfully !");
                                                    return true;
                                                }
                                                else {
                                                    return false;
                                                }
                                            }

</script>

<script>
    function checkOption(obj) {
        var input = document.getElementById("inputCre");
        input.disabled = obj.value === "1";
    }
</script>

<script>
    function goBack() {
        window.history.back();
    }
</script>

<style>
    .button {
        background-color: #4CAF50; /* Green */
        border: none;
        color: white;
        padding: 16px 32px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        margin: 4px 2px;
        -webkit-transition-duration: 0.4s; /* Safari */
        transition-duration: 0.4s;
        cursor: pointer;
    }

    .button1 {
        background-color: white; 
        color: black; 
        border: 2px solid #4CAF50;
    }

    .button1:hover {
        background-color: #4CAF50;
        color: white;
    }

    .button2 {
        background-color: white; 
        color: black; 
        border: 2px solid #008CBA;
    }

    .button2:hover {
        background-color: #1e90ff;
        color: white;
    }

    .button3 {
        background-color: white; 
        color: black; 
        border: 2px solid #f44336;
    }

    .button3:hover {
        background-color: #f44336;
        color: white;
    }

    .button4 {
        background-color: white;
        color: black;
        border: 2px solid #e7e7e7;
    }

    .button4:hover {background-color: #e7e7e7;}

    .button5 {
        background-color: white;
        color: black;
        border: 2px solid #555555;
    }

    .button5:hover {
        background-color: #555555;
        color: white;
    }
</style>


<%@include  file="footer.jsp" %>