
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp"%>

<!-- main-cont -->
<div class="main-cont">
    <div class="body-wrapper">
        <div class="wrapper-padding">
            <div class="page-head">
                <div class="page-title">Tours - <span>booking complete</span></div>
                <div class="breadcrumbs">
                    <a href="#">Home</a> / <a href="#">Tour</a> / <span>tour booking</span>
                </div>
                <div class="clear"></div>
            </div>

            <div class="sp-page">
                <div class="sp-page-a">
                    <div class="sp-page-l">
                        <div class="sp-page-lb">
                            <div class="sp-page-p">
                                <div class="booking-left">
                                    <h2>Booking Complete</h2>

                                    <div class="comlete-alert">
                                        <div class="comlete-alert-a">
                                            <b>Thank You. Your Order is Confirmed.</b>
                                            <span>We will contact to you later </span>
                                        </div>
                                    </div>

                                    <div class="complete-info">
                                        <h2>Your Personal Information</h2>
                                        <div class="complete-info-table">
                                            <div class="complete-info-i">
                                                <div class="complete-info-l">Tour Booked ID</div>
                                                <div class="complete-info-r">${TourBookedId}</div>
                                                <div class="clear"></div>
                                            </div>
                                            <div class="complete-info-i">
                                                <div class="complete-info-l">Location</div>
                                                <div class="complete-info-r">${sTour.headingTo}</div>
                                                <div class="clear"></div>
                                            </div>
                                            <div class="complete-info-i">
                                                <div class="complete-info-l">Depature</div>
                                                <div class="complete-info-r">${depature}</div>
                                                <div class="clear"></div>
                                            </div>
                                            <div class="complete-info-i">
                                                <div class="complete-info-l">Duration</div>
                                                <div class="complete-info-r">${sTour.duration} days</div>
                                                <div class="clear"></div>
                                            </div>
                                            <div class="complete-info-i">
                                                <div class="complete-info-l">Full name:</div>
                                                <div class="complete-info-r">${Customeruser.fullName}</div>
                                                <div class="clear"></div>
                                            </div>

                                            <div class="complete-info-i">
                                                <div class="complete-info-l">E-Mail:</div>
                                                <div class="complete-info-r">${Customeruser.email}</div>
                                                <div class="clear"></div>
                                            </div>

                                            <div class="complete-info-i">
                                                <div class="complete-info-l">Phone Number:</div>
                                                <div class="complete-info-r">${Customeruser.phone}</div>
                                                <div class="clear"></div>
                                            </div>
                                        </div>

                                        <div class="complete-devider"></div>

                                        <div class="complete-txt">
                                            <h2>Passegers Infomation</h2>
                                            <table class="table table-bordered">
                                                <thead>
                                                    <tr>
                                                        <th>No</th>
                                                        <th>Full Name</th>
                                                        <th>Sex</th>
                                                        <th>Date Of Birth</th>

                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${ListPasseger}" var="pass" varStatus="no">
                                                        <tr>
                                                            <td>${no.count}</td>
                                                            <td>${pass.fullName}</td>
                                                            <td>
                                                                <c:if test="${pass.sex eq 'True'}">Male</c:if>
                                                                <c:if test="${pass.sex eq 'False'}">Female</c:if>
                                                                </td>
                                                                <td><fmt:formatDate value="${pass.dateOfBirth}" pattern="dd-MM-yyyy" /></td>
                                                        </tr>
                                                    </c:forEach>
                                                    <tr>
                                                        <td  colspan="3" style="text-align: center"><strong>Transportation</strong></td>
                                                        <td><strong>${Transportation}</strong></td>
                                                    </tr>
                                                    <tr>
                                                        <td  colspan="3" style="text-align: center"><strong>Individual Room(+15$)</strong></td>
                                                        <td><strong>${room}</strong></td>
                                                    </tr>
                                                    <tr>
                                                        <td  colspan="3" style="text-align: center"><strong>Price</strong></td>
                                                        <td><strong>${price}$</strong></td>
                                                    </tr>
                                                    <tr>
                                                        <td  colspan="3" style="text-align: center"><strong>Total</strong></td>
                                                        <td><strong>${TotalPrice}$</strong></td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                        <div class="printPDF">
                                            <form action="printPDF" method="get">
                                                <button id="printPDF" name="printPDF" ><i class="fa fa-print" aria-hidden="true"></i></button>
                                            </form>
                                        </div>
                                        <div class="complete-devider"></div>



                                    </div>

                                </div>
                            </div>
                        </div>
                        <div class="clear"></div>
                    </div>
                </div>

                <div class="sp-page-r">

                    <div class="h-help">
                        <div class="h-help-lbl">Need Sparrow Help?</div>
                        <div class="h-help-lbl-a">We would be happy to help you!</div>
                        <div class="h-help-phone">2-800-256-124 23</div>
                        <div class="h-help-email">sparrow@mail.com</div>
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
                                                <p>You can choose any design what you want.</p>
                                            </div>
                                        </div>
                                        <br class="clear">
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
                                                <div class="reasons-i-lbl">Carefully hand-crafted</div>
                                                <p>Nice hand-crafted.</p>
                                            </div>
                                        </div>
                                        <br class="clear">
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
                                                <div class="reasons-i-lbl">Customer support</div>
                                                <p>Contact 0962502799.</p>
                                            </div>
                                        </div>
                                        <br class="clear">
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

<%@include  file="footer.jsp" %>
