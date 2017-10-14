<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/user/template/header.jsp" %> 

<!-- main-cont -->
<div class="main-cont">
    <div class="body-wrapper">
        <div class="wrapper-padding">
            <div class="page-head">
                <div class="page-title">Tours - <span>simple style</span></div>
                <div class="breadcrumbs">
                    <a href="#">Home</a> / <a href="#">Tours</a> / <span>simple style</span>
                </div>
                <div class="clear"></div>
            </div>
            <div class="two-colls">
                <div class="two-colls-left">

                    <div class="srch-results-lbl fly-in">
                        <span>2,435 results found.</span>
                        <a href="/tour/newjsp.jsp">link</a>
                    </div> 

                    <div class="side-block fly-in">
                        <div class="side-block-search">
                            <div class="page-search-p">
                                <!-- // -->
                                <div class="srch-tab-line">
                                    <div class="srch-tab-left">
                                        <label>country</label>
                                        <div class="input-a"><input type="text" value="" placeholder="example: france"></div>	
                                    </div>
                                    <div class="srch-tab-right">
                                        <label>city</label>
                                        <div class="input-a"><input type="text" value="" placeholder="Vienna"></div>	
                                    </div>
                                    <div class="clear"></div>
                                </div>
                                <!-- \\ -->

                                <!-- // -->
                                <div class="srch-tab-line">
                                    <div class="srch-tab-left">
                                        <label>Departure</label>
                                        <div class="input-a"><input type="text" value="" class="date-inpt" placeholder="mm/dd/yy"> <span class="date-icon"></span></div>	
                                    </div>
                                    <div class="srch-tab-right">
                                        <label>Return</label>
                                        <div class="input-a"><input type="text" value="" class="date-inpt" placeholder="mm/dd/yy"> <span class="date-icon"></span></div>	
                                    </div>
                                    <div class="clear"></div>
                                </div>
                                <!-- \\ -->
                                <div class="srch-tab-line no-margin-bottom">
                                    <div class="srch-tab-left transformed">
                                        <label>Hotel stars</label>
                                        <div class="select-wrapper">
                                            <select class="custom-select">
                                                <option>--</option>
                                                <option>1</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                            </select>
                                        </div>	
                                    </div>
                                    <div class="srch-tab-right transformed">
                                        <label>peoples</label>
                                        <div class="select-wrapper">
                                            <select class="custom-select">
                                                <option>--</option>
                                                <option>1</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                            </select>
                                        </div>	
                                    </div>
                                    <div class="clear"></div>
                                </div>
                                <!-- \\ -->	

                                <button class="srch-btn">Search</button> 
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
                                <div class="side-lbl">Tour duration</div>  
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
                                <div class="side-lbl">Tour type</div>  
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="" />
                                        Bus tour
                                    </label>
                                </div> 
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="" />
                                        avia
                                    </label>
                                </div> 
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="" />
                                        Bus = avia
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
                                <div class="side-lbl">continent</div>  
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="" />
                                        Europe
                                    </label>
                                </div> 
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="" />
                                        asia
                                    </label>
                                </div> 
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="" />
                                        north america
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="" />
                                        south america
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="" />
                                        africa
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="" />
                                        australia
                                    </label>
                                </div>
                            </div>
                        </div>  
                    </div>
                    <!-- \\ side \\ -->


                </div>
                <div class="two-colls-right">
                    <div class="two-colls-right-b">
                        <div class="padding">

                            <div class="catalog-head fly-in">
                                <label>Sort results by:</label>
                                <div class="search-select">
                                    <select>
                                        <option>Name</option>
                                        <option>Name</option>
                                        <option>Name</option>
                                        <option>Name</option>
                                        <option>Name</option>
                                    </select>
                                </div>
                                <div class="search-select">
                                    <select>
                                        <option>Price</option>
                                        <option>Price</option>
                                        <option>Price</option>
                                        <option>Price</option>
                                        <option>Price</option>
                                    </select>
                                </div>
                                <div class="search-select">
                                    <select>
                                        <option>Duration</option>
                                        <option>Duration</option>
                                        <option>Duration</option>
                                        <option>Duration</option>
                                        <option>Duration</option>
                                    </select>
                                </div>
                                <a href="#" class="show-list"></a>              
                                <a class="show-thumbs chosen" href="#"></a> 
                                <div class="clear"></div>
                            </div>

                            <div class="catalog-row grid">
                                <!-- // -->
                                <div class="offer-slider-i catalog-i tour-grid fly-in">
                                    <a href="#" class="offer-slider-img">
                                        <img alt="" src="img/tour-01.jpg">
                                        <span class="offer-slider-overlay">
                                            <span class="offer-slider-btn">view details</span><span></span>
                                        </span>
                                    </a>
                                    <div class="offer-slider-txt">
                                        <div class="offer-slider-link"><a href="#">amazing france tour</a></div>
                                        <div class="offer-slider-l">
                                            <div class="offer-slider-location">Duration / 11 days</div>
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
                                            <b>2634$</b>
                                            <span>tour price</span>
                                        </div>
                                        <div class="offer-slider-devider"></div>								
                                        <div class="clear"></div>
                                    </div>
                                </div>
                                <!-- \\ -->	
                                <!-- // -->
                                <div class="offer-slider-i catalog-i tour-grid fly-in">
                                    <a href="#" class="offer-slider-img">
                                        <img alt="" src="img/tour-02.jpg">
                                        <span class="offer-slider-overlay">
                                            <span class="offer-slider-btn">view details</span><span></span>
                                        </span>
                                    </a>
                                    <div class="offer-slider-txt">
                                        <div class="offer-slider-link"><a href="#">Switzerland - France - Italy</a></div>
                                        <div class="offer-slider-l">
                                            <div class="offer-slider-location">Duration / 11 days</div>
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
                                            <b>2634$</b>
                                            <span>tour price</span>
                                        </div>
                                        <div class="offer-slider-devider"></div>								
                                        <div class="clear"></div>
                                    </div>
                                </div>
                                <!-- \\ -->
                                <!-- // -->
                                <div class="offer-slider-i catalog-i tour-grid fly-in">
                                    <a href="#" class="offer-slider-img">
                                        <img alt="" src="img/tour-03.jpg">
                                        <span class="offer-slider-overlay">
                                            <span class="offer-slider-btn">view details</span><span></span>
                                        </span>
                                    </a>
                                    <div class="offer-slider-txt">
                                        <div class="offer-slider-link"><a href="#">Tales of Old Europe</a></div>
                                        <div class="offer-slider-l">
                                            <div class="offer-slider-location">Duration / 11 days</div>
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
                                            <b>2634$</b>
                                            <span>tour price</span>
                                        </div>
                                        <div class="offer-slider-devider"></div>								
                                        <div class="clear"></div>
                                    </div>
                                </div>
                                <!-- \\ -->
                                <!-- // -->
                                <div class="offer-slider-i catalog-i tour-grid fly-in">
                                    <a href="#" class="offer-slider-img">
                                        <img alt="" src="img/tour-04.jpg">
                                        <span class="offer-slider-overlay">
                                            <span class="offer-slider-btn">view details</span><span></span>
                                        </span>
                                    </a>
                                    <div class="offer-slider-txt">
                                        <div class="offer-slider-link"><a href="#">Provence + Barcelona</a></div>
                                        <div class="offer-slider-l">
                                            <div class="offer-slider-location">Duration / 11 days</div>
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
                                            <b>2634$</b>
                                            <span>tour price</span>
                                        </div>
                                        <div class="offer-slider-devider"></div>								
                                        <div class="clear"></div>
                                    </div>
                                </div>
                                <!-- \\ -->
                                <!-- // -->
                                <div class="offer-slider-i catalog-i tour-grid fly-in">
                                    <a href="#" class="offer-slider-img">
                                        <img alt="" src="img/tour-05.jpg">
                                        <span class="offer-slider-overlay">
                                            <span class="offer-slider-btn">view details</span><span></span>
                                        </span>
                                    </a>
                                    <div class="offer-slider-txt">
                                        <div class="offer-slider-link"><a href="#">Switzerland and Italy Tour</a></div>
                                        <div class="offer-slider-l">
                                            <div class="offer-slider-location">Duration / 11 days</div>
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
                                            <b>2634$</b>
                                            <span>tour price</span>
                                        </div>
                                        <div class="offer-slider-devider"></div>								
                                        <div class="clear"></div>
                                    </div>
                                </div>
                                <!-- \\ -->	
                                <!-- // -->
                                <div class="offer-slider-i catalog-i tour-grid fly-in">
                                    <a href="#" class="offer-slider-img">
                                        <img alt="" src="img/tour-06.jpg">
                                        <span class="offer-slider-overlay">
                                            <span class="offer-slider-btn">view details</span><span></span>
                                        </span>
                                    </a>
                                    <div class="offer-slider-txt">
                                        <div class="offer-slider-link"><a href="#">treasures of Morocco tour</a></div>
                                        <div class="offer-slider-l">
                                            <div class="offer-slider-location">Duration / 11 days</div>
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
                                            <b>2634$</b>
                                            <span>tour price</span>
                                        </div>
                                        <div class="offer-slider-devider"></div>								
                                        <div class="clear"></div>
                                    </div>
                                </div>
                                <!-- \\ -->	
                                <!-- // -->
                                <div class="offer-slider-i catalog-i tour-grid fly-in">
                                    <a href="#" class="offer-slider-img">
                                        <img alt="" src="img/tour-07.jpg">
                                        <span class="offer-slider-overlay">
                                            <span class="offer-slider-btn">view details</span><span></span>
                                        </span>
                                    </a>
                                    <div class="offer-slider-txt">
                                        <div class="offer-slider-link"><a href="#">amazing france tour</a></div>
                                        <div class="offer-slider-l">
                                            <div class="offer-slider-location">Duration / 11 days</div>
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
                                            <b>2634$</b>
                                            <span>tour price</span>
                                        </div>
                                        <div class="offer-slider-devider"></div>								
                                        <div class="clear"></div>
                                    </div>
                                </div>
                                <!-- \\ -->	
                                <!-- // -->
                                <div class="offer-slider-i catalog-i tour-grid fly-in">
                                    <a href="#" class="offer-slider-img">
                                        <img alt="" src="img/tour-08.jpg">
                                        <span class="offer-slider-overlay">
                                            <span class="offer-slider-btn">view details</span><span></span>
                                        </span>
                                    </a>
                                    <div class="offer-slider-txt">
                                        <div class="offer-slider-link"><a href="#">madrid tour</a></div>
                                        <div class="offer-slider-l">
                                            <div class="offer-slider-location">Duration / 11 days</div>
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
                                            <b>2634$</b>
                                            <span>tour price</span>
                                        </div>
                                        <div class="offer-slider-devider"></div>								
                                        <div class="clear"></div>
                                    </div>
                                </div>
                                <!-- \\ -->
                                <!-- // -->
                                <div class="offer-slider-i catalog-i tour-grid fly-in">
                                    <a href="#" class="offer-slider-img">
                                        <img alt="" src="img/tour-09.jpg">
                                        <span class="offer-slider-overlay">
                                            <span class="offer-slider-btn">view details</span><span></span>
                                        </span>
                                    </a>
                                    <div class="offer-slider-txt">
                                        <div class="offer-slider-link"><a href="#">london tour</a></div>
                                        <div class="offer-slider-l">
                                            <div class="offer-slider-location">Duration / 11 days</div>
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
                                            <b>2634$</b>
                                            <span>tour price</span>
                                        </div>
                                        <div class="offer-slider-devider"></div>								
                                        <div class="clear"></div>
                                    </div>
                                </div>
                                <!-- \\ -->	
                                <!-- // -->
                               
                                <!-- \\ -->	
                                <!-- // -->
                              
                                <!-- \\ -->
                                <!-- // -->
                              
                                <!-- \\ -->		        
                            </div>

                            <div class="clear"></div>

                            <div class="pagination">
                                <a class="active" href="#">1</a>
                                <a href="#">2</a>
                                <a href="#">3</a>
                                <div class="clear"></div>
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
<%@include file="/user/template/footer.jsp" %>
