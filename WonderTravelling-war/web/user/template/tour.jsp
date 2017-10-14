
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>


<!-- main-cont -->
<div class="main-cont">
    <div class="body-wrapper">
        <div class="wrapper-padding">
            <div class="page-head">
                <div class="page-title">Tour <span></span></div>
                <div class="breadcrumbs">
                    <a href="#">Home</a> / <a href="#">Tour</a> 
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
                                    <div class="srch-tab-left">
                                        <label>Depature</label>

                                        <div class="form-group">
                                            <select class="form-control"  name="depature" id="depature">
                                                
                                                <option >Ho Chi Minh City</option>
                                               <option>An Giang</option>
                                                <option>Vung Tau</option>
                                                <option>Bac Giang</option>
                                                <option>Bac Kan</option>
                                                <option>Bac Lieu</option>
                                                <option>Bac Ninh</option>
                                                <option>Ben Tre</option>
                                                <option>Binh Dinh</option>
                                                <option>Binh Duong</option>
                                                <option>Binh Phuoc</option>
                                                <option>Binh Thuan</option>
                                                <option>Can Tho</option>
                                                <option>Ca Mau</option>
                                                <option>Cao Bang</option>
                                                <option>Dak Lak</option>
                                                <option>Dak Nong</option>
                                                <option>Da Nang</option>
                                                <option>Dien Bien</option>
                                                <option>Dong Nai</option>
                                                <option>Dong Thap</option>
                                                <option>Gia Lai</option>
                                                <option>Ha Giang</option>
                                                <option>Ha Nam</option>
                                                <option>Ha Tinh</option>
                                                <option>Hai Phong</option>
                                                <option>Ha Noi</option>
                                                <option>Hai Duong</option>
                                                <option>Hau Giang</option>
                                                <option>Hoa Binh</option>
                                                <option>Hung Yen</option>
                                                <option>Khanh Hoa</option>
                                                <option>Kien Giang</option>
                                                <option>Phu Quoc</option>
                                                <option>Kon Tum</option>
                                                <option>Lai Chau</option>
                                                <option>Lam Dong</option>
                                                <option>Da Lat</option>
                                                <option>Lang Son</option>
                                                <option>Lao Cai</option>
                                                <option>Long An</option>
                                                <option>Nam Dinh</option>
                                                <option>Nghe An</option>
                                                <option>Ninh Binh</option>
                                                <option>Ninh Thuan</option>
                                                <option>Phu Tho</option>
                                                <option>Quang Binh</option>
                                                <option>Quang Nam</option>
                                                <option>Quang Ngai</option>
                                                <option>Quang Ninh</option>
                                                <option>Quang Tri</option>
                                                <option>Soc Trang</option>
                                                <option>Son La</option>
                                                
                                                <option>Tay Ninh</option>
                                                <option>Thai Binh</option>
                                                <option>Thai Nguyen</option>
                                                <option>Thanh Hoa</option>
                                                <option>Thua Thien Hue</option>
                                                <option>Tien Giang</option>
                                                <option>Tra Vinh</option>
                                                <option>Tuyen Quang</option>
                                                <option>Vinh Long</option>
                                                <option>Vinh Phuc</option>
                                                <option>Yen Bai</option>
                                                <option>Phu Yen</option>
                                                <option>Pleiku</option>
                                                <option>Buon Me</option>
                                                     
                                            </select>
                                        </div>
                                    </div>
                                    <div class="srch-tab-right">
                                        <label>Arrival</label>
                                        <div class="form-group">
                                            <select class="form-control" name="arrival" id="arrival">
                                                <c:forEach items="${tours}" var="tour">
                                                    <option>${tour.headingTo}</option>
                                                </c:forEach>
                                            </select>
                                        </div>	
                                    </div>
                                    <div class="clear"></div>
                                </div>
                                <!-- \\ -->

                                <!-- // -->
                                <div class="srch-tab-line">

                                    <label>Depature date</label>
                                    <div class="input-a"><input type="text" name="depatureDate"  id="date-inpt" > 
                                        <span class="date-icon"></span>
                                    </div>	

                                    <div class="clear"></div>
                                </div>
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
                    <div class="side-block fly-in">
                        <div class="side-stars">
                            <div class="side-padding">
                                <div class="side-lbl">Duration</div>  
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="" />
                                        2 - 4 Days
                                    </label>
                                </div> 
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="" />
                                        2-5 Days
                                    </label>
                                </div> 
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="" />
                                        6 - 9 Days
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="" />
                                        10+ Days
                                    </label>
                                </div>          
                            </div>
                        </div>  
                    </div>
                    <!-- \\ side \\ -->
                    <!-- // side // -->
                    <div class="side-block fly-in">
                        <div class="side-stars">
                            <div class="side-padding">
                                <div class="side-lbl">Transportation</div>  
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="" />
                                        Bus tour
                                    </label>
                                </div> 
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="" />
                                        Flight
                                    </label>
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

                            <!--  <div class="catalog-head fly-in">
                                 <label>Sort:</label>
 
                                 <div class="search-select">
                                     <select>
                                         <option>Price</option>
 
                                     </select>
                                 </div>
                                 <div class="search-select">
                                     <select>
                                         <option>Duration</option>
 
                                     </select>
                                 </div>
                                 <a href="#" class="show-list"></a>              
                                 <a class="show-thumbs chosen" href="#"></a> 
                                 <div class="clear"></div>
                             </div> // -->

                            <div class="catalog-row grid" id="result-search" >
                                <!-- // -->
                                <c:forEach items="${listTour}" var="tour">
                                    <div class="offer-slider-i catalog-i tour-grid fly-in" >
                                        <a href="#" class="offer-slider-img">
                                            <img alt="" src="img/${tour.image}">
                                            <span class="offer-slider-overlay">
                                                <span class="offer-slider-btn">View</span><span></span>
                                            </span>
                                        </a>
                                        <div class="offer-slider-txt">
                                            <div class="offer-slider-link"><a href="TourDetail?txtTourID=${tour.tourID}">${tour.tourTitle}</a></div>
                                            <div class="offer-slider-l">
                                                <div class="offer-slider-location">Duration / ${tour.duration} days</div>
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
                                            <div class="offer-slider-r">
                                                <b><fmt:formatNumber value="${tour.oddTourPrice}" type="number"></fmt:formatNumber></b>
                                                <span>USD</span>
                                            </div>
                                            <div class="offer-slider-devider"></div>								
                                            <div class="clear"></div>
                                        </div>
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
                                        <a href="PaginationController?txtCurrentPage=1">First</a>
                                        <a href="PaginationController?txtCurrentPage=${requestScope.CurrentPage - 1}">Previous</a>
                                    </c:if>
                                    <c:forEach begin="${requestScope.StartPage}" end="${requestScope.EndPage}"
                                               var="pages" step="1">
                                        <a href="PaginationController?txtCurrentPage=${pages}">${pages}</a> 
                                    </c:forEach>
                                    <c:if test="${requestScope.CurrentPage lt requestScope.TotalPage}">
                                        <a href="PaginationController?txtCurrentPage=${requestScope.CurrentPage + 1}">Next</a>
                                        <a href="PaginationController?txtCurrentPage=${requestScope.TotalPage}">Last</a>
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
<script src="js/tour.js"></script>
<script src="js/tourdetail.js"></script>

<!-- \\ scripts \\ -->
<%@include  file="footer.jsp" %>
