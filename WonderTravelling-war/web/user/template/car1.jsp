
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>


<!-- main-cont -->
<div class="main-cont">
    <div class="body-wrapper">
        <div class="wrapper-padding">
            <div class="page-head">
                <div class="page-title">Car Service <span></span></div>
                <div class="breadcrumbs">
                    <a href="#">Home</a> / <a href="userCarFirstController">Car</a> 
                </div>
                <div class="clear"></div>
            </div>
            <div class="two-colls">
                <div class="two-colls-left">

                    <div class="srch-results-lbl fly-in">
                        <span>Search</span>
                    </div> 

                    <div class="side-block fly-in">
                        <div class="side-block-search">
                            <div class="page-search-p">
                                <!-- // -->

                                <div class="srch-tab-line">
                                    <label>Number of Seats</label>
                                    <div class="srch-tab-left">
                                        <label>From</label>

                                        <div class="form-group">
                                            <select class="form-control"  name="seatFrom" id="seatFrom">
                                                <option value="2">2</option>
                                                <option value="4">4</option>
                                                <option value="7">7</option>
                                                <option value="12">12</option>
                                                <option value="15">15</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="srch-tab-right">
                                        <label>To</label>
                                        <div class="form-group">
                                            <select class="form-control" name="seatTo" id="seatTo">
                                                <option value="4">4</option>
                                                <option value="7">7</option>
                                                <option value="12">12</option>
                                                <option value="24">24</option>
                                                <option value="45">45</option>
                                            </select>
                                        </div>	
                                    </div>
                                    <div class="clear"></div>
                                </div>
                                <!-- \\ -->

                                <!-- \\ -->
                                <button type="submit" id="btnsearch" class="srch-btn" name="action">Search</button>

                            </div>  

                        </div>          
                    </div>

                    <!-- // side // -->
                    <div class="side-block fly-in">
                        <div class="side-price">
                            <div class="side-padding">
                                <div class="side-lbl">Price</div>
                                <div class="price-ranger">
                                    <div id="slider-range"></div>              
                                </div>
                                <div class="price-ammounts">
                                    <input type="text" id="ammount-from" readonly>
                                    <input type="text" id="ammount-to" readonly>
                                    <div class="clear"></div>
                                </div>    

                            </div>
                        </div>  
                    </div> 

                    <!-- \\ side \\ -->

                    
                    
                    <!-- // side // -->

                    <!-- \\ side \\ -->


                </div>
                <div class="two-colls-right">
                    <div class="two-colls-right-b">
                        <div class="padding">

                            <div class="catalog-row grid" id="result-search" >
                                <!-- // -->
                                <c:forEach items="${listCar}" var="car">
                                    <div class="cat-list-item fly-in">
                                        <div class="cat-list-item-l">
                                            <a href="#"><img alt="" src="${car.carImage}"></a>
                                        </div>
                                        <div class="cat-list-item-r">
                                            <div class="cat-list-item-rb">
                                                <div class="cat-list-item-p">
                                                    <div class="cat-list-content">
                                                        <div class="cat-list-content-a">
                                                            <div class="cat-list-content-l">
                                                                <div class="cat-list-content-lb">
                                                                    <div class="cat-list-content-lpadding">
                                                                        <div class="offer-slider-link"><strong><a href="userCarDetail?txtCarID=${car.carID}">${car.carName}</a></strong></div>
                                                                        <div class="offer-slider-location"><img style="width: 20px; height: 20px;" alt="" src="img/icon-seats.png" />    ${car.carSeats} seats </div>
                                                                        <div class="offer-slider-location"><img style="width: 20px; height: 20px;" alt="" src="img/icon-doors.png" />    ${car.carDoors} doors </div>
                                                                        <div class="offer-slider-location"><img style="width: 20px; height: 20px;" alt="" src="img/icon-transmission.png" />    ${car.carTrasmission}</div>
                                                                        <div class="offer-slider-location"><c:if test="${car.carGPS eq true}"><img style="width: 20px; height: 20px;" alt="" src="img/extra-gps.png" />    GPS</c:if></div>
                                                                        <div class="offer-slider-location"><c:if test="${car.carAirConditioning eq true}"><img style="width: 20px; height: 20px;" alt="" src="img/icon-aircon.png" />    Air Conditioning</c:if></div>
                                                                        <div class="offer-slider-location"><c:if test="${car.carPushChair eq true}"><img style="width: 20px; height: 20px;" alt="" src="img/icons-i-03.png" />    Push Chair</c:if></div>
                                                                            
                                                                        </div>
                                                                    </div>
                                                                    <br class="clear" />
                                                                </div>
                                                            </div>
                                                            <div class="cat-list-content-r">
                                                                <div class="cat-list-content-p">
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
                                                                    <div class="offer-slider-r">
                                                                        <b>${car.carPrice}$</b>
                                                                    <span>/day</span>
                                                                </div>           
                                                                <a href="userCarDetail?txtCarID=${car.carID}" class="cat-list-btn">View Detail</a>   
                                                            </div>
                                                        </div>
                                                        <div class="clear"></div>
                                                    </div>
                                                </div>
                                            </div>
                                            <br class="clear" />
                                        </div>
                                        <div class="clear"></div>
                                    </div>
                                </c:forEach>                                

                            </div>



                            <div class="clear"></div>



                            <!-- \\ -->	
                            <!-- // -->

                            <!-- \\ -->	
                            <!-- // -->

                            <!-- \\ -->		        


                            <div class="pagination">
                                <c:if test="${TotalPage > 1}">
                                    <c:if test="${requestScope.CurrentPage gt 1}">
                                        <a href="userCarPaginationController?txtCurrentPage=1">First</a>
                                        <a href="userCarPaginationController?txtCurrentPage=${requestScope.CurrentPage - 1}">Previous</a>
                                    </c:if>
                                    <c:forEach begin="${requestScope.StartPage}" end="${requestScope.EndPage}"
                                               var="pages" step="1">
                                        <a href="userCarPaginationController?txtCurrentPage=${pages}">${pages}</a> 
                                    </c:forEach>
                                    <c:if test="${requestScope.CurrentPage lt requestScope.TotalPage}">
                                        <a href="userCarPaginationController?txtCurrentPage=${requestScope.CurrentPage + 1}">Next</a>
                                        <a href="userCarPaginationController?txtCurrentPage=${requestScope.TotalPage}">Last</a>
                                    </c:if>
                                </c:if>
                            </div>            
                        </div>
                    </div>
                    <br class="clear" />
                </div>
            </div>
            <div class="clear"></div>

        </div>	
    </div>  
</div>
<!-- /main-cont -->
 
<!-- // scripts // -->
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
<script src="js/car.js"></script>
<script src="js/rating.js"></script>
<script src="js/cardetail.js"></script>

<!-- \\ scripts \\ -->
<%@include  file="footer.jsp" %>
