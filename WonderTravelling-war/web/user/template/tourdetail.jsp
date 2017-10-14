<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>

<!-- main-cont -->


<!-- main-cont -->
<div class="main-cont">
    <div class="body-wrapper">
        <div class="wrapper-padding">
            <div class="page-head">
                <div class="page-title">Tours - <span>detail page</span></div>
                <div class="breadcrumbs">
                    <a href="#">Home</a> / <a href="#">Tours</a> / <span>detail page</span>
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
                                            <span>more tours</span>
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
                                            <li><a class="active" href="#" style="height: 41px;">Detail tour</a></li>
                                            <li><a href="#" style="height: 41px;">Preferences</a></li>
                                            <li><a href="#" style="height: 41px;">Reviews</a></li>
                                            <li><a href="#" style="height: 41px;">THINGS TO DO</a></li>
                                            <li><a href="#" class="tabs-lamp"></a></li>
                                        </ul>

                                    </div>


                                    <div class="clear"></div>
                                    <div class="content-tabs-body">
                                        <!-- // content-tabs-i Detail tour // -->
                                        <div class="content-tabs-i">
                                            <c:forEach items="${listSchedule}" var="schedule">
                                                <h4 style="padding-left: 30px"><strong>${schedule.summary}</strong></h4>
                                                <p style="padding-left: 30px"><img src="img/${schedule.image1}"</p>
                                                <p style="padding-left: 30px">
                                                    ${schedule.content}
                                                </p>
                                            </c:forEach>
                                            <div class="tab-reasons">
                                                <h2>4 Reasons to Choose Wonder Travelling</h2>
                                                <div class="tab-reasons-h">
                                                    <!-- // -->
                                                    <div class="tab-reasons-i reasons-01">
                                                        <b>Easy Book Tour</b>
                                                        <p>One Click, You can finf out where you want.</p>
                                                    </div>
                                                    <!-- \\ -->
                                                    <!-- // -->
                                                    <div class="tab-reasons-i reasons-02">
                                                        <b>All places its awesome</b>
                                                        <p>Wonder Traveling find all places where are good for you.</p>
                                                    </div>
                                                    <!-- \\ -->
                                                    <!-- // -->
                                                    <div class="tab-reasons-i reasons-03">
                                                        <b>Manage your bookings online</b>
                                                        <p>You can manage your tours visited online.</p>
                                                    </div>
                                                    <!-- \\ -->
                                                    <!-- // -->
                                                    <div class="tab-reasons-i reasons-04">
                                                        <b>Booking is safe</b>
                                                        <p>All your information is safe.</p>
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
                                                        <div class="reviews-total" id="resultRating">${rated}/5 in ${totalNumPeople} rating(s)</div>
                                                        <!--<div class="reviews-total1" >Total of Rating: <label id="totalNumPeople"></label></div>-->
                                                        <nav class="reviews-total-stars">

                                                            <form>
                                                                <span class="rating" >

                                                                    <input id="rating5" type="radio"  name="rating" value="5" <c:if test="${rated >4 && rated <= 5}">checked</c:if> onclick="control.rating(5)" >
                                                                        <label for="rating5">5</label>

                                                                        <input id="rating4" type="radio"  name="rating" value="4" <c:if test="${rated >3 && rated <= 4}">checked</c:if> onclick="control.rating(4)">
                                                                        <label for="rating4">4</label>

                                                                        <input id="rating3" type="radio"  name="rating" <c:if test="${rated >2 && rated <= 3}">checked</c:if> value="3" onclick="control.rating(3)">
                                                                        <label for="rating3">3</label>

                                                                        <input id="rating2" type="radio"  name="rating" <c:if test="${rated >1 && rated <= 2}">checked</c:if> value="2" onclick="control.rating(2)">
                                                                        <label for="rating2">2</label>

                                                                        <input id="rating1" type="radio"  name="rating" <c:if test="${rated >0 && rated <= 1}">checked</c:if> value="1" onclick="control.rating(1)">
                                                                        <label for="rating1">1</label>

                                                                    </span> 

                                                                    <input type="hidden" name="sTour" id="sTour" value="${sTour.tourID}"/>
                                                            </form>


                                                            <div class="clear"></div>
                                                        </nav>

                                                    </div>

                                                    <div class="reviews-r">

                                                        <div></div>
                                                        <!--
                                                        <div class="reviews-rb">
                                                            <div class="reviews-percents">
                                                                <label>4.7 out of 5 stars</label>
                                                                <div class="reviews-percents-i"><span></span></div>
                                                            </div>
                                                        <!-- <div class="reviews-percents">
                                                             <label>100% clients recommeted</label>
                                                             <div class="reviews-percents-i"><span></span></div>
                                                         </div>
                                                      
                                                    </div>-->

                                                        <br class="clear" />
                                                    </div> 

                                                </div>
                                                <div class="clear"></div>

                                                <div class="reviews-devider"></div>


                                                <div class="hotel-reviews-devider"></div>

                                                <div class="guest-reviews">
                                                    <h2>Comments</h2>
                                                    <div class="guest-reviews-row">
                                                        <!-- // -->

                                                        <!-- \\ -->
                                                        <!-- // -->
                                                        <div class="guest-reviews-i">
                                                            <c:forEach items="${list}" var="comment">
                                                                <div class="guest-reviews-a">
                                                                    <div class="guest-reviews-l">
                                                                        <div class="guest-reviews-img">

                                                                            
                                                                            <!-- <span>Robert Dowson</span> -->
                                                                             <img alt="" src="img/guest-02.png">
                                                                        </div> 
                                                                    </div>
                                                                    <div class="guest-reviews-r">
                                                                        <div class="guest-reviews-rb">
                                                                            <div class="guest-reviews-b">
                                                                                <div class="guest-reviews-bl">
                                                                                    <div class="guest-reviews-blb">
                                                                                        <div class="guest-reviews-lbl"></div>
                                                                                        <!--<div class="guest-reviews-lbl-a">from Austria</div> -->
                                                                                        <strong style="color:blue">${comment.customerID.customerUsername}</strong> &nbsp;
                                                                                        <fmt:formatDate value="${comment.createdDate}" pattern="dd-MM-yyyy"></fmt:formatDate>
                                                                                        <div class="guest-reviews-txt">${comment.content} </div>
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
                                                                                    <!-- <div class="guest-rating">4,5/5.0</div> -->
                                                                                    <div class="clear"></div>
                                                                                    <div class="guest-rating-txt">Recomended</div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <br class="clear" />
                                                                    </div>
                                                                </div>
                                                            </c:forEach>
                                                            <div class="clear"></div>
                                                        </div>
                                                        <!-- \\ -->
                                                        <!-- // -->

                                                        <!-- \\ -->
                                                        <!-- // -->



                                                        <div class="review-form">
                                                            <form action="CommentController" method="post">

                                                                <div class="form-group">
                                                                    <label for="exTextarea">Your Comments (*)</label>
                                                                    <textarea class="form-control" id="comment" name="txtComment" rows="3" style="width: 430px;"></textarea>
                                                                </div>
                                                                <div id="error_dt"></div>
                                                                <input type="hidden" value="" name="txtUser" id="user"/>
                                                                <input type="hidden" value="" name="txtTourId" id="tourId"/>
                                                                <input class="review-send" type="submit" name="action" value="Comment" id="btnComment"/>
                                                            </form>
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
                        <div class="h-detail-lbl">
                            <div class="h-detail-lbl-a">${sTour.tourTitle}</div>
                            <!--<div class="h-detail-lbl-b">11 nov 2015 - 22 nov 2015</div>-->
                            <label class="depatureday">Depature day:</label>
                            <div class="h-detail-lbl-b">

                                <div class="col-depature">

                                    <a class="btn btn-info btn-select btn-select-light">
                                        <input type="hidden" class="btn-select-input" id="" name="" value="" />

                                        <span class="btn-select-value">Choose depature</span>
                                        <span class='btn-select-arrow glyphicon glyphicon-chevron-down'></span>

                                        <ul>
                                            <c:forEach items="${strDepature}" var="depature">
                                                <li>${depature}</li>
                                                </c:forEach>
                                        </ul>

                                    </a>

                                </div>
                            </div>
                            <div class="clear"></div>
                        </div>
                        <div class="h-tour">
                            <div class="tour-item-icons">
                                <img alt="" src="img/tour-icon-01.png">
                                <span class="tour-item-plus"><img alt="" src="img/tour-icon.png"></span>
                                <img alt="" src="img/tour-icon-02.png">
                            </div>
                            <div class="tour-icon-txt">Air + bus</div>
                            <div class="tour-icon-person" id="available"> </div>

                            <div class="clear"></div>
                        </div>
                        <div class="h-detail-stars">
                            <ul class="h-stars-list">
                                <li><a href="#"><img alt="" src="img/hd-star-b.png"></a></li>
                                <li><a href="#"><img alt="" src="img/hd-star-b.png"></a></li>
                                <li><a href="#"><img alt="" src="img/hd-star-b.png"></a></li>
                                <li><a href="#"><img alt="" src="img/hd-star-b.png"></a></li>
                                <li><a href="#"><img alt="" src="img/hd-star-a.png"></a></li>
                            </ul>
                            <div class="h-stars-lbl">156 reviews</div>

                            <div class="clear"></div>
                        </div>
                        <!--  <div class="h-details-text">
                              <p>Voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui voluptatem sequi nesciunt. </p>
                              <p>Neque porro quisqua. Sed ut perspiciatis unde omnis ste natus error sit voluptatem.</p>
                          </div> -->
                        <!--  <a href="#" class="wishlist-btn">
                              <span class="wishlist-btn-l"><i></i></span>
                              <span class="wishlist-btn-r">ADD TO wish list</span>
                              <div class="clear"></div>
                          </a> -->
                        <a href="TourBooking" class="book-btn" style="pointer-events: none;"  >
                            <input type="hidden" value="${username}" name="sUsername" id="sUsername"/>
                            <input type="hidden" name="chkDepature" id="chkDepature"/>
                            <span class="book-btn-l"><i></i></span>
                            <span class="book-btn-r"  id="booknow">book now</span>
                            <div class="clear"></div>
                        </a>

                        <div>
                          

                        </div>
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
                                <div class="reasons-rating-txt"></div>
                                <div class="reasons-rating-user">
                                    <div class="reasons-rating-user-l">
                                        <img alt="" src="img/BuonMeThuot01_sidebar.jpg">
                                        <span>5.0</span>
                                    </div>
                                    <div class="reasons-rating-user-r">
                                        <b>Buon Ma Thuat</b>
                                        <span>Highlands</span>
                                    </div>
                                    <div class="clear"></div>
                                </div>
                            </div>
                            <!-- \\ -->
                            <!-- // -->
                            <div class="reasons-rating-i">
                                <div class="reasons-rating-txt"></div>
                                <div class="reasons-rating-user">
                                    <div class="reasons-rating-user-l">
                                        <img alt="" src="img/ConDao01_sidebar.jpg">
                                        <span>5.0</span>
                                    </div>
                                    <div class="reasons-rating-user-r">
                                        <b>Mekong Delta</b>
                                        <span>Mekong</span>
                                    </div>
                                    <div class="clear"></div>
                                </div>
                            </div>
                            <!-- \\ -->
                            <!-- // -->
                            <div class="reasons-rating-i">
                                <div class="reasons-rating-txt"></div>
                                <div class="reasons-rating-user">
                                    <div class="reasons-rating-user-l">
                                        <img alt="" src="img/LaoCai01_sidebar.jpg">
                                        <span>5.0</span>
                                    </div>
                                    <div class="reasons-rating-user-r">
                                        <b>North of Vietnam</b>
                                        <span>from Vietnam</span>
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
                                        <a href="#"><img alt="" src="img/Hotel01_sidebar.jpg"></a>
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
                                        <a href="#"><img alt="" src="img/Hotel02_sidebar.jpg"></a>
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
                                        <a href="#"><img alt="" src="img/Hotel03_sidebar.jpg"></a>
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
                                                <p>You can choose any design what you want.</p>
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
                                                <div class="reasons-i-lbl">Carefully hand-crafted</div>
                                                <p>Nice hand-crafted.</p>
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
                                                <div class="reasons-i-lbl">Customer support</div>
                                                <p>Contact 0962502799.</p>
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
  
<!-- Large modal -->



<!-- /main-cont -->





<script  src="js/jquery-2.1.4.min.js"></script>
<script src="js/jquery-ui.min.js"></script>  

<script src="js/custom.select.js"></script> 
<script src="js/script.js"></script>

<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap.js"></script> 


<script  src="js/selectDate.js"></script>
<script src="js/tour.js"></script>
<script src="js/tourdetail.js"></script>
<script  src="js/rating.js"></script>

<%@include  file="footer.jsp" %>
